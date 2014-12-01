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
     * Get a customer with email.
     */
    public static final String SEARCH_EMAIL = "SELECT *"
            + "FROM Customer "
            + "WHERE eMail = ?";
        
    /**
     * Get a customer with customer number.
     */
    public static final String SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB = "SELECT * "
            + "FROM Customer "
            + "WHERE CustomerNumber = ?";    
    
    /**
     * Update customer by CustomerNumber
     * firstName, lastName, email, password
     */
    public static final String UPDATE_CUSTOMER = "UPDATE Customer "
            + "SET (FirstName, LastName, eMail, Password) = (?,?,?,?) "
            + "WHERE CustomerNumber = ?";    
   
    /**
     * Get a customer with email and password.
     */
    public static final String SYSTEM_VALIDATE_CUSTOMER_LOGIN = "SELECT * "
            + "FROM Customer "
            + "WHERE Email = ? and Password = ?";    

    /** 
     * TEST -- Get all of a customers journey history given his customer id.
     */
    public static final String SYSTEM_GET_JOURNEY_HISTORY   = "SELECT * "
            + "FROM journeyhistory "
            + "WHERE Customer = ? "
            + "ORDER BY datetimestamp DESC";
    
    /**
     * Get a range of journey history given a customer and the start and end index.
     */
    public static final String SYSTEM_GET_JOURNEY_HISTORY_RANGE   = "SELECT * "
            + "FROM journeyhistory "
            + "WHERE Customer = ? "            
            + "ORDER BY datetimestamp DESC "
            + "LIMIT 5 OFFSET ?";           
  
    /**
     * Return TicketList
     */
    public static final String SYSTEM_GET_TICKETLIST= "SELECT * "
            + "FROM ticket "
            + "WHERE customer = ? "
            + "ORDER BY customer ASC";      
       
    /**
     * Create Ticket:
     * auto generates datetimestamp
     * ticketprice, startzone, customer
     */
    public static final String CREATE_TICKET= "INSERT INTO "
            + "ticket (ticketprice, startzone, zonecount, customer)  "
            + "VALUES (?,?,?,?)";      
            
    /**
     * Create Ticket in JourneyHistory:
     */
    public static final String TRANSFER_TICKET_TO_HISTORY= "INSERT INTO "
            + "JourneyHistory (ticketnumber, datetimestamp, ticketprice, startzone, zonecount, customer)  "
            + "VALUES (?,?,?,?,?,?)";  
    
    /**
     * Delete a ticket in Ticket table:
     */
    public static final String DELETE_TICKET= "DELETE FROM "
            + "ticket * "
            + "WHERE ticketnumber = ? ";  
                
    /**
     * Update ticket t by ticket number
     */
    public static final String UPDATE_TICKET = "UPDATE ticket "
            + "SET zonecount = ?, "
            + "ticketprice = ? "
            + "WHERE ticketnumber = ?";    
    
    /**
     * Get a customer with customer number.
     */
    public static final String SYSTEM_GET_CUSTOMERNUMBER = "SELECT CustomerNumber "
            + "FROM Customer "
            + "WHERE FirstName = ? "
            + "AND LastName = ? "
            + "AND eMail = ? "
            + "AND Password = ? ";        
    
    /**
     * Get Database Time:
     */
    public static final String GET_TIME= "SELECT "
            + "current_time ";       
            
    /**
     * "select speedbound FROM speedbound"
     */
    public static final String ROUTEPLANNER_GET_SPEEDBOUND = "select speedbound FROM speedbound";    
    
    /**
     * "select stopname,zoneNumber,longitude,latitude FROM stops"
     */
     public static final String ROUTEPLANNER_GET_STOP = "select stopname,zoneNumber,longitude,latitude FROM stops";
    
     /**
      * select vehicle,line,fromstop,tostop,towards FROM stoplinks
      */
     public static final String ROUTEPLANNER_GET_STOPLINK ="select vehicle,line,fromstop,tostop,towards FROM stoplinks";

    
    
    
//   LIMIT { count | ALL }
//   OFFSET start
//count specifies the maximum number of rows to return, while start specifies 
//the number of rows to skip before starting to return rows. When both are 
//specified, start rows are skipped before starting to count the count rows 
//to be returned.
//
//If the count expression evaluates to NULL, it is treated as LIMIT ALL, i.e., 
//no limit. If start evaluates to NULL, it is treated the same as OFFSET 0. 
    
  
   
//    FETCH_COUNT
//If this variable is set to an integer value > 0, the results of SELECT queries 
//are fetched and displayed in groups of that many rows, rather than the default
//behavior of collecting the entire result set before display. 
//Therefore only a limited amount of memory is used, regardless of the size of 
//the result set. 
//Settings of 100 to 1000 are commonly used when enabling this feature. 
//Keep in mind that when using this feature, a query might fail after having 
//already displayed some rows.
//
//Tip: Although you can use any output format with this feature, the default 
//aligned format tends to look bad because each group of FETCH_COUNT rows will 
//be formatted separately, leading to varying column widths across the row 
//groups. The other output formats work better.
    

    
   
    //BEGIN, COMMIT, ROLLBACK
    
//    AUTOCOMMIT
//When on (the default), each SQL command is automatically committed upon 
//successful completion. To postpone commit in this mode, 
//you must enter a BEGIN or START TRANSACTION SQL command. 
//When off or unset, SQL commands are not committed until you explicitly issue 
//COMMIT or END. The autocommit-off mode works by issuing an implicit BEGIN 
//for you, just before any command that is not already in a transaction block 
//and is not itself a BEGIN or other transaction-control command, nor a command
//that cannot be executed inside a transaction block (such as VACUUM).
//
//Note: In autocommit-off mode, you must explicitly abandon any failed 
//transaction by entering ABORT or ROLLBACK. Also keep in mind that if you exit 
//the session without committing, your work will be lost.
//Note: The autocommit-on mode is PostgreSQL's traditional behavior, 
//but autocommit-off is closer to the SQL spec.
  
    
    
//    ON_ERROR_ROLLBACK
//When on, if a statement in a transaction block generates an error, the error 
//is ignored and the transaction continues. When interactive, such errors are 
//only ignored in interactive sessions, and not when reading script files. 
//When off (the default), a statement in a transaction block that generates 
//an error aborts the entire transaction. The on_error_rollback-on mode works 
//by issuing an implicit SAVEPOINT for you, just before each command that is 
//in a transaction block, and rolls back to the savepoint on error.

    
    
//    xml queryRoutePlanner(startPosition, endPosition, timeDeparture)
//    xml viewJourneysWithPrice(customerNumber)
    
 

    
//
//    /**
//     * Get customers by first name.
//     */
//    public static final String ADMIN_SEARCH_USER_FIRSTNAME = "SELECT * "
//            + "FROM Customer "
//            + "WHERE UPPER(FirstName) "
//            + "LIKE UPPER(?)";


}