/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;
import SQLDatabase.Managers.TerminalManager;
import SerialCom.protocol.ProjectPacket;
import SerialCom.controller.EventManager;
import SerialCom.serial.SerialTransceiver;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Qess
 */
public class TestMainHardware {

    public static void main(String[] args) {

        EventManager eventManager = new EventManager();
        CustomerManager customerManager = new CustomerManager();
        DatabaseManager databaseManager = new DatabaseManager();
        TerminalManager terminalManager = new TerminalManager();

        customerManager.setDatabaseManager(databaseManager);         // customer needs databasemanager

        terminalManager.setDatabaseManager(databaseManager);         // terminal manager needs EventManager & DatabaseManager
        terminalManager.setEventManager(eventManager);

        eventManager.setCustomerManager(customerManager);         // event manager needs customerManager & terminalManager
        eventManager.setTerminalManager(terminalManager);

        //Construct another SerialTransceiver for the RFIDEventManager
        SerialTransceiver transceiver = new SerialTransceiver(
                new ProjectPacket(), eventManager);
        //Set the transmitter for the RFIDManagerSimple
        eventManager.setTransmitter(transceiver);

        System.out.println("TestMain: open port:");
        try {
            eventManager.openPort();
        } catch (TooManyListenersException ex) {
            Logger.getLogger(TestMainHardware.class.getName()).log(Level.SEVERE,
                    null,
                    ex);
        }

        while (true) {}  // can test ping terminals function

        //eventManager.closePort();
        //rFIDReaderSimpleSimulator.closePort();
    }
}
