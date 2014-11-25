/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans;

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
 * @author Qesss
 */
public class RPJSkel implements RPJInterface, Serializable  {

    @Override
    public RoutePlannerJourney createRouteplannerJourney(int origin, int destination, GregorianCalendar timeDeparture) throws Exception{
        
    final int ServerPort = 44448;
            /*
         Station index:
         0 Ballerup
         1 Malmparken
         2 Skovlunde
         3 Herlev
         4 Husum
         5 Islev
         6 Flintholm
         7 Valby
         8 Enghave
         9 Vesterport
         */
    RoutePlannerJourney result = null;

//try {
            DatagramSocket datagramSocket = new DatagramSocket();
            DatagramPacket outPacket;
            InetAddress address = InetAddress.getByName("thelizard6.eitlab.ihk-edu.dk");
//            GregorianCalendar testtime= new GregorianCalendar();
//            System.err.println(testtime.getTimeInMillis());
           
            
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
//            try {
                result = (RoutePlannerJourney) oi.readObject();
//        } catch (ClassNotFoundException ex) {
//            System.err.println("exception: " + ex);
//        }

            //result.testOutput();
            //System.err.println(result.getWPStopName(1));

            datagramSocket.close();
            oi.close();
            bis.close();
//        } catch (Exception ex) {
//            System.err.println("exception:" + ex);
//        }

      //  if (result == null)         throw new NullPointerException();
        
        
        return result;
                //RoutePlannerJourneyManager.CreateRoutePlannerJourney(waypoints, new GregorianCalendar(2014,11,15,16,18), new GregorianCalendar(2014,11,15,15,17), 4);
    }
}
