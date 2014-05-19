/**
 * Project Name: SerialComV1
 * Unit Test Name: CustomerManagerTest
 * Engineers: Team Awesome 
 * Creation Date: May 15, 2014
 * Test Description:
 */

package SQLDatabase.Managers;

import SQLDatabase.ModelClasses.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerManagerTest {
    DatabaseManager dbManager;
    CustomerManager cManager;
    Customer customer;

    public CustomerManagerTest() {
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
        cManager = new CustomerManager();
        cManager.setDatabaseManager(dbManager);
        
        String customerNumb = "1";
        String pin = "1337";
        String password = "password";
        String cardNumb = "9bfa0ee8";
        String firstname = "Hans";
        String lastname = "Hansen";
        String road = "vej 4";
        String zipCode = "2730";
        String email = "hans@hansen.dk";
        String phoneNumb = "25302308";
        int balance = 10000;
        String accountStatus = "ACTIVE";
        String useStatus = "IDLE";
        customer = new Customer(customerNumb, pin, password, cardNumb, firstname, lastname, road, zipCode, email,
                    phoneNumb, balance, accountStatus, useStatus);
    }

    @After
    public void tearDown() {
    }

//    /**
//     * Test of setDatabaseManager method, of class CustomerManager.
//     */
//    @Test
//    public void testSetDatabaseManager() {
//        System.out.println("setDatabaseManager");
//        DatabaseManager databaseManager = null;
//        CustomerManager instance = new CustomerManager();
//        instance.setDatabaseManager(databaseManager);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getLoggedInUser method, of class CustomerManager.
     */
//    @Test
//    public void testGetLoggedInUser() {
//        System.out.println("getLoggedInUser");
//        CustomerManager instance = new CustomerManager();
//        Customer expResult = null;
//        Customer result = instance.getLoggedInUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of setLoggedInUser method, of class CustomerManager.
//     */
//    @Test
//    public void testSetLoggedInUser() {
//        System.out.println("setLoggedInUser");
//        Customer user = null;
//        CustomerManager instance = new CustomerManager();
//        instance.setLoggedInUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of verifyCustomer method, of class CustomerManager.
     */
    @Test
    public void testVerifyCustomer() {
        System.err.println("verifyCustomer");
        String cardNumb = "9bfa0ee8";
        String pin = "1337";
        Customer expResult = customer;
        Customer result = cManager.verifyCustomer(cardNumb, pin);
        if (expResult.equals(result)){
            assertTrue(true);
        } else{
            assertTrue(false);
        }
    }

    /**
     * Test of loggedInAs method, of class CustomerManager.
     */
    @Test
    public void testLoggedInAs() {
        System.err.println("loggedInAs");
        String email = "hans@hansen.dk";
        String password = "password";
        boolean result = cManager.loggedInAs(email, password);
        assertTrue(result);
    }

    /**
     * Test of admLoggedInAs method, of class CustomerManager.
     */
    @Test
    public void testAdmLoggedInAs() {
        System.err.println("admLoggedInAs");
        String email = "hans@hansen.dk";
        boolean result = cManager.admLoggedInAs(email);
        assertTrue(result);
    }

    /**
     * Test of updateLoggedInCustomer method, of class CustomerManager.
     */
    @Test
    public void testUpdateLoggedInCustomer() {
        System.err.println("updateLoggedInCustomer");
        String customerNumb = "1";
        boolean result = cManager.updateLoggedInCustomer(customerNumb);
        assertTrue(result);
    }

    /**
     * Test of updateCustomerInformation method, of class CustomerManager.
     */
    @Test
    public void testUpdateCustomerInformation() {
        System.err.println("updateCustomerInformation");
        String customerID = "9bfa0ee8";
        int command = 1;
        String[] newValues = new String[1];
        newValues[0] = "CHAR";
        cManager.updateCustomerInformation(customerID, command, newValues);
        Customer result = cManager.getCustomer("9bfa0ee8");
        assertTrue(result.getUseStatus().equals("CHAR"));
        customerID = "9bfa0ee8";
        newValues[0] = "IDLE";
        command = 1;
        cManager.updateCustomerInformation(customerID, command, newValues);
    }

    /**
     * Test of addNewCustomer method, of class CustomerManager.
     */
    @Test
    public void testAddNewCustomer() {
        System.out.println("addNewCustomer");
        String[] information = new String[8];
        information[0] = "test";
        information[1] = "Test";
        information[2] = "Tester";
        information[3] = "testvej";
        information[4] = "1234";
        information[5] = "test@test.dk";
        information[6] = "12345678";
        information[7] = "2000";        
        cManager.addNewCustomer(information);
        String resultName = cManager.getCustomerByEmail("test@test.dk").getFirstName();
        String resultName2 = cManager.getCustomerByEmail("test@test.dk").getLastName();
        String expName = "Test";
        String expName2 = "Tester";
        assertTrue(expName.equals(resultName) && expName2.equals(resultName2));
    }

    /**
     * Test of getCustomer method, of class CustomerManager.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String cardNumb = "9bfa0ee8";
        Customer expResult = customer;
        Customer result = cManager.getCustomer(cardNumb);
        System.err.println("**************************************** "+result.getUseStatus());
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getCustomerByEmail method, of class CustomerManager.
     */
    @Test
    public void testGetCustomerByEmail() {
        System.out.println("getCustomerByEmail");
        String email = "hans@hansen.dk";
        Customer expResult = customer;
        Customer result = cManager.getCustomerByEmail(email);
        System.err.println("**************************************** "+result.getUseStatus());
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of getCustomersByFirstName method, of class CustomerManager.
     */
    @Test
    public void testGetCustomersByFirstName() {
        System.out.println("getCustomersByFirstName");
        String firstName = "Hans";
        String expResult = "Hans Hansen, hans@hansen.dk";
        String expResult2 = "Hans Jensen, hansemand@hotmail.com";
        ArrayList result = cManager.getCustomersByFirstName(firstName);
        assertTrue(expResult.equals(result.get(0)) && expResult2.equals(result.get(1)));
    }

}