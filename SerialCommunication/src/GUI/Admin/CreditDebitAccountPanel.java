/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Admin;

import GUI.System.GUIFrame;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Qess
 */
public class CreditDebitAccountPanel extends javax.swing.JPanel {
    
    private GUIFrame frame;
    private int errors;
    /**
     * Creates new form ForgotPassControllerPanel
     */
    public CreditDebitAccountPanel() {
        initComponents();
        errors = 1;
    }

    public void setFrame(GUI.System.GUIFrame frame) {
        this.frame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitle = new javax.swing.JLabel();
        labAmount = new javax.swing.JLabel();
        textAmount = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnCreateDeposit = new javax.swing.JButton();
        cbCreditDebit = new javax.swing.JComboBox();
        labStatus = new javax.swing.JLabel();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setText("Credit/Debit Account");

        labAmount.setText("Amount (DKK)");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCreateDeposit.setText("Create Deposit");
        btnCreateDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateDepositActionPerformed(evt);
            }
        });

        cbCreditDebit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Credit", "Debit" }));
        cbCreditDebit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCreditDebitItemStateChanged(evt);
            }
        });

        labStatus.setText("Currently crediting account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCreditDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labAmount)
                    .addComponent(labTitle)
                    .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateDeposit)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labTitle)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCreditDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labStatus))
                .addGap(18, 18, 18)
                .addComponent(labAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCreateDeposit))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       frame.changePanel("card13");
       resetPage();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateDepositActionPerformed
        inputCheck();
        if (errors == 0){
            if(cbCreditDebit.getSelectedIndex() == 0){
                creditAccount();
                JOptionPane.showMessageDialog(this, "The account has been credited\n"+textAmount.getText()+" DKK");
                frame.changePanel("card13");
                resetPage();
            } else if(cbCreditDebit.getSelectedIndex() == 1){
                debitAccount();
                JOptionPane.showMessageDialog(this, "The account has been debited\n"+textAmount.getText()+" DKK");
                frame.changePanel("card13");
                resetPage();
            }   
        }
        errors = 1;
    }//GEN-LAST:event_btnCreateDepositActionPerformed

    private void cbCreditDebitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCreditDebitItemStateChanged
        if(cbCreditDebit.getSelectedIndex() == 0){
            labStatus.setText("Currently crediting account");
        } else{
            labStatus.setText("Currently debiting account");
        }
    }//GEN-LAST:event_cbCreditDebitItemStateChanged

    private void inputCheck(){
       if (!textAmount.getText().matches("\\d|\\d\\d|\\d\\d\\d|\\d\\d\\d\\d|\\d\\d\\d\\d\\d")){
            labAmount.setForeground(Color.RED);
        } else{
            labAmount.setForeground(Color.BLACK);
            errors--;
        } 
    }
    
    private void creditAccount() {
        int customerNumb = Integer.parseInt(frame.cManager.getLoggedInUser().getCustomerNumb());
        int amount = Integer.parseInt(textAmount.getText())*100;
        int newBalance = frame.cManager.getLoggedInUser().getBalance()+amount;
        int lastFourDigits = 4444;
        
        /* External reference number is for simulation purposes only. 
        Originally this numbers would be supplied by the 3rd-party banking 
        instituts. 
        */
        long randomNum = System.currentTimeMillis() * 13 * 29;
        String randomNumString = ("" + randomNum).substring(0, 6);
        int externalRefNumb = Integer.parseInt(randomNumString);
        
        /* Log deposit on database (also changes customer's balance) */
        Object[] data = {customerNumb, amount, newBalance, externalRefNumb, lastFourDigits};
        frame.depManager.registerDeposit(data);
    }
    
    private void debitAccount() {
        int customerNumb = Integer.parseInt(frame.cManager.getLoggedInUser().getCustomerNumb());
        int amount = Integer.parseInt(textAmount.getText())*100;
        int newBalance = frame.cManager.getLoggedInUser().getBalance()-amount;
        int lastFourDigits = 5555;
        
        /* External reference number is for simulation purposes only. 
        Originally this numbers would be supplied by the 3rd-party banking 
        instituts. 
        */
        long randomNum = System.currentTimeMillis() * 13 * 29;
        String randomNumString = ("" + randomNum).substring(0, 6);
        int externalRefNumb = Integer.parseInt(randomNumString);
        
        /* Log deposit on database (also changes customer's balance) */
        Object[] data = {customerNumb, amount, newBalance, externalRefNumb, lastFourDigits};
        frame.depManager.registerDeposit(data);
    }
    
    private void resetPage(){
       labAmount.setForeground(Color.BLACK);
       textAmount.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateDeposit;
    private javax.swing.JComboBox cbCreditDebit;
    private javax.swing.JLabel labAmount;
    private javax.swing.JLabel labStatus;
    private javax.swing.JLabel labTitle;
    private javax.swing.JTextField textAmount;
    // End of variables declaration//GEN-END:variables
}
