/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import SQLDatabase.Managers.*;
import java.awt.CardLayout;

/**
 *
 * @author Qess
 */
public class GUIFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private boolean isLoggedIn = false;
    
    /**
     * Used for detailed view of a despoit instance. The history panel needs to
     * change this field before calling changePanel, in order to collect the 
     * correct data.
     */
    private String activeDepositNumber;
    
    /**
     * Used for detailed view of a billing instance. The history panel needs to
     * change this field before calling changePanel, in order to collect the 
     * correct data.
     */
    private String activeBillingNumber;
    
    protected CustomerManager cManager;
    protected DatabaseManager dbManager;
    protected BillingManager bManager;
    protected DepositManager depManager;
    protected TerminalManager tManager; 
    
    /**
     * Creates new form GUIFrame
     */
    public GUIFrame() {
        initComponents();
        cardLayout = new CardLayout();
        dbManager = new DatabaseManager();
        cManager = new CustomerManager();
        bManager = new BillingManager();
        depManager = new DepositManager();
        tManager = new TerminalManager();
        cManager.setDatabaseManager(dbManager);
        bManager.setDatabaseManager(dbManager);
        depManager.setDatabaseManager(dbManager);
        tManager.setDatabaseManager(dbManager);
        
        
        loginControllerPanel.setFrame(this);
        accountPanel.setFrame(this);
        signupPanel.setFrame(this);
        addFundsPanel.setFrame(this);
        signupCongratulationsPanel.setFrame(this);
        forgotPassPanel.setFrame(this);
        passwordFoundPanel.setFrame(this);
        editAccountPanel.setFrame(this);
        changePasswordPanel.setFrame(this);
        transactionHistoryPanel.setFrame(this);
        controlPanel.setFrame(this);
        loginAsPanel.setFrame(this);
        accountAdminPanel.setFrame(this);
        creditDebitAccountPanel.setFrame(this);
        addFundsUserPanel.setFrame(this);
        editAccountAdminPanel.setFrame(this);
        changePasswordAdminPanel.setFrame(this);
        transactionHistoryAdminPanel.setFrame(this);
        terminalListAdminPanel.setFrame(this);
        terminalListPanel.setFrame(this);
        transactHisDepositDetailsPanel.setFrame(this);
        transactHisBillingDetailsPanel.setFrame(this);
        cards.setLayout(cardLayout);
        cards.add(loginControllerPanel, "card1");
        cards.add(accountPanel, "card2");
        cards.add(signupPanel, "card3");
        cards.add(addFundsPanel, "card4");
        cards.add(signupCongratulationsPanel, "card5");
        cards.add(forgotPassPanel, "card6");
        cards.add(passwordFoundPanel, "card7");
        cards.add(editAccountPanel, "card8");
        cards.add(changePasswordPanel, "card9");
        cards.add(transactionHistoryPanel, "card10");
        cards.add(controlPanel, "card11");
        cards.add(loginAsPanel, "card12");
        cards.add(accountAdminPanel, "card13");
        cards.add(creditDebitAccountPanel, "card14");
        cards.add(addFundsUserPanel, "card15");
        cards.add(editAccountAdminPanel, "card16");
        cards.add(changePasswordAdminPanel, "card17");
        cards.add(transactionHistoryAdminPanel, "card18");
        cards.add(terminalListAdminPanel, "card19");
        cards.add(terminalListPanel, "card20");
        cards.add(transactHisDepositDetailsPanel, "card21");
        cards.add(transactHisBillingDetailsPanel, "card22");
    }
    
    
    
    public void changePanel(String panel){
        
        if(panel.equals("card2")){
            updateUser();
            accountPanel.loadCustomerDetails();
            //cardLayout.show(cards, panel);
        } else if(panel.equals("card7")){
            passwordFoundPanel.loadCustomerDetails();
            //cardLayout.show(cards, panel);
        } else if(panel.equals("card8")){
            editAccountPanel.loadCustomerDetails();
            //cardLayout.show(cards, panel);
        } else if(panel.equals("card16")){
            editAccountAdminPanel.loadCustomerDetails();
            //cardLayout.show(cards, panel);
        } else if(panel.equals("card13")){
            updateUser();
            accountAdminPanel.loadCustomerDetails();
            //cardLayout.show(cards, panel);
        } else if(panel.equals("card5") && isLoggedIn == true){
            updateUser();
            accountPanel.loadCustomerDetails();
            cardLayout.show(cards, "card2");
            return;
        } else if(panel.equals("card5") && isLoggedIn == false){
            //cardLayout.show(cards, panel);
        }else if (panel.equals("card19")){
            terminalListAdminPanel.loadTerminalDetails();
            //cardLayout.show(cards, panel);
        }else if (panel.equals("card10")){
            transactionHistoryPanel.loadTransactionsDetails();
            //cardLayout.show(cards, panel);
        }else if(panel.equals("card20")) {
            terminalListPanel.loadTerminalDetails();
            //cardLayout.show(cards, panel);
        }else if (panel.equals("card21")) {
            transactHisDepositDetailsPanel.loadDepositDetails(activeDepositNumber);
            //cardLayout.show(cards, panel);
        }else if (panel.equals("card22")) {
            transactHisBillingDetailsPanel.loadBillingDetails(activeBillingNumber);
            //cardLayout.show(cards, panel);
        }
//        } else{
//            cardLayout.show(cards, panel);
//        }
        cardLayout.show(cards, panel);
    }
    
    public void setLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
    
    public void setActiveDepositNumber(String newNumber) {
        activeDepositNumber = newNumber;
    }
    
    public void setActiveBillingNumber(String newNumber) {
        activeBillingNumber = newNumber;
    }
    
    private void updateUser(){
        String customerNumb = cManager.getLoggedInUser().getCustomerNumb();
        cManager.updateLoggedInCustomer(customerNumb);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();
        loginControllerPanel = new GUI.Test.LoginControllerPanel();
        accountPanel = new GUI.Test.AccountPanel();
        signupPanel = new GUI.Test.SignupPanel();
        addFundsPanel = new GUI.Test.AddFundsPanel();
        signupCongratulationsPanel = new GUI.Test.SignupCongratulationsPanel();
        forgotPassPanel = new GUI.Test.ForgotPassPanel();
        passwordFoundPanel = new GUI.Test.PasswordFoundPanel();
        editAccountPanel = new GUI.Test.EditAccountPanel();
        changePasswordPanel = new GUI.Test.ChangePasswordPanel();
        transactionHistoryPanel = new GUI.Test.TransactionHistoryPanel();
        controlPanel = new GUI.Test.ControlPanel();
        loginAsPanel = new GUI.Test.LoginAsPanel();
        accountAdminPanel = new GUI.Test.AccountAdminPanel();
        creditDebitAccountPanel = new GUI.Test.CreditDebitAccountPanel();
        addFundsUserPanel = new GUI.Test.AddFundsUserPanel();
        editAccountAdminPanel = new GUI.Test.EditAccountAdminPanel();
        changePasswordAdminPanel = new GUI.Test.ChangePasswordAdminPanel();
        transactionHistoryAdminPanel = new GUI.Test.TransactionHistoryAdminPanel();
        terminalListAdminPanel = new GUI.Test.TerminalListAdminPanel();
        terminalListPanel = new GUI.Test.TerminalListPanel();
        transactHisDepositDetailsPanel = new GUI.Test.TransactHisDepositDetailsPanel();
        transactHisBillingDetailsPanel = new GUI.Test.TransactHisBillingDetailsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cards.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        cards.add(loginControllerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 430));
        cards.add(accountPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 207, -1));
        cards.add(signupPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(addFundsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(signupCongratulationsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));
        cards.add(forgotPassPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 440));
        cards.add(passwordFoundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 440));
        cards.add(editAccountPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(changePasswordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactionHistoryPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(controlPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(loginAsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(accountAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(creditDebitAccountPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(addFundsUserPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(editAccountAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(changePasswordAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactionHistoryAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(terminalListAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(terminalListPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisDepositDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisBillingDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 521, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Test.AccountAdminPanel accountAdminPanel;
    private GUI.Test.AccountPanel accountPanel;
    private GUI.Test.AddFundsPanel addFundsPanel;
    private GUI.Test.AddFundsUserPanel addFundsUserPanel;
    private javax.swing.JPanel cards;
    private GUI.Test.ChangePasswordAdminPanel changePasswordAdminPanel;
    private GUI.Test.ChangePasswordPanel changePasswordPanel;
    private GUI.Test.ControlPanel controlPanel;
    private GUI.Test.CreditDebitAccountPanel creditDebitAccountPanel;
    private GUI.Test.EditAccountAdminPanel editAccountAdminPanel;
    private GUI.Test.EditAccountPanel editAccountPanel;
    private GUI.Test.ForgotPassPanel forgotPassPanel;
    private GUI.Test.LoginAsPanel loginAsPanel;
    private GUI.Test.LoginControllerPanel loginControllerPanel;
    private GUI.Test.PasswordFoundPanel passwordFoundPanel;
    private GUI.Test.SignupCongratulationsPanel signupCongratulationsPanel;
    private GUI.Test.SignupPanel signupPanel;
    private GUI.Test.TerminalListAdminPanel terminalListAdminPanel;
    private GUI.Test.TerminalListPanel terminalListPanel;
    private GUI.Test.TransactHisBillingDetailsPanel transactHisBillingDetailsPanel;
    private GUI.Test.TransactHisDepositDetailsPanel transactHisDepositDetailsPanel;
    private GUI.Test.TransactionHistoryAdminPanel transactionHistoryAdminPanel;
    private GUI.Test.TransactionHistoryPanel transactionHistoryPanel;
    // End of variables declaration//GEN-END:variables

}
