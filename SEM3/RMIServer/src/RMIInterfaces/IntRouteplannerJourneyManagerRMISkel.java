package RMIInterfaces;

import java.rmi.*;
import java.sql.Time;
import ModelClasses.*;

public interface IntRouteplannerJourneyManagerRMISkel extends Remote
{
//    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException;
//   // Return is availible departure; timeDeparture is the desired departure time
       
    public Stop[] SetupGraph() throws RemoteException; //Objects may be defined as a modelclass Stop[]

}





