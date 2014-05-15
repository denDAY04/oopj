package SQLDatabase.Library;

/**
 *
 * @author Qess
 */
public class SQLLibrary {

    public static final String USER_GET_DEPOSITS = "select * " 
                                              + "from Deposits "
                                              + "where CustomerNumb = ?";
  
    public static final String USER_GET_DEPOSIT_DETAILS = "select * "
                                                       + "from Deposits "
                                                       + "where DepositsNumb = ? ";

    public static final String USER_GET_BILLING = "select * " 
                                             + "from Billing "
                                             + "where CustomerNumb = ?";

    public static final String USER_GET_BILLING_N_TERMINAL = "select TransactionNumb, StartCharge, EndCharge, Recieved, BillingAmount, " 
                                     +"BillingRate, BillingKWH, NewBalanceBilling, Road, ZipCode, CustomerNumb, Terminals.HardwareNumb " 
                                     + "from Billing "
                                     + "inner join Terminals "
                                     + "on Billing.HardwareNumb = Terminals.HardwareNumb "
                                     + "where TransactionNumb= ?"; 

    public static final String USER_SET_USER_DATA = "update Customer " 
                                               + "set FirstName = ?, " 
                                               + "LastName  = ?, "
                                               + "Road      = ?, "
                                               + "ZipCode   = ?, "                                
                                               + "PhoneNumb = ?, "
                                               + "Email     = ? "
                                               + "where CustomerNumb = ?";
 
    public static final String USER_SET_USER_PASSWORD = "update Customer " 
                                               + "set Password = ? "
                                               + "where CustomerNumb = ?";

    public static final String ADMIN_SET_USER_DATA = "update Customer "
                                                + "set FirstName= ?, "
                                                + "LastName     = ?, "
                                                + "Road         = ?, "
                                                + "ZipCode      = ?, "
                                                + "PhoneNumb    = ?, "
                                                + "Email        = ?, "
                                                + "CardNumb     = ?, "
                                                + "Pin          = ?, "
                                                + "AccountStatus= ?, "
                                                + "UseStatus = ? "
                                                + "where CustomerNumb = ?";
 
    public static final String ADMIN_SET_USER_PASSWORD = "update Customer "
                                                    + "set Password= ? "
                                                    + "where CustomerNumb = ?";

    public static final String ADMIN_SET_USER_ACCOUNTSTATUS = "update Customer "
                                                         + "set AccountStatus= ? "
                                                         + "where CustomerNumb = ?";
 
    public static final String ADMIN_SEARCH_USER_FIRSTNAME = "select * "
                                                        + "from Customer "
                                                        + "where UPPER(FirstName) "
                                                        + "like UPPER(?)";

    public static final String ADMIN_SEARCH_DEPOSITS_REFNUMBER = "select * "
                                                            + "from Deposits "
                                                            + "where ExternalRefNumb = ?";
 
    public static final String ADMIN_SEARCH_BILLINGS_TRANSNUMB = "select * "
                                                            + "from Billing "
                                                            + "where TransactionNumb = ?";
      
    public static final String ADMIN_ADD_NEW_TERMINAL = "insert into Terminals (Road, ZipCode, IPAddress, InstallStatus, ChargingStatus) " 
                                                   + "Values (?,?,?,'PENDEP','IDLE')";

    public static final String ADMIN_SET_TERMINAL_INSTALLSTATUS  = "update Terminals "  
                                                                 + "set InstallStatus  = ? "
                                                                 + "where HardwareNumb = ?";
 
    public static final String ADMIN_SET_TERMINAL_ALL_DETAILS = "update Terminals "
                                                                + "set Road = ?, "
                                                                + "ZipCode = ?, "
                                                                + "ChargingStatus = ?, "
                                                                + "OfflineSince = ?, "
                                                                + "IPAddress = ?, "
                                                                + "InstallStatus = ? "
                                                                + "where HardwareNumb = ?";
         
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
    
    public static final String SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB = "select * " 
                                                                   + "from Customer "
                                                                   + "where CustomerNumb = ?";
 
    public static final String SYSTEM_WRITE_NEW_BALANCE = "update Customer " 
                                                     + "set Balance= ? " 
                                                     + "where CustomerNumb = ?";
    public static final String SYSTEM_LOG_DEPOSIT = "insert into Deposits (CustomerNumb, DepositAmount, NewBalanceDeposit, ExternalRefNumb,last4CardNumb) " 
                                               + "Values (?,?,?,?,?)";
 
    public static final String SYSTEM_LOG_NEW_BILLING = "insert into Billing (CustomerNumb, HardwareNumb, StartCharge, EndCharge, BillingAmount, "  
                                                    + "BillingRate, BillingKWH, NewBalanceBilling) "
                                                    + "Values (?,?,?,?,?,?,?,?)";

    public static final String SYSTEM_CREATE_NEW_CUSTOMER = "insert into Customer (Password, FirstName, LastName, Road, ZipCode, Email, PhoneNumb, Balance, AccountStatus, UseStatus) "
                                                       + "values (?,?,?,?,?,?,?,?,'PENAPP', 'IDLE')";

    public static final String SYSTEM_SET_CUSTOMER_USE_STATUS = "update Customer " 
                                                           + "set usestatus = ? "
                                                           + "where CardNumb = ? ";
    
    public static final String SYSTEM_TERMINAL_CHARGE_STATUS = "update Terminals " 
                                                           + "set ChargingStatus = ? "
                                                           + "where HardwareNumb = ?";
 
    public static final String SYSTEM_GET_ALL_BILLINGS = "select * " 
                                                   + "from Billing"; 

    public static final String SYSTEM_GET_ALL_DEPOSITS = "select * " 
                                                   + "from Deposits"; 

    public static final String SYSTEM_GET_TERMINAL = "select * " 
                                                               + "from Terminals "
                                                               + "where HardwareNumb = ?";  
    
    public static final String SYSTEM_GET_ALL_TERMINALS = "select * " 
                                                      + "from Terminals";  

    public static final String SYSTEM_TERMINAL_RESET_OFFLINESINCE = "update Terminals  " 
                                                               + "set OfflineSince = 'ONLINE' "
                                                               + "where IPAddress = ?"; 

    public static final String SYSTEM_TERMINAL_SET_OFFLINESINCE =   "UPDATE Terminals " +
                                                                    "SET OfflineSince = CASE " +
                                                                    "WHEN OfflineSince='ONLINE' " +
                                                                    "THEN CURRENT_TIMESTAMP "+ 
                                                                    "ELSE OfflineSince " +
                                                                    "END " + 
                                                                    "WHERE IPAddress = ?";
}



