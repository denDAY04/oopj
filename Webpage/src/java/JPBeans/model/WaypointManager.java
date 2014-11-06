/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans.model;

import java.util.GregorianCalendar;

/**
 *
 * @author Qesss
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
    
    public static Waypoint CreateWayPoint(String StopName, int StopZone, GregorianCalendar arrivalTimeAtStop, GregorianCalendar DepartureTimeFromStop, String departureLine, String departureType, String departureDirection){
     final int HOURS = 24;
     final int MINUTES = 60;
     final int SECONDS = 60;    
     final int MILLISECONDS = 1000;   
        
          int waitTimeDays=0;
          int waitTimeHours=0;
          int waitTimeMinutes=0;
          
        // The last waypoint will not have any departure time, and thus no wait time
        if ((DepartureTimeFromStop != null) & (arrivalTimeAtStop != null)) { 
          long deltaT = DepartureTimeFromStop.getTimeInMillis() - arrivalTimeAtStop.getTimeInMillis();
          waitTimeDays = (int)(Math.floor(deltaT/(HOURS * MINUTES * SECONDS * MILLISECONDS)));
          waitTimeHours = (int)(Math.floor(deltaT/(MINUTES * SECONDS * MILLISECONDS))-(waitTimeDays*HOURS));
          waitTimeMinutes =(int)(Math.floor(deltaT/(SECONDS * MILLISECONDS))-(waitTimeDays*HOURS*MINUTES)-(waitTimeHours*MINUTES));
        }
    
    return new Waypoint(StopName, StopZone, arrivalTimeAtStop, waitTimeDays, waitTimeHours, waitTimeMinutes, DepartureTimeFromStop, departureLine, departureType, departureDirection);

        }
    }
    