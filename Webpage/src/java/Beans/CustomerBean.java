package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RAsmus
 */
public class CustomerBean {
    
/*public String name = "Rasmus";
public int value = 5;
public int newcustomer;*/

//String customerNumber = "1234"; //change to "" to test page redirects 
String customerNumber = "";
String firstName = "Mister";
String lastName = "Bean";
String email = "Test@Test.Test";
String password = "1234";

    /*public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }*/

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String CustomerNumber) {
        this.customerNumber = CustomerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String Firstname) {
        this.firstName = Firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String Lastname) {
        this.lastName = Lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }


    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


    public void setValue(String name) {
        this.name = name;
    }*/
    
//    public String getNewcustomer(){
//        return newcustomer;
//    }
    
    /*public void setNewcustomer(int newcustomer){
    this.newcustomer=newcustomer;
    }
    
    
    
    public int getNewcustomer(){
        int rows=0;
    
         try {

    String url = "jdbc:postgresql://thelizard6.eitlab.ihk-edu.dk:5432/rasmus3e14";
    String userName = "rasmus3e14";
    String password = "s132309";
    Connection con=null;

    PreparedStatement preparedStatementTest;
    //PreparedStatement preparedStatementInsert;
    String testStatementString = "INSERT INTO ntest(name,age) Values (?,?)";
   // String insertStatement = "INSERT into transport (CustomerNumb) Values (?)";

            try {
            try {
            Class.forName("org.postgresql.Driver").newInstance();
            } catch (ClassNotFoundException ex) {
                System.err.println("ClassNotFoundException "+ex);
            } catch (InstantiationException ex) {
                System.err.println(ex);
        } catch (IllegalAccessException ex) {
                System.err.println(ex);
        }
            con = DriverManager.getConnection(url, userName, password);

        } catch (SQLException ex) {
            System.err.println("cannot connect to database! "+ex);
        }
    
            preparedStatementTest = con.prepareStatement(testStatementString);
            preparedStatementTest.setString(1, name);
            preparedStatementTest.setInt(2, value);
           rows = preparedStatementTest.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL exception!");
        }
    
         return rows;
    }*/
    
}

