/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPBeans.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.GregorianCalendar;

/**
 *
 * @author Rasmus
 */
public class StopLink implements Serializable{

    /**
     * The StopLink are the links between the stops. Each stoplink stores the
     * information about the path between two stops, and has a reference to the
     * database connection, to look up the next departure time. Stoplinks are
     * one way, as the departures are different in either direction.
     */
    public String type;
    public String line;
    public Stop fromStop; // fromStop of the link
    public Stop toStop;   // destination of the link
    public Stop towards;
    Connection con;

    /**
     * standard constructor for StopLink.
     *
     * @param type
     * @param line
     * @param fromStop
     * @param destinationStop
     * @param towards
     */
    public StopLink(String type, String line, Stop fromStop, Stop destinationStop, Stop towards) {
        this.type = type;
        this.line = line;
        this.fromStop = fromStop;
        this.toStop = destinationStop;
        this.towards = towards;

    }

    /**
     * getNextDeparture Method. Takes a GregorianCalendar object, and finds the
     * next departure for the current stoplink in the database, and returns 2
     * GregorianCalendar objects, an arrival time and a departure time. If no
     * journey is found, the earliest next morning is used instead.
     *
     * @param inputTime
     * @return
     */
    public GregorianCalendar[] getNextDeparture(GregorianCalendar inputTime,Connection con) {
        GregorianCalendar arrival = new GregorianCalendar();
        GregorianCalendar departure = new GregorianCalendar();

        arrival.setTimeInMillis(inputTime.getTimeInMillis());
        departure.setTimeInMillis(inputTime.getTimeInMillis());

        int hour = arrival.get(GregorianCalendar.HOUR_OF_DAY);
        int minute = arrival.get(GregorianCalendar.MINUTE);

        PreparedStatement preparedStatementGetToday;
        PreparedStatement preparedStatementGetTomorrow;
        Time nextArivalTime = null;
        Time departureTime = null;
        try {

                // NEEDS TO IMPLIMENT CHECK SQL CONNECTION, AND REESTABLISH LINK.
            // get next departure today
            preparedStatementGetToday = con.prepareStatement("select Departure, NextArrival FROM TimeTable "
                    + "WHERE(TransportationType = ? ) AND "
                    + "(Line = ?) AND "
                    + "(Station = ?) AND "
                    + "(Destination = ?) AND "
                    + "(Departure > ?)");
            preparedStatementGetToday.setMaxRows(1);
            preparedStatementGetToday.setString(1, type);
            preparedStatementGetToday.setString(2, line);
            preparedStatementGetToday.setString(3, fromStop.name);
            preparedStatementGetToday.setString(4, towards.name);
            preparedStatementGetToday.setTime(5, new Time(hour, minute, 0));

            ResultSet resultSet = preparedStatementGetToday.executeQuery();

            if (resultSet.next()) {
                // read the time data from the result set
                departureTime = resultSet.getTime(1);
                nextArivalTime = resultSet.getTime(2);
            }
            if (nextArivalTime == null) {

                // if resultset is empty, then get first arrival (next day)
                arrival.add(GregorianCalendar.DATE, 1);
                departure.add(GregorianCalendar.DATE, 1);

                preparedStatementGetTomorrow = con.prepareStatement("select Departure, NextArrival FROM TimeTable "
                        + "WHERE(TransportationType = ? ) AND "
                        + "(Line = ?) AND "
                        + "(Station = ?) AND "
                        + "(Destination = ?)");

                preparedStatementGetTomorrow.setMaxRows(1);
                preparedStatementGetTomorrow.setString(1, type);
                preparedStatementGetTomorrow.setString(2, line);
                preparedStatementGetTomorrow.setString(3, fromStop.name);
                preparedStatementGetTomorrow.setString(4, towards.name);

                ResultSet resultSet2 = preparedStatementGetTomorrow.executeQuery();
                if (resultSet2 != null) {
                    if (resultSet2.next()) {
                        departureTime = resultSet2.getTime(1);
                        nextArivalTime = resultSet2.getTime(2);

                    } else {
                        System.err.println("Result set 2 is empty, no times found!!!!");
                    }
                }
            }

        } catch (SQLException ex) {
            System.err.println("SQL EXCEPTION!!!!" + ex);
        }

        // use the recieved time to update the GregorianCalendar objects and return them.
        arrival.set(GregorianCalendar.HOUR_OF_DAY, nextArivalTime.getHours());
        arrival.set(GregorianCalendar.MINUTE, nextArivalTime.getMinutes());

        departure.set(GregorianCalendar.HOUR_OF_DAY, departureTime.getHours());
        departure.set(GregorianCalendar.MINUTE, departureTime.getMinutes());
        GregorianCalendar[] returnarray = new GregorianCalendar[2];
        returnarray[0] = arrival;
        returnarray[1] = departure;
              // String time1 = " Departure: " + "Year: " + departure.get(GregorianCalendar.YEAR) + " date: " + departure.get(GregorianCalendar.DATE) + ", hours: " + departure.get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + departure.get(GregorianCalendar.MINUTE)+", ";
              // String time2 = "Arrival: " + "Year: " + arrival.get(GregorianCalendar.YEAR) + " date: " + arrival.get(GregorianCalendar.DATE) + ", hours: " + arrival.get(GregorianCalendar.HOUR_OF_DAY) + ", minutes:  " + arrival.get(GregorianCalendar.MINUTE);
              // System.err.println("SQL: from: "+fromStop.name+" to "+toStop.name);
              // System.err.println(time1);
              // System.err.println(time2);
   
        
        return returnarray;
    }
}
