/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;
import SQLDatabase.Managers.TerminalManager;
import SerialCom.protocol.ProjectPacket;
import SerialCom.controller.EventManager;
import SerialCom.serial.SerialTransceiver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ibr
 */
public class RFIDReaderSimpleSimulatorTest {

            EventManager eventManager = new EventManager();  
        CustomerManager customerManager = new CustomerManager();
        DatabaseManager databaseManager = new DatabaseManager();
        TerminalManager terminalManager = new TerminalManager();
        
        RFIDReaderSimpleSimulator rFIDReaderSimpleSimulator = new RFIDReaderSimpleSimulator();

        SerialTransceiver aVRTransceiver = new SerialTransceiver(new ProjectPacket(), rFIDReaderSimpleSimulator);
        SerialTransceiver transceiver = new SerialTransceiver(new ProjectPacket(), eventManager);
 
    
    public RFIDReaderSimpleSimulatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of connect method, of class RFIDReaderSimpleSimulator.
     */
    @Test
    public void testConnect() throws Exception {
        
        rFIDReaderSimpleSimulator.setTransmitter(aVRTransceiver);
        customerManager.setDatabaseManager(databaseManager);         // customer needs databasemanager
        terminalManager.setDatabaseManager(databaseManager);         // terminal manager needs EventManager & DatabaseManager
        terminalManager.setEventManager(eventManager); 
        eventManager.setCustomerManager(customerManager);         // event manager needs customerManager & terminalManager
        eventManager.setTerminalManager(terminalManager);
        eventManager.setTransmitter(transceiver);        



        System.out.println("j-unit: open port:");
        eventManager.openPort();

        //Let the Card Reader simulator connect to the RFIDEventManager server
        System.out.println("j-unit: connect:");
        rFIDReaderSimpleSimulator.connect();

        //Wait for transmission to complete
        System.out.println("j-unit: sleep thread:");
        Thread.sleep(200);
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
        assertTrue(expectedRequest.equals(actualRequest));
        System.out.println("expResp: " + expectedResponse + " actResp: " + actualResponse);
        assertTrue(expectedResponse.equals(actualResponse));

        //Now we try to send an RFID and RFID Reader ID
        rFIDReaderSimpleSimulator.sendRFIDRequest("VC", "13379bfa0ee8","34"); //13379bfa0ee8

        //Wait for transmission to complete
        Thread.sleep(500);
       expectedRequest = "VC";
       actualRequest = rFIDReaderSimpleSimulator.getPacket().getCommandStatus();  
       
       String expectedData = "000100chargingactiveHans";
       String actualData = rFIDReaderSimpleSimulator.getPacket().getData();
       
       System.out.println("actualRequest: "+actualRequest);
       System.out.println("expectedRequest: "+ expectedRequest);
       System.out.println("actualData: "+actualData);
       System.out.println("expectedData: "+ expectedData);
       assertTrue(expectedRequest.equals(actualRequest));
       assertTrue(expectedData.equals(actualData));

       
       
        expectedRequest = "RA";
        actualRequest = eventManager.getPacket().getCommandStatus();

        expectedData = "Receive Acknowledged";
        ProjectPacket actualPacket = (ProjectPacket) eventManager.getPacket();
        actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);
        assertTrue(expectedRequest.equals(actualRequest));
        assertTrue(expectedData.equals(actualData));
        
        
       // test Ping Pong
        eventManager.sendResponse("PI", "PING","34");
        
                //Wait for transmission to complete
        Thread.sleep(500);
        eventManager.closePort();
        rFIDReaderSimpleSimulator.closePort();
        
        expectedRequest = "PO";
        actualRequest = eventManager.getPacket().getCommandStatus();
        
         expectedData = "PONG";
         actualPacket = (ProjectPacket) eventManager.getPacket();
         actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);
        assertTrue(expectedRequest.equals(actualRequest));
        assertTrue(expectedData.equals(actualData));
        
    }
}
