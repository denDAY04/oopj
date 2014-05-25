package SQLDatabase.ModelClasses;

/**
 * This class keeps track of the customer currently signed in in the GUI with
 * its Customer field object.
 */
public class LoggedIn {

    private Customer customer;

    /**
     * Setter for the customer reference.
     *
     * @param customer Customer object denoting the customer currently logged
     *                 in.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter for the customer reference.
     *
     * @return a Customer Object denoting the logged in customer.
     */
    public Customer getCustomer() {
        return customer;
    }
}
