/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class WebsiteManagerRMISkel implements WebsiteManagerRMISkelInterface {

    @Override
    public List<Journey> getJourneyHistory(int customerNumber) {


        List<Journey> test = new ArrayList(); 
        Journey journey = new Journey();
        journey.setStartzone(1);
        journey.setNumberofzones(2);
        journey.setPrice(10);
        journey.setStarttime(new GregorianCalendar());

        Journey journey2 = new Journey();
        journey2.setStartzone(3);
        journey2.setNumberofzones(3);
        journey2.setPrice(15);
        journey2.setStarttime(new GregorianCalendar());
        
        test.add(journey);
        test.add(journey2);
        
       return test;  
    }

    @Override
    public Customer getCustomerDetails(int customerNumber) {

        Customer customer = new Customer();
        customer.setCustomerNumber(1234);
        customer.setFirstname("Hans");
        customer.setLastname("Jensen");
        customer.setEmail("hans@jensen.dk");
        
        return customer;
    }

    @Override
    public void setCustomerDetails(Customer customer) {        
    }

    @Override
    public boolean createCustomer(Customer customer) {
        return true;
    }

    @Override
    public boolean logOn(String email, String password) {
        return true;
    }

    @Override
    public boolean logOff() {
        return true;
    }
    
}