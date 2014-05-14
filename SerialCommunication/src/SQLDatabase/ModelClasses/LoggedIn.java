/**
 * Project Name: SerialComV1
 * Class Name: LoggedIn
 * Engineers: Team Awesome 
 * Creation Date: May 2, 2014
 * Description:
 */
package SQLDatabase.ModelClasses;

import SQLDatabase.ModelClasses.Customer;

public class LoggedIn {
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
    
}
