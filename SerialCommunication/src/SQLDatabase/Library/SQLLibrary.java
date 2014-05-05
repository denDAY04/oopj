/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Library;

/**
 *
 * @author Qess
 */
public class SQLLibrary {

    //       ****************************************************USER QUERYS****************************************************    
    
// USER Get user data    
//ArrayList: 1, CustomerNumb
 public static final String USER_GET_USER_DATA = "select FirstName, LastName, Road, ZipCode, Email, PhoneNumb, Balance, AccountStatus " 
                                               + "from Customer "
                                               + "where CustomerNumb = ?";
// USER  Get deposits
//ArrayList: 1, CustomerNumb
 public static final String USER_GET_DEPOSITS = "select DepositsNumb, DepositsDate, DepositAmount, NewBalanceDeposit, last4CardNumb " 
                                              + "from Deposits "
                                              + "where CustomerNumb = ?";
// USER  Get Billing
//ArrayList: 1, CustomerNumb
 public static final String USER_GET_BILLING = "select Recieved, TransactionNumb, BillingAmount, NewBalanceBilling " 
                                             + "from Billing "
                                             + "inner join Customer"
                                             + "on Billing.CustomerNumb = Customer.CustomerNumb"
                                             + "where CustomerNumb = ?";
//  public static final String USER_GET_BILLING = "select Recieved, TransactionNumb, BillingAmount, NewBalanceBilling " 
//                                             + "from Billing "
//                                             + "where CustomerNumb = ?";
// USER  get Billing & Terminals - (on click)
//ArrayList: 1, TransactionNumb
 public static final String USER_GET_BILLING_N_TERMINAL = "select TransactionNumb, StartCharge, EndCharge, Recieved, BillingAmount, " 
                                     +"BillingRate, BillingKWH, NewBalanceBilling, Road, ZipCode " 
                                     + "from Billing "
                                     + "inner join Terminals "
                                     + "on Billing.HardwareNumb = Terminals.HardwareNumb "
                                     + "where TransactionNumb= ?"; 


// USER Set user data
//ArrayList: 1, Password, 2, FirstName, 3, LastName, 4, Road, 5, ZipCode, 6, Email, 7, PhoneNumb, 8, CustomerNumb
 public static final String USER_SET_USER_DATA = "update Customer" 
                                               + "set Password = ?," 
                                               + "FirstName = ?," 
                                               + "LastName  = ?,"
                                               + "Road      = ?,"
                                               + "ZipCode   = ?,"
                                               + "Email     = ?,"
                                               + "PhoneNumb = ?"
                                               + "where CustomerNumb = ?";

    //       ****************************************************ADMIN QUERYS****************************************************    
 // ADMIN Get user data
 //ArrayList: 1, CustomerNumb
 public static final String ADMIN_GET_USER_DATA = "select * "  
                                                + "from Customer "
                                                + "where CustomerNumb = ?";

// ADMIN Get deposits         
//ArrayList: 1, CustomerNumb
 public static final String ADMIN_GET_DEPOSITS = "select *" 
                                               + "from Deposits"
                                               + "where CustomerNumb = ?";

 // ADMIN Get Billing
 //ArrayList: 1, CustomerNumb
 public static final String ADMIN_GET_BILLING = "select *" 
                                              + "from Billing"
                                              + "where CustomerNumb = ?";
// ADMIN get Billing & terminal - on click
//ArrayList: 1, TransactionNumb
 public static final String ADMIN_GET_BILLING_AND_TERMINAL = "select *" 
                + "from Billing"
                + "inner join Terminal"
                + "on Billing.HardwareNumb = Terminal.HardwareNumb"
                + "where TransactionNumb= ?"; 

// ADMIN Set user data
    //- ADMIN Get user data
  //ArrayList: 1, Pin,2, Password,3, CardNumb,4, FirstName,5, LastName,6, Road,7, ZipCode,8, Email,9, PhoneNumb,10, AccountStatus,11, CustomerNumb
 public static final String ADMIN_SET_USER_DATA = "update Customer "
                                                + "set Pin      = ?,"
                                                + "Password     = ?,"
                                                + "CardNumb     = ?,"
                                                + "FirstName    = ?," 
                                                + "LastName     = ?,"
                                                + "Road         = ?,"
                                                + "ZipCode      = ?,"
                                                + "Email        = ?,"
                                                + "PhoneNumb    = ?,"
                                                + "AccountStatus= ? "
                                                + "where CustomerNumb = ?";

// ADMIN add new terminal                   
//ArrayList: 1,Road,2, ZipCode,3, IPAddress         
 public static final String ADMIN_ADD_NEW_TERMINAL = "insert into Terminals (Road, ZipCode, IPAddress, InstallStatus, ChargingStatus) " 
                                                   + "Values (?,?,?,'Pending deployment','Idle')";

//ADMIN change terminal InstallStatus           
//ArrayList: 1, InstallStatus, 2, HardwareNumb
 public static final String ADMIN_CHANGE_TERMINAL_INSTALLSTATUS  = "update Terminals "  
                                                                 + "set InstallStatus  = ? "
                                                                 + "where HardwareNumb = ?";

