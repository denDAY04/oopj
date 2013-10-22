package MachineLogic;
import Interface.UserInterface;
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
private UserInterface UserInt;

public Statistics (UserInterface UserInt)
{
this.UserInt=UserInt;
}
     /**
     * Update all variables and arrays for a printed ticket .
     * @param t
     */
	public void LogSale(Ticket t)
    {
        this.logStatsArray.add(t);
		ticketsTotal = ticketsTotal + t.getAmountTickets();
		moneyTotal = moneyTotal + (t.getZones()*t.getPricePerZone()*t.getAmountTickets());
		this.dayStatsArray.add(t);
		moneyDay = moneyDay + (t.getZones()*t.getPricePerZone()*t.getAmountTickets());
		ticketsDay = ticketsDay + t.getAmountTickets();
		--paperLeft;
		--inkLeft;
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
	public void ShowLog()
	{
        for(Ticket t : logStatsArray)
        {
			UserInt.printLn(t.getTimeStamp() + "- fra zone " + t.getStartZone() + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        }
    }
	/**
        * Show the daily total sales log.   .
        */
	public void ShowDayLog()
	{
        for(Ticket t : dayStatsArray)
        {
			UserInt.printLn(t.getTimeStamp() + "- fra zone " + t.getStartZone() + ", " + t.getZones() + "-zoner, " + t.getPricePerZone() + "kr. pr zone. " + t.getTypeDA() + " "+ t.getTypeENG() + " " + t.getAmountTickets()+" stk.");
        }
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