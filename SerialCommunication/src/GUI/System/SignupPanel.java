package GUI.System;

import java.awt.Color;

/**
 * Panel for signing up.
 */
public class SignupPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private int errors;

    /**
     * Custom constructor.
     */
    public SignupPanel() {
        initComponents();
        errors = 8;
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
     * Reset fields.
     */
    private void resetPage() {
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

    /**
     * Check input fields for errors.
     */
    private void inputCheck() {
        /*
         * (?i) = Case Insensitive, [a-å] = any letter from a to å
         * "+" = any combination of the previous, 
         * [a-å\\-\\s] = any letter from a-å incl "-" and " "
         * "?" = the previous can appear once or none  */
        if (textFirstName.getText().matches(
                "(?i)[a-å]+(?i)[a-å\\-\\s]?(?i)[a-å]+")) {
            labFirstName.setForeground(Color.BLACK);
            errors--;
        } else {
            labFirstName.setForeground(Color.RED);
        }

        if (textLastName.getText().matches(
                "(?i)[a-å]+(?i)[a-å\\-\\s]?(?i)[a-å]+")) {
            labLastName.setForeground(Color.BLACK);
            errors--;
        } else {
            labLastName.setForeground(Color.RED);
        }

        if (textRoad.getText().matches(
                "(?i)[a-å]+(?i)[a-å\\-\\s]?(?i)[a-å]+(?i)[a-å\\-\\s]?(?i)"
                + "[a-å\\d]+")) {
            labRoad.setForeground(Color.BLACK);
            errors--;
        } else {
            labRoad.setForeground(Color.RED);
        }

        if (textZip.getText().length() == 4) {
            try {
                int zipcode = Integer.parseInt(textZip.getText());
                labZip.setForeground(Color.BLACK);
                errors--;
            } catch (NumberFormatException e) {
                labZip.setForeground(Color.RED);
            }
        } else {
            labZip.setForeground(Color.RED);
        }

        if (textPhoneNBR.getText().length() == 8) {
            try {
                int phoneNBR = Integer.parseInt(textPhoneNBR.getText());
                labPhoneNBR.setForeground(Color.BLACK);
                errors--;
            } catch (NumberFormatException e) {
                labPhoneNBR.setForeground(Color.RED);
            }
        } else {
            labPhoneNBR.setForeground(Color.RED);
        }

        if (isValidEmailAddress(textEmail.getText()) == true) {
            try {
                frame.cManager.getCustomerByEmail(textEmail.getText());
            } catch (NullPointerException e) {
                errors--;
            }
        }

        String password = new StringBuilder().append(textPassword.getPassword()).
                toString();
        if (password.matches("^\\S*") && password.length() >= 4 && password.
                length() <= 30) {
            labPassword.setForeground(Color.BLACK);
            errors--;
        } else {
            labPassword.setForeground(Color.RED);
        }

        String passwordConfirm = new StringBuilder().append(textPassword.
                getPassword()).toString();
        if ((!passwordConfirm.equals("")) && passwordConfirm.equals(password)) {
            labConfirmPassword.setForeground(Color.BLACK);
            labErrorConfirmPassword.setVisible(false);
            errors--;
        } else {
            labConfirmPassword.setForeground(Color.RED);
            labErrorConfirmPassword.setVisible(true);
        }
    }

    /**
     * Collect values from fields and create new customer in database.
     */
    private void registerUser() {
        Object[] userData = new Object[8];
        userData[0] = new StringBuilder().append(textConfirmPassword.
                getPassword()).toString();
        userData[1] = textFirstName.getText();
        userData[2] = textLastName.getText();
        userData[3] = textRoad.getText();
        userData[4] = textZip.getText();
        userData[5] = textEmail.getText().toLowerCase();
        userData[6] = textPhoneNBR.getText();
        userData[7] = 0;           // Is set in next panel

        /* Create customer in database */
        frame.cManager.addNewCustomer(userData);
    }

    /**
     * Method found at StackOverflow.com, which validates the syntax of an email
     * address.
     * http://stackoverflow.com/questions/624581/what-is-the-best-java-email
     * -address-validation-method
     *
     * @param email
     *
     * @return true if the string matches the structure of a valid email
     *         address; false oStherwise.
     */
    private boolean isValidEmailAddress(String email) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(
                ".+@.+\\.[a-z]+");
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
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
        labRoad = new javax.swing.JLabel();
        labConfirmPassword = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        labLastName = new javax.swing.JLabel();
        textZip = new javax.swing.JTextField();
        labZip = new javax.swing.JLabel();
        textPhoneNBR = new javax.swing.JTextField();
        labPhoneNBR = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labErrorEmail = new javax.swing.JLabel();
        labErrorConfirmPassword = new javax.swing.JLabel();
        labError1 = new javax.swing.JLabel();
        labError2 = new javax.swing.JLabel();
        labErrorExistingEmail = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        textConfirmPassword = new javax.swing.JPasswordField();

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

        labPassword.setText("Password (4 - 30 characters)");
        add(labPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, -1));

        textRoad.setNextFocusableComponent(textZip);
        add(textRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 187, -1));

        labCredentials.setText("Login Credentials");
        add(labCredentials, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 150, -1));

        textEmail.setNextFocusableComponent(textPassword);
        textEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textEmailFocusLost(evt);
            }
        });
        add(textEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 187, -1));

        labEmail.setText("Email");
        add(labEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

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
        labErrorEmail.setText("- not a valid email address");
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

        labErrorExistingEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorExistingEmail.setForeground(new java.awt.Color(255, 0, 0));
        labErrorExistingEmail.setText("- email is already in use");
        add(labErrorExistingEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 130, -1));
        labErrorExistingEmail.setVisible(false);

        textPassword.setNextFocusableComponent(textConfirmPassword);
        add(textPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 190, -1));

        textConfirmPassword.setNextFocusableComponent(textFirstName);
        add(textConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 190, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change to login panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        frame.changePanel("card1");
        resetPage();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * If no errors in input fields, create the new user in the database. Then
     * change to panel for adding funds.
     *
     * @param evt ActionEvent
     */
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        inputCheck();
        if (errors == 0) {
            registerUser();
            /* Set the user as logged in */
            String email = textEmail.getText();
            System.out.println(frame.cManager.getCustomerByEmail(email).
                    toString());
            frame.cManager.setLoggedInUser(frame.cManager.getCustomerByEmail(
                    email));

            frame.changePanel("card4");
            resetPage();
        }
        errors = 8;
    }//GEN-LAST:event_btnSubmitActionPerformed

    /**
     * When email input field looses focus, make sure that the syntax follows
     * that of an email address, and that the address does not already exist in
     * the database.
     *
     * @param evt FocusEvent
     */
    private void textEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusLost
        System.err.println(errors);
        if (isValidEmailAddress(textEmail.getText()) == true) {
            labErrorEmail.setVisible(false);
            try {
                frame.cManager.getCustomerByEmail(textEmail.getText());
                labEmail.setForeground(Color.RED);
                labErrorExistingEmail.setVisible(true);
            } catch (NullPointerException e) {
                System.out.println(e);
                labEmail.setForeground(Color.BLACK);
                labErrorExistingEmail.setVisible(false);
            }
        } else {
            labErrorEmail.setVisible(true);
            labEmail.setForeground(Color.RED);
        }
    }//GEN-LAST:event_textEmailFocusLost

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
    private javax.swing.JLabel labErrorExistingEmail;
    private javax.swing.JLabel labFirstName;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labLastName;
    private javax.swing.JLabel labPassword;
    private javax.swing.JLabel labPhoneNBR;
    private javax.swing.JLabel labRoad;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JLabel labZip;
    private javax.swing.JPasswordField textConfirmPassword;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textPhoneNBR;
    private javax.swing.JTextField textRoad;
    private javax.swing.JTextField textZip;
    // End of variables declaration//GEN-END:variables
}
