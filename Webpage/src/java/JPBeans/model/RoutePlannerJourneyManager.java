/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPBeans.model;

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

        // calculate travel time for waypoints
        // Travel time is the time between departing from a stop (index) and arriving at the following stop (index+1)
        for (int i = 0; i < waypoints.size() - 1; i++) {
            waypoints.get(i).setTravelTimeDays((int) (Math.floor((waypoints.get(i + 1).getArrivalTimeAtStop().getTimeInMillis()
                    - waypoints.get(i).getDepartureTimeFromStop().getTimeInMillis()) / (HOURS * MINUTES * SECONDS * MILLISECONDS))));

            // GetTravelTimeHours returns the number of whole hours. returns only hours in excess of whole days.
            int temp = (int) (Math.floor((waypoints.get(i + 1).getArrivalTimeAtStop().getTimeInMillis()
                    - waypoints.get(i).getDepartureTimeFromStop().getTimeInMillis()) / (MINUTES * SECONDS * MILLISECONDS)));
            temp = temp - (24 * ((int) (Math.floor(temp / 24))));
            waypoints.get(i).setTravelTimeHours(temp);

            // getTravelTimeMinutes returns the number of whole minutes. Returns only minutes in excess of whole hours.  
           // System.err.println("travel time: i:"+i+" (i + 1).getArrivalTimeAtStop: "+waypoints.get(i + 1).getArrivalTimeAtStop().getTimeInMillis()+"(i).getDepartureTimeFromStop(): "+waypoints.get(i).getDepartureTimeFromStop().getTimeInMillis());
            int temp2 = (int) (Math.floor((waypoints.get(i + 1).getArrivalTimeAtStop().getTimeInMillis()
                    - waypoints.get(i).getDepartureTimeFromStop().getTimeInMillis()) / (SECONDS * MILLISECONDS)));
            temp2 = temp2 - (60 * ((int) (Math.floor(temp2 / 60))));
            waypoints.get(i).setTravelTimeMinutes(temp2);
        }

        int price = zones*1000;
        long deltaT = arrival.getTimeInMillis() - departure.getTimeInMillis();
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
                System.err.println("waypoint " + i + ": Wait time days: " + rPJ.getWPWaitTimeDays(i));
                System.err.println("waypoint " + i + ": Wait time Hours: " + rPJ.getWPWaitTimeHours(i));
                System.err.println("waypoint " + i + ": Wait time Minutes: " + rPJ.getWPWaitTimeMinutes(i));
                System.err.println("waypoint " + i + ": Travel time days: " + rPJ.getTravelTimeDays(i));
                System.err.println("waypoint " + i + ": Travel time hours: " + rPJ.getTravelTimeHours(i));
                System.err.println("waypoint " + i + ": Travel time minutes: " + rPJ.getTravelTimeMinutes(i));
                System.err.println("waypoint " + i + ": Departure Line: " + rPJ.getWPDepartureLine(i));
                System.err.println("waypoint " + i + ": Departure type: " + rPJ.getWPDepartureType(i));
                System.err.println("waypoint " + i + ": Departure Direction: " + rPJ.getWPDepartureDirection(i));
                System.err.println("waypoint " + i + ": Change Counter: " + rPJ.getWPChangeCounter(i));
            }
        }
    }
}
