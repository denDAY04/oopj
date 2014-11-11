package RmiServer.Interface;

import java.rmi.*;

public interface IntRouteplannerJourneyManagerRMISkel extends Remote
{
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException;
   // Return is availible departure; timeDeparture is the desired departure time
}





