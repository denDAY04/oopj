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
}