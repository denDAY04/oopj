package SQLConn;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.common.BaseDataSource;
import org.postgresql.jdbc2.optional.PoolingDataSource;
import org.postgresql.ds.jdbc23.AbstractJdbc23PoolingDataSource;

/**
 * Class <code>ConnectionManager</code> uses the Factory Method design pattern
 * to create a connection to a specific Java PostgreSQL database.
 *
 * @version 16/02/10
 * @author ibr
 * changed from derby to PostgreSQL 2014
 */
public class ConnectionManager {

    private static final String URL = Setup.Settings.URL;
    private static final String USERNAME = Setup.Settings.USERNAME;
    private static final String PASSWORD = Setup.Settings.PASSWORD;

    private static final String serverName = Setup.Settings.SERVERNAME;
    private static final int portNumber = Setup.Settings.PORT;
    private static final String databaseName = Setup.Settings.USERNAME;
    private static final String user = Setup.Settings.USERNAME;
    private static final String password = Setup.Settings.PASSWORD;
    private static PoolingDataSource source = new PoolingDataSource();

  
    
    public ConnectionManager() {             
               
    //<editor-fold defaultstate="collapsed" desc="return a connection from a pool @author Mathias Nordahl ">
        //source.getDa
        System.out.println("Got Source");
        //source.setDataSourceName("A Data Source");
        source.setServerName(serverName);
        source.setDatabaseName(databaseName);
        source.setPortNumber(portNumber);
        source.setUser(user);
        source.setPassword(password);
        source.setMaxConnections(10);
        
    }
    
    public static Connection getConnection() {
        
        try {
              return source.getConnection();
        }
        catch (SQLException ex) {return null;
        }
        
    }
//</editor-fold>

    
    
    
    /**
     * return a connection to a specific PostgreSQL database.
     * <p>
     * @return the Java PostgreSQL database connection
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver").newInstance();
        }
        catch (Exception ex) {
            return null;
        }

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
