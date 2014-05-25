package SQLDatabase.Managers;

import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.Deposit;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create and retrieve deposits in the database.
 */
public class DepositManager {

    DatabaseManager databaseManager;

    /**
     * Setter for DatabaseManager reference.
     *
     * @param databaseManager DatabaseManager reference.
     */
    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Get the simple details of all the deposits linked to a given customer
     * number.
     *
     * @param customerNumb of the customer to whom the deposits should belong.
     *
     * @return an ArrayList of String arrays tailored for table-display.
     */
    public ArrayList<String[]> getSimpleDeposits(String customerNumb) {
        ArrayList<Object> parametersbilling = new ArrayList();
        parametersbilling.add(customerNumb);
        ArrayList<Deposit> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println(
                "DepositManager getDeposits, Fire SQL statement customerNumb: "
                + customerNumb);
        arr = databaseManager.getDeposits(SQLLibrary.USER_GET_DEPOSITS,
                parametersbilling);
        if (arr.isEmpty() == false) {
            for (int i = 0; i < arr.size(); ++i) {
                String a = arr.get(i).getDepositsNumb();
                String b = arr.get(i).getDepositsDate();
                String c = "" + (arr.get(i).getDepositAmount() / 100.0);
                String d = "" + (arr.get(i).getNewBalanceDeposit() / 100.0);
                String e = "**** **** **** " + arr.get(i).getLast4CardNumb();
                result.add(new String[]{a, b, c, d, e});
            }
        }
        return result;
    }

    /**
     * Get all deposits in the database.
     *
     * @return ArrayList of String arrays tailored for table-display.
     */
    public ArrayList<String[]> getAllDeposits() {
        ArrayList<Object> parametersbilling = new ArrayList();
        ArrayList<Deposit> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println("DepositManager getAllDeposits, Fire SQL statement");
        arr = databaseManager.getDeposits(SQLLibrary.SYSTEM_GET_ALL_DEPOSITS,
                parametersbilling);
        if (arr.isEmpty() == false) {
            for (int i = 0; i < arr.size(); ++i) {
                String a = "" + arr.get(i).getDepositsNumb();
                String b = "" + arr.get(i).getCustomerNumb();
                String c = arr.get(i).getDepositsDate();
                String d = "" + (arr.get(i).getDepositAmount() / 100.0);
                String e = "" + (arr.get(i).getNewBalanceDeposit() / 100.0);
                String f = arr.get(i).getExternalRefNumb();
                String g = "**** **** **** " + arr.get(i).getLast4CardNumb();
                result.add(new String[]{a, b, c, d, e, f, g});
            }
        }
        return result;
    }

    /**
     * Get a detailed deposit matching a deposit number.
     *
     * @param depositNumb of the deposit to find.
     *
     * @return an ArrayList of String objects.
     */
    public ArrayList<String> getDetailedDeposit(int depositNumb) {
        ArrayList<Object> parameter = new ArrayList<Object>();
        ArrayList<Deposit> deposit = new ArrayList<Deposit>();
        ArrayList<String> result = new ArrayList<String>();
        parameter.add(depositNumb);
        deposit = databaseManager.getDeposits(
                SQLLibrary.USER_GET_DEPOSIT_DETAILS, parameter);
        if (deposit.isEmpty() == false) {
            Deposit activeDeposit = deposit.get(0);
            result.add(activeDeposit.getDepositsNumb());
            result.add(activeDeposit.getDepositsDate());
            result.add("" + activeDeposit.getDepositAmount() / 100.0);
            result.add("" + activeDeposit.getNewBalanceDeposit() / 100.0);
            result.add(activeDeposit.getLast4CardNumb());
            result.add(activeDeposit.getExternalRefNumb());
        }
        return result;
    }

    /**
     * Get deposits by a specific reference number.
     *
     * @param refNumber Reference number of the deposit.
     *
     * @return an ArrayList of String arrays tailored for table-display.
     */
    public ArrayList<String[]> getDepositsByRefNumber(String refNumber) {
        ArrayList<Object> parametersbilling = new ArrayList();
        parametersbilling.add(refNumber);
        ArrayList<Deposit> arr;
        ArrayList<String[]> result = new ArrayList();
        System.out.println(
                "DepositManager getDepositsByRefNumber, Fire SQL statement: "
                + "efNumber: " + refNumber);
        arr = databaseManager.getDeposits(
                SQLLibrary.ADMIN_SEARCH_DEPOSITS_REFNUMBER, parametersbilling);
        if (arr.isEmpty() == false) {
            for (int i = 0; i < arr.size(); ++i) {
                String a = "" + arr.get(i).getDepositsNumb();
                String b = "" + arr.get(i).getCustomerNumb();
                String c = arr.get(i).getDepositsDate();
                String d = "" + (arr.get(i).getDepositAmount() / 100.0);
                String e = "" + (arr.get(i).getNewBalanceDeposit() / 100.0);
                String f = arr.get(i).getExternalRefNumb();
                String g = "**** **** **** " + arr.get(i).getLast4CardNumb();
                result.add(new String[]{a, b, c, d, e, f, g});
            }
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
     *
     * @param data See constraints above.
     */
    public void registerDeposit(Object[] data) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.addAll(Arrays.asList(data));
        /* Create new deposit entry in database, and edit customer's balance */
        databaseManager.updateQuery(SQLLibrary.SYSTEM_LOG_DEPOSIT, parameters);
        ArrayList<Object> arr = new ArrayList();
        arr.add(data[2]);                        // New balance
        arr.add(data[0]);                        // Customer ID
        databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE, arr);
    }
}
