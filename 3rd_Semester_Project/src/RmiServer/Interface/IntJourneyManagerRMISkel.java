package RmiServer.Interface;

import java.rmi.*;
import ModelClasses.*;

public interface IntJourneyManagerRMISkel extends Remote
{
    public TicketList getExistingTickets(PassengerList pLst) throws RemoteException;
    public TicketList createNewTickets(PassengerList pLst) throws RemoteException;
  //(multicast forced update from database in regards to zonemap and prices)  
   
}