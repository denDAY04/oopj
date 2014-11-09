/**
 * This class was presented by the project supervisor/course lector, and is not
 * made by the group.
 */
package SQLDatabase.Setup;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class <code>ConnectionManager</code> uses the Factory Method design pattern
 * to create a connection to a specific Java PostgreSQL database.
 *
 * NB Add derbyclient.jar to project
 *
 * @version 16/02/10
 * @author ibr
 * changed from derby to PostgreSQL 2014
 */
public class ConnectionSettings {

  //  private static final String URL = "jdbc:postgresql://goonhilly6.eitlab.ihk-edu.dk:5432/jonas3e14";
  //  private static final String USERNAME = "jonas3e14";
  //  private static final String PASSWORD = "s134421";
    
    private static final String URL = "jdbc:derby://localhost:1527/CoreDb";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";
    
       
    /**
     * Factory method to return a connection to a specific PostgreSQL database.
     *
     * @return the Java PostgreSQL database connection
     *
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {
       
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //   Class.forName("org.postgresql.Driver").newInstance();
            }catch (Exception ex) {return null;}
        
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}