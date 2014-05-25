package SQLDatabase.Managers;

import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.Billing;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Creates and handles searches for billings in the database.
 */
public class BillingManager {

    DatabaseManager databaseManager;

    /**
     * Setter for DatabaseManager reference.
     *
     * @param databaseManager DatabaseManager
     */
    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Get all billings from the database with a specific customer number. The
     * product of this method is on the simple details of all the billings.
     *
     * @param customerNumb of the customer that the billings should be linked
     *                     to.
     *
     * @return an ArrayList of String arrays tailored to table-displaying.
     */
    public ArrayList<String[]> getSimpleBillings(String customerNumb) {
        ArrayList<Object> parametersbilling = new ArrayList();
        parametersbilling.add(customerNumb);
        ArrayList<Billing> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println("BillingManager getSimpleBillings, Fire SQL "
                + "statement customerNumb: " + customerNumb);
        try {
            arr = databaseManager.getBillings(SQLLibrary.USER_GET_BILLING,
                    parametersbilling);
            Billing activeBilling;
            for (int i = 0; i < arr.size(); ++i) {
                activeBilling = arr.get(i);
                String a = activeBilling.getTransactionNumb();
                String b = activeBilling.getRecieved();
                String c = "" + (activeBilling.getBillingAmount() / 100.0);
                String d = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                result.add(new String[]{a, b, c, d});
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get all billings in the database. The product of this method contains all
     * the details for each billing instance.
     *
     * @return an ArrayList of String arrays tailored to table-displaying.
     */
    public ArrayList<String[]> getAllBillings() {
        ArrayList<Object> parametersbilling = new ArrayList();
        ArrayList<Billing> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println("BillingManager getAllBillings, Fire SQL statement");
        try {
            arr = databaseManager.getBillings(
                    SQLLibrary.SYSTEM_GET_ALL_BILLINGS, parametersbilling);
            Billing activeBilling;
            for (int i = 0; i < arr.size(); ++i) {
                activeBilling = arr.get(i);
                String a = "" + activeBilling.getTransactionNumb();
                String b = "" + activeBilling.getCustomerNumb();
                String c = "" + activeBilling.getHardwareNumb();
                String d = activeBilling.getStartCharge().substring(0, 19);
                String e = "" + (activeBilling.getBillingAmount() / 100.0);
                String f = "" + (activeBilling.getBillingRate() / 100.0);
                String g = "" + (activeBilling.getBillingWH());
                String h = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                result.add(new String[]{a, b, c, d, e, f, g, h});
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get a all details for a billing with a specific transaction number, from
     * the database.
     *
     * @param transactionNumber that the desired billing has.
     *
     * @return an ArrayList of Strings.
     */
    public ArrayList<String> getDetailedBilling(int transactionNumber) {
        ArrayList<Object> parameter = new ArrayList<Object>();
        ArrayList<Object> temp;
        ArrayList<String> result = new ArrayList<String>();

        parameter.add(transactionNumber);
        temp = databaseManager.getDetailedBilling(
                SQLLibrary.USER_GET_BILLING_AND_TERMINAL, parameter);
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
            result.add("" + billing.getBillingWH());
            result.add("" + billing.getNewBalanceBilling() / 100.0);
            result.add(address);
            result.add(zipCode);
        }
        return result;
    }

    /**
     * Return a billing with a specific transaction number, from the database.
     *
     * @param transactionNumb that the billing should have
     *
     * @return an ArrayList of String arrays tailored for table-displaying.
     */
    public ArrayList<String[]> getBillingsByTransactionNumb(
            String transactionNumb) {
        ArrayList<Object> parametersbilling = new ArrayList();
        parametersbilling.add(transactionNumb);
        ArrayList<Billing> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println("BillingManager getAllBillings, Fire SQL statement:"
                + " TransactionNumb: " + transactionNumb);
        try {
            arr = databaseManager.getBillings(
                    SQLLibrary.ADMIN_SEARCH_BILLINGS_TRANSNUMB,
                    parametersbilling);
            Billing activeBilling;
            for (int i = 0; i < arr.size(); ++i) {
                activeBilling = arr.get(i);
                String a = "" + activeBilling.getTransactionNumb();
                String b = "" + activeBilling.getCustomerNumb();
                String c = "" + activeBilling.getHardwareNumb();
                String d = activeBilling.getStartCharge().substring(0, 19);
                String e = "" + (activeBilling.getBillingAmount() / 100.0);
                String f = "" + (activeBilling.getBillingRate() / 100.0);
                String g = "" + (activeBilling.getBillingWH());
                String h = "" + (activeBilling.getNewBalanceBilling() / 100.0);
                result.add(new String[]{a, b, c, d, e, f, g, h});
            }
        } catch (NullPointerException e) {
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
     *
     * @param data See constraint above.
     */
    public void registerBilling(String[] data) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.addAll(Arrays.asList(data));

        /* Create new billing entry in database, and edit customer's balance */
        databaseManager.updateQuery(SQLLibrary.SYSTEM_LOG_NEW_BILLING,
                parameters);
        ArrayList<Object> arr = new ArrayList();
        arr.add(data[7]);                        // New balance
        arr.add(data[0]);                        // Customer ID
        databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE, arr);
    }
}
