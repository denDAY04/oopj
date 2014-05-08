/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import SQLDatabase.Managers.CustomerManager;

/**
 *
 * @author Qess
 */
public class AccountAdminPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    
    public AccountAdminPanel() {
        initComponents();
    }

    public void setFrame(GUIFrame frame) {
        this.frame = frame;
    }

    protected void loadCustomerDetails(){
        labCName.setText(frame.cManager.getLoggedInUser().getFirstName()+" "+
                         frame.cManager.getLoggedInUser().getLastName());
        labCEmail.setText(frame.cManager.getLoggedInUser().getEmail());
        labCCardNumber.setText(frame.cManager.getLoggedInUser().getCardNumb());
        labCBalance.setText(frame.cManager.getLoggedInUser().getBalance()*0.01+"");
        if(frame.cManager.getLoggedInUser().getAccountStatus().equals("PenApp")){
            labCAccStatus.setText("Pending Approval");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals("PenAct")){
            labCAccStatus.setText("Pending Activation");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals("Disabl")){
            labCAccStatus.setText("Disabled");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals("Active")){
            labCAccStatus.setText("Activated");
        }
        
        if(frame.cManager.getLoggedInUser().getUseStatus().equals("Char")){
            labCUseStatus.setText("Charging");
        } else if (frame.cManager.getLoggedInUser().getUseStatus().equals("Idle")){
            labCUseStatus.setText("Idle");
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

        labTitle = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        btnCreditDebit = new javax.swing.JButton();
        btnTransactionHistory = new javax.swing.JButton();
        labName = new javax.swing.JLabel();
        labCName = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        labCEmail = new javax.swing.JLabel();
        labCardNumber = new javax.swing.JLabel();
        labCCardNumber = new javax.swing.JLabel();
        labBalance = new javax.swing.JLabel();
        labCBalance = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labAccStatus = new javax.swing.JLabel();
        labCAccStatus = new javax.swing.JLabel();
        labUseStatus = new javax.swing.JLabel();
        labCUseStatus = new javax.swing.JLabel();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setText("Account Information");

        btnEdit.setText("Edit account details");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnChangePass.setText("Change password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        btnCreditDebit.setText("Credit/Debit account");
        btnCreditDebit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditDebitActionPerformed(evt);
            }
        });

        btnTransactionHistory.setText("Transaction history");
        btnTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionHistoryActionPerformed(evt);
            }
        });

        labName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labName.setText("Name");

        labCName.setText(" ");

        labEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labEmail.setText("Email");

        labCEmail.setText(" ");

        labCardNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labCardNumber.setText("Card number");

        labCCardNumber.setText(" ");

        labBalance.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labBalance.setText("Balance (DKK)");

        labCBalance.setText(" ");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Administrator view");

        labAccStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labAccStatus.setText("Account status");

        labCAccStatus.setText(" ");

        labUseStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labUseStatus.setText("Use status");

        labCUseStatus.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labTitle)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnTransactionHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCreditDebit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labName)
                                        .addComponent(labCName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labCardNumber)
                                        .addComponent(labCCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labEmail)
                                        .addComponent(labCEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labBalance)
                                        .addComponent(labCBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labAccStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labCAccStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labUseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labCUseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labName)
                        .addGap(6, 6, 6)
                        .addComponent(labCName)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChangePass)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labEmail)
                        .addGap(6, 6, 6)
                        .addComponent(labCEmail)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreditDebit)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labCardNumber)
                        .addGap(6, 6, 6)
                        .addComponent(labCCardNumber)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTransactionHistory)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labBalance)
                        .addGap(6, 6, 6)
                        .addComponent(labCBalance)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labAccStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCAccStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labUseStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labCUseStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        frame.changePanel("card1");
        frame.cManager.setLoggedInUser(null);
        //frame.setLoggedIn(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        frame.changePanel("card16");
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        frame.changePanel("card17");
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionHistoryActionPerformed
        frame.changePanel("card18");
    }//GEN-LAST:event_btnTransactionHistoryActionPerformed

    private void btnCreditDebitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditDebitActionPerformed
        frame.changePanel("card14");
    }//GEN-LAST:event_btnCreditDebitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnCreditDebit;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTransactionHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labAccStatus;
    private javax.swing.JLabel labBalance;
    private javax.swing.JLabel labCAccStatus;
    private javax.swing.JLabel labCBalance;
    private javax.swing.JLabel labCCardNumber;
    private javax.swing.JLabel labCEmail;
    private javax.swing.JLabel labCName;
    private javax.swing.JLabel labCUseStatus;
    private javax.swing.JLabel labCardNumber;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labName;
    private javax.swing.JLabel labTitle;
    private javax.swing.JLabel labUseStatus;
    // End of variables declaration//GEN-END:variables
}
