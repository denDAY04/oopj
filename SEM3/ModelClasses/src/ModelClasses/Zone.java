package ModelClasses;


import java.io.Serializable;
import java.util.LinkedList;

public class Zone implements Serializable {
    
    
    /**
     * Contains the zone number, a linkedlist of adjacent zones, a visited
     * boolean and a reference to the parent zone in the search tree.
     */

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
