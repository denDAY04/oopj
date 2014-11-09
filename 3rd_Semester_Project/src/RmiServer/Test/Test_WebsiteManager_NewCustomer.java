package RmiServer.Test;

import ModelClasses.Customer;
import RmiServer.Skeleton.WebsiteManagerRMISkel;
import java.rmi.RemoteException;

public class Test_WebsiteManager_NewCustomer {

    Customer citizenKane;   
    WebsiteManagerRMISkel websiteManagerRMISkel;
    boolean status = false;
    
    public static void main(String[] args) throws RemoteException {

        
        Test_WebsiteManager_NewCustomer WMN = new Test_WebsiteManager_NewCustomer();        
        WMN.Test_WebsiteManager_NewCustomer();
                
           }  

    public void Test_WebsiteManager_NewCustomer() throws RemoteException {
        System.err.println("break a");
        this.citizenKane = new Customer();   //create test customer object
        citizenKane.setFirstname("Citizen");
        citizenKane.setLastname("Kane");
        citizenKane.setEmail("Kane@Citizen.com");
        citizenKane.setPassword("LetMeIn");        
                
        this.websiteManagerRMISkel = new WebsiteManagerRMISkel();
        
        
        status = websiteManagerRMISkel.createCustomer(citizenKane);
        System.err.println("break b");
           
        System.out.println(status);
       
        
        
        
    }
        
        
        
        
        
        
  
    
}
