/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HardwareSim;

import SQLDatabase.Managers.BillingManager;
import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;
import SQLDatabase.Managers.DepositManager;
import SQLDatabase.Managers.TerminalManager;
import SQLDatabase.ModelClasses.Customer;
import SQLDatabase.ModelClasses.Terminal;
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
public class HardwareSimulator_J_Unit_Test {

        EventManager eventManager = new EventManager();  
        CustomerManager customerManager = new CustomerManager();
        DatabaseManager databaseManager = new DatabaseManager();
        TerminalManager terminalManager = new TerminalManager();
        BillingManager billingManager = new BillingManager();
        DepositManager depositManager = new DepositManager();
        
        HardwareSimulator hardwareSimulator = new HardwareSimulator();

        SerialTransceiver aVRTransceiver = new SerialTransceiver(new ProjectPacket(), hardwareSimulator);
        SerialTransceiver transceiver = new SerialTransceiver(new ProjectPacket(), eventManager);
        
    
    public HardwareSimulator_J_Unit_Test() {
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
     * Test of connect method, of class HardwareSimulator.
     */
    @Test
    public void testConnect() throws Exception {
        
        hardwareSimulator.setTransmitter(aVRTransceiver);
        customerManager.setDatabaseManager(databaseManager);         // customer needs databasemanager
        terminalManager.setDatabaseManager(databaseManager);         // terminal manager needs EventManager & DatabaseManager
        terminalManager.setEventManager(eventManager); 
        eventManager.setCustomerManager(customerManager);         // event manager needs customerManager & terminalManager
        eventManager.setTerminalManager(terminalManager);
        eventManager.setTransmitter(transceiver);        
        eventManager.setBillingManager(billingManager);
        billingManager.setDatabaseManager(databaseManager);
        depositManager.setDatabaseManager(databaseManager);

        // open ports
        System.out.println("j-unit: open port:");
        eventManager.openPort();
        
//----------------------------- Test Hand Shake -----------------------------//
        //Let the Card Reader simulator connect to the RFIDEventManager server
        System.out.println("j-unit: connect:");
        hardwareSimulator.connect();

        //Wait for transmission to complete
        System.out.println("j-unit: sleep thread:");
        Thread.sleep(200);
        System.out.println("j-unit: wakeup thread:");
        
        
        //We expect the EventManager to have received a "03" message
        System.out.println("j-unit: Expect EventManager to receive 03 (end of handshake)"); // 03 is end of handshake
        String expectedRequest = "03";
        ProjectPacket packet = (ProjectPacket) eventManager.getPacket();
        System.out.print("j-unit: eventManager.getPacket.getCommandStatus =");
        String req = packet.getCommandStatus();
        String actualRequest = eventManager.getPacket().getCommandStatus();
        System.out.println(actualRequest);

        //We expect the RFIDManager to have sent a "12" response
        System.out.println("j-unit: Expect to receive 12");
        String expectedResponse = "12";
        System.out.println("j-unit: getPacket().getCommandStatus()");
        String actualResponse = hardwareSimulator.getPacket().getCommandStatus();

        System.out.println("expReq: " + expectedRequest + " actReq: " + actualRequest);
        assertTrue(expectedRequest.equals(actualRequest));
        System.out.println("expResp: " + expectedResponse + " actResp: " + actualResponse);
        assertTrue(expectedResponse.equals(actualResponse));

//----------------------------- Test Verify Customer -----------------------------//        
        
       /* Decrypt card numder */
       String PincardNumb = "13379bfa0ee8";
       char[] PincardNumbArr = new char[12];
       for (int i = 0; i < 12; ++i) {
            PincardNumbArr[i] = PincardNumb.charAt(i);
            PincardNumbArr[i] += 15;            // Encryption number
       }
       String encPincardNumb = new StringBuilder().append(PincardNumbArr).toString();
        
       //Now we try to send a pin number and RFID ID
       hardwareSimulator.sendRequest("VC", encPincardNumb,"34"); //13379bfa0ee8

       //Wait for transmission to complete
       Thread.sleep(500);
       expectedRequest = "VC";
       actualRequest = hardwareSimulator.getPacket().getCommandStatus();  
       
       String expectedData = "000500000000IDLEACTIVEHans";
       String actualData = hardwareSimulator.getPacket().getData();
       
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
        
//----------------------------- Test Ping Terminal -----------------------------//        
       // test Ping Pong
        eventManager.sendResponse("PI", "PING","34");
        
        //Wait for transmission to complete
        Thread.sleep(500);
        
        expectedRequest = "PO";
        actualRequest = eventManager.getPacket().getCommandStatus();
        
        expectedData = "PONG";
        actualPacket = (ProjectPacket) eventManager.getPacket();
        actualData = actualPacket.getData();
        System.out.println("actualRequest: "+actualRequest);
        System.out.println("expectedRequest: "+ expectedRequest);
        assertTrue(expectedRequest.equals(actualRequest));
        assertTrue(expectedData.equals(actualData));
     
//----------------------------- Test Charging Started -----------------------------//

        hardwareSimulator.sendRequest("CS", "9bfa0ee8","34"); //13379bfa0ee8        
        
        //Wait for transmission to complete
        Thread.sleep(500);  
        actualRequest = eventManager.getPacket().getCommandStatus();  // read the reply package.
        // check that the database locked the customer and the charging station
        Customer testcustomer = customerManager.getCustomer("9bfa0ee8");
        String useStatus = testcustomer.getUseStatus();
        Terminal testterminal = terminalManager.getTerminal("1");
        String TerminalStatus = testterminal.getChargingStatus();

        String expecteduseStaus = "CHAR";
        String expectedTerminalStatus = "CHAR";

        System.out.println("expecteduseStaus: "+expecteduseStaus);
        System.out.println("expectedTerminalStatus: "+ expectedTerminalStatus);
        System.out.println("useStaus: "+useStatus);
        System.out.println("TerminalStatus: "+ TerminalStatus);        
        assertTrue(expecteduseStaus.equals(useStatus));
        assertTrue(expectedTerminalStatus.equals(TerminalStatus));
        
//----------------------------- Test Charging Completed -----------------------------//

        String CCdata = "9bfa0ee80000053324710000002014-01-01 01:01:252014-01-01 01:01:34";
        hardwareSimulator.sendRequest("CC", CCdata,"34"); //13379bfa0ee8                
        //Wait for transmission to complete
        Thread.sleep(500);  
        actualRequest = eventManager.getPacket().getCommandStatus();  // read the reply package.
        // check that the database unlocked the customer and the charging station
        testcustomer = customerManager.getCustomer("9bfa0ee8");
        useStatus = testcustomer.getUseStatus();
        testterminal = terminalManager.getTerminal("1");
        TerminalStatus = testterminal.getChargingStatus();
        expecteduseStaus = "IDLE";
        expectedTerminalStatus = "IDLE";

        System.out.println("expecteduseStaus: "+expecteduseStaus);
        System.out.println("expectedTerminalStatus: "+ expectedTerminalStatus);
        System.out.println("useStaus: "+useStatus);
        System.out.println("TerminalStatus: "+ TerminalStatus);        
        assertTrue(expecteduseStaus.equals(useStatus));
        assertTrue(expectedTerminalStatus.equals(TerminalStatus));

        // Close ports
        eventManager.closePort();
        hardwareSimulator.closePort();
    }
}
