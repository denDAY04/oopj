/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import SQLDatabase.Managers.CustomerManager;
import SQLDatabase.Managers.DatabaseManager;
import SQLDatabase.ModelClasses.Customer;
import java.awt.CardLayout;

/**
 *
 * @author Qess
 */
public class GUIFrame extends javax.swing.JFrame {

    private CardLayout cardLayout;
    protected CustomerManager cManager;
    DatabaseManager dbManager;
    /**
     * Creates new form GUIFrame
     */
    public GUIFrame() {
        initComponents();
        cardLayout = new CardLayout();
        dbManager = new DatabaseManager();
        cManager = new CustomerManager();
        cManager.setDatabaseManager(dbManager);
        
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
    }
    
    
    
    public void changePanel(String panel){
        cardLayout.show(cards, panel);
        if(panel.equals("card2")){
            accountPanel.loadCustomerDetails();
        } else if(panel.equals("card8")){
            editAccountPanel.loadCustomerDetails();
        }
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
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
    private GUI.Test.AccountPanel accountPanel;
    private GUI.Test.AddFundsPanel addFundsPanel;
    private javax.swing.JPanel cards;
    private GUI.Test.ChangePasswordPanel changePasswordPanel;
    private GUI.Test.EditAccountPanel editAccountPanel;
    private GUI.Test.ForgotPassPanel forgotPassPanel;
    private GUI.Test.LoginControllerPanel loginControllerPanel;
    private GUI.Test.PasswordFoundPanel passwordFoundPanel;
    private GUI.Test.SignupCongratulationsPanel signupCongratulationsPanel;
    private GUI.Test.SignupPanel signupPanel;
    private GUI.Test.TransactionHistoryPanel transactionHistoryPanel;
    // End of variables declaration//GEN-END:variables

}
