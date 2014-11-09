/**
 * DatabaseManager (factory) 
 * -- Interact-with SQL library
 */

package SQLDatabase.Manager;

import SQLDatabase.Setup.ConnectionSettings;
import ModelClasses.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * This is the sole class of the project that interacts directly with the
 * database. All manager classes should interact with this class in order to
 * interact with the database.
 */
public class DatabaseManager implements IntDatabaseManager{

 
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
    
       
        
// @Override      
//    public int executeUpdate(String UpdateQuery)throws NullPointerException{
//           Connection con = null;
//           int rows = 0;
//    
//     try {
//            con = ConnectionManager.createConnection();
//            if (con == null){throw new NullPointerException("Could not create database connection");}
//            
//            PreparedStatement preparedStatement;
//               preparedStatement = con.prepareStatement(UpdateQuery);
//            
//               
//               
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
//            
//            
//            
//        } catch (SQLException e) {e.printStackTrace();
//        } finally {if (con != null) {
//                   try {con.close();}
//                   catch (SQLException e1) {e1.printStackTrace();}}}          
//        
//        return rows;
//    }
//    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     /**
//     * Get all customers matching some parameters.
//     *
//     * @param getQuery   SQL command. See SQLLibrary.
//     * @param parameters The parameters needed for a given SQL command.
//     *
//     * @return an ArrayList of Customer objects denoting the found customers.
//     *
//     * @see SQLLLibrary
//     */
//    public ArrayList<Customer> getCustomers(String getQuery, ArrayList<Object> parameters)throws NullPointerException{
//           Connection con = null;
//           ArrayList<Customer> customerList = new ArrayList();
//           
//        try {
//            con = ConnectionManager.createConnection();
//            if (con == null){throw new NullPointerException("Could not create database connection");}
//            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
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
//            
//        } catch (SQLException e) {e.printStackTrace();
//        } finally {if (con != null) {
//                   try {con.close();}
//                   catch (SQLException e1) {e1.printStackTrace();}}}
//        
//        return customerList;
//    }
//
//
//
//   
//
//    /**
//     * Create a Customer object from the ResultSet containing a customer's data.
//     *
//     * @param resultSet containing the found data from the database.
//     *
//     * @return a Customer object holding all the data.
//     *
//     * @throws SQLException if the method tries to access a column that isn't
//     *                      found in the ResultSet.
//     */
//    private Customer createCustomer(ResultSet resultSet) throws SQLException {
//        int customerNumb = Integer.parseInt (resultSet.getString("CustomerNumb"));
//        String firstName = resultSet.getString("FirstName");
//        String lastName = resultSet.getString("LastName");
//        String email = resultSet.getString("Email");
//       // String status = resultSet.getString("status");
//        return new Customer(customerNumb, firstName, //status
//                lastName, email);
//    }

   

    

}