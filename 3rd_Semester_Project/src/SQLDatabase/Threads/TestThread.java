package SQLDatabase.Threads;

import ModelClasses.Customer;
import RmiServer.Skeleton.*;
import java.rmi.RemoteException;


public class TestThread {

    Customer citizenKane;
    WebsiteManagerRMISkel websiteManagerRMISkel;
    
    boolean status = false;
    
    public static void main(String[] args) throws RemoteException{         
        TestThread WMN = new TestThread();        
        WMN.TestThread();                
           }  

    public void TestThread() throws RemoteException{
        System.err.println("a");
        this.citizenKane = new Customer();   //create test customer object
        citizenKane.setFirstname("Citizen");
        citizenKane.setLastname("Kane");
        citizenKane.setEmail("Kane@Citizen.com");
        citizenKane.setPassword("LetMeIn");        
                
        this.websiteManagerRMISkel = new WebsiteManagerRMISkel();       
        
        status = websiteManagerRMISkel.createCustomer(citizenKane);
        System.err.println("b");
           
        System.out.println(status);
       
        
        
        
    }
        
        
        
        
        
        
  
    
}
