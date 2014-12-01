/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbean;



/**
 *
 * @author Rasmus
 */
public class test {
    int counter =0;

    public test() {
    }

    public String getCounter() {
        return "testname"+counter;
        
    }

    public void setCounter(String counter) {
        this.counter++;
    }
    
    
    
}
