package MachineLogic;
import java.sql.Timestamp;

public class Ticket 
{
    private int pricePerZone;
    private String typeDA;
    private String typeENG;
    private int startZone;
    private int zones;
    private int amountTickets;
    private String timeStamp;
    
    /**
     * Standard constructor.
     * @param pricePerZone
     * @param typeDA
     * @param typeENG
     * @param startZone
     */
    public Ticket(int pricePerZone, String typeDA, String typeENG,              //creates a new ticket for the createdTickets 
                                         int startZone)
    {
        this.pricePerZone = pricePerZone;
        this.typeDA = typeDA;
        this.typeENG = typeENG;
        this.startZone = startZone;
    }
    /**
     * Constructor for ShoppingBasket.
     * @param t
     * @param amountTickets
     * @param zones
     */
    public Ticket(Ticket t, int amountTickets, int zones)                       // creates a new ticket for the shopping cart, using a ticket from the createdTickets.
    {
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
