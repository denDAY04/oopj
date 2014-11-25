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
	 
	//Below statement means that class 'Country.java' is the root-element of our example
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

    
    public ArrayList<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(ArrayList<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

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
    public RoutePlannerJourney(){}

    public int getNumberofWaypoints() {
        return waypoints.size();
    }

    public GregorianCalendar getArrival() {
        return arrival;
    }

    public void setArrival(GregorianCalendar arrival) {
        this.arrival = arrival;
    }

    public GregorianCalendar getDeparture() {
        return departure;
    }

    public void setDeparture(GregorianCalendar departure) {
        this.departure = departure;
    }

    public int getZones() {
        return zones;
    }

    public void setZones(int zones) {
        this.zones = zones;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTravelTimeDays() {
        return travelTimeDays;
    }

    public void setTravelTimeDays(int travelTimeDays) {
        this.travelTimeDays = travelTimeDays;
    }

    public int getTravelTimeHours() {
        return travelTimeHours;
    }

    public void setTravelTimeHours(int travelTimeHours) {
        this.travelTimeHours = travelTimeHours;
    }

    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }

// Get methods to access Waypoint Array data.    
    public String getWPStopName(int index) {
        return waypoints.get(index).getStopName();
    }

    public int getWPStopZone(int index) {
        return waypoints.get(index).getStopZone();
    }

    public GregorianCalendar getWPArrivalTimeAtStop(int index) {
        return waypoints.get(index).getArrivalTimeAtStop();
    }


    public GregorianCalendar getWPDepartureTimeFromStop(int index) {
        return waypoints.get(index).getDepartureTimeFromStop();
    }

    public String getWPDepartureLine(int index) {
        return waypoints.get(index).getDepartureLine();
    }

    public String getWPDepartureType(int index) {
        return waypoints.get(index).getDepartureType();
    }

    public String getWPDepartureDirection(int index) {
        return waypoints.get(index).getDepartureDirection();
    }
    public int getWPChangeCounter(int index){
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
                System.err.println("waypoint " + i + ": Change Counter: " + getWPChangeCounter(i));
            }
        }
    }
}
