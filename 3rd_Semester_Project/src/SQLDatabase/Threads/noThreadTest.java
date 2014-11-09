package SQLDatabase.Threads;

import ModelClasses.Customer;
import SQLDatabase.Library.SQLLibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class noThreadTest {

    public static void main(String[] args) throws RemoteException, SQLException{

        noThreadTest test = new noThreadTest();
        test.begin();
    }

    
    
    Customer citizenKane;
    private static final boolean DEBUG = true;
    

    Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int rowCount;
    private String action;
    private String query;
    private ArrayList<Object> parameters;
    
    
    
    public void begin() throws RemoteException, SQLException{
         if (con==null){System.out.println("No Connection yet! ");
         this.con = returnCon();} // create connection
                
        createTestCustomerObject();    
        createCustomer(citizenKane);        
        
        int rCount= -1 ;
        ResultSet rSet = null;
        if ("update".equals(action)) rCount = (Integer) WorkerThread(con, action, query, parameters);  
        if ("query".equals(action)) rSet = (ResultSet) WorkerThread(con, action, query, parameters);      
        
        if (con!=null){System.out.println("Connection still active! ");}        
        
        
    }
    
    
      //create customer object
    private void createTestCustomerObject() throws RemoteException {

        this.citizenKane = new Customer();   //create test customer object
        citizenKane.setFirstname("Citizen6");
        citizenKane.setLastname("Kane");
        citizenKane.setEmail("Kane@Citizen.com");
        citizenKane.setPassword("LetMeIn");  
    }
    
    
     //add customer to database
    private void createCustomer(Customer customer) throws RemoteException { 
        ArrayList Values = new ArrayList();
        Values.add(customer.getFirstname());
        Values.add(customer.getLastname());
        Values.add(customer.getEmail());
        Values.add(customer.getPassword());
        this.action = "update"; //query or update 
        this.query = SQLLibrary.CREATE_CUSTOMER;        
        this.parameters = Values;
        
    }
    
    
    
    
    

    public Object WorkerThread(Connection Con, String Action, String Query, ArrayList<Object> Parameters) throws SQLException {        
        Object result = null;  
        this.resultSet = null;
        this.preparedStatement = null;
        
        if (Con==null){Con = returnCon();} // create connection                
        if (Action.equals("update")) result = executeUpdate(Con, Query, Parameters); // return int object
        if (Action.equals("query"))  result = executeQuery(Con, Query, Parameters); // return resultset object
        
        return result;
    }
    
    
    
    

       private Object executeUpdate(Connection con, String Query, ArrayList<Object> Parameters) {
                

        try {if (con == null) {throw new NullPointerException("Database connection lost");}  

            preparedStatement = con.prepareStatement(Query);
            
            for (int i = 0; i < Parameters.size(); ++i) {
                Class indexedClass = Parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) Parameters.get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) Parameters.get(i));
                }
            }
                        
           rowCount = preparedStatement.executeUpdate();   
                        
        } catch (SQLException e) {e.printStackTrace();}

        
        return rowCount;
    }
    
    
       
       
       
       
       
       private Object executeQuery(Connection con, String Query, ArrayList<Object> Parameters) throws SQLException {
                 
   

        try {if (con == null) {throw new NullPointerException("Database connection lost");} 

            preparedStatement = con.prepareStatement(Query);
            resultSet = preparedStatement.executeQuery();

             
        } catch (SQLException e) {e.printStackTrace();}
          
        return resultSet;

    }
           
           
           
  

    private void setupCon() {

        this.con = null;
        try {
            con = SQLDatabase.Setup.ConnectionSettings.createConnection(); //new connection
            if (con == null) {
                throw new NullPointerException("Could not create database connection");
            }
            System.err.println("Valid connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
    
    private Connection returnCon() {

        Connection con = null;
        try {
            con = SQLDatabase.Setup.ConnectionSettings.createConnection(); //new connection
            if (con == null) {
                throw new NullPointerException("Could not create database connection");
            }
            System.err.println("Valid connection created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;

    }

    
    
    
    
    

}