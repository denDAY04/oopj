/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SQLDatabase.Main;

//import SQLDatabase.Managers.DatabaseInterface;
import SQLDatabase.Managers.DatabaseManager;
import java.util.ArrayList;
//import model.Author;
import SQLDatabase.ModelClasses.Terminal;
import SQLDatabase.ModelClasses.Billing;
import SQLDatabase.ModelClasses.Customer;
import SQLDatabase.ModelClasses.Deposit;
import SQLDatabase.Library.SQLLibrary;

/**
 *
 * @author hbe
 */
//public class TestDatabase {
//    public static void main(String[] args) {
//        ArrayList<Terminal> terminalList;
//        DatabaseInterface databaseDAO = new DatabaseManager();
//
//        System.out.println("---");
//        System.out.println("Modify terminal:");
//        int row;
//        ArrayList<String> parameters = new ArrayList();
//        parameters.add("seethis");        // status
//        parameters.add("2");              // hardwareID
//        row = databaseDAO.updateQuery(SQLLibrary.ADMIN_CHANGE_TERMINAL_INSTALLSTATUS,parameters);
//        System.out.println("update done");
//
//       //System.out.println("ISBN: " + terminal1.getIsbn() +
//       //         ", Title: " + terminal1.getTitle() +
//        //        ", Ed.: " + terminal1.getEditionNumber() +
//         //       ", year: " + terminal1.getCopyright());
//        
//
////        System.out.println("---");
////        System.out.println("Add Shakespeare to database, and look him up again");
////        //Add an author by use of the addAuthor() method in the databaseDAO object:
////        Author shakespeareWilliam = new Author("Shakespeare", "William");
////        databaseDAO.addAuthor(shakespeareWilliam);
////
////        //Look up author by the findAuthorByName() method in the databaseDAO object:
////        Author author = databaseDAO.findAuthorByName("Shakespeare", "William");
////        //Print the authorID, first name and last name on the display:
////        System.out.println("Author: " + author.getAuthorID() + " " + author.getFirstName() + " " + author.getLastName());
////        
////        System.out.println("---");
////        System.out.println("Lookup all books by Paul Deitel:");
////        //Find all authors written by Paul Deitel
////        terminalList = databaseDAO.findBooksByAuthorName("Deitel", "Paul");
////        System.out.println("Found " + terminalList.size() + " books");
////        for (int i = 0; i < terminalList.size(); i++) {
////            terminal1 = terminalList.get(i);
////            System.out.printf("%s %s %d %s\n",
////                    terminal1.getIsbn(), terminal1.getTitle(),
////                    terminal1.getEditionNumber(), terminal1.getCopyright());
////        }
////        
////        System.out.println("---");
////        System.out.println("Lookup all authors and find all books they have written:");
////        ArrayList<Author> authorList = databaseDAO.findAllAuthors();
////        
////        for (Author a : authorList) {
////            System.out.println("---");
////            System.out.println("Books by: " + a.getFirstName() + " " + a.getLastName()+":");
////            ArrayList<Terminal> books = databaseDAO.findBooksByAuthor(a);
////            
////            for (Terminal b : books) {
////                System.out.println(b.getTitle());
////            }
////        }
//    }
//}