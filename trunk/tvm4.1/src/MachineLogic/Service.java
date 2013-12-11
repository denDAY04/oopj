package MachineLogic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *   +Service() : void
 *
 *  Module description:   
 *  - Create ticket templates, by using +addTicket(type, zoneprice) method in CreatedTickets
 *  - Change Ink (call ST and use the method +ResetInk()  )
 *  - Add paper   (call ST and use the method +ResetPaper()  )
 *  - Show statistics (call ST and use the method  +ShowStastics()  )
 *  - Log out  (end loop and return control to caller)
 *  
 * @version 1
 */

public class Service

{
    private Statistics ST;
    private CreatedTickets CT;
    private ShoppingBasket SB;
       
    public Service(Statistics ST,CreatedTickets CT,ShoppingBasket SB)
    {
        this.ST=ST;
        this.CT=CT;
        this.SB=SB;
    }
    
     /**
      * Service menu to be displayed on the terminal rather than the graphical 
      * user interface. 
      * @return True in all cases unless the machine should be set out of order.
      */
    public ArrayList<String> getData(int menuSelection)
    {
        // ArrayList of strings to be printed in the GUI
        ArrayList<String> data = new ArrayList<String>();
        // Menu actions
        switch (menuSelection) {
            case 1:  // 1 : Vis dagsstatistik
                data.add("Antal billetter solgt : "+ST.TicketSoldDay()+" stk.");        
                data.add("Antal print tilbage : "+Math.min(ST.CheckPaper(),ST.CheckInk())+" stk.");
                data.add("Omsat for : "+ST.MoneyDay()+" kr.");
                data.add("Dagens salg:");
                for (String element: ST.getDayLog()) {
                    data.add(element);
                }
                return data;
            case 2:  // 2 : Skift billetrulle
                data.add("Nulstiller papir variabel... OK.");                          
                return data;
            case 3:  // 3 : Skift blækpatron
                data.add("Nulstiller blæk variabel... OK.");                           
                ST.ResetInk();
                return data;
            case 4: // 4 : Udskriv og nulstil salgs statestik
                data.add("Dagens salg:");
                for (String element : ST.getDayLog()) {
                    data.add(element);
                }
                data.add("Statistik for dagens salg.");
                data.add("Omsat for "+ST.MoneyDay()+" kr.");
                data.add("Solgt "+ST.TicketSoldDay()+" billetter"); 
                data.add("Nulstiller statestik... OK.");                               
                ST.ResetDayStatistics();
                return data;
            case 5: // 5 : Sæt ud af drift
                data.add("OOO");     // out of order-keyword
                return data;
            case 6: // 6 : Standard Service besøg
                ST.ResetInk();
                ST.ResetPaper();
                data.add("Nulstiller forbrugs variable........ OK.");                       
                ST.ResetDayStatistics();
                data.add("Nulstiller statestik........... OK.");
                return data;
            case 7: // 7 : Vis total statestik
                data.add("Total salg:");                    
                data.add("Omsat for "+ST.MoneyTotal()+" kr.");
                data.add("Solgt "+ST.TicketSoldTotal()+" billetter"); 
                data.add("Total salg:");
                for (String element : ST.getLog()) {
                    data.add(element);
                }
                return data;
            case 8: // 8 : Udskriv test billetter.
                for (int n=0; n<CT.getArray().size();n++) // get the array of all possibel tickets
                    {
                     SB.addToCart(n,2,1);       // add one of each ticket to the shopping cart
                     SB.printTicket(0,1,8888);  // prints the ticket from the cart in danish
                     SB.printTicket(0,2,8888);  // prints the ticket from the cart in english
                     ST.testPrint();            // updates the ticket machine variabels.
                     ST.testPrint();
                     SB.clearCart();            // empty the shopping basket.
                    }
                return data;
            case 0: //0 : Log ud 
                data.add("LO");     // log out keyword
                return data;
            default:
                data.add("LO");     // log out keyword
                return data;       
        }
    }       
}