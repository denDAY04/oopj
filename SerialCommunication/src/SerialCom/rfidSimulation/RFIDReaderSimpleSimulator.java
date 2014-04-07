/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SerialCom.rfidSimulation;

import SerialCom.controller.PortDetection;
import SerialCom.protocol.ProjectPacket;
import SerialCom.serial.FrameEvent;
import SerialCom.serial.FrameEventListener;
import SerialCom.serial.SerialTransceiver;
import java.util.TooManyListenersException;
import SerialCom.protocol.Packet;

/**  // Simulation of RFID for J-unit testing
 * The <code>RFIDReaderSimpleSimulator</code> class simulates the RFID Reader.
 *
 * @version 16/02/10
 * @author ibr
 */
public class RFIDReaderSimpleSimulator implements FrameEventListener {

    private SerialTransceiver transmitter;
    private String portNumber;             // Windows port
    private String source = "12";
    private String destination = "34";
    private Packet packet;

    /**
     * Default constructor which automatically detects port name.
     */
    public RFIDReaderSimpleSimulator() {
        portNumber = PortDetection.getPorts().get(1);
    }

    /**
     * Get the value of destination
     *
     * @return the value of destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Set the value of destination
     *
     * @param destination new value of destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Get the value of packet
     *
     * @return the value of packet
     */
    public Packet getPacket() {
        return packet;
    }

    /**
     * Get the value of source
     *
     * @return the value of source
     */
    public String getSource() {
        return source;
    }

    /**
     * Set the value of source
     *
     * @param source new value of source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Set the value of transmitter
     *
     * @param transmitter new value of transmitter
     */
    public void setTransmitter(SerialTransceiver transmitter) {
        this.transmitter = transmitter;
    }

    /**
     * Method encapsulates the RFID request as an <code>ProjectPacket</code>
     * and transmits the packet through the serial port.
     */
    public synchronized void sendRFIDRequest(String command, String data) {
        System.err.println("Simulator sendRFIDRequest");
        ProjectPacket packet = new ProjectPacket(source, destination, command, data);
        transmitter.transmit(packet.getBytes());
    }


    /**
     * The <code>FrameEventListener</code> method called when a
     * <code>FrameEvent</code> occurs.
     * The <code>RFIDResponse</code> is extracted from the <code>ProjectPacket</code>
     * and processed.
     * @param frameEvent the event
     */
    public synchronized void frameReady(FrameEvent frameEvent) {
        System.err.print("Simulator frameReady");
        System.err.print("\nReceived at Client: [");
        System.err.println(new String(frameEvent.getData()) + "]");
        packet = new ProjectPacket(frameEvent.getData());
        System.err.println("            status: [" + packet.getCommandStatus() + "]");
        System.err.println("            data:   [" + packet.getData() + "]");
        processRequest(packet.getCommandStatus());
      }

    private void processRequest(String command) {
        //THIS CODE IS FOR SIMPLE DEMONSTRATION ONLY.
        //IT IS DIFFICULT TO MAINTAIN AND TEST.
        //IT SHOULD BE REPLACED BY EG. COMMAND PATTERN IN THE LATER DESIGN
        // Simulation of RFID for J-unit testing
        System.err.println("Simulator processRequest");
        if (command.equals("VC")) {   // revieves customer data
            sendRFIDRequest("RA", "Receive Acknowledged");  // skips checksum check and acknoleges recieved.
            System.err.println("Simulator processRequest: RA Receive Acknowledged sent");
        }
        else if (command.equals("12")) {
            sendRFIDRequest("03", "AcceptAck");
            System.err.println("Simulator processRequest: 03 AcceptAck sent");
        }
        else if (command.equals("PI")){
            sendRFIDRequest("PO", "PONG");
            System.err.println("Simulator processRequest: PO PONG sent");
        
        }
        
        
        else{
            System.err.println("Simulator processRequest: Unproccessed command revieced: "+command);
        }
    }

    /**
     * Open the serial port and connect to server.
     * @throws TooManyListenersException
     */
    public void connect() throws TooManyListenersException {
        if (transmitter != null) {
            System.err.println("Simulator connect, sending 01");
            transmitter.openPort(portNumber);
            sendRFIDRequest("01", "connect");

        }
    }

    /**
     * Close the serial port.
     */
    public void closePort() {
        if (transmitter != null) {
            transmitter.closePort();
        }
    }
}
