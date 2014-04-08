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


    EventManager eventManager; // OBS Should get a refrence to this from the main class
    // add terminal
    // edit terminal
    // find terminal
    public void connectionFailed(String destination) {
        ArrayList<String> parametersTerminal = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        parametersTerminal.add(destination);   // add the cardnumber parameter
            System.out.println("TerminalManager connectionFailed, Fire SQL statement");
            int result = DatabaseManager.updateQuery(SQLLibrary.SYSTEM_TERMINALS_SET_OFFLINESINCE,parametersTerminal);
            System.out.println("result: " + result);
    }

    public void connectionSuccessful(String destination) {
        System.out.println("enter connectionSuccessful");
        // Set OfflineSince to Online, when connection is established.
        ArrayList<String> parametersTerminal = new ArrayList();
        parametersTerminal.add(destination);
        int result = DatabaseManager.updateQuery(SQLLibrary.SYSTEM_TERMINALS_RESET_OFFLINESINCE,parametersTerminal);
        System.out.println("TerminalManager connectionSuccessful, Fire SQL statement");
        System.out.println("result: " + result);
    }

    }
    