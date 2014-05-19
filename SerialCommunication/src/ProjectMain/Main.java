package ProjectMain;

import GUI.System.GUIFrame;
import SQLDatabase.Managers.*;
import SerialCom.controller.EventManager;
import SerialCom.protocol.ProjectPacket;
import SerialCom.serial.SerialTransceiver;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;



/**
 * Main class with main method for full integration testing. 
 * NOTE: Remember to in-comment out-commented lines when doing a full test of 
 * the system. If only testing GUI, all lines related to EventManger should be
 * out-commented due to automatic port detection otherwise failing. 
 * 
 * @author AndreasStensig
 */
public class Main {
    public static void main(String[] args) {
        
        
        
        
        /* Create managers */
        DatabaseManager databaseManager = new DatabaseManager();
        EventManager eventManager = new EventManager();  
        CustomerManager customerManager = new CustomerManager();
        TerminalManager terminalManager = new TerminalManager();
        BillingManager billingManager = new BillingManager();
        DepositManager depositManager = new DepositManager();
        
        /* Set the references between the managers */
        eventManager.setBillingManager(billingManager);
        eventManager.setCustomerManager(customerManager);
        eventManager.setTerminalManager(terminalManager);
        customerManager.setDatabaseManager(databaseManager);
        terminalManager.setDatabaseManager(databaseManager);
        terminalManager.setEventManager(eventManager);
        billingManager.setDatabaseManager(databaseManager);
        depositManager.setDatabaseManager(databaseManager);
        
        /* Create the GUI front-end */
        /* Set the Nimbus look and feel  - generated by Netbeans */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        GUIFrame gui = new GUIFrame();
        
        /* Set GUI references to managers */
        gui.setDatabaseManager(databaseManager);
        gui.setBillingManager(billingManager);
        gui.setCustomerManager(customerManager);
        gui.setDepositManager(depositManager);
        gui.setTerminalManager(terminalManager);
        
        gui.setVisible(true);
        
         //Construct another SerialTransceiver for the RFIDEventManager
        SerialTransceiver transceiver = new SerialTransceiver(
                new ProjectPacket(), eventManager);
        //Set the transmitter for the RFIDManagerSimple
        eventManager.setTransmitter(transceiver);

        System.out.println("TestMain: open port:");
        try {
            eventManager.openPort();
        } catch (TooManyListenersException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
                    null,
                    ex);
        }
        
       terminalManager.startPingSchedule();
                
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
