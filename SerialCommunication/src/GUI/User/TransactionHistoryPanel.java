/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.User;

import GUI.System.GUIFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AndreasStensig
 */
public class TransactionHistoryPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private GUIFrame frame;

    public TransactionHistoryPanel() {
        initComponents();
        
        /* Set column headers and special width on tables */
        tableDepositHistory.getColumnModel().getColumn(0).setHeaderValue("Deposit number");
        tableDepositHistory.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableDepositHistory.getColumnModel().getColumn(1).setHeaderValue("Date");
        tableDepositHistory.getColumnModel().getColumn(2).setHeaderValue("Amount (DKK)");
        tableDepositHistory.getColumnModel().getColumn(2).setPreferredWidth(15);
        tableDepositHistory.getColumnModel().getColumn(3).setHeaderValue("New balance (DKK)");
        tableDepositHistory.getColumnModel().getColumn(3).setPreferredWidth(15);
        tableDepositHistory.getColumnModel().getColumn(4).setHeaderValue("Card number");
        tableDepositHistory.getColumnModel().getColumn(4).setPreferredWidth(20);
        
        tableBillingHistory.getColumnModel().getColumn(0).setHeaderValue("Transaction number");
        tableBillingHistory.getColumnModel().getColumn(1).setHeaderValue("Recieved at server");
        tableBillingHistory.getColumnModel().getColumn(2).setHeaderValue("Amount (DKK)");
        tableBillingHistory.getColumnModel().getColumn(3).setHeaderValue("New balance (DKK)");
    }

    public void setFrame(GUI.System.GUIFrame frame) {
        this.frame = frame;
    }
    
    public void loadPage() {
        tableModel = (DefaultTableModel) tableDepositHistory.getModel();
        /* Clear table and insert values */
        clearTable(tableModel);
        ArrayList<String[]> depositList = frame.depManager.getSimpleDeposits(frame.cManager.getLoggedInUser().getCustomerNumb());
        for(String[] iter : depositList) {
            tableModel.addRow(iter);
        }
        
        tableModel = (DefaultTableModel) tableBillingHistory.getModel();
        /* Clear table and insert values */
        clearTable(tableModel);
        ArrayList<String[]> billingList = frame.bManager.getSimpleBillings(frame.cManager.getLoggedInUser().getCustomerNumb());
        for (String[] iter : billingList) {
            tableModel.addRow(iter);
        }
    }
    
    private void clearTable(DefaultTableModel tableModel) {
        if (tableModel != null) {
            while (tableModel.getRowCount() != 0) {
                tableModel.removeRow(0);
            }
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

        labTransactionHistory = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        tableBillingHistory = new javax.swing.JTable();
        labInformation2 = new javax.swing.JLabel();
        tableScrollPane1 = new javax.swing.JScrollPane();
        tableDepositHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnDepositDetails = new javax.swing.JButton();
        btnBillingDetails = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(402, 302));

        labTransactionHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTransactionHistory.setText("Transaction History");

        labInformation.setText("Below you will see a history of all billings and deposits for your account.");

        tableBillingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        )
        {public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tableScrollPane.setViewportView(tableBillingHistory);

    labInformation2.setText("To see more details about a specific history, click on it and click Details.");

    tableDepositHistory.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
        }
    )
    {public boolean isCellEditable(int row, int column){
        return false;
    }
    }
    );
    tableScrollPane1.setViewportView(tableDepositHistory);

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
    jLabel1.setText("Deposits");

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
    jLabel2.setText("Billings");

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
    });

    btnDepositDetails.setText("Deposit details");
    btnDepositDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDepositDetailsActionPerformed(evt);
        }
    });

    btnBillingDetails.setText("Billing details");
    btnBillingDetails.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBillingDetailsActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(btnDepositDetails))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labTransactionHistory)
                            .addComponent(labInformation)
                            .addComponent(labInformation2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBillingDetails)))))
            .addContainerGap(27, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labTransactionHistory)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labInformation2)
            .addGap(11, 11, 11)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnDepositDetails)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnBack)
                .addComponent(btnBillingDetails))
            .addGap(40, 40, 40))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        clearTable((DefaultTableModel) tableBillingHistory.getModel());
        clearTable((DefaultTableModel) tableDepositHistory.getModel());   
        frame.changePanel("card2");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDepositDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositDetailsActionPerformed
        int rowSelected = tableDepositHistory.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "No deposit selected.");
            return;
        }
        
        String depositNumber = (String) tableDepositHistory.getValueAt(rowSelected, 0);
        frame.setActiveDepositNumber(depositNumber);
        frame.changePanel("card21");
    }//GEN-LAST:event_btnDepositDetailsActionPerformed

    private void btnBillingDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillingDetailsActionPerformed
        int rowSelected = tableBillingHistory.getSelectedRow();
        if (rowSelected == -1) {
            JOptionPane.showMessageDialog(this, "No billing selected.");
            return;
        }
        
        String billingNumber = (String) tableBillingHistory.getValueAt(rowSelected, 0);
        frame.setActiveBillingNumber(billingNumber);
        frame.changePanel("card22");
    }//GEN-LAST:event_btnBillingDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBillingDetails;
    private javax.swing.JButton btnDepositDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labInformation2;
    private javax.swing.JLabel labTransactionHistory;
    private javax.swing.JTable tableBillingHistory;
    private javax.swing.JTable tableDepositHistory;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JScrollPane tableScrollPane1;
    // End of variables declaration//GEN-END:variables
}