    //       ****************************************************SYSTEM QUERYS****************************************************                
// SYSTEM Validate customer   
//ArrayList: 1, CardNumb,2, Pin
 //public static final String SYSTEM_VALIDATE_CUSTOMER = "select FirstName, Balance, AccountStatus, UseStatus " 
//                                                     + "from Customer "
//                                                     + "where CardNumb = ? and Pin = ?";
 // SYSTEM Validate customer   
//ArrayList: 1, CardNumb,2, Pin
 public static final String SYSTEM_VALIDATE_CUSTOMER = "select * " 
                                                     + "from Customer "
                                                     + "where CardNumb = ? and Pin = ?";

  public static final String SYSTEM_VALIDATE_CUSTOMER_LOGIN = "select * " 
                                                     + "from Customer "
                                                     + "where Email = ? and Password = ?";
  
    public static final String SYSTEM_GET_CUSTOMER_BY_CARD = "select * " 
                                                     + "from Customer "
                                                     + "where CardNumb = ?";
    
    public static final String SYSTEM_GET_CUSTOMER_BY_EMAIL = "select * " 
                                                     + "from Customer "
                                                     + "where Email = ?";
 
 // SYSTEM create deposit
    //---Get old balance
 //ArrayList: 1, CustomerNumb
 public static final String SYSTEM_GET_OLD_BALANCE = "select Balance "  
                                                   + "from Customer "
                                                   + "where CustomerNumb = ?";
    //--- Write new balance
 //ArrayList: 1, Balance,2, CustomerNumb
 public static final String SYSTEM_WRITE_NEW_BALANCE = "update Customer " 
                                                     + "set Balance= ? " 
                                                     + "where CustomerNumb = ?";
    //--- Log deposit
 //ArrayList: 1, CustomerNumb,2, DepositAmount,3, NewBalanceDeposit,4, ExternalRefNumb,5, last4CardNumb
 public static final String SYSTEM_LOG_DEPOSIT = "insert into Deposits (CustomerNumb, DepositAmount, NewBalanceDeposit, ExternalRefNumb,last4CardNumb) " 
                                               + "Values (?,?,?,?,?)";
 

// SYSTEM Create new billing
    //---Get old balance         
         // SYSTEM_GET_OLD_BALANCE
    //--- Write new balance
         // SYSTEM_WRITE_NEW_BALANCE
    //--- Log new billing
  //ArrayList: 1, CustomerNumb,2, HardwareNumb,3, StartCharge,4, EndCharge,5, BillingAmount,6, BillingRate,7, BillingKWH,8, NewBalanceBilling
  public static final String SYSTEM_LOG_NEW_BILLING = "insert into Billing (CustomerNumb, HardwareNumb, StartCharge, EndCharge, BillingAmount, "  
                                                    + "BillingRate, BillingKWH, NewBalanceBilling) "
                                                    + "Values (?,?,?,?,?,?,?,?)";

  // System Create new customer
//1, Password,2, FirstName,3, LastName,4, Road,5, ZipCode,6, Email,7, PhoneNumb,8, Balance,9, AccountStatus
 public static final String SYSTEM_CREATE_NEW_CUSTOMER = "insert into Customer (Password, FirstName, LastName, Road, ZipCode, Email, PhoneNumb, Balance, AccountStatus, UseStatus) "
                                                       + "values (?,?,?,?,?,?,?,?,'PenApp', 'Idle')";

 // System Set charging status (customer and Terminals)
    //--- Set customer use status
// 1, UseStatus,2, CustomerNumb
 public static final String SYSTEM_SET_CUSTOMER_USE_STATUS = "update Customer " 
                                                           + "set usestatus = ? "
                                                           + "where CardNumb = ? ";
    //--- Set Terminals charge status
//1, ChargingStatus,2, HardwareNumb         
 public static final String SYSTEM_TERMINAL_CHARGE_STATUS = "update Terminals " 
                                                           + "set ChargingStatus = ? "
                                                           + "where HardwareNumb = ?";      
 
public static final String SYSTEM_GET_TERMINAL = "select * " 
                                                               + "from Terminals "
                                                               + "where HardwareNumb = ?";  
public static final String SYSTEM_GET_ALL_TERMINALS = "select * " 
                                                      + "from Terminals";  



  public static final String SYSTEM_TERMINAL_RESET_OFFLINESINCE = "update Terminals  " 
                                                               + "set OfflineSince = 'Online' "
                                                               + "where IPAddress = ?"; 

  public static final String SYSTEM_TERMINAL_SET_OFFLINESINCE =   "UPDATE Terminals " +
                                                                    "SET OfflineSince = CASE " +
                                                                    "WHEN OfflineSince='Online' " +
                                                                    "THEN CURRENT_TIMESTAMP "+ 
                                                                    "ELSE OfflineSince " +
                                                                    "END " + 
                                                                    "WHERE IPAddress = ?";
}



