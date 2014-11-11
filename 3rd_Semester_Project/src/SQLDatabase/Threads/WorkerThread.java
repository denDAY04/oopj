
package SQLDatabase.Threads;
import SQLDatabase.Manager.DatabaseManager;
import SQLDatabase.Setup.ConnectionSettings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import SQLDatabase.Setup.ConnectionSettings;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


// Are they writing in the same table? If yes, multithreading has no use at all.

    public class WorkerThread implements Runnable{ 
    
    private static final boolean DEBUG = true;  

    Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int rowCount;
    private String action;
    private String query;
    private ArrayList<Object> parameters;

       
    
    
    @Override
    public void run() {
        setupCon(); // test no connection is parsed yet so we try to make it ourself 
        
        if ("update".equals(this.action)) executeUpdate();  
        if ("query".equals(this.action)) executeQuery();
        
        
    }
    
       
    
    
    public WorkerThread(String Action, String Query, ArrayList<Object> Parameters){  
    this.action = Action;
    this.query = Query;
    this.parameters = Parameters;  
    this.preparedStatement = null; 
    this.resultSet = null;      
    
    
    Object object = (Integer) rowCount;
    // return object
    }    
    
         
    
    
    
    
    
    public int executeUpdate() throws NullPointerException {        
             
                   
          
        try {if (!connection()) {throw new NullPointerException("Database connection lost");}  //if (!connection())        
            preparedStatement = con.prepareStatement(query);
            
            
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));}
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            //this.resultSet = preparedStatement.executeQuery(); 
            
                rowCount = preparedStatement.executeUpdate();

        } catch (SQLException e) {e.printStackTrace();}    
        
        return rowCount;
    }
    
    

    ///////////////////////////////executeQuery//////////////////////////////////
    
    
    
    
    // ResultSet executeQuery(String Query) throws NullPointerException
    public ResultSet executeQuery() throws NullPointerException {
       

        try {if (!connection()) {throw new NullPointerException("Database connection lost");} 

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(query);

            System.out.println("Success, Connection created");   // test output

            resultSet = preparedStatement.executeQuery();

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return resultSet;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    /**
     * executeUpdate
     * @param Action
     * @param Query
     * @param Parameters
     * @throws NullPointerException
     */
       
    //private void executeUpdate() throws NullPointerException {
    //public ResultSet executeUpdate() throws NullPointerException {
    //public ResultSet executeUpdate(String Action, String updateQuery, ArrayList<Object> parameters) throws NullPointerException {
    public int executeUpdate(String Action, String Query, ArrayList<Object> Parameters) throws NullPointerException {        
        
            this.action = Action;
            this.query = Query;
            this.parameters = Parameters;      
            this.preparedStatement = null;         
          
        try {if (!connection()) {throw new NullPointerException("Database connection lost");}  //if (!connection())        
            preparedStatement = con.prepareStatement(query);
            
            
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));}
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            //this.resultSet = preparedStatement.executeQuery(); 
            
                rowCount = preparedStatement.executeUpdate();

        } catch (SQLException e) {e.printStackTrace();}    
        
        return rowCount;
    }
    
    

    ///////////////////////////////executeQuery//////////////////////////////////
    
    
    
    
//    // ResultSet executeQuery(String Query) throws NullPointerException
//    public ResultSet executeQuery() throws NullPointerException {
//       resultSet = null;
//       preparedStatement = null;
//
//        try {if (!connection()) {throw new NullPointerException("Database connection lost");} 
//
//            PreparedStatement preparedStatement;
//            preparedStatement = con.prepareStatement(query);
//
//            System.out.println("Success, Connection created");   // test output
//
//            resultSet = preparedStatement.executeQuery();
//
//            return resultSet;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        return resultSet;

 //   }
        
        
        
    
    
    
//    private void idle(){
//    
//        //if idle time excedes time to live set timeout = 1 
//        //if thread type = baseThread then return thread to thread pool
//        // else (thread type = dynamicThread)
//        
//        
//        if (con != null) {try {con.close();}
//        catch (SQLException e1) {e1.printStackTrace();}}
//        
//        
//        //con.close();  // close connection
//        //terminate thread 
//    
//    }

  
        
//        try {
          
        // check connection -- internal database connection check       
        // if connection is alive proceed, else create new connection
            
            
            
            
//            if (!connection()){setupCon();}
//            } catch (SQLException e) {e.printStackTrace();}

        
        
        
        
//        // execute recieved string literal -- if database is busy then waite 2 seconds and retry (repeat attempt 5 times before terminating)
            
//          if ("update".equals(this.action)){executeUpdate(this.action, this.query, this.parameters);}
//          if ("query".equals(this.action)){executeQuery();}
          

//        // if return value exists ... return responce value
              // return resultSet;
          
//        // else return Thread to thread pool
        
    

        
        
        
   
        
     private void setupCon(){
     
             this.con = null;
        try {
            con = SQLDatabase.Setup.ConnectionSettings.createConnection(); //new connection
             if (con == null) {throw new NullPointerException("Could not create database connection");}
             if(DEBUG){if(connection()){System.out.println("Valid connection created");}}
        } catch (SQLException e) {e.printStackTrace();} 
     
     
     }
     
      private boolean connection() throws SQLException{  // check if connection is alive       
      return (con.isValid(5));                         // value is timeout in seconds       
    }

    
        
        

    }


















     
////   PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
////                                     SET SALARY = ? WHERE ID = ?");
////   pstmt.setBigDecimal(1, 153833.00)
////   pstmt.setInt(2, 110592)
//        
//
//        DatabaseManager coreDb = new DatabaseManager();
//        int rSet = coreDb.executeUpdate("Query string - insert here");
//
//        // return CustomerNumber = " + customerNumb








//@Override
//    public void init() {
//        try {
//            java.awt.EventQueue.invokeAndWait(new Runnable() {
//                public void run() {
//                    initComponents();
//                }
//            });
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

























//
//
//
//
//            int rowCount = 0; 


//            while (resultSet.next()) {
//                //         customerList.add(createCustomer(resultSet));
//            }
//
//            rowCount = preparedStatement.executeUpdate();