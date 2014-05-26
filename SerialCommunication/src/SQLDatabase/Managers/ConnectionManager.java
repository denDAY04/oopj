/**
 * This class was presented by the project supervisor/course lector, and is not
 * made by the group.
 */
package SQLDatabase.Managers;

import java.sql.*;

/**
 * Class <code>ConnectionManager</code> uses the Factory Method design pattern
 * to create a connection to a specific Java Derby database.
 *
 * NB Add derbyclient.jar to project
 *
 * @version 16/02/10
 * @author ibr
 */
public class ConnectionManager {

    private static final String URL = "jdbc:derby://localhost:1527/TA";
    private static final String USERNAME = "TA";
    private static final String PASSWORD = "TA";

    /**
     * Factory method to return a connection to a specific Java Derby database.
     *
     * @return the Java Derby database connection
     *
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
