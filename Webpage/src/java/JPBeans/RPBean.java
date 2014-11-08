/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans;

import JPBeans.model.RoutePlannerJourney;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author Qesss
 */
public class RPBean implements Serializable{

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
        this.origin="ballerup";
        this.destination="valby";
        
    }
    
    GregorianCalendar startTime;
    
    private int year;   
    private int month;
    private int day;    
    private int hour;
    private int minute;    
    private String stringrpj;
    private RoutePlannerJourney rpj;
    private RPJSkel rPJSkel;
    private String origin;
    private String destination;
    private int currentwaypoint=0;
    
    
    public int getNumberofwaypoints(){
    
        if (rpj==null) return 0;
        
    return  rpj.getNumberofWaypoints();
    }
    
    public void setNextwaypoint(int currentwaypoint){
        this.currentwaypoint=currentwaypoint;
    }
    
    public String getStop(){

    return rpj.getWPStopName(currentwaypoint);
    }
    
    public int getNextwaypoint(){
        currentwaypoint++;
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

//    public RoutePlannerJourney getRPJ() {
//        return rPJ;
//    }
    
        public String getStringrpj() {
        return stringrpj;
    }

    public void setStringrpj(String var) {
        rpj = rPJSkel.createRouteplannerJourney(origin, destination,  startTime);
        this.stringrpj = rpj.getWPStopName(1);
    }

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
    
}
