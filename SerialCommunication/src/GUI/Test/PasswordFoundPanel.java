/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import GUI.*;

/**
 *
 * @author Qess
 */
public class PasswordFoundPanel extends javax.swing.JPanel {
    
    private GUIFrame frame;
    /**
     * Creates new form PasswordViewPanel
     */
    public PasswordFoundPanel() {
        initComponents();
    }

    public void setFrame(GUI.Test.GUIFrame frame) {
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

        labPassword = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        labPasswordFound = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        labPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labPassword.setText("Account Password");

        labInformation.setText("Your password:");

        labPasswordFound.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labPasswordFound.setForeground(new java.awt.Color(51, 153, 0));
        labPasswordFound.setText(" ");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labPassword)
                    .addComponent(labInformation)
                    .addComponent(btnOK)
                    .addComponent(labPasswordFound, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labPassword)
                .addGap(18, 18, 18)
                .addComponent(labInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labPasswordFound)
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        frame.changePanel("card1");
    }//GEN-LAST:event_btnOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labPasswordFound;
    // End of variables declaration//GEN-END:variables
}
