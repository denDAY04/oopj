package Website;

import Manager.DatabaseManager;
import ModelClasses.*;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WebsiteManagerRMISkelImpl extends UnicastRemoteObject implements WebsiteManagerRMISkel {
    DatabaseManager databasemanager;      
    public WebsiteManagerRMISkelImpl() throws RemoteException {  
        databasemanager = new DatabaseManager();      
    }  
    
    /**
     * int createCustomer(Customer)
     * @param customer
     * @return customer number
     * @throws java.rmi.RemoteException 
     */   
    @Override //adds a customer to the SQL database returns the customer number
    public int createCustomer(Customer customer) throws RemoteException { 
    return databasemanager.createCustomer(customer);  
    }

    @Override
    public Customer setCustomerDetails(Customer customer) throws RemoteException {
    return databasemanager.setCustomerDetails(customer);        
    }

    @Override
    public Customer getCustomerDetails(String customerNumber) throws RemoteException {
        // insert String to int - try catch protection here
    return databasemanager.getCustomerDetails(Integer.parseInt(customerNumber));            
    }             
 
    @Override
    public Customer logOn(String email, String password) throws RemoteException {
    return databasemanager.logOn(email, password);  
    }

    @Override
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) throws RemoteException {  
        // insert String to int - try catch protection here
    return  databasemanager.getJourneyHistory(Integer.parseInt(customerNumber), index);    
    }
        
}      