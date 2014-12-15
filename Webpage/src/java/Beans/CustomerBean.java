//Author: Mathias Nordahl
package Beans;

import RMIInterfaces.WebsiteManagerRMISkel;
import ModelClasses.*;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerBean implements Serializable {

private int customerNumber;
private String firstName;
private String lastName;
private String email;
private String password;
private String errorMessage = ""; //Email/Password combination not found
private String errorMessage2 = ""; //Email already exists
private String errorMessage3 = ""; //Email already exists (EditInformation)
private WebsiteManagerRMISkel skel;

    public CustomerBean() throws Exception{

        //Setup RMI Client
        String host = "goonhilly6.eitlab.ihk-edu.dk";        
        int port = 20421;               
        System.out.println("Client: Starting...");
        System.out.println("Using registry at: " + host + " port " + port);
        
        final Registry registryA;
        try{
            registryA = LocateRegistry.getRegistry(host, port);        
            final String[] boundNames = registryA.list();
            System.out.println(
               "Names bound to RMI registry at host " + host + " and port " + port + ":");
            for (final String name : boundNames){
                System.out.println("\t" + name);
            }        
        }
         catch (RemoteException ex){
             System.err.println("Setup graph Remote ex: " +ex);
        }
        Registry registry = LocateRegistry.getRegistry(host, port);     
        this.skel = (WebsiteManagerRMISkel)registry.lookup("websiteManager");                      
    }                   
    
    /**
    * Invokes the logOn method specified in the WebsiteManagerRMISkel in the
    * RMIInterfaces package. The method login() gets a Customer object from the
    * RMI server, and verifies if it is not null.
    * <p>
    * The bean properties are set if a Customer object is returned from logOn
    * @param  None
    * @return      True if Customer != null, False otherwise
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    */
    public boolean login() throws RemoteException{
        Customer user = this.skel.logOn(email, password);
        if(user!= null){
            this.customerNumber = user.getCustomerNumber();
            this.firstName = user.getFirstname();
            this.lastName = user.getLastname();
            this.email = user.getEmail();
            setErrorMessage("");
            return true;
        } else{
            setErrorMessage("Error - Could not login, user not found");
            return false;
        }
    }
    
    /**
    * Invokes the createCustomer method specified in the WebsiteManagerRMISkel in the
    * RMIInterfaces package. The method signUp() gets a customerNumber from the
    * RMI server, and verifies it is not -1.
    * <p>
    * The bean property customerNumber are set if the received number != -1.
    * @param  None
    * @return      True if customerNumber != -1, False otherwise
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    */
    public boolean signUp() throws RemoteException{
        Customer user = new Customer(firstName,lastName,email,password);
        int cNumber = this.skel.createCustomer(user);
        if(cNumber!=-1){
            this.customerNumber = cNumber;
            setErrorMessage2("");
            
            return true;
        } else{
            setErrorMessage2("Error - Email address is already in use");
            return false;
        }
    }
    
    /**
    * Invokes the setCustomerDetails method specified in the WebsiteManagerRMISkel 
    * in the RMIInterfaces package. The method changeDetails() gets a Customer 
    * object from the RMI server, and verifies if the objects properties are
    * identical to those in the bean. 
    * <p>
    * The bean properties are set in both cases as the old data would need to
    * be filled back in if the submission failed.
    * @param  None
    * @return      True if CustomerSent == CustomerReceived, False otherwise
    * @see         RMIInterfaces.WebsiteManagerRMISkel
    */
    public boolean changeDetails() throws RemoteException{
        Customer user = new Customer(firstName,lastName,email,password);
        user.setCustomerNumber(customerNumber);
        System.err.println(user.getFirstname()+" "+user.getLastname()+" "+user.getEmail());
        Customer upUser = this.skel.setCustomerDetails(user);
        System.err.println(upUser.getFirstname()+" "+upUser.getLastname()+" "+upUser.getEmail());
        System.err.println(!upUser.equals(user));
        if(upUser.equals(user)){
            this.firstName = upUser.getFirstname();
            this.lastName = upUser.getLastname();
            this.email = upUser.getEmail();
            this.password = upUser.getPassword();
            errorMessage3="";
            return true;
        } else{
            this.firstName = upUser.getFirstname();
            this.lastName = upUser.getLastname();
            this.email = upUser.getEmail();
            this.password = upUser.getPassword(); 
            errorMessage3="Error - Email address is already in use";
            return false;
        }
    }
    
    //Accessor and Mutator methods
    public String getErrorMessage(){
        return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage2(){
        return errorMessage2;
    }
    
    public void setErrorMessage2(String errorMessage2){
        this.errorMessage2 = errorMessage2;
    }
    
    public String getErrorMessage3(){
        return errorMessage3;
    }
    
    public void setErrorMessage3(String errorMessage3){
        this.errorMessage3 = errorMessage3;
    }
    
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int CustomerNumber) {
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
}

