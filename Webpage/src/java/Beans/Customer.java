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
    
int CustomerNumber;
String Firstname;
String Lastname;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
String Email;
String Password;
//String Status;        // Logged in, Valid customer, e.t.c  

    public int getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(int CustomerNumber) {
        this.CustomerNumber = CustomerNumber;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
