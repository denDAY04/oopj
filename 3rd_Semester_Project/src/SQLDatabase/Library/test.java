

package SQLDatabase.Library;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;


public class test {

 
    public static void main(String[] args) {
       
    
        
    GregorianCalendar testtime = new GregorianCalendar(TimeZone.getTimeZone("Europe/Copenhagen"));
        
        System.out.println("getTime: " + testtime.getTime());    
        System.out.println("getFirstDayOfWeek: " + testtime.getFirstDayOfWeek()); 
        System.out.println("getTimeZone: " + testtime.getTimeZone()); 
        
        
        
    }
    
}
