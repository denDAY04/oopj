/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SerialCom.controller;

import SQLDatabase.Managers.*;
import SQLDatabase.ModelClasses.*;
import SerialCom.protocol.*;
import SerialCom.serial.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;
import javax.swing.*;
import java.sql.Timestamp;

/**
 * The
 * <code>EventManager</code> class is the central controller in the application.
 * It receives requests from the serial port, processes them and transmits the
 * response. The
 * <code>EventManager</code> is implemented using the State design pattern.
 *
 * @version 16/02/10
 * @author ibr
 */
public class EventManager implements FrameEventListener {

    private SerialTransceiver transmitter;
    private String portNumber;             // Windows port
    private String source = "34";
    private String destination = "12";
    private Packet packet;
    private CustomerManager customerManager;
    private TerminalManager terminalManager;
    private BillingManager billingManager;
    private Timer resendTimer = new Timer(300, new TimerListener());  // resend request timer. Set hardware dependent timeout here.
    private int maxSendAttempt = 4;
    private int currentSendAttempt = 0;
    private String currentStatus;
    private String currentData;
    private java.util.Date date;
    
    /* For data index values there exists a naming convention if the index 
    changes between different implementations (commands). It is as follows:
        XX_DATAY(..)YINDEX
    Where XX is the abbriviation of the command and Y(..)Y  is the data name.
    */
    private final int DATAPININDEX = 0;
    private final int DATAPINSIZE = 4; //number of bytes
    private final int CS_CC_DATACARDNUMBINDEX = 0;
    private final int VC_DATACARDNUMBINDEX = 4;
    private final int DATACARDNUMBSIZE = 8; //fx. 9bfa0ee8
    private final int DATAKWHRATEINDEX = 8;
    private final int DATAKWHRATESIZE = 6;
    private final int DATAKWHAMOUNTINDEX = 14;
    private final int DATAKWHAMOUNTSIZE = 6;
    private final int DATADKKAMOUNTINDEX = 20;
    private final int DATADKKAMOUNTSIZE = 6;
    private final int DATASTARTTIMEINDEX = 26;
    private final int DATASTARTTIMESIZE = 19;
    private final int DATAENDTIMEINDEX = 45;
    private final int DATAENDTIMESIZE = 19;

    /**
     * Default constructor which automatically detects port name.
     */
    public EventManager() {
        portNumber = PortDetection.getPorts().get(0);
    }

    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void setTerminalManager(TerminalManager terminalManager) {
        this.terminalManager = terminalManager;
    }
    
    public void setBillingManager(BillingManager billingManager) {
        this.billingManager = billingManager; 
    }

    /**
     * Get the value of source
     *
     * @return the value of source
     */
    public synchronized String getSource() {
        return source;
    }

    /**
     * Set the value of source
     *
     * @param source new value of source
     */
    public synchronized void setSource(String source) {
        System.err.print("EventManager setSource, was: " + this.source);

        this.source = source;
        System.err.println(" is now: " + source);
    }

    /**
     * Get the value of packet
     *
     * @return the value of packet
     */
    public synchronized Packet getPacket() {
        return packet;
    }

    /**
     * Get the value of destination
     *
     * @return the value of destination
     */
    public synchronized String getDestination() {
        return destination;
    }

    /**
     * Set the value of destination
     *
     * @param destination new value of destination
     */
    public synchronized void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Set the value of transmitter
     *
     * @param transmitter new value of transmitter
     */
    public synchronized void setTransmitter(SerialTransceiver transmitter) {
        this.transmitter = transmitter;
    }

    /**
     * Open the transmitter serial port.
     *
     * @throws TooManyListenersException
     */
    public synchronized void openPort() throws TooManyListenersException {
        if (transmitter != null) {
            transmitter.openPort(portNumber);
        }
    }

    /**
     * Close the transmitter serial port.
     */
    public synchronized void closePort() {
        if (transmitter != null) {
            transmitter.closePort();
        }
    }

    public String padAmount(double number) { // return a string with 6 digits, padded with zeros.
        System.err.println("EventManager padAmount, number:" + number);
        return String.format("%06d", Math.round(number)); // OBS needs to be changed depending on kr/ore implementation!!!!
    }

    /**
     * Send the
     * <code>RFIDResponse</code> as an
     * <code>ProjectPacket</code> using the serial transmitter.
     *
     * @param status The status response to send
     * @param data The specific data for the status response
     */
    public synchronized void sendResponse(String status, String data,
            String destination) {
        System.err.println("EventManager sendResponse");
        currentData = data;
        currentStatus = status;
        /* Send packet first time */
        ProjectPacket responsePacket = new ProjectPacket(source, destination,
                status, data);
        transmitter.transmit(responsePacket.getBytes());
        /* start timer to periodically transmit packet until recieved acknowledge */
        currentSendAttempt = 0;
        resendTimer.start(); // timer will be stopped when recieveing a correct reply package
    }

