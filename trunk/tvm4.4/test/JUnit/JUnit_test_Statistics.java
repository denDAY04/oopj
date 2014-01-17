package JUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import MachineLogic.CreatedTickets;
import MachineLogic.ShoppingBasket;
import MachineLogic.Statistics;

/**
 * JUnit test class for {@link Statistics}.
 */
public class JUnit_test_Statistics {
    
    /**
     * Default constructor for test class JUnit_test_Statistics
     */
    public JUnit_test_Statistics() {}

    @Test
    public void JUnit_test_Statist() {
        // Create instances of logical classes
        CreatedTickets cTickets = new CreatedTickets();
        Statistics Stat = new Statistics(); 
        ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
        int machineID = 1010;  /* Is normally sent from the GUI, hence
                                the need for a dedicated variable due to
                                lack of GUI in testing*/
        // Create a ticket and add it to the cart
        cTickets.addTicket(2, "test", "testENG", 30);
        sBasket.addToCart(0,3,4);
        /* Test the ability to log a sale; exception thrown if problem occours
        during filestream to tvm.log file */
        try {
            Stat.LogSale(sBasket.getCart().get(0), machineID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
        // Evaluate if accessor methods from Statistics funtion correctly
        assertEquals(24,Stat.getMoneyDay());
        assertEquals(999,Stat.getInk());
        assertEquals(999,Stat.getPaper());
        assertEquals(24,Stat.getMoneyTotal());
        assertEquals(4,Stat.getTicketSoldDay());
        assertEquals(4,Stat.getTicketSoldTotal());
        // Reset daily statistic and re-evaluate
        Stat.ResetDayStatistics();
        assertEquals(0,Stat.getMoneyDay());
        assertEquals(0,Stat.getTicketSoldDay());
        // Resert printer resource variables and re-evaluate
        Stat.ResetInk();
        Stat.ResetPaper();
        assertEquals(1000,Stat.getInk());
        assertEquals(1000,Stat.getPaper());
        // Evaluate alltime statistics
        assertEquals(24,Stat.getMoneyTotal());
        assertEquals(4,Stat.getTicketSoldTotal());
    }
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}
}