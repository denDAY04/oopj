package MachineLogic;

import Interface.Printer;
import java.util.*;

/**
 * This class handles communication with {@link Ticket} objects when dealing 
 * with the sales functions.
 */
public class ShoppingBasket {
    private final CreatedTickets cTickets;
    private final Printer Print = new Printer();
    private final Statistics Stat;
    private final ArrayList<Ticket> ShoppingBasket = new ArrayList<>();

    /**
     * Custom constructor.
     * @param cTickets Reference to {@link CreatedTickets}
     * @param Stat Reference to {@link Statistics}
     */
    public ShoppingBasket(CreatedTickets cTickets, Statistics Stat) {
        this.cTickets=cTickets;
        this.Stat=Stat;
    }

    /**
     * Creates a special {@link Ticket} from and given existing Ticket, with 
     * added amount of tickets and zones. This Ticket is then stored in 
     * a field ArrayList of Ticket objects representing the cart.
     * @param ticketIndex Int denoting the index at which the desired Ticket
     * can be located in CreatedTickets' ArrayList. This is the Ticket which 
     * will be used as a template.
     * @param amountZones Int denoting the amount of zones that should be added
     * to the new Ticket.
     * @param ticketAmount Int denoting the amount of tickets that should be 
     * added to the Ticket object.
     */
    public void addToCart(int ticketIndex, int amountZones, int ticketAmount) {
        ShoppingBasket.add((new Ticket(cTickets.getTicket(ticketIndex)
                ,ticketAmount,amountZones)));  
    }  

    /**
     * Removes a {@link Ticket} from the ArrayList of Ticket objects that are 
     * in the cart.
     * @param index Int denoting the index at which the given Ticket can be 
     * located.
     */
    public void removeTicket(int index) {ShoppingBasket.remove(index);} 

    /**
     * Calls {@link Printer} in order to print out a given {@link Ticket}, 
     * after having formated all of its informations. 
     * @param index Int denoting the index of the Ticket in the cart.
     * @param language Int denoting what language the Ticket should be printed
     * in.
     * @param hardwareID Int denoting the machine's ID.
     * @return True if the Ticket was successfully printed; false otherwise.
     */
    public boolean printTicket(int index,int language,int hardwareID) {            
        // Timestamp the ticket
        ShoppingBasket.get(index).setTimeStamp();
        String HardwareString = intToFourChar(hardwareID);
        // Calculate the total price of the Ticket
        int total =  ShoppingBasket.get(index).getPricePerZone()* 
                ShoppingBasket.get(index).getZones()* 
                ShoppingBasket.get(index).getAmountTickets();  
        // Format the different Strings to fit dimensions of printed ticket.
        String typeStr =  convertTo8Lenght( ShoppingBasket.get(index)
                .getTypeDA());             
        String typeENGStr =  convertTo8Lenght( ShoppingBasket.get(index)
                .getTypeENG());
        String startZoneStr = intToFourChar( ShoppingBasket.get(index)
                .getStartZone());         
        String zonesStr = intToFourChar( ShoppingBasket.get(index).getZones());
        String amountTicketsStr = intToFourChar( ShoppingBasket.get(index)
                .getAmountTickets());
        String totalPriceStr =  convertTo8Lenght(Integer.toString(total));
        // Get timestamp for the Ticket
        String timeStamp =  ShoppingBasket.get(index).getTimeStamp();
        // Prepare machine ID and unique ticket code
        String ticketID = HardwareString+">>"
                +convertTo8Lenght0(Stat.getTicketNumber()); 
        // Print ticket and evaluate if printed successfully.
        if (Print.print(typeStr, typeENGStr, startZoneStr, zonesStr, 
                amountTicketsStr, totalPriceStr, timeStamp, ticketID, 
                language) == false) 
            return false;
        else 
            return true;
    }    

    /**
     * Accessor method for the ArrayList of {@link Ticket} objects denoting 
     * the cart.
     * @return ArrayList of Ticket objects.
     */      
    public ArrayList<Ticket> getCart() {return ShoppingBasket;}
        
    /**
     * Clears the ArrayList denoting the cart.
     */ 
    public void clearCart()  {ShoppingBasket.clear();}
        
    /**
     * Accessor method for the total price of the cart.
     * @return Int denoting the total price.
     */  
    public int getTotalPrice() {
        int totalprice=0;
        for (Ticket element : ShoppingBasket) {
            int subtotal = (element.getPricePerZone()*element.getZones()
                    *element.getAmountTickets());
            totalprice = totalprice + subtotal;
        }
        return totalprice;
    }
   
    /**
     * Turns an String in to a 8 char long string.
     * @param type String to be formatted.
     * @return Formatted String.
     */
    public String convertTo8Lenght(String type) {
        String output = "";
        output = output.format("%8s", type.replace(' ',' '));
        if (output.length()> 8) 
            output = output.substring(0,8);
        return output;
     }

    /**
     * Turns an integer in to a 8 char long string, with leading zeros.
     * @param type Int to be formatted.
     * @return Formatted String.
     */
    public String convertTo8Lenght0(int type) {
        String output = "";
        output = output.format("%1$08d", type);
        if (output.length()> 8) 
            output = output.substring(0,8);
        return output;
     }

    /**
     * Turns an integer into a four char long string.
     * @param input Int to be formatted.
     * @return Formatted String.
     */
    public String intToFourChar(int input) {
        String output="";
        output = output.format("%4s", input);            
        if (output.length()> 4) 
            output = output.substring(0,4);
        return output;
        } 

}