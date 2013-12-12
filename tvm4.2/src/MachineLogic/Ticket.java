package MachineLogic;
import java.sql.Timestamp;
import java.util.Date;

/**
 * This class denotes a single Ticket object.
 * A new instance of this class should be created for each use of a new 
 * ticket.
 */
public class Ticket {
    private final int pricePerZone;
    private final String typeDA;
    private final String typeENG;
    private final int startZone;
    private int zones;
    private int amountTickets;
    private String timeStamp;
    
    /**
     * Constructor 
     * <p>
     * Creates a new ticket instance of the class.
     * @param pricePerZone Int denoting the prize of a zone for this ticket. 
     * @param typeDA String denoting the type (name) of the ticket in Danish.
     * @param typeENG String denoting the type (name) of the ticket in English.
     * @param startZone Int denoting the start zone from which the ticket will  
     * be valid.
     */
    public Ticket(int pricePerZone, String typeDA, String typeENG,
                    int startZone){
        this.pricePerZone = pricePerZone;
        this.typeDA = typeDA;
        this.typeENG = typeENG;
        this.startZone = startZone;
    }
    
    /**
     * Constructor for ShoppingBasket.
     * Used to create an instance of an existing ticket, but with more than
     * one, and with a number of zones for which it should be valid.
     * @param t Ticket object of the ticket that should be added to the cart 
     * and which will have an added amount of tickets and zones.
     * @param amountTickets int denoting the amount of tickets that should be 
     * added to the Ticket.
     * @param zones int denoting the amount of zones that should be added 
     * to the Ticket.
     */
    public Ticket(Ticket t, int amountTickets, int zones) {
        this.startZone = t.getStartZone();
        this.zones = t.getZones();
        this.pricePerZone = t.getPricePerZone();
        this.typeDA = t.getTypeDA();
        this.typeENG = t.getTypeENG();
        this.amountTickets = amountTickets;
        this.zones = zones;
    }

   /**
    * Adds a timestamp(accurate down to minutes) to the given
    * {@link Ticke} instance. 
    * <p>
    * The format for the timestamp is <code>yyyy-mm-dd hh:mm</code>
    * 
    */
    public void setTimeStamp() {
        Date date = new Date();
        timeStamp = new Timestamp(date.getTime()).toString().substring(0,16);
    }
    
    /**
     * Accessor method for the timestamp of a given {@link Ticket}.
     * @return String denoting the timestamp in the format
     * <code>yyyy-mm-dd hh:mm</code>
     */
    public String getTimeStamp() {return timeStamp;}
    
    /**
     * Accessor method for the Danish type/Name.
     * @return String denoting the type/name of the {@link Ticket} in Danish.
     */
    public String getTypeDA() {return typeDA;}
    
   /**
     * Accessor method for the English type/Name.
     * @return String denoting the type/name of the {@link Ticket} in English.
     */
    public String getTypeENG() {return typeENG;}
    
    /**
     * Accessor method for the amount of Zones.
     * @return Int denoting the amount of zones added to the {@link Ticket}.
     */
    public int getZones() {return zones;}
    
    /**
     * Accessor method for the start zone.
     * @return Int denoting the start zone of the {@link Ticket}.
     */
    public int getStartZone() {return startZone;}
    
    /**
     * Accessor method for the prize per zone.
     * @return Int denoting the prize for a single zone of the given
     * {@link Ticket}.
     */
    public int getPricePerZone() {return pricePerZone;}
    
    /**
     * Accessor method for the amount of tickets added to the given 
     * {@link Ticket}.
     * @return Int denoting the amount of tickets.
     */
    public int getAmountTickets() {return amountTickets;}
}
