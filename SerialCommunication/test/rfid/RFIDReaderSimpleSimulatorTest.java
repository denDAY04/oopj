/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rfid;

import SerialCom.rfidSimulation.RFIDReaderSimpleSimulator;
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
        //Construct an RFIDReaderSimpleSimulator object to simulate the RFID Card Reader board
        RFIDReaderSimpleSimulator rFIDReaderSimpleSimulator = new RFIDReaderSimpleSimulator();
        //Construct a SerialTransceiver object, setting the packet protocol and frameEventListener
        //This SerialTransceiver object is for the aVRReaderSimple simulator
        SerialTransceiver aVRTransceiver = new SerialTransceiver(new ProjectPacket(), rFIDReaderSimpleSimulator);
        //Set the transmitter for the AVRReader simulator
        rFIDReaderSimpleSimulator.setTransmitter(aVRTransceiver);

        //Now create a server, that responds to and handles messages from the
        //AVR Card reader simulator
        EventManager rFIDEventManagerSimple = new EventManager();
        //Construct another SerialTransceiver for the RFIDEventManager
        SerialTransceiver rFIDEventManagerTransceiver = new SerialTransceiver(new ProjectPacket(), rFIDEventManagerSimple);
        //Set the transmitter for the RFIDManagerSimple
        rFIDEventManagerSimple.setTransmitter(rFIDEventManagerTransceiver);

        //Open the RFIDEventManager server port - it waits for messages from
        //the Card Reader
        System.out.println("j-unit: open port:");
        rFIDEventManagerSimple.openPort();

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
        ProjectPacket packet = (ProjectPacket) rFIDEventManagerSimple.getPacket();
        System.out.print("j-unit: rFIDEventManagerSimple.getPacket.getCommandStatus =");
        String req = packet.getCommandStatus();
        String actualRequest = rFIDEventManagerSimple.getPacket().getCommandStatus();
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
        rFIDReaderSimpleSimulator.sendRFIDRequest("VC", "13370001"); //13370001

        //Wait for transmission to complete
        Thread.sleep(500);
        rFIDEventManagerSimple.closePort();
        rFIDReaderSimpleSimulator.closePort();

        expectedRequest = "03";
        actualRequest = rFIDEventManagerSimple.getPacket().getCommandStatus();



        String expectedData = "AcceptAck";
        ProjectPacket actualPacket = (ProjectPacket) rFIDEventManagerSimple.getPacket();
        String actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);
        assertTrue(expectedRequest.equals(actualRequest));
        assertTrue(expectedData.equals(actualData));
    }
}
