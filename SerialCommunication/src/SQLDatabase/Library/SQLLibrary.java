package SQLDatabase.Library;

/**
 * Library with Static String objects serving as SQL query templates for use in
 * prepared statements.
 */
public class SQLLibrary {

    /**
     * Get simple deposit with customer number.
     */
    public static final String USER_GET_DEPOSITS = "select * "
            + "from Deposits "
            + "where CustomerNumb = ?";

    /**
     * Get detailed deposit with deposit number.
     */
    public static final String USER_GET_DEPOSIT_DETAILS = "select * "
            + "from Deposits "
            + "where DepositsNumb = ? ";

    /**
     * Get simple billing with customer number.
     */
    public static final String USER_GET_BILLING = "select * "
            + "from Billing "
            + "where CustomerNumb = ?";

    /**
     * Get detailed billing with transaction number.
     */
    public static final String USER_GET_BILLING_AND_TERMINAL = "select "
            + "TransactionNumb, StartCharge, EndCharge, Recieved, "
            + "BillingAmount, BillingRate, BillingWH, NewBalanceBilling, Road,"
            + " ZipCode, CustomerNumb, Terminals.HardwareNumb "
            + "from Billing "
            + "inner join Terminals "
            + "on Billing.HardwareNumb = Terminals.HardwareNumb "
            + "where TransactionNumb= ?";

    /**
     * Set customer data with customer number. Data:
     * <li> first name
     * <li> last name
     * <li> road
     * <li> zip code
     * <li> phone number
     * <li> email
     */
    public static final String USER_SET_USER_DATA = "update Customer "
            + "set FirstName = ?, "
            + "LastName  = ?, "
            + "Road      = ?, "
            + "ZipCode   = ?, "
            + "PhoneNumb = ?, "
            + "Email     = ? "
            + "where CustomerNumb = ?";

    /**
     * Set customer's password with customer number.
     */
    public static final String USER_SET_USER_PASSWORD = "update Customer "
            + "set Password = ? "
            + "where CustomerNumb = ?";

    /**
     * Set customer's data with customer number. FOR ADMIN USE. Data.
     * <li> first name
     * <li> last name
     * <li> road
     * <li> zip code
     * <li> phone number
     * <li> email
     * <li> pin
     * <li> account status
     * <li> use status
     */
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

    /**
     * Set customer's password with customer number. FOR ADMIN USE.
     */
    public static final String ADMIN_SET_USER_PASSWORD = "update Customer "
            + "set Password= ? "
            + "where CustomerNumb = ?";

    /**
     * Set customer's account status with customer number.
     */
    public static final String ADMIN_SET_USER_ACCOUNTSTATUS = "update Customer "
            + "set AccountStatus= ? "
            + "where CustomerNumb = ?";

    /**
     * Get customers by first name.
     */
    public static final String ADMIN_SEARCH_USER_FIRSTNAME = "select * "
            + "from Customer "
            + "where UPPER(FirstName) "
            + "like UPPER(?)";

    /**
     * Get deposits with external reference number.
     */
    public static final String ADMIN_SEARCH_DEPOSITS_REFNUMBER = "select * "
            + "from Deposits "
            + "where ExternalRefNumb = ?";

    /**
     * Get billings with transaction number.
     */
    public static final String ADMIN_SEARCH_BILLINGS_TRANSNUMB = "select * "
            + "from Billing "
            + "where TransactionNumb = ?";

    /**
     * Add new terminal with ROAD, ZIPCODE, and IPADDRESS.
     */
    public static final String ADMIN_ADD_NEW_TERMINAL = "insert into Terminals "
            + "(Road, ZipCode, IPAddress, InstallStatus, ChargingStatus) "
            + "Values (?,?,?,'PENDEP','IDLE')";

    /**
     * Set install status of a terminal with hardware number.
     */
    public static final String ADMIN_SET_TERMINAL_INSTALLSTATUS = "update "
            + "Terminals "
            + "set InstallStatus  = ? "
            + "where HardwareNumb = ?";

    /**
     * Set all data for a terminal with hardware number. Data:
     * <li> road
     * <li> zip code
     * <li> charging status
     * <li> offline since
     * <li> IP address
     * <li> install status
     */
    public static final String ADMIN_SET_TERMINAL_ALL_DETAILS = "update "
            + "Terminals "
            + "set Road = ?, "
            + "ZipCode = ?, "
            + "ChargingStatus = ?, "
            + "OfflineSince = ?, "
            + "IPAddress = ?, "
            + "InstallStatus = ? "
            + "where HardwareNumb = ?";

