/**
 * // RMIServer: -- Maintain RMI registry -- Supply Manager-RMI-Implementation
 * classes in RMI registry String createJourneyManagerRMI(objName) // (bind to
 * registry) ; String is obj name in registry String
 * createWebsiteMangerRMI(objName) // (bind to registry) ; String is obj name in
 * registry void deleteJourneyManagerRMI(objName) // (unbind from registry) void
 * deleteWebsiteMangerRMI(objName) // (unbind from registry)
 */
package RmiServer;

import RmiServer.Interface.IntRMIServer;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

import RmiServer.Skeleton.*;
import ModelClasses.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMIServer implements IntRMIServer {

    // private static final String HOST = "goonhilly6.eitlab.ihk-edu.dk"; 
    // private static final String HOST = "thelizard6.eitlab.ihk-edu.dk"; 
    private static final String HOST = "localhost";
    private static final int PORT = 20421;
    public static void main(String[] args) {

        String host = HOST;
        int port = PORT;
        
        if (args.length > 0) {
            host = args[0];
        }
        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }
        System.out.println();
        System.out.println("Using registry on " + host + " port " + port);
        System.out.println();
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new RMISecurityManager());
//        }
        try {
            System.out.println("DataServer: Instantiating server objects...");
           // DataImpl p1 = new DataImpl("Jacks data");
            WebsiteManagerRMISkel websiteManager = new WebsiteManagerRMISkel();
            JourneyManagerRMISkel journeyManager = new JourneyManagerRMISkel();
            RouteplannerJourneyManagerRMISkel routeplannerJourneyManager = new RouteplannerJourneyManagerRMISkel();
            
            
            System.out.println("DataServer: Connecting server objects to registry...");
            Registry registry = LocateRegistry.getRegistry(host, port);
            //registry.rebind("jack", p1);
            registry.rebind("websiteManager", websiteManager);
            registry.rebind("journeyManager", journeyManager);
            registry.rebind("routeplannerJourneyManager", routeplannerJourneyManager);
            
//            registry.rebind("journeyManager", journeyManager); 
//            registry.rebind("routeplannerJourneyManager ", routeplannerJourneyManager );
           
            System.out.println("DataServer: Waiting for client messages...");
        } catch (Exception e) {
            System.out.println("=== DataServer Error ===");
            System.out.println("DataServer: Error description: " + e);
            System.out.println("---DataServer: StackTrace ---: ");
            e.printStackTrace();
            System.out.println("=== DataServer Error (end) ===");
        }

    }

//    JourneyManagerRMISkel journeyManager = new JourneyManagerRMISkel();
//    RouteplannerJourneyManagerRMISkel routeplannerJourneyManager = new RouteplannerJourneyManagerRMISkel();
//    WebsiteManagerRMISkel websiteManager = new WebsiteManagerRMISkel();
//    @Override
//    public boolean createCustomer(Customer obj) {
//        try {
//            WebsiteManagerRMISkel websiteManager = new WebsiteManagerRMISkel();
//            boolean status = websiteManager.createCustomer(obj);
//
//            return status;
//
//        } catch (RemoteException ex) {System.err.println("RemoteException");}
//        return false;
//    }
//    
//     @Override
//     public void setCustomerDetails(Customer obj) {
//         try {WebsiteManagerRMISkel websiteManager = new WebsiteManagerRMISkel();
//            boolean status = websiteManager.createCustomer(obj);           
//
//        } catch (RemoteException ex) {System.err.println("RemoteException");}
//        
//    }
//    
//    @Override
//    public Customer getCustomerDetails(String customerNumber) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Customer logOn(String email, String password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public ArrayList<Journey> getJourneyHistory(String customerNumber, int index) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
////Create an initialised array of four Account
//      //objects...
//      Account[] account =
//       {new AccountImpl(111111,"Smith","Fred James",112.58),
//        new AccountImpl(222222,"Jones","Sally",507.85),
//        new AccountImpl(234567,"White","Mary Jane",2345.00),
//        new AccountImpl(666666,"Satan","Beelzebub",666.00)};
//
//      ArrayList<Account> acctDetails = new ArrayList<Account>();
//
//      //Insert the Account objects into the ArrayList...
//      for (int i=0; i<account.length; i++)
//         acctDetails.add(account[i]);
//
//      //Create an implementation object, passing the
//      //above ArrayList to the constructor...
//      Bank1Impl temp = new Bank1Impl(acctDetails);
//
//      //Save the object's name in a String...
//      String rmiObjectName = "rmi://" + HOST + "/Accounts"; 
//      
//      //Bind the object's name to its reference...
//      Naming.rebind(rmiObjectName,temp);  
//      System.out.println("Binding complete...\n");
//	}
//    public String customer(Customer obj) throws MalformedURLException {
//        try {
//            Customer customer = new Customer(obj);
//            String rmiObjectName = "rmi://" + HOST + "/Customer";
//            Naming.rebind(rmiObjectName, customer);
//            System.out.println("Binding complete...\n");
//            return rmiObjectName;
//        } catch (RemoteException ex) {
//            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "Error";
//    }
//    
//    
//     public String newCustomer(Customer obj) throws MalformedURLException {
//        try {
//            Customer customer = new Customer(obj);
//            String rmiObjectName = "rmi://" + HOST + "/Customer";
//            customer.create();
//            Naming.rebind(rmiObjectName, customer);
//            System.out.println("Binding complete...\n");
//            return rmiObjectName;
//        } catch (RemoteException ex) {
//            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "Error";
//    }
}
