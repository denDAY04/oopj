package SQLDatabase.Managers;

import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class creates, modifies, and retrieves customer data in the database. It
 * also tracks the customer logged in on the GUI front-end of the system.
 *
 * @see LoggedIn
 */
public class CustomerManager {

    DatabaseManager databaseManager;
    LoggedIn loggedInUser = new LoggedIn();     // Track front-end customer

    /**
     * Setter for DatabaseManager reference.
     *
     * @param databaseManager DatabaseManager reference
     */
    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Getter for the customer currently logged in in the GUI.
     *
     * @return a Customer object with the data of the logged in customer, or
     *         NULL if none is logged in.
     */
    public Customer getLoggedInUser() {
        return loggedInUser.getCustomer();
    }

    /**
     * Setter for the customer currently logged in in the GUI.
     *
     * @param user Customer object denoting the user of the GUI.
     */
    public void setLoggedInUser(Customer user) {
        loggedInUser.setCustomer(user);
    }

    /**
     * Search for a customer in the database with a specific card number and
     * pin.
     *
     * @param cardNumb of the customer that needs found.
     * @param pin      of the customer that needs found.
     *
     * @return a Customer object denoting the customer, or NULL if no match was
     *         found.
     */
    public Customer verifyCustomer(String cardNumb, String pin) {
        Customer customer = null;
        ArrayList<Object> parameterscostumer = new ArrayList();
        parameterscostumer.add(cardNumb);
        parameterscostumer.add(pin);

        System.out.println("CustomerManager verifyCustomer, Fire SQL statement"
                + " cardNumb:'" + cardNumb + "' pin: '" + pin + "'");
        ArrayList<Customer> arr = databaseManager.getCustomers(
                SQLLibrary.SYSTEM_VALIDATE_CUSTOMER, parameterscostumer);
        if (arr.isEmpty() == false) {
            customer = arr.get(0);
            System.out.println("found: '" + customer.getFirstName() + "'");
        } else {
            System.err.println("No customers found.");
        }
        return customer;
    }

    /**
     * Set the reference to the customer currently using the GUI.
     *
     * @param email    of the customer
     * @param password of the customer
     *
     * @return true if the reference was successfully changed; false if no
     *         customer was found in the database with such email and password.
     */
    public boolean loggedInAs(String email, String password) {
        Customer customer = null;
        ArrayList<Object> parameterscostumer = new ArrayList();
        parameterscostumer.add(email);
        parameterscostumer.add(password);

        System.out.println("CustomerManager loggedInAs email: " + email
                + " password: " + password);
        try {
            customer = databaseManager.getCustomers(
                    SQLLibrary.SYSTEM_VALIDATE_CUSTOMER_LOGIN,
                    parameterscostumer).get(0);
            loggedInUser.setCustomer(customer);
            return true;
        } catch (IndexOutOfBoundsException e) {
            loggedInUser.setCustomer(null);
            return false;
        }
    }

    /**
     * Set the reference to the customer that the administrator wishes to log in
     * as.
     *
     * @param email of the customer to be logged in.
     *
     * @return true if the reference was successfully changed; false if no
     *         customer was found in the database with such email.
     */
    public boolean admLoggedInAs(String email) {
        Customer customer = null;
        ArrayList<Object> parameterscostumer = new ArrayList();
        parameterscostumer.add(email);

        System.out.println("CustomerManager adminLoggedInAs email: " + email);
        try {
            customer = databaseManager.getCustomers(
                    SQLLibrary.SYSTEM_GET_CUSTOMER_BY_EMAIL, parameterscostumer).
                    get(0);
            loggedInUser.setCustomer(customer);
            return true;
        } catch (IndexOutOfBoundsException e) {
            loggedInUser.setCustomer(null);
            return false;
        }
    }

    public boolean updateLoggedInCustomer(String customerNumb) {
        Customer customer = null;
        ArrayList<Object> parameterscostumer = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        parameterscostumer.add(customerNumb);   // add the email parameter
        // do query in database (ArrayList: 1, email)
        System.out.println(
                "CustomerManager updateLoggedInCustomer customerNumb: " + customerNumb);
        try {
            customer = databaseManager.getCustomers(
                    SQLLibrary.SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB,
                    parameterscostumer).get(0);
            loggedInUser.setCustomer(customer);
            return true;
        } catch (IndexOutOfBoundsException e) {
            loggedInUser.setCustomer(null);
            return false;
        }
    }

