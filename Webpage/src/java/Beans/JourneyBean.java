package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Website.WebsiteManagerRMISkel;
import ModelClasses.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


/**
 *
 * @author Qess
 */
public class JourneyBean implements Serializable {
    // used to itterate through the journeys in the journey array list.
    private int i=0;
        // index used to track what section of the journey history to be retrived.
    private int index;
    private int customerNumber;
    private WebsiteManagerRMISkel skel;
    private ArrayList<Journey> journeyList;

    
    public int getDisplayFrom(){
        return index+1;
    }
    public int getDisplayTo(){

        return index+getListSize();
    }
    
    public JourneyBean() throws Exception{
        
        String host = "goonhilly6.eitlab.ihk-edu.dk";        
        int port = 20423;               
        System.out.println("Client: Starting...");
        System.out.println("Using registry at: " + host + " port " + port);

        
        final Registry registryA;
        try {registryA = LocateRegistry.getRegistry(host, port);        
       
         final String[] boundNames = registryA.list();
         System.out.println(
            "Names bound to RMI registry at host " + host + " and port " + port + ":");
         for (final String name : boundNames)
         {System.out.println("\t" + name);}        
        }
         catch (RemoteException ex) {
             System.err.println("Setup graph Remote ex: " +ex);
        }
   
            Registry registry = LocateRegistry.getRegistry(host, port);     
            this.skel = (WebsiteManagerRMISkel)registry.lookup("websiteManager");
    }
    
    
    public ArrayList<Journey> getJourneyList(){
    return journeyList;
    }
    

    public void setIndex(int index) throws RemoteException{
    this.index = index;
    journeyList = skel.getJourneyHistory(Integer.toString(customerNumber), index);
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
        
    public void setCustomerNumber(int customerNumber){
    this.customerNumber=customerNumber;
    }

    public int getCustomerNumber(){
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
