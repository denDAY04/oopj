/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans;

import JPBeans.model.RoutePlannerJourney;
import JPBeans.model.RoutePlannerJourneyManager;
import JPBeans.model.Waypoint;
import JPBeans.model.WaypointManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Qesss
 */
public class RPJSkel implements RPJInterface, Serializable {

    @Override
    public RoutePlannerJourney createRouteplannerJourney(String origin, String destination, GregorianCalendar timeDeparture) {

         ArrayList<Waypoint> waypoints = new ArrayList();
        waypoints.add( WaypointManager.CreateWayPoint("Ballerup1", 6, new GregorianCalendar(2014,11,15,15,15), new GregorianCalendar(2014,11,15,15,17), "B", "Train", "Valby",2));
        waypoints.add( WaypointManager.CreateWayPoint("Malmparken1", 5, new GregorianCalendar(2014,11,15,15,19), new GregorianCalendar(2014,11,15,15,20), "B", "Train", "Valby",2));
        waypoints.add( WaypointManager.CreateWayPoint("Malmparken2", 5, new GregorianCalendar(2014,11,15,15,25), new GregorianCalendar(2014,11,15,15,30), "B", "Train", "Valby",2));        
        waypoints.add( WaypointManager.CreateWayPoint("Malmparken3", 5, new GregorianCalendar(2014,11,15,15,32), new GregorianCalendar(2014,11,15,15,35), "B", "Train", "Valby",2));
         waypoints.add( WaypointManager.CreateWayPoint("Ballerup", 6, new GregorianCalendar(2014,11,15,15,40), new GregorianCalendar(2014,11,15,15,42), "B", "Train", "Valby",1));
        waypoints.add( WaypointManager.CreateWayPoint("Malmparken", 5, new GregorianCalendar(2014,11,15,15,44), new GregorianCalendar(2014,11,15,15,46), "B", "Train", "Valby",1));        
        waypoints.add( WaypointManager.CreateWayPoint("Herlev", 5, new GregorianCalendar(2014,11,15,15,50), new GregorianCalendar(2014,11,15,15,57), "B", "Train", "Valby",1));
        waypoints.add( WaypointManager.CreateWayPoint("Husum", 4, new GregorianCalendar(2014,11,15,15,58), new GregorianCalendar(2014,11,15,15,59), "153", "Bus", "Vesterport",0));
        waypoints.add( WaypointManager.CreateWayPoint("peter", 3, new GregorianCalendar(2014,11,15,16,05), new GregorianCalendar(2014,11,15,16,15), "153", "Bus", "Vesterport",0));        
        waypoints.add( WaypointManager.CreateWayPoint("Valby", 3, new GregorianCalendar(2014,11,15,16,18), new GregorianCalendar(2014,11,15,16,30), "153", "Bus", "Vesterport",0));
        return RoutePlannerJourneyManager.CreateRoutePlannerJourney(waypoints, new GregorianCalendar(2014,11,15,15,15), new GregorianCalendar(2014,11,15,16,30), 5);
    }
}
