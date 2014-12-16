/* @author Jonas
 * Contributors:
 */

package RMIInterfaces;

import ModelClasses.*;
import java.rmi.*;

public interface JourneyManagerRMISkel extends Remote
{
    public TicketList createNewTickets(PassengerList pLst) throws RemoteException;
  //(multicast forced update from database in regards to zonemap and prices)  
    public TicketList getExistingTickets(PassengerList pLst) throws RemoteException;  
}