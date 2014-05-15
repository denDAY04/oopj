/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;
import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.Billing;
import SQLDatabase.ModelClasses.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nordahl
 */
public class BillingManager {
    DatabaseManager databaseManager;

    public void setDatabaseManager(DatabaseManager databaseManager){
        this.databaseManager = databaseManager;
    }
    
    public ArrayList<String[]> getSimpleBillings (String customerNumb){
            ResultSet rs = null;
            ArrayList<Object> parametersbilling = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parametersbilling.add(customerNumb);   // add the customerNumb parameter
            ArrayList<Billing> arr;                             // Temp ArrayList for holding all billings with full data
            ArrayList<String[]> result = new ArrayList();       // ArrayList for results containing only desired data
            System.out.println("BillingManager getSimpleBillings, Fire SQL statement customerNumb: "+customerNumb);
            try{
                arr = databaseManager.getBillings(SQLLibrary.USER_GET_BILLING, parametersbilling);
                Billing activeBilling; 
                for (int i = 0; i < arr.size(); ++i) {
                    activeBilling = arr.get(i);
                    String a = activeBilling.getTransactionNumb();
                    String b = activeBilling.getRecieved();
                    String c = "" + (activeBilling.getBillingAmount() / 100.0);
                    String d = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                    result.add(new String[]{a, b, c, d});
                }
            } catch(NullPointerException e){
                e.printStackTrace(); 
            }
            return result;
    }     
    
    public ArrayList<String[]> getAllBillings (){
            ResultSet rs = null;
            ArrayList<Object> parametersbilling = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            //parametersbilling.add(customerNumb);   // add the customerNumb parameter
            ArrayList<Billing> arr;                             // Temp ArrayList for holding all billings with full data
            ArrayList<String[]> result = new ArrayList();       // ArrayList for results containing only desired data
            System.out.println("BillingManager getAllBillings, Fire SQL statement");
            try{
                arr = databaseManager.getBillings(SQLLibrary.SYSTEM_GET_ALL_BILLINGS, parametersbilling);
                Billing activeBilling; 
                for (int i = 0; i < arr.size(); ++i) {
                    activeBilling = arr.get(i);
                    String a = ""+activeBilling.getTransactionNumb();
                    String b = ""+activeBilling.getCustomerNumb();
                    String c = ""+activeBilling.getHardwareNumb();
                    String d = activeBilling.getStartCharge().substring(0, 19);
                    String e = "" + (activeBilling.getBillingAmount() / 100.0);
                    String f = "" + (activeBilling.getBillingRate() / 100.0);
                    String g = "" + (activeBilling.getBillingKWH() / 100.0);
                    String h = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                    result.add(new String[]{a, b, c, d, e, f, g, h});
                }
            } catch(NullPointerException e){
                e.printStackTrace(); 
            }
            return result;
    }
    
    public ArrayList<String> getDetailedBilling(int transactionNumber) {
        ArrayList<Object> parameter = new ArrayList<Object>();
        ArrayList<Object> temp;
        ArrayList<String> result = new ArrayList<String>();
        
        parameter.add(transactionNumber);
        temp = databaseManager.getDetailedBilling(SQLLibrary.USER_GET_BILLING_AND_TERMINAL, parameter);
        Billing billing = (Billing) temp.get(0);
        String address = (String) temp.get(1);
        String zipCode = (String) temp.get(2);
        
        if (billing != null && address != null && zipCode != null) {
            result.add(billing.getTransactionNumb());
            result.add(billing.getStartCharge());
            result.add(billing.getEndCharge());
            result.add(billing.getRecieved());
            result.add("" + billing.getBillingAmount() / 100.0);
            result.add("" + billing.getBillingRate() / 100.0);
            result.add("" + billing.getBillingKWH());
            result.add("" + billing.getNewBalanceBilling() / 100.0);
            result.add(address);
            result.add(zipCode);
        }
        return result;
    }
    
    public ArrayList<String[]> getBillingsByTransactionNumb (String transactionNumb){
            ResultSet rs = null;
            ArrayList<Object> parametersbilling = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
            parametersbilling.add(transactionNumb);   // add the transactionNumb parameter
            ArrayList<Billing> arr;                             // Temp ArrayList for holding all billings with full data
            ArrayList<String[]> result = new ArrayList();       // ArrayList for results containing only desired data
            System.out.println("BillingManager getAllBillings, Fire SQL statement: TransactionNumb: "+transactionNumb);
            try{
                arr = databaseManager.getBillings(SQLLibrary.ADMIN_SEARCH_BILLINGS_TRANSNUMB, parametersbilling);
                Billing activeBilling; 
                for (int i = 0; i < arr.size(); ++i) {
                    activeBilling = arr.get(i);
                    String a = ""+activeBilling.getTransactionNumb();
                    String b = ""+activeBilling.getCustomerNumb();
                    String c = ""+activeBilling.getHardwareNumb();
                    String d = activeBilling.getStartCharge().substring(0, 19);
                    String e = "" + (activeBilling.getBillingAmount() / 100.0);
                    String f = "" + (activeBilling.getBillingRate() / 100.0);
                    String g = "" + (activeBilling.getBillingKWH() / 100.0);
                    String h = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                    result.add(new String[]{a, b, c, d, e, f, g, h});
                }
            } catch(NullPointerException e){
                e.printStackTrace(); 
            }
            return result;
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

