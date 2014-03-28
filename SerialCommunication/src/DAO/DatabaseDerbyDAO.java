/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import model.Author;
import model.Terminal;
import model.Customer;
import model.Deposit;
import model.Billing;

/**
 *
 * @author ibr
 */
public class DatabaseDerbyDAO implements DatabaseDAO {
    
@Override
    public int updateQuery(String updateQuery,ArrayList<String> parameters) {
        int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            rowCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return rowCount;
    }

//    public Author findAuthorByName(String lastName, String firstName) {
//        String query = "select \"authorID\", \"lastName\", \"firstName\" "
//                + "from \"authors\" "
//                + "where \"lastName\" = ? and \"firstName\" = ?";
//
//        Author author = null;
//        Connection con = null;
//        try {
//            con = DerbyDAOFactory.createConnection();
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1, lastName);
//            preparedStatement.setString(2, firstName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                author = createAuthor(resultSet);
//            }
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        return author;
//    }
//    
//    public ArrayList<Author> findAllAuthors() {
//        String query = "select \"authorID\", \"lastName\", \"firstName\" "
//                + "from \"authors\"";
//
//        ArrayList<Author> authorList = new ArrayList<Author>();
//        Connection con = null;
//        try {
//            con = DerbyDAOFactory.createConnection();
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Author author = createAuthor(resultSet);
//                System.out.println("#### Fandt author " + author.getFirstName() + " " + author.getLastName());
//                authorList.add(author);
//            }
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        return authorList;
//    }
//
//    public ArrayList<Terminal> findBooksByAuthorName(String lastName, String firstName) {
//        String query = "select \"titles\".\"isbn\", \"title\",  "
//                + "\"editionNumber\", \"copyright\""
//                + "from \"titles\" "
//                + "inner join \"authorISBN\" ON "
//                + "\"titles\".\"isbn\" = \"authorISBN\".\"isbn\" "
//                + "inner join \"authors\" ON "
//                + "\"authors\".\"authorID\" = \"authorISBN\".\"authorID\" "
//                + "where \"lastName\" = ? AND \"firstName\" = ?";
//
//        ArrayList<Terminal> bookList = new ArrayList<Terminal>();
//        Connection con = null;
//        try {
//            con = DerbyDAOFactory.createConnection();
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1, lastName);
//            preparedStatement.setString(2, firstName);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                Terminal book = createBook(resultSet);
//                bookList.add(book);
//            }
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        return bookList;
//    }
//
//    public ArrayList<Terminal> findBooksByAuthor(Author author) {
//        return findBooksByAuthorName(author.getLastName(), author.getFirstName());
//    }
//    
//    public Terminal findByISBN(String isbn) {
//        String titlesQuery = "select distinct \"isbn\", \"title\",  "
//                + "\"editionNumber\", \"copyright\""
//                + "from \"titles\" "
//                + "where \"isbn\" = ?";
//        Terminal book = null;
//        Connection con = null;
//        try {
//            con = DerbyDAOFactory.createConnection();
//            PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);
//            preparedStatement.setString(1, isbn);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                book = createBook(resultSet);
//            }
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//        return book;
//    }

    
        private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String customerNumb = resultSet.getString("CustomerNumb");
        //String pin = resultSet.getString("Pin");
        String password = resultSet.getString("Password");
        //String cardNumb = resultSet.getString("CardNumb");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String road = resultSet.getString("Road");        
        String zipCode = resultSet.getString("ZipCode");
        String email = resultSet.getString("Email");
        String phoneNumb = resultSet.getString("PhoneNumb");
        String balance = resultSet.getString("Balance"); 
        String accountStatus = resultSet.getString("AccountStatus");        
        String useStatus = resultSet.getString("UseStatus");        
        return new Customer(customerNumb, password, firstName,lastName,road,zipCode,email,phoneNumb,balance,accountStatus);
    }
    
    private Terminal createTerminal(ResultSet resultSet) throws SQLException {
        String road = resultSet.getString("road");
        String zipCode = resultSet.getString("zipCode");
        String ipAddress = resultSet.getString("ipAddress");
        String installStatus = resultSet.getString("installStatus");
        String chargingStatus = resultSet.getString("chargingStatus");        
        return new Terminal(road, zipCode, ipAddress, installStatus,chargingStatus);
    }

//    private Author createAuthor(ResultSet resultSet) throws SQLException {
//        String firstName = resultSet.getString("firstName");
//        String lastName = resultSet.getString("lastName");
//        int authorID = resultSet.getInt("authorID");
//        return new Author(authorID, lastName, firstName);
//    }
}

