package GUI.Admin;

import GUI.System.GUIFrame;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Panel for the administrator to change the password of the customer he is
 * posing as.
 */
public class ChangePasswordAdminPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private int errors;

    /**
     * Constructor for initializing panel components. 
     */
    public ChangePasswordAdminPanel() {
        initComponents();
        errors = 2;
    }

    /**
     * Setter for reference to the framing containing this panel.
     *
     * @param frame GUIFrame controller.
     */
    public void setFrame(GUI.System.GUIFrame frame) {
        this.frame = frame;
    }
    
    /**
     * Check all user-input field for errors. 
     * Errors are reflected in the errors field.
     */
    private void inputCheck() {
        String newPassword = new StringBuilder().append(textNewPass.
                                                        getPassword()).
                                                        toString();
        if (newPassword.matches("^\\S*") && newPassword.length() >= 4 
                && newPassword.length() <= 30) {
            labNewPass.setForeground(Color.BLACK);
            errors--;
        } else {
            labNewPass.setForeground(Color.RED);
        }

        String confirmPassword = new StringBuilder().
                append(textConfirmPass.getPassword()).toString();
        if ((!confirmPassword.equals("")) && confirmPassword.equals(textNewPass.
                getText())) {
            labErrorMatch.setVisible(false);
            errors--;
        } else {
            labErrorMatch.setVisible(true);
        }
    }

    /**
     * Clear input fields.
     */
    private void resetPage() {
        textNewPass.setText("");
        textConfirmPass.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labSignUp = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        labConfirmPass = new javax.swing.JLabel();
        labNewPass = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labErrorMatch = new javax.swing.JLabel();
        textNewPass = new javax.swing.JPasswordField();
        textConfirmPass = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labSignUp.setText("Change Password");
        add(labSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, -1));

        labInformation.setText("Change the users password.");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, -1));

        labConfirmPass.setText("Confirm new password");
        add(labConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        labNewPass.setText("New password (4 - 30 characters)");
        add(labNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btnChangePass.setText("Change password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 60, -1));

        labErrorMatch.setForeground(new java.awt.Color(255, 0, 0));
        labErrorMatch.setText("Passwords do not match. Please try again.");
        add(labErrorMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, -1));
        labErrorMatch.setVisible(false);
        add(textNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, -1));
        add(textConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change panel to administrator's customer account panel.
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to go back?\n"
                + "All changes will be discarded.",
                "choose one", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            frame.changePanel("card13");
            resetPage();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Update customer's password in database.
     * Changes panel back to administrator's customer account panel.
     * @param evt ActionEvent
     */
    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        inputCheck();
        if (errors == 0) {
            JOptionPane.showMessageDialog(null,
                    "Users password has been changed.",
                    "Password change successfull",
                    JOptionPane.INFORMATION_MESSAGE);
            String[] newValues = new String[1];
            newValues[0] = new StringBuilder().append(textConfirmPass.
                    getPassword()).toString();
            frame.cManager.updateCustomerInformation(frame.cManager.
                    getLoggedInUser().getCustomerNumb(), 6, newValues);
            frame.changePanel("card13");
            resetPage();
        }
        errors = 2;
    }//GEN-LAST:event_btnChangePassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JLabel labConfirmPass;
    private javax.swing.JLabel labErrorMatch;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labNewPass;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JPasswordField textConfirmPass;
    private javax.swing.JPasswordField textNewPass;
    // End of variables declaration//GEN-END:variables
}