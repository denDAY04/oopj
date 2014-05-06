/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.Deposit;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nordahl
 */
public class DepositManager {
    DatabaseManager databaseManager;

    public void setDatabaseManager(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }
    
    public ArrayList<String[]> getSimpleDeposits (String customerNumb){
            ResultSet rs = null;
            ArrayList<Object> parametersbilling = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parametersbilling.add(customerNumb);   // add the customerNumb parameter
            ArrayList<Deposit> arr;                             // Temp ArrayList for holding all billings with full data
            ArrayList<String[]> result = new ArrayList();       // ArrayList for results containing only desired data
            System.out.println("DepositManager getDeposits, Fire SQL statement customerNumb: "+customerNumb);
            try{
                arr = databaseManager.getDeposits(SQLLibrary.USER_GET_DEPOSITS,parametersbilling);
                Deposit activeDeposit; 
                for (int i = 0; i < arr.size(); ++i) {
                    activeDeposit = arr.get(i);
                    String a = activeDeposit.getDepositsNumb();
                    String b = activeDeposit.getDepositsDate();
                    String c = "" + (activeDeposit.getDepositAmount() / 100.0);
                    String d = "" + (activeDeposit.getNewBalanceDeposit() / 100.0);
                    String e = "**** **** **** " + activeDeposit.getLast4CardNumb();
                    result.add(new String[]{a, b, c, d, e});
                }
            } catch(NullPointerException e){
                e.printStackTrace(); 
            }
            return result;
    }     
   
   /**
    * Register a deposit. 
    * 
    * CONSTRAINT: The order of the data in the parameter must follow a certain 
    * pattern:
    * <li>Customer number (int)
    * <li>Amount of DKK deposited (int)
    * <li>New balance after deposit (int)
    * <li>External reference number (int)
    * <li>Last four digits of credit card (int)
    * <br><br>
    * @param data See constraints above.
    */
   public void registerDeposit(Object[] data) {
        ArrayList<Object> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        parameters.addAll(Arrays.asList(data));
        /* Create new deposit entry in database, and edit customer's balance */
        databaseManager.updateQuery(SQLLibrary.SYSTEM_LOG_DEPOSIT, parameters);
        ArrayList<Object> arr = new ArrayList();
        arr.add(data[2]);                        // New balance
        arr.add(data[0]);                        // Customer ID
        databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE, arr);
   }
}

