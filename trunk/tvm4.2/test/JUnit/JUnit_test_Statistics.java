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
import MachineLogic.CreatedTickets;
import MachineLogic.ShoppingBasket;
import MachineLogic.Statistics;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    
    

    @Test
    public void JUnit_test_Statist() {
             CreatedTickets cTickets = new CreatedTickets();
             Statistics Stat = new Statistics(); 
             ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
             int machineID = 1010;  // Is normally sent from the GUI, hence
                                    // the need for a dedicated variable due to
                                    // lack of GUI in testing
             
             cTickets.addTicket(2, "test", "testENG", 30);
             sBasket.addToCart(0,3,4);
            try {
                Stat.LogSale(sBasket.getCart().get(0), machineID);
            } catch (Exception ex) {
                ex.printStackTrace();
                return;
            }
             assertEquals(24,Stat.getMoneyDay());
             assertEquals(999,Stat.getInk());
             assertEquals(999,Stat.getPaper());
             assertEquals(24,Stat.getMoneyTotal());
             assertEquals(4,Stat.getTicketSoldDay());
             assertEquals(4,Stat.getTicketSoldTotal());
             Stat.ResetDayStatistics();
             assertEquals(0,Stat.getMoneyDay());
             assertEquals(0,Stat.getTicketSoldDay());
             Stat.ResetInk();
             Stat.ResetPaper();
             assertEquals(1000,Stat.getInk());
             assertEquals(1000,Stat.getPaper());
             assertEquals(24,Stat.getMoneyTotal());
             assertEquals(4,Stat.getTicketSoldTotal());
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