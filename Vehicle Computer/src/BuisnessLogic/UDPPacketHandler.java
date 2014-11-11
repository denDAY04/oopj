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
import java.util.Arrays;


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

    private final int SEQ_NUM_Index = 0;
    
    private boolean alive = true;
    private final int destPort;
    private final InetAddress destAddr;
    private byte[] bufferIn = new byte[UDPTrafficManager.BUFFER_IN_SIZE];
    private byte[] bufferOut = new byte[UDPTrafficManager.BUFFER_OUT_SIZE];
    private final DatagramSocket socket;
    private DatagramPacket packet;
    private byte expSeqNum, currSeqNum;
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
        // Extract sequence number and preapre data input stream
        bufferIn = packet.getData();
        byte seqNum = bufferIn[SEQ_NUM_Index];
        byte[] dataIn = Arrays.copyOfRange(bufferIn, (SEQ_NUM_Index + 1), bufferIn.length);
        ByteArrayInputStream bis = new ByteArrayInputStream(dataIn);
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(bis);
        } catch (IOException ex) {
            System.err.println("Could not procecss datagram.");
            ex.printStackTrace();
            return;
        }

        switch (seqNum) {
            case 0 :  // Request for service and tickets
                PassengerList passengers;
                try {
                    // Extract passenger list and get ticket list from JourneyManager
                    passengers = (PassengerList) ois.readObject();
                    TicketList tickets = journeyManager.generateTickets(passengers);
                    
                    // Serialize ticket list
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(tickets);
                    byte[] dataOut = bos.toByteArray();
                                        
                    //Incerement sequence number and populate output buffer
                    prepBufferOut(++seqNum, dataOut);
                    
                    // Reply to client
                    DatagramPacket replyPacket = new DatagramPacket(bufferOut, bufferOut.length, destAddr, destPort);
                    socket.send(replyPacket);
                } catch (IOException | ClassNotFoundException ex) {
                    System.err.println("Could not process data in datagram.");
                    ex.printStackTrace();
                    System.err.println("Dropping datagram.");
                    return;
                }
                break;
        }
    }

    /**
     * Fill the output buffer with the supplied sequence number and data. 
     * @param seqNum sequence number to be placed in the buffer.
     * @param data data to be placed in the buffer.
     */
    private void prepBufferOut(byte seqNum, byte[] data) {
        bufferOut[SEQ_NUM_Index] = seqNum;
        /*
        Copy data into output buffer, beginning from index next to sequence 
        number and stopping at index one over data length due to one extra 
        index for sequence number. 
        */
        for (int i = (SEQ_NUM_Index + 1); i != (data.length + 1); ++i) {
            bufferOut[i] = data[i];
        }
    }
    
}
