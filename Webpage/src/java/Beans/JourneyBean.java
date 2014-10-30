/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Qess
 */
public class JourneyBean implements Serializable {
    private int i;
   // private int customerNumber;
    private WebsiteManagerRMISkel skel;
    private List<Journey> journeyList;


    
    public JourneyBean() {
            this.skel = new WebsiteManagerRMISkel();
    }
    
    
    
    public int getNextI(){
        i++;
        return i;
    }
    
    public int getNextStartzone() {
        return journeyList.get(i).getStartzone();
    }
        
    public void setCustomerNumber(int customerNumber){
  //  this.customerNumber=customerNumber;
    journeyList = skel.getJourneyHistory(customerNumber);
    }


    public int getNextNumberofzones() {
        return journeyList.get(i).getNumberofzones();
    }

    public int getNextPrice() {
        return journeyList.get(i).getPrice();
    }

    public GregorianCalendar getNextStarttime() {
        return journeyList.get(i).getStarttime();
    }
}
