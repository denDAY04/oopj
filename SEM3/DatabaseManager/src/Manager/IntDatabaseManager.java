package Manager;

import ModelClasses.*;
import java.util.ArrayList;

public interface IntDatabaseManager {
    
    
    //<editor-fold defaultstate="collapsed" desc="WebsiteManager">
    public int createCustomer(Customer customer);
    public Customer setCustomerDetails(Customer customer);
    public Customer getCustomerDetails(int customerNumber);
    public Customer logOn(String email, String password);
    public ArrayList<Journey> getJourneyHistory(int customerNumber, int index);
    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="RouteplannerJourneyManager">

    public Stop[] SetupGraph(); //Objects may be defined as a modelclass Stop[]

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="JourneyManager">
    public TicketList getExistingTickets(PassengerList pLst);
    public TicketList createNewTickets(PassengerList pLst);
    //</editor-fold>
    
}
