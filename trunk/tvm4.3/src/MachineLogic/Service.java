package MachineLogic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class' main function is to communicate with with the other logical 
 * classes ({@link Statistics}, {@link CreatedTickets}, and 
 * {@link ShoppingBasket}) ind order to construct an ArrayList of Strings used
 * to display the statistics in the GUI.
 */
public class Service {
    private Statistics ST;
    private CreatedTickets CT;
    private ShoppingBasket SB;
       
    /**
     * Costum constructor with references to the other logical classes
     * @param ST Reference to {@link Statistics}.
     * @param CT Reference to {@link CreatedTickets}.
     * @param SB Reference to {@link ShoppingBasket}.
     */
    public Service(Statistics ST,CreatedTickets CT,ShoppingBasket SB) {
        this.ST=ST;
        this.CT=CT;
        this.SB=SB;
    }
    
    /**
     * Collects data from the other logical classes in order to construct an
     * ArrayList of Strings containing all statisitc data requested by the 
     * service visit, and send it back to the caller for displaying. 
     * @param menuSelection Int denoting the request that has been made
     * @return An ArrayList of Strings with all the needed data.
     * @see Service#Service(MachineLogic.Statistics, 
     * MachineLogic.CreatedTickets, MachineLogic.ShoppingBasket) 
     */
    public ArrayList<String> getData(int menuSelection) {
        // ArrayList of strings to be printed in the GUI
        ArrayList<String> data = new ArrayList<String>();
        // Menu actions
        switch (menuSelection) {
            case 1:  // 1 : Vis dagsstatistik
                data.add("Antal billetter solgt : "+ST.getTicketSoldDay()
                        + " stk.");        
                data.add("Antal print tilbage : "+Math.min(ST.getPaper()
                        , ST.getInk())+" stk.");
                data.add("Omsat for : "+ST.getMoneyDay()+" kr.");
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
                data.add("Omsat for "+ST.getMoneyDay()+" kr.");
                data.add("Solgt "+ST.getTicketSoldDay()+" billetter"); 
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
                data.add("Omsat for "+ST.getMoneyTotal()+" kr.");
                data.add("Solgt "+ST.getTicketSoldTotal()+" billetter"); 
                data.add("Total salg:");
                for (String element : ST.getLog()) {
                    data.add(element);
                }
                return data;
            case 8: // 8 : Udskriv test billetter.
                // Get the array of all possibel tickets
                for (int n=0; n<CT.getArray().size();n++) {
                    // Add one of each ticket to the shopping cart 
                    SB.addToCart(n,2,1);       
                    // Prints the ticket from the cart in danish
                    SB.printTicket(0,1,8888);  
                    // Prints the ticket from the cart in english
                    SB.printTicket(0,2,8888);  
                    // Updates the ticket machine variabels for two tickets.
                    ST.testPrint();            
                    ST.testPrint();
                    // Empty the shopping basket.
                    SB.clearCart();           
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