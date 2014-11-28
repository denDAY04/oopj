/**
 * DatabaseManager (factory)
 * -- Interact-with SQL library
 * <p>
 * Instantiates a database connection pool
 * <p>
 * Unwraps RMI parsed objects into generic database calls
 * capable of being executed by a WorkerThread.
 * the call is created by using a SQLlibrary to load a prepared
 * query and combine it with an ArrayList containing objects to be
 * dereferenced and cast into integers or strings from within the thread
 * <p>
 * Cast the returned object into an integer or a resultset, if required it
 * wraps a SQL resultset back into modelclass objects and
 * returns it to the RMI client
 */
package Manager;

import ModelClasses.*;
import SQLConn.*;
import SQLDatabase.Library.SQLLibrary;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class interacts directly with the database.
 * All manager classes interacts with this class in order
 * to interact with the database.
 */
public class DatabaseManager implements IntDatabaseManager {

    public DatabaseManager() {                
        this.zdc =  new ZoneDistanceCalc();
    }
    
    
    private static final int PRICE_ONE_ZONE_ADULT = 1200; //<editor-fold defaultstate="collapsed" desc="comment">    
    //price is in danish øre.
    //future update: retrieve value from database table called price    
    //</editor-fold>    
    private static ZoneDistanceCalc zdc;
    private Connection con;
    private String query;
    private ArrayList<Object> parameters;
    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    

