package JUnit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.*;
import org.junit.Test;
import MachineLogic.CreatedTickets;
import MachineLogic.ShoppingBasket;
import MachineLogic.Statistics;
import java.sql.Timestamp;

/**
 *
 * @author mazlink
 */
public class JUnit_test_Statistics {
    
    /**
     *
     */
    @Test
    public void JUnit_test_Statist() {
             CreatedTickets cTickets = new CreatedTickets();
             Statistics Stat = new Statistics(); 
             ShoppingBasket sBasket = new ShoppingBasket(cTickets,Stat);
             String timeStamp;
             
             //Creation of ticket
             cTickets.addTicket(2, "test", "testENG", 30);
             sBasket.addToCart(0,3,4);

             //Testing LogSale method
             Stat.LogSale(sBasket.getCart().get(0));
             assertEquals(24,Stat.MoneyDay());
             assertEquals(999,Stat.CheckInk());
             assertEquals(999,Stat.CheckPaper());
             assertEquals(24,Stat.MoneyTotal());
             assertEquals(4,Stat.TicketSoldDay());
             assertEquals(4,Stat.TicketSoldTotal());
             
             //Testing and comparing getLog methods
             assertEquals(Stat.getLog(),Stat.getDayLog());
             
             //Test ResetDayStatistics method
             Stat.ResetDayStatistics();
             assertEquals(0,Stat.MoneyDay());
             assertEquals(0,Stat.TicketSoldDay());
             
             //Test testPrint method
             Stat.testPrint();
             assertEquals(998,Stat.CheckInk());
             assertEquals(998,Stat.CheckPaper());
             
             //Test ResetInk and ResetPaper method and totals
             Stat.ResetInk();
             Stat.ResetPaper();
             assertEquals(1000,Stat.CheckInk());
             assertEquals(1000,Stat.CheckPaper());
             assertEquals(24,Stat.MoneyTotal());
             assertEquals(4,Stat.TicketSoldTotal());
    }
}