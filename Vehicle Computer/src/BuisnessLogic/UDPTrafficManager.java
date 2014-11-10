package BuisnessLogic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * {Insert class description here}
 * <p>
 * @author Andreas Stensig Jensen, on Nov 7, 2014
 * Contributors:
 */
public class UDPTrafficManager {

    private static DatagramSocket socket;
    private static String rmiHost, rmiJournayManagerName;
    private static int rmiPort;
    private static int udpSocketPort = 2409;

    // Test for input buffer size with 800 passengers was 8207
    protected static final int BUFFER_IN_SIZE = 8300;
    // Test for input buffer size with 800 passengers was 21833
    protected static final int BUFFER_OUT_SIZE = 21900;


    public synchronized static boolean sendDatagram(DatagramPacket packet) {
        try {
            socket.send(packet);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

// Legacy method -- possibly not needed
// Handlers should themselves determin when to stop execution, via their acks 
// and seq#. 
    private static boolean closeHandlerThread(String threadName) {
//        for (UDPPacketHandler handler : handlers) {
//            if (handler.name().equals(threadName)) {
//                handler.killThread();
//                handlers.remove(handler);
//                return true;
//            }
//        }
        return false;
    }

    private static void openUDPSocket(String host, String port) {
        try {
            int socketPort = Integer.parseInt(port);
            InetAddress hostAddr = InetAddress.getByName(host);
            socket = new DatagramSocket(socketPort, hostAddr);
        } catch (NumberFormatException | UnknownHostException | SocketException ex) {
            System.err.println("Fatal error in UPDTrafficManager.");
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    private static void setRMIpropperties(String RMIHost, String RMIPort,
                                          String RMIJouenryManName) {
        try {
            rmiHost = RMIHost;
            rmiPort = Integer.parseInt(RMIPort);
            rmiJournayManagerName = RMIJouenryManName;
        } catch (NumberFormatException ex) {
            System.err.println("Fatal error in UPDTrafficManager.");
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    
// Legacy method -- possibly not needed
    /**
     * Reply to the a client with a <code>DatagramPacket</code> whose payload
     * is an integer specifying the port number of a new 
     * <code>DatagramSocket</code> created in the handler thread that will 
     * service the client. 
     * @param packet the original <code>DatagramPakcet</code> from the client 
     * requesting to be serviced. This is used to generate a reply. 
     * @throws IOException if an I/O exception occurs during the output streams 
     * generating the reply. 
     */
    private static void replyWithHandlerPort(DatagramPacket packet) throws IOException {
        // Create output streams and generate reply
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        Integer handlerSocketReply = udpSocketPort;
        oos.writeObject(handlerSocketReply);
        byte[] replyArr = bos.toByteArray();
        
        // Get destination ip and port and send reply. 
        InetAddress destAddr = packet.getAddress();
        int port = packet.getPort();
        DatagramPacket reply = new DatagramPacket(replyArr, replyArr.length, destAddr, port);
        socket.send(reply);
    }
    
    /**
     * Distributes a <code>DatagramPacket</code> to a new handler thread. 
     * The new handler will then take over communication with the client through
     * its own <code>DatagramSocker</code>. 
     * @param packet the <code>DatagramPacket</code> received from a client that 
     * wishes to be serviced. 
     */
    private static void distributeDatagram(DatagramPacket packet) {
        /*
        Do not offer port numbers greater than 2,409 + 2,000. With a restiction
        of a maximum users of 1,000, we can expect to be able to reuse port 
        numbers after an extra 1,000 port numbers.
        */
        if (udpSocketPort >= 4409) {
            udpSocketPort = 2409;
        }
        
        /*
        Instantiate new handler for the DatagramPacket, start handler thread, 
        and increment UDP socket port counter.
        */
        try {
            // Using test constructor to ignore RMI.
            UDPPacketHandler handler = 
                   new UDPPacketHandler(packet, udpSocketPort);
            System.err.println("Handler created.");
            handler.start();
            System.err.println("Handler started.");
            ++udpSocketPort;
        } catch (SocketException ex) {
            System.err.println("-- UDPTRafficManager --");
            System.err.println("Handler exception; datagram dropped.");
            System.err.println(ex.getMessage());
            System.err.println("Continue listening for new datagram.");
        }
    }
    
    /**
     * Main method for starting <code>UDPTrafficManger</code>,
     * <code>UDPPacketHandler</code>, and <code>JourneyManager</code>.
     * <p>
     * @param args
     * <p>
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
    /* testing */
        InetAddress addr = InetAddress.getLocalHost();
        String port = "2408";
        String host = addr.getHostName();
        openUDPSocket(host, port);
    /* -- */
        
    // Outcommented for testing
        //openUDPSocket(args[0], args[1]);
        //setRMIpropperties(args[2], args[3], args[4]);

        DatagramPacket packet;
        while (true) {
            // Wait for new DatagramPacket and distribute it to a new handler.
            try {
                System.err.println("Waiting for packet. . . ");
                packet = new DatagramPacket(new byte[BUFFER_IN_SIZE],
                                            BUFFER_IN_SIZE);
                socket.receive(packet);
                distributeDatagram(packet);
            } catch (IOException ex) {
                System.err.println("-- UDPTrafficManager --");
                System.err.println("I/O exception; datagram dropped.");
                System.err.println("Continue listening for next datagram. ");
            }
        }
    }

}
