/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Rasmus
 */
public class WebsiteManagerRMISkel implements WebsiteManagerRMISkelInterface {

    @Override
    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) {


        ArrayList<Journey> test = new ArrayList(); 
        
        Journey journey = new Journey();
        journey.setStartzone(1);
        journey.setNumberofzones(2);
        journey.setPrice(10);
        journey.setStarttime("10-01-14");

        Journey journey2 = new Journey();
        journey2.setStartzone(3);
        journey2.setNumberofzones(3);
        journey2.setPrice(15);
        journey2.setStarttime("10-02-14");
        
        Journey journey3 = new Journey();
        journey3.setStartzone(5);
        journey3.setNumberofzones(7);
        journey3.setPrice(70);
        journey3.setStarttime("10-03-14");

        Journey journey4 = new Journey();
        journey4.setStartzone(7);
        journey4.setNumberofzones(8);
        journey4.setPrice(80);
        journey4.setStarttime("10-08-14");
        
        Journey journey5 = new Journey();
        journey5.setStartzone(6);
        journey5.setNumberofzones(2);
        journey5.setPrice(20);
        journey5.setStarttime("10-07-14");

        Journey journey6 = new Journey();
        journey6.setStartzone(8);
        journey6.setNumberofzones(3);
        journey6.setPrice(30);
        journey6.setStarttime("10-02-14");
        
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);
        test.add(journey);
        test.add(journey2);
        test.add(journey3);
        test.add(journey4);
        test.add(journey5);
        test.add(journey6);

        if (index<0){index =0;}
       
        int index2=index+5;
        // display the remainding
       if (index2>test.size()&index<test.size()){
        index2=test.size();
       }

       // redisplay the final view
       if (index>(test.size()-1)){
           index=((test.size()-1)/5)*5; // integer divition
          index2=test.size();
       }

       return new ArrayList(test.subList(index, index2));       
    }

    @Override
    public Customer getCustomerDetails(String customerNumber) {

        Customer customer = new Customer();
        customer.setCustomerNumber("1234");
        customer.setFirstname("Hans");
        customer.setLastname("Jensen");
        customer.setEmail("hans@jensen.dk");
        customer.totalRecords=24;
        
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
    
}