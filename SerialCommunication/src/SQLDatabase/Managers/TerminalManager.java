/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLDatabase.Managers;

import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import SerialCom.controller.EventManager;
import SerialCom.protocol.ProjectPacket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;


/**
 *
 * @author Qess
 */
public class TerminalManager {
    Timer pingTimer =new Timer(500, new TimerListener());  // resend request pingTimer. Set hardware dependent timeout here.
    Timer pingSchedule =new Timer(60000, new TimerListener2()); // delay between pings. Should be 8 hours. Is one minute
    static int i=0;

    EventManager eventManager; // OBS Should get a refrence to this from the main class

    public TerminalManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }
    // add terminal
    // edit terminal
    // find terminal
    public static void connectionFailed(String destination) {
        ArrayList<String> parametersTerminal = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        parametersTerminal.add(destination);   // add the cardnumber parameter
            System.out.println("TerminalManager connectionFailed, Fire SQL statement");
            int result = DatabaseManager.updateQuery(SQLLibrary.SYSTEM_TERMINALS_SET_OFFLINESINCE,parametersTerminal);
            System.out.println("result: " + result);
    }

    public static void connectionSuccessful(String destination) {
        System.out.println("enter connectionSuccessful");
        // Set OfflineSince to Online, when connection is established.
        ArrayList<String> parametersTerminal = new ArrayList();
        parametersTerminal.add(destination);
        int result = DatabaseManager.updateQuery(SQLLibrary.SYSTEM_TERMINALS_RESET_OFFLINESINCE,parametersTerminal);
        System.out.println("TerminalManager connectionSuccessful, Fire SQL statement");
        System.out.println("result: " + result);
    }

   public void startPingSchedule() {
    System.err.println("Terminal Manager startPingSchedule, Starting first Ping cycle.");       
    pingTimer.start();         // pings stations on start of system
    pingSchedule.start();      // schedules ping timer to run in 6 hours.
    }

         public  class TimerListener2 implements ActionListener {  // ping schedule timer, ping all terminals every 6 hours
        public synchronized void actionPerformed(ActionEvent e) {
        System.err.println("Terminal Manager TimerListener2, Starting Ping cycle.");
        pingTimer.start();
        }}
   
      public  class TimerListener implements ActionListener {  // ping delay timer, ping one terminal at a time
        public synchronized void actionPerformed(ActionEvent e) {  
            ArrayList<Terminal> terminals;
            ArrayList<String> Parameter = new ArrayList();
                   terminals = DatabaseManager.getTerminals(SQLLibrary.SYSTEM_GET_ALL_TERMINALS,Parameter);
                   System.err.println("size of array"+terminals.size());
                   System.err.println("TerminalManager TimerListener FireSQL PING!");
                   eventManager.pingEvent(terminals.get(i).getIpAddress()); 
                   System.err.println("TerminalManager TimerListener, PI, PING, "+terminals.get(i).getIpAddress()+" i: "+i);
                      // closePort();
                 i++;
                if (i >= terminals.size()){ 
                    i=0;
                    pingTimer.stop();
                }
        }
      }
    }
    