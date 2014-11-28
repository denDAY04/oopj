import Manager.DatabaseManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class RouteplannerJourneyManagerRMISkelImpl extends UnicastRemoteObject implements RouteplannerJourneyManagerRMISkel{
    DatabaseManager databasemanager;
    public RouteplannerJourneyManagerRMISkelImpl()throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("RouteplannerJourneyManagerRMISkel constructor is executed");  
    }    
 
    @Override
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException {
    return databasemanager.getNextDeparture(startPosition, endPosition, timeDeparture);     
    }

    @Override //Objects may be defined as a modelclass Stop[]
    public ArrayList<Object> SetupGraph() throws RemoteException {
    return databasemanager.SetupGraph();     
    }
    
             // GetNextDeparute   IS ....DEPARUTE a spelling error ????????????
    @Override //Objects may be defined as a modelclass time[]
    public ArrayList<Object> GetNextDeparute(
    String type, String line, String fromStop, String towardsStop, int hour, int minute) throws RemoteException {
    return databasemanager.GetNextDeparute(type, line, fromStop, towardsStop, hour, minute);       
    }
    
}