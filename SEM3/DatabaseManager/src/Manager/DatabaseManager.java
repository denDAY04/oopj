/**
 * DatabaseManager (factory)
 * -- Interact-with SQL library
 * <p>
 * Instansiates a database connection pool
 * <p>
 * Unwraps RMI parsed objects into generic database calls
 * capable of being executed by a WorkerThread.
 * the call is created by using a SQLlibrary to load a prepaired
 * query and combine it with an ArrayList containing objects to be
 * dereferenced and cast into inters or strings from within the thread
 * <p>
 * Cast the returned object into an integer or a resultset, if required it
 * wraps a SQL resultsets back into modelclass objects and
 * returns it to the RMI client
 */
package Manager;

import ModelClasses.*;
import SQLConn.*;
import SQLDatabase.Library.SQLLibrary;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class interacts directly with the database.
 * All manager classes interacts with this class in order
 * to interact with the database.
 */
public class DatabaseManager implements IntDatabaseManager {
    
    
    private static final int PRICE_ONE_ZONE_ADULT = 1200; //<editor-fold defaultstate="collapsed" desc="comment">    
    //price is in danish øre.
    //future update: retrieve value from configuration file or database    
    //</editor-fold>    
    private Connection con;
    private String query;
    private ArrayList<Object> parameters;
    private PreparedStatement preparedStatement;
    private ResultSet resultset;

    
    //<editor-fold defaultstate="collapsed" desc="Connection Handler">
    
    private void dbConnect() {
        
        try {
            if (this.con == null || this.con.isClosed()) {
//     this.con = ConnectionManager.getConnection();
                this.con = ConnectionManager.createConnection();     // replace this with getConnection
                if (this.con == null) {throw new NullPointerException("Could not create database connection");
                }} System.out.println("Success, Connection created");}
        catch (SQLException e) {e.printStackTrace();}
    }
    
    //</editor-fold>         // needs connection pool implementation !!
 
