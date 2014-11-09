package SQLDatabase.Threads.Convert2Thread;

import ModelClasses.Customer;
import SQLDatabase.Library.SQLLibrary;;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TestThread {

  
    private static final boolean DEBUG = true;
     
    Connection con;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private int rowCount;
    private String action;
    private String query;
    private ArrayList<Object> parameters;

    public static void main(String[] args) {

//        TestThread test = new TestThread();       
        new TestThread().createCustomer(new TestThread().createTestCustomerObject());
        
        
              
        this.customer = createTestCustomerObject();
        createCustomer(this.customer);

    }

    //create customer object
    private Customer createTestCustomerObject(){
        Customer customer;
        customer = new Customer();   //create test customer object
        customer.setFirstname("Citizen6");
        customer.setLastname("Kane");
        customer.setEmail("Kane@Citizen.com");
        customer.setPassword("LetMeIn");
      return customer;        
    }

     //add customer to database
    private void createCustomer(Customer customer){ 
        ArrayList Values = new ArrayList();
        Values.add(customer.getFirstname());
        Values.add(customer.getLastname());
        Values.add(customer.getEmail());
        Values.add(customer.getPassword());
        this.action = "update"; //query or update 
        this.query = SQLLibrary.CREATE_CUSTOMER;        
        this.parameters = Values;
        
    }

    
    
    
    
    
    
    
    
    
}
