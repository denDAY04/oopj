package Website;

//Class from which objects will be created 
//and then passed as arguments.


import ModelClasses.*;
import java.rmi.*;
import java.util.ArrayList;

public interface WebsiteManagerRMISkel extends Remote
{
    public int createCustomer(Customer customer) throws RemoteException; 
    
    public Customer setCustomerDetails(Customer customer) throws RemoteException;
    
    // customer number is stored as an integer in the database... cast integer to string for return
    public Customer getCustomerDetails(String customerNumber) throws RemoteException; 

    public Customer logOn(String email, String password) throws RemoteException;
   
    // customer number is stored as an integer in the database... cast integer to string for return
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) throws RemoteException;  
}