/**
 * RouteplannerJourneyManagerRMISkel 
 * Interface for RMI connection to Database
 * @author Rasmus
 */

package RMIInterfaces;

import java.rmi.*;
import ModelClasses.*;
import java.util.ArrayList;

public interface RouteplannerJourneyManagerRMISkel extends Remote
{
    /**
     * Returns an array of Stop objects, representing a graph of all stops and
     * links between stops, representing busses and trains.
     * @return
     * @throws RemoteException
     */
    public Stop[] setupGraph() throws RemoteException; 
    
    /**
     * Returns an array of Zone objects, representing an adjacency list of 
     * Zones. This list describes the physical layout of the zones.
     * @return
     * @throws RemoteException
     */
    public ArrayList<Zone> setupZoneDistance() throws RemoteException;

}