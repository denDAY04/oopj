/**
 * Project Name: SerialComV1
 * Unit Test Name: TerminalManagerTest
 * Engineers: Team Awesome 
 * Creation Date: May 19, 2014
 * Test Description:
 */

package SQLDatabase.Managers;

import SQLDatabase.ModelClasses.Terminal;
import SerialCom.controller.EventManager;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TerminalManagerTest {
    DatabaseManager dbManager;
    TerminalManager tManager;
    
    public TerminalManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbManager = new DatabaseManager();
        tManager = new TerminalManager();
        tManager.setDatabaseManager(dbManager);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setDatabaseManager method, of class TerminalManager.
     */
//    @Test
//    public void testSetDatabaseManager() {
//        System.out.println("setDatabaseManager");
//        DatabaseManager databaseManager = null;
//        TerminalManager instance = new TerminalManager();
//        instance.setDatabaseManager(databaseManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEventManager method, of class TerminalManager.
//     */
//    @Test
//    public void testSetEventManager() {
//        System.out.println("setEventManager");
//        EventManager eventManager = null;
//        TerminalManager instance = new TerminalManager();
//        instance.setEventManager(eventManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of addTerminal method, of class TerminalManager.
     */
    @Test
    public void testAddTerminal() {
        System.out.println("addTerminal");
        String road = "vejen 1";
        String zipCode = "1234";
        String ipAddress = "99";
        tManager.addTerminal(road, zipCode, ipAddress);
        String terminalID = "4";
        Terminal expResult = new Terminal("4","vejen 1","1234","99","PENDEP","IDLE","ONLINE");
        Terminal result = tManager.getTerminal(terminalID);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of editTerminal method, of class TerminalManager.
     */
    @Test
    public void testEditTerminal() {
        System.out.println("editTerminal");
        String terminalID = "1";
        int command = 4;
        String installStatus = "DISABL";
        String chargingStatus = "";
        tManager.editTerminal(terminalID, command, installStatus, chargingStatus);
        Terminal expResult = new Terminal("1","vejen 4","2750","12","DISABL","CHAR","ONLINE");
        Terminal result = tManager.getTerminal(terminalID);
        assertTrue(expResult.equals(result));
        installStatus = "ENABLE";
        tManager.editTerminal(terminalID, command, installStatus, chargingStatus);
    }

    /**
     * Test of editFullTerminal method, of class TerminalManager.
     */
//    @Test
//    public void testEditFullTerminal() {
//        System.out.println("editFullTerminal");
//        String[] newValues = null;
//        int terminalID = 0;
//        TerminalManager instance = new TerminalManager();
//        instance.editFullTerminal(newValues, terminalID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getTerminal method, of class TerminalManager.
     */
    @Test
    public void testGetTerminal() {
        System.out.println("getTerminal");
        String terminalID = "1";
        Terminal expResult = new Terminal("1","vejen 4","2750","12","ENABLE","CHAR","ONLINE");
        Terminal result = tManager.getTerminal(terminalID);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getTerminalByIP method, of class TerminalManager.
     */
    @Test
    public void testGetTerminalByIP() {
        System.out.println("getTerminalByIP");
        String terminalIP = "12";
        Terminal expResult = new Terminal("1","vejen 4","2750","12","ENABLE","CHAR","ONLINE");
        Terminal result = tManager.getTerminalByIP(terminalIP);
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getAllTerminals method, of class TerminalManager.
     */
    @Test
    public void testGetAllTerminals() {
        System.out.println("getAllTerminals");
        String[] expResult = new String[]{"1","vejen 4","2750","CHAR","ONLINE","12","ENABLE"};
        ArrayList<String[]> result = tManager.getAllTerminals();
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[2];
        String result4 = result0[3];
        String result5 = result0[4];
        String result6 = result0[5];
        String result7 = result0[6];
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)&&
                expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6)&&
                expResult[6].equals(result7));
    }

    /**
     * Test of connectionFailed method, of class TerminalManager.
     */
    @Test
    public void testConnectionFailed() {
        System.out.println("connectionFailed");
        String terminalIP = "12";
        String expResult = tManager.getTerminalByIP(terminalIP).getOfflineSince();
        System.err.println(expResult);
        tManager.connectionFailed(terminalIP);
        String result = tManager.getTerminalByIP(terminalIP).getOfflineSince();
        System.err.println(result);
        assertTrue(!expResult.equals(result));
        tManager.editTerminal(terminalIP, 2, "", "");
    }

    /**
     * Test of connectionSuccessful method, of class TerminalManager.
     */
    @Test
    public void testConnectionSuccessful() {
        System.out.println("connectionSuccessful");
        String terminalIP = "12";
        tManager.connectionFailed(terminalIP);
        String expResult = tManager.getTerminalByIP(terminalIP).getOfflineSince();
        System.err.println(expResult);
        tManager.connectionSuccessful(terminalIP);
        String result = tManager.getTerminalByIP(terminalIP).getOfflineSince();
        System.err.println(result);
        assertTrue(!expResult.equals(result));
    }

    /**
     * Test of startPingSchedule method, of class TerminalManager.
     */
//    @Test
//    public void testStartPingSchedule() {
//        System.out.println("startPingSchedule");
//        TerminalManager instance = new TerminalManager();
//        instance.startPingSchedule();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setTerminalChargingStatus method, of class TerminalManager.
     */
    @Test
    public void testSetTerminalChargingStatus() {
        System.out.println("setTerminalChargingStatus");
        String terminalID = "1";
        String status = "IDLE";
        tManager.setTerminalChargingStatus(terminalID, status);
        String result = tManager.getTerminal(terminalID).getChargingStatus();
        assertTrue(status.equals(result));
        tManager.setTerminalChargingStatus(terminalID, "CHAR");
    }

}