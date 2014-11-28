/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import java.util.GregorianCalendar;

/**
 *
 * @author Rasmus
 */
public class WaypointManager {

    /**
     * Constructor for the Waypoint class
     *
     * @param StopName
     * @param StopZone
     * @param arrivalTimeAtStop
     * @param DepartureTimeFromStop
     * @param departureLine
     * @param departureType
     * @param departureDirection
     * @return
     */
    public static Waypoint CreateWayPoint(String StopName, int StopZone, GregorianCalendar arrivalTimeAtStop, GregorianCalendar DepartureTimeFromStop, String departureLine, String departureType, String departureDirection, int changeCounter) {
        return new Waypoint(StopName, StopZone, arrivalTimeAtStop, DepartureTimeFromStop, departureLine, departureType, departureDirection, changeCounter);
    }
}
