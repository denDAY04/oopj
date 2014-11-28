/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClasses;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * RoutePlannerJourneyManager bla bla bla Not implementing index out of bounds
 * or nullpointer checks
 *
 * @author Rasmus
 */
public class RoutePlannerJourneyManager {

    private static final int HOURS = 24;
    private static final int MINUTES = 60;
    private static final int SECONDS = 60;
    private static final int MILLISECONDS = 1000;

    /**
     * Default constructor for the RoutePlannerJourney model object
     *
     * @param waypoints
     * @param arrival
     * @param departure
     * @param zones
     * @return
     */
    public static RoutePlannerJourney CreateRoutePlannerJourney(ArrayList<Waypoint> waypoints, GregorianCalendar arrival, GregorianCalendar departure, int zones) {

        int price = 1200*zones;
        long deltaT = arrival.getTimeInMillis() - waypoints.get(0).getDepartureTimeFromStop().getTimeInMillis();
        int travelTimeDays = (int) (Math.floor(deltaT / (HOURS * MINUTES * SECONDS * MILLISECONDS)));
        int travelTimeHours = (int) (Math.floor(deltaT / (MINUTES * SECONDS * MILLISECONDS))) - (travelTimeDays * HOURS);
        int travelTimeMinutes = (int) (Math.floor(deltaT / (SECONDS * MILLISECONDS))) - (travelTimeDays * HOURS * MINUTES) - (travelTimeHours * MINUTES);

        return new RoutePlannerJourney(waypoints, arrival, departure, zones, price, travelTimeDays, travelTimeHours, travelTimeMinutes);
    }

    // Test output method.
    public static void testOutput(RoutePlannerJourney rPJ) {

        System.err.println("**** RoutePlannerJourney ****");
        System.err.println("Departure Station: " + rPJ.getWPStopName(0));
        System.err.println("Destination Station: " + rPJ.getWPStopName(rPJ.getNumberofWaypoints() - 1));
        System.err.println("Departure: " + "Year: " + rPJ.getDeparture().get(GregorianCalendar.YEAR) + " date: " + rPJ.getDeparture().get(GregorianCalendar.DATE) + ", hours: " + rPJ.getDeparture().get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + rPJ.getDeparture().get(GregorianCalendar.MINUTE));
        System.err.println("Arrival: " + rPJ.getArrival().get(GregorianCalendar.YEAR) + " date: " + rPJ.getArrival().get(GregorianCalendar.DATE) + ", hours: " + rPJ.getArrival().get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + rPJ.getArrival().get(GregorianCalendar.MINUTE));
        System.err.println("Number of waypoints: " + rPJ.getNumberofWaypoints());
        System.err.println("Number of zones: " + rPJ.getZones());
        System.err.println("Price: " + rPJ.getPrice() + " kr.");
        System.err.println("Travel Time days: " + rPJ.getTravelTimeDays());
        System.err.println("Travel Time hours: " + rPJ.getTravelTimeHours());
        System.err.println("Travel Time minutes: " + rPJ.getTravelTimeMinutes());
        for (int i = 0; i < rPJ.getNumberofWaypoints(); i++) {
            System.err.println("**** Waypoint " + i + " ****");
            System.err.println("waypoint " + i + ": StopName: " + rPJ.getWPStopName(i));
            System.err.println("waypoint " + i + ": StopZone: " + rPJ.getWPStopZone(i));
            System.err.println("waypoint " + i + ": arrivalTimeAtStop: " + "Year: " + rPJ.getWPArrivalTimeAtStop(i).get(GregorianCalendar.YEAR) + " date: " + rPJ.getWPArrivalTimeAtStop(i).get(GregorianCalendar.DATE) + ", hours: " + rPJ.getWPArrivalTimeAtStop(i).get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + rPJ.getWPArrivalTimeAtStop(i).get(GregorianCalendar.MINUTE));
            if (rPJ.getWPDepartureTimeFromStop(i) != null) {
                System.err.println("waypoint " + i + ": DepartureTimeFromStop: " + "Year: " + rPJ.getWPDepartureTimeFromStop(i).get(GregorianCalendar.YEAR) + " date: " + rPJ.getWPDepartureTimeFromStop(i).get(GregorianCalendar.DATE) + ", hours: " + rPJ.getWPDepartureTimeFromStop(i).get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + rPJ.getWPDepartureTimeFromStop(i).get(GregorianCalendar.MINUTE));
                System.err.println("waypoint " + i + ": Departure Line: " + rPJ.getWPDepartureLine(i));
                System.err.println("waypoint " + i + ": Departure type: " + rPJ.getWPDepartureType(i));
                System.err.println("waypoint " + i + ": Departure Direction: " + rPJ.getWPDepartureDirection(i));
                System.err.println("waypoint " + i + ": Change Counter: " + rPJ.getWPChangeCounter(i));
            }
        }
    }
}
