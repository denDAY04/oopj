package RmiServer.Skeleton;

import SQLDatabase.Manager.DatabaseManager;
import ModelClasses.*;
import SQLDatabase.Library.SQLLibrary;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import SQLDatabase.Threads.ThreadServer;



public class WebsiteManagerRMISkel extends UnicastRemoteObject implements RmiServer.Skeleton.Interface.IntWebsiteManagerRMISkel {

    public WebsiteManagerRMISkel() throws RemoteException {
     //constructor... Not implemented yet
    }
 
    
    
    
     /**
     * WebsiteManger boolean createCustomer(Customer)
     */   
    @Override
    public boolean createCustomer(Customer customer) throws RemoteException { //add customer to database
        String Query = SQLLibrary.CREATE_CUSTOMER;
        boolean status = false;
        ArrayList Values = new ArrayList();
        Values.add(customer.getFirstname());
        Values.add(customer.getLastname());
        Values.add(customer.getEmail());
        Values.add(customer.getPassword());
        String Action = "update"; //query or update
        status = ThreadServer.nextThread(Action, Query, Values);
               
        System.out.println("Query string output: " + Query);  // test output
        System.out.println(Values.toString());
        
   
        return status;
    }

    
    
  
    
    
    
    
    
    
    
    
    
    
    
  
    
    
    @Override
    public void setCustomerDetails(Customer customer) throws RemoteException {

        int customerNumb = customer.getCustomerNumber();
        String firstName = customer.getFirstname();
        String lastName = customer.getLastname();
        String email = customer.getEmail();
    //String status = cusomer.getStatus();

        String Query = "update Customer set "
                + "FirstName = '" + firstName + "', "
                + "LastName  = '" + lastName + "', "
                + "Email     = '" + email + "' "
                + "where CustomerNumber = " + customerNumb;
        System.out.println("Query string output: " + Query);  // test output

        DatabaseManager coreDb = new DatabaseManager();
        int rSet = coreDb.executeUpdate(Query);

    }

    @Override
    public Customer getCustomerDetails(String customerNumber) throws RemoteException {
    
        
        
        
        
        
        // return test customer 
        Customer customer = new Customer();
        customer.setCustomerNumber("1234");
        customer.setFirstname("Hans");
        customer.setLastname("Jensen");
        customer.setEmail("hans@jensen.dk");
        customer.totalRecords=24;  //field in customer is set as public for testing
        
        return customer;
    }             
        
    @Override
    public Customer logOn(String email, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) throws RemoteException {
    //Not implemented yet .... the folowing is test data
        
        ArrayList<Journey> test = new ArrayList(); 
        
        Journey journey = new Journey();
        journey.setStartzone(1);
        journey.setNumberofzones(2);
        journey.setPrice(10);
        journey.setStarttime("10-01-14");

        Journey journey2 = new Journey();
        journey2.setStartzone(3);
        journey2.setNumberofzones(3);
        journey2.setPrice(15);
        journey2.setStarttime("10-02-14");
        
        Journey journey3 = new Journey();
        journey3.setStartzone(5);
        journey3.setNumberofzones(7);
        journey3.setPrice(70);
        journey3.setStarttime("10-03-14");

        Journey journey4 = new Journey();
        journey4.setStartzone(7);
        journey4.setNumberofzones(8);
        journey4.setPrice(80);
        journey4.setStarttime("10-08-14");
        
        Journey journey5 = new Journey();
        journey5.setStartzone(6);
        journey5.setNumberofzones(2);
        journey5.setPrice(20);
        journey5.setStarttime("10-07-14");

        Journey journey6 = new Journey();
        journey6.setStartzone(8);
        journey6.setNumberofzones(3);
        journey6.setPrice(30);
        journey6.setStarttime("10-02-14");
        
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);

        if (index<0){index =0;}
       
        int index2=index+5;
        // display the remainding
       if (index2>test.size()&index<test.size()){
        index2=test.size();
       }

       // redisplay the final view
       if (index>(test.size()-1)){
           index=((test.size()-1)/5)*5; // integer divition
          index2=test.size();
       }

       return new ArrayList(test.subList(index, index2));       
    }
        
}      
        
        
        
        
        

  



//
//
//
//     @Override
//    public boolean createCustomer(Customer customer) throws RemoteException {
//    boolean status = false;
//    
//    String firstName= customer.getFirstName();
//    String lastName = customer.getLastName();
//    String email = customer.getEmail();
//    
//    
//    String CREATE_CUSTOMER = "insert into Customer (FirstName, LastName, Email) values ('"+firstName+"', '"+lastName+"', '"+email+"')";
//    //insert into CUSTOMER (FIRSTNAME, LASTNAME, EMAIL) values ('fname2', 'lname2', 'email2@test.com');
//         
//    System.out.println("Query string output: " + CREATE_CUSTOMER);  // test output
//        
//    DatabaseManager coreDb = new DatabaseManager();
//      int rSet = coreDb.executeUpdate(CREATE_CUSTOMER);
//    
//    
//    
//    
//    
//        // return CustomerNumber = " + customerNumb
//        
//     return status;
//    }
//      public void create() { //add customer to database
//        String Query = SQLLibrary.CREATE_CUSTOMER;
//        ArrayList Values = new ArrayList();
//        Values.add(this.firstName);
//        Values.add(this.lastName);
//        Values.add(this.email);   
//        String Action = "execute"; //execute or update
//        ThreadServer.nextThread(Action, Query, Values);
//        
//          //ThreadServer.nextThread("update", Query, Values);
//        
//        
//        
////         PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
////                                     SET SALARY = ? WHERE ID = ?");
////   pstmt.setBigDecimal(1, 153833.00)
////   pstmt.setInt(2, 110592)
//        
//        
//        
//    }

