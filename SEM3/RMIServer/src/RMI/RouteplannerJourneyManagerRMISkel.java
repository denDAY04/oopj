package RMI;

import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ModelClasses.*;
import java.util.ArrayList;


public class RouteplannerJourneyManagerRMISkel extends UnicastRemoteObject implements IntRouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkel()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor executed");  
    }    


    @Override 
    public Stop[] setupGraph() throws RemoteException {
    return databasemanager.setupGraph();     
    }

    @Override
    public ArrayList<Zone> setupZoneDistance() throws RemoteException {
       return databasemanager.setupZoneDistance();

    }

}