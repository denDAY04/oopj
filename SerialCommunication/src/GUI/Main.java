/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;

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

        controller = new Controller();
        
        controller.setCustomerModel(model);
        controller.setAccountView(view.getAccountViewPanel());
        
        view.getLoginControllerPanel().setController(controller);
        
        view.setVisible(true);
    }
    
}
