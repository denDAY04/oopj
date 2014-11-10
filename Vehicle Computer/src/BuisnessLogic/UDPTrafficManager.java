package BuisnessLogic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
 * Manager for incoming serivce requests from <code>VehicleComputer</code>
 * clients. This class captures the UDP request and instanciates a new instance
 * of of the <code>UDPPacketHandler</code> class. This class is then passed
 * the request for service and will service the client in a seperate thread.
 * <p>
 * NOTE that this class does not check the incoming UDP datagrams for propper
 * request syntax as dictated by a custom protocol. Instead, this is left for
 * the designated handler of the request.
 * <p>
 * Furthermore, this class cotains the main method for starting this part of the
 * business logic back-end.
 * <p>
 * @author Andreas Stensig Jensen, on Nov 7, 2014
 * Contributors:
 */
public class UDPTrafficManager {

    private DatagramSocket socket;
    private String rmiHost, rmiJournayManagerName;
    private int rmiPort;
    private int udpSocketPort = 2409;

    /**
     * Size for a <code>byte</code> buffer tested to hold 800 passengers in a
     * serialized <code>PassengerList</code>. Test showed a size of 8207 bytes.
     * Actual size is 8,300 for good measure.
     */
    protected static final int BUFFER_IN_SIZE = 8300;

    /**
     * Size for a <code>byte</code> buffer tested to hold 800 tickets in a
     * serialized <code>TicketList</code>. Test showed a size of 21,833 bytes.
     * Actual size is 21,900 for good measure.
     */
    protected static final int BUFFER_OUT_SIZE = 21900;


    /**
     * Open the UDP <code>DatagramSocket</code> on a specified port, with the
     * host name of the local machine.
     * <p>
     * @param port port number for the socket.
     */
    private void openUDPSocket(String port) {
        try {
            int socketPort = Integer.parseInt(port);
            InetAddress hostAddr = InetAddress.getLocalHost();
            socket = new DatagramSocket(socketPort, hostAddr);
        } catch (NumberFormatException | UnknownHostException | SocketException ex) {
            System.err.println("Fatal error in UPDTrafficManager.");
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Assigns the RMI properties to field variables. This method MUST be called
     * prior to the <code>distributeDatagram</code> method.
     * <p>
     * @param RMIHost           host name of the RMI registry location.
     * @param RMIPort           port number of the RMI registry location.
     * @param RMIJouenryManName name of the <code>JourneyManager</code>
     *                          implementation class in the RMI registry.
     */
    private void setRMIpropperties(String RMIHost, String RMIPort,
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

    /**
     * Distributes a <code>DatagramPacket</code> to a new handler thread.
     * The new handler will then take over communication with the client through
     * its own <code>DatagramSocker</code>.
     * <p>
     * The <code>setRMIPropperties</code> method MUST be called prior to this
     * method.
     * <p>
     * @param packet the <code>DatagramPacket</code> received from a client that
     *               wishes to be serviced.
     */
    private void distributeDatagram(DatagramPacket packet) {
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
            UDPPacketHandler handler
                    = new UDPPacketHandler(packet, udpSocketPort);
            // Outcommented to ignore RMI
            //UDPPacketHandler handler = 
            //       new UDPPacketHandler(packet, udpSocketPort, rmiHost,
            //                               rmiPort, rmiJournayManagerName)
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
     *             <ul>
     * <li>0 : port number for the <code>UDPTrafficManager</code>'s UDP socket.
     * <li>1 : host name for the RMI registry server.
     * <li>2 : port number for the RMI registry server.
     * <li>3 : name of the <code>JourneyManager</code> implementation class in
     * the RMI registry.
     * </ul>
     * <p>
     */
    public static void main(String[] args) {
        UDPTrafficManager manager = new UDPTrafficManager();
        /* testing */
        String port = "2408";
        manager.openUDPSocket(port);
        /* -- */
        // Outcommented for testing
        //manager.openUDPSocket(args[0]);
        //manager.setRMIpropperties(args[1], args[2], args[3]);

        DatagramPacket packet;
        while (true) {
            // Wait for new DatagramPacket and distribute it to a new handler.
            try {
                System.err.println("Waiting for packet. . . ");
                packet = new DatagramPacket(new byte[BUFFER_IN_SIZE],
                                            BUFFER_IN_SIZE);
                manager.socket.receive(packet);
                manager.distributeDatagram(packet);
            } catch (IOException ex) {
                System.err.println("-- UDPTrafficManager --");
                System.err.println("I/O exception; datagram dropped.");
                System.err.println("Continue listening for next datagram. ");
            }
        }
    }

}