    /**
     * The method called by the
     * <code>SerialFrame</code> when a complete data packet is received.
     *
     * @param frameEvent the frame event
     */
    public synchronized void frameReady(FrameEvent frameEvent) {
        System.err.println("EventManager frameReady");
        byte[] received = frameEvent.getData();
        System.err.print("\nReceived at Server: [");
        System.err.println(new String(received) + "]");
        packet = new ProjectPacket(received);
        System.err.println("           command: [" + packet.getCommandStatus()
                + "]");
        System.err.println("           data:    [" + packet.getData() + "]");
        processRequest(packet);
    }

    private void processRequest(Packet packet) {
// list of possible commands, not final
//   - RS - resend
//   [done] - RA - receive acknowledged
//   [done] - VC - Verify Customer (pin and card number)
//   [done] - CS - Charging started ( set charger to charging and customer to locked)
//  [redundant due to VC] - CI - Customer information (customer found, status, name, amount …. )
//   [done] - CC - Charge completed (amount, rate ….)
//   [done] - PI - Ping 
//   [done] - PO - Pong 
        System.err.println("EventManeger source: " + source + " destination: "
                + destination);
        System.err.println("Packet source: " + packet.getSource()
                + " destination: " + packet.getDestination());

        if (packet.getDestination().equals("34")) {
            System.err.println("EventManager destination :" + destination
                    + " source: " + source);
            destination = "" + packet.getSource(); // reply to the sender
            //source = "34";           // send from this database
            System.err.println("EventManager re-mapped destination :"
                    + destination + " source: " + source);
            String command = packet.getCommandStatus();
            int checksum = packet.getChecksum(); // get the checksum from the revieced package
            packet.generateChecksum();           // generate the actual checksum
            int checksum2 = packet.getChecksum(); // get the new generated checksum fom the package
            if (checksum != checksum2) {
                System.err.println("Checksum failed! Found:" + checksum
                        + " Expected: " + checksum2);  // should send resend command
                if (!resendTimer.isRunning()) { // the message recieved was a new message, not a response, and a resend command must be sent. 
                    //Should check specifically for the new message commands instead, for increased stability.
                    sendResponse("RS", "VOID", destination);
                }
            } else {
                System.err.println("checksum ok:" + checksum
                        + ", Stopping resend timer");
                resendTimer.stop(); // stop resending timer, as an anwser has been recieved.


                //   - Verify Customer (pin and card number)
                if (command.equals("VC")) {
                    System.err.println("command = VC");
                    String pin = packet.getData().substring(DATAPININDEX,
                            DATAPININDEX + DATAPINSIZE);
                    System.err.println("Pin: " + pin);
                    String cardNumb = packet.getData().substring(
                            VC_DATACARDNUMBINDEX, VC_DATACARDNUMBINDEX
                            + DATACARDNUMBSIZE);
                    System.err.println("Cardnumber: " + cardNumb);
                    Customer customer = customerManager.verifyCustomer(cardNumb,
                            pin);
                    if (customer != null) {
                        //TODO get rate from database
                        System.err.println("customer found, sending response");
                        sendResponse("VC", padAmount(500) // rate simulation.
                                +padAmount(customer.getBalance())
                                + customer.getUseStatus() + customer.
                                getAccountStatus() + customer.getFirstName().substring(0, Math.min(customer.getFirstName().length(), 9)), //9 first letters of first name. Magic number, consider making variable. 
                                destination);
                    } else {
                        System.err.println("customer object is NULL");
                        System.err.println("no customer found");
                        sendResponse("VC", "NULL", destination);
                    }
                } // pong was sent back from terminal.
                else if (command.equals("PO")) {
                    System.err.println("command = PO");
                    terminalManager.connectionSuccessful(packet.getSource()); // should this call be made on all revieved packages?
                    System.err.println("Source was: " + packet.getSource());
//                } else if (command.equals("OP")) {
//                    System.err.println(
//                            "EventManager processRequest, OP revieced");
                } else if (command.equals("CS") || command.equals("CC")) {      // Charging started
                    sendResponse("RA", "Receive Acknowledged", destination);
                    resendTimer.stop();
                    System.err.println("EventManager processRequest: Charging started or completed");
                    String terminalID = packet.getSource();
                    // ^^Server knows the terminalID allready from the source of the package.^^
                    String cardNum = packet.getData().substring(CS_CC_DATACARDNUMBINDEX, CS_CC_DATACARDNUMBINDEX + DATACARDNUMBSIZE);
                    System.err.println("TerminalID: " + terminalID);
                    System.err.println("cardNum: " + cardNum);
                    
                    String[] newStatus = new String[1];

                    /* Validate the command for 'charging started', else the 
                    charging must be complete. If complete, log the billing in 
                    the database.
                    */
                    if (command.equals("CS")) {
                        newStatus[0] = "CHAR";
                        System.err.println("Process request: command is CS");
                    } else {                          
                        newStatus[0] = "IDLE";
                        System.err.println("Process request: command is NOT CS "+cardNum +" " + terminalID);
                        /* Extract the billing data from the packet and log it in the database. */
                        String[] dataArr = exstractBillingData(cardNum, terminalID);
                        System.err.println("Process request: before register billing method call");
                        billingManager.registerBilling(dataArr);

                    }
                    
                    /* Update customer's use status */
                    customerManager.updateCustomerInformation(cardNum, 1, newStatus);
                    /* Update charging station's charging status */
                    terminalManager.setTerminalChargingStatus(packet.getSource(), newStatus[0]);     

                } else if (command.equals("01")) {
                    System.err.println(
                            "EventManager processRequest, if 01 revieced, send 12-Accept");
                    sendResponse("12", "Accept", destination);
                } else if (command.equals("RA")) {
                    System.err.println(
                            "EventManager processRequest, RA recieved.");
                } else {
                    System.err.println(
                            "EventManager processRequest: Unproccessed command revieced: "
                            + command);
                }
            }
        }
    }

