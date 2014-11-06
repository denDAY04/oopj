package JPBeans.model;

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
public class RoutePlannerJourney {

    private ArrayList<Waypoint> waypoints;
    private GregorianCalendar arrival;
    private GregorianCalendar departure;
    private int zones;
    private int price;
    private int travelTimeDays;
    private int travelTimeHours;
    private int travelTimeMinutes;

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

    public int getWPWaitTimeDays(int index) {
        return waypoints.get(index).getWaitTimeDays();
    }

    public int getWPWaitTimeHours(int index) {
        return waypoints.get(index).getWaitTimeHours();
    }

    public int getWPWaitTimeMinutes(int index) {
        return waypoints.get(index).getWaitTimeMinutes();
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
    
    
        public int getTravelTimeDays(int index) {
        return waypoints.get(index).getTravelTimeDays();
    }    

    public int getTravelTimeHours(int index) {
        return waypoints.get(index).getTravelTimeHours();
    }    

    public int getTravelTimeMinutes(int index) {
        return waypoints.get(index).getTravelTimeMinutes();
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
}
