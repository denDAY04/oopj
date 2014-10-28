/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Rasmus
 */
public class Customer {
    
int customerNumber;
String firstName;
String lastName;
String email;
String password;
//String Status;        // Logged in, Valid customer, e.t.c  


    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int CustomerNumber) {
        this.customerNumber = CustomerNumber;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String Firstname) {
        this.firstName = Firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String Lastname) {
        this.lastName = Lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }
}