    public void pingEvent(String IpAddress) {
        date = new java.util.Date();
        sendResponse("PI", new Timestamp(date.getTime()).toString(), IpAddress); // or new Timestamp(System.currentTimeMillis());
        setDestination(IpAddress);
        System.err.
                println("EventManager TimerListener2, PI, PING, " + IpAddress);
    }

    class TimerListener implements ActionListener {  // Resend request Timelistener. Is stopped on verification of checksum.

        public void actionPerformed(ActionEvent e) {
            if (currentSendAttempt == maxSendAttempt) {
                System.err.println(
                        "EventManager TimeListener, maxSendAttempt reached");
                terminalManager.connectionFailed(destination);
                resendTimer.stop();
            } else {
                System.err.println("Resending packet");
                ProjectPacket responsePacket = new ProjectPacket(source,
                        destination, currentStatus, currentData);
                transmitter.transmit(responsePacket.getBytes());
                currentSendAttempt++;
            }
        }
    }
    
    /**
     * Extracts the data needed for registering a billing, to an array.
     * 
     * @param cardNum The card number of the use being billed.
     * @param terminalID The ID number of the terminal that was used.
     * 
     * @return An array of Strings containing the data in the correct sequence, 
     * as dictated by the SQL template in SQLLibrary.SYSTEM_LOG_NEW_BILLING.
     */
    private String[] exstractBillingData(String cardNum, String terminal) {
        /* Find a customer's ID and old balance through the transfered card number */
        Customer billedCustomer = customerManager.getCustomer(cardNum);
        Terminal usedTerminal = terminalManager.getTerminalByIP(terminal);
        String customerID = billedCustomer.getCustomerNumb();
        int oldBalance = billedCustomer.getBalance();

        /* Extract billing data from packet */
        String kWhRate = packet.getData().substring(DATAKWHRATEINDEX, DATAKWHRATEINDEX + DATAKWHRATESIZE);
        String kwHAmount = packet.getData().substring(DATAKWHAMOUNTINDEX, DATAKWHAMOUNTINDEX + DATAKWHAMOUNTSIZE);
        String DKKAmount = packet.getData().substring(DATADKKAMOUNTINDEX, DATADKKAMOUNTINDEX + DATADKKAMOUNTSIZE);
        String startTime = packet.getData().substring(DATASTARTTIMEINDEX, DATASTARTTIMEINDEX + DATASTARTTIMESIZE);
        String endTime = packet.getData().substring(DATAENDTIMEINDEX, DATAENDTIMEINDEX + DATAENDTIMESIZE);
        String terminalID = usedTerminal.getHardwareNumb();
        /* Calcualte new balance after billing */
        String newBalanceString = "" + (oldBalance - Integer.parseInt(DKKAmount));

        String[] arr = {customerID, terminalID, startTime, endTime, DKKAmount, kWhRate, kwHAmount, newBalanceString};
        //System.err.println("Event manager exstract billing data " +customerID+" "+ terminalID+" "+ startTime+" "+endTime+" "+DKKAmount+" "+kWhRate+" "+kwHAmount+" "+newBalanceString);
        return arr;
    }
}
