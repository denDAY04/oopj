package RMIInterfaces;

import java.rmi.*;
import ModelClasses.*;
import java.util.ArrayList;

public interface RouteplannerJourneyManagerRMISkel extends Remote
{      
    public Stop[] setupGraph() throws RemoteException;
    
    public ArrayList<Zone> setupZoneDistance() throws RemoteException;
}





