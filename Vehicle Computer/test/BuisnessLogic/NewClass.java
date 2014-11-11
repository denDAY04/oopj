package BuisnessLogic;

/**
 * {Insert class description here}
 * 
 * @author Andreas Stensig Jensen, on Nov 11, 2014
 * Contributors: 
 */
public class NewClass {

    public static void main(String[] args) {
        long time1,time2;
        
        time1 = System.nanoTime();
        for (int i = 0; i != 10000000; ++i) {
            // Nothing.
        }
        time2 = System.nanoTime();
        
        System.out.println("Time: " + (time2 - time1));
    }
}
