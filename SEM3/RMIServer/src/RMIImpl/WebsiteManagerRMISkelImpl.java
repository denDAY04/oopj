/* @author Jonas
 * Contributors:
 */

package RMIImpl;

import RMIInterfaces.WebsiteManagerRMISkel;
import Manager.DatabaseManager;
import ModelClasses.*;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WebsiteManagerRMISkelImpl extends UnicastRemoteObject implements WebsiteManagerRMISkel {
    DatabaseManager databasemanager;      
    public WebsiteManagerRMISkelImpl() throws RemoteException {  
        databasemanager = new DatabaseManager();
         System.out.println("WebsiteManagerRMI constructor executed"); 
    }  
    
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
    @Override
    public int createCustomer(Customer customer) throws RemoteException { 
        return databasemanager.createCustomer(customer);  
    }
    
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
    @Override
    public Customer setCustomerDetails(Customer customer) throws RemoteException {
        return databasemanager.setCustomerDetails(customer);        
    }

    /*@Override
    public Customer getCustomerDetails(String customerNumber) throws RemoteException {
        return databasemanager.getCustomerDetails(Integer.parseInt(customerNumber));            
    }*/        
 
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
    @Override
    public Customer logOn(String email, String password) throws RemoteException {
        return databasemanager.logOn(email, password);
    }

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
    @Override
    public ArrayList<Journey> getJourneyHistory(int customerNumber, int index) throws RemoteException {  
        return  databasemanager.getJourneyHistory(customerNumber, index);    
    }
        
}      