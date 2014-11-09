package RmiServer.Skeleton;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RouteplannerJourneyManagerRMISkel extends UnicastRemoteObject implements RmiServer.Skeleton.Interface.IntRouteplannerJourneyManagerRMISkel{

    
    public RouteplannerJourneyManagerRMISkel()throws RemoteException{
    
    
        
        
        
    }
    
    
    
    
    
    
    
    
    @Override
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
