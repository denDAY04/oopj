/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import ModelClasses.Customer;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathias
 */
public class CustomerBeanTest {

    public CustomerBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class CustomerBean.
     */
    @Test
    public void testLogin() {
        System.err.println("Testing method: Login");
        try{
            CustomerBean bean = new CustomerBean();
            //bean.setFirstName("a");
            //bean.setLastName("a");
            bean.setEmail("a@a.a");
            bean.setPassword("a");
            
            boolean expResult = true;
            boolean result;
            System.err.println("Trying to login...");
            try {
                result = bean.login();
                System.err.println(result);
                assertEquals(expResult, result);
            } catch (RemoteException ex) {
                result = false;
                fail("RMI Registry not found");
            }
            } catch(Exception e){
            e.printStackTrace();
            System.err.println("Could not find RMI server...");
        }
        
    }

    /**
     * Test of signUp method, of class CustomerBean.
     */
    @Test
    public void testSignUp() {
        System.err.println("Test method: SignUp");
        try{
            CustomerBean bean = new CustomerBean();
            bean.setFirstName("George");
            bean.setLastName("Washington");
            bean.setEmail("georgy@us.org");
            bean.setPassword("usababy");
            
            boolean expResult = true;
            boolean result;
            System.err.println("Trying to sign up...");
            try {
                result = bean.signUp();
                System.err.println(result);
                assertEquals(expResult, result);
            } catch (RemoteException ex) {
                result = false;
                fail("RMI Registry not found");
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Could not find RMI server...");
        }
    }

    /**
     * Test of changeDetails method, of class CustomerBean.
     */
    @Test
    public void testChangeDetails() throws Exception {
        System.err.println("Test method: ChangeDetails");
        try{
            CustomerBean bean = new CustomerBean();
            bean.setFirstName("Aa");
            bean.setLastName("Aa");
            bean.setEmail("a@a.a");
            bean.setPassword("blah");
            bean.setCustomerNumber(9);

            boolean expResult = true;
            boolean result;
            System.err.println("Trying to update info...");
            try {
                result = bean.changeDetails();
                System.err.println(result);
                assertEquals(expResult, result);
            } catch (RemoteException ex) {
                result = false;
                fail("RMI Registry not found");
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Could not find RMI server...");
        }
    }

    
    
}
