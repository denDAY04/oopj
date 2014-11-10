package BuisnessLogic;

import java.util.ArrayList;


/**
 * {Insert class description here}
 * 
 * @author Andreas Stensig Jensen, on Nov 10, 2014
 * Contributors: 
 */
public class IPThreadNameSearchTest {

    private String name = "128.138.43.102";
    
    
    public String name() {
        return name;
    }
    
    public static void main(String[] args) {
        ArrayList<IPThreadNameSearchTest> arrList = new ArrayList<>();
        long timeBegin, timeEnd;
        
        for (int i = 0 ; i != 500; ++i) {
            arrList.add(new IPThreadNameSearchTest());
        }
        
        
        String target = "128.138.43.103";
        timeBegin = System.nanoTime();
        for (IPThreadNameSearchTest e : arrList) {
            if (e.name().equals(target)) {
                System.out.println("Target found.");
                break;
            }
        }
        timeEnd = System.nanoTime();
        System.out.println("Time: " + (timeEnd - timeBegin) + " ns");
        
    }
    
}
