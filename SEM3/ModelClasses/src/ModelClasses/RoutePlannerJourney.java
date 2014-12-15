package ModelClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * RoutePlannerJourney Model Class. Stores a Route Planner journey object, for
 * distribution to web server. Uses an array of waypoints to store journey
 * information.
 *
 * @author Rasmus
 */
import javax.xml.bind.annotation.XmlRootElement;

//Set element to be the root element for the xml structure
@XmlRootElement(namespace = "RoutePlannerJourney")

public class RoutePlannerJourney implements Serializable {

    private ArrayList<Waypoint> waypoints;
    private GregorianCalendar arrival;
    private GregorianCalendar departure;
    private int zones;
    private int price;
    private int travelTimeDays;
    private int travelTimeHours;
    private int travelTimeMinutes;

    /**
     * Getter for the araylist of waypoints
     * @return waypoints
     */
    public ArrayList<Waypoint> getWaypoints() {
        return waypoints;
    }

    /**
     * Setter for the araylist of waypoints
     * @param waypoints
     */
    public void setWaypoints(ArrayList<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    /**
     * Constructor for the RoutePlannerJourney class.
     * @param waypoints
     * @param arrival
     * @param departure
     * @param zones
     * @param price
     * @param travelTimeDays
     * @param travelTimeHours
     * @param travelTimeMinutes
     */
    public RoutePlannerJourney(ArrayList<Waypoint> waypoints, GregorianCalendar arrival, GregorianCalendar departure, int zones, int price, int travelTimeDays, int travelTimeHours, int travelTimeMinutes) {
        this.waypoints = waypoints;
        this.arrival = arrival;
        this.departure = departure;
        this.zones = zones;
        this.price = price;
        this.travelTimeDays = travelTimeDays;
        this.travelTimeHours = travelTimeHours;
        this.travelTimeMinutes = travelTimeMinutes;
    }

    /**
     * Default 0-argument constructor used by the XML.
     */
    public RoutePlannerJourney() {
    }

    /**
     * Getter for the number of waypoints.
     * @return
     */
    public int getNumberofWaypoints() {
        return waypoints.size();
    }

    /**
     * Getter for the arrival time of the journey
     * @return
     */
    public GregorianCalendar getArrival() {
        return arrival;
    }

    /**
     * Setter for the arrival time of the journey
     * @param arrival
     */
    public void setArrival(GregorianCalendar arrival) {
        this.arrival = arrival;
    }

    /**
     * Getter for the departure time of the journey
     * @return
     */
    public GregorianCalendar getDeparture() {
        return departure;
    }

    /**
     * Setter for the arrival time of the journey
     * @param departure
     */
    public void setDeparture(GregorianCalendar departure) {
        this.departure = departure;
    }

    /**
     * Getter for the number of zones of the journey
     * @return
     */
    public int getZones() {
        return zones;
    }

    /**
     * Setter for the number of zones of the journey
     * @param zones
     */
    public void setZones(int zones) {
        this.zones = zones;
    }

    /**
     * Getter for the price of the journey
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for the price of the journey
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for the travel time in whole days, of the journey
     * @return
     */
    public int getTravelTimeDays() {
        return travelTimeDays;
    }

    /**
     * Setter for the travel time in whole days, of the journey
     * @param travelTimeDays
     */
    public void setTravelTimeDays(int travelTimeDays) {
        this.travelTimeDays = travelTimeDays;
    }

    /**
     * Getter for the travel time in whole hours, of the journey.
     * @return
     */
    public int getTravelTimeHours() {
        return travelTimeHours;
    }

    /**
     * Setter for the travel time in whole hours, of the journey.
     * @param travelTimeHours
     */
    public void setTravelTimeHours(int travelTimeHours) {
        this.travelTimeHours = travelTimeHours;
    }

    /**
     * Getter for the travel time in whole minutes, of the journey.
     * @return
     */
    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    /**
     * Setter for the travel time in whole minutes, of the journey.
     * @param travelTimeMinutes
     */
    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }

// Get methods to access Waypoint Array data.    

    /**
     * Getter for a Waypoints stop name at an index
     * @param index
     * @return
     */
        public String getWPStopName(int index) {
        return waypoints.get(index).getStopName();
    }

    /**
     * Getter for a Waypoints stop zone at an index
     * @param index
     * @return
     */
    public int getWPStopZone(int index) {
        return waypoints.get(index).getStopZone();
    }

    /**
     * Getter for a Waypoints arrival time at a stop, at an index
     * @param index
     * @return
     */
    public GregorianCalendar getWPArrivalTimeAtStop(int index) {
        return waypoints.get(index).getArrivalTimeAtStop();
    }

    /**
     * Getter for a Waypoints departure time from a stop, at an index
     * @param index
     * @return
     */
    public GregorianCalendar getWPDepartureTimeFromStop(int index) {
        return waypoints.get(index).getDepartureTimeFromStop();
    }

