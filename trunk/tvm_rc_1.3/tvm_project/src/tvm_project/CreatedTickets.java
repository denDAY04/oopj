package tvm_project;
import java.util.* ;

public class CreatedTickets 
{
    ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
    
    
    /**
     * add <Ticket> to arraylist ticketList method.
     * @param pricePerZone
     * @param typeDA
     * @param typeENG
     * @param startZone
     */
    public void addTicket(int pricePerZone, String typeDA, 
                          String typeENG, int startZone)
    {
        ticketList.add(new Ticket (pricePerZone,typeDA,typeENG,startZone));
    }
        
    /**
     * <Ticket> in ticketList arraylist accessor method.
     * @param index
     * @return
     */
    public Ticket transferTicket(int index)
    {
        return (ticketList.get(index));
    }
    
    /**
     * ticketList arraylist of <Ticket> accessor method.
     * @return
     */
    public ArrayList<Ticket> getArray()
    {
        return(ticketList);
    }
}