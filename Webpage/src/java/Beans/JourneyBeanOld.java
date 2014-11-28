package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Qess
 */
public class JourneyBeanOld implements Serializable {
    // used to itterate through the journeys in the journey array list.
    private int i=0;
        // index used to track what section of the journey history to be retrived.
    private int index;
    private String customerNumber;
    private WebsiteManagerRMISkelImpl skel;
    private ArrayList<Journey> journeyList;

    
    public int getDisplayFrom(){
        return index+1;
    }
    public int getDisplayTo(){

        return index+getListSize();
    }
    
    public JourneyBeanOld() {
            this.skel = new WebsiteManagerRMISkelImpl();
    }
    
    
    public ArrayList<Journey> getJourneyList(){
    return journeyList;
    }
    

    public void setIndex(int index){
    this.index = index;
    journeyList = skel.getJourneyHistory(customerNumber, index);
    }
    
    public int getIndex(){
    return index;
    }
    
    public int getNextIndex(){
        if(journeyList.size() == 5){
            return index+5;
        }else{
            return index;
        }
    }
    
    public int getprevIndex(){
        if (index>5){
        return index-5;
        }
        else return 0;
    }
    
    public void setNext(String nexti){
        i++;
    }
    
    public int getI(){
        return i;
     }
    
    public int getListSize(){
    return journeyList.size();
    }
    
    public int getNextStartzone() {
        return journeyList.get(i).getStartzone();
    }
        
    public void setCustomerNumber(String customerNumber){
    this.customerNumber=customerNumber;
    }

    public String getCustomerNumber(){
    return customerNumber;
    }

    public int getNextNumberofzones() {
        return journeyList.get(i).getNumberofzones();
    }

    public int getNextPrice() {
        return journeyList.get(i).getPrice();
    }

    public String getNextStarttime() {
        return journeyList.get(i).getStarttime();
    }
}
