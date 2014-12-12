/*
 *Sets up the Graph data for the Routeplanner from the database
 */
package Manager;

import ModelClasses.Stop;
import ModelClasses.StopLink;
import SQLDatabase.Library.SQLLibrary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Sets up the Graph data for the Routeplanner from the database
 * @author Rasmus Loft
 */
public class SetupRoutePlannerGraph {

    private final String URL = Setup.Settings.URL;
    private final String USERNAME = Setup.Settings.USERNAME;
    private final String PASSWORD = Setup.Settings.PASSWORD;

    public Stop[] setupGraph(DatabaseManager dBM) {
        Connection con = null;
        ArrayList<Stop> stopArr = new ArrayList();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultset;
            String query;

            int speed;
            ArrayList<StopLink>[] stopLinkArr;

            query = SQLLibrary.ROUTEPLANNER_GET_SPEEDBOUND;

            System.err.println("executeQuery, Setup route planner");

            resultset = statement.executeQuery(query);

            if (resultset.next()) {
                speed = resultset.getInt(1);
                query = SQLLibrary.ROUTEPLANNER_GET_STOP;
                resultset = statement.executeQuery(query);
                while (resultset.next()) { // itterates through lines to create stops
                    stopArr.add(new Stop(resultset.getString(1), resultset.getInt(2), (long) resultset.getInt(3), (long) resultset.getInt(4), speed));
                 }
                stopLinkArr = new ArrayList[stopArr.size()];
                for (int i = 0; i < stopArr.size(); i++) {
                    stopLinkArr[i] = new ArrayList<>(); // if no array exsists yet, make one
                }
                query = SQLLibrary.ROUTEPLANNER_GET_STOPLINK;
                resultset = statement.executeQuery(query);

                while (resultset.next()) { // itterates through lines to create links
                    String type = resultset.getString(1);
                    String line = resultset.getString(2);
                    Stop parent = stopArr.get(resultset.getInt(3) - 1);
                    Stop stop = stopArr.get(resultset.getInt(4) - 1);
                    Stop towards = stopArr.get(resultset.getInt(5) - 1);

                    // add the link to the arrayarray list in the array with index toStop
                    stopLinkArr[resultset.getInt(3) - 1].add(new StopLink(type, line, parent, stop, towards));
                }

                for (int i = 0; i < stopLinkArr.length; i++) {
                    if (stopLinkArr[i] != null) {
                        StopLink[] currStopLinkArr = stopLinkArr[i].toArray(new StopLink[stopLinkArr[i].size()]);
                        stopArr.get(i).links = currStopLinkArr;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Setup Routeplanner Exception: " + ex);;
        }
        // convert arraylist toarray
        Stop[] stopArr2 = new Stop[stopArr.size()];
        stopArr2 = stopArr.toArray(stopArr2);

        return stopArr2;
    }

}
