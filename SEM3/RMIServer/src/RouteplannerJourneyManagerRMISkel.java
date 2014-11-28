import java.rmi.*;
import java.util.ArrayList;

public interface RouteplannerJourneyManagerRMISkel extends Remote
{
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException;
   // Return is availible departure; timeDeparture is the desired departure time
       
    public ArrayList<Object> SetupGraph() throws RemoteException; //Objects may be defined as a modelclass Stop[]

    public ArrayList<Object> GetNextDeparute(String type, String line, String fromStop, String towardsStop,int hour, int minute) throws RemoteException;
    //Objects may be defined as a modelclass time[]
}





