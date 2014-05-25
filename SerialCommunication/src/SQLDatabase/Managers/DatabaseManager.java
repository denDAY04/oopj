package SQLDatabase.Managers;

import SQLDatabase.ModelClasses.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * This is the sole class of the project that interacts directly with the
 * database. All manager classes should interact with this class in order to
 * interact with the database.
 */
public class DatabaseManager {

    /**
     * Update the information of existing data on the database. Use also this
     * method for adding new data objects to the database.
     *
     * @param updateQuery SQL command. See SQLLibrary.
     * @param parameters  Data to be updated or added in the database. Let the
     *                    objects of the ArrayList have their original class,
     *                    and be treated like Objects.
     *
     * @return The index number of the row that was edited or added.
     *
     * @see SQLLibrary
     */
    public int updateQuery(String updateQuery, ArrayList<Object> parameters) {
        int rowCount = 0;           //Return value from executeUpdate()
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    updateQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            rowCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return rowCount;
    }

    /**
     * Get all customers matching some parameters.
     *
     * @param getQuery   SQL command. See SQLLibrary.
     * @param parameters The parameters needed for a given SQL command.
     *
     * @return an ArrayList of Customer objects denoting the found customers.
     *
     * @see SQLLLibrary
     */
    public ArrayList<Customer> getCustomers(String getQuery,
            ArrayList<Object> parameters) {
        Connection con = null;
        ArrayList<Customer> customerList = new ArrayList();
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerList.add(createCustomer(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return customerList;
    }

    /**
     * Get all terminals matching some parameters.
     *
     * @param getQuery   SQL command. See SQLLibrary.
     * @param parameters The parameters needed for a given SQL command.
     *
     * @return an ArrayList of Terminal objects denoting the found customers.
     *
     * @see SQLLLibrary
     */
    public ArrayList<Terminal> getTerminals(String getQuery,
            ArrayList<Object> parameters) {
        ArrayList<Terminal> terminalList = new ArrayList();
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.err.println("added terminal to resultset");
                terminalList.add(createTerminal(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return terminalList;
    }

    /**
     * Get all deposits matching some parameters.
     *
     * @param getQuery   SQL command. See SQLLibrary.
     * @param parameters The parameters needed for a given SQL command.
     *
     * @return an ArrayList of Deposit objects denoting the found customers.
     *
     * @see SQLLLibrary
     */
    public ArrayList<Deposit> getDeposits(String getQuery,
            ArrayList<Object> parameters) {
        ArrayList<Deposit> depositList = new ArrayList();
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                depositList.add(createDeposit(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return depositList;
    }

    /**
     * Get a detailed billing matching some parameters.
     *
     * @param getQuery   SQL command. See SQLLibrary.
     * @param parameters The parameters needed for a given SQL command.
     *
     * @return an ArrayList of Objects in which the first is the Billing object
     *         denoting the actual billing, the second is a String denoting the
     *         billing address, and the third is a string denoting the zip code.
     *
     * @see SQLLLibrary
     */
    public ArrayList<Object> getDetailedBilling(String getQuery,
            ArrayList<Object> parameters) {
        ArrayList<Object> result = new ArrayList<Object>();
        Billing billing = null;
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String address = resultSet.getString("Road");
                String zipCode = resultSet.getString("ZipCode");
                billing = createBilling(resultSet);
                result.add(billing);
                result.add(address);
                result.add(zipCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Get all billings matching some parameters.
     *
     * @param getQuery   SQL command. See SQLLibrary.
     * @param parameters The parameters needed for a given SQL command.
     *
     * @return an ArrayList of Billing objects denoting the found customers.
     *
     * @see SQLLLibrary
     */
    public ArrayList<Billing> getBillings(String getQuery,
            ArrayList<Object> parameters) {
        ArrayList<Billing> billingList = new ArrayList();
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.
                            get(i));
                } else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                billingList.add(createBilling(resultSet));
            }
            return billingList;
        } catch (SQLException e) {
            System.err.println("ResultSet error");
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * Create a Customer object from the ResultSet containing a customer's data.
     *
     * @param resultSet containing the found data from the database.
     *
     * @return a Customer object holding all the data.
     *
     * @throws SQLException if the method tries to access a column that isn't
     *                      found in the ResultSet.
     */
    private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String customerNumb = resultSet.getString("CustomerNumb");
        String pin = resultSet.getString("Pin");
        String password = resultSet.getString("Password");
        String cardNumb = resultSet.getString("CardNumb");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String road = resultSet.getString("Road");
        String zipCode = resultSet.getString("ZipCode");
        String email = resultSet.getString("Email");
        String phoneNumb = resultSet.getString("PhoneNumb");
        int balance = Integer.parseInt(resultSet.getString("Balance"));
        String accountStatus = resultSet.getString("AccountStatus");
        String useStatus = resultSet.getString("UseStatus");
        return new Customer(customerNumb, pin, password, cardNumb, firstName,
                lastName, road, zipCode, email, phoneNumb, balance,
                accountStatus, useStatus);
    }

    /**
     * Create a Terminal object from the ResultSet containing a Terminal's data.
     *
     * @param resultSet containing the found data from the database.
     *
     * @return a Terminal object holding all the data.
     *
     * @throws SQLException if the method tries to access a column that isn't
     *                      found in the ResultSet.
     */
    private Terminal createTerminal(ResultSet resultSet) throws SQLException {
        String hardwareNumb = resultSet.getString("hardwareNumb");
        String road = resultSet.getString("road");
        String zipCode = resultSet.getString("zipCode");
        String ipAddress = resultSet.getString("ipAddress");
        String installStatus = resultSet.getString("installStatus");
        String chargingStatus = resultSet.getString("chargingStatus");
        String OfflineSince = resultSet.getString("OfflineSince");
        return new Terminal(hardwareNumb, road, zipCode, ipAddress,
                installStatus, chargingStatus, OfflineSince);
    }

    /**
     * Create a Deposit object from the ResultSet containing a Deposit's data.
     *
     * @param resultSet containing the found data from the database.
     *
     * @return a Deposit object holding all the data.
     *
     * @throws SQLException if the method tries to access a column that isn't
     *                      found in the ResultSet.
     */
    private Deposit createDeposit(ResultSet resultSet) throws SQLException {
        String depositsNumb = resultSet.getString("DepositsNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String depositsDate = resultSet.getString("DepositsDate");
        int depositAmount = Integer.parseInt(resultSet.
                getString("DepositAmount"));          
        int newBalanceDeposit = Integer.parseInt(resultSet.getString(
                "NewBalanceDeposit"));  
        String externalRefNumb = resultSet.getString("ExternalRefNumb");
        String last4CardNumb = resultSet.getString("Last4CardNumb");
        return new Deposit(depositsNumb, customerNumb, depositsDate,
                depositAmount, newBalanceDeposit, externalRefNumb, last4CardNumb);
    }

    /**
     * Create a Billing object from the ResultSet containing a Billing's data.
     *
     * @param resultSet containing the found data from the database.
     *
     * @return a Billing object holding all the data.
     *
     * @throws SQLException if the method tries to access a column that isn't
     *                      found in the ResultSet.
     */
    private Billing createBilling(ResultSet resultSet) throws SQLException {
        String transactionNumb = resultSet.getString("TransactionNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String hardwareNumb = resultSet.getString("HardwareNumb");
        String startCharge = resultSet.getString("StartCharge");
        String endCharge = resultSet.getString("EndCharge");
        String recieved = resultSet.getString("Recieved");
        int billingAmount = Integer.parseInt(resultSet.
                getString("BillingAmount")); 
        int billingRate = Integer.parseInt(resultSet.getString("BillingRate"));   
        int billingWH = Integer.parseInt(resultSet.getString("BillingWH"));    
        int newBalanceBilling = Integer.parseInt(resultSet.getString(
                "NewBalanceBilling")); 
        return new Billing(transactionNumb, customerNumb, hardwareNumb,
                startCharge, endCharge, recieved, billingAmount, billingRate,
                billingWH, newBalanceBilling);
    }
}
