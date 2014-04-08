/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SerialCom.controller;

import SQLDatabase.Managers.*;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import SerialCom.protocol.*;
import SerialCom.serial.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 * The <code>EventManager</code> class is the central controller in the
 * application. It receives requests from the serial port, processes them and
 * transmits the response.
 * The <code>EventManager</code> is implemented using the State design pattern.
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
    private Timer timer=new Timer(100, new TimerListener());  // resend request timer. Set hardware dependent timeout here.
    private int maxSendAttempt = 4;
    private int currentSendAttempt = 0;
    private String currentStatus;
    private String currentData;
    private final int DATAPININDEX = 0;
    private final int DATAPINSIZE = 4; //number of bytes
    private final int DATACARDNUMBINDEX = 4;
    private final int DATACARDNUMBSIZE = 4; //needs to be changed to actual length of card number
    Timer timer2 =new Timer(5000, new TimerListener2());  // resend request timer. Set hardware dependent timeout here.
    static int i=0;

    /**
     * Default constructor which automatically detects port name.
     */
    public EventManager() {
        portNumber = PortDetection.getPorts().get(0);
        customerManager = new CustomerManager();
        terminalManager = new TerminalManager();
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
        this.source = source;
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
     * @param transmitter new value of transmitter
     */
    public synchronized void setTransmitter(SerialTransceiver transmitter) {
        this.transmitter = transmitter;
    }

    /**
     * Open the transmitter serial port.
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
    public String padAmount(double number){ // return a string with 6 digits, padded with zeros.
        System.err.println("padAmount number:"+number);
    return String.format("%06d", Math.round(number)); // OBS!!!!
    }

    /**
     * Send the <code>RFIDResponse</code> as an <code>ProjectPacket</code> using
     * the serial transmitter. 
     * @param status The status response to send
     * @param data The specific data for the status response
     */
    public synchronized void sendResponse(String status, String data,String destination) {
        System.err.println("EventManager sendResponse");
        currentData = data;
        currentStatus = status;
        /* Send packet first time */
        ProjectPacket responsePacket = new ProjectPacket(source, destination, status, data);
        transmitter.transmit(responsePacket.getBytes());
        /* start timer to periodically transmit packet until recieved acknowledge */
        currentSendAttempt=0;
        timer.start();
    }

    /**
     * The method called by the <code>SerialFrame</code> when a complete 
     * data packet is received.
     * @param frameEvent the frame event
     */
    public synchronized void frameReady(FrameEvent frameEvent) {
        System.err.println("EventManager frameReady");
        byte[] received  = frameEvent.getData();
        System.err.print("\nReceived at Server: [");
        System.err.println(new String(received) + "]");
        packet = new ProjectPacket(received);
        System.err.println("           command: [" + packet.getCommandStatus() + "]");
        System.err.println("           data:    [" + packet.getData() + "]");
        //TO DO Process request and send response
        processRequest(packet);
    }

    private void processRequest(Packet packet) {
        System.err.println("EventManager processRequest");
        //THIS CODE IS FOR SIMPLE DEMONSTRATION ONLY.
        //IT IS DIFFICULT TO MAINTAIN AND TEST.
        //IT SHOULD BE REPLACED BY EG. COMMAND PATTERN IN THE LATER DESIGN
        
//   - RS - resend
//   - RA - receive acknowledge
//   - VC - Verify Customer (pin and card number)
//   - CS - Charging started ( set charger to charging and customer to locked)
//   - CI - Customer information (customer found, status, name, amount …. )
//   - CC - Charge completed (amount, rate ….)
//   - PI - Ping 
//   - PO - Pong 
        
     
        String command = packet.getCommandStatus();
        int checksum = packet.getChecksum(); // get the checksum from the revieced package
        packet.generateChecksum();           // generate the actual checksum
        int checksum2 =  packet.getChecksum(); // get the new generated checksum fom the package
        if (checksum  != checksum2) {
            System.err.println("Checksum failed! Found:" +checksum + " Expected: " + checksum2);  // should send resend command
            if (!timer.isRunning()){ // the message recieved was a new message, not a response, and a resend command must be sent. 
                                     //Should check specifically for the new message commands instead, for increased stability.
                sendResponse("RS", "VOID",destination);
            }
        }
        else{
            System.err.println("checksum ok:" +checksum+ ", Stopping resend timer");
            timer.stop(); // stop resending timer, as an anwser has been recieved.
        

        //   - Verify Customer (pin and card number)
        if (command.equals("VC")) {  
            System.err.println("command = VC");
            String pin = packet.getData().substring(DATAPININDEX, DATAPININDEX+DATAPINSIZE);  
            System.err.println("Pin: " + pin);
            String cardNumb = packet.getData().substring(DATACARDNUMBINDEX, DATACARDNUMBINDEX+DATACARDNUMBSIZE);
            System.err.println("Cardnumber: " + cardNumb);
            Customer costumer = customerManager.verifyCustomer(cardNumb,pin);
            if (costumer != null) {
                System.err.println("customer found, sending response");
                sendResponse("VC", padAmount(costumer.getBalance())+costumer.getUseStatus()+costumer.getAccountStatus()+costumer.getFirstName(),destination);
            }
            else {System.err.println("customer object is NULL");
                System.err.println("no customer found");
                sendResponse("VC", "VOID",destination);      
            }
        }
        // pong was sent back from terminal.
        if (command.equals("PO")){
            System.err.println("command = PO");
            terminalManager.connectionSuccessful(packet.getSource()); // should this call be made on all revieved packages?
        }
            
         
            
//            sendResponse("RA", "Accept");
//            ArrayList<Terminal> terminalList;
//            
//
//            System.err.println("---");
//            System.err.println("Modify terminal:");
//            int row;
//            ArrayList<String> parameters = new ArrayList();
//            parameters.add("seethis");        // status
//            parameters.add("2");              // hardwareID
//            row = databaseDAO.updateQuery(SQLLibrary.ADMIN_CHANGE_TERMINAL_INSTALLSTATUS,parameters);
//            System.err.println("update done");
//
//            
            
        else if(command.equals("OP")){
            System.err.println("EventManager processRequest, OP revieced");
        }
        else if (command.equals("01")) {
            System.err.println("EventManager processRequest, if 01 revieced, send 12-Accept");
            sendResponse("12", "Accept",destination);
        }
        else if (command.equals("RA")) {
            System.err.println("EventManager processRequest, RA recieved.");
        }
        
        
        
        
        else{
            System.err.println("EventManager processRequest: Unproccessed command revieced: "+command);
        }
        }
    }
    
    
    public void testsendresponce(){}
    
    
    class TimerListener implements ActionListener {  // Resend request Timelistener. Is stopped on verification of checksum.
        public void actionPerformed(ActionEvent e) {         
            if (currentSendAttempt == maxSendAttempt){  // Needs to implement connection lost. Setting the terminal offline time if unset.
                    terminalManager.connectionFailed(destination);
                    System.err.println("EventManager TimeListener, maxSendAttempt reached");
                    timer.stop();
            }
            else {
                System.err.println("Resending packet");
                ProjectPacket responsePacket = new ProjectPacket(source, destination, currentStatus, currentData);
                transmitter.transmit(responsePacket.getBytes());   
                currentSendAttempt++;
            }
        }
    }
    
    
         public void startTimer() {
    System.out.println("testmethod");
    timer2.start();
    
    }
      // Should be moved
      public  class TimerListener2 implements ActionListener {  // Resend request Timelistener. Is stopped on verification of checksum.
        public synchronized void actionPerformed(ActionEvent e) {  
            ArrayList<Terminal> terminals;
            ArrayList<String> Parameter = new ArrayList();
                   terminals = DatabaseManager.getTerminals(SQLLibrary.SYSTEM_GET_ALL_TERMINALS,Parameter);
                   System.err.println("size of array"+terminals.size());
                   System.err.println("EventManager TimerListener FireSQL PING!");
                   try {
                        openPort();
                   } catch (TooManyListenersException ex) {
                        System.err.println("TimerListener2 TooManyListenersException");
                   }
                   sendResponse("PI", "PING", terminals.get(i).getIpAddress()); // could implement sending time and date to the terminal.
                   System.err.println("EventManager TimerListener2, PI, PING, "+terminals.get(i).getIpAddress()+" i: "+i);
                      // closePort();
                 i++;
                if (i >= terminals.size()){ i=0;}
               // if last element:  timer.stop();

        }
      }
    
}
