package RmiServer.Skeleton;

import ModelClasses.PassengerList;
import ModelClasses.TicketList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JourneyManagerRMISkel extends UnicastRemoteObject implements RmiServer.Skeleton.Interface.IntJourneyManagerRMISkel{

    public JourneyManagerRMISkel() throws RemoteException{
    
    
    }
        
    
    @Override
    public TicketList getExistingTickets(PassengerList pLst) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TicketList createNewTickets(PassengerList pLst) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
