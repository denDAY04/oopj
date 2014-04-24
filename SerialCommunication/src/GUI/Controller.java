/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.ModelClasses.Billing;
import SQLDatabase.ModelClasses.Customer;

/**
 *
 * @author Qess
 */
public class Controller {
    private Billing billingModel;
    private CustomerManager customerModel;
    private Customer customer = null;
    private AccountViewPanel accountView; 

    public void setCustomerModel(CustomerManager customerModel) {
        this.customerModel = customerModel;
    }

    public void setAccountView(AccountViewPanel accountView) {
        this.accountView = accountView;
    }

    
    
        public void findCustomer(String email, String password){
        
       customer = customerModel.verifyCustomerLogin(email, password);
       
       if (customer!= null)
       {
        accountView.showEmail(customer.getEmail());
       }
    }
            
    public void customerChanged(){
     //   accountView.showEmail("email");
        
    }
    
}
