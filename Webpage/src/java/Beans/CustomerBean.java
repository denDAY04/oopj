package Beans;


import Website.WebsiteManagerRMISkel;
import ModelClasses.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;


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
int customerNumber;
String firstName;
String lastName;
String email;
String password;

String oldFirst;
String oldLast;
String oldEmail;
String oldPassword;
private WebsiteManagerRMISkel skel;
String errorMessage = ""; //Email/Password combination not found
String errorMessage2 = ""; //Email already exists
String errorMessage3 = ""; //Email already exists (EditInformation)

    public CustomerBean() throws Exception{

        //this.skel = new WebsiteManagerRMISkel();
        String host = "goonhilly6.eitlab.ihk-edu.dk";        
        int port = 20423;               
        System.out.println("Client: Starting...");
        System.out.println("Using registry at: " + host + " port " + port);

        
        final Registry registryA;
        try {registryA = LocateRegistry.getRegistry(host, port);        
       
         final String[] boundNames = registryA.list();
         System.out.println(
            "Names bound to RMI registry at host " + host + " and port " + port + ":");
         for (final String name : boundNames)
         {System.out.println("\t" + name);}        
        }
         catch (RemoteException ex) {
             System.err.println("Setup graph Remote ex: " +ex);
        }
   
            Registry registry = LocateRegistry.getRegistry(host, port);     
            this.skel = (WebsiteManagerRMISkel)registry.lookup("websiteManager");                      

    }                   

    /*public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }*/
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

