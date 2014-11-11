//Class from which objects will be created 
//and then passed as arguments.

package RmiServer.Interface;

import ModelClasses.*;
import java.rmi.*;
import java.util.ArrayList;

public interface IntWebsiteManagerRMISkel extends Remote
{
    public boolean createCustomer(Customer customer) throws RemoteException; 
    
    public void setCustomerDetails(Customer customer) throws RemoteException;
    // public Customer getCustomerDetails(int customerNumber) throws RemoteException; // customer number is stored as an integer in the databese
    public Customer getCustomerDetails(String customerNumber)throws RemoteException; // new addition ... cast integer to string
    
    //public boolean logOn(String email, String password);
    //public Customer logOn(String email, int password) throws RemoteException;  // changed return type from boolean to customer
    public Customer logOn(String email, String password) throws RemoteException;  // changed return type from boolean to customer
   
    //public ArrayList<Journey> getJourneyHistory(int customerNumber) throws RemoteException;	// customer number is stored as an integer in the databese
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) throws RemoteException;        // (precision?) 3 / 5 / 10   ... cast integer to string
}