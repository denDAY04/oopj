package JUnit;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import java.sql.Timestamp;
import MachineLogic.CreatedTickets;
import MachineLogic.ShoppingBasket;
import MachineLogic.Statistics;

/**
 * The test class JUnit_test_Shopping_basket.
 */
public class JUnit_test_Shopping_basket
{

    
    /**
     * Default constructor for test class JUnit_test_Shopping_basket
     */
    public JUnit_test_Shopping_basket() {}

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
    
    /**
     * Test intToFourChar
     *
     */
    @Test
    public void testIntToFourChar() {
        //Create instances of logic classes
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        /* Test method from ShoppingBasket that converts a string into 
        four chars with whitespaces.*/
        assertEquals("   2", sBasket.intToFourChar(2));
        assertEquals("1234", sBasket.intToFourChar(12345));
        assertEquals("   0", sBasket.intToFourChar(0));
        assertEquals("  -1", sBasket.intToFourChar(-1));
        
   
    }
    
    /**
     * Test convertTo8Length
     */
    @Test
    public void testConvertTo8Lenght(){
        //Create instances of logic classes
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        /* Test method from ShoppingBasket that converts a string into 
        eight char with whitespaces.*/     
        assertEquals("       2", sBasket.convertTo8Length("2"));
        assertEquals("   12345", sBasket.convertTo8Length("12345"));
        assertEquals("12345678", sBasket.convertTo8Length("1234567890"));
        assertEquals("       0", sBasket.convertTo8Length("0"));
        assertEquals("      -1", sBasket.convertTo8Length("-1"));
    }
    
    
    /**
     * Test convertTo8Length0
     */
    @Test
    public void testConvertTo8Lenght0(){
        //Create instances of logic classes
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        /* Test method from ShoppingBasket that converts a string into 
        eight chars with leading 0s.*/
        assertEquals("00000002", sBasket.convertTo8Length0(2));
        assertEquals("00012345", sBasket.convertTo8Length0(12345));
        assertEquals("12345678", sBasket.convertTo8Length0(1234567890));
        assertEquals("00000000", sBasket.convertTo8Length0(0));
        assertEquals("-0000001", sBasket.convertTo8Length0(-1));
        
   
    }

     /**
     * Test addToCart() & getTotalPrice() & getCart() & clearCart()
     */
    @Test
    public void testShoppingcartMethods() {
        //Create instances of logic classes
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        String timeStamp;
        // Create a ticket and add it to the cart
        cTickets.addTicket(2, "test", "testENG", 30);
        sBasket.addToCart(0,3,4);
        // Evaluate if the accessor methods function correctly
        assertEquals(24,sBasket.getTotalPrice());
        assertEquals(4,sBasket.getCart().get(0).getAmountTickets());
        assertEquals(3,sBasket.getCart().get(0).getZones());
        assertEquals(30,sBasket.getCart().get(0).getStartZone());
        assertEquals(2,sBasket.getCart().get(0).getPricePerZone());
        assertEquals("test",sBasket.getCart().get(0).getTypeDA());
        assertEquals("testENG",sBasket.getCart().get(0).getTypeENG());
        // New Date object and timestamp
        java.util.Date date = new java.util.Date();
        timeStamp = new Timestamp(date.getTime()).toString().substring(0,16);
        sBasket.getCart().get(0).setTimeStamp();
        // Check timestamp
        assertEquals(timeStamp,sBasket.getCart().get(0).getTimeStamp());
        // Clear cart and ensure it was successful
        sBasket.clearCart();
        assertEquals(0,sBasket.getCart().size());
    }
}
