package Manager;
import SQLConn.ConnectionManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDaemon extends Thread {
    
    private Connection        con;    
    private ResultSet         resultset;
    private PreparedStatement pStmt, pStmt2;
    private boolean           errFlag     = false;  // if error SLEEP_SHORT and retry
    private static final int  SLEEP_LONG  = 900000; // sleep 15 min    
    private static final int  SLEEP_SHORT = 60000;  // sleep  1 min 
    //<editor-fold defaultstate="collapsed" desc="SQL String: Fetch Expired Tickets ">/** 
    private static final String GET_EXPIRED_TICKETS =  "SELECT * FROM ticket WHERE "
    + "   (current_timestamp - ticket.datetimestamp) > '1 hour  00 minutes' AND ticket.zonecount = 2 " 
    + "OR (current_timestamp - ticket.datetimestamp) > '1 hour  15 minutes' AND ticket.zonecount = 3 "
    + "OR (current_timestamp - ticket.datetimestamp) > '1 hour  30 minutes' AND ticket.zonecount = 4 "
    + "OR (current_timestamp - ticket.datetimestamp) > '1 hour  45 minutes' AND ticket.zonecount = 5 "
    + "OR (current_timestamp - ticket.datetimestamp) > '2 hours 00 minutes' AND ticket.zonecount = 6 "
    + "OR (current_timestamp - ticket.datetimestamp) > '2 hours 15 minutes' AND ticket.zonecount = 7 "
    + "OR (current_timestamp - ticket.datetimestamp) > '2 hours 30 minutes' AND ticket.zonecount = 8 "
    + "OR (current_timestamp - ticket.datetimestamp) > '2 hours 45 minutes' AND ticket.zonecount = 9 ";
    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="SQL String: Create a Ticket in JourneyHistory ">
     private static final String TRANSFER_TICKET_TO_HISTORY= "INSERT INTO "
     + "JourneyHistory (ticketnumber, datetimestamp, ticketprice, startzone, zonecount, customer)  "
     + "VALUES (?,?,?,?,?,?)";              
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="SQL String: Delete a ticket from the Ticket table">
     private static final String DELETE_TICKET= "DELETE FROM "
     + "ticket * "
     + "WHERE ticketnumber = ? ";   
     //</editor-fold>    
     
    @Override
    public void run() {   
        System.out.println("Database daemon unleashed...");        
    while (true){
    
//RETRY:    
       try      {if (!errFlag) Thread.sleep(SLEEP_LONG);
                else           Thread.sleep(SLEEP_SHORT);       
                connect();           if (errFlag) continue; //break RETRY;                
                getExpiredTickets(); if (errFlag) continue; //break RETRY;   
                transferTicket();}
       
       catch    (Exception e) {System.out.println("Demon says err");
                e.printStackTrace(); this.errFlag = true;}
       
       finally  {this.errFlag = false;
                if (con != null) {try {con.close();}
                catch (SQLException e) {e.printStackTrace();
                this.errFlag = true;}
            }
        } // finally     
     } // while (true)   
 } // run  
           
    private void connect()           {
        try {
              if (this.con == null || this.con.isClosed()) 
                  this.con = ConnectionManager.createConnection();       
               // Assume a valid connection object con
                  con.setAutoCommit(false);
            }
       catch (Exception e) {this.errFlag = true;}
    }    
    private void getExpiredTickets() {
            
        try {Statement getExpiredTickets  = con.createStatement();
             getExpiredTickets.execute(GET_EXPIRED_TICKETS);      
             this.resultset = getExpiredTickets.getResultSet();
             con.commit();   
        }
        
        catch (SQLException ex) {this.errFlag = true;
            try    {con.rollback();} // rollback
            catch (Exception exx) {exx.printStackTrace();}}               
    }
    private void transferTicket()    {
       String time = getTime();
        try   
        {
             while (resultset.next()) 
             {                   
                    pStmt = con.prepareStatement(TRANSFER_TICKET_TO_HISTORY);                
                    pStmt.setInt(1, resultset.getInt("ticketnumber"));
                    pStmt.setString(2, resultset.getTimestamp("datetimestamp").toString());
                    pStmt.setInt(3, resultset.getInt("ticketprice"));   
                    pStmt.setInt(4, resultset.getInt("startzone"));
                    pStmt.setInt(5, resultset.getInt("zonecount"));
                    pStmt.setInt(6, resultset.getInt("customer"));
                    pStmt.executeUpdate();
                                       
                    pStmt2 = con.prepareStatement(DELETE_TICKET);
                    pStmt2.setInt(1, resultset.getInt("ticketnumber"));                   
                    pStmt2.executeUpdate();
                    
                    System.out.println(time + " ...Transferred old ticket with ticket number: " + resultset.getInt("ticketnumber"));
                    
                    con.commit();
             }               
        }
         catch (SQLException ex) { 
                ex.printStackTrace();
                this.errFlag = true;
                try {con.rollback();} catch (SQLException ex1) {ex1.printStackTrace();}}           
    }
    private String getTime()         {
    
        try {
             
            Statement getTime  = con.createStatement();
            getTime.execute("SELECT current_timestamp");
            ResultSet time = getTime.getResultSet();
            con.commit();
            time.next();
            return time.getString("now").substring(11, 19);     //  2014-11-30 03:42:11.260
        }
        catch (SQLException ex) {ex.printStackTrace();
        }
     return "";
    }
    
    
}  //class DatabaseDemon

//<editor-fold defaultstate="collapsed" desc="Snippet">
//
//Thread t1 = new Thread(new Runnable() {
//public void run() {
//// code goes here.
//}
//});
//t1.start();
//</editor-fold>