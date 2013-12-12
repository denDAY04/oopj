package MachineLogic;

import java.util.* ;

/**
 * This class functions as a database for all the created {@link Ticket} 
 * objects with the use of an ArrayList. 
 */
public class CreatedTickets {
    public ArrayList<Ticket> ticketList = new ArrayList<>();
        
    /**
     * Adds a {@link Ticket} to the ArrayList.
     * @param pricePerZone Int denoting the price for a single zone.
     * @param typeDA String denoting the Danish name of the Ticket.
     * @param typeENG String denoting the English name of the Ticket.
     * @param startZone Int denoting the startzone from which the Ticket will
     * be valid.
     */
    public void addTicket(int pricePerZone, String typeDA, 
            String typeENG, int startZone) {
        ticketList.add(new Ticket (pricePerZone,typeDA,typeENG,startZone));
    }
        
    /**
     * Accessor method for getting a {@link Ticket} from the ArrayList.
     * @param index Int denoting the index at which the desired Ticket is.
     * @return A Ticket object.
     */
    public Ticket getTicket(int index) {return (ticketList.get(index));}
    
    /**
     * Accessor method for getting the entire ArrayList of created
     * {@link Ticket} objects.
     * @return ArrayList of Ticket objects.
     */
    public ArrayList<Ticket> getArray() {return(ticketList);}
    
    /**
     * Clears the ArrayList of created {@link Ticket} objects.
     */
    public void ClearArray() {ticketList.clear();}
    
}