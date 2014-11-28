package ModelClasses;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Waypoint Model class used as inner class for the RoutePlannerJourney Model
 * Class. This class stores all information about a stop in a journey, and
 * information about the transport to the following stop.
 *
 * @author Rasmus
 */
public class Waypoint implements Serializable {

    private String StopName;
    private int StopZone;
    private GregorianCalendar arrivalTimeAtStop;
    private GregorianCalendar DepartureTimeFromStop;
    private String departureLine;
    private String departureType;
    private String departureDirection;
    private int changeCounter;

    public int getChangeCounter() {
        return changeCounter;
    }

    public void setChangeCounter(int changeCounter) {
        this.changeCounter = changeCounter;
    }

    public Waypoint(String StopName, int StopZone, GregorianCalendar arrivalTimeAtStop, GregorianCalendar DepartureTimeFromStop, String departureLine, String departureType, String departureDirection, int changeCounter) {
        this.StopName = StopName;
        this.StopZone = StopZone;
        this.arrivalTimeAtStop = arrivalTimeAtStop;
        this.DepartureTimeFromStop = DepartureTimeFromStop;
        this.departureLine = departureLine;
        this.departureType = departureType;
        this.departureDirection = departureDirection;
        this.changeCounter = changeCounter;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String StopName) {
        this.StopName = StopName;
    }

    public int getStopZone() {
        return StopZone;
    }

    public void setStopZone(int StopZone) {
        this.StopZone = StopZone;
    }

    public GregorianCalendar getArrivalTimeAtStop() {
        return arrivalTimeAtStop;
    }

    public void setArrivalTimeAtStop(GregorianCalendar arrivalTimeAtStop) {
        this.arrivalTimeAtStop = arrivalTimeAtStop;
    }

    public GregorianCalendar getDepartureTimeFromStop() {
        return DepartureTimeFromStop;
    }

    public void setDepartureTimeFromStop(GregorianCalendar DepartureTimeFromStop) {
        this.DepartureTimeFromStop = DepartureTimeFromStop;
    }

    public String getDepartureLine() {
        return departureLine;
    }

    public void setDepartureLine(String departureLine) {
        this.departureLine = departureLine;
    }

    public String getDepartureType() {
        return departureType;
    }

    public void setDepartureType(String departureType) {
        this.departureType = departureType;
    }

    public String getDepartureDirection() {
        return departureDirection;
    }

    public void setDepartureDirection(String departureDirection) {
        this.departureDirection = departureDirection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.StopName);
        hash = 53 * hash + this.StopZone;
        hash = 53 * hash + Objects.hashCode(this.arrivalTimeAtStop);
        hash = 53 * hash + Objects.hashCode(this.DepartureTimeFromStop);
        hash = 53 * hash + Objects.hashCode(this.departureLine);
        hash = 53 * hash + Objects.hashCode(this.departureType);
        hash = 53 * hash + Objects.hashCode(this.departureDirection);
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
        final Waypoint other = (Waypoint) obj;
        if (!Objects.equals(this.StopName, other.StopName)) {
            return false;
        }
        if (this.StopZone != other.StopZone) {
            return false;
        }
        if (!Objects.equals(this.arrivalTimeAtStop, other.arrivalTimeAtStop)) {
            return false;
        }
        if (!Objects.equals(this.DepartureTimeFromStop, other.DepartureTimeFromStop)) {
            return false;
        }
        if (!Objects.equals(this.departureLine, other.departureLine)) {
            return false;
        }
        if (!Objects.equals(this.departureType, other.departureType)) {
            return false;
        }
        if (!Objects.equals(this.departureDirection, other.departureDirection)) {
            return false;
        }
        return true;
    }

}
