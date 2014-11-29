package RMI;

import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ModelClasses.*;


public class RouteplannerJourneyManagerRMISkel extends UnicastRemoteObject implements IntRouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkel()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor executed");  
    }    
 
    @Override
    public Stop[] SetupGraph() throws RemoteException {
    return databasemanager.SetupGraph();     
    }
    
}