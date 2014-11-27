package Beans;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rasmus
 */
public class Customer implements Serializable {
    
String customerNumber;
String firstName;
String lastName;
String email;
String password;
int totalRecords;
//String Status;        // Logged in, Valid customer, e.t.c
public Customer(){
    
}

public Customer(String firstName, String lastName, String email, String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
}
public void setTotalRecords(int totalRecords){
 this.totalRecords=totalRecords;
}

public int getTotalRecords(){
 return totalRecords;
}

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String CustomerNumber) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.customerNumber);
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.lastName);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerNumber, other.customerNumber)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
}
