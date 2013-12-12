package MachineLogic;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Statistics {

    ArrayList<Ticket> logStatsArray = new ArrayList<Ticket>();
    ArrayList<Ticket> dayStatsArray = new ArrayList<Ticket>();

    private int moneyDay=0;
    private int moneyTotal=0;
    private int ticketsTotal=0;
    private int ticketNumber=0;
    private int ticketsDay=0;
    private int inkLeft=1000;
    private int paperLeft=1000;
    
    /**
     * Default constructor
     */
    public Statistics() {}
    
    /**
     * Write the statistics of a sale into a log file and also store them
     * in the filed variables.
     * <p>
     * The log file is found in the same foulder as the program, with the name
     * "tvm.log".
     * @param t The {@link Ticket} object which was sold.
     * @param hardID Int denoting the ID of the machine that sold the ticket(s).
     * @throws Exception If problems occour during opening of filestreams.
     */
    public void LogSale(Ticket t, int hardID) throws Exception {
        // Update statistics value
        logStatsArray.add(t);
        ticketsTotal = ticketsTotal + t.getAmountTickets();
        moneyTotal = moneyTotal + (t.getZones()*t.getPricePerZone()
                                                *t.getAmountTickets());
        dayStatsArray.add(t);
        moneyDay = moneyDay + (t.getZones()*t.getPricePerZone()
                                            *t.getAmountTickets());
        ticketsDay = ticketsDay + t.getAmountTickets();
        --paperLeft;
        --inkLeft;
        // If no log is found, create new file
        if (new File("tvm.log").exists() == false) {
            PrintWriter log = new PrintWriter(
                                new BufferedWriter(
                                 new FileWriter("tvm.log",true))); 
            java.util.Date date = new java.util.Date();
            String ts = new Timestamp(date.getTime()).toString().
                                substring(0,16);
            // Graphics for file header
            log.println("BJ2013LOG");  //magic number
            log.println("Log Setup Dato: "+ts);
            log.println(" ---------------------------------  ");
            log.println("|    ___  __   _  _  ___    __    | ");
            log.println(" )  (  ,)(  ) ( )( )(  _)  (  )  ( ");
            log.println("|    ) ,\\ )(__ )()(  ) _) __)(    | ");
            log.println(" )  (___/(____)\\__/ (___)(___/   ( ");
            log.println("|                                 | ");
            log.println(" ---------------------------------  ");
            log.println("                                  ");
            log.println(" BlueJ Salgs Statistik  2013(c)   ");
            log.println(" ===============================  ");
            log.println("  Maskin ID: " + hardID            );
            log.println("  Zone: " + t.getStartZone()       );
            log.println(" ===============================  ");
            log.println("                                  ");
            log.println("                                  ");
            log.close();
         }
        // Open filestream
        PrintWriter log = new PrintWriter(
                           new BufferedWriter(
                            new FileWriter("tvm.log",true)));
        // Log data
        log.println(""+t.getTimeStamp() + ", " + t.getZones() + "-zoner, " 
                + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "
                + t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        // Close filestream
        log.close();

    }

    /**
    * Should only be called when doing a test print.
    * <p>
    * Updates paper and ink variables with.   .
    */
    public void testPrint() {
       --paperLeft;
       --inkLeft;        
    }


    /**
     * Accessor method to get an ArrayList of Strings denoting all sales made
     * on the machine since last reboot.
     * @return ArrayList of String objects that each contains the statistics
     * of a sale of one instance of {@link Ticket}.
     */
    public ArrayList<String> getLog() {
        ArrayList<String> tempArr = new ArrayList<>();
        for(Ticket t : logStatsArray) {
            tempArr.add(""+t.getTimeStamp() + " - fra zone " + t.getStartZone() 
                    + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() 
                    + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() 
                    + " " + t.getAmountTickets()+" stk.");
        }
        return tempArr;
     }
       
    /**
     * Accessor method to get an ArrayList of Strings denoting daily sales made
     * on the machine since last service visit.
     * @return ArrayList of String objects that each contains the statistics
     * of a sale of one instance of {@link Ticket}.
     */
    public ArrayList<String> getDayLog() {
        ArrayList<String> tempArr = new ArrayList<>();
        for(Ticket t : dayStatsArray) {
            tempArr.add(t.getTimeStamp() + " - fra zone " + t.getStartZone() 
                    + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() 
                    + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() 
                    + " " + t.getAmountTickets()+" stk.");
        }
        return tempArr;
    }
    
    /**
     * Accessor method for the variable denoting ink left in the machine.
     * @return Int denoting remaining ink.
     */
    public int getInk() {return inkLeft;}

    /**
     * Resets the ink varaible to 1000-tickets capacity.
     */
    public void ResetInk() {inkLeft = 1000;}

    /**
     * Accessor method for the variable denoting the paper left in the machine.
     * @return Int denoting remaining paper.
     */
    public int getPaper() {return paperLeft;}

    /**
     * Resets the paper variable to 1000-tickets capacity.
     */
    public void ResetPaper() {paperLeft = 1000;}

    /**
     * Accessor method for the variable denoting the amount of money the 
     * machine has recieved since the last service visit.
     * @return Int denoting amount of money the machine currently contains.
     */
    public int getMoneyDay() {return moneyDay;}

    /**
     * Accessor method for the variable denoting the amount of money the
     * machine has recieved in total since the last reboot. 
     * @return Int denoting the amount of money the machine has contained 
     * overall.
     */
    public int getMoneyTotal() {return moneyTotal;}

    /**
     * Accessor method for the variable denoting the amount of tickets sold 
     * since the last service visit.
     * @return Int denoting the amount of ticket sold today.
     */
    public int getTicketSoldDay() {return ticketsDay;}

    /**
     * Accessor method for the variable denoting the amount of tickets sold
     * since the last reboot.
     * @return Int denoting the amount of tickets sold overall.
     */
    public int getTicketSoldTotal() {return ticketsTotal;}

    /**
     * Resets the daily statistics: this include the daily variables for money, 
     * amount of tickets sold, and the ArrayList of given {@link Ticket}
     * objects.
     */
    public void ResetDayStatistics(){
        moneyDay = 0;
        ticketsDay = 0;
        dayStatsArray.clear();
    }

    /**
     * Accessor method for the variable denoting a unique ID for a 
     * {@link Ticket}.
     * @return Int denoting the unique ID.
     */
    public int getTicketNumber(){
        ticketNumber = ticketNumber+1;
        return ticketNumber;
    }

}