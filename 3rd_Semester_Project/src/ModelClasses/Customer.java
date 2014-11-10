package ModelClasses;

//Model Class for Object creation
import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {

    private int customerNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public int totalRecords;
   // private String status; // Logged in, Valid customer, Active/Disabled e.t.c

    
    
public Customer(){
        this.customerNumber = -1;
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
}
    
    
    
    
    
//    public Customer(int customerNumb, String email, // String status,            
//            String firstname, String lastname) throws RemoteException {
//        this.customerNumber = customerNumb;
//        //   this.status = status;
//        this.firstName = firstname;
//        this.lastName = lastname;
//        this.email = email;
//    }
//
//    public Customer(Customer obj) throws RemoteException {
//        this.customerNumber = obj.customerNumber;
//        this.firstName = obj.firstName;
//        this.lastName = obj.lastName;
//        this.email = obj.email;
//    }

    /**
     *
     * getters and setters
     */
    public int getCustomerNumber() {return customerNumber;}
   // public String getCustomerNumber(){return "" + customerNumber;}        // return as string
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;}
    public void setCustomerNumber(String CustomerNumber) {
        this.customerNumber = Integer.parseInt(CustomerNumber);}
    
    public String getFirstname() {return firstName;}
    public void setFirstname(String firstName) {this.firstName = firstName;}

    public String getLastname() {return lastName;}
    public void setLastname(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;}

    public int getTotalRecords() {return totalRecords;}

    public String getPassword() {return password;}

    public void setPassword(String Password) {this.password = Password;}

  //  public String getStatus() {return status;}
    //  public void setStatus(String status) {this.status = status;}
    /**
     * Pass the Customer object to a formated string. Format: "FIRSTNAME,
     * LASTNAME, EMAIL"
     *
     * @return the formated string.
     */
    @Override
    public String toString() {
        String s = firstName + ", " + lastName + ", " + email + ", " + password;
        return s;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.customerNumber;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.password);
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
        if (this.customerNumber != other.customerNumber) {
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
        if (this.totalRecords != other.totalRecords) {
            return false;
        }
        return true;
    }

}