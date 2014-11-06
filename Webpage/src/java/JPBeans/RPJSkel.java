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
        waypoints.add(0, WaypointManager.CreateWayPoint("Ballerup", 6, new GregorianCalendar(), new GregorianCalendar(), "B", "Train", "Valby"));
        waypoints.add(0, WaypointManager.CreateWayPoint("Skovlunde", 5, new GregorianCalendar(), new GregorianCalendar(), "B", "Train", "Valby"));
        waypoints.add(0, WaypointManager.CreateWayPoint("Malmparken", 4, new GregorianCalendar(), new GregorianCalendar(), "153", "Bus", "Vesterport"));
        waypoints.add(0, WaypointManager.CreateWayPoint("Herlev", 3, new GregorianCalendar(), new GregorianCalendar(), "153", "Bus", "Vesterport"));
        return RoutePlannerJourneyManager.CreateRoutePlannerJourney(waypoints, new GregorianCalendar(), new GregorianCalendar(), 4);
    }
}