/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import SQLDatabase.ModelClasses.Customer;

/**
 *
 * @author Qess
 */
public class LoginControllerPanel extends javax.swing.JPanel {

    //private CustomerManager cManager;
    private GUIFrame frame;
    
    /**
     * Creates new form LoginControllerPanel
     */
    public LoginControllerPanel() {
        initComponents();
    }

    public void setFrame(GUIFrame frame) {
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

        jButton1 = new javax.swing.JButton();
        labWelcome = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labPassword = new javax.swing.JLabel();
        textPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnForgot = new javax.swing.JButton();
        btnSignup = new javax.swing.JButton();
        labSignup = new javax.swing.JLabel();
        labError = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 253, -1, -1));

        labWelcome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labWelcome.setText("Welcome to TA Charging");
        add(labWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        labInformation.setText("Enter your credentials to login.");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 197, -1));

        labEmail.setText("Email");
        add(labEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, -1, -1));

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 197, -1));

        labPassword.setText("Password");
        add(labPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });
        add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, 197, -1));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 176, -1, -1));

        btnForgot.setText("Forgot Password");
        btnForgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotActionPerformed(evt);
            }
        });
        add(btnForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 176, -1, -1));

        btnSignup.setText("Sign up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, -1, -1));

        labSignup.setText("New User?");
        add(labSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, -1, -1));

        labError.setForeground(new java.awt.Color(255, 0, 51));
        labError.setText("Wrong email or password");
        labError.setVisible(false);
        add(labError, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 216, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    
    if(frame.cManager.loggedInAs(textEmail.getText(), textPassword.getText()) == true){
        labError.setVisible(false);
        frame.changePanel("card2");
    } else {
        labError.setVisible(true);
    }
//    try {
//        frame.cManager.loggedInAs(textEmail.getText(), textPassword.getText());
//        labError.setVisible(false);
//        frame.changePanel("card2");
//    } catch (IndexOutOfBoundsException e) {
//        labError.setVisible(true);
//    }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        frame.changePanel("card3");
    }//GEN-LAST:event_btnSignupActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.changePanel("card4");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnForgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotActionPerformed
        frame.changePanel("card6");
    }//GEN-LAST:event_btnForgotActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgot;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labError;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labSignup;
    private javax.swing.JLabel labWelcome;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textPassword;
    // End of variables declaration//GEN-END:variables
}