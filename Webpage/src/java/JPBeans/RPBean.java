/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPBeans;

import ModelClasses.RoutePlannerJourney;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author Rasmus
 */
public class RPBean implements Serializable {

    public RPBean() {
        this.startTime = new GregorianCalendar(TimeZone.getTimeZone("Europe/Copenhagen"));
        startTime.add(GregorianCalendar.MINUTE, 5); // add 5 minute
        this.year = startTime.get(GregorianCalendar.YEAR);
        this.month = startTime.get(GregorianCalendar.MONTH);
        this.day = startTime.get(GregorianCalendar.DAY_OF_MONTH);
        this.hour = startTime.get(GregorianCalendar.HOUR_OF_DAY);
        this.minute = startTime.get(GregorianCalendar.MINUTE);
        this.rPJSkel = new RPJSkel();
        // test
        this.origin = "Ballerup";
        this.destination = "Husum";

    }

    GregorianCalendar startTime;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private RoutePlannerJourney rpj;
    private RPJSkel rPJSkel;
    private String origin;
    private int originint;
    private String destination;
    private int destinationint;
    private int currentwaypoint = 0;
    private boolean getOn = true;
    private int departureStopIndex;
    private static final int HOURS = 24;
    private static final int MINUTES = 60;
    private static final int SECONDS = 60;
    private static final int MILLISECONDS = 1000;

    public int getNumberofwaypoints() {

        if (rpj == null) {
            return 0;
        }
        // get the total number of changes
        return 2 + (2 * rpj.getWPChangeCounter(0)); //Determines times JSP loop runs
    }

    public void setNextwaypoint(int currentwaypoint) {
        this.currentwaypoint = currentwaypoint;
    }
    
    public String getZones(){

        ArrayList<String> zoneCount = new ArrayList();

        for (int i = 0; i < rpj.getNumberofWaypoints(); i++) {
            if (!zoneCount.contains(""+rpj.getWPStopZone(i)))
         zoneCount.add(rpj.getWPStopZone(i)+"");    
        }
        String output="";
        for (String zc : zoneCount) {
            output=output+" "+zc;
        }
        
        return output;
    }
    
    
    public int getZonecount(){
    return rpj.getZones();
    }
    public String getPrice(){
        int wholecrowns = rpj.getPrice()/100;
        int ore = rpj.getPrice()-(wholecrowns*100);
    return wholecrowns+"."+String.format("%02d",ore)+" kr.";
    }
    
    public int getChangecount(){
    return rpj.getWPChangeCounter(0);
    }
    
    public String getTotalduration(){

    return rpj.getTravelTimeHours()+":"+String.format("%02d",rpj.getTravelTimeMinutes());
    }

    public String getStop() {

        return rpj.getWPStopName(currentwaypoint);
    }

    public String getWaypointtransport() {
        if (getOn) {
            getOn = false;
            
            departureStopIndex = currentwaypoint;
            if (currentwaypoint>0){departureStopIndex--;}
            if (currentwaypoint == 0) {
                return "Take " + rpj.getWPDepartureType(currentwaypoint) + " " + rpj.getWPDepartureLine(currentwaypoint) + " from " + rpj.getWPStopName(currentwaypoint) + " towards " + rpj.getWPDepartureDirection(currentwaypoint);
            } else {
                return "Take " + rpj.getWPDepartureType(currentwaypoint) + " " + rpj.getWPDepartureLine(currentwaypoint) + " from " + rpj.getWPStopName(currentwaypoint - 1) + " towards " + rpj.getWPDepartureDirection(currentwaypoint);
            }

        } else {
            getOn = true;
            
            if (currentwaypoint == rpj.getNumberofWaypoints())
            return " Get off " + rpj.getWPDepartureType(currentwaypoint-1) + " " + rpj.getWPDepartureLine(currentwaypoint-1) + " at " + rpj.getWPStopName(currentwaypoint-1);
            return " Get off " + rpj.getWPDepartureType(currentwaypoint-1) + " " + rpj.getWPDepartureLine(currentwaypoint-1) + " at " + rpj.getWPStopName(currentwaypoint);
        }

    }

