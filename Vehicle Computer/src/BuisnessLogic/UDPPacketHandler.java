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
 * Thread extension class for handling communication with a
 * <code>VehicleComputer</code> in regards to producing a
 * <code>TicketList</code> out of a <code>PassengerList</code>.
 * <p>
 * This class is meant to be instantiated with each new session with a
 * vehicle computer client, and terminate itself after having completed its
 * service of the client, as dictated by a custom protocol.
 * <p>
 * @author Andreas Stensig Jensen, on Nov 7, 2014
 * Contributors:
 */
public class UDPPacketHandler extends Thread {

    private boolean alive = true;
    private final int destPort;
    private final InetAddress destAddr;
    private byte[] bufferIn = new byte[UDPTrafficManager.BUFFER_IN_SIZE];
    private byte[] bufferOut = new byte[UDPTrafficManager.BUFFER_OUT_SIZE];
    private final DatagramSocket socket;
    private DatagramPacket packet;
    private JourneyManager journeyManager;


    /**
     * Proper constructor that incorporates RMI variables.
     * <p>
     * @param packet            initial <code>DatagramPacket</code> from client
     *                          wanted to
     *                          be serviced.
     * @param socketPort        the port number on which the handler shall open
     *                          a
     *                          <code>DatagramSocket</code>.
     * @param rmiHost           host name of the service running the RMI
     *                          registry.
     * @param rmiPort           port number of the service running the RMI
     *                          registry.
     * @param rmiJourneyManName name of the <code>JourneyManager</code>
     *                          implementation class in the RMI registry.
     * <p>
     * @throws RemoteException   if unable to locate RMI registry.
     * @throws NotBoundException if unable to locate implementation class in the
     *                           RMI registry.
     * @throws SocketException   if unable to open a <code>DatagramSocket</code>
     *                           on the specified port.
     */
    public UDPPacketHandler(DatagramPacket packet, int socketPort,
                            String rmiHost, int rmiPort,
                            String rmiJourneyManName) throws RemoteException,
                                                             NotBoundException,
                                                             SocketException {
        this.packet = packet;
        destPort = packet.getPort();
        destAddr = packet.getAddress();
        journeyManager = new JourneyManager(rmiHost, rmiPort, rmiJourneyManName);
        socket = new DatagramSocket(socketPort);
    }

    /**
     * Test constructor that ignores RMI initialization. Use for
     * internal testing that doesn't concern itself with RMI.
     * <p>
     * @param packet     initial <code>DatagramPacket</code> from client wanted
     *                   to be serviced.
     * @param socketPort the port number on which the handler shall open a
     *                   <code>DatagramSocket</code>.
     * <p>
     * @throws SocketException if unable to open a <code>DatagramSocket</code>
     *                         on the specified port.
     */
    public UDPPacketHandler(DatagramPacket packet, int socketPort) throws
            SocketException {
        this.packet = packet;
        destPort = packet.getPort();
        destAddr = packet.getAddress();
        socket = new DatagramSocket(socketPort);
    }

    /**
     * Main flow of the the thread. Will continue to run, processing data
     * whenever a new <code>DatagramPacket</code> is available, until
     * <code>killThread()</code> has been called.
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
             contant UDPTrafficManager again. Therefore, kill the handler. 
             */
            System.err.println("-- UDPPacketHandler --");
            System.err.println("I/O exception in initial datagram.");
            System.err.println("Killing thread.");
            killThread();
        }
        while (alive) {
            try {
                socket.receive(packet);
                processDatagram();
            } catch (IOException ex) {
                System.err.println("-- UDPPacketHandler --");
                System.err.println("I/O exception; datagram dropped.");
            }
        }
        System.out.println("Thread killed. . . ");
    }

    /**
     * Kills the targeted thread, making it stop execution. If the thread is
     * currently processing a Datagram the thread will not stop execution until
     * after it is done with its current task.
     */
    private void killThread() {
        alive = false;
    }

    /**
     * Processes the data in the <code>DatagramPacket</code>.
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

        PassengerList passengers;
        try {
            // Test: generate tickets through RMI and return the list
            passengers = (PassengerList) ois.readObject();
            TicketList tickets = journeyManager.generateTickets(passengers);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(tickets);
            bufferOut = bos.toByteArray();
            DatagramPacket replyPacket = new DatagramPacket(bufferOut, bufferOut.length, destAddr, destPort);
            socket.send(replyPacket);
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UDPPacketHandler.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        killThread();
    }

}
