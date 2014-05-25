package GUI.System;

import SQLDatabase.Managers.*;
import java.awt.CardLayout;

/**
 * The JFrame of the GUI, and the controller/manager of the different panels.
 */
public class GUIFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;
    public CustomerManager cManager;
    public DatabaseManager dbManager;
    public BillingManager bManager;
    public DepositManager depManager;
    public TerminalManager tManager;


    /**
     * Used for detailed view of a deposit instance. The history panel needs to
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

    /**
     * Custom constructor.
     */
    public GUIFrame() {
        initComponents();
        cardLayout = new CardLayout();

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
        transactHisDepositDetailsAdminPanel.setFrame(this);
        transactHisBillingDetailsAdminPanel.setFrame(this);
        transactionManagementPanel.setFrame(this);

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
        cards.add(transactHisDepositDetailsAdminPanel, "card23");
        cards.add(transactHisBillingDetailsAdminPanel, "card24");
        cards.add(transactionManagementPanel, "card25");
    }

    /**
     * Setter for CustomerManager reference.
     *
     * @param cManager CustomerManager object.
     */
    public void setCustomerManager(CustomerManager cManager) {
        this.cManager = cManager;
    }

    /**
     * Setter for DatabaseManager reference.
     *
     * @param dbManager DatabaseManager object.
     */
    public void setDatabaseManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * Setter for BillingManager reference.
     *
     * @param bManager BillingManager object.
     */
    public void setBillingManager(BillingManager bManager) {
        this.bManager = bManager;
    }

    /**
     * Setter for DepositManager reference.
     *
     * @param depManager DepositManager object.
     */
    public void setDepositManager(DepositManager depManager) {
        this.depManager = depManager;
    }

    /**
     * Setter for TerminalManager reference.
     *
     * @param tManager TerminalManager object.
     */
    public void setTerminalManager(TerminalManager tManager) {
        this.tManager = tManager;
    }

    /**
     * Setter for the deposit number denoting the currently active deposit.
     *
     * @param newNumber deposit number.
     */
    public void setActiveDepositNumber(String newNumber) {
        activeDepositNumber = newNumber;
    }

    /**
     * Setter for the billing number denoting the currently active billing.
     *
     * @param newNumber billing number.
     */
    public void setActiveBillingNumber(String newNumber) {
        activeBillingNumber = newNumber;
    }

    /**
     * Change to a new panel in the CardLayout, and perform necessary method
     * calls, if any.
     *
     * @param panel the card name of the panel to switch to. See GUIFrame's
     *              constructor.
     */
    public void changePanel(String panel) {

        if (panel.equals("card2")) {
            updateUser();
            accountPanel.loadPage();
        } else if (panel.equals("card7")) {
            passwordFoundPanel.loadPage();
        } else if (panel.equals("card8")) {
            editAccountPanel.loadPage();
        } else if (panel.equals("card16")) {
            editAccountAdminPanel.loadPage();
        } else if (panel.equals("card12")) {
            loginAsPanel.loadPage();
        } else if (panel.equals("card13")) {
            updateUser();
            accountAdminPanel.loadPage();
        } else if (panel.equals("card19")) {
            terminalListAdminPanel.loadPage();
        } else if (panel.equals("card10")) {
            transactionHistoryPanel.loadPage();
        } else if (panel.equals("card18")) {
            transactionHistoryAdminPanel.loadPage();
        } else if (panel.equals("card20")) {
            terminalListPanel.loadPage();
        } else if (panel.equals("card21")) {
            transactHisDepositDetailsPanel.loadPage(activeDepositNumber);
        } else if (panel.equals("card22")) {
            transactHisBillingDetailsPanel.loadPage(activeBillingNumber);
        } else if (panel.equals("card23")) {
            transactHisDepositDetailsAdminPanel.loadPage(activeDepositNumber);
        } else if (panel.equals("card24")) {
            transactHisBillingDetailsAdminPanel.loadPage(activeBillingNumber);
        } else if (panel.equals("card25")) {
            transactionManagementPanel.loadPage();
        }

        cardLayout.show(cards, panel);
    }

    /**
     * Update the tracker of the currently logged in customer.
     */
    private void updateUser() {
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
        loginControllerPanel = new GUI.System.LoginControllerPanel();
        accountPanel = new GUI.User.AccountPanel();
        signupPanel = new GUI.System.SignupPanel();
        addFundsPanel = new GUI.System.AddFundsPanel();
        signupCongratulationsPanel = new GUI.System.SignupCongratulationsPanel();
        forgotPassPanel = new GUI.System.ForgotPassPanel();
        passwordFoundPanel = new GUI.System.PasswordFoundPanel();
        editAccountPanel = new GUI.User.EditAccountPanel();
        changePasswordPanel = new GUI.User.ChangePasswordPanel();
        transactionHistoryPanel = new GUI.User.TransactionHistoryPanel();
        controlPanel = new GUI.Admin.ControlPanel();
        loginAsPanel = new GUI.Admin.LoginAsPanel();
        accountAdminPanel = new GUI.Admin.AccountAdminPanel();
        creditDebitAccountPanel = new GUI.Admin.CreditDebitAccountPanel();
        addFundsUserPanel = new GUI.User.AddFundsUserPanel();
        editAccountAdminPanel = new GUI.Admin.EditAccountAdminPanel();
        changePasswordAdminPanel = new GUI.Admin.ChangePasswordAdminPanel();
        terminalListAdminPanel = new GUI.Admin.TerminalListAdminPanel();
        terminalListPanel = new GUI.User.TerminalListPanel();
        transactHisDepositDetailsPanel = new GUI.User.TransactHisDepositDetailsPanel();
        transactHisBillingDetailsPanel = new GUI.User.TransactHisBillingDetailsPanel();
        transactionHistoryAdminPanel = new GUI.Admin.TransactionHistoryAdminPanel();
        transactHisBillingDetailsAdminPanel = new GUI.Admin.TransactHisBillingDetailsAdminPanel();
        transactHisDepositDetailsAdminPanel = new GUI.Admin.TransactHisDepositDetailsAdminPanel();
        transactionManagementPanel = new GUI.Admin.TransactionManagementPanel();

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
        cards.add(terminalListAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(terminalListPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisDepositDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisBillingDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactionHistoryAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisBillingDetailsAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactHisDepositDetailsAdminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        cards.add(transactionManagementPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Admin.AccountAdminPanel accountAdminPanel;
    private GUI.User.AccountPanel accountPanel;
    private GUI.System.AddFundsPanel addFundsPanel;
    private GUI.User.AddFundsUserPanel addFundsUserPanel;
    private javax.swing.JPanel cards;
    private GUI.Admin.ChangePasswordAdminPanel changePasswordAdminPanel;
    private GUI.User.ChangePasswordPanel changePasswordPanel;
    private GUI.Admin.ControlPanel controlPanel;
    private GUI.Admin.CreditDebitAccountPanel creditDebitAccountPanel;
    private GUI.Admin.EditAccountAdminPanel editAccountAdminPanel;
    private GUI.User.EditAccountPanel editAccountPanel;
    private GUI.System.ForgotPassPanel forgotPassPanel;
    private GUI.Admin.LoginAsPanel loginAsPanel;
    private GUI.System.LoginControllerPanel loginControllerPanel;
    private GUI.System.PasswordFoundPanel passwordFoundPanel;
    private GUI.System.SignupCongratulationsPanel signupCongratulationsPanel;
    private GUI.System.SignupPanel signupPanel;
    private GUI.Admin.TerminalListAdminPanel terminalListAdminPanel;
    private GUI.User.TerminalListPanel terminalListPanel;
    private GUI.Admin.TransactHisBillingDetailsAdminPanel transactHisBillingDetailsAdminPanel;
    private GUI.User.TransactHisBillingDetailsPanel transactHisBillingDetailsPanel;
    private GUI.Admin.TransactHisDepositDetailsAdminPanel transactHisDepositDetailsAdminPanel;
    private GUI.User.TransactHisDepositDetailsPanel transactHisDepositDetailsPanel;
    private GUI.Admin.TransactionHistoryAdminPanel transactionHistoryAdminPanel;
    private GUI.User.TransactionHistoryPanel transactionHistoryPanel;
    private GUI.Admin.TransactionManagementPanel transactionManagementPanel;
    // End of variables declaration//GEN-END:variables

}