    /**
     * Getter for a Waypoints departure line, at an index
     * @param index
     * @return
     */
    public String getWPDepartureLine(int index) {
        return waypoints.get(index).getDepartureLine();
    }

    /**
     * Getter for a Waypoints departure type, at an index
     * @param index
     * @return
     */
    public String getWPDepartureType(int index) {
        return waypoints.get(index).getDepartureType();
    }

    /**
     * Getter for a Waypoints departure direction, at an index
     * @param index
     * @return
     */
    public String getWPDepartureDirection(int index) {
        return waypoints.get(index).getDepartureDirection();
    }

    /**
     * Getter for a Waypoints change counter, at an index
     * @param index
     * @return
     */
    public int getWPChangeCounter(int index) {
        return waypoints.get(index).getChangeCounter();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.waypoints);
        hash = 97 * hash + Objects.hashCode(this.arrival);
        hash = 97 * hash + Objects.hashCode(this.departure);
        hash = 97 * hash + this.zones;
        hash = 97 * hash + this.price;
        hash = 97 * hash + this.travelTimeDays;
        hash = 97 * hash + this.travelTimeHours;
        hash = 97 * hash + this.travelTimeMinutes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoutePlannerJourney other = (RoutePlannerJourney) obj;
        if (!Objects.equals(this.waypoints, other.waypoints)) {
            return false;
        }
        if (!Objects.equals(this.arrival, other.arrival)) {
            return false;
        }
        if (!Objects.equals(this.departure, other.departure)) {
            return false;
        }
        if (this.zones != other.zones) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.travelTimeDays != other.travelTimeDays) {
            return false;
        }
        if (this.travelTimeHours != other.travelTimeHours) {
            return false;
        }
        if (this.travelTimeMinutes != other.travelTimeMinutes) {
            return false;
        }
        return true;
    }

    /**
     * Test output method used for confirmation of route planner function.
     * outputs all information stored in the route planner journey class
     * and all contained waypoints.
     */
    public void testOutput() {

        System.err.println("**** RoutePlannerJourney ****");
        System.err.println("Departure Station: " + getWPStopName(0));
        System.err.println("Destination Station: " + getWPStopName(getNumberofWaypoints() - 1));
        System.err.println("Departure: " + "Year: " + getDeparture().get(GregorianCalendar.YEAR) + " date: " + getDeparture().get(GregorianCalendar.DATE) + ", hours: " + getDeparture().get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + getDeparture().get(GregorianCalendar.MINUTE));
        System.err.println("Arrival: " + getArrival().get(GregorianCalendar.YEAR) + " date: " + getArrival().get(GregorianCalendar.DATE) + ", hours: " + getArrival().get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + getArrival().get(GregorianCalendar.MINUTE));
        System.err.println("Number of waypoints: " + getNumberofWaypoints());
        System.err.println("Number of zones: " + getZones());
        System.err.println("Price: " + getPrice() + " kr.");
        System.err.println("Travel Time days: " + getTravelTimeDays());
        System.err.println("Travel Time hours: " + getTravelTimeHours());
        System.err.println("Travel Time minutes: " + getTravelTimeMinutes());
        for (int i = 0; i < getNumberofWaypoints(); i++) {
            System.err.println("**** Waypoint " + i + " ****");
            System.err.println("waypoint " + i + ": StopName: " + getWPStopName(i));
            System.err.println("waypoint " + i + ": StopZone: " + getWPStopZone(i));
            System.err.println("waypoint " + i + ": arrivalTimeAtStop: " + "Year: " + getWPArrivalTimeAtStop(i).get(GregorianCalendar.YEAR) + " date: " + getWPArrivalTimeAtStop(i).get(GregorianCalendar.DATE) + ", hours: " + getWPArrivalTimeAtStop(i).get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + getWPArrivalTimeAtStop(i).get(GregorianCalendar.MINUTE));
            if (getWPDepartureTimeFromStop(i) != null) {
                System.err.println("waypoint " + i + ": DepartureTimeFromStop: " + "Year: " + getWPDepartureTimeFromStop(i).get(GregorianCalendar.YEAR) + " date: " + getWPDepartureTimeFromStop(i).get(GregorianCalendar.DATE) + ", hours: " + getWPDepartureTimeFromStop(i).get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + getWPDepartureTimeFromStop(i).get(GregorianCalendar.MINUTE));
                System.err.println("waypoint " + i + ": Departure Line: " + getWPDepartureLine(i));
                System.err.println("waypoint " + i + ": Departure type: " + getWPDepartureType(i));
                System.err.println("waypoint " + i + ": Departure Direction: " + getWPDepartureDirection(i));
            }
            System.err.println("waypoint " + i + ": Change Counter: " + getWPChangeCounter(i));
        }
    }
}
