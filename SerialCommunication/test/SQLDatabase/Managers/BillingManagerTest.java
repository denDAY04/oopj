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
        int BillingAmount = 10000;
        int BillingRate = 1050;
        int BillingKWH = 7530;
        int newBalance = 5040;
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
        String[] expResult = new String[]{"1","100.0","50.4"};
        ArrayList<String[]> result = bManager.getSimpleBillings(customerNumb);
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[2];
        String result3 = result0[3];  
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3));
    }

    /**
     * Test of getAllBillings method, of class BillingManager.
     */
    @Test
    public void testGetAllBillings() {
        System.out.println("getAllBillings");
        String[] expResult = new String[]{"1","1","2","2014-03-24 13:10:02","100.0","10.5","7530.0","50.4"};
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
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)&&
                expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6)&&
                expResult[6].equals(result7)&&expResult[7].equals(result8));
    }

    /**
     * Test of getDetailedBilling method, of class BillingManager.
     */
    @Test
    public void testGetDetailedBilling() {
        System.out.println("getDetailedBilling");
        int transactionNumber = 1;
        ArrayList<String> expResult = new ArrayList();
        expResult.add("1");
        expResult.add("2014-03-24 13:10:02.047");
        expResult.add("2014-03-24 16:10:02.047");
        expResult.add("100.0");
        expResult.add("10.5");
        expResult.add("7530.0");
        expResult.add("50.4");
        ArrayList<String> result = bManager.getDetailedBilling(transactionNumber);
        result.remove(9); //removes check for zipcode
        result.remove(8); //removes check for address
        result.remove(3); //removes check for received at server timestamp
        boolean noErrorDetected = true;
        for (int i=0;i<result.size();i++){       
            if(expResult.get(i).equals(result.get(i))){
                noErrorDetected = true;
            } else{
                noErrorDetected = false;
                break;
            }
        }
        assertTrue(noErrorDetected);
    }

    /**
     * Test of getBillingsByTransactionNumb method, of class BillingManager.
     */
    @Test
    public void testGetBillingsByTransactionNumb() {
        System.out.println("getBillingsByTransactionNumb");
        String transactionNumb = "1";
        String[] expResult = new String[]{"1","1","2","2014-03-24 13:10:02","100.0","10.5","7530.0","50.4"};
        ArrayList<String[]> result = bManager.getBillingsByTransactionNumb(transactionNumb);
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[2];
        String result4 = result0[3]; 
        String result5 = result0[4];
        String result6 = result0[5];
        String result7 = result0[6];
        String result8 = result0[7];     
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)&&
                expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6)&&
                expResult[6].equals(result7)&&expResult[7].equals(result8));
    }

    /**
     * Test of registerBilling method, of class BillingManager.
     */
    @Test
    public void testRegisterBilling() {
        System.out.println("registerBilling");
        String[] data = new String[]{"1","2","2014-05-19 09:21:02.047","2014-05-19 09:23:02.047","12000","1050","8200","5000"};
        bManager.registerBilling(data);
        String customerNumb = "1";
        String[] expResult = new String[]{"5","120.0","50.0"};
        ArrayList<String[]> result = bManager.getSimpleBillings(customerNumb);
        String[] result0 = result.get(2);
        String result1 = result0[0];
        String result2 = result0[2];
        String result3 = result0[3];    
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3));
        //assertTrue(true);
    }
}