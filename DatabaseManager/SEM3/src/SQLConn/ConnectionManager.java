package SQLConn;

/**
 * This class was presented by the project supervisor/course lector, and is not
 * made by the group.
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.jdbc2.optional.ConnectionPool;

//import javax.sql.PooledConnection;

import com.sun.corba.se.impl.orbutil.threadpool.WorkQueueImpl;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;






/**
 * Class <code>ConnectionManager</code> uses the Factory Method design pattern
 * to create a connection to a specific Java PostgreSQL database.
 *
 * @version 16/02/10
 * @author ibr
 * changed from derby to PostgreSQL 2014
 */
public class ConnectionManager {
    
    private static final String URL = SQLConn.Setup.Settings.URL;
    private static final String USERNAME = SQLConn.Setup.Settings.USERNAME;
    private static final String PASSWORD = SQLConn.Setup.Settings.PASSWORD;
    private static ConnectionPool connectionpool;
    

        public ConnectionManager(){         //not working needs a checkup!!!!!!!!!       
        try {
        //    Class.forName("org.postgresql.jdbc3.Jdbc3ConnectionPool").newInstance();       //not used
            
            
            connectionpool = new ConnectionPool();
            connectionpool.setUrl(URL); 
            connectionpool.setPassword(PASSWORD);
            //connectionpool.setPortNumber(5432);
            connectionpool.setUser(USERNAME);    
                       
        }
      
        catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Wrapper
        //Work
        //WorkQueue
        //WorkQueueImpl
        
        
        
        
        
        
    
    }
    
    
    public static Connection getConnection(){
    
        try {
            return connectionpool.getConnection();
            //  connectionpool.getPooledConnection();  ??????????????
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    
  
    
    
    
    
    
    
       
    /**
     * Factory method to return a connection to a specific PostgreSQL database.
     * @return the Java PostgreSQL database connection
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException {
       
                
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            }catch (Exception ex) {return null;}
        
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}