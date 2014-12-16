/* @author Jonas
 * Contributors:
 */

package RMIImpl;

import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import ModelClasses.*;
import RMIInterfaces.RouteplannerJourneyManagerRMISkel;
import java.util.ArrayList;

public class RouteplannerJourneyManagerRMISkelImpl extends UnicastRemoteObject implements RouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkelImpl()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor executed");  
    }    
 
    @Override
    public Stop[] setupGraph() throws RemoteException {
    return databasemanager.setupGraph();
    }
    
    @Override
    public ArrayList<Zone> setupZoneDistance() throws RemoteException{
    return databasemanager.setupZoneDistance();
    }
}