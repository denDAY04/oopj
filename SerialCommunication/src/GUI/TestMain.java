/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.TerminalManager;
import SerialCom.rfidSimulation.RFIDReaderSimpleSimulator;
import SerialCom.protocol.ProjectPacket;
import SerialCom.controller.EventManager;
import SerialCom.serial.SerialTransceiver;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qess
 */
public class TestMain {
    
    
    public static void main(String[] args){
    
            //Construct an RFIDReaderSimpleSimulator object to simulate the RFID Card Reader board
        RFIDReaderSimpleSimulator rFIDReaderSimpleSimulator = new RFIDReaderSimpleSimulator();
        //Construct a SerialTransceiver object, setting the packet protocol and frameEventListener
        //This SerialTransceiver object is for the aVRReaderSimple simulator
        SerialTransceiver aVRTransceiver = new SerialTransceiver(new ProjectPacket(), rFIDReaderSimpleSimulator);
        //Set the transmitter for the AVRReader simulator
        rFIDReaderSimpleSimulator.setTransmitter(aVRTransceiver);

        //Now create a server, that responds to and handles messages from the
        //AVR Card reader simulator

        EventManager eventManager = new EventManager();  
        CustomerManager customerManager = new CustomerManager();
        
        
        
        //Construct another SerialTransceiver for the RFIDEventManager
        SerialTransceiver transceiver = new SerialTransceiver(new ProjectPacket(), eventManager);
        //Set the transmitter for the RFIDManagerSimple
        eventManager.setTransmitter(transceiver);
        
        TerminalManager terminalManager = new TerminalManager(eventManager);
        terminalManager.startPingTimer();

        //Open the RFIDEventManager server port - it waits for messages from
        //the Card Reader
        System.out.println("j-unit: open port:");
        try {
            eventManager.openPort();
        } catch (TooManyListenersException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        //Let the Card Reader simulator connect to the RFIDEventManager server
        System.out.println("j-unit: connect:");
        try {
            rFIDReaderSimpleSimulator.connect();
        } catch (TooManyListenersException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        //Wait for transmission to complete
        System.out.println("j-unit: sleep thread:");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        System.out.println("j-unit: wakeup thread:");
        
        
        //We expect the RFIDEventManager to have received a "03" message
        System.out.println("j-unit: Expect RFIDEventManager to receive 03 (end of handshake)"); // 03 is end of handshake
        String expectedRequest = "03";
        ProjectPacket packet = (ProjectPacket) eventManager.getPacket();
        System.out.print("j-unit: rFIDEventManagerSimple.getPacket.getCommandStatus =");
        String req = packet.getCommandStatus();
        String actualRequest = eventManager.getPacket().getCommandStatus();
        System.out.println(actualRequest);

        //We expect the RFIDManager to have sent a "12" response
        System.out.println("j-unit: Expect to receive 12");
        String expectedResponse = "12";
        System.out.println("j-unit: getPacket().getCommandStatus()");
        String actualResponse = rFIDReaderSimpleSimulator.getPacket().getCommandStatus();

        System.out.println("expReq: " + expectedRequest + " actReq: " + actualRequest);
        System.out.println("expResp: " + expectedResponse + " actResp: " + actualResponse);

        //Now we try to send an RFID and RFID Reader ID
        eventManager.sendResponse("VC", "13370001","12"); //13370001 destination 34
        try {
            //Wait for transmission to complete
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        expectedRequest = "RA";
        actualRequest = eventManager.getPacket().getCommandStatus();

        String expectedData = "Receive Acknowledged";
        ProjectPacket actualPacket = (ProjectPacket) eventManager.getPacket();
        String actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);

        
       // test Ping Pong
        eventManager.sendResponse("PI", "PING","12"); // destination 12 
        try {
            //Wait for transmission to complete
    Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        
                expectedRequest = "PO";
        actualRequest = eventManager.getPacket().getCommandStatus();
        
         expectedData = "PONG";
         actualPacket = (ProjectPacket) eventManager.getPacket();
         actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);
    
     //   while (true) {}  // can test ping terminals function
        
       eventManager.closePort();
       rFIDReaderSimpleSimulator.closePort();
    }
}
