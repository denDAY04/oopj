package ModelClasses;

import java.util.GregorianCalendar;

/**
 * Waypoint Manager class.
 * This class was used for calculations of data stored in the waypoints.
 * since this function was moved to the receiver, the class has been left
 * un-utilized.
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
