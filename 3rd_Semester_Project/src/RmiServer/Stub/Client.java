package RmiServer.Stub;

import RmiServer.Interface.IntClient;
import ModelClasses.*;
import RmiServer.Skeleton.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.ArrayList;

public class Client implements IntClient{

    public static void main(String[] args) {
//        String host = "localhost";        
//        int port = 1099;
        
        String host = "goonhilly6.eitlab.ihk-edu.dk";        
        int port = 20421;
        
         
        if (args.length > 0) {
            host = args[0];
        }
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }
        System.out.println("Client: Starting...");
        System.out.println("Using registry at: " + host + " port " + port);
        if (System.getSecurityManager() == null) {System.setSecurityManager(new RMISecurityManager());}
        
        
        
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            
            
          //  JourneyManagerRMISkel jMgr = (JourneyManagerRMISkel) registry.lookup("journeyManager");
          //  RouteplannerJourneyManagerRMISkel rpjMgr = (RouteplannerJourneyManagerRMISkel)registry.lookup("routeplannerJourneyManager");
            
           
             WebsiteManagerRMISkel webM =  (WebsiteManagerRMISkel) registry.lookup("websiteManager");
             
             

        Customer citizenKane = new Customer(); 
        citizenKane.setFirstname("RMI");
        citizenKane.setLastname("Kane");
        citizenKane.setEmail("Kane@Citizen.com");
        citizenKane.setPassword("LetMeIn");      
        
        webM.createCustomer(citizenKane);
        
        
        
        
                
//        WebsiteManagerRMISkel websiteManagerRMISkel = new WebsiteManagerRMISkel();
//        
//        
//        Boolean status = websiteManagerRMISkel.createCustomer(citizenKane);
            
            
            
            
//            Data c1 = (Data) registry.lookup("jack");
//            Data c2 = (Data) registry.lookup("jill");
//            c1.putData(c2.getData() + 2.53);
//            c2.putData(c1.getData() * 3.57);
//            System.out.println(c1.getName() + ": " + c1.getData());
//            System.out.println(c2.getName() + ": " + c2.getData());
            
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Client: Using host: '" + host + "' port " + port);
            System.out.println("Error: " + e);
        }
        System.out.println("Client: Terminating...");
        System.exit(0);
    }

    
    

}
