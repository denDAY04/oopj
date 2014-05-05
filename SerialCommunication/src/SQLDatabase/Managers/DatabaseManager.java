/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SQLDatabase.ModelClasses.Terminal;
import SQLDatabase.ModelClasses.Customer;
import SQLDatabase.ModelClasses.Deposit;
import SQLDatabase.ModelClasses.Billing;

/**
 *
 * @author ibr
 */
public class DatabaseManager {// implements DatabaseInterface {   // any update or insert in to statement
    
/**
 * Update the information of existing data on the database. 
 * Use also this method for addding new data objects to the database.
 * 
 * @param updateQuery SQL command. See SQLLibrary. 
 * @param parameters Data to be updated or added in the database.
 * 
 * @return The index number of the row that was edited or added.
 */
 public int updateQuery(String updateQuery,ArrayList<Object> parameters) {
        int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
            for (int i=0; i<parameters.size();++i){
                Class indexedClass = parameters.get(i).getClass();
                if(indexedClass == String.class) {
                    System.err.println("DatabaseManager, updateQuery: Found String.");
                    preparedStatement.setString(i+1, (String) parameters.get(i));
                } else if (indexedClass == Integer.class) {
                    System.err.println("DatabaseManager, updateQuery: Found Integer.");
                    preparedStatement.setInt(i+1, (Integer) parameters.get(i));
                } else {
                    System.err.println("Error in DatabaseManager, updateQuery. No suitable class found!");
                    System.err.println("Found class: " + indexedClass.toString());
                    System.exit(-1);
                }
                
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
// possible to join the below 4 mothodcalls using polymorphy of a parent class, 
// but would require analasys of metadata to determine type of data (which constructor to call)

//@Override
  public ArrayList<Customer> getCustomers(String getQuery,ArrayList<String> parameters) {
        Connection con = null;
        ArrayList<Customer> customerList = new ArrayList();
        try {
            System.err.println("DatabaseManager getCustomers 1");
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            System.err.println("DatabaseManager getCustomers 2");                
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            System.err.println("DatabaseManager getCustomers 3");
            while (resultSet.next()) {
                 System.err.println("DatabaseManager getCustomers 4");
                 customerList.add(createCustomer(resultSet));
            }
            System.err.println("DatabaseManager getCustomers 5");

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
        return customerList;
    }

//@Override  
  public ArrayList<Terminal> getTerminals(String getQuery,ArrayList<String> parameters) {
        ArrayList<Terminal> terminalList = new ArrayList();
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 System.err.println("added terminal to resultset");
                terminalList.add(createTerminal(resultSet));
            }
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
        return terminalList;
    }

//@Override  // needs to be able to return an arraylist of Deposits
  public ArrayList<Deposit> getDeposits(String getQuery,ArrayList<String> parameters) {
        ArrayList<Deposit> depositList = new ArrayList();
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                depositList.add(createDeposit(resultSet));
            }
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
        return depositList;
    }

//@Override  // 
            // Method for returning a billing on click, with refrences.
    public Billing getDetailedBilling(String getQuery,ArrayList<String> parameters) {
        Billing billing = null;
        Customer customer = null;
        Terminal terminal = null;
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                customer = createCustomer(resultSet);
                terminal = createTerminal(resultSet);
                billing = createBilling(resultSet,customer,terminal);
            }
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
        return billing;
    }

//@Override  // needs to be able to return an arraylist of Deposits
            // a billing could have a customer object and terminal object, but only neccesary for on click
    public ArrayList<Billing> getBillings(String getQuery,ArrayList<String> parameters) {
        ArrayList<Billing> billingList = new ArrayList();
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = ConnectionManager.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {  // while add to arraylist
                billingList.add(createBilling(resultSet));
            }
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
        return billingList; 
    }

    
        private Customer createCustomer(ResultSet resultSet) throws SQLException {
        String customerNumb = resultSet.getString("CustomerNumb");
        String pin = resultSet.getString("Pin");
        String password = resultSet.getString("Password");
        String cardNumb = resultSet.getString("CardNumb");
        String firstName = resultSet.getString("FirstName");
        String lastName = resultSet.getString("LastName");
        String road = resultSet.getString("Road");        
        String zipCode = resultSet.getString("ZipCode");
        String email = resultSet.getString("Email");
        String phoneNumb = resultSet.getString("PhoneNumb");
        int balance = Integer.parseInt(resultSet.getString("Balance")); // parse to double
        String accountStatus = resultSet.getString("AccountStatus");        
        String useStatus = resultSet.getString("UseStatus");        
        return new Customer(customerNumb, pin, password, cardNumb, firstName,lastName,road,zipCode,email,phoneNumb,balance,accountStatus, useStatus);
        }
        
        
    
