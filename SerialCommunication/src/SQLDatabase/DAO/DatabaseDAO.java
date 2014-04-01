/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.DAO;

import java.util.ArrayList;

import SQLDatabase.ModelClasses.Terminal;
import SQLDatabase.ModelClasses.Customer;
import SQLDatabase.ModelClasses.Deposit;
import SQLDatabase.ModelClasses.Billing;

/**
 *
 * @author ibr
 */
public interface DatabaseDAO {
    
    
    public int updateQuery(String updateQuery,ArrayList<String> parameters);
    public Billing getDetailedBilling(String updateQuery,ArrayList<String> parameters);
    public ArrayList<Billing> getBillings(String getQuery,ArrayList<String> parameters);
    public ArrayList<Customer> getCustomers(String getQuery,ArrayList<String> parameters);
    public ArrayList<Deposit> getDeposits(String getQuery,ArrayList<String> parameters);
    public ArrayList<Terminal> getTerminals(String getQuery,ArrayList<String> parameters);

    

//    public Terminal findByISBN(String isbn);
//    public int addAuthor(Author author);
//    public Author findAuthorByName(String lastName, String firstName);
//    public ArrayList<Author> findAllAuthors();
//    public ArrayList<Terminal> findBooksByAuthorName(String lastName, String firstName);
//    public ArrayList<Terminal> findBooksByAuthor(Author author);
}
