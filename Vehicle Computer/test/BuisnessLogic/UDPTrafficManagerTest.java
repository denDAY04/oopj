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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * {Insert class description here}
 * 
 * @author Andreas Stensig Jensen, on 08-11-2014
 * Contributors: 
 */
public class UDPTrafficManagerTest extends Thread {

    private int port;
    private String msg;
    private InetAddress addr;
    private DatagramSocket socket;
    
    
    public UDPTrafficManagerTest(int port, String msg) throws UnknownHostException, SocketException {
        this.port = port;
        this.msg = msg;
        addr = InetAddress.getLocalHost();
        socket = new DatagramSocket();
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream oos = null;
            try {
                DatagramPacket packet;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(msg);
                byte[] arr = bos.toByteArray();
                packet = new DatagramPacket(arr, arr.length, addr, port);
                socket.send(packet);
            } catch (IOException ex) {
                Logger.getLogger(UDPTrafficManagerTest.class.getName()).
                        log(Level.SEVERE, null, ex);
            } finally {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(UDPTrafficManagerTest.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
            
            
            byte[] inputArr = new byte[21900];
            DatagramPacket inPacket = new DatagramPacket(inputArr, inputArr.length);
            socket.receive(inPacket);
            ByteArrayInputStream bis = new ByteArrayInputStream(inPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);
            
            String response = (String) ois.readObject();
            System.err.println(response);
        } catch (IOException ex) {
            Logger.getLogger(UDPTrafficManagerTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UDPTrafficManagerTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, ClassNotFoundException {
        String message1 = "This is the test message1";
        String message2 = "This is the test message2";
        String message3 = "This is the test message3";
        String message4 = "This is the test message4";
        String message5 = "This is the test message5";
        int port = 2408;
        UDPTrafficManagerTest test1 = new UDPTrafficManagerTest(port, message1);
        UDPTrafficManagerTest test2 = new UDPTrafficManagerTest(port, message2);
        UDPTrafficManagerTest test3 = new UDPTrafficManagerTest(port, message3);
        UDPTrafficManagerTest test4 = new UDPTrafficManagerTest(port, message4);
        UDPTrafficManagerTest test5 = new UDPTrafficManagerTest(port, message5);

        test1.start();
        test2.start();
        test3.start();
        test4.start();
        test5.start();
    }
    
    
}
