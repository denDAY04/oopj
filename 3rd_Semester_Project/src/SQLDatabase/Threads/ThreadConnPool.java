/**
 * -- Handle all connectivity to the database 
 *  Resultset executeQuery(Query)
 *  int executeUpdate(UpdateQuery)
 *  Thread distributeThread()
 * 
 * Check if Connection is alive ..sql timeout!!
 */

package SQLDatabase.Threads;
import SQLDatabase.Manager.IntDatabaseManager;
import ModelClasses.*;
import SQLDatabase.Setup.ConnectionSettings;
import java.sql.*;
import java.util.ArrayList;




//Check if Connection is alive ..sql timeout!!
// implement thread pool




public class ThreadConnPool implements IntDatabaseManager{

 
  @Override
    public ResultSet executeQuery(String Query)throws NullPointerException{
           Connection con = null;
    
     try {
            con = ConnectionSettings.createConnection();
            if (con == null){throw new NullPointerException("Could not create database connection");}
            
            PreparedStatement preparedStatement;
               preparedStatement = con.prepareStatement(Query);
            
               System.out.println("Success, Connection created");   // test output
                        
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet;              
         } catch (SQLException e) {e.printStackTrace();}
     finally {if (con != null) {
                   try {con.close();}
                   catch (SQLException e1) {e1.printStackTrace();}}}
    return null;
    }
    
    
    
    
    
@Override      
    public int executeUpdate(String UpdateQuery)throws NullPointerException{
           Connection con = null;
           int rows = 0;
    
     try {
            con = ConnectionSettings.createConnection();
            if (con == null){throw new NullPointerException("Could not create database connection");}
            
            PreparedStatement preparedStatement;
               preparedStatement = con.prepareStatement(UpdateQuery);
            
               
               
//            for (int i = 0; i < parameters.size(); ++i) {
//                Class indexedClass = parameters.get(i).getClass();
//                if (indexedClass == String.class){
//                    preparedStatement.setString(i + 1, (String) parameters.
//                            get(i));
//                } else if (indexedClass == Integer.class) {
//                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
//                }
//            }
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {customerList.add(createCustomer(resultSet));}
            
              rows = preparedStatement.executeUpdate();
            
        } catch (SQLException e) {e.printStackTrace();
        } finally {if (con != null) {
                   try {con.close();}
                   catch (SQLException e1) {e1.printStackTrace();}}}          
        
        return rows;
    }
    

}