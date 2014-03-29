/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

import model.Terminal;
import model.Customer;
import model.Deposit;
import model.Billing;

/**
 *
 * @author ibr
 */
public interface DatabaseDAO {
    
    
    public int updateQuery(String updateQuery,ArrayList<String> parameters);
    public Billing getBilling(String updateQuery,ArrayList<String> parameters);
    public Customer getCustomer(String getQuery,ArrayList<String> parameters);
    public Deposit getDeposit(String getQuery,ArrayList<String> parameters);
    public Terminal getTerminal(String getQuery,ArrayList<String> parameters);

    

//    public Terminal findByISBN(String isbn);
//    public int addAuthor(Author author);
//    public Author findAuthorByName(String lastName, String firstName);
//    public ArrayList<Author> findAllAuthors();
//    public ArrayList<Terminal> findBooksByAuthorName(String lastName, String firstName);
//    public ArrayList<Terminal> findBooksByAuthor(Author author);
}
