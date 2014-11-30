/**
 * // RMIServer: -- Maintain RMI registry -- Supply Manager-RMI-Implementation
 * classes in RMI registry String createJourneyManagerRMI(objName)
 * (bind to registry) ; String is obj name in registry String
 * createWebsiteMangerRMI(objName) // (bind to registry) ; String is obj name in
 * registry void deleteJourneyManagerRMI(objName) // (unbind from registry) void
 * deleteWebsiteMangerRMI(objName) // (unbind from registry)
 */


import JourneyManager.JourneyManagerRMISkelImpl;
import Website.WebsiteManagerRMISkelImpl;
import RMI.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer{

    private static final String HOST = "goonhilly6.eitlab.ihk-edu.dk"; 
    // private static final String HOST = "thelizard6.eitlab.ihk-edu.dk"; 
    // private static final String HOST = "localhost";
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

       
          if (System.getProperty("java.rmi.server.codebase") == null)
    {
        System.setProperty("java.rmi.server.codebase", "http://goonhilly6.eitlab.ihk-edu.dk/~jonas3e14/RMIServer.jar");
    }
        
//         if (System.getProperty("java.security.policy") == null)
//    {
//        System.setProperty("java.security.policy", "src/Server/Policy/server.policy");
//    }
//    if (System.getProperty("java.rmi.server.codebase") == null)
//    {
//        System.setProperty("java.rmi.server.codebase", "file:/D:/.../build/classes");
//    }
//    if (System.getSecurityManager() == null)
//    { 
//        System.setSecurityManager(new RMISecurityManager());
//    }
//    LocateRegistry.createRegistry(9292);
//    Naming.rebind("rmi://localhost:9292/StrategoServer", stratego);

  
        
        try {
            System.out.println("DataServer: Instantiating server objects...");        
            
            JourneyManagerRMISkelImpl journeyManager = new JourneyManagerRMISkelImpl();
            IntRouteplannerJourneyManagerRMISkel routeplannerJourneyManager = new RouteplannerJourneyManagerRMISkel();
            WebsiteManagerRMISkelImpl websiteManager = new WebsiteManagerRMISkelImpl();
            
            System.out.println("DataServer: Connecting server objects to registry...");    
            
            Registry registry = null;
            try {
                registry = LocateRegistry.createRegistry(port);
            } catch(RemoteException ex) {
                System.out.println("Registry already exists.");
                System.out.println("Searching existing registry...");  //this part fails!!
                
                              
                 final Registry registryA;
        try {
            registryA = LocateRegistry.getRegistry(host, port);        
       
         final String[] boundNames = registryA.list();
         System.out.println(
            "Names bound to RMI registry at host " + host + " and port " + port + ":");
         for (final String name : boundNames)
         {
            System.out.println("\t" + name);
         }
         
        }
         catch (RemoteException exx) {exx.printStackTrace();
        }
                
    
                registry = LocateRegistry.getRegistry(host, port);
            }            
           
            registry.rebind("journeyManager", journeyManager);
            registry.rebind("routeplannerJourneyManager", routeplannerJourneyManager);
            registry.rebind("websiteManager", websiteManager);
            
           
            System.out.println("DataServer: Waiting for client messages...");
        }
        catch (Exception e) {
            System.out.println("=== DataServer Error ===");
            System.out.println("DataServer: Error description: " + e);
            System.out.println("---DataServer: StackTrace ---: ");
            e.printStackTrace();
            System.out.println("=== DataServer Error (end) ===");
        }

    }

}
