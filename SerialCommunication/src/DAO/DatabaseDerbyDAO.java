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
import model.Terminal;
import model.Customer;
import model.Deposit;
import model.Billing;

/**
 *
 * @author ibr
 */
public class DatabaseDerbyDAO implements DatabaseDAO {   // any update or insert in to statement
    
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

@Override
    public Customer getCustomer(String getQuery,ArrayList<String> parameters) {
        Customer customer = null;
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                customer = createCustomer(resultSet);
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
        return customer;
    }

@Override
    public Terminal getTerminal(String getQuery,ArrayList<String> parameters) {
        Terminal terminal = null;
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                terminal = createTerminal(resultSet);
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
        return terminal;
    }

@Override
    public Deposit getDeposit(String getQuery,ArrayList<String> parameters) {
        Deposit deposit = null;
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                deposit = createDeposit(resultSet);
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
        return deposit;
    }

@Override
    public Billing getBilling(String getQuery,ArrayList<String> parameters) {
        Billing billing = null;
       // int rowCount = 0; //Return value from executeUpdate()
        Connection con = null;
        try {
            con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            for (int i=0; i<parameters.size();++i){
            preparedStatement.setString(i+1, parameters.get(i));
            }
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                billing = createBilling(resultSet);
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
        double balance = Double.parseDouble(resultSet.getString("Balance")); // parse to double
        String accountStatus = resultSet.getString("AccountStatus");        
        String useStatus = resultSet.getString("UseStatus");        
        return new Customer(customerNumb, password, firstName,lastName,road,zipCode,email,phoneNumb,balance,accountStatus);
        }
    
        private Terminal createTerminal(ResultSet resultSet) throws SQLException {
        String hardwareNumb = resultSet.getString("hardwareNumb");
        String road = resultSet.getString("road");
        String zipCode = resultSet.getString("zipCode");
        String ipAddress = resultSet.getString("ipAddress");
        String installStatus = resultSet.getString("installStatus");
        String chargingStatus = resultSet.getString("chargingStatus");        
        return new Terminal(hardwareNumb,road, zipCode, ipAddress, installStatus,chargingStatus);
        }

        private Deposit createDeposit(ResultSet resultSet) throws SQLException {
        String depositsNumb = resultSet.getString("DepositsNumb");
        String customerNumb = resultSet.getString("CustomerNumb");
        String depositsDate = resultSet.getString("DepositsDate");
        double depositAmount = Double.parseDouble(resultSet.getString("DepositAmount"));          // parse to double
        double newBalanceDeposit = Double.parseDouble(resultSet.getString("NewBalanceDeposit"));  // parse to double
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
        double billingAmount = Double.parseDouble(resultSet.getString("BillingAmount")); // parse to double
        double billingRate = Double.parseDouble(resultSet.getString("BillingRate"));    // parse to double
        double billingKWH = Double.parseDouble(resultSet.getString("BillingKWH"));     // parse to double
        double newBalanceBilling = Double.parseDouble(resultSet.getString("NewBalanceBilling")); // parse to double
        return new Billing(transactionNumb,customerNumb, hardwareNumb, startCharge, endCharge,recieved,billingAmount, billingRate, billingKWH,newBalanceBilling);
    }    
}

