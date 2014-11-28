import Manager.DatabaseManager;
import ModelClasses.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JourneyManagerRMISkelImpl extends UnicastRemoteObject implements JourneyManagerRMISkel{
    DatabaseManager databasemanager; 
    public JourneyManagerRMISkelImpl() throws RemoteException{  
        databasemanager = new DatabaseManager();
        System.out.println("JourneyManagerRMI constructor executed");       
    }  
    
    
        
    
    @Override
    public TicketList getExistingTickets(PassengerList pLst) throws RemoteException {
        return databasemanager.getExistingTickets(pLst);
        
        
    }

    @Override
    public TicketList createNewTickets(PassengerList pLst) throws RemoteException {
       return databasemanager.createNewTickets(pLst);
    }
    
}
