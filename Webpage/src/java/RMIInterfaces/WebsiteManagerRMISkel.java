//Author: Mathias Nordahl
package RMIInterfaces;

import ModelClasses.*;
import java.rmi.*;
import java.util.ArrayList;

public interface WebsiteManagerRMISkel extends Remote
{
    /**
    * Invokes the createCustomer method specified in the DatabaseManager.java included
    * in the Libraries/DatabaseManager.jar.
    * Implements the method from RMIInterfaces/WebsiteManagerRMISkel.
    * <P>
    * Adds a customer to the SQL database.
    * @param  Customer The customer to be created without customerNumber.
    * @return      The customerNumber
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    * @see         Manager.DatabaseManager
    * @throws java.rmi.RemoteException 
    */  
    public int createCustomer(Customer customer) throws RemoteException; 
    
    /**
    * Invokes the setCustomerDetails method specified in the DatabaseManager.java included
    * in the Libraries/DatabaseManager.jar.
    * Implements the method from RMIInterfaces/WebsiteManagerRMISkel
    * <P>
    * Changes the information on a customer in the SQL database.
    * @param  Customer The updated customer with customerNumber.
    * @return      The new data for the customer.
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    * @see         Manager.DatabaseManager
    * @throws java.rmi.RemoteException 
    */ 
    public Customer setCustomerDetails(Customer customer) throws RemoteException;
    
    // customer number is stored as an integer in the database... cast integer to string for return
    //public Customer getCustomerDetails(String customerNumber) throws RemoteException; 

    /**
    * Invokes the logOn method specified in the DatabaseManager.java included
    * in the Libraries/DatabaseManager.jar.
    * Implements the method from RMIInterfaces/WebsiteManagerRMISkel
    * <P>
    * Finds the customer with the specified email/password combination.
    * @param  email The email address entered by the user
    * @param password The password entered by the user
    * @return      A Customer object.
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    * @see         Manager.DatabaseManager
    * @throws java.rmi.RemoteException 
    */
    public Customer logOn(String email, String password) throws RemoteException;
   
    /**
    * Invokes the getJourneyHistory method specified in the DatabaseManager.java included
    * in the Libraries/DatabaseManager.jar.
    * Implements the method from RMIInterfaces/WebsiteManagerRMISkel
    * <P>
    * Finds the journey objects associated with a customerNumber
    * @param  customerNumber The users customerNumber
    * @param index The index to fetch the tickets from
    * @return ArrayList<Journey> 
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    * @see         Manager.DatabaseManager
    * @throws java.rmi.RemoteException 
    */
    public ArrayList<Journey> getJourneyHistory(int customerNumber, int index) throws RemoteException;  
}