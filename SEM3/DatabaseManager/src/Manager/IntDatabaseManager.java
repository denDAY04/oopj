package Manager;

import ModelClasses.*;
import java.util.ArrayList;

public interface IntDatabaseManager {
    
    
    //<editor-fold defaultstate="collapsed" desc="WebsiteManager">
    public int createCustomer(Customer customer);
    public void setCustomerDetails(Customer customer);
    public Customer getCustomerDetails(int customerNumber);
    public Customer logOn(String email, String password);
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index);
    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="RouteplannerJourneyManager">
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture);// Return is availible departure; timeDeparture is the desired departure time   
    public ArrayList<Object> SetupGraph(); //Objects may be defined as a modelclass Stop[]
    public ArrayList<Object> GetNextDeparute(String type, String line, String fromStop, String towardsStop,int hour, int minute);    //Objects may be defined as a modelclass time[]
    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="JourneyManager">
    public TicketList getExistingTickets(PassengerList pLst);
    public TicketList createNewTickets(PassengerList pLst);
    //</editor-fold>
    
}
