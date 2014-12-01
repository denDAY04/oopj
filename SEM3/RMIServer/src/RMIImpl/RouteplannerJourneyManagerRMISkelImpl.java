package RMIImpl;

import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ModelClasses.*;
import RMIInterfaces.RouteplannerJourneyManagerRMISkel;


public class RouteplannerJourneyManagerRMISkelImpl extends UnicastRemoteObject implements RouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkelImpl()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor executed");  
    }    
 
    @Override
    public Stop[] SetupGraph() throws RemoteException {
    return databasemanager.setupGraph();
    }
    
}