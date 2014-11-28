import Manager.DatabaseManager;
import ModelClasses.*;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WebsiteManagerRMISkelImpl extends UnicastRemoteObject implements WebsiteManagerRMISkel {
    DatabaseManager databasemanager;      
    public WebsiteManagerRMISkelImpl() throws RemoteException {  
        databasemanager = new DatabaseManager();
        System.out.println("WebsiteManagerRMISkel constructor executed");       
    }  
    
    
    /**
     * WebsiteManger boolean createCustomer(Customer)
     * @param customer
     * @return customer number
     * @throws java.rmi.RemoteException 
     */   
    @Override //adds a customer to the SQL database
    public int createCustomer(Customer customer) throws RemoteException { 
    int status = databasemanager.createCustomer(customer);  
    return status;
    }

    @Override
    public void setCustomerDetails(Customer customer) throws RemoteException {
    databasemanager.setCustomerDetails(customer);
    }

    @Override
    public Customer getCustomerDetails(int customerNumber) throws RemoteException {
    return databasemanager.getCustomerDetails(customerNumber);
    }             
 
    @Override
    public Customer logOn(String email, String password) throws RemoteException {
    return databasemanager.logOn(email, password);  
    }

    @Override
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) throws RemoteException {  
    return  databasemanager.getJourneyHistory(customerNumber,index);    
    }
        
}      