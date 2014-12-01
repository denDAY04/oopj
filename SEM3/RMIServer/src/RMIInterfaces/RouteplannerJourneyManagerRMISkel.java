package RMIInterfaces;

import java.rmi.*;
import java.sql.Time;
import ModelClasses.*;
import java.util.ArrayList;

public interface RouteplannerJourneyManagerRMISkel extends Remote
{
//    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException;
//   // Return is availible departure; timeDeparture is the desired departure time
       
    public Stop[] setupGraph() throws RemoteException; //Objects may be defined as a modelclass Stop[]
    
    public ArrayList<Zone> setupZoneDistance() throws RemoteException;
}





