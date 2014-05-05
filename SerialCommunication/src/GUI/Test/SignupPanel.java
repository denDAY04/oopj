/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Test;

import GUI.*;
import java.awt.Color;

/**
 *
 * @author Qess
 */
public class SignupPanel extends javax.swing.JPanel {
    
    private GUIFrame frame;
    private boolean inputError;
    /**
     * Creates new form LoginControllerPanel
     */
    public SignupPanel() {
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

        labSignUp = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        labFirstName = new javax.swing.JLabel();
        textFirstName = new javax.swing.JTextField();
        labPassword = new javax.swing.JLabel();
        textRoad = new javax.swing.JTextField();
        labCredentials = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labEmail = new javax.swing.JLabel();
        textConfirmPassword = new javax.swing.JTextField();
        labRoad = new javax.swing.JLabel();
        labConfirmPassword = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        labLastName = new javax.swing.JLabel();
        textZip = new javax.swing.JTextField();
        labZip = new javax.swing.JLabel();
        textPhoneNBR = new javax.swing.JTextField();
        labPhoneNBR = new javax.swing.JLabel();
        textPassword = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labErrorEmail = new javax.swing.JLabel();
        labErrorConfirmPassword = new javax.swing.JLabel();
        labError1 = new javax.swing.JLabel();
        labError2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labSignUp.setText("Signup");
        add(labSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 187, -1));

