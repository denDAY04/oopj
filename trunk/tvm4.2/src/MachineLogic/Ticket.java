package MachineLogic;
import java.sql.Timestamp;

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
     * @param t
     * @param amountTickets
     * @param zones
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
    * Timestamping method..
    */
    public void setTimeStamp()                                                  // asks a tiket to timestamp itself.
    {
        java.util.Date date = new java.util.Date();
        timeStamp = new Timestamp(date.getTime()).toString().substring(0,16);
    }
    /**
     * Timestamping accessor method.
     * @return
     */
    public String getTimeStamp()
    {
        return timeStamp;
    }
    /**
     * Type accessor method.
     * @return
     */
    public String getTypeDA()
    {
        return typeDA;
    }
    /**
     * Type English accessor method.
     * @return
     */
    public String getTypeENG()
    {
        return typeENG;
    }
    /**
     * Zones accessor method.
     * @return
     */
    public int getZones()
    {
        return zones;
    }
    /**
     * Start zone accessor method.
     * @return
     */
    public int getStartZone()
    {
        return startZone;
    }
    /**
     * price per zone accessor method.
     * @return
     */
    public int getPricePerZone()
    {
        return pricePerZone;
    }
    /**
     * amount of tickets accessor method.
     * @return
     */
    public int getAmountTickets()
    {
        return amountTickets;
    }
}
