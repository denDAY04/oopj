package SQLDatabase.Managers;

import SQLDatabase.Library.SQLLibrary;
import SQLDatabase.ModelClasses.*;
import SerialCom.controller.EventManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Timer;

/**
 * Create, edit, and retrieve terminals in the database. This class also
 * observes the connection to the terminals by pinging them in intervals.
 */
public class TerminalManager {

    /* Resend request pingTimer. Set hardware dependent timeout here. */
    Timer pingTimer = new Timer(1800, new PingTimerListener());

    /* Delay between pings. Should be 8 hours. Is one minute */
    Timer pingSchedule = new Timer(60000, new PingScheduleListener());

    static int i = 0; // ping terminal counter
    static ArrayList<Terminal> terminals; // all terminals to be pinged
    EventManager eventManager;
    DatabaseManager databaseManager;

    /**
     * Setter for DatabaseManager reference.
     *
     * @param databaseManager DatabaseManager reference.
     */
    public void setDatabaseManager(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    /**
     * Setter for EventManager reference.
     *
     * @param eventManager EventManager reference.
     */
    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * Add a new terminal to the database. The terminal's install status and
     * charging status will be 'Pending deployment' and 'idle' respectively,
     * when initially added. These values will have to be changed separately.
     * See editTerminal.
     *
     * Note that no checks are made on the strings as to their values.
     *
     * @param road      The road address of the terminal.
     * @param zipCode   The zipcode of its area.
     * @param ipAddress The ip address used for communication to and from the
     *                  terminal.
     */
    public void addTerminal(String road, String zipCode, String ipAddress) {
        ArrayList<Object> parameters = new ArrayList();
        parameters.add(road);
        parameters.add(zipCode);
        parameters.add(ipAddress);
        databaseManager.updateQuery(SQLLibrary.ADMIN_ADD_NEW_TERMINAL,
                parameters);
    }

    /**
     * Edit the information of a terminal on the database. Depending on the
     * command parameter, not all of the parameters are used, and can therefore
     * potentially be left as NULL.
     *
     * @param terminalID     ID hardwareNumber of the terminal to be edited.
     *                       Must always be supplied.
     * @param command        Specifies what data needs to be changed through its
     *                       value. See list below:
     * <br>1: Set terminal offline (install and charging can be NULL)
     * <br>2: Set terminal online (install and charging can be NULL)
     * <br>3: Set charging status (install can be NULL)
     * <br>4: Set install status (charging can be NULL)
     * <br>
     * @param installStatus  Accepted values: "ENABLE", "DISABL", and "PENDEP".
     * @param chargingStatus Accepted values: "CHAR", "IDLE"
     */
    public void editTerminal(String terminalID, int command,
            String installStatus, String chargingStatus) {
        ArrayList<Object> parameters = new ArrayList();

        switch (command) {
            case 1:     // Set offline
                parameters.add(terminalID);
                databaseManager.updateQuery(
                        SQLLibrary.SYSTEM_TERMINAL_SET_OFFLINESINCE, parameters);
                break;
            case 2:     // Set online
                parameters.add(terminalID);
                databaseManager.updateQuery(
                        SQLLibrary.SYSTEM_TERMINAL_RESET_OFFLINESINCE,
                        parameters);
                break;
            case 3:     // Set charging status
                parameters.add(chargingStatus);
                parameters.add(terminalID);
                databaseManager.updateQuery(
                        SQLLibrary.SYSTEM_TERMINAL_CHARGE_STATUS, parameters);
                break;
            case 4:     // Set install status
                parameters.add(installStatus);
                parameters.add(terminalID);
                databaseManager.updateQuery(
                        SQLLibrary.ADMIN_SET_TERMINAL_INSTALLSTATUS, parameters);
                break;
            default:
                System.err.println(
                        "TerminalManager editTerminal: No suitible command found.");
        }
    }

    /**
     * Edit all information of a terminal except its ID number. This is used
     * from the administrator's view of the list of terminals.
     * <p>
     * CONSTRAINT: the order of the new values must follow as the list.
     * <li>Address
     * <li>Zip code
     * <li>Charging status
     * <li>OfflineSince
     * <li>IP address
     * <li>Install status
     * <br><br>
     *
     * @param newValues  Array of Strings with all the new values. See
     *                   constraint above.
     * @param terminalID ID number of the terminal to be edited.
     */
    public void editFullTerminal(String[] newValues, int terminalID) {
        ArrayList<Object> parameters = new ArrayList<Object>();
        parameters.addAll(Arrays.asList(newValues));
        parameters.add(terminalID);
        databaseManager.updateQuery(SQLLibrary.ADMIN_SET_TERMINAL_ALL_DETAILS,
                parameters);

        /* Check value of changed install status to determin what message to 
         send to the terminal */
        if (newValues[5].equals("DISABL")) {
            eventManager.sendResponse("DA", "", newValues[4]);
        } else if (newValues[5].equals("ENABLE")) {
            eventManager.sendResponse("EA", "", newValues[4]);
        }
    }

    /**
     * Get a terminal with a specific hardware number, from the database.
     *
     * @param terminalID the desired terminal's hardware number.
     *
     * @return a Terminal object; NULL if no match was found.
     */
    public Terminal getTerminal(String terminalID) {
        ArrayList<Object> parameter = new ArrayList();
        parameter.add(terminalID);
        Terminal terminal = null;
        ArrayList<Terminal> arr = databaseManager.getTerminals(
                SQLLibrary.SYSTEM_GET_TERMINAL, parameter);
        if (arr.isEmpty() == false) {
            terminal = arr.get(0);
        }
        return terminal;
    }

    /**
     * Get a terminal with a specific IP address, from the database.
     *
     * @param terminalIP the desired terminal's IP address.
     *
     * @return a Terminal object; NULL if no match was found.
     */
    public Terminal getTerminalByIP(String terminalIP) {
        ArrayList<Object> parameter = new ArrayList();
        parameter.add(terminalIP);
        Terminal terminal = null;
        ArrayList<Terminal> arr = databaseManager.getTerminals(
                SQLLibrary.SYSTEM_GET_TERMINAL_BY_IP, parameter);
        if (arr.isEmpty() == false) {
            terminal = arr.get(0);
        }
        return terminal;
    }

    /**
     * Get all terminals from the database.
     *
     * @return ab ArrayList of Terminal Objects.
     */
    public ArrayList<String[]> getAllTerminals() {
        ArrayList<Terminal> terminals;
        ArrayList<String[]> result = new ArrayList<String[]>();
        System.err.println("TerminalManager getAllTerminals : Fire SQL");
        terminals = databaseManager.getTerminals(
                SQLLibrary.SYSTEM_GET_ALL_TERMINALS, new ArrayList<Object>());
        if (terminals.isEmpty() == false) {
            for (int i = 0; i < terminals.size(); ++i) {
                String a = terminals.get(i).getHardwareNumb();
                String b = terminals.get(i).getRoad();
                String c = terminals.get(i).getZipCode();
                String d = terminals.get(i).getChargingStatus();
                String e = terminals.get(i).getOfflineSince();
                String f = terminals.get(i).getIpAddress();
                String g = terminals.get(i).getInstallStatus();
                result.add(new String[]{a, b, c, d, e, f, g});
            }
        }
        return result;
    }

    /**
     * Set the offline since-status of a terminal specified by IP address. The
     * value of the status will be changed to time-stamp of the moment it is
     * received in the server.
     *
     * @param terminalIP IP address of the terminal.
     */
    public void connectionFailed(String terminalIP) {
        ArrayList<Object> parametersTerminal = new ArrayList();
        parametersTerminal.add(terminalIP);
        System.out.println(
                "TerminalManager connectionFailed, Fire SQL statement");
        int result = databaseManager.updateQuery(
                SQLLibrary.SYSTEM_TERMINAL_SET_OFFLINESINCE, parametersTerminal);
        System.out.println("result: " + result);
    }

    /**
     * Set the offline since-status of a terminal specified by IP address. The
     * value of the status will be 'ONLINE'.
     *
     * @param terminalIP IP address of the terminal.
     */
    public void connectionSuccessful(String terminalIP) {
        System.out.println("enter connectionSuccessful");
        ArrayList<Object> parametersTerminal = new ArrayList();
        parametersTerminal.add(terminalIP);
        int result = databaseManager.updateQuery(
                SQLLibrary.SYSTEM_TERMINAL_RESET_OFFLINESINCE,
                parametersTerminal);
        System.out.println(
                "TerminalManager connectionSuccessful, Fire SQL statement");
        System.out.println("result: " + result);
    }

    /**
     * Start ping timers.
     */
    public void startPingSchedule() {
        System.err.println("Terminal Manager startPingSchedule, Starting first "
                + "Ping cycle.");
        pingTimer.start();         // pings stations on start of system
        pingSchedule.start();      // schedules ping timer to run in 6 hours.
    }

    /**
     * Set the charging status of a terminal.
     *
     * @param terminalID The Hardware number of the terminal.
     * @param status     The new status of the terminal.
     */
    public void setTerminalChargingStatus(String terminalID, String status) {
        ArrayList<Object> parameters = new ArrayList();  // make an ArrayList of the parameters for the sql statement.
        parameters.add(status);
        parameters.add(terminalID);
        System.err.
                println("TerminalManager setTerminalChargingStatus: fire SQL");
        databaseManager.updateQuery(SQLLibrary.SYSTEM_TERMINAL_CHARGE_STATUS,
                parameters);
    }
    
    /**
     * This PingTimerListener ensures that only one terminal is pinged at a time,
     * with the field of the outer class.
     * Approximately 1800 ms 
     */
    public class PingTimerListener implements ActionListener {

        public synchronized void actionPerformed(ActionEvent e) {
            if (i==0){
            terminals = databaseManager.getTerminals(
                    SQLLibrary.SYSTEM_GET_ALL_TERMINALS, new ArrayList<Object>());
            System.err.println("size of array" + terminals.size());
            }
            System.err.println("TerminalManager TimerListener FireSQL PING!");
            eventManager.pingEvent(terminals.get(i).getIpAddress());
            System.err.println("TerminalManager TimerListener, PI, PING, "
                    + terminals.get(i).getIpAddress() + " i: " + i);
            i++;
            if (i >= terminals.size()) {
                i = 0;
                pingTimer.stop();
            }
        }
    }

    
    /**
     * Starts the ping timer which then runs the 
     */
    public class PingScheduleListener implements ActionListener {  // ping schedule timer, ping all terminals every 6 hours

        public synchronized void actionPerformed(ActionEvent e) {
            System.err.println(
                    "Terminal Manager TimerListener2, Starting Ping cycle.");
            pingTimer.start();
        }
    }
}
