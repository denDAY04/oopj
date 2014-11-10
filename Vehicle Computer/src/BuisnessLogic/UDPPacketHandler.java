/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BuisnessLogic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Stensig
 */
public class UDPPacketHandler extends Thread {

//    private boolean newData = true;
    private boolean alive = true;
//    private final String name;
    private int destPort;
    private InetAddress destAddr;
    private byte[] bufferIn = new byte[UDPTrafficManager.BUFFER_IN_SIZE];
    private byte[] bufferOut = new byte[UDPTrafficManager.BUFFER_OUT_SIZE];
    private DatagramSocket socket;
    private DatagramPacket packet;
    private JourneyManager journeyManager;


    public UDPPacketHandler(DatagramPacket packet, int socketPort, String rmiHost, int rmiPort,
                            String rmiJourneyManName) throws RemoteException, NotBoundException, SocketException {
        // Name the thread with the sender-host name for identification
        //name = packet.getAddress().getHostName();
        this.packet = packet;
        destPort = packet.getPort();
        destAddr = packet.getAddress();
        journeyManager = new JourneyManager(rmiHost, rmiPort, rmiJourneyManName);
        socket = new DatagramSocket(socketPort);
    }
    
    /**
     * Test constructor for testing. Ignores RMI initialization. Use for 
     * internal testing that doesn't concern itself with RMI. 
     * @param packet initial <code>DatagramPacket</code> from client wanted to
     * be serviced.
     * @param socketPort the port number on which the handler shall open a 
     * <code>DatagramSocket</code>. 
     * @throws SocketException if the socket is in use.
     */
    public UDPPacketHandler(DatagramPacket packet, int socketPort) throws SocketException {
        this.packet = packet;
        destPort = packet.getPort();
        destAddr = packet.getAddress();
        socket = new DatagramSocket(socketPort);
    }

// Legacy method
//    public String name() {
//        return name;
//    }

    /**
     * Main flow of the the thread. Will continue to run, processing data
     * whenever a new <code>DatagramPacket</code> is available, until
     * <code>killThread()</code> is called.
     */
    @Override
    public void run() {
        // Initial processing of datagram set in constructor.
        try {
            processDatagram();
        } catch (IOException ex) {
            /*
            If first datagram is dropped then client won't know the port of 
            the handler. Thus the handler serves no purpose as the client will 
            contant UDPTrafficManager again. There, kill the handler. 
            */
            System.err.println("-- UDPPacketHandler --");
            System.err.println("I/O exception in initial datagram.");
            System.err.println("Killing thread.");
            killThread();
        }
        while (alive) {
//            if (newData) {
//                processDatagram();
//            }
            try {
                socket.receive(packet);
                processDatagram();
            } catch (IOException ex) {
                System.err.println("-- UDPPacketHandler --");
                System.err.println("I/O exception; datagram dropped.");
            }
        }
        System.err.println("Thread killed. . . ");
    }

    /**
     * Kills the targeted thread, making it stop execution. If the thread is
     * currently processing a Datagram the thread will not stop execution until
     * after it is done with its current task.
     */
    private void killThread() {
        alive = false;
    }

// might not be needed - legacy method from when all com was through 
// UDPTrafficManager
    /**
     * Put new data in the form of a <code>DatagramPacket</code> in the handler
     * thread. The new data will be processed as soon as the thread is ready
     * and done with any current data processing.
     * <p>
     * @param packet new <code>DatagramPacket</code> to process.
     */
    public void recieveDatagram(DatagramPacket packet) {
//        this.packet = packet;
//        newData = true;
    }

    /**
     * Processes the data in the <code>DatagramPacket</code> and changes
     * newData flag to false.
     */
    private void processDatagram() throws IOException {
        bufferIn = packet.getData();
        ByteArrayInputStream bis = new ByteArrayInputStream(bufferIn);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bis);
        } catch (IOException ex) {
            System.err.println("Could not procecss datagram.");
            ex.printStackTrace();
            return;
        }

        String s = "NO DATA";
        try {
            s = (String) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UDPPacketHandler.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        System.err.println(s);
        
        // Test reply back to client
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        String replyMsg = "This is the Handler replying";
        oos.writeObject(replyMsg);
        bufferOut = bos.toByteArray();
        
        DatagramPacket replyPacket = new DatagramPacket(bufferOut, bufferOut.length,
                                                        destAddr, destPort);
        socket.send(replyPacket);
        
        killThread();
//        newData = false;
    }


    // send Datagram to VehicleComputer
    public void recieveTicketList(TicketList tickets) {

    }

    public void sendPassengerlist(PassengerList passengers) {

    }

}
