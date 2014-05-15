/**
 * Project Name: SerialComV1
 * Unit Test Name: CustomerTest
 * Engineers: Team Awesome 
 * Creation Date: May 15, 2014
 * Test Description:
 */

package SQLDatabase.ModelClasses;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    
    Customer instance;
    public CustomerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String customerNumb = "123";
        String pin = "1234";
        String password = "password";
        String cardNumb = "abcd";
        String firstname = "Hans";
        String lastname = "Hansen";
        String road = "vej 1";
        String zipCode = "2730";
        String email = "hans@hansen.dk";
        String phoneNumb = "12345678";
        int balance = 100;
        String accountStatus = "Active";
        String useStatus = "Idle";
        instance = new Customer(customerNumb, pin, password, cardNumb, firstname, lastname, road, zipCode, email,
                    phoneNumb, balance, accountStatus, useStatus);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerNumb method, of class Customer.
     */
    @Test
    public void testGetCustomerNumb() {
        System.out.println("getCustomerNumb");
        String expResult = "123";
        String result = instance.getCustomerNumb();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setCustomerNumb method, of class Customer.
     */
    @Test
    public void testSetCustomerNumb() {
        System.out.println("setCustomerNumb");
        String customerNumb = "234";
        instance.setCustomerNumb(customerNumb);
        assertTrue(customerNumb.equals(instance.getCustomerNumb()));
    }

    /**
     * Test of getPin method, of class Customer.
     */
    @Test
    public void testGetPin() {
        System.out.println("getPin");
        String expResult = "1234";
        String result = instance.getPin();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPin method, of class Customer.
     */
    @Test
    public void testSetPin() {
        System.out.println("setPin");
        String pin = "2345";
        instance.setPin(pin);
        assertTrue(pin.equals(instance.getPin()));
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "password";
        String result = instance.getPassword();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPassword method, of class Customer.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "wordpass";
        instance.setPassword(password);
        assertTrue(password.equals(instance.getPassword()));
    }

    /**
     * Test of getCardNumb method, of class Customer.
     */
    @Test
    public void testGetCardNumb() {
        System.out.println("getCardNumb");
        String expResult = "abcd";
        String result = instance.getCardNumb();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setCardNumb method, of class Customer.
     */
    @Test
    public void testSetCardNumb() {
        System.out.println("setCardNumb");
        String cardNumb = "bcde";
        instance.setCardNumb(cardNumb);
        assertTrue(cardNumb.equals(instance.getCardNumb()));
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Hans";
        String result = instance.getFirstName();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Gretel";
        instance.setFirstName(firstName);
        assertTrue(firstName.equals(instance.getFirstName()));
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Hansen";
        String result = instance.getLastName();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setLastName method, of class Customer.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Jensen";
        instance.setLastName(lastName);
        assertTrue(lastName.equals(instance.getLastName()));
    }

    /**
     * Test of getRoad method, of class Customer.
     */
    @Test
    public void testGetRoad() {
        System.out.println("getRoad");
        String expResult = "vej 1";
        String result = instance.getRoad();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setRoad method, of class Customer.
     */
    @Test
    public void testSetRoad() {
        System.out.println("setRoad");
        String road = "vej 2";
        instance.setRoad(road);
        assertTrue(road.equals(instance.getRoad()));
    }

    /**
     * Test of getZipCode method, of class Customer.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        String expResult = "2730";
        String result = instance.getZipCode();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setZipCode method, of class Customer.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        String zipCode = "2750";
        instance.setZipCode(zipCode);
        assertTrue(zipCode.equals(instance.getZipCode()));
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "hans@hansen.dk";
        String result = instance.getEmail();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "gretel@jensen.dk";
        instance.setEmail(email);
        assertTrue(email.equals(instance.getEmail()));
    }

    /**
     * Test of getPhoneNumb method, of class Customer.
     */
    @Test
    public void testGetPhoneNumb() {
        System.out.println("getPhoneNumb");
        String expResult = "12345678";
        String result = instance.getPhoneNumb();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPhoneNumb method, of class Customer.
     */
    @Test
    public void testSetPhoneNumb() {
        System.out.println("setPhoneNumb");
        String phoneNumb = "23456789";
        instance.setPhoneNumb(phoneNumb);
        assertTrue(phoneNumb.equals(instance.getPhoneNumb()));
    }

    /**
     * Test of getBalance method, of class Customer.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        int expResult = 100;
        int result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBalance method, of class Customer.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        int balance = 200;
        instance.setBalance(balance);
        assertEquals(balance, instance.getBalance());
    }

    /**
     * Test of getAccountStatus method, of class Customer.
     */
    @Test
    public void testGetAccountStatus() {
        System.out.println("getAccountStatus");
        String expResult = "Active";
        String result = instance.getAccountStatus();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setAccountStatus method, of class Customer.
     */
    @Test
    public void testSetAccountStatus() {
        System.out.println("setAccountStatus");
        String accountStatus = "Disabled";
        instance.setAccountStatus(accountStatus);
        assertTrue(accountStatus.equals(instance.getAccountStatus()));
    }

    /**
     * Test of getUseStatus method, of class Customer.
     */
    @Test
    public void testGetUseStatus() {
        System.out.println("getUseStatus");
        String expResult = "Idle";
        String result = instance.getUseStatus();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setUseStatus method, of class Customer.
     */
    @Test
    public void testSetUseStatus() {
        System.out.println("setUseStatus");
        String useStatus = "Char";
        instance.setUseStatus(useStatus);
        assertTrue(useStatus.equals(instance.getUseStatus()));
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Hans, Hansen, hans@hansen.dk";
        String result = instance.toString();
        assertTrue(expResult.equals(result));
    }
}