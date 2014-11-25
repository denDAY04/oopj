/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPBeans.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author Rasmus
 */
public class Stop implements Serializable{

    /**
     * Stop class stores all the information about the current stop. Tracks the
     * best time at stop in timeAtStop, and the way to get there in the
     * previousStop and previousStopLink.
     */
    public String name;
    public int zoneNumber;
    public long longitude, latitude;

    public StopLink[] links;

    public Stop previousStop = null;
    public StopLink previousStopLink = null;
    public GregorianCalendar timeAtStop = new GregorianCalendar(2050, 1, 1, 1, 1, 1);
    public GregorianCalendar DepartureTimeFromPreviousStop = new GregorianCalendar(2050, 1, 1, 1, 1, 1);
    public long expTimetoGoal; // calculated MS time to the goal.
    public int maximumSpeed;

    /**
     * Standard constructor for stop objects. longitude and latitude are
     * positive and given in the same coordinate system as other stops, in
     * kilometers.
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
        this.expTimetoGoal = (long) (Math.sqrt((deltaLatitude * deltaLatitude) + (deltaLongitude * deltaLongitude)) * ((60 * 60 * 1000) / maximumSpeed)); // for time in MS @ 100km / h
    }
}
