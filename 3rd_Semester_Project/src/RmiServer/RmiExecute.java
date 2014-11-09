package RmiServer;

//Client.
import RmiServer.Skeleton.*;
import java.rmi.*;
import java.util.ArrayList;
import java.io.*;

public class RmiExecute
{
//   private static final String HOST = "goonhilly6.eitlab.ihk-edu.dk";
   private static final String HOST = "localhost";

   public static void main(String[] args)
   {
       
       WebsiteManagerRMISkel websiteManagerRMISkel;
      try
      {
         // Obtain a reference to the object from the registry 
         // and typecast it into the appropriate type...
                    
          websiteManagerRMISkel = (WebsiteManagerRMISkel)Naming.lookup("rmi://" + HOST + "/WebsiteManager");
          
          
          
          
          
          
          
          
          
          
          
          
          

//         Bank1 temp = (Bank1)Naming.lookup(
//                         "rmi://" + HOST + "/Accounts");
//
//         ArrayList<Account> acctDetails =
//                                temp.getBankAccounts();
//
//         //Simply display all acct details...
//         for (int i=0; i<acctDetails.size(); i++)
//         {
//            //Retrieve an Account object from the
//            //ArrayList...
//            Account acct = acctDetails.get(i);
//
//            //Now invoke methods of Account object
//            //to display its details...
//            System.out.println("\nAccount number: "
//                                   + acct.getAcctNum());
//            System.out.println("Name: "
//                                    + acct.getName());
//            System.out.println("Balance: "
//                                   + acct.getBalance());
//			acct.deposit(100.0);
//			System.out.println("New Balance: "
//                                   + acct.getBalance());
                        
//               }
          
          
          
          
// below for testing how long TCP connection is kept open
//		 System.out.println("return to exit ...");
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		 br.readLine();
      }
      catch(ConnectException conEx)
      {System.out.println("Unable to connect to server!");  System.exit(1);}
      catch(Exception ex) {ex.printStackTrace();   System.exit(1);}
   }
}