    private void executeUpdate() throws NullPointerException {
        try {
            
//            if (this.con != null){System.err.println("Connection not null");}
//            if (this.con.isClosed()){System.err.println("Connection is Closed");}
            
            dbConnect();
            preparedStatement = con.prepareStatement(query);

            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));
                }
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally {if (con != null) {try {con.close();}
                catch (SQLException e) {e.printStackTrace();}}
        }

    }
    private void executeQuery() throws NullPointerException {        
        try {
            dbConnect();
            this.preparedStatement = con.prepareStatement(query);
            
                 for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));
                }
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }            
            
            this.resultset = preparedStatement.executeQuery();
           // while (resultset.next()) {}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

         finally {if (con != null) {try {con.close();}
                catch (SQLException e) {e.printStackTrace();}}
        }      
    }
    

    /**
     * Create a Customer object from the ResultSet containing a customer's data.
     *
     * @param resultSet containing the found data from the database.
     * @return a Customer object holding all the data.
     * @throws SQLException if the method tries to access a column that isn't
     * found in the ResultSet.
     */
    private Customer createCustomer(ResultSet resultSet) {
        try {
            Customer jDoe = new Customer();
            jDoe.setCustomerNumber(Integer.parseInt(resultSet.getString("CustomerNumber")));
            jDoe.setFirstname(resultSet.getString("FirstName"));
            jDoe.setLastname(resultSet.getString("LastName"));
            jDoe.setEmail(resultSet.getString("Email"));
            jDoe.setPassword(resultSet.getString("Password"));
            // resultSet.getString("status");                               // may have no use
            //   jDoe.setTotalRecords(resultSet.getString("TotalRecords"));        // field still missing in modelclass            
            return jDoe;
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

  
 
    //<editor-fold defaultstate="collapsed" desc="WebsiteManager">

    
    
    //<editor-fold defaultstate="collapsed" desc="Create a new Customer in the SQL Database">    
    /**  Create a new customer in the SQL Database
     * @param customer
     * @return boolean
     */    
    @Override 
    public boolean createCustomer(Customer customer) {        
        this.query = SQLLibrary.CREATE_CUSTOMER;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customer.getFirstname());
        parameters.add(customer.getLastname());
        parameters.add(customer.getEmail());
        parameters.add(customer.getPassword());
        this.parameters = parameters;
        executeUpdate();
        
        boolean responce = false;               // boolean responce missing!!
        return responce;
    }
     //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Update Customer details in the SQL Database">
    @Override
    public void setCustomerDetails(Customer customer) {
        this.query = SQLLibrary.UPDATE_CUSTOMER;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customer.getFirstname());
        parameters.add(customer.getLastname());
        parameters.add(customer.getEmail());
        parameters.add(customer.getPassword());
        //parameters.add(customer.getStatus());   //not used
        parameters.add(customer.getCustomerNumber());
        this.parameters = parameters;
        executeUpdate();
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">
    //
    //        // return test customer
    //        Customer customer = new Customer();
    //        customer.setCustomerNumber("1234");
    //        customer.setFirstname("Hans");
    //        customer.setLastname("Jensen");
    //        customer.setEmail("hans@jensen.dk");
    //        customer.totalRecords=24;  //field in customer is set as public for testing
    
    
    //</editor-fold>
    @Override
    public Customer getCustomerDetails(int customerNumber) {
        this.query = SQLLibrary.SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB;
        
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customerNumber);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();
        try {
            if (resultset.next()){return createCustomer(resultset);}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">
    // possibility of two dublicate customers in the database
    // email may have to be made unique in the sql database
    // does not check for customer not found!!
    //</editor-fold>
    @Override
    public Customer logOn(String email, String password) {
        this.query = SQLLibrary.SYSTEM_VALIDATE_CUSTOMER_LOGIN;
        
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(email);
        parameters.add(password);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();
        try {
            if (resultset.next()){return createCustomer(resultset);}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">
    // This needs implementation !!!    
         
        // index 0 --- return the last five histories..
        // index 5 --- return return histories from 5 to 10
        // index 10 --- return histories from 10 to 15
        // e.t.c.
        
        // SQL LIMIT 5 sort Decending ???
        // preparedstatement.setMaxRows(1); ?? -> stoplink.java in algorithme
    //</editor-fold> // !!!!!!!!! Not implemented yet !!!!!!!!!!!!!!!!!!!!!!
    @Override
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) {
        this.query = SQLLibrary.SYSTEM_GET_JOURNEY_HISTORY_RANGE;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customerNumber);
        parameters.add(index);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();
        
         ArrayList<Journey> journeyArray = new ArrayList();
         
        try {
            
         while (resultset.next()) {
                Journey journey = new Journey();
              
                journey.setStartzone(resultset.getInt("startzone"));
                journey.setPrice(resultset.getInt("ticketprice"));
                journey.setNumberofzones((resultset.getInt("ticketprice"))/ PRICE_ONE_ZONE_ADULT); // calculate number of Zones
          
                String dts = "" + resultset.getTimestamp("datetimestamp");  // 2014-11-19 15:44:09.630 format returned from database
                System.out.println(dts);   
                
                journey.setStarttime(dts.substring(0, 17));
             
                 journeyArray.add(journey);
               
            }
            
            
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return journeyArray;
        
        
        
        //Not implemented yet ....
        
//        
//        if (index<0){index =0;}
//        
//        int index2=index+5;
//        // display the remainding
//        if (index2>test.size()&index<test.size()){
//            index2=test.size();
//        }
//        
//        // redisplay the final view
//        if (index>(test.size()-1)){
//            index=((test.size()-1)/5)*5; // integer divition
//            index2=test.size();
//        }
//        
//        return new ArrayList(test.subList(index, index2));
        
    }
    //</editor-fold>              // 90% done
    
    //<editor-fold defaultstate="collapsed" desc="RouteplannerJourneyManager">
    
    @Override
    public double getNextDeparture(int startPosition, int endPosition, int timeDeparture) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
     
    @Override              //Objects may be defined as a modelclass Stop[]
    public ArrayList<Object> SetupGraph() {
        throw new UnsupportedOperationException("Not supported yet.");
        
     
    //  int GetSpeedBound()
        
    }
           // GetNextDeparute   IS ....DEPARUTE a spelling error ????????????
    @Override              //Objects may be defined as a modelclass time[]
    public ArrayList<Object> GetNextDeparute(String type, String line, String fromStop, String towardsStop, int hour, int minute) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //</editor-fold>  // 5% done
    
    //<editor-fold defaultstate="collapsed" desc="JourneyManager">
    
    @Override
    public TicketList createNewTickets(PassengerList pLst) {
        
        
        
        
       
//        INSERT INTO ticket (datetimestamp, ticketprice, startzone, customer) 
//	VALUES (DEFAULT, 12, 5, 2)

        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TicketList getExistingTickets(PassengerList pLst) {
       
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //</editor-fold>              // 5% done
}

    

    //<editor-fold defaultstate="collapsed" desc="Snippet 1">

    //    private int executeUpdate() {
    //
    //        int rows = 0;
    //
    //        preparedStatement = con.prepareStatement(UpdateQuery);
    //
    //        for (int i = 0; i < parameters.size(); ++i) {
    //            Class indexedClass = parameters.get(i).getClass();
    //            if (indexedClass == String.class) {
    //                preparedStatement.setString(i + 1, (String) parameters.
    //                        get(i));
    //            }
    //            else if (indexedClass == Integer.class) {
    //                preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
    //            }
    //        }
    //        ResultSet resultSet = preparedStatement.executeQuery();
    //        while (resultSet.next()) {
    //            customerList.add(createCustomer(resultSet));
    //        }
    //
    //        rows = preparedStatement.executeUpdate();
    //    }
    //    catch (SQLException e
    //
    //
    //        ) {
    //            e.printStackTrace();
    //    }
    //
    //    return rows ;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Snippet 2">
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
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Snippet 3">
    //         PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
    //                                     SET SALARY = ? WHERE ID = ?");
    //   pstmt.setBigDecimal(1, 153833.00)
    //   pstmt.setInt(2, 110592)

    //</editor-fold>