package GUI.Admin;

import GUI.System.GUIFrame;
import GUI.System.JTextFieldLimit;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Administrator panel for editing a customer's account information.
 */
public class EditAccountAdminPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private int errors;

    /**
     * Custom constructor. Initializes panel components, creates new document
     * for pin input, and sets error count.
     */
    public EditAccountAdminPanel() {
        initComponents();
        textPin.setDocument(new JTextFieldLimit(4));
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
     * Load content into fields.
     */
    public void loadPage() {
        textFirstName.setText(frame.cManager.getLoggedInUser().getFirstName());
        textLastName.setText(frame.cManager.getLoggedInUser().getLastName());
        textRoad.setText(frame.cManager.getLoggedInUser().getRoad());
        textZip.setText(frame.cManager.getLoggedInUser().getZipCode());
        textPhoneNBR.setText(frame.cManager.getLoggedInUser().getPhoneNumb());
        textEmail.setText(frame.cManager.getLoggedInUser().getEmail());
        textCardNBR.setText(frame.cManager.getLoggedInUser().getCardNumb());
        textPin.setText(frame.cManager.getLoggedInUser().getPin());
        if (frame.cManager.getLoggedInUser().getAccountStatus().
                equals("PENAPP")) {
            cbAccountStatus.setSelectedItem("Pending Application");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals(
                "PENACT")) {
            cbAccountStatus.setSelectedItem("Pending Activation");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals(
                "DISABL")) {
            cbAccountStatus.setSelectedItem("Disabled");
        } else if (frame.cManager.getLoggedInUser().getAccountStatus().equals(
                "ACTIVE")) {
            cbAccountStatus.setSelectedItem("Activated");
        }

        if (frame.cManager.getLoggedInUser().getUseStatus().equals("CHAR")) {
            cbUseStatus.setSelectedItem("Charging");
        } else if (frame.cManager.getLoggedInUser().getUseStatus().
                equals("IDLE")) {
            cbUseStatus.setSelectedItem("Idle");
        }
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
                if (frame.cManager.getCustomerByEmail(textEmail.getText()).
                        getEmail().equals(frame.cManager.getLoggedInUser().
                                getEmail())) {
                    errors--;
                }
            } catch (NullPointerException e) {
                errors--;
            }
        }

        if (textCardNBR.getText().equals("") && cbAccountStatus.
                getSelectedIndex() == 0) {
            labCardNBR.setForeground(Color.BLACK);
            errors--;
        } else if (!textCardNBR.getText().equals("") && cbAccountStatus.
                getSelectedIndex() != 0) {
            labCardNBR.setForeground(Color.BLACK);
            errors--;
        } else {
            labCardNBR.setForeground(Color.RED);
        }

        if (textPin.getText().equals("") && cbAccountStatus.
                getSelectedIndex() == 0) {
            labPin.setForeground(Color.BLACK);
            errors--;
        } else if (textPin.getText().matches("\\d\\d\\d\\d") && cbAccountStatus.
                getSelectedIndex() != 0) {
            labPin.setForeground(Color.BLACK);
            errors--;
        } else {
            labPin.setForeground(Color.RED);
        }
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
     * Update all the information of the customer with the fields' values.
     */
    private void updateCustomerInfo() {
        String[] newValues = new String[10];
        newValues[0] = textFirstName.getText();
        newValues[1] = textLastName.getText();
        newValues[2] = textRoad.getText();
        newValues[3] = textZip.getText();
        newValues[4] = textPhoneNBR.getText();
        newValues[5] = textEmail.getText();
        newValues[6] = textCardNBR.getText();
        newValues[7] = textPin.getText();
        if (cbAccountStatus.getSelectedItem().equals("Pending Approval")) {
            newValues[8] = "PENAPP";
        } else if (cbAccountStatus.getSelectedItem().
                equals("Pending Activation")) {
            newValues[8] = "PENACT";
        } else if (cbAccountStatus.getSelectedItem().equals("Disabled")) {
            newValues[8] = "DISABL";
        } else if (cbAccountStatus.getSelectedItem().equals("Activated")) {
            newValues[8] = "ACTIVE";
        }

        if (cbUseStatus.getSelectedItem().equals("Charging")) {
            newValues[9] = "CHAR";
        } else if (cbUseStatus.getSelectedItem().equals("Idle")) {
            newValues[9] = "IDLE";
        }

        frame.cManager.updateCustomerInformation(frame.cManager.
                getLoggedInUser().getCustomerNumb(), 5, newValues);
    }

    /**
     * Reset labels.
     */
    private void resetPage() {
        labError1.setVisible(false);
        labError2.setVisible(false);
        labErrorEmail.setVisible(false);
        labFirstName.setForeground(Color.BLACK);
        labLastName.setForeground(Color.BLACK);
        labRoad.setForeground(Color.BLACK);
        labZip.setForeground(Color.BLACK);
        labPhoneNBR.setForeground(Color.BLACK);
        labEmail.setForeground(Color.BLACK);
        labCardNBR.setForeground(Color.BLACK);
        labPin.setForeground(Color.BLACK);
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
        textRoad = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        labEmail = new javax.swing.JLabel();
        labRoad = new javax.swing.JLabel();
        textLastName = new javax.swing.JTextField();
        labLastName = new javax.swing.JLabel();
        textZip = new javax.swing.JTextField();
        labZip = new javax.swing.JLabel();
        textPhoneNBR = new javax.swing.JTextField();
        labPhoneNBR = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        labErrorEmail = new javax.swing.JLabel();
        labError1 = new javax.swing.JLabel();
        labError2 = new javax.swing.JLabel();
        cbAccountStatus = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbUseStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        textCardNBR = new javax.swing.JTextField();
        labCardNBR = new javax.swing.JLabel();
        textPin = new javax.swing.JTextField();
        labPin = new javax.swing.JLabel();
        labErrorExistingEmail = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labSignUp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labSignUp.setText("Edit Account Information");
        add(labSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, -1));

        labInformation.setText("Edit the desired account information below.");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 210, -1));

        labFirstName.setText("First Name");
        add(labFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        textFirstName.setNextFocusableComponent(textLastName);
        add(textFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 187, -1));

        textRoad.setNextFocusableComponent(textZip);
        add(textRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 187, -1));

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

        btnSave.setText("Save changes");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 60, -1));

        labErrorEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        labErrorEmail.setText("- not a valid email address");
        add(labErrorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 130, -1));
        labErrorEmail.setVisible(false);

        labError1.setForeground(new java.awt.Color(255, 0, 0));
        labError1.setText("Some of the fields are not filled in correctly.");
        add(labError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, -1));
        labError1.setVisible(false);

        labError2.setForeground(new java.awt.Color(255, 0, 0));
        labError2.setText("Please revise, and then try again.");
        add(labError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 240, -1));
        labError2.setVisible(false);

        cbAccountStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending Approval", "Pending Activation", "Disabled", "Activated" }));
        add(cbAccountStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        jLabel2.setText("Account status ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        cbUseStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Charging", "Idle" }));
        add(cbUseStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        jLabel3.setText("Use status ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));
        add(textCardNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 80, -1));

        labCardNBR.setText("Card number");
        add(labCardNBR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));
        add(textPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 70, -1));

        labPin.setText("Pin code");
        add(labPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        labErrorExistingEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorExistingEmail.setForeground(new java.awt.Color(255, 0, 0));
        labErrorExistingEmail.setText("- email is already in use");
        add(labErrorExistingEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 130, -1));
        labErrorExistingEmail.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change to administrator's account panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int reply = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to go back?\n"
                + "All changes will be discarded.",
                "Are you sure?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            frame.changePanel("card13");
            resetPage();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Collect data from input fields and update the customer's information in
     * the database. Change to administrator's account panel.
     *
     * @param evt ActionEvent
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        inputCheck();
        if (errors == 0) {
            JOptionPane.showMessageDialog(null,
                    "Account information has been updated.",
                    "Account information change successfull",
                    JOptionPane.INFORMATION_MESSAGE);
            String[] newValues = new String[9];
            newValues[0] = textFirstName.getText();
            newValues[1] = textLastName.getText();
            newValues[2] = textRoad.getText();
            newValues[3] = textZip.getText();
            newValues[4] = textPhoneNBR.getText();
            newValues[5] = textEmail.getText().toLowerCase();
            newValues[6] = textCardNBR.getText();
            newValues[7] = textPin.getText();
            if (cbAccountStatus.getSelectedItem().equals("Pending Approval")) {
                newValues[8] = "PENAPP";
            } else if (cbAccountStatus.getSelectedItem().equals(
                    "Pending Activation")) {
                newValues[8] = "PENACT";
            } else if (cbAccountStatus.getSelectedItem().equals("Disabled")) {
                newValues[8] = "DISABL";
            } else if (cbAccountStatus.getSelectedItem().equals("Activated")) {
                newValues[8] = "ACTIVE";
            }

            updateCustomerInfo();
            frame.changePanel("card13");
            resetPage();
        }
        errors = 8;
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Run when email input-field loses focus. If input is a valid email, look
     * up email in database to ensure that it matches the email of currently
     * logged in customer.
     *
     * @param evt FocusEvent
     */
    private void textEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmailFocusLost
        if (isValidEmailAddress(textEmail.getText()) == true) {
            labErrorEmail.setVisible(false);
            try {
                if (frame.cManager.getCustomerByEmail(textEmail.getText()).
                        getEmail().equals(frame.cManager.getLoggedInUser().
                                getEmail())) {
                    labEmail.setForeground(Color.BLACK);
                    labErrorExistingEmail.setVisible(false);
                } else {
                    labEmail.setForeground(Color.RED);
                    labErrorExistingEmail.setVisible(true);
                }
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
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbAccountStatus;
    private javax.swing.JComboBox cbUseStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labCardNBR;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labError1;
    private javax.swing.JLabel labError2;
    private javax.swing.JLabel labErrorEmail;
    private javax.swing.JLabel labErrorExistingEmail;
    private javax.swing.JLabel labFirstName;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labLastName;
    private javax.swing.JLabel labPhoneNBR;
    private javax.swing.JLabel labPin;
    private javax.swing.JLabel labRoad;
    private javax.swing.JLabel labSignUp;
    private javax.swing.JLabel labZip;
    private javax.swing.JTextField textCardNBR;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFirstName;
    private javax.swing.JTextField textLastName;
    private javax.swing.JTextField textPhoneNBR;
    private javax.swing.JTextField textPin;
    private javax.swing.JTextField textRoad;
    private javax.swing.JTextField textZip;
    // End of variables declaration//GEN-END:variables
}
