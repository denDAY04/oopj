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
    public Customer getCustomerDetails(int customerNumber) throws RemoteException; // customer number is stored as an integer in the databese
    //public Customer getCustomerDetails(String customerNumber)throws RemoteException; // new addition ... cast integer to string
    
    //public boolean logOn(String email, String password);
    //public Customer logOn(String email, int password) throws RemoteException;  // changed return type from boolean to customer
    public Customer logOn(String email, String password) throws RemoteException;  // changed return type from boolean to customer
   
    //public ArrayList<Journey> getJourneyHistory(int customerNumber) throws RemoteException;	// customer number is stored as an integer in the databese
    public ArrayList<Journey> getJourneyHistory(int customerNumber, int index) throws RemoteException;        // (precision?) 3 / 5 / 10   ... cast integer to string
}