    public String getTime() {
        if (getOn) {
            String waittime = "";
            if (currentwaypoint > 0) {

                //int days = (int)(Math.floor((rpj.getWPArrivalTimeAtStop(currentwaypoint).getTimeInMillis() - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (HOURS * MINUTES * SECONDS * MILLISECONDS)));
                int hours = (int) (Math.floor((rpj.getWPDepartureTimeFromStop(currentwaypoint-1).getTimeInMillis()
                        - rpj.getWPArrivalTimeAtStop(currentwaypoint-1).getTimeInMillis()) / (MINUTES * SECONDS * MILLISECONDS)));
                hours = hours - (24 * ((int) (Math.floor(hours / 24))));

                int minutes = (int) (Math.floor(((rpj.getWPDepartureTimeFromStop(currentwaypoint-1).getTimeInMillis()
                        - rpj.getWPArrivalTimeAtStop(currentwaypoint-1).getTimeInMillis()) / (SECONDS * MILLISECONDS))));
                minutes = minutes - (60 * ((int) (Math.floor(minutes / 60))));

                waittime = "&nbsp &nbsp &nbsp &nbsp Wait time:" + String.format("%02d", hours) + ":" + String.format("%02d", minutes);
            }
            if (currentwaypoint == 0) {
                return "Departure:" + String.format("%02d", rpj.getWPDepartureTimeFromStop(currentwaypoint).get(GregorianCalendar.HOUR_OF_DAY)) + ":" + String.format("%02d", rpj.getWPDepartureTimeFromStop(currentwaypoint).get(GregorianCalendar.MINUTE)) + waittime;
            } else {
                return "Departure:" + String.format("%02d", rpj.getWPDepartureTimeFromStop(currentwaypoint - 1).get(GregorianCalendar.HOUR_OF_DAY)) + ":" + String.format("%02d", rpj.getWPDepartureTimeFromStop(currentwaypoint - 1).get(GregorianCalendar.MINUTE)) + waittime;
            }
        } else {

            if (currentwaypoint==rpj.getNumberofWaypoints()){
                            //int days = (int)(Math.floor((rpj.getWPArrivalTimeAtStop(currentwaypoint).getTimeInMillis() - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (HOURS * MINUTES * SECONDS * MILLISECONDS)));
            int hours = (int) (Math.floor(rpj.getWPArrivalTimeAtStop(currentwaypoint-1).getTimeInMillis()
                    - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (MINUTES * SECONDS * MILLISECONDS));
            hours = hours - (24 * ((int) (Math.floor(hours / 24))));

            int minutes = (int) (Math.floor((rpj.getWPArrivalTimeAtStop(currentwaypoint-1).getTimeInMillis()
                    - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (SECONDS * MILLISECONDS)));
            minutes = minutes - (60 * ((int) (Math.floor(minutes / 60))));
                return "Arrival: &nbsp &nbsp" + String.format("%02d", rpj.getWPArrivalTimeAtStop(currentwaypoint-1).get(GregorianCalendar.HOUR_OF_DAY)) + ":" + String.format("%02d", rpj.getWPArrivalTimeAtStop(currentwaypoint-1).get(GregorianCalendar.MINUTE)) + " &nbsp &nbsp &nbsp &nbsp  Duration: " + String.format("%02d", hours) + ":" + String.format("%02d", minutes);
            }
                        //int days = (int)(Math.floor((rpj.getWPArrivalTimeAtStop(currentwaypoint).getTimeInMillis() - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (HOURS * MINUTES * SECONDS * MILLISECONDS)));
            int hours = (int) (Math.floor(rpj.getWPArrivalTimeAtStop(currentwaypoint).getTimeInMillis()
                    - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (MINUTES * SECONDS * MILLISECONDS));
            hours = hours - (24 * ((int) (Math.floor(hours / 24))));

            int minutes = (int) (Math.floor((rpj.getWPArrivalTimeAtStop(currentwaypoint).getTimeInMillis()
                    - rpj.getWPDepartureTimeFromStop(departureStopIndex).getTimeInMillis()) / (SECONDS * MILLISECONDS)));
            minutes = minutes - (60 * ((int) (Math.floor(minutes / 60))));
            return "Arrival: &nbsp &nbsp" + String.format("%02d", rpj.getWPArrivalTimeAtStop(currentwaypoint).get(GregorianCalendar.HOUR_OF_DAY)) + ":" + String.format("%02d", rpj.getWPArrivalTimeAtStop(currentwaypoint).get(GregorianCalendar.MINUTE)) + " &nbsp &nbsp &nbsp &nbsp  Duration: " + String.format("%02d", hours) + ":" + String.format("%02d", minutes);
            }

        }
    

 public int getNextwaypoint() {
        currentwaypoint++;
        if ((currentwaypoint + 1) < rpj.getNumberofWaypoints()) {
            if (rpj.getWPChangeCounter(currentwaypoint) != rpj.getWPChangeCounter(currentwaypoint - 1)) {
                return 0;
            }

            while (rpj.getWPChangeCounter(currentwaypoint) == rpj.getWPChangeCounter(currentwaypoint + 1)) {
                currentwaypoint++;
                if (rpj.getWPChangeCounter(currentwaypoint) != rpj.getWPChangeCounter(currentwaypoint - 1)) {
                    return 0;
                }

                if (((currentwaypoint + 1) >= rpj.getNumberofWaypoints())) {
                    return 0;
                }
            }
        }
        return 0;

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    // Method for
    
    public void setDorouteplanning(String var) throws Exception {
        // reset
            currentwaypoint = 0;
            getOn = true;
            departureStopIndex=0;
//       try{
        rpj = rPJSkel.createRouteplannerJourney(originint, destinationint, startTime);
//          }
//       catch (InterruptedException //| TimeoutException | ExecutionException 
//               e) {
//timeout
//}
    }
    
    // Getters and setters for the field on the website.

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        startTime.set(GregorianCalendar.YEAR, year);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        startTime.set(GregorianCalendar.MONTH, month);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        startTime.set(GregorianCalendar.DAY_OF_MONTH, day);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        startTime.set(GregorianCalendar.HOUR_OF_DAY, hour);
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        startTime.set(GregorianCalendar.MINUTE, minute);
    }

    public void setOriginint(int o){
    this.originint = o;
    }
    
    public void setDestinationint(int d){
    this.destinationint = d;
    }
    
    
}
