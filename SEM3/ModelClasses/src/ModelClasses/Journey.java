package ModelClasses;


import java.io.Serializable;

/**
 * Journey Model Class. 
 * This model class represents a previous journey logged in the system.
 * It is used to communicate data from the backend to the journey history bean.
 * @author Rasmus
 */

public class Journey implements Serializable {
    
    public Journey() {
    }
    
    int startzone = 0;
    int numberofzones = 0;
    int price =0;
    String starttime;

    /**
     * Getter of the Start zone of the journey
     * @return
     */
    public int getStartzone() {
        return startzone;
    }

    /**
     * Setter of the Start zone of the journey
     * @param startzone
     */
    public void setStartzone(int startzone) {
        this.startzone = startzone;
    }

    /**
     * Getter of the number of zone in the journey
     * @return
     */
    public int getNumberofzones() {
        return numberofzones;
    }

    /**
     * Setter of the number of zone in the journey
     * @param numberofzones
     */
    public void setNumberofzones(int numberofzones) {
        this.numberofzones = numberofzones;
    }

    /**
     * Getter for the price of the journey
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for the price of the journey
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for the start time of the journey
     * @return
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * Setter for the start time of the journey
     * @param starttime
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    
 
}