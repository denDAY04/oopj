package GUI.User;

import GUI.System.GUIFrame;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Panel for the customer to change his password.
 */
public class ChangePasswordPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private int errors;

    /**
     * Custom constructor.
     */
    public ChangePasswordPanel() {
        initComponents();
        errors = 3;
    }

    /**
     * Setter for GUIFrame reference.
     *
     * @param frame GUIFrame object.
     */
    public void setFrame(GUI.System.GUIFrame frame) {
        this.frame = frame;
    }

    /**
     * Check input fields.
     */
    private void inputCheck() {
        String currentPassword = new StringBuilder().append(textCurrentPass.
                getPassword()).toString();
        if (currentPassword.equals(frame.cManager.getLoggedInUser().
                getPassword())) {
            labCurrentPass.setForeground(Color.BLACK);
            labErrorWrongPass.setVisible(false);
            errors--;
        } else {
            labCurrentPass.setForeground(Color.RED);
            labErrorWrongPass.setVisible(true);
        }

        String newPassword = new StringBuilder().append(textNewPass.
                getPassword()).toString();
        if (newPassword.matches("^\\S*") && newPassword.length() >= 4
                && newPassword.length() <= 30) {
            labNewPass.setForeground(Color.BLACK);
            errors--;
        } else {
            labNewPass.setForeground(Color.RED);
        }

        String confirmPassword = new StringBuilder().append(textConfirmPass.
                getPassword()).toString();
        if ((!confirmPassword.equals("")) && confirmPassword.equals(textNewPass.
                getText())) {
            labConfirmPass.setForeground(Color.BLACK);
            labErrorMatch.setVisible(false);
            errors--;
        } else {
            labConfirmPass.setForeground(Color.RED);
            labErrorMatch.setVisible(true);
        }
    }

    /**
     * Reset fields.
     */
    private void resetPage() {
        textCurrentPass.setText("");
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
        labCurrentPass = new javax.swing.JLabel();
        labConfirmPass = new javax.swing.JLabel();
        labNewPass = new javax.swing.JLabel();
        btnChangePass = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labErrorWrongPass = new javax.swing.JLabel();
        labErrorMatch = new javax.swing.JLabel();
        textCurrentPass = new javax.swing.JPasswordField();
        textNewPass = new javax.swing.JPasswordField();
        textConfirmPass = new javax.swing.JPasswordField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labSignUp.setText("Change Password");
        add(labSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, -1));

        labInformation.setText("Here you can change your password.");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, -1));

        labCurrentPass.setText("Current password");
        add(labCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        labConfirmPass.setText("Confirm new password");
        add(labConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        labNewPass.setText("New password (4 - 30 characters)");
        add(labNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        btnChangePass.setText("Change password");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        add(btnChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, -1));

        labErrorWrongPass.setForeground(new java.awt.Color(255, 0, 0));
        labErrorWrongPass.setText("- wrong password");
        add(labErrorWrongPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 120, -1));
        labErrorWrongPass.setVisible(false);

        labErrorMatch.setForeground(new java.awt.Color(255, 0, 0));
        labErrorMatch.setText("Passwords do not match. Please try again.");
        add(labErrorMatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, -1));
        labErrorMatch.setVisible(false);
        add(textCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, -1));
        add(textNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 190, -1));
        add(textConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 190, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Prompt the user for confirmation of going back, and then change to
     * account panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to go back?\n"
                + "All changes will be discarded.",
                "choose one", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            frame.changePanel("card2");
            resetPage();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * If no errors in input fields, change the customer's password in the
     * database and change to account panel.
     *
     * @param evt ActionEvent
     */
    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        inputCheck();
        if (errors == 0) {
            String[] newValues = new String[1];
            newValues[0] = new StringBuilder().append(textConfirmPass.
                    getPassword()).toString();
            frame.cManager.updateCustomerInformation(frame.cManager.
                    getLoggedInUser().getCustomerNumb(), 4, newValues);
            JOptionPane.showMessageDialog(null,
                    "Your password has been changed.",
                    "Password change successfull",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.changePanel("card2");
            resetPage();
        }
        errors = 3;
    }//GEN-LAST:event_btnChangePassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JLabel labConfirmPass;
    private javax.swing.JLabel labCurrentPass;
    private javax.swing.JLabel labErrorMatch;
    private javax.swing.JLabel labErrorWrongPass;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labNewPass;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JPasswordField textConfirmPass;
    private javax.swing.JPasswordField textCurrentPass;
    private javax.swing.JPasswordField textNewPass;
    // End of variables declaration//GEN-END:variables
}