        private Terminal createTerminal(ResultSet resultSet) throws SQLException {
        String hardwareNumb = resultSet.getString("hardwareNumb");
        String road = resultSet.getString("road");
        String zipCode = resultSet.getString("zipCode");
        String ipAddress = resultSet.getString("ipAddress");
        String installStatus = resultSet.getString("installStatus");
        String chargingStatus = resultSet.getString("chargingStatus");   
        String OfflineSince = resultSet.getString("OfflineSince");
        return new Terminal(hardwareNumb,road, zipCode, ipAddress, installStatus,chargingStatus,OfflineSince);
        }

        private Deposit createDeposit(ResultSet resultSet) throws SQLException {
        String depositsNumb = resultSet.getString("DepositsNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String depositsDate = resultSet.getString("DepositsDate");
        int depositAmount = Integer.parseInt(resultSet.getString("DepositAmount"));          // parse to double
        int newBalanceDeposit = Integer.parseInt(resultSet.getString("NewBalanceDeposit"));  // parse to double
        String externalRefNumb = resultSet.getString("ExternalRefNumb");
        String last4CardNumb = resultSet.getString("Last4CardNumb");
        return new Deposit(depositsNumb,customerNumb, depositsDate, depositAmount, newBalanceDeposit,externalRefNumb,last4CardNumb);
        }
    
        private Billing createBilling(ResultSet resultSet) throws SQLException {
        String transactionNumb = resultSet.getString("TransactionNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String hardwareNumb = resultSet.getString("HardwareNumb");
        String startCharge =  resultSet.getString("StartCharge"); 
        String endCharge =  resultSet.getString("EndCharge");  
        String recieved = resultSet.getString("Recieved");
        int billingAmount = Integer.parseInt(resultSet.getString("BillingAmount")); // parse to double
        int billingRate = Integer.parseInt(resultSet.getString("BillingRate"));    // parse to double
        int billingKWH = Integer.parseInt(resultSet.getString("BillingKWH"));     // parse to double
        int newBalanceBilling = Integer.parseInt(resultSet.getString("NewBalanceBilling")); // parse to double
        return new Billing(transactionNumb,customerNumb, hardwareNumb, startCharge, endCharge,recieved,billingAmount, billingRate, billingKWH,newBalanceBilling);
    }    
        
        // Create billing with refrence to a terminal and costomer object, to display all information.
        private Billing createBilling(ResultSet resultSet,Customer costumer,Terminal terminal) throws SQLException {
        String transactionNumb = resultSet.getString("TransactionNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String hardwareNumb = resultSet.getString("HardwareNumb");
        String startCharge =  resultSet.getString("StartCharge"); 
        String endCharge =  resultSet.getString("EndCharge");  
        String recieved = resultSet.getString("Recieved");
        int billingAmount = Integer.parseInt(resultSet.getString("BillingAmount")); // parse to double
        int billingRate = Integer.parseInt(resultSet.getString("BillingRate"));    // parse to double
        int billingKWH = Integer.parseInt(resultSet.getString("BillingKWH"));     // parse to double
        int newBalanceBilling = Integer.parseInt(resultSet.getString("NewBalanceBilling")); // parse to double
        return new Billing(transactionNumb,customerNumb, hardwareNumb, startCharge, endCharge,recieved,billingAmount, billingRate, billingKWH,newBalanceBilling);
    }    
        
        public void test(){
        System.out.println("test!");
        }
        
        
}

