package Beans;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Rasmus
 */
public class Journey implements Serializable{

    public Journey() {
    }
    
    int startzone = 0;
    int numberofzones = 0;
    int price =0;
    String starttime;

    public int getStartzone() {
        return startzone;
    }

    public void setStartzone(int startzone) {
        this.startzone = startzone;
    }

    public int getNumberofzones() {
        return numberofzones;
    }

    public void setNumberofzones(int numberofzones) {
        this.numberofzones = numberofzones;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    
    
}
