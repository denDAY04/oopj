/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;
import GUI.Test.ResultSetTableModel;
import SQLDatabase.Library.SQLLibrary;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nordahl
 */
public class BillingManager {
    DatabaseManager databaseManager;
    ResultSetTableModel tableModel;

    public void setDatabaseManager(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }

    public void setTableModel(ResultSetTableModel tableModel) {
        this.tableModel = tableModel;
    }
    
    public void getBillings (String customerNumb){
            ResultSet rs = null;
            ArrayList<Object> parametersbilling = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parametersbilling.add(customerNumb);   // add the customerNumb parameter
            // do query in database (ArrayList: 1, CardNumb)
            System.out.println("BillingManager getBillings, Fire SQL statement customerNumb: "+customerNumb);
            try{
                rs = databaseManager.getBillings(SQLLibrary.USER_GET_BILLING, parametersbilling);
                System.err.println("test");
                tableModel.setResultSet(rs);
            } catch(NullPointerException e){
                System.err.println("test5");
                e.printStackTrace(); 
            }
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
       ArrayList<Object> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
       parameters.addAll(Arrays.asList(data));
       /* Create new billing entry in database, and edit customer's balance */
       databaseManager.updateQuery(SQLLibrary.SYSTEM_LOG_NEW_BILLING, parameters);
       ArrayList<Object> arr = new ArrayList();
       arr.add(data[7]);                        // New balance
       arr.add(data[0]);                        // Customer ID
       databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE, arr);
       
   }
}