    /**
     * Update information on a customer in the database. CONSTRAINT: the order
     * in which the new values are placed in the array parameter must follow the
     * order in which they are set in the SQL library. See SQLLibrary class.
     *
     * @param customerID This will be the card number of the customer if the
     *                   command is coming from a charging station. If coming
     *                   from the web-based client this should be the customer's
     *                   number.
     * @param command    Denotes the command to be executed. See list for
     *                   values:
     * <br>1: Set use status (when charging)
     * <br>2: Set new balance
     * <br>3: Set all customer data as customer
     * <br>4: Set customer password
     * <br>5: Set customer password as customer
     * <br>6: Set customer's password as administrator
     * <br>7: Set customer's account status as administrator
     * <br>
     * @param newValues  the new values that should be put into the database.
     *                   See constraints above!
     */
    public void updateCustomerInformation(String customerID, int command,
            Object[] newValues) {
        ArrayList<Object> parameters = new ArrayList();
        switch (command) {
            case 1:         // Set use status
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 1");
                databaseManager.updateQuery(
                        SQLLibrary.SYSTEM_SET_CUSTOMER_USE_STATUS, parameters);
                break;
            case 2:         // Set new balance
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 2");
                databaseManager.updateQuery(SQLLibrary.SYSTEM_WRITE_NEW_BALANCE,
                        parameters);
                break;
            case 3:         // Set all customer data as customer
                parameters.addAll(Arrays.asList(newValues));
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 3");
                databaseManager.updateQuery(SQLLibrary.USER_SET_USER_DATA,
                        parameters);
                break;
            case 4:         // Set customer password as customer
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 4");
                databaseManager.updateQuery(SQLLibrary.USER_SET_USER_PASSWORD,
                        parameters);
                break;
            case 5:         // Set all customer data as administrator
                parameters.addAll(Arrays.asList(newValues));
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 5");
                databaseManager.updateQuery(SQLLibrary.ADMIN_SET_USER_DATA,
                        parameters);
                break;
            case 6:         // Set customer's password as administrator
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 6");
                databaseManager.updateQuery(SQLLibrary.ADMIN_SET_USER_PASSWORD,
                        parameters);
                break;
            case 7:         // Set customer's account status as administrator
                parameters.add(newValues[0]);
                parameters.add(customerID);
                System.out.println(
                        "CustomerManager updateInformation, Fire SQL statement,"
                        + " Case 7");
                databaseManager.updateQuery(
                        SQLLibrary.ADMIN_SET_USER_ACCOUNTSTATUS, parameters);
                break;
        }
    }

    /**
     * Add a new customer to the database. CONSTRAINT: The order in which the
     * different customer informations are placed in the array parameter must
     * follow the order specified in the SQL call. See SQLLIbrary,
     * SYSTEM_CREATE_NEW_CUSTOMER.
     *
     * @param information Array of the new customer's information. See
     *                    constraint above!
     */
    public void addNewCustomer(Object[] information) {
        ArrayList<Object> parameters = new ArrayList();
        int length = information.length;
        for (int i = 0; i < length; ++i) {
            parameters.add(information[i]);
        }
        databaseManager.updateQuery(SQLLibrary.SYSTEM_CREATE_NEW_CUSTOMER,
                parameters);
    }

    /**
     * Find the customer in the database associated with a given card number.
     *
     * @param cardNumb The card number associated with the customer that is
     *                 desired found.
     *
     * @return A Customer object with all the information of the customer; NULL
     *         if no customer was found.
     */
    public Customer getCustomer(String cardNumb) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(cardNumb);
        Customer customer = null;
        ArrayList<Customer> arr = databaseManager.getCustomers(
                SQLLibrary.SYSTEM_GET_CUSTOMER_BY_CARD, parameters);
        if (arr.isEmpty() == false) {
            customer = arr.get(0);
        }
        return customer;
    }

    /**
     * Find the customer in the database associated with a given email.
     *
     * @param email The email associated with the customer that is desired
     *              found.
     *
     * @return A Customer object with all the information of the customer; NULL
     *         if no customer was found.
     */
    public Customer getCustomerByEmail(String email) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(email);
        Customer customer = null;
        System.out.println("CustomerManager getCustomerByEmail Email: " + email);
        ArrayList<Customer> arr = databaseManager.getCustomers(
                SQLLibrary.SYSTEM_GET_CUSTOMER_BY_EMAIL, parameters);
        if (arr.isEmpty() == false) {
            customer = arr.get(0);
        } else {
            throw new NullPointerException(
                    "No customer found with this emailaddress");
        }
        return customer;
    }

    /**
     * Find the customer in the database associated with a given FirstName.
     *
     * @param firstName The first name associated with the customer that is
     *                  desired found.
     *
     * @return An ArrayList of String[] containing FirstName, LastName and Email
     *         for each customer found.
     */
    public ArrayList<String> getCustomersByFirstName(String firstName) {
        ArrayList<Customer> customers;
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(firstName);
        ArrayList<String> result = new ArrayList();
        customers = databaseManager.getCustomers(
                SQLLibrary.ADMIN_SEARCH_USER_FIRSTNAME, parameters);
        if (customers.isEmpty() == false) {
            for (int i = 0; i < customers.size(); ++i) {
                String a = customers.get(i).getFirstName();
                String b = customers.get(i).getLastName();
                String c = customers.get(i).getEmail();
                result.add(a + " " + b + ", " + c);
            }
        }
        return result;
    }
}
