package ModelClasses;
import java.io.Serializable;

public class Ticket implements Serializable {
    
    private int ticketNumber;
    private int ticketPrice;    
    private int startZone;
    private int dateTimeStamp;  //SQL TIMESTAMP DEFAULT current_timestamp,  ?????
    
    
    public Ticket(int ticketNumber, int ticketPrice,           
                  int startZone,    int dateTimeStamp){
    
        this.ticketNumber  = ticketNumber;
        this.ticketPrice   = ticketPrice;
        this.startZone     = startZone;
        this.dateTimeStamp = dateTimeStamp;
    }
    
    
    public int getticketNumber() {return ticketNumber;}
    public void setticketNumber(String email) {this.ticketNumber = ticketNumber;}
    
    public int getticketPrice() {return ticketPrice;}
    public void setticketPrice(String email) {this.ticketPrice = ticketPrice;}
    
    public int getstartZone() {return startZone;}
    public void setstartZone(String email) {this.startZone = startZone;}
    
    public int getdateTimeStamp() {return dateTimeStamp;}
    public void setdateTimeStamp(String email) {this.dateTimeStamp = dateTimeStamp;}

    
    
    @Override
    public String toString() {
        return "Ticket{" + "ticketNumber=" + ticketNumber + ", ticketPrice=" + ticketPrice + ", startZone=" + startZone + ", dateTimeStamp=" + dateTimeStamp + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ticketNumber;
        hash = 37 * hash + this.ticketPrice;
        hash = 37 * hash + this.startZone;
        hash = 37 * hash + this.dateTimeStamp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.ticketNumber != other.ticketNumber) {
            return false;
        }
        if (this.ticketPrice != other.ticketPrice) {
            return false;
        }
        if (this.startZone != other.startZone) {
            return false;
        }
        if (this.dateTimeStamp != other.dateTimeStamp) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
}






