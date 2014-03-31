/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SerialCom.controller;

import SQLDatabase.DAO.*;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import SerialCom.protocol.*;
import SerialCom.serial.*;
import java.util.TooManyListenersException;
import java.util.ArrayList;



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

    /**
     * Default constructor which automatically detects port name.
     */
    public EventManager() {
        portNumber = PortDetection.getPorts().get(0);
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
        System.out.println("padAmount number:"+number);
    return String.format("%06d", Math.round(number)); // OBS!!!!
    }

    /**
     * Send the <code>RFIDResponse</code> as an <code>ProjectPacket</code> using
     * the serial transmitter. 
     * @param status The status response to send
     * @param data The specific data for the status response
     */
    public synchronized void sendResponse(String status, String data) {
        System.out.println("EventManager sendResponse");
        ProjectPacket responsePacket = new ProjectPacket(source, destination, status, data);
        transmitter.transmit(responsePacket.getBytes());
    }

    /**
     * The method called by the <code>SerialFrame</code> when a complete 
     * data packet is received.
     * @param frameEvent the frame event
     */
    public synchronized void frameReady(FrameEvent frameEvent) {
        System.out.println("EventManager frameReady");
        byte[] received  = frameEvent.getData();
        System.out.print("\nReceived at Server: [");
        System.out.println(new String(received) + "]");
        packet = new ProjectPacket(received);
        System.out.println("           command: [" + packet.getCommandStatus() + "]");
        System.out.println("           data:    [" + packet.getData() + "]");
        //TO DO Process request and send response
        processRequest(packet);
    }

    private void processRequest(Packet packet) {
        System.out.println("EventManager processRequest");
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
        int checksum = packet.getChecksum(); // get the checksum from the package
        packet.generateChecksum();           // generate the actual checksum
        int checksum2 =  packet.getChecksum(); // get the new generated checksum fom the package
        if (checksum  == checksum2) {
        System.out.println("checksum ok:" +checksum);
        }
        else{
        System.out.println("checksum failed:" +checksum + " " + checksum2);  // should send resend command
        }
        
        //check checksum - if invalid return RS - Resend. 
          //else
        
        if (command.equals("VC")) {  //   - Verify Customer (pin and card number)
            System.out.println("command = VC");
            DatabaseDAO databaseDAO = new DatabaseDerbyDAO();
            // get Pin CardNumb from Serial package
            String pin = packet.getData().substring(0, 4);  // get the pin from the data of the package
            System.out.println("Pin: " + pin);
            String CardNumb = packet.getData().substring(4, 8); // needs to be changed to actual CardNumb length!!!
            System.out.println("Cardnumber: " + CardNumb);
            Customer costumer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(CardNumb);   // add the cardnumber parameter
            parameterscostumer.add(pin);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            try {
                System.out.println("Fire SQL statement");
                costumer = databaseDAO.getCustomer(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER, parameterscostumer);
            } catch (Exception e) {
                System.out.println("no customer found");
                sendResponse("RA", "VOID");
          
            }
            if (costumer != null) {
              System.out.println("customer found, sending response");
            sendResponse("VC", padAmount(costumer.getBalance())+costumer.getUseStatus()+costumer.getAccountStatus()+costumer.getFirstName());
            
            }
            else {System.out.println("customer object is NULL");}
            
            // get Pin CardNumb Balance AccountStatus and UseStatus for customer, or empty result set.
               //if resultset empty, reply with sendResponse("RA", "VOID");

            
            
               //else reply with Pin CardNumb Balance AccountStatus and UseStatus for customer

            // respond with query to serial
            
            
            
            
            
            
            
            
//            sendResponse("RA", "Accept");
//            ArrayList<Terminal> terminalList;
//            
//
//            System.out.println("---");
//            System.out.println("Modify terminal:");
//            int row;
//            ArrayList<String> parameters = new ArrayList();
//            parameters.add("seethis");        // status
//            parameters.add("2");              // hardwareID
//            row = databaseDAO.updateQuery(SQLLibrary.ADMIN_CHANGE_TERMINAL_INSTALLSTATUS,parameters);
//            System.out.println("update done");
//
//            
            
        }
        else if(command.equals("OP")){
            
        }
        else if (command.equals("01")) {
            System.out.println("EventManager processRequest, if 01, send 12-Accept");
            sendResponse("12", "Accept");
        }
        //else if (command.equals("03")) {
        //    System.out.println("EventManager processRequest, 03 recieved, end of handshake");
        //}
            
    }
}
