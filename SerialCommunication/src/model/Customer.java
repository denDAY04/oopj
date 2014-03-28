package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerNumb;
    private String password;
    private String firstName;
    private String lastName;
    private String road;
    private String zipCode;
    private String email;
    private String phoneNumb;
    private String balance;
    private String accountStatus;

    public Customer(String customerNumb,String password, String firstname, String lastname, String road, String zipCode, String email,
                    String phoneNumb, String balance, String accountStatus) {
        this.customerNumb = customerNumb;
        this.password = password;
        this.firstName = firstname;
        this.lastName = lastname;
        this.road = road;
        this.zipCode = zipCode;
        this. email = email;
        this. phoneNumb = phoneNumb;
        this. balance = balance;
        this.accountStatus = accountStatus;


    }
    public String getCustomerNumb() {
        return customerNumb;
    }

    public void setCustomerNumb(String password) {
        this.customerNumb = customerNumb;
    }    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash =
                67 * hash +
                (this.customerNumb != null ? this.customerNumb.hashCode() : 0);
        hash =
                67 * hash +
                (this.password != null ? this.password.hashCode() : 0);
        hash =
                67 * hash +
                (this.firstName != null ? this.firstName.hashCode() : 0);
        hash =
                67 * hash +
                (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 67 * hash + (this.road != null ? this.road.hashCode() : 0);
        hash = 67 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 67 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash =
                67 * hash +
                (this.phoneNumb != null ? this.phoneNumb.hashCode() : 0);
        hash = 67 * hash + (this.balance != null ? this.balance.hashCode() : 0);
        hash =
                67 * hash +
                (this.accountStatus != null ? this.accountStatus.hashCode() : 0);
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
        if ((this.customerNumb == null) ? (other.customerNumb != null)
                : !this.customerNumb.equals(other.customerNumb)) {
            return false;
        }        
        if ((this.password == null) ? (other.password != null)
                : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null)
                : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null)
                : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.road == null) ? (other.road != null)
                : !this.road.equals(other.road)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null)
                : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null)
                : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.phoneNumb == null) ? (other.phoneNumb != null)
                : !this.phoneNumb.equals(other.phoneNumb)) {
            return false;
        }
        if ((this.balance == null) ? (other.balance != null)
                : !this.balance.equals(other.balance)) {
            return false;
        }
        if ((this.accountStatus == null) ? (other.accountStatus != null)
                : !this.accountStatus.equals(other.accountStatus)) {
            return false;
        }
        return true;
    }

    
}
