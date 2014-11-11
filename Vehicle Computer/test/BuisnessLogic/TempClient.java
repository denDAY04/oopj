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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Stand-in class for <code>VehicleComputer</code> clients in order to execute
 * <code>IntegreationTest</code> class.
 * 
 * @author Andreas Stensig Jensen, on Nov 11, 2014
 * Contributors: 
 */
public class TempClient extends Thread {
    PassengerList passengers;
    DatagramSocket socket;

    public TempClient() throws SocketException {
        passengers = IntegrationTest.generatePassList();
        socket = new DatagramSocket();
    }

    @Override
    public void run() {
        try {
            // Serialize passenger list
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(passengers);

            // Prepare and send datagram
            byte[] buffOut = bos.toByteArray();
            InetAddress host = InetAddress.getLocalHost();
            int port = 2408;
            DatagramPacket packet = new DatagramPacket(buffOut, buffOut.length, host,port);
            socket.send(packet);
            
            // Recive reply
            byte[] buffIn = new byte[UDPTrafficManager.BUFFER_OUT_SIZE];
            DatagramPacket response = new DatagramPacket(buffIn, buffIn.length);
            socket.receive(response);
            // Read it
            ByteArrayInputStream bis = new ByteArrayInputStream(response.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            TicketList tickets = (TicketList) ois.readObject();
            // Print it
            for (Ticket t : tickets.getAllTickets()) {
                System.out.println("Client: Ticket nr. " + t.getNumber());
            }
            
        } catch (IOException ex) {
            Logger.getLogger(IntegrationTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TempClient.class.getName()).log(Level.SEVERE, null,
                                                             ex);
        } 
    }
}
