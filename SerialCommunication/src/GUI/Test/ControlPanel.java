/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

/**
 *
 * @author Qess
 */
public class ControlPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    
    public ControlPanel() {
        initComponents();
    }

    public void setFrame(GUIFrame frame) {
        this.frame = frame;
    }

    protected void loadCustomerDetails(){

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
        btnAccManage = new javax.swing.JButton();
        btnTransManage = new javax.swing.JButton();
        btnFundsManage = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        labAccManage = new javax.swing.JLabel();
        labTransManage = new javax.swing.JLabel();
        labTermManage = new javax.swing.JLabel();
        btnTermManage = new javax.swing.JButton();
        labFundsManage = new javax.swing.JLabel();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setText("Administrator Control Panel");

        btnAccManage.setText("Account Management");
        btnAccManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccManageActionPerformed(evt);
            }
        });

        btnTransManage.setText("Transaction Management");
        btnTransManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransManageActionPerformed(evt);
            }
        });

        btnFundsManage.setText("Funds Management");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        labAccManage.setText("Edit customers account details.");

        labTransManage.setText("Manage billings and deposits.");

        labTermManage.setText("Manage terminal statuses.");

        btnTermManage.setText("Terminal Manager");
        btnTermManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTermManageActionPerformed(evt);
            }
        });

        labFundsManage.setText("Add or withdraw funds from an account.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFundsManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTransManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAccManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTermManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labAccManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labTransManage)
                            .addComponent(labTermManage, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labFundsManage, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labTitle)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccManage)
                    .addComponent(labAccManage))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransManage)
                    .addComponent(labTransManage))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTermManage)
                    .addComponent(btnTermManage))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFundsManage)
                    .addComponent(labFundsManage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnLogout)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        frame.changePanel("card1");
        frame.cManager.setLoggedInUser(null);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAccManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccManageActionPerformed
        frame.changePanel("card12");
    }//GEN-LAST:event_btnAccManageActionPerformed

    private void btnTransManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransManageActionPerformed
        frame.changePanel("card25");
    }//GEN-LAST:event_btnTransManageActionPerformed

    private void btnTermManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTermManageActionPerformed
        frame.changePanel("card19");
    }//GEN-LAST:event_btnTermManageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccManage;
    private javax.swing.JButton btnFundsManage;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTermManage;
    private javax.swing.JButton btnTransManage;
    private javax.swing.JLabel labAccManage;
    private javax.swing.JLabel labFundsManage;
    private javax.swing.JLabel labTermManage;
    private javax.swing.JLabel labTitle;
    private javax.swing.JLabel labTransManage;
    // End of variables declaration//GEN-END:variables
}
