/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import protocol.ProjectPacket;
import serial.FrameEvent;
import serial.FrameEventListener;
import serial.SerialTransceiver;
import java.util.TooManyListenersException;
import protocol.Packet;

/**
 * The <code>RFIDEventManagerSimple</code> class is the central controller in the
 * application. It receives requests from the serial port, processes them and
 * transmits the response.
 * The <code>RFIDEventManagerSimple</code> is implemented using the State design pattern.
 * @version 16/02/10
 * @author ibr
 */
public class RFIDEventManagerSimple implements FrameEventListener {

    private SerialTransceiver transmitter;
    private String portNumber = "COM4";             // Windows port
    private String source = "34";
    private String destination = "12";
    private Packet packet;

    public RFIDEventManagerSimple() {
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

    /**
     * Send the <code>RFIDResponse</code> as an <code>ProjectPacket</code> using
     * the serial transmitter. 
     * @param status The status response to send
     * @param data The specific data for the status response
     */
    public synchronized void sendRFIDResponse(String status, String data) {
        ProjectPacket responsePacket = new ProjectPacket(source, destination, status, data);
        transmitter.transmit(responsePacket.getBytes());
    }

    /**
     * The method called by the <code>SerialFrame</code> when a complete 
     * data packet is received.
     * @param frameEvent the frame event
     */
    public synchronized void frameReady(FrameEvent frameEvent) {
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
        //THIS CODE IS FOR SIMPLE DEMONSTRATION ONLY.
        //IT IS DIFFICULT TO MAINTAIN AND TEST.
        //IT SHOULD BE REPLACED BY EG. COMMAND PATTERN IN THE LATER DESIGN
        String command = packet.getCommandStatus();
        if (command.equals("01")) {
            sendRFIDResponse("12", "Accept");
        }
        else if(command.equals("09")){
            
        }
    }
}
