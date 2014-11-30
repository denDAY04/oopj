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
 * @author Rasmus
 */
public class RPJSkel implements RPJInterface, Serializable  {

    @Override
    public RoutePlannerJourney createRouteplannerJourney(int origin, int destination, GregorianCalendar timeDeparture) throws Exception{
    
    // test
    //timeDeparture.set(GregorianCalendar.HOUR_OF_DAY, 12);
    //timeDeparture.set(GregorianCalendar.MINUTE, 00);
       
    final int ServerPort = 44448;

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
    }
}