    //<editor-fold defaultstate="collapsed" desc="Connection Handler">
    private void dbConnect() {

        try {
            if (this.con == null || this.con.isClosed()) {
                //      this.con = ConnectionManager.getConnection();
                this.con = ConnectionManager.createConnection();     // replace this with getConnection
                System.out.println("Connection: Created...");
                if (this.con == null) {
                    throw new NullPointerException("Could not create database connection");
                }
            }
            System.out.println("Connection: Still valid...");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //</editor-fold>         // needs connection pool implementation !!
    private void executeUpdate() throws NullPointerException {
        try {

//            if (this.con != null){System.err.println("Connection not null");}
//            if (this.con.isClosed()){System.err.println("Connection is Closed");}
            dbConnect();
            preparedStatement = con.prepareStatement(query);

            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));
                }
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }

            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally {
            if (con != null) {
                try {
                    con.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private void executeQuery() throws NullPointerException {
        try {
            dbConnect();
            this.preparedStatement = con.prepareStatement(query);

            for (int i = 0; i < parameters.size(); ++i) {
                Class indexedClass = parameters.get(i).getClass();
                if (indexedClass == String.class) {
                    preparedStatement.setString(i + 1, (String) parameters.get(i));
                }
                else if (indexedClass == Integer.class) {
                    preparedStatement.setInt(i + 1, (Integer) parameters.get(i));
                }
            }

            this.resultset = preparedStatement.executeQuery();
            // while (resultset.next()) {}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally {
            if (con != null) {
                try {
                    con.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    
    
    
    

    //<editor-fold defaultstate="collapsed" desc="WebsiteManager">
    //<editor-fold defaultstate="collapsed" desc="Create a new Customer in the SQL Database">    
    /**
     * Create a new customer in the SQL Database
     * <p>
     * @param customer, or -1 if customer weren't found in the database after creation 
     * @return boolean
     */
    @Override
    public int createCustomer(Customer customer) {
        this.query = SQLLibrary.SEARCH_EMAIL;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customer.getEmail());
        this.parameters = parameters;
        executeQuery();
        

        try {
            if(!this.resultset.next()){
                this.query = SQLLibrary.CREATE_CUSTOMER;
                parameters = new ArrayList<>();
                parameters.add(customer.getFirstname());
                parameters.add(customer.getLastname());
                parameters.add(customer.getEmail());
                parameters.add(customer.getPassword());
                this.parameters = parameters;
                executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            return getCustomerNumber(customer);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    private int getCustomerNumber(Customer customer) throws SQLException {       
        this.query = SQLLibrary.SYSTEM_GET_CUSTOMERNUMBER;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customer.getFirstname());
        parameters.add(customer.getLastname());
        parameters.add(customer.getEmail());
        parameters.add(customer.getPassword());
        this.parameters = parameters;
        executeQuery(); 
        
        try {
            if (resultset.next()) {            
            }
                return resultset.getInt("CustomerNumber");
            }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
       
    }
     //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Update Customer details in the SQL Database">
    @Override
    public Customer setCustomerDetails(Customer customer) {
        this.query = SQLLibrary.SEARCH_EMAIL;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customer.getEmail());
        this.parameters = parameters;
        executeQuery();
        
        try {
            if(!this.resultset.next()){
                this.query = SQLLibrary.UPDATE_CUSTOMER;
                parameters = new ArrayList<>();
                parameters.add(customer.getFirstname());
                parameters.add(customer.getLastname());
                parameters.add(customer.getEmail());
                parameters.add(customer.getPassword());
                //parameters.add(customer.getStatus());   //not used
                parameters.add(customer.getCustomerNumber());
                this.parameters = parameters;
                executeUpdate();
                return customer;
            } else{
                this.query = SQLLibrary.SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB;
                parameters = new ArrayList<>();
                parameters.add(customer.getCustomerNumber());
                this.parameters = parameters;
                executeQuery();
                
                try {
                    if (resultset.next()) {
                        return createCustomer(resultset);
                    }
                }
                catch (SQLException ex) {
                    Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new Customer("La","La","La@La.La","Lalala");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Customer("Blah","Blah","Blah@Blah.Blah","Blalala");
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">
    //
    //        // return test customer
    //        Customer customer = new Customer();
    //        customer.setCustomerNumber("1234");
    //        customer.setFirstname("Hans");
    //        customer.setLastname("Jensen");
    //        customer.setEmail("hans@jensen.dk");
    //        customer.totalRecords=24;  //field in customer is set as public for testing
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Retrieve Customer details from the SQL Database">
    @Override
    public Customer getCustomerDetails(int customerNumber) {
        this.query = SQLLibrary.SYSTEM_GET_CUSTOMER_BY_CUSTOMERNUMB;

        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customerNumber);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();
        try {
            if (resultset.next()) {
                return createCustomer(resultset);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">
    // possibility of dublicate customers in the database
    // email may have to be made unique in the sql database
    // does not check for customer not found!!
    //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Customer logon credentials check">
    @Override
    public Customer logOn(String email, String password) {
        this.query = SQLLibrary.SYSTEM_VALIDATE_CUSTOMER_LOGIN;

        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(email);
        parameters.add(password);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();
        try {
            if (resultset.next()) {
                return createCustomer(resultset);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Readme: to do list">        
    // index 0 --- return the last five histories..
    // index 5 --- return return histories from 5 to 10
    // index 10 --- return histories from 10 to 15
    // e.t.c.
        // SQL LIMIT 5 sort Decending ???
    // preparedstatement.setMaxRows(1); ?? -> stoplink.java in algorithme
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Retrieve Customer Journey History from the SQL Database">
    @Override
    public ArrayList<Journey> getJourneyHistory(int customerNumber, int index) {
        this.query = SQLLibrary.SYSTEM_GET_JOURNEY_HISTORY_RANGE;
        ArrayList<Object> parameters = new ArrayList<>();
        parameters.add(customerNumber);
        parameters.add(index);
        this.parameters = parameters;
        System.err.println("executeQuery!!");
        executeQuery();

        ArrayList<Journey> journeyArray = new ArrayList();

        try {

            while (resultset.next()) {
                Journey journey = new Journey();
                journey.setStartzone(resultset.getInt("startzone"));
                journey.setPrice(resultset.getInt("ticketprice"));
                journey.setNumberofzones((resultset.getInt("ticketprice")) / PRICE_ONE_ZONE_ADULT); // calculate number of Zones
                journey.setStarttime(resultset.getTimestamp("datetimestamp").toString().substring(0, 16)); // 2014-11-19 15:44:09.630 format returned from database
                journeyArray.add(journey);
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return journeyArray;

        
        
        
    }
//</editor-fold>    
//</editor-fold>          
    //<editor-fold defaultstate="collapsed" desc="RouteplannerJourneyManager">

         
    @Override              //Objects may be defined as a modelclass Stop[]
    public Stop[] SetupGraph() {
       

        int speed;
        ArrayList<StopLink>[] stopLinkArr;
        
        this.query = SQLLibrary.ROUTEPLANNER_GET_SPEEDBOUND;
        
        System.err.println("executeQuery!!");
        this.parameters = new ArrayList();
        executeQuery();
        ArrayList<Stop> stopArr = new ArrayList();
        try {
            if (resultset.next()){
            speed = resultset.getInt(1);
            this.query=SQLLibrary.ROUTEPLANNER_GET_STOP;
            executeQuery();
            while (resultset.next()) { // itterates through lines to create stops
                stopArr.add(new Stop(resultset.getString(1), resultset.getInt(2), (long) resultset.getInt(3), (long) resultset.getInt(4), speed));
                //System.err.println(stopArr[i].name+" "+stopArr[i].zoneNumber+" "+stopArr[i].longitude+" "+stopArr[i].latitude);
            }
            stopLinkArr = new ArrayList[stopArr.size()];
            for (int i = 0; i < stopArr.size(); i++) {
                stopLinkArr[i] = new ArrayList<>(); // if no array exsists yet, make one
            }
            this.query = SQLLibrary.ROUTEPLANNER_GET_STOPLINK;
            executeQuery();
            
            
            while (resultset.next()) { // itterates through lines to create links
                String type = resultset.getString(1);
                String line = resultset.getString(2);
                Stop parent = stopArr.get(resultset.getInt(3) - 1);
                Stop stop = stopArr.get(resultset.getInt(4) - 1);
                Stop towards = stopArr.get(resultset.getInt(5) - 1);

                // add the link to the arrayarray list in the array with index toStop
                stopLinkArr[resultset.getInt(3) - 1].add(new StopLink(type, line, parent, stop, towards));
            //System.err.println("index "+(rs.getInt(3) - 1));
                //System.err.println("type: "+rs.getString(1)+" line"+rs.getString(2)+parent.name+" "+stop.name+" "+towards.name);
              }
            
             for (int i = 0; i < stopLinkArr.length; i++) {
               if (stopLinkArr[i] != null) {
                   StopLink[] currStopLinkArr = stopLinkArr[i].toArray(new StopLink[stopLinkArr[i].size()]);
                   stopArr.get(i).links = currStopLinkArr;
                }
            
            
             }
        }}
        catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        // convert arraylist toarray
        Stop[] stopArr2 = new Stop[stopArr.size()];
        stopArr2 = stopArr.toArray(stopArr2);
        
        return stopArr2;
    }

    
    
    //</editor-fold> 
    
    
    
    //<editor-fold defaultstate="collapsed" desc="JourneyManager">
    @Override
    public TicketList createNewTickets(PassengerList pLst) {     //the check for existing tickets is handled by the JourneyManager 
         ArrayList<Object> parameters = new ArrayList<>();
         this.query = SQLLibrary.CREATE_TICKET; 
         int zone = pLst.getZone();
         int zonecount = 2;          // Start with a minimum of 2 zones
         
        ArrayList<Integer> passengers = pLst.getAllPassengers();
        for (Integer passenger : passengers) {      
            parameters.add(PRICE_ONE_ZONE_ADULT * zonecount);
            parameters.add(zone);           
            parameters.add(zonecount);            
            parameters.add(passenger);            
            this.parameters = parameters;
            executeUpdate();
            parameters.clear();
        }
        return getExistingTickets(pLst); 
    }
 
    
    @Override
    public TicketList getExistingTickets(PassengerList pLst) {
    TicketList usort = getTickets(pLst);    
    ArrayList<Ticket> unchecked = usort.getAllTickets(); 
    TicketList returnTicketList = new TicketList();    
    
        for (Ticket t : unchecked) { 
            try {
                Ticket checked = validate(t, pLst);
                if (checked != null)  returnTicketList.addSingleTicket(checked);          
            }
            catch (SQLException ex) {ex.printStackTrace();
            }    
        }   
    return returnTicketList;
    }
 
    
     //<editor-fold defaultstate="collapsed" desc="getTickets">
                    
                    private TicketList getTickets(PassengerList pLst){
                        this.query = SQLLibrary.SYSTEM_GET_TICKETLIST;
                        ArrayList<Object> parameters = new ArrayList<>();
                        ArrayList<Integer> passengers = pLst.getAllPassengers();
                        
                        TicketList returnTicketList = new TicketList();
                        for (Integer passenger : passengers) {
                            parameters.add(passenger);
                            this.parameters = parameters;
                            executeQuery();
                            
                            try {
                                while (resultset.next()) {
                                    Ticket t = new Ticket();
                                    t.createTicket(
                                            resultset.getInt("ticketnumber"),
                                            resultset.getTimestamp("datetimestamp").toString().substring(0, 19), // 2014-11-19 15:44:09.630 format returned from database
                                            resultset.getInt("ticketprice"),
                                            resultset.getInt("startzone"),
                                            resultset.getInt("zonecount"),
                                            resultset.getInt("customer")
                                    );
                                }
                            }
                            catch (SQLException ex) {ex.printStackTrace();                            
                            }                            
                            parameters.clear();
                        }
                        
                        return returnTicketList;
                        
                        
                    }
                    
//</editor-fold> 
     //<editor-fold defaultstate="collapsed" desc="Validate Ticket">
    private Ticket validate(Ticket t, PassengerList pLst) throws SQLException{
        
        if (!validateTicketTime(t)){  // move invalid ticket to history using transaction
            try {
                //0. Enable Transaction
                con.setAutoCommit(false);
                
                //1. Store Ticket t in JourneyHistroy on the database
                ArrayList<Object> input = new ArrayList<>();
                this.query = SQLLibrary.TRANSFER_TICKET_TO_HISTORY;
                
                input.add(t.getNumber());           // ticketnumber
                input.add(t.getTimestamp());        // datetimestamp
                input.add(t.getPrice());            // ticketprice
                input.add(t.getStartZone());        // startzone
                input.add(t.getZoneCount());        // zonecount
                input.add(t.getCustomerNumber());   // customer
                
                this.parameters = input;
                executeUpdate();
                
                //2. Remove Ticket t from Ticket on the database
                this.query = SQLLibrary.DELETE_TICKET;
                input.clear();
                input.add(t.getNumber());
                this.parameters = input;
                executeQuery();
                
                //3. Commit to transaction
                con.commit();
            }
            catch (Exception e) {con.rollback(); System.err.println("Rollback error");}
            
            //4. Disable Transaction
            con.setAutoCommit(true);
            return null;            
        }
        
        else if (!validateTicketZone(t, pLst.getZone())){       
              //Ticket Zone is invalid... update ticket:                        
                updateTicket(t);              
        }
        return t;       // Return valid ticket
        
    }    
    
//</editor-fold> 
     //<editor-fold defaultstate="collapsed" desc="validateTicketTime">
    
// Method for validating a ticket based on its time of purchase and zone amount
// Return: false is invalid tikcet time, true is valid ticket time
    private boolean validateTicketTime(Ticket ticket){
        int zc = ticket.getZoneCount();
        System.out.println("" + zc);        
        
        int tm = Integer.parseInt(ticket.getTimestamp().substring(11, 13));
        tm = tm * 60 + Integer.parseInt(ticket.getTimestamp().substring(14, 16));
        tm = tm * 60 + Integer.parseInt(ticket.getTimestamp().substring(17, 19));
        // tm is ticket creation time in seconds
        
        // new SQL query use instead --> this.query = SQLLibrary.GET_TIME; // To get the server time 
        
//        dbConnect();        
//        Statement stm = con.createStatement();
//        stm.execute(SQLLibrary.GET_TIME);
//        String time = stm.getResultSet().getString("timetz");
                
                
        int ct = 60 * 60 * Calendar.getInstance().get(Calendar.HOUR_OF_DAY); // current hours in seconds
        ct = ct + 60 * Calendar.getInstance().get(Calendar.MINUTE); //  current hours in seconds + current minutes in seconds
                
        boolean answer;
        switch (zc) {
            case 2: if (ct - tm >  3600) {answer = false; break;} // 60 min
            case 3: if (ct - tm >  4500) {answer = false; break;} // 75 min
            case 4: if (ct - tm >  5400) {answer = false; break;} // 90 min
            case 5: if (ct - tm >  6300) {answer = false; break;} // 105 min
            case 6: if (ct - tm >  7200) {answer = false; break;} // 120 min
            case 7: if (ct - tm >  8100) {answer = false; break;} // 135 min
            case 8: if (ct - tm >  9000) {answer = false; break;} // 150 min
            case 9: if (ct - tm >  9900) {answer = false; break;} // 165 min
            default: answer = true;		   // pass - ticket is valid
        }
        return answer;
    }
    
//</editor-fold>    
     //<editor-fold defaultstate="collapsed" desc="validateTicketZone">
    private static boolean validateTicketZone(Ticket ticket, int zone) {
        int zc = ticket.getZoneCount();    // get zone count zc from ticket
        int sz = ticket.getStartZone();    // get start zone sz from ticket
        int zn = zone;                     // get zone number zn from passengers
        int d = zdc.getDistance(sz, zn);   //  calculate distance d from sz to zn  
        return (d <= zc);     
    }
//</editor-fold>    
     //<editor-fold defaultstate="collapsed" desc="updateTicket">    
    private Ticket updateTicket(Ticket t){
      
        ArrayList<Object> input = new ArrayList<>();
        this.query = SQLLibrary.UPDATE_TICKET;
        input.add(t.getZoneCount()+1);                   // ++zoneCount
        input.add(t.getPrice()+ PRICE_ONE_ZONE_ADULT);   // price += 1200
        input.add(t.getNumber());                        // ticketnumber
        this.parameters = input;
        executeUpdate();
        
        t.setZoneCount(t.getZoneCount()+1);                       // should be set by a call to the database
        t.setPrice(t.getPrice()+ PRICE_ONE_ZONE_ADULT);
        
        return t;
    }    
//</editor-fold>  
                 
                    
     //<editor-fold defaultstate="collapsed" desc="Create a Customer object from a ResultSet">
                    
                    /**
                     * Create a Customer object from a ResultSet containing a customer's data.
                     *
                     * @param resultSet containing the found data from the database.
                     * @return a Customer object holding all the data.
                     * @throws SQLException if the method tries to access a column that isn't
                     * found in the ResultSet.
                     */
                    private Customer createCustomer(ResultSet resultSet) {
                        try {
                            Customer jDoe = new Customer();
                            jDoe.setCustomerNumber(Integer.parseInt(resultSet.getString("CustomerNumber")));
                            jDoe.setFirstname(resultSet.getString("FirstName"));
                            jDoe.setLastname(resultSet.getString("LastName"));
                            jDoe.setEmail(resultSet.getString("Email"));
                            jDoe.setPassword(resultSet.getString("Password"));
                            // resultSet.getString("status");                               // may have no use
                            //   jDoe.setTotalRecords(resultSet.getString("TotalRecords"));        // field still missing in modelclass
                            return jDoe;
                        }
                        catch (SQLException ex) {
                            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        return null;
                    }
                    
//</editor-fold>
    
      
    //</editor-fold>

 
    
    
} 

    
    


    
 
    //<editor-fold defaultstate="collapsed" desc="Snippet 3">
    //         PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
    //                                     SET SALARY = ? WHERE ID = ?");
    //   pstmt.setBigDecimal(1, 153833.00)
    //   pstmt.setInt(2, 110592)
        //</editor-fold>
    // //<editor-fold defaultstate="collapsed" desc="Snippet 4">
    //    
    //    @Override
    //    public TicketList createNewTickets(PassengerList pLst) {      
    //         ArrayList<Object> parameters = new ArrayList<>();
    //         this.query = SQLLibrary.CREATE_TICKET; 
    //         int zone = pLst.getZone();
    //         ArrayList<Integer> passengers = pLst.getAllPassengers(); 
    //         
    //         
    //          TicketList check = getExistingTickets(pLst); // check if ticket exists
    //         
    //         
    //         
    //        //  for (int i = 0; i < passengers.size(); i++) System.out.println(passengers.get(i).toString());
    //        for (Integer passenger : passengers) {
    //            System.out.println(passenger.toString());
    //            parameters.add(PRICE_ONE_ZONE_ADULT); // ticket price for one zone adult
    //            parameters.add(zone);       // zone **********************
    //            parameters.add(passenger);
    //            
    //            System.out.println(parameters.toString());
    //            
    //            executeUpdate();
    //            parameters.clear();
    //            
    //        }
    //         
    //        //should a price field in the old tickets be added to the sql database to enable prize and zone calculation if and when the ticket prize is changed
    //        
    //        
    //        
    //        
    //        
    //        
    //        
    //         
    //         
    ////        
    ////        
    ////         parameters.addAll((Collection<? extends Object>) passengers);
    ////        
    ////         
    ////         
    ////         
    ////         
    ////         //evt use sql trans action here.........
    ////        
    ////        ListIterator itr = passengers.listIterator();
    ////        
    ////         while(itr.hasNext()){   // not a effecient solution, consider improvement
    ////            parameters.clear();
    ////            parameters.add(PRICE_ONE_ZONE_ADULT); // ticket price for one zone adult
    ////            parameters.add(zone);       // zone
    ////            parameters.add(itr.next());           // add customer   (integer customer number)     
    ////            
    ////            // check to se if passenger is allready active
    ////            
    ////            executeUpdate();           
    ////         }
    ////         
    //         
    //         
    //         
    //         TicketList returnTicketList = new TicketList();      //return select * from ticket where zone = ?    
    //         parameters.clear();
    //         this.query = SQLLibrary.SYSTEM_GET_TICKETLIST;
    //         parameters.add(zone);
    //         executeQuery();
    //         
    //         
    //              try {
    //            
    //            while (resultset.next()) {
    //                Ticket t = new Ticket();
    //                 
    //                t.createTicket(
    //                    resultset.getInt("ticketnumber"),
    //                    resultset.getTimestamp("datetimestamp").toString().substring(0, 16), // 2014-11-19 15:44:09.630 format returned from database
    //                    resultset.getInt("ticketprice"),
    //                    resultset.getInt("startzone"),
    //                    resultset.getInt("customer")
    //                ); 
    //                
    //                returnTicketList.addSingleTicket(t);
    //                
    //      
    //            }
    //            
    //        }
    //        catch (SQLException ex) {
    //            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
    //        }
    //       
    //         
    //        return returnTicketList;
    //      
    //    }
    //    
    //    
    //    
    //    
    //    
    //    //</editor-fold>             


