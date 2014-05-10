package SQLDatabase.ModelClasses;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerNumb;
    private String pin;
    private String password;
    private String cardNumb;
    private String firstName;
    private String lastName;
    private String road;
    private String zipCode;
    private String email;
    private String phoneNumb;
    private int balance;
    private String accountStatus;
    private String useStatus;

    public Customer(String customerNumb, String pin, String password, String cardNumb, String firstname, String lastname, String road, String zipCode, String email,
                    String phoneNumb, int balance, String accountStatus, String useStatus) {
        this.customerNumb = customerNumb;
        this.pin = pin;
        this.password = password;
        this.cardNumb = cardNumb;
        this.firstName = firstname;
        this.lastName = lastname;
        this.road = road;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumb = phoneNumb;
        this.balance = balance;
        this.accountStatus = accountStatus;
        this.useStatus = useStatus;
        
        
    
}

    public String getCustomerNumb() {
        return customerNumb;
    }

    public void setCustomerNumb(String customerNumb) {
        this.customerNumb = customerNumb;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    @Override
    public String toString(){
        String s = firstName+", "+lastName+", "+email;
        return s;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash =
                37 * hash +
                (this.customerNumb != null ? this.customerNumb.hashCode() : 0);
        hash = 37 * hash + (this.pin != null ? this.pin.hashCode() : 0);
        hash =
                37 * hash +
                (this.password != null ? this.password.hashCode() : 0);
        hash =
                37 * hash +
                (this.cardNumb != null ? this.cardNumb.hashCode() : 0);
        hash =
                37 * hash +
                (this.firstName != null ? this.firstName.hashCode() : 0);
        hash =
                37 * hash +
                (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 37 * hash + (this.road != null ? this.road.hashCode() : 0);
        hash = 37 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 37 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash =
                37 * hash +
                (this.phoneNumb != null ? this.phoneNumb.hashCode() : 0);
        hash =
                37 * hash +
                (int) (Double.doubleToLongBits(this.balance) ^
                (Double.doubleToLongBits(this.balance) >>> 32));
        hash =
                37 * hash +
                (this.accountStatus != null ? this.accountStatus.hashCode() : 0);
        hash =
                37 * hash +
                (this.useStatus != null ? this.useStatus.hashCode() : 0);
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
        if ((this.pin == null) ? (other.pin != null)
                : !this.pin.equals(other.pin)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null)
                : !this.password.equals(other.password)) {
            return false;
        }
        if ((this.cardNumb == null) ? (other.cardNumb != null)
                : !this.cardNumb.equals(other.cardNumb)) {
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
        if (Double.doubleToLongBits(this.balance) !=
                Double.doubleToLongBits(other.balance)) {
            return false;
        }
        if ((this.accountStatus == null) ? (other.accountStatus != null)
                : !this.accountStatus.equals(other.accountStatus)) {
            return false;
        }
        if ((this.useStatus == null) ? (other.useStatus != null)
                : !this.useStatus.equals(other.useStatus)) {
            return false;
        }
        return true;
    }

    
    
    
}
