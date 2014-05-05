/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;
import GUI.Test.LoggedIn;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Qess
 */
public class CustomerManager {
    DatabaseManager databaseManager;
    LoggedIn loggedInUser = new LoggedIn();

    public void setDatabaseManager(DatabaseManager databaseManager){
  this.databaseManager = databaseManager;
  }
    
    public Customer getLoggedInUser(){
        return loggedInUser.getCustomer();
    }
    
    public Customer verifyCustomer (String cardNumb,String pin){
            Customer customer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(cardNumb);   // add the cardnumber parameter
            parameterscostumer.add(pin);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            System.out.println("CustomerManager verifyCustomer, Fire SQL statement cardNumb:'"+cardNumb+"' pin: '"+pin+"'");
            ArrayList<Customer> arr = databaseManager.getCustomers(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER, parameterscostumer);
            if (arr.isEmpty() == false) {
                customer = arr.get(0);
                System.out.println("found: '"+customer.getFirstName()+"'");
            } else {
                System.err.println("No customers found.");
            }
            return customer;
    }
   
    public boolean loggedInAs (String email,String password){
            Customer customer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(email);   // add the cardnumber parameter
            parameterscostumer.add(password);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            System.out.println("CustomerManager verifyCustomerLogin, Fire SQL statement");
            System.out.println("email: "+email+" password: "+password);
            
            try {
                customer = databaseManager.getCustomers(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER_LOGIN, parameterscostumer).get(0);
                loggedInUser.setCustomer(customer);
                return true;
            } catch (IndexOutOfBoundsException e) {
                loggedInUser.setCustomer(null);
                return false;
            }
          //  databaseManager.test();
            //return costumer;
    }       
    
    /**
     * Update information on a customer in the database.
     * CONSTRAINT: the order in which the new values are placed in the array 
     * parameter must follow the order in which they are set in the SQL library.
     * See SQLLibrary class.
     * 
     * @param customerID This will be the card number of the customer if the 
     * command is coming from a charging station. If coming from the web-based
     * client this should be the customer's ID. 
     * @param command Denotes the command to be executed. See Table for values:
     * <br>1: Set use status (when charging)
     * <br>2: ... [add as they come]
     * <br>
     * @param newValues the new values that should be put into the database. 
     * See constraints above!
     */
    public void updateCustomerInformation (String customerID, int command, String[] newValues) {
        ArrayList<String> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        switch (command) {
            case 1:         // Set use status
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println("CustomerManager updateInformation, Fire SQL statement");
                databaseManager.updateQuery(SQLLibrary.SYSTEM_SET_CUSTOMER_USE_STATUS, parameters);
                break;
        }
    }
   
    /**
     * Add a new customer to the database.
     * CONSTRAINT: The order in which the different customer informations are
     * placed in the array parameter must follow the order specified in the SQL
     * call. See SQLLIbrary, SYSTEM_CREATE_NEW_CUSTOMER.
     * 
     * @param information Array of the new customer's information. See 
     * constraint above!
     */
   public void addNewCustomer(String[] information) {
       ArrayList<String> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
       for (int i = 0; i < 9; ++i) {
           parameters.add(information[i]);
       }
       databaseManager.updateQuery(SQLLibrary.SYSTEM_CREATE_NEW_CUSTOMER, parameters);
   }
   
   /**
    * Find the customer in the database associated with a given card number.
    * 
    * @param cardNumb The card number associated with the customer that is 
    * desired found.
    * @return A Customer object with all the information of the customer.
    */
   public Customer getCustomer(String cardNumb) {
       ArrayList<String> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
       parameters.add(cardNumb);
       Customer customer = null;
       ArrayList<Customer> arr = databaseManager.getCustomers(SQLLibrary.SYSTEM_GET_CUSTOMER, parameters);
       if (arr.isEmpty() == false) {
           customer = arr.get(0);
       }
       return customer;
   }
   
   /**
    * Register a billing when a car has been charged.
    * 
    * CONSTRAINT: The order of the data in the parameter must follow a certain 
    * pattern:
    * <li>Customer number
    * <li>Terminal number
    * <li>Start time of charging
    * <li>End time of charging
    * <li>The amount of DKK to be billed
    * <li>The rate to which he is billed (DKK/kwH)
    * <li>The amount of kWh that was charged
    * <li>The new balance of the the customer after being billed
    * <br> <br>
    * @param data See constraint above.
    */
   public void registerBilling(String[] data) {
       ArrayList<String> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
       parameters.addAll(Arrays.asList(data));
       /* Create new billing entry in database, and edit customer's balance */
       databaseManager.updateQuery(SQLLibrary.SYSTEM_LOG_NEW_BILLING, parameters);
       ArrayList<String> arr = new ArrayList();
       arr.add(data[7]);                        // New balance
       arr.add(data[0]);                        // Customer ID
       databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE, arr);
       
   }
}
