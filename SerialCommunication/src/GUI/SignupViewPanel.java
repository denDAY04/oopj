/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Qess
 */
public class SignupViewPanel extends javax.swing.JPanel {

    private Controller controller;

    
    /**
     * Creates new form LoginControllerPanel
     */
    public SignupViewPanel() {
        initComponents();
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
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
        labFirstName = new javax.swing.JLabel();
        textFirstName = new javax.swing.JTextField();
        labPassword = new javax.swing.JLabel();
        textRoad = new javax.swing.JTextField();
        labCredentials = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labEmail1 = new javax.swing.JLabel();
        textConfirmPassword = new javax.swing.JTextField();
        labRoad = new javax.swing.JLabel();
        labPassword1 = new javax.swing.JLabel();
        textLastName1 = new javax.swing.JTextField();
        labLastName1 = new javax.swing.JLabel();
        textRoad1 = new javax.swing.JTextField();
        labRoad1 = new javax.swing.JLabel();
        textPhoneNBR = new javax.swing.JTextField();
        labPhoneNBR = new javax.swing.JLabel();
        textPassword1 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labSignUp.setText("Signup");
        add(labSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 187, -1));

        labInformation.setText("please fill out the form below !");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 187, -1));

        labFirstName.setText("First Name");
        add(labFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        textFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFirstNameActionPerformed(evt);
            }
        });
        add(textFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 187, -1));

        labPassword.setText("Password");
        add(labPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        textRoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRoadActionPerformed(evt);
            }
        });
        add(textRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 187, -1));

        labCredentials.setText("Login Credentials");
        add(labCredentials, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 170, -1));

        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });
        add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 187, -1));

        labEmail1.setText("Email");
        add(labEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        textConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textConfirmPasswordActionPerformed(evt);
            }
        });
        add(textConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 187, -1));

        labRoad.setText("Address and number");
        add(labRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        labPassword1.setText("Confirm Password");
        add(labPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        textLastName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textLastName1ActionPerformed(evt);
            }
        });
        add(textLastName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 187, -1));

        labLastName1.setText("Last Name");
        add(labLastName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        textRoad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRoad1ActionPerformed(evt);
            }
        });
        add(textRoad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 187, -1));

        labRoad1.setText("Zip/Postal code");
        add(labRoad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        textPhoneNBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPhoneNBRActionPerformed(evt);
            }
        });
        add(textPhoneNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 187, -1));

        labPhoneNBR.setText("Phone number");
        add(labPhoneNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        textPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPassword1ActionPerformed(evt);
            }
        });
        add(textPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 187, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void textFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFirstNameActionPerformed

    private void textRoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRoadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRoadActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textConfirmPasswordActionPerformed

    private void textLastName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textLastName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textLastName1ActionPerformed

    private void textRoad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRoad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRoad1ActionPerformed

    private void textPhoneNBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPhoneNBRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPhoneNBRActionPerformed

    private void textPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPassword1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labCredentials;
    private javax.swing.JLabel labEmail1;
    private javax.swing.JLabel labFirstName;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labLastName1;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labPassword1;
    private javax.swing.JLabel labPhoneNBR;
    private javax.swing.JLabel labRoad;
    private javax.swing.JLabel labRoad1;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JTextField textConfirmPassword;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName1;
    private javax.swing.JTextField textPassword1;
    private javax.swing.JTextField textPhoneNBR;
    private javax.swing.JTextField textRoad;
    private javax.swing.JTextField textRoad1;
    // End of variables declaration//GEN-END:variables
}