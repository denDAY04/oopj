package Manager;

/**
 * Interface for external simulation, mean to signal that a change in the
 * database that holds the zone map has occurred.
 * <p>
 * @author Andreas Stensig Jensen, on Nov 25, 2014
 * Contributors:
 */
public interface ZoneMapeUpdates {

    /**
     * Indicate that the zone map has been updated in the database, and
     * therefore should be recreated in the class.
     */
    public void zoneMapUpdated();
}
