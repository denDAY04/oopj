/**
 * Project Name: SerialComV1
 * Unit Test Name: DepositManagerTest
 * Engineers: Team Awesome 
 * Creation Date: May 19, 2014
 * Test Description:
 */

package SQLDatabase.Managers;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DepositManagerTest {
    DatabaseManager dbManager;
    DepositManager dManager;
    
    public DepositManagerTest() {
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
        dManager = new DepositManager();
        dManager.setDatabaseManager(dbManager);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setDatabaseManager method, of class DepositManager.
     */
//    @Test
//    public void testSetDatabaseManager() {
//        System.out.println("setDatabaseManager");
//        DatabaseManager databaseManager = null;
//        DepositManager instance = new DepositManager();
//        instance.setDatabaseManager(databaseManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getSimpleDeposits method, of class DepositManager.
     */
    @Test
    public void testGetSimpleDeposits() {
        System.out.println("getSimpleDeposits");
        String customerNumb = "1";
        String[] expResult = new String[]{"1","1.0","1.0","**** **** **** 4587"};
        ArrayList<String[]> result = dManager.getSimpleDeposits(customerNumb);
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[2];
        String result3 = result0[3];
        String result4 = result0[4];
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)
                &&expResult[3].equals(result4));
    }

    /**
     * Test of getAllDeposits method, of class DepositManager.
     */
    @Test
    public void testGetAllDeposits() {
        System.out.println("getAllDeposits");
        String[] expResult = new String[]{"1","1","1.0","1.0","15698","**** **** **** 4587"};
        ArrayList<String[]> result = dManager.getAllDeposits();
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[3];
        String result4 = result0[4];
        String result5 = result0[5];
        String result6 = result0[6];
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)
                &&expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6));
    }

    /**
     * Test of getDetailedDeposit method, of class DepositManager.
     */
    @Test
    public void testGetDetailedDeposit() {
        System.out.println("getDetailedDeposit");
        int depositNumb = 1;
        ArrayList<String> expResult = new ArrayList();
        expResult.add("1");
        expResult.add("1.0");
        expResult.add("1.0");
        expResult.add("4587");
        expResult.add("15698");
        ArrayList<String> result = dManager.getDetailedDeposit(depositNumb);
        result.remove(1); //Removes the timestamp
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
     * Test of getDepositsByRefNumber method, of class DepositManager.
     */
    @Test
    public void testGetDepositsByRefNumber() {
        System.out.println("getDepositsByRefNumber");
        String refNumber = "15698";
        String[] expResult = new String[]{"1","1","1.0","1.0","15698","**** **** **** 4587"};
        ArrayList<String[]> result = dManager.getDepositsByRefNumber(refNumber);
        String[] result0 = result.get(0);
        String result1 = result0[0];
        String result2 = result0[1];
        String result3 = result0[3];
        String result4 = result0[4];
        String result5 = result0[5];
        String result6 = result0[6];
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)
                &&expResult[3].equals(result4)&&expResult[4].equals(result5)&&expResult[5].equals(result6));
    }

    /**
     * Test of registerDeposit method, of class DepositManager.
     */
    @Test
    public void testRegisterDeposit() {
        System.out.println("registerDeposit");
        String[] data = new String[]{"1","30000","50000","99999","1234"};
        /*
        * <li>Customer number (int)
    * <li>Amount of DKK deposited (int)
    * <li>New balance after deposit (int)
    * <li>External reference number (int)
    * <li>Last four digits of credit card (int)*/
        dManager.registerDeposit(data);
        String customerNumb = "1";
        String[] expResult = new String[]{"5","300.0","500.0","**** **** **** 1234"};
        ArrayList<String[]> result = dManager.getSimpleDeposits(customerNumb);
        String[] result0 = result.get(2);
        String result1 = result0[0];
        String result2 = result0[2];
        String result3 = result0[3];
        String result4 = result0[4];
        assertTrue(expResult[0].equals(result1)&&expResult[1].equals(result2)&&expResult[2].equals(result3)
                &&expResult[3].equals(result4));
    }

}