package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Maintains a local copy of the zone map and gives access to calculating how
 * many zone-rings are between two zones with the <code>getDistance</code>
 * method.
 * <p>
 * The local copy of the zone map is generated with the central zone map
 * maintained in a database, and with the interface method
 * <code>zoneMapUpdated</code> the local copy can be updated to ensure
 * synchronization between the two versions.
 * <p>
 * @author Rasmus
 * Contributors:
 * Andreas Stensig Jensen
 */
public class ZoneDistanceCalc implements ZoneMapeUpdates {

    private final String URL = Setup.Settings.URL;            
    private final String USERNAME = Setup.Settings.USERNAME;
    private final String PASSWORD = Setup.Settings.PASSWORD;
    private final String DB_TABLE_NAME = "ZoneMap";
    private final int MAX_ADJACENCY = 5;
    private ArrayList<Zone> zonelist = new ArrayList<>();


    /**
     * Constructor. Also initialized the local copy of the zone map, by
     * contacting the database.
     */
    public ZoneDistanceCalc() {
        createZonelist();
    }

    /**
     * Recreate the zone map in a local copy, in the <code>zonelist</code>
     * field, by getting the zone map from the database.
     * <p>
     * The address and login credentials for the database are stored in field
     * variables.
     */
    private void createZonelist() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from "
                    + DB_TABLE_NAME);
            /*Create zones in the list*/
            while (rs.next()) {
                zonelist.add(makezone(rs.getInt(1)));
            }

            /*Add adjacenct zones to each zone*/
            rs = statement.executeQuery("select * from " + DB_TABLE_NAME);
            int zoneX = 0;
            while (rs.next()) {
                /*Look through adjacency-columns starting at column#2*/
                for (int j = 2; j <= MAX_ADJACENCY; ++j) {
                    int z = rs.getInt(j);   // adjacent zone name 

                    if (z == 0) {       // No more adjacent zones
                        break;
                    }
                    /*The zones are placed at NAME-1; there is no zone named 0*/
                    zonelist.get(zoneX).addZonelink(zonelist.get(z - 1));
                }
                ++zoneX;
            }

            rs.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

//        // TEST printout of created data
//        /*for each created zone*/
//        for (int i = 0; i < 5; i++) {
//            System.err.println("zone: " + zonelist.get(i).zoneNumber);
//            /*Output each link for zone*/
//            for (Zone v : zonelist.get(i).Zonelink) {
//                System.err.println("link: " + v.zoneNumber);
//            }
//            System.err.println("---");
//        }
    }

    /**
     * Breadth first search method. This algorithm will do a Breadth first
     * search using the <code>zonelist</code> field. It will then backtrack
     * though the search to find the shortest route between the parameters.
     * <p>
     * @param begin zone number of the start zone
     * @param end   zone number of the end zone.
     * <p>
     * @return the number of zones in the shortest path between the begin
     *         and end zone.
     * @throws IllegalArgumentException if either or both of the parameters 
     *                                  was out of range. 
     */
    public int getDistance(int begin, int end) throws IllegalArgumentException {
        /*Input error checking*/
        if (begin < 1 || begin > 5 || end < 1 || end > 5) {
            throw new IllegalArgumentException("Zone numbers must be in"
                    + " range: 1 through 5.");
        }
        
        Zone start = zonelist.get(begin - 1);
        Zone finish = zonelist.get(end - 1);

        LinkedList queue = new LinkedList(); 
        queue.add(start); 
        start.visited = true; 
        /*loop while there are uncheked zones in the queue*/
        while (!queue.isEmpty()) {
            Zone visit = (Zone) queue.poll(); 
            /*If target is reached, search finished*/
            if (visit.equals(finish)) { 
                break; 
            }
            /*for each of the adjecent zones to the current zone*/
            for (Zone adj : visit.Zonelink) {
                if (!adj.visited) {    
                    adj.visited = true;
                    /*Store parent to the zone and queue for visiting*/
                    adj.visitedBefore = visit; 
                    queue.add(adj); 
                }
            }
        }

        /*
         A path have been found. Back track through the path to find the 
         shortest route; start with the end zone.
        */
        Zone backtrack = finish; 
        int numberOfZones = 1; 
        while (backtrack != start) {
            backtrack = backtrack.visitedBefore;
            numberOfZones++; 
        }

        /*reset list before exit.*/
        for (Zone zone : zonelist) {
            zone.visited = false;
        }

        return numberOfZones;
    }

    /**
     * Create a new zone
     * <p>
     * @param num zone number
     * <p>
     * @return the created <code>Zone</code> object.
     */
    public Zone makezone(int num) {
        return new Zone(num);
    }

    /**
     * Interface override. Indication that the zone map has been updated in the
     * database. Therefore the local copy in the class should be recreated with
     * the updated info.
     */
    @Override
    public void zoneMapUpdated() {
        System.out.println("Recreating zone map.");
        createZonelist();
    }


    /**
     * Contains the zone number, a linkedlist of adjacent zones, a visited
     * boolean and a reference to the parent zone in the search tree.
     */
    public class Zone {

        public int zoneNumber;
        public LinkedList<Zone> Zonelink = new LinkedList();
        public boolean visited = false;
        public Zone visitedBefore = null;

        /**
         * Constructor.
         *
         * @param zoneNumber the zone's number.
         */
        public Zone(int zoneNumber) {
            this.zoneNumber = zoneNumber;
        }

        /**
         * Set the initial <code>Zonelink</code> after creation of zones.
         * <p>
         * @param Zonelink
         */
        public void setZonelink(LinkedList Zonelink) {
            this.Zonelink = Zonelink;
        }

        /**
         * Add a <code>Zone</code> to the current <code>Zone</code>'s
         * <code>ZoneLink</code>.
         * <p>
         * @param zone zone to add.
         */
        public void addZonelink(Zone zone) {
            this.Zonelink.add(zone);
        }

    }

}
