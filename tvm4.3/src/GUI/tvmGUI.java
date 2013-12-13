package GUI;

import MachineLogic.*;
import PaymentModule.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 * Top-layer of the GUI class; meaning this class takes care of the 
 * communication between the different panels of the GUI. 
 */
public class tvmGUI extends javax.swing.JFrame {
    Setup1 Setup1Class;
    Setup2 Setup2Class;
    WelcomeDA WelcomeDAClass;
    CartDA CartDAClass;
    PayDA PayDAClass;
    CashDA CashDAClass;
    CardDA CardDAClass;
    SMSDA SMSDAClass; 
    OutOfOrder OutOfOrderClass;
    Admin AdminClass;
    
    /**
     * Custom constructor
     * <p>
     * It creates all the panels of the GUI and distributes references between
     * them. Furthermore it enables a separate thread for admin login through
     * the terminal, and it also initializes an action listener for timing 
     * out the machine to the welcoming screen.
     */
    public tvmGUI() {
        // Create panels
        Setup1Class = new Setup1(this);
        Setup2Class = new Setup2(this);
        WelcomeDAClass = new WelcomeDA(this); 
        CartDAClass = new CartDA(this);
        PayDAClass = new PayDA(this);
        CashDAClass = new CashDA(this);
        CardDAClass = new CardDA(this);
        SMSDAClass = new SMSDA(this);
        AdminClass = new Admin(this);
        OutOfOrderClass = new OutOfOrder(this);
        // Transfer references between panels
        Setup1Class.setReferences(Setup2Class);
        Setup2Class.setReferences(Setup1Class, WelcomeDAClass, AdminClass);
        WelcomeDAClass.setReferences(CartDAClass);
        CartDAClass.setReferences(WelcomeDAClass, PayDAClass);
        PayDAClass.setReferences(WelcomeDAClass, CartDAClass, CashDAClass
                , CardDAClass, SMSDAClass);
        CashDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        CardDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        SMSDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        ListContent = new ArrayList<>();
        initComponents();
        // test for manual setup
        if (manualSetup()) {
            /* In case some data had already been loaded by the time of 
            corruption, clear the existing tickets, and diactivate
            timeout timer.*/
            CT.ClearArray();
            timeOutTimer.cancel();
            // Initiate manual setup
            ChangePanel(Setup1Class);
        } else ChangePanel(WelcomeDAClass);
        
        // Initialize labels to be invisible
        Setup1Class.LabSetup1Error.setVisible(false);
        Setup2Class.LabSetup2Error.setVisible(false);
        Setup2Class.LabSetup2ErrorList.setVisible(false);
        // Initialize error labels to be empty/single space
        WelcomeDAClass.LabWelcomeDAError.setText(" ");
        WelcomeDAClass.LabWelcomeDATypeError.setText(" ");
        WelcomeDAClass.LabWelcomeDAZonesError.setText(" ");
        WelcomeDAClass.LabWelcomeDAAmountError.setText(" ");
        // Call thread-method to make time labels
        startTimeThread();  
        /* Call thread-method to watch terminal for integer inputs
          - used for admin login*/
        adminLogIn();
        // Add a mouse movement-actionlistener for use to timeout the machine
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPIC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 630));
        getContentPane().setLayout(new java.awt.CardLayout());

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        getContentPane().add(BackgroundPIC, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//------------------------Methods for use in the GUI--------------------------
    /**
     * This call tries to open a filestream to a tvm.setup file while will
     * then be used to set up the machine automatically, with predefined 
     * tickets in the file. 
     * @return True if a setupfile was not found, or an error occoured while
     * reading the file. False if a setupfile is successfully read and
     * its commands implemented.
     */
    @SuppressWarnings("unchecked")
    private boolean manualSetup() {
        try {
            FileInputStream fstream = new FileInputStream("tvm.setup");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read and set MachineID from file
            hardID = Integer.parseInt(br.readLine().trim()); 
            // Read StartZone from file
            startZone = Integer.parseInt(br.readLine().trim());
            // Read time-length required for timingout, from file
            int timeInactive = Integer.parseInt(br.readLine().trim());
            // Read time-length for initial delay of timeout check, from file
            int initDelay = Integer.parseInt(br.readLine().trim());
            // Read time-length for period at timeout check, from file
            int period = Integer.parseInt(br.readLine().trim());
            // Begin timeout checks
            runTimeOut(timeInactive, initDelay, period);
            // Read lines from the file
            while ((strLine = br.readLine()) != null) {
                String[] words = strLine.split(":");                  
                int PPZ = Integer.parseInt(words[0].trim());          
                String TDA = words[1].trim();                         
                String TEN = words[2].trim();     
                // Loading ticket into CT array
                CT.addTicket(PPZ, TDA, TEN, startZone);        
                // Loading ticket into list
                WelcomeDAClass.CBWelcomeDAType.addItem(TDA);   
            }
            // Close the input stream
            in.close();
            WelcomeDAClass.LabWelcomeDAInfo.setText("Machine ID: "+hardID
                    + "  Zone: "+startZone);
            return false;
        } catch (Exception e) {
            /* If an exception happens, the file was not loaded propperly, 
            and manual setup will be required.*/
            System.err.println("Error. Initiating manual setup.");
            return true;
        }
    }   
    
    /**
     * A Thread that keeps checking the terminal for integer inputs. 
     * If the input equals a specified password the program switches 
     * to the admin window. But only so if the active window is 
     * WelcomeDA.
     * <p>
     * If the input does not equal the specified password in the
     * adminPassword variable, or the active window is not Welcome DA,
     * error messages/instructions are written to theterminal.
     */
    private void adminLogIn() {
        Thread watchTerminal = new Thread() {
           public void run() {
               while (true) {   // Always run
                if (terminalInput.nextInt() == adminPassword) {
                    /* Only enable switching to admin if the active 
                     screen is WelcomeDA.*/
                    if (getContentPane().getComponent(0).equals(WelcomeDAClass) 
                            == false) {                                                       
                        System.err.println("Skift til Velkomstvindue.");
                    } else {
                        // Set text in menu field
                        AdminClass.TextAdminMenu.setText(
                            "Der kan fortages følgende valg:"
                            +"\n"
                            +"\n1 : Vis dagsstatistik "
                            +"\n2 : Skift billetrulle"
                            +"\n3 : Skift blækpatron"
                            +"\n4 : Udskriv og nulstil salgs statestik"
                            +"\n5 : Sæt ud af drift"
                            +"\n6 : Standard service besøg"
                            +"\n7 : Vis total statestik"
                            +"\n8 : Print test billet"
                            +"\n0 : Log ud"
                        );
                        // Reset input field in admin window
                        AdminClass.InAdminSelection.setText(null);
                        // Clear possible selected Tickets
                        resetSelectionScreen();
                        SB.clearCart();
                        CartContent.clear();
                        CartDAClass.ListCartDATicketList.setListData((String[]) 
                                CartContent.toArray(new String[0]));
                        // Switch to admin window
                        ChangePanel(AdminClass);
                    }
                } else {
                    // If input dows not equal the password
                    System.err.println("Forkert indput.");
                }
            }
           }
        };
        watchTerminal.start();
    }
    
    /**
     * Starts a thread that updates the time labels continuesly.
     */
    private void startTimeThread() {
        Thread timeLabels = new Thread(){
            public void run() {
                while(true) {
                    String time  = new Date().toString().substring(0,19);
                    Setup2Class.LabSetup2Time.setText(time);
                    WelcomeDAClass.LabWelcomeDATime.setText(time);
                    CartDAClass.LabCartDATime.setText(time);
                    PayDAClass.LabPayDATime.setText(time);
                    CashDAClass.LabCashDATime.setText(time);
                    OutOfOrderClass.LabOutOfOrderTime.setText(time);
                    CardDAClass.LabCardDATime.setText(time);
                    SMSDAClass.LabSMSDATime.setText(time);
                    AdminClass.LabAdminTime.setText(time);
                }
            }
        };
        timeLabels.start();
    }
    
    /**
     * Checks on a string if it is an integer.
     * @param s String input to be checked for integers.
     * @return The integer if any, or -1 if no integer is found.
     */
    public int isInteger(String s) {
        int temp;
        try {temp = Integer.parseInt(s);}
        // If error, return -1
        catch (NumberFormatException e) {return -1;}
        // Invert negatives
        if (temp < 0) {                  
            temp *= -1;
        }
        return temp; 
    }
    
    /**
     * For creation of tickets by adding them to an array of tickets, and array
     * of strings, and a Jlist displaying the Strings.
     * @param PricePZ Price per zone - integer.
     * @param TypeDA Name of ticket type in Danish - string.
     * @param TypeENG Name of ticket type in English - string.
     */
    @SuppressWarnings("unchecked")
    public void addTicketToListSetup2 (int PricePZ, String TypeDA
            , String TypeENG) {       
        Setup2Class.LabSetup2Error.setVisible(false);
        Setup2Class.LabSetup2ErrorList.setVisible(false);
        CT.addTicket(PricePZ, TypeDA, TypeENG, startZone);
        Setup2Class.InSetup2TypeDA.setText(""); 
        Setup2Class.InSetup2TypeENG.setText(""); 
        Setup2Class.InSetup2PricePZ.setText("");
        ListContent.add(TypeDA+", "+TypeENG+", "+PricePZ+", "+startZone);
        Setup2Class.ListSetup2TicketList.setListData(ListContent.toArray());
        WelcomeDAClass.CBWelcomeDAType.addItem(TypeDA);
    }
    
    /**
     * For Setup2 window. Check whether fields are empty (if Strings) or 
     * invalid zone price.
     * @param PricePZ -1 if not an int.
     * @param TypeDA  Error if empty.
     * @param TypeENG Error if empty.
     */
    public void checkFieldsSetup2 (int PricePZ, String TypeDA, String TypeENG) {
        if(PricePZ == -1){
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2PricePZ.setForeground(Color.red);
        } else {
            Setup2Class.LabSetup2PricePZ.setForeground(Color.black);
        }
        if(TypeDA.equals("")) {
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2TypeDA.setForeground(Color.red);
        } else {    
            Setup2Class.LabSetup2TypeDA.setForeground(Color.black);
        } 
        if (TypeENG.equals("")) {
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2TypeENG.setForeground(Color.red);
        } else {
            Setup2Class.LabSetup2TypeENG.setForeground(Color.black);
        }
    }
    
    /**
     * Formate a string to be 15 characters long, by inserting spaces.
     * @param item String to be formatted.
     * @return The formatted string.
     */
    public String fitToListCart(String item) {
        while (item.length() < 15) {
            item += " ";
        }
        return item;
    }
    
    /**
     * Resets the combo boxes in the WelcomeDA window, and set the 
     * error labels blank.
     */
    public void resetSelectionScreen() {
        // Reset Combo boxes
        WelcomeDAClass.CBWelcomeDAType.setSelectedIndex(0);
        WelcomeDAClass.CBWelcomeDAZone.setSelectedIndex(0);
        WelcomeDAClass.CBWelcomeDAAmount.setSelectedIndex(0);
        // Set error labes blank
        WelcomeDAClass.LabWelcomeDAAmountError.setText(" ");
        WelcomeDAClass.LabWelcomeDAError.setText(" ");
        WelcomeDAClass.LabWelcomeDATypeError.setText(" ");
        WelcomeDAClass.LabWelcomeDAZonesError.setText(" ");
    }
    
    /**
     * Prints the tickets in the shopping cart and updates statistics. 
     * If error arises during printing a dialog window is opened, after which
     * the machine is set out of order.
     */
    public void printTickets() {
        //Print all tickets in the basket
        int index = 0;
        for (Ticket element : SB.getCart()) {
            // If printing failed
            if (SB.printTicket(index,language,hardID)== false){
                // Show dialog box with error message
                JOptionPane.showMessageDialog(this, 
                    WelcomeDA.languageBundle.getString("FEJL")
                   + WelcomeDA.languageBundle.getString("DER OPSTOD EN FEJL VED PRINTNING AF EN BILLET.")
                   + WelcomeDA.languageBundle.getString("KONTAKT TEKNIKER PÅ TLF. XX XX XX XX OG")
                   + WelcomeDA.languageBundle.getString("HUSK DINE RETURPENGE.")
                   + WelcomeDA.languageBundle.getString("VI BEKLAGER ULEGLIGHEDEN.")
                   + "\n"
                   + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB")
                        , WelcomeDA.languageBundle.getString("TEKNISK FEJL"),
                JOptionPane.ERROR_MESSAGE);
                // Set info label and out-of-order variable
                OutOfOrderClass.LabOutOfOrderInfo.setText(WelcomeDA
                        .languageBundle.getString("MASKIN ID: ")+
                        hardID+WelcomeDA.languageBundle.
                                getString("  ZONE:")+startZone);
                // Go to out-of-order window
                outOfOrder = true;
                ChangePanel(OutOfOrderClass);
                break;
            } else {
                // Print successful
                try {
                    // Send the ticket to the statistics module
                    ST.LogSale(SB.getCart().get(index),hardID);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Der er opstået en fejl"
                            + "\nAn error has occurred", "ERROR"
                            , JOptionPane.ERROR_MESSAGE);
                    outOfOrder = true;
                    ChangePanel(OutOfOrderClass);
                }
            }
            index++;
        }
    }
    
    /**
     * Checks input from admin in service window, and print
     * the appropriate text to the text field. 
     */
    public void adminWriteData() {
        int adminSelection;  
        try {   
            adminSelection = Integer.parseInt(AdminClass.InAdminSelection
                    .getText());
        } catch (NumberFormatException e) {
            // If input is not an integer, do nothing in program.
            return; 
        }
        // Get data from Service
        ArrayList<String> data = SV.getData(adminSelection);
        // Clear text area
        AdminClass.TextAdminLog.setText(null);
        //Check String elements in data-list
        for (String element : data) {
            // Check for keyword to set out of order
            switch (element) {
                case "OOO":
                    // Swtich to out-of-order window
                    outOfOrder = true;
                    ChangePanel(OutOfOrderClass);
                    return;
                case "LO":
                    // Log out/Switch back to welcomming screen
                    ChangePanel(WelcomeDAClass);
                    return;
                default:
                    // Add text to area
                    AdminClass.TextAdminLog.append(element);
                    AdminClass.TextAdminLog.append("\n");      // linebreak
            }
        }
    }
    
    /**
     * Clears current contentpane of the JFrame, and adds 
     * the JPanel from the call as the next panel to be shown.
     * @param Next Jpanel that should be shown next. 
     */
    public void ChangePanel(JPanel Next) {
        getContentPane().removeAll();
        add(Next);
        repaint();
    }
    
    /**
     * Creates a thread that waits for a given set of milliseconds before
     * executing. When executed, it creates a {@link Date} object to
     * capture the current time. 
     * <p>
     * By comparing it to a Date object in the master
     * tvmGUI class (updated at each movement of the mouse inside of the 
     * JFrame) it evaluates whether the difference in time exceeds a
     * limit given in the method call. If so, the program is returned to the
     * welcomingpanel, the shoppingbasket is cleared, and the
     * list in the Cart-panel is reset.
     * @param timeInactive The number of milliseconds that must have passed,
     * at the time of the thread execution, since the last mouse movement.
     * @param initDelay The initial delay (in milliseconds) from the creation
     * of the object to the first execution of the thread.
     * @param period  The period (in milliseconds) at which the thread will be
     * executed. 
     */
    @SuppressWarnings("unchecked")
    public void runTimeOut(final int timeInactive, final int initDelay
            , final int period) {
        timeOutTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date currectTime = new Date();
                if ((currectTime.getTime() - mouseMovedTime.getTime()) 
                        > timeInactive && !outOfOrder) { // do not timeout if
                                                         //out-of-order
                    ChangePanel(WelcomeDAClass);
                    resetSelectionScreen();
                    SB.clearCart();
                    CartContent.clear();
                    CartDAClass.ListCartDATicketList.setListData((String[]) 
                            CartContent.toArray(new String[0]));
                }
            }
        } // end annonymus TimerTask
        , initDelay, period);
    }
    
    /**
     * A mouse movement-listening that captures the current time at which
     * the mouse was moved inside of the frame, through a {@link Date} 
     * object.
     * @param evt Mouse movement-event
     */
    private void formMouseMoved(MouseEvent evt) {
        mouseMovedTime = new Date();
    }
    
//---------------------Variables for use in the GUI---------------------------
    public Scanner terminalInput = new Scanner(System.in);
    public boolean adminPasswordCorret = false;
    public int adminPassword = 1337;
    public int hardID;
    public int startZone;
    public CreatedTickets CT = new CreatedTickets();
    public Statistics ST = new Statistics();
    public ShoppingBasket SB = new ShoppingBasket(CT, ST);
    public Service SV = new Service(ST, CT, SB);
    public Cash CH = null;
    public CreditCard CC = null;
    public paySMS SMS = null;
    public ArrayList<String> ListContent;
    public ArrayList<String> CartContent = new ArrayList<String>();
    public int amountZones = 0;
    public int amountTickets = 0;
    public int typePricePZ = 0;
    public int language = 1;   //1 danish; 2 english
    public boolean outOfOrder = false;
    private Date mouseMovedTime;
    private java.util.Timer timeOutTimer = new java.util.Timer();
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tvmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tvmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tvmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tvmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tvmGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundPIC;
    // End of variables declaration//GEN-END:variables
}