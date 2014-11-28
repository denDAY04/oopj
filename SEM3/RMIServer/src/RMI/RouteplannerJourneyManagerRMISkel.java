package RMI;

import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Time;
import ModelClasses.*;


public class RouteplannerJourneyManagerRMISkel extends UnicastRemoteObject implements IntRouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkel()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor is executed");  
    }    
 
//    @Override
//    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException {
//    return databasemanager.getNextDeparture(startPosition, endPosition, timeDeparture);     
//    }

    @Override //Objects may be defined as a modelclass Stop[]
    public Stop[] SetupGraph() throws RemoteException {
    return databasemanager.SetupGraph();     
    }
    
}