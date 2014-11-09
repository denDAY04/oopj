package SQLDatabase.Library;

/**
 * Library with Static String objects serving as SQL query templates for use in
 * prepared statements.
 */
public class SQLLibrary {

     
        
    /**
     * Create new customer:
     * first name, last name, email, password
     */
    public static final String CREATE_CUSTOMER = "INSERT INTO "
            + "Customer (FirstName, LastName, eMail, Password) "
            + "VALUES (?,?,?,?)";   
    
       
    
    
    
    
    
     /**
     * Update customer by CustomerNumber
     * firstName, lastName, email
     */
    public static final String UPDATE_CUSTOMER = "UPDATE Customer "
            + "SET (FirstName, LastName, eMail) = (?,?,?) "
            + "WHERE CustomerNumber = ?";    
    
     public static final String UPDATE_CUSTOMER2 = "UPDATE Customer "
             + "SET FirstName = ?, LastName  = ?, eMail = ? "
             + "WHERE CustomerNumber = ?";  
            
    /**
     * Update customer email by CustomerNumber
     */
    public static final String UPDATE_CUSTOMER_EMAIL = "UPDATE Customer "
            + "SET eMail = ? "
            + "WHERE CustomerNumber = ?";
    
    
    /**
     * Check user validity at logOn
     * email, password
     */
    
    
    
    
    
    
    
    // store tickets (TicketList)
    
   
    
    
//    xml queryRoutePlanner(startPosition, endPosition, timeDeparture)
//    xml viewJourneysWithPrice(customerNumber)
    
    
   
    
    
    
    
    
    
    
    /**
     * Get simple billing with customer number.
     */
    public static final String USER_GET_BILLING = "SELECT * "
            + "FROM Billing "
            + "WHERE CustomerNumb = ?";

    /**
     * Get detailed billing with transaction number.
     */
    public static final String USER_GET_BILLING_AND_TERMINAL = "SELECT "
            + "TransactionNumber, StartCharge, EndCharge, Recieved, "
            + "BillingAmount, BillingRate, BillingWH, NewBalanceBilling, Road,"
            + " ZipCode, CustomerNumb, Terminals.HardwareNumb "
            + "FROM Billing "
            + "inner join Terminals "
            + "on Billing.HardwareNumb = Terminals.HardwareNumb "
            + "WHERE TransactionNumber= ?";

 
    
    
    

    


    

    

    /**
     * Get customers by first name.
     */
    public static final String ADMIN_SEARCH_USER_FIRSTNAME = "SELECT * "
            + "FROM Customer "
            + "WHERE UPPER(FirstName) "
            + "LIKE UPPER(?)";


    

    /**
     * Get billings with transaction number.
     */
    public static final String ADMIN_SEARCH_BILLINGS_TRANSNUMB = "SELECT * "
            + "FROM Billing "
            + "WHERE TransactionNumber = ?";

  
    
  
    


    

    /**
     * Get a customer with email and password.
     */
    public static final String SYSTEM_VALIDATE_CUSTOMER_LOGIN = "SELECT * "
            + "FROM Customer "
            + "WHERE Email = ? and Password = ?";

    

    /**
     * Get a customer with email.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_EMAIL = "SELECT * "
            + "FROM Customer "
            + "WHERE Email = ?";

    /**
     * Get a customer with customer number.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB = "SELECT * "
            + "FROM Customer "
            + "WHERE CustomerNumb = ?";

 
    

    /**
     * Create new deposit with data:
     * <li> customer number
     * <li> deposit amount
     * <li> new balance
     * <li> external reference number
     * <li> last four digits of debit card number
     */
    public static final String SYSTEM_LOG_DEPOSIT = "INSERT INTO Deposits "
            + "(CustomerNumb, DepositAmount, NewBalanceDeposit, "
            + "ExternalRefNumb, last4CardNumb) "
            + "VALUES (?,?,?,?,?)";

    /**
     * Create new billing with data:
     * <li> customer number
     * <li> hardware number
     * <li> start charge time
     * <li> end charge time
     * <li> billed amount of DKK
     * <li> rate of a watt-hour
     * <li> amount of watt-hours
     * <li> the new balance after billed
     */
    public static final String SYSTEM_LOG_NEW_BILLING = "INSERT INTO Billing "
            + "(CustomerNumb, HardwareNumb, StartCharge, EndCharge, "
            + "BillingAmount, "
            + "BillingRate, BillingWH, NewBalanceBilling) "
            + "VALUES (?,?,?,?,?,?,?,?)";

   

    /**
     * Set customer's use status with card number.
     */
    public static final String SYSTEM_SET_CUSTOMER_USE_STATUS = "update Customer "
            + "SET usestatus = ? "
            + "WHERE CardNumb = ? ";

    /**
     * Set charge status of terminal with hardware number.
     */
    public static final String SYSTEM_TERMINAL_CHARGE_STATUS = "update Terminals "
            + "SET ChargingStatus = ? "
            + "WHERE HardwareNumb = ?";

    

    
}
