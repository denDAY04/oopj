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
    
    public Customer verifyCustomer (String CardNumb,String pin){
            Customer costumer = null;
            ArrayList<String> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parameterscostumer.add(CardNumb);   // add the cardnumber parameter
            parameterscostumer.add(pin);        // add the pin parameter
            // do query in database (ArrayList: 1, CardNumb,2, Pin)
            System.out.println("CustomerManager verifyCustomer, Fire SQL statement");
            costumer = DatabaseManager.getCustomers(SQLLibrary.SYSTEM_VALIDATE_CUSTOMER, parameterscostumer).get(0);
            return costumer;
        
    }
    // add costumer
    
    // find costumer
    
    // update costumer
    
}