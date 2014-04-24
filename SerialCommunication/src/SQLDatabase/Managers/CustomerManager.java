/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import java.util.ArrayList;

/**
 *
 * @author Qess
 */
public class CustomerManager {
DatabaseManager databaseManager;

  public void setDatabaseManager(DatabaseManager databaseManager){
  this.databaseManager = databaseManager;
  }
    
   public Customer verifyCustomer (String cardNumb,String pin){
            Customer costumer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(cardNumb);   // add the cardnumber parameter
            parameterscostumer.add(pin);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            System.out.println("CustomerManager verifyCustomer, Fire SQL statement");
            costumer = databaseManager.getCustomers(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER, parameterscostumer).get(0);
            return costumer;
    }
   
      public Customer verifyCustomerLogin (String email,String password){
            Customer costumer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(email);   // add the cardnumber parameter
            parameterscostumer.add(password);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            System.out.println("CustomerManager verifyCustomerLogin, Fire SQL statement");
            System.out.println("email: "+email+" password: "+password);
            
            costumer = databaseManager.getCustomers(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER_LOGIN, parameterscostumer).get(0);
          //  databaseManager.test();
            return costumer;
    }       
   
   
   
    // add costumer
    
    // find costumer
    
    // update costumer
    
}