    /**
     * Get a customer with card number and pin.
     */
    public static final String SYSTEM_VALIDATE_CUSTOMER = "select * "
            + "from Customer "
            + "where CardNumb = ? and Pin = ?";

    /**
     * Get a customer with email and password.
     */
    public static final String SYSTEM_VALIDATE_CUSTOMER_LOGIN = "select * "
            + "from Customer "
            + "where Email = ? and Password = ?";

    /**
     * Get a customer with card number.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_CARD = "select * "
            + "from Customer "
            + "where CardNumb = ?";

    /**
     * Get a customer with email.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_EMAIL = "select * "
            + "from Customer "
            + "where Email = ?";

    /**
     * Get a customer with customer number.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB = "select * "
            + "from Customer "
            + "where CustomerNumb = ?";

    /**
     * Set new balance of a customer with customer number.
     */
    public static final String SYSTEM_WRITE_NEW_BALANCE = "update Customer "
            + "set Balance= ? "
            + "where CustomerNumb = ?";

    /**
     * Create new deposit with data:
     * <li> customer number
     * <li> deposit amount
     * <li> new balance
     * <li> external reference number
     * <li> last four digits of debit card number
     */
    public static final String SYSTEM_LOG_DEPOSIT = "insert into Deposits "
            + "(CustomerNumb, DepositAmount, NewBalanceDeposit, "
            + "ExternalRefNumb, last4CardNumb) "
            + "Values (?,?,?,?,?)";

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
    public static final String SYSTEM_LOG_NEW_BILLING = "insert into Billing "
            + "(CustomerNumb, HardwareNumb, StartCharge, EndCharge, "
            + "BillingAmount, "
            + "BillingRate, BillingWH, NewBalanceBilling) "
            + "Values (?,?,?,?,?,?,?,?)";

    /**
     * Create new customer with data:
     * <li> password
     * <li> first name
     * <li> last name
     * <li> road
     * <li> zip code
     * <li> email
     * <li> phone number
     * <li> balance
     */
    public static final String SYSTEM_CREATE_NEW_CUSTOMER = "insert into "
            + "Customer (Password, FirstName, LastName, Road, ZipCode, Email, "
            + "PhoneNumb, Balance, AccountStatus, UseStatus) "
            + "values (?,?,?,?,?,?,?,?,'PENAPP', 'IDLE')";

    /**
     * Set customer's use status with card number.
     */
    public static final String SYSTEM_SET_CUSTOMER_USE_STATUS = "update Customer "
            + "set usestatus = ? "
            + "where CardNumb = ? ";

    /**
     * Set charge status of terminal with hardware number.
     */
    public static final String SYSTEM_TERMINAL_CHARGE_STATUS = "update Terminals "
            + "set ChargingStatus = ? "
            + "where HardwareNumb = ?";

    /**
     * Get all billings.
     */
    public static final String SYSTEM_GET_ALL_BILLINGS = "select * "
            + "from Billing";

    /**
     * Get all deposits
     */
    public static final String SYSTEM_GET_ALL_DEPOSITS = "select * "
            + "from Deposits";

    /**
     * Get terminal by hardware number.
     */
    public static final String SYSTEM_GET_TERMINAL = "select * "
            + "from Terminals "
            + "where HardwareNumb = ?";

    /**
     * Get terminal by IP address.
     */
    public static final String SYSTEM_GET_TERMINAL_BY_IP = "select * "
            + "from Terminals "
            + "where IPAddress = ?";

    /**
     * Get all terminals.
     */
    public static final String SYSTEM_GET_ALL_TERMINALS = "select * "
            + "from Terminals";

    /**
     * Reset terminal offline since-status to 'ONLINE' with IP address.
     */
    public static final String SYSTEM_TERMINAL_RESET_OFFLINESINCE = "update "
            + "Terminals  "
            + "set OfflineSince = 'ONLINE' "
            + "where IPAddress = ?";

    /**
     * Set offline since-status of a terminal with IP address.
     */
    public static final String SYSTEM_TERMINAL_SET_OFFLINESINCE = "UPDATE "
            + "Terminals "
            + "SET OfflineSince = CASE "
            + "WHEN OfflineSince='ONLINE' "
            + "THEN CURRENT_TIMESTAMP "
            + "ELSE OfflineSince "
            + "END "
            + "WHERE IPAddress = ?";
}
