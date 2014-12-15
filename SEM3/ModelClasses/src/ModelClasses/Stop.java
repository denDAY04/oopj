package ModelClasses;

import java.io.Serializable;
import java.util.GregorianCalendar;

    /**
     * Stop class stores all the information about a stop. Tracks the
     * fastest time at stop in timeAtStop, and the way to get there in the
     * previousStop and previousStopLink.
     * Also contains geographical information, used in the heuristic.
     *  @author Rasmus
     */
public class Stop implements Serializable{


    public String name;
    public int zoneNumber;
    // location used for heuristic
    public long longitude, latitude;
    // Array of connections to and from this stop.
    public StopLink[] links;
    // used for backtracking though the graph.
    public Stop previousStop = null;
    public StopLink previousStopLink = null;
    // used for finding the fastest arrival time
    public GregorianCalendar timeAtStop = new GregorianCalendar(2050, 1, 1, 1, 1, 1);
    // used for displaying both departure and arrival times.
    public GregorianCalendar DepartureTimeFromPreviousStop = new GregorianCalendar(2050, 1, 1, 1, 1, 1);
    // the heuristic time, calculated from the euclidian distance
    public long expTimetoGoal; // calculated MS time to the goal.
    public int maximumSpeed;

    /**
     * Standard constructor for stop objects. longitude and latitude are
     * positive and given in the same coordinate system as other stops.
     *
     * @param name
     * @param zoneNumber
     * @param longitude
     * @param latitude
     * @param maximumSpeed
     */
    public Stop(String name, int zoneNumber, long longitude, long latitude, int maximumSpeed) {
        this.name = name;
        this.zoneNumber = zoneNumber;
        this.longitude = longitude;
        this.latitude = latitude;
        this.maximumSpeed = maximumSpeed;
    }

    /**
     * Method to set the Stop Links, after creation of destinationStop.
     *
     * @param linkArr
     */
    public void setStopLink(StopLink[] linkArr) {
        this.links = linkArr;
    }

    /**
     * Heuristic calculation method. Using Pythagoras and a fixed maximum speed
     * (100 km/h) an expected time to goal is calculated. Euclidian distance /
     * Speed.
     *
     * @param goal
     */
    public final void calcExpDistGoal(Stop goal) {
        long deltaLatitude = Math.abs(latitude - goal.latitude);
        long deltaLongitude = Math.abs(longitude - goal.longitude);
  // local variables for magic numbers 60, 1000 etc (e.g. seconds, minutes etc)
        this.expTimetoGoal = (long) (Math.sqrt((deltaLatitude * deltaLatitude) + 
                             (deltaLongitude * deltaLongitude)) * 
                             ((60 * 60 * 1000) / maximumSpeed)); // for time in MS @ 100km / h
    }
}
