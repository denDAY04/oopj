/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;

import SQLDatabase.ModelClasses.Billing;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathias Rasmussen
 */
public class BillingManagerTest {
    DatabaseManager dbManager;
    BillingManager bManager;
    Billing billing;
    
    public BillingManagerTest() {
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
        bManager = new BillingManager();
        bManager.setDatabaseManager(dbManager);
        
        String transactionNumb = "1";
        String customerNumb = "1";
        String hardwareNumb = "2";
        String startCharge = "2014-03-24 13:10:02.047";
        String endCharge = "2014-03-24 16:10:02.047";
        String recieved = "2014-05-18 17:36:10.478";
        double BillingAmount = 10000;
        double BillingRate = 1050;
        double BillingKWH = 7530;
        double newBalance = 5040;
        billing = new Billing(transactionNumb, customerNumb, hardwareNumb, startCharge, 
                endCharge, recieved, BillingAmount, BillingRate, BillingKWH, newBalance);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDatabaseManager method, of class BillingManager.
     */
//    @Test
//    public void testSetDatabaseManager() {
//        System.out.println("setDatabaseManager");
//        DatabaseManager databaseManager = null;
//        BillingManager instance = new BillingManager();
//        instance.setDatabaseManager(databaseManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSimpleBillings method, of class BillingManager.
     */
    @Test
    public void testGetSimpleBillings() {
        System.out.println("getSimpleBillings");
        String customerNumb = "1";
        String[] expResult = new String[]{"1","2014-05-18 17:36:10.478","100.0","50.4"};
        ArrayList<String[]> result = bManager.getSimpleBillings(customerNumb);
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[2];
        String result4 = result0[3];                   
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)&&
                expResult[3].equals(result4));
    }

    /**
     * Test of getAllBillings method, of class BillingManager.
     */
    @Test
    public void testGetAllBillings() {
        System.out.println("getAllBillings");
        String[] expResult = new String[]{"1","1","2","2014-03-24 13:10:02","2014-03-24 16:10:02","100.0","10.5","75.3","50.4"};
        ArrayList<String[]> result = bManager.getAllBillings();
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[2];
        String result4 = result0[3]; 
        String result5 = result0[4];
        String result6 = result0[5];
        String result7 = result0[6];
        String result8 = result0[7]; 
        String result9 = result0[8];
        
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)&&
                expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6)&&
                expResult[6].equals(result7)&&expResult[7].equals(result8)&&expResult[8].equals(result9));
    }

    /**
     * Test of getDetailedBilling method, of class BillingManager.
     */
    @Test
    public void testGetDetailedBilling() {
        System.out.println("getDetailedBilling");
        int transactionNumber = 0;
        BillingManager instance = new BillingManager();
        ArrayList expResult = null;
        ArrayList result = instance.getDetailedBilling(transactionNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBillingsByTransactionNumb method, of class BillingManager.
     */
    @Test
    public void testGetBillingsByTransactionNumb() {
        System.out.println("getBillingsByTransactionNumb");
        String transactionNumb = "";
        BillingManager instance = new BillingManager();
        ArrayList expResult = null;
        ArrayList result = instance.getBillingsByTransactionNumb(transactionNumb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerBilling method, of class BillingManager.
     */
    @Test
    public void testRegisterBilling() {
        System.out.println("registerBilling");
        String[] data = null;
        BillingManager instance = new BillingManager();
        instance.registerBilling(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}