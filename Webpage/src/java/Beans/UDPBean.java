package Beans;

import ModelClasses.RoutePlannerJourney;
import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.GregorianCalendar;

/**
 *
 * UDPBean The UDPBean contacts the Route Planner Server and receives a Route
 * Planner Journey model class back.
 *
 *
 * @author Rasmus LOft
 */
public class UDPBean implements Serializable {

    public RoutePlannerJourney sendRequest(int origin, int destination, GregorianCalendar timeDeparture) throws Exception {

        final int ServerPort = 44448;

        RoutePlannerJourney result = null;

        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket outPacket;
        InetAddress address = InetAddress.getByName("thelizard6.eitlab.ihk-edu.dk");

        String msg = origin + ";" + destination + ";" + timeDeparture.getTimeInMillis();
        outPacket = new DatagramPacket(msg.getBytes(), msg.length(), address, ServerPort);
        datagramSocket.send(outPacket);
        DatagramPacket reply;
        byte[] dataBuffIn;
        byte[] packetBuffIn = new byte[10000]; // "5 waypoint" trip size < 7000

        reply = new DatagramPacket(packetBuffIn, packetBuffIn.length);
        datagramSocket.receive(reply);
        dataBuffIn = reply.getData();
        ByteArrayInputStream bis = new ByteArrayInputStream(dataBuffIn);
        ObjectInput oi = null;
        oi = new ObjectInputStream(bis);

        result = (RoutePlannerJourney) oi.readObject();

        datagramSocket.close();
        oi.close();
        bis.close();

        return result;
    }
}
