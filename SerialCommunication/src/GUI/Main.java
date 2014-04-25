/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;
import SQLDatabase.Managers.TerminalManager;
import SerialCom.controller.EventManager;
import SerialCom.protocol.ProjectPacket;
import SerialCom.serial.SerialTransceiver;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qess
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        GUIFrame view;
        CustomerManager model = new CustomerManager();
        DatabaseManager databaseManager = new DatabaseManager();
        model.setDatabaseManager(databaseManager);         // customer needs databasemanager
        Controller controller;
        
        view = new GUIFrame();
//        model = new CustomerManager();
        controller = new Controller();
        
        controller.setCustomerModel(model);
        controller.setAccountView(view.getAccountViewPanel());
        
        view.getLoginControllerPanel().setController(controller);
        
        view.setVisible(true);
    }
    
}
