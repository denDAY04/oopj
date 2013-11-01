/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MachineLogic;

import Interface.Printer;
import java.util.*;

/**
 *
 * @author Qess
 */
public class ShoppingBasket
        {

    private CreatedTickets cTickets;
    private Printer Print = new Printer();
    private Statistics Stat;
    private ArrayList<Ticket> ShoppingBasket = new ArrayList<>();
    

    /**
     * Standard constructor.
     * @param cTickets
     * @param Stat
     */
    public ShoppingBasket(CreatedTickets cTickets, Statistics Stat) {
        this.cTickets=cTickets;
        this.Stat=Stat;
    }


public void addToCart(int ticketIndex,int amountZones,int ticketAmount) // adds a ticket to the shopping cart, using a ticket from created tickets as a template
        {
    
        ShoppingBasket.add((new Ticket(cTickets.transferTicket(ticketIndex-1),ticketAmount,amountZones)));  

        }  
              
      
     public boolean printTicket(int index,int language,int hardwareID)  // prints a ticket at location index in the ShoppingBasket array.
       {
             boolean printok;            
             ShoppingBasket.get(index).setTimeStamp();              // timestap the ticket
             String Hardwarestring = intToFourChar(hardwareID);
             int subtotal =  ShoppingBasket.get(index).getPricePerZone()* ShoppingBasket.get(index).getZones()* ShoppingBasket.get(index).getAmountTickets();   // calculate the value to be printed on the ticket.
             String typeStr =  convertTo8Lenght( ShoppingBasket.get(index).getTypeDA());             // makes a 8 char long string of the name, to fit on the ticket.
             String typeENGStr =  convertTo8Lenght( ShoppingBasket.get(index).getTypeENG());
             String startZoneStr = intToFourChar( ShoppingBasket.get(index).getStartZone());         // makes a 4 char long string of the startzone, to fit on the ticket.
             String zonesStr = intToFourChar( ShoppingBasket.get(index).getZones());
             String amountTicketsStr = intToFourChar( ShoppingBasket.get(index).getAmountTickets());
             String totalPriceStr =  convertTo8Lenght(Integer.toString(subtotal));
             String timeStamp =  ShoppingBasket.get(index).getTimeStamp();
             String ticketID = Hardwarestring+">>"+convertTo8Lenght0(Stat.getTicketNumber());    // Prints unique codestring on ticket containig machine ID and unique ticket number.
             printok = Print.print(typeStr,typeENGStr,startZoneStr,zonesStr,amountTicketsStr,totalPriceStr,timeStamp,ticketID,language);    // prints the ticket and checks for errors.
             if (printok == false) return false;
             else
             {
             return true;
             }}
         
       

        /**
     * Shopping cart of Tickets accessor method.
     * @return
     */       
        public ArrayList<Ticket> getCart()                      // accessor method
        {
        return ShoppingBasket;
        }
        /**
        * Shopping cart of Tickets reset method.
        */  
        public void clearCart()  {                           // clear array method
        ShoppingBasket.clear();
        }
        /**
     * Total value of  Tickets in Shopping cart accessor method.
     * @return
     */  
        public int getTotalPrice()                           // gets total price of shopping cart.
        {
        int totalprice=0;
        for (Ticket element : ShoppingBasket) 
          {
          int subtotal = (element.getPricePerZone()*element.getZones()*element.getAmountTickets());
          totalprice = totalprice + subtotal;
          }
        return totalprice;
        }
   
        /**
     * Turns an String in to a 8 char long string.
     * @param type
     * @return
     */
        public String convertTo8Lenght(String type)
         {
         String output = "";
         output = output.format("%8s", type.replace(' ',' '));
         if (output.length()> 8) 
           output = output.substring(0,8);
         return output;
         }

        /**
     * Turns an integer in to a 8 char long string, with leading zeros.
     * @param type
     * @return
     */
        public String convertTo8Lenght0(int type)
         {
         String output = "";
         output = output.format("%1$08d", type);
         if (output.length()> 8) 
           output = output.substring(0,8);
         return output;
         }

        /**
     * Turns an integer in to a four char long string.
     * @param input
     * @return
     */
        public String intToFourChar(int input) 
         {
         String output="";
         output = output.format("%4s", input);            
         if (output.length()> 4) 
            output = output.substring(0,4);
         return output;
         } 

}