

package SQLDatabase.Manager;

import java.sql.ResultSet;


public interface IntDatabaseManager {
    
    public ResultSet executeQuery(String Query)throws NullPointerException;
    public int executeUpdate(String UpdateQuery)throws NullPointerException;  
               
}





