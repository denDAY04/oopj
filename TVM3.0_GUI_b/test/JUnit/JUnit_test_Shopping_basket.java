package JUnit;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Assert.*;
import java.sql.Timestamp;
import MachineLogic.CreatedTickets;
import MachineLogic.ShoppingBasket;
import MachineLogic.Statistics;


/**
 * The test class JUnit_test_Shopping_basket.
 *
 * 
 */
public class JUnit_test_Shopping_basket
{
    
    /**
    * Test intToFourChar
    *
    */
    @Test
    public void testIntToFourChar()
    {
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        
        //Testing of convertions
        assertEquals("   2", sBasket.intToFourChar(2));
        assertEquals("1234", sBasket.intToFourChar(12345));
        assertEquals("   0", sBasket.intToFourChar(0));
        assertEquals("  -1", sBasket.intToFourChar(-1));
        
    }
    
    /**
    * Test convertTo8Lenght
    *
    */
    @Test
    public void testConvertTo8Lenght()
    {
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        
        //Testing of convertions
        assertEquals("       2", sBasket.convertTo8Lenght("2"));
        assertEquals("   12345", sBasket.convertTo8Lenght("12345"));
        assertEquals("12345678", sBasket.convertTo8Lenght("1234567890"));
        assertEquals("       0", sBasket.convertTo8Lenght("0"));
        assertEquals("      -1", sBasket.convertTo8Lenght("-1"));
   
    }
    
    /**
    * Test convertTo8Lenght0
    *
    */
    @Test
    public void testConvertTo8Lenght0()
    {
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        
        //Testing of convertions
        assertEquals("00000002", sBasket.convertTo8Lenght0(2));
        assertEquals("00012345", sBasket.convertTo8Lenght0(12345));
        assertEquals("12345678", sBasket.convertTo8Lenght0(1234567890));
        assertEquals("00000000", sBasket.convertTo8Lenght0(0));
        assertEquals("-0000001", sBasket.convertTo8Lenght0(-1));
        
    }

    /**
    * Test addToCart() & getTotalPrice() & getCart() & clearCart()
    *
    */
    @Test
    public void testShoppingcartMethods()
    {
             CreatedTickets cTickets = new CreatedTickets();
             Statistics Stat = new Statistics();
             ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
             String timeStamp;
             
             //Creation of ticket
             cTickets.addTicket(20, "test", "testENG", 2);
             
             //Testing of
             //addToCart(int ticketIndex,int amountZones,int ticketAmount)
             //method
             sBasket.addToCart(0,3,1);
                   
             //Test getTotalPrice and getCart method
             assertEquals(60,sBasket.getTotalPrice());
             assertEquals(1,sBasket.getCart().get(0).getAmountTickets());
             assertEquals(3,sBasket.getCart().get(0).getZones());
             assertEquals(2,sBasket.getCart().get(0).getStartZone());
             assertEquals(20,sBasket.getCart().get(0).getPricePerZone());
             assertEquals("test",sBasket.getCart().get(0).getTypeDA());
             assertEquals("testENG",sBasket.getCart().get(0).getTypeENG());
             java.util.Date date = new java.util.Date();
             timeStamp = new Timestamp(date.getTime()).toString().substring(0,16);
             sBasket.getCart().get(0).setTimeStamp();
             assertEquals(timeStamp,sBasket.getCart().get(0).getTimeStamp());
             
             //Testing removeTicket method
             sBasket.removeTicket(0);
             assertEquals(0,sBasket.getCart().size());
             
             //Test clearCart method
             sBasket.addToCart(0,1,1);
             sBasket.addToCart(0,2,3);
             sBasket.clearCart();
             assertEquals(0,sBasket.getCart().size());
    }
}
