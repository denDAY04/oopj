/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

import protocol.ProjectPacket;
import serial.FrameEvent;
import serial.FrameEventListener;
import serial.SerialTransceiver;
import java.util.TooManyListenersException;
import protocol.Packet;

/**
 * The <code>RFIDReaderSimpleSimulator</code> class simulates the RFID Reader.
 *
 * @version 16/02/10
 * @author ibr
 */
public class RFIDReaderSimpleSimulator implements FrameEventListener {

    private SerialTransceiver transmitter;
    private String portNumber = "COM5";             // Windows port
    private String source = "12";
    private String destination = "34";
    private Packet packet;

    public RFIDReaderSimpleSimulator() {
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
        System.out.print("\nReceived at Client: [");
        System.out.println(new String(frameEvent.getData()) + "]");
        packet = new ProjectPacket(frameEvent.getData());
        System.out.println("            status: [" + packet.getCommandStatus() + "]");
        System.out.println("            data:   [" + packet.getData() + "]");
        processRequest(packet.getCommandStatus());
      }

    private void processRequest(String command) {
        //THIS CODE IS FOR SIMPLE DEMONSTRATION ONLY.
        //IT IS DIFFICULT TO MAINTAIN AND TEST.
        //IT SHOULD BE REPLACED BY EG. COMMAND PATTERN IN THE LATER DESIGN
        if (command.equals("12")) {
            sendRFIDRequest("03", "AcceptAck");
        }
    }

    /**
     * Open the serial port and connect to server.
     * @throws TooManyListenersException
     */
    public void connect() throws TooManyListenersException {
        if (transmitter != null) {
            transmitter.openPort(portNumber);
            sendRFIDRequest("01", "Connect");
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
