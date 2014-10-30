/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public interface WebsiteManagerRMISkelInterface {    
    
ArrayList<Journey> getJourneyHistory(String customerNumber, int index);        // (precision?) 3 / 5 / 10
Customer getCustomerDetails(String customerNumber);
void setCustomerDetails(Customer customer);
boolean createCustomer(Customer customer);
boolean logOn(String email, String password);
boolean logOff();
}
