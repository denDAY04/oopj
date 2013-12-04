package Interface;
//Importing
import MachineLogic.*;
import PaymentModule.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
     * Creates new form tvmGUI
     */
    public tvmGUI() {
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
        Setup1Class.setReferences(Setup2Class);
        Setup2Class.setReferences(Setup1Class, WelcomeDAClass, AdminClass);
        WelcomeDAClass.setReferences(CartDAClass);
        CartDAClass.setReferences(WelcomeDAClass, PayDAClass);
        PayDAClass.setReferences(WelcomeDAClass, CartDAClass, CashDAClass, CardDAClass, SMSDAClass);
        CashDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        CardDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        SMSDAClass.setReferences(WelcomeDAClass, CartDAClass, PayDAClass);
        this.ListContent = new ArrayList<>();
        Date time = new Date();
        initComponents();
        ChangePanel(Setup1Class);
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
        // Call thread-method to watch terminal for integer inputs
        // Used for admin login
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(820, 630));
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//------------------------Methods for use in the GUI--------------------------
    /**
     * A Thread that keeps checking the terminal for integer inputs. 
     * If the input equals a specified password the program switches 
     * to the admin window. But only so if the active window is 
     * WelcomeDA.
     * 
     * If the input does not equal the specified password in the
     * adminPassword variable, or the active window is not Welcome DA,
     * error messages/instructions are written to theterminal.
     */
    public void adminLogIn() {
        Thread watchTerminal = new Thread() {
           public void run() {
               while (true) {   // Always rin
                if (terminalInput.nextInt() == adminPassword) {
                    // Only enable switching to admin if the active 
                    // screen is WelcomeDA.
                    if (!getContentPane().equals(WelcomeDAClass) == false) {     //Check om det nye udtryk passer istedet for
                                                                                //WelcomeDA.isVisible()
                        System.out.println("Skift til Velkomstvindue.");
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
                        // Switch to admin window
                        ChangePanel(AdminClass);
                    }
                } else {
                    // If input dows not equal the password
                    System.out.println("Forkert indput.");
                }
            }
           }
        };
        watchTerminal.start();
    }
    
    /**
     * Starts a thread that updates the time labels. 
     */
    private void startTimeThread() {
        Thread timeLabels = new Thread(){
            public void run() {
                while(true) {
                    Date time = new Date();
                    Setup2Class.LabSetup2Time.setText(time.toString().substring(0,19));
                    WelcomeDAClass.LabWelcomeDATime.setText(time.toString().substring(0,19));
                    CartDAClass.LabCartDATime.setText(time.toString().substring(0,19));
                    PayDAClass.LabPayDATime.setText(time.toString().substring(0,19));
                    CashDAClass.LabCashDATime.setText(time.toString().substring(0,19));
                    OutOfOrderClass.LabOutOfOrderTime.setText(time.toString().substring(0,19));
                    CardDAClass.LabCardDATime.setText(time.toString().substring(0,19));
                    SMSDAClass.LabSMSDATime.setText(time.toString().substring(0,19));
                    AdminClass.LabAdminTime.setText(time.toString().substring(0,19));
                }
            }
        };
        timeLabels.start();
    }
    
    /**
     * Checks on a string if it is an integer.
     * @param s String input to be checked for integers.
     * @return Returns the integer if any, or -1 if no integer found.
     */
    public int isInteger(String s)
    {
        int temp;
        try {
            temp = Integer.parseInt(s);        // Try make s to int
        } catch (NumberFormatException e) {    //catch exception - return error
            return -1;
        }
        if (temp < 0) {                     // invert negatives
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
    public void addTicketToListSetup2 (int PricePZ, String TypeDA, String TypeENG) {       
        Setup2Class.LabSetup2Error.setVisible(false);
        Setup2Class.LabSetup2ErrorList.setVisible(false);
        CT.addTicket(PricePZ, TypeDA, TypeENG, startZone);
        Setup2Class.InSetup2TypeDA.setText(""); Setup2Class.InSetup2TypeENG.setText(""); Setup2Class.InSetup2PricePZ.setText("");
        ListContent.add(TypeDA+", "+TypeENG+", "+PricePZ+", "+startZone);
        Setup2Class.ListSetup2TicketList.setListData(ListContent.toArray());
        WelcomeDAClass.CBWelcomeDAType.addItem(TypeDA);
    }
    
    /**
     * For Setup2 window. Check whether fields are empty (if Strings) or invalid zone price.
     * @param PricePZ -1 if not an int.
     * @param TypeDA  Error if empty.
     * @param TypeENG Error if empty.
     */
    public void checkFieldsSetup2 (int PricePZ, String TypeDA, String TypeENG) {
        if(PricePZ == -1)
        {
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2PricePZ.setForeground(Color.red);
        }
        else
        {
            Setup2Class.LabSetup2PricePZ.setForeground(Color.black);
        }
        if(TypeDA.equals(""))
        {
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2TypeDA.setForeground(Color.red);
        }
        else
        {    
            Setup2Class.LabSetup2TypeDA.setForeground(Color.black);
        }
        if (TypeENG.equals(""))
        {
            Setup2Class.LabSetup2Error.setVisible(true);
            Setup2Class.LabSetup2TypeENG.setForeground(Color.red);
        }
        else
        {
            Setup2Class.LabSetup2TypeENG.setForeground(Color.black);
        }
    }
    
    /**
     * Formate a string to be 15 characters long, by inserting spaces.
     * @param item String to be formated.
     * @return The formated string.
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
     * If error arises during printing a dialog window is opened.
     * @param window The JPanel from which the call is made. Is hidden if 
     * a printer error is encountered.
     */
    public void printTickets(JPanel window) {
        //Print all tickets in the basket
        for (int index=0;index<(SB.getCart().size());index++) {
            if (SB.printTicket(index,language,hardID)== false){      //if printing failed
                // Show dialog box with error message
                JOptionPane.showMessageDialog(this, 
                    "\nFejl"
                   + "\nDer opstod en fejl ved printning af en billet."
                   + "\nKontakt tekniker på tlf. xx xx xx xx og"
                   + "\nhusk dine returpenge."
                   + "\nVi beklager ulegligheden."
                   + "\n"
                   + "\nBlueJ Trakfikselskab","Teknisk fejl",
                JOptionPane.ERROR_MESSAGE);
                // Set info label and out-of-order variable
                OutOfOrderClass.LabOutOfOrderInfo.setText("Maskin ID: "+hardID+"  Zone:"+startZone);
                outOfOrder = true;
                // Go to out-of-order window
                //window.setVisible(false);
                //OutOfOrder.setVisible(true);
                ChangePanel(OutOfOrderClass);
                break;
            } else {
                // Send the ticket to the statistics module
                ST.LogSale(SB.getCart().get(index));
            }
        }
    }
    
    /**
     * Set the visibility of current JPanel to false, and true on the JPanel
     * that needs displaying next. 
     * @param currentWindow The Jpanel from which the method is called, and needs to be hidden.
     * @param nextWindow The JPanel that needs to be displayed next.
     */
    public void switchWindow(JPanel currentWindow, JPanel nextWindow) {
        currentWindow.setVisible(false);
        nextWindow.setVisible(true);
    }
    
    /**
     * Used to check input from admin in service window, and print
     * the appropriate text to the text field. 
     */
    public void adminWriteData() {
        int adminSelection;     // Variable to hold menu selection
        try {       // Make string to int.
            adminSelection = Integer.parseInt(AdminClass.InAdminSelection.getText());
        } catch (NumberFormatException e) {
            return;     // If input is not an integer, do nothing in program.
        }
        // Get data from Serice
        ArrayList<String> data = SV.getData(adminSelection);
        // Clear text area
        AdminClass.TextAdminLog.setText(null);
        //Check String elements in data-list
        for (String element : data) {
            // Check for keyword to set out of order
            switch (element) {
                case "OOO":
                    outOfOrder = true;
                    // Swtich to out-of-order window
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
     * Clears current contentpane of the <code>JFrame</code>, and add 
     * the <code>JPanel</code> from the call as the next panel to be shown.
     * 
     * @param Next Jpanel that should be shown next. 
     */
    public void ChangePanel(JPanel Next)
    {
        getContentPane().removeAll();
        add(Next);
        repaint();
    }
    
    /**
     * Creates a thread that waits for a given set of milliseconds before
     * executing. When executed, it creates a <code>Date</code> object to
     * capture the current time. 
     * 
     * By comparing it to a Date object in the master
     * tvmGUI class (updated at each movement of the mouse inside of the 
     * <code>JFrame</code>)it evaluates whether the difference in time exceeds a
     * limit given in the method call. If so, the program is returned to the
     * welcoming-<code>JPanel</code>, the shoppingbasket is cleared, and the
     * list in the Cart-JPanel is reset.
     * 
     * @param timeInactive The number of milliseconds that must have passed,
     * at the time of the thread execution, since the last mouse movement.
     * @param initDelay The initial delay (in milliseconds) from the creation
     * of the object to the first execution of the thread.
     * @param period  The period (in milliseconds) at which the thread will be
     * executed. 
     */
    public void runTimeOut(final int timeInactive, final int initDelay, final int period) {
        timeOutTimer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Date currectTime = new Date();
                if ((currectTime.getTime() - mouseMovedTime.getTime()) > timeInactive 
                        && !outOfOrder) { // do not timeout if out-of-order
                    ChangePanel(WelcomeDAClass);
                    resetSelectionScreen();
                    SB.clearCart();
                    CartContent.clear();
                    CartDAClass.ListCartDATicketList.setListData(CartContent.toArray());
                }
            }
        } // end annonymus TimerTask
        , initDelay, period);
    }
    
    /**
     * A mouse movement-listening that captures the current time at which
     * the mouse was moved inside of the frame, through a <code>Date</code> 
     * object.
     * 
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
    private Timer timeOutTimer = new Timer();
 
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
    // End of variables declaration//GEN-END:variables
}
