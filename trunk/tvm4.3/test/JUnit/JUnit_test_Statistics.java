package JUnit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tvm_project.CreatedTickets;
import tvm_project.ShoppingBasket;
import tvm_project.Statistics;
import tvm_project.UserInterface;

/**
 *
 * @author mazlink
 */
public class JUnit_test_Statistics {
    
        /**
     * Default constructor for test class JUnit_test_Statistics
     */
    public JUnit_test_Statistics()
    {

    }
    
    
    
    /**
     *
     */
    @Test
    public void JUnit_test_Statist() {
             CreatedTickets cTickets = new CreatedTickets();
             UserInterface UserInt = new UserInterface();
             Statistics Stat = new Statistics(UserInt); 
             ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
             
             cTickets.addTicket(2, "test", "testENG", 30);
             sBasket.addToCart(1,3,4);

             Stat.LogSale(sBasket.getCart().get(0));
             assertEquals(24,Stat.MoneyDay());
             assertEquals(999,Stat.CheckInk());
             assertEquals(999,Stat.CheckPaper());
             assertEquals(24,Stat.MoneyTotal());
             assertEquals(4,Stat.TicketSoldDay());
             assertEquals(4,Stat.TicketSoldTotal());
             Stat.ResetDayStatistics();
             assertEquals(0,Stat.MoneyDay());
             assertEquals(0,Stat.TicketSoldDay());
             Stat.ResetInk();
             Stat.ResetPaper();
             assertEquals(1000,Stat.CheckInk());
             assertEquals(1000,Stat.CheckPaper());
             assertEquals(24,Stat.MoneyTotal());
             assertEquals(4,Stat.TicketSoldTotal());
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}