        labInformation.setText("Please fill out the form below !");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 187, -1));

        labFirstName.setText("First Name");
        add(labFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        textFirstName.setNextFocusableComponent(textLastName);
        add(textFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 187, -1));

        labPassword.setText("Password (min. 4 characters)");
        add(labPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, -1));

        textRoad.setNextFocusableComponent(textZip);
        add(textRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 187, -1));

        labCredentials.setText("Login Credentials");
        add(labCredentials, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 150, -1));

        textEmail.setNextFocusableComponent(textPassword);
        add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 187, -1));

        labEmail.setText("Email");
        add(labEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        textConfirmPassword.setNextFocusableComponent(textFirstName);
        add(textConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 187, -1));

        labRoad.setText("Address and number");
        add(labRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        labConfirmPassword.setText("Confirm Password");
        add(labConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        textLastName.setNextFocusableComponent(textRoad);
        add(textLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 187, -1));

        labLastName.setText("Last Name");
        add(labLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        textZip.setNextFocusableComponent(textPhoneNBR);
        add(textZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 187, -1));

        labZip.setText("Zip/Postal code");
        add(labZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        textPhoneNBR.setNextFocusableComponent(textEmail);
        add(textPhoneNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 187, -1));

        labPhoneNBR.setText("Phone number (8 digits)");
        add(labPhoneNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        textPassword.setNextFocusableComponent(textConfirmPassword);
        add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 187, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 60, -1));

        labErrorEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        labErrorEmail.setText("- not a valid email adress");
        add(labErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 130, -1));
        labErrorEmail.setVisible(false);

        labErrorConfirmPassword.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorConfirmPassword.setForeground(new java.awt.Color(255, 0, 0));
        labErrorConfirmPassword.setText("- passwords does not match");
        add(labErrorConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 140, -1));
        labErrorConfirmPassword.setVisible(false);

        labError1.setForeground(new java.awt.Color(255, 0, 0));
        labError1.setText("Some of the fields are not filled in correctly.");
        add(labError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 230, -1));
        labError1.setVisible(false);

        labError2.setForeground(new java.awt.Color(255, 0, 0));
        labError2.setText("Please revise, and then try again.");
        add(labError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 240, -1));
        labError2.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        frame.changePanel("card1");
        resetPage();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        inputCheck();
        if (inputError == false){
            frame.changePanel("card4");
            labError1.setVisible(inputError);
            labError2.setVisible(inputError);
        } else{
            labError1.setVisible(inputError);
            labError2.setVisible(inputError);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed
    
    private void resetPage(){
        textFirstName.setText("");
        textLastName.setText("");
        textRoad.setText("");
        textZip.setText("");
        textPhoneNBR.setText("");
        textEmail.setText("");
        textPassword.setText("");
        textConfirmPassword.setText("");
        labFirstName.setForeground(Color.BLACK);
        labLastName.setForeground(Color.BLACK);
        labRoad.setForeground(Color.BLACK);
        labZip.setForeground(Color.BLACK);
        labPhoneNBR.setForeground(Color.BLACK);
        labEmail.setForeground(Color.BLACK);
        labPassword.setForeground(Color.BLACK);
        labConfirmPassword.setForeground(Color.BLACK);
        labErrorConfirmPassword.setVisible(false);
        labErrorEmail.setVisible(false);
        labError1.setVisible(false);
        labError2.setVisible(false);
    }
    private void inputCheck() {
        if (!textFirstName.getText().equals("")){
            labFirstName.setForeground(Color.BLACK);
            inputError = false;
        } else{
            labFirstName.setForeground(Color.RED);
            inputError = true;
        }
        
        if (!textLastName.getText().equals("")){
            labLastName.setForeground(Color.BLACK);  
            inputError = false;
        } else{
            labLastName.setForeground(Color.RED);
            inputError = true;
        }
        
        if (!textRoad.getText().equals("")){
            labRoad.setForeground(Color.BLACK);
            inputError = false;
        } else{
            labRoad.setForeground(Color.RED);
            inputError = true;
        }
        
        if (!textZip.getText().equals("") && textZip.getText().length() == 4){
            try {
                int zipcode = Integer.parseInt(textZip.getText());
                labZip.setForeground(Color.BLACK);
                inputError = false;
            } catch(NumberFormatException e){
                labZip.setForeground(Color.RED);
                inputError = true;
            }
        } else{
            labZip.setForeground(Color.RED);
            inputError = true;
        }
        
        if (!textPhoneNBR.getText().equals("") && textPhoneNBR.getText().length() == 8){
            try {
                int phoneNBR = Integer.parseInt(textPhoneNBR.getText());
                labPhoneNBR.setForeground(Color.BLACK);
                inputError = false;
            } catch(NumberFormatException e){
                labPhoneNBR.setForeground(Color.RED);
                inputError = true;
            }
        } else{
            labPhoneNBR.setForeground(Color.RED);
            inputError = true;
        }
        
        if(!textEmail.getText().equals("")){
            if (isValidEmailAddress(textEmail.getText()) == true){
                labEmail.setForeground(Color.BLACK);
                labErrorEmail.setVisible(false);
                inputError = false;
            } else{
                labEmail.setForeground(Color.RED);
                labErrorEmail.setVisible(true);
                inputError = true;
            }
        } else{
            labEmail.setForeground(Color.RED);
            labErrorEmail.setVisible(true);
            inputError = true;
        }
        
        if(!textPassword.getText().equals("") && textPassword.getText().length() >= 4) {
            labPassword.setForeground(Color.BLACK);
            inputError = false;
        } else{
            labPassword.setForeground(Color.RED);
            inputError = true;
        }
        
        if((!textConfirmPassword.getText().equals("")) && textConfirmPassword.getText().equals(textPassword.getText())) {
            labConfirmPassword.setForeground(Color.BLACK);
            labErrorConfirmPassword.setVisible(false);
            inputError = false;
        } else{
            labConfirmPassword.setForeground(Color.RED);
            labErrorConfirmPassword.setVisible(true);
            inputError = true;
        }
    }
    
    // Metod found at StackOverflow.com, which validates the syntax of an emailadress
    // http://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
    private boolean isValidEmailAddress(String email) {
       java.util.regex.Pattern p = java.util.regex.Pattern.compile(".+@.+\\.[a-z]+");
       java.util.regex.Matcher m = p.matcher(email);
       return m.matches();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel labConfirmPassword;
    private javax.swing.JLabel labCredentials;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labError1;
    private javax.swing.JLabel labError2;
    private javax.swing.JLabel labErrorConfirmPassword;
    private javax.swing.JLabel labErrorEmail;
    private javax.swing.JLabel labFirstName;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labLastName;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labPhoneNBR;
    private javax.swing.JLabel labRoad;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JLabel labZip;
    private javax.swing.JTextField textConfirmPassword;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextField textPhoneNBR;
    private javax.swing.JTextField textRoad;
    private javax.swing.JTextField textZip;
    // End of variables declaration//GEN-END:variables
}