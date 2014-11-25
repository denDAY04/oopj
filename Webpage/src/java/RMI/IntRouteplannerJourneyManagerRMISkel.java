package RMI;







import JPBeans.model.*;
import java.rmi.*;
import java.sql.Time;

public interface IntRouteplannerJourneyManagerRMISkel extends Remote
{
    public  Time[] getNextDeparture(String type, String line, String fromStop, String towardsStop, int hour, int minute) throws RemoteException;
   // Return is availible departure; timeDeparture is the desired departure time
    
    public  Stop[] SetupGraph(); 
    
    
}





