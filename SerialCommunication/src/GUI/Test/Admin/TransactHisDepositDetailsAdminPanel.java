/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Test.Admin;

import GUI.*;
import GUI.Test.System.GUIFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AndreasStensig
 */
public class TransactHisDepositDetailsAdminPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    
    /**
     * Creates new form ChargingStationListViewPanel
     */
    public TransactHisDepositDetailsAdminPanel() {
        initComponents();
    }
    
    public void setFrame(GUIFrame frame) {
        this.frame = frame;
    }
    
    public void loadPage(String depositNumber) {
        int depositNumb;
        try {
            depositNumb = Integer.parseInt(depositNumber);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "An error has occoured.\n No valid deposit number was found.");
            return;
        }
        
        ArrayList<String> data = frame.depManager.getDetailedDeposit(depositNumb);
        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "An error has occoured.\n No valid deposit instance was found.");
            return;
        }
        
        textDepositNumber.setText(data.get(0));
        textDepositDate.setText(data.get(1));
        textDepositAmount.setText(data.get(2));
        textNewBalance.setText(data.get(3));
        textLast4CardNumber.setText(data.get(4));
        textExternalRefNumb.setText(data.get(5));
    }
    
    private void resetPage() {
        textDepositNumber.setText("");
        textDepositDate.setText("");
        textDepositAmount.setText("");
        textNewBalance.setText("");
        textLast4CardNumber.setText("");
        textExternalRefNumb.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labDepositDetails = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        labLast4CardNumber = new javax.swing.JLabel();
        textDepositAmount = new javax.swing.JTextField();
        labDepositAmount = new javax.swing.JLabel();
        textDepositDate = new javax.swing.JTextField();
        lapDepositDate = new javax.swing.JLabel();
        labDepositNumber = new javax.swing.JLabel();
        labNewBalance = new javax.swing.JLabel();
        textNewBalance = new javax.swing.JTextField();
        textLast4CardNumber = new javax.swing.JTextField();
        textDepositNumber = new javax.swing.JTextField();
        labExternalRefNum = new javax.swing.JLabel();
        textExternalRefNumb = new javax.swing.JTextField();
        labDKK2 = new javax.swing.JLabel();
        labDKK1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(402, 302));

        labDepositDetails.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labDepositDetails.setText("Detailed deposit overview");

        labInformation.setText("Below you can see a detailed overview over a selected deposit instance.");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labLast4CardNumber.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labLast4CardNumber.setText("Last four card numbers");

        textDepositAmount.setEditable(false);
        textDepositAmount.setText(" ");

        labDepositAmount.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labDepositAmount.setText("Deposit amount");

        textDepositDate.setEditable(false);
        textDepositDate.setText(" ");

        lapDepositDate.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lapDepositDate.setText("Deposit date");

        labDepositNumber.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labDepositNumber.setText("Deposit number");

        labNewBalance.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labNewBalance.setText("New balance");

        textNewBalance.setEditable(false);
        textNewBalance.setText("  ");

        textLast4CardNumber.setEditable(false);
        textLast4CardNumber.setText(" ");

        textDepositNumber.setEditable(false);
        textDepositNumber.setText(" ");

        labExternalRefNum.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labExternalRefNum.setText("External reference number");

        textExternalRefNumb.setEditable(false);

        labDKK2.setText("DKK");

        labDKK1.setText("DKK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labDepositDetails)
                    .addComponent(labInformation)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lapDepositDate)
                            .addComponent(labDepositAmount)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textDepositAmount)
                                    .addComponent(textDepositDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDepositNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labDepositNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labDKK1)))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labExternalRefNum)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labDKK2))
                            .addComponent(labLast4CardNumber)
                            .addComponent(textLast4CardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textExternalRefNumb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnBack))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labDepositDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDepositNumber)
                    .addComponent(labNewBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDepositNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDKK2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lapDepositDate)
                    .addComponent(labLast4CardNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDepositDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLast4CardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labDepositAmount)
                    .addComponent(labExternalRefNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDepositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textExternalRefNumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labDKK1))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        resetPage();
        frame.changePanel("card18");
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel labDKK1;
    private javax.swing.JLabel labDKK2;
    private javax.swing.JLabel labDepositAmount;
    private javax.swing.JLabel labDepositDetails;
    private javax.swing.JLabel labDepositNumber;
    private javax.swing.JLabel labExternalRefNum;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labLast4CardNumber;
    private javax.swing.JLabel labNewBalance;
    private javax.swing.JLabel lapDepositDate;
    private javax.swing.JTextField textDepositAmount;
    private javax.swing.JTextField textDepositDate;
    private javax.swing.JTextField textDepositNumber;
    private javax.swing.JTextField textExternalRefNumb;
    private javax.swing.JTextField textLast4CardNumber;
    private javax.swing.JTextField textNewBalance;
    // End of variables declaration//GEN-END:variables
}
