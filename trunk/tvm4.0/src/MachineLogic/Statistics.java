package MachineLogic;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Statistics
{

ArrayList<Ticket> logStatsArray = new ArrayList<Ticket>();
ArrayList<Ticket> dayStatsArray = new ArrayList<Ticket>();

private int moneyDay=0;
private int moneyTotal=0;
private int ticketsTotal=0;
private int ticketNumber=0;
private int ticketsDay=0;
private int inkLeft=1000;
private int paperLeft=1000;

public Statistics (){}
     /**
     * Update all variables and arrays for a printed ticket .
     * @param t
     * @throws java.lang.Exception
     */
	public void LogSale(Ticket t, int hardID) throws Exception
    {
        this.logStatsArray.add(t);
		ticketsTotal = ticketsTotal + t.getAmountTickets();
		moneyTotal = moneyTotal + (t.getZones()*t.getPricePerZone()*t.getAmountTickets());
		this.dayStatsArray.add(t);
		moneyDay = moneyDay + (t.getZones()*t.getPricePerZone()*t.getAmountTickets());
		ticketsDay = ticketsDay + t.getAmountTickets();
		--paperLeft;
		--inkLeft;
                
                
                
                if (new File("tvm.log").exists() == false) 
                {
                   PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter("tvm.log",true))); 
                   java.util.Date date = new java.util.Date();
                   String ts = new Timestamp(date.getTime()).toString().substring(0,16);
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
                    log.println("  Maskin ID: " + hardID);
                    log.println("  Zone: " + t.getStartZone()       );
                    log.println(" ===============================  ");
                    log.println("                                  ");
                    log.println("                                  ");
                    log.close();
                 }
      PrintWriter log = new PrintWriter(new BufferedWriter(new FileWriter("tvm.log",true)));           
      log.println(""+t.getTimeStamp() + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        
      log.close();
       
    }
    
    /**
    * Update paper and ink variables for test prints.   .
    */
        public void testPrint()
        {
	--paperLeft;
	--inkLeft;        
        }
        
         
       /**
        * Show the total sales log.   .
        */
	public ArrayList<String> getLog()
	{
        ArrayList<String> tempArr = new ArrayList<>();
        for(Ticket t : logStatsArray)
        {
            tempArr.add(""+t.getTimeStamp() + " - fra zone " + t.getStartZone() + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        }
        return tempArr;
    }
	/**
        * Show the daily total sales log.   .
        */
	public ArrayList<String> getDayLog()
	{
        ArrayList<String> tempArr = new ArrayList<>();
        for(Ticket t : dayStatsArray)
        {
			tempArr.add(t.getTimeStamp() + " - fra zone " + t.getStartZone() + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        }
        return tempArr;
        }
        /**
     * ink variable accessor method.
     * @return
     */
	public int CheckInk()
	{
		return inkLeft;
	}
        /**
        * ink variable reset method.
        */	
	public void ResetInk()
	{
		inkLeft = 1000;
	}
        /**
     * paper variable accessor method.
     * @return
     */
	public int CheckPaper()
	{
		return paperLeft;
	}
        /**
        * paper variable reset method.
        */		
	public void ResetPaper()
	{
		paperLeft = 1000;
	}
	/**
     * Daily money accessor method.
     * @return
     */
	public int MoneyDay()
	{
		return moneyDay;
	}
	/**
     * Total money accessor method.
     * @return
     */
	public int MoneyTotal()
	{
		return moneyTotal;
	}
	/**
     * Daily tickets accessor method.
     * @return
     */
	public int TicketSoldDay()
	{
		return ticketsDay;
	}
	/**
     * Total tickets accessor method.
     * @return
     */
	public int TicketSoldTotal()
	{
		return ticketsTotal;
	}
	/**
        * Daily tickets reset method.
        */	
	public void ResetDayStatistics()
	{
		moneyDay = 0;
		ticketsDay = 0;
		this.dayStatsArray.clear();
	}
        
        /**
     * unique ticket ID accessor method.
     * @return
     */	
        public int getTicketNumber()
        {
        ticketNumber = ticketNumber+1;
        
        return ticketNumber;
        }
        
}