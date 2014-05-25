package GUI.User;

import GUI.System.GUIFrame;
import GUI.System.JTextFieldLimit;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Panel for a customer to add funds to the account.
 */
public class AddFundsUserPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private String wrongCardNBR = "9999999999999999";
    private ImageIcon icon;
    private int errors;
    private DateFormat dateFormat;
    private Date date;
    private int month;
    private int year;

    /**
     * Custom constructor.
     */
    public AddFundsUserPanel() {
        initComponents();
        errors = 5;
        dateFormat = new SimpleDateFormat("MMyyyy");
        date = new Date();
        String monthYear = dateFormat.format(date);
        month = Integer.parseInt(monthYear.substring(0, 2));
        year = Integer.parseInt(monthYear.substring(3, 6));
        textCardNumber1.setDocument(new JTextFieldLimit(4));
        textCardNumber2.setDocument(new JTextFieldLimit(4));
        textCardNumber3.setDocument(new JTextFieldLimit(4));
        textCardNumber4.setDocument(new JTextFieldLimit(4));
        textCSC.setDocument(new JTextFieldLimit(3));
        textAmount.setDocument(new JTextFieldLimit(4));
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
     * Create a new reposit in the database.
     */
    private void registerDeposit() {
        int customerID = Integer.parseInt(frame.cManager.getLoggedInUser().
                getCustomerNumb());
        int oldBalance = frame.cManager.getLoggedInUser().getBalance();
        int depositAmount = Integer.parseInt(textAmount.getText()) * 100;
        int newBalance = oldBalance + depositAmount;
        int lastFourDigits = Integer.parseInt(textCardNumber4.getText());

        /* External reference number is for simulation purposes only. 
         Originally this numbers would be supplied by the 3rd-party banking 
         instituts. 
         */
        long randomNum = System.currentTimeMillis() * 13 * 29;
        String randomNumString = "" + randomNum;
        randomNumString = randomNumString.
                substring(randomNumString.length() - 6);
        int externalRefNumb = Integer.parseInt(randomNumString);

        /* Log deposit on database (also changes customer's balance) */
        Object[] depositData = {customerID, depositAmount, newBalance, externalRefNumb, lastFourDigits};
        frame.depManager.registerDeposit(depositData);
    }

    /**
     * Check input fields for errors.
     */
    private void inputCheck() {
        String cardNumber = textCardNumber1.getText() + textCardNumber2.
                getText()
                + textCardNumber3.getText() + textCardNumber4.getText();
        if (cardNumber.equals(wrongCardNBR)) {
            labError1.setVisible(true);
            labError2.setVisible(true);
        } else {
            labError1.setVisible(false);
            labError2.setVisible(false);
            errors--;
        }

        if (!cardNumber.matches(
                "\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
            labError1.setVisible(true);
            labError2.setVisible(true);
        } else {
            labError1.setVisible(false);
            labError2.setVisible(false);
            errors--;
        }

        if (!textCSC.getText().matches("\\d\\d\\d")) {
            labError1.setVisible(true);
            labError2.setVisible(true);
        } else {
            labError1.setVisible(false);
            labError2.setVisible(false);
            errors--;
        }

        if (!textAmount.getText().matches(
                "[1-9][0-9][0-9]|[1][0-9][0-9][0-9]|[2][0][0][0]")) {
            labValue.setForeground(Color.RED);
        } else {
            labValue.setForeground(Color.BLACK);
            errors--;
        }

        int monthValue = (Integer) spinMonth.getValue();
        int yearValue = (Integer) spinYear.getValue();
        if (monthValue > month && yearValue >= year) {
            labMonth.setForeground(Color.BLACK);
            labYear.setForeground(Color.BLACK);
            errors--;
        } else {
            labMonth.setForeground(Color.RED);
            labYear.setForeground(Color.RED);
        }
    }

    /**
     * Reset fields.
     */
    private void resetFields() {
        textCardNumber1.setText("");
        textCardNumber2.setText("");
        textCardNumber3.setText("");
        textCardNumber4.setText("");
        textAmount.setText("");
        textCSC.setText("");
        spinMonth.setValue(1);
        spinYear.setValue(14);
        labValue.setForeground(Color.BLACK);
        labError1.setVisible(false);
        labError2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labPayment = new javax.swing.JLabel();
        labCardNumber = new javax.swing.JLabel();
        labMonth = new javax.swing.JLabel();
        spinMonth = new javax.swing.JSpinner();
        labYear = new javax.swing.JLabel();
        spinYear = new javax.swing.JSpinner();
        labCSC = new javax.swing.JLabel();
        textCSC = new javax.swing.JTextField();
        btnHelp = new javax.swing.JButton();
        textAmount = new javax.swing.JTextField();
        labAmount = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        labInformation1 = new javax.swing.JLabel();
        textCardNumber1 = new javax.swing.JTextField();
        textCardNumber2 = new javax.swing.JTextField();
        textCardNumber3 = new javax.swing.JTextField();
        textCardNumber4 = new javax.swing.JTextField();
        labError1 = new javax.swing.JLabel();
        labError2 = new javax.swing.JLabel();
        labValue = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(402, 302));

        labPayment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labPayment.setText("Add funds");

        labCardNumber.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labCardNumber.setText("Card number");

        labMonth.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labMonth.setText("Month");

        spinMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        labYear.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labYear.setText("Year");

        spinYear.setModel(new javax.swing.SpinnerNumberModel(14, 14, 30, 1));

        labCSC.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labCSC.setText("CSC");

        textCSC.setText(" ");

        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        textAmount.setText(" ");

        labAmount.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labAmount.setText("Amount (DKK)");

        btnAccept.setText("Accept/OK");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        labInformation1.setText("Enter your billing information to add funds to your account.");

        textCardNumber1.setText(" ");
        textCardNumber1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber1KeyPressed(evt);
            }
        });

        textCardNumber2.setText(" ");
        textCardNumber2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber2KeyPressed(evt);
            }
        });

        textCardNumber3.setText(" ");
        textCardNumber3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber3KeyPressed(evt);
            }
        });

        textCardNumber4.setText(" ");

        labError1.setForeground(new java.awt.Color(255, 0, 51));
        labError1.setText("The informations given does not match that of a valid credit card.");

        labError2.setForeground(new java.awt.Color(255, 0, 51));
        labError2.setText("Please try again.");

        labValue.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labValue.setText("Enter value between 100-2000");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labCardNumber)
                        .addGap(197, 197, 197)
                        .addComponent(labAmount))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(textCardNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textCardNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textCardNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textCardNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labMonth)
                        .addGap(24, 24, 24)
                        .addComponent(labYear)
                        .addGap(59, 59, 59)
                        .addComponent(labCSC)
                        .addGap(4, 4, 4)
                        .addComponent(btnHelp)
                        .addGap(63, 63, 63)
                        .addComponent(labValue, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(spinMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(spinYear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(textCSC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labError1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labError2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAccept)))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(labPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(labInformation1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(labCardNumber))
                    .addComponent(labAmount))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCardNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCardNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCardNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCardNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labMonth))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labYear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(labCSC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnHelp))
                    .addComponent(labValue))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(labError1)
                .addGap(6, 6, 6)
                .addComponent(labError2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccept)
                    .addComponent(btnBack)))
        );

        labError1.setVisible(false);
        labError2.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * If no errors in fields, create new deposit in the database.
     *
     * @param evt ActionEvent
     */
    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        inputCheck();
        if (errors == 0) {
            registerDeposit();
            JOptionPane.showMessageDialog(this,
                    "The following amount has been added to your account "
                    + "balance.\n" + textAmount.
                    getText() + " DKK");
            frame.changePanel("card2");
            resetFields();
        }
        errors = 5;
    }//GEN-LAST:event_btnAcceptActionPerformed

    /**
     * Upon key press, if input string of CardNumber1 field is four, move focus
     * to next field.
     *
     * @param evt KeyEvent
     */
    private void textCardNumber1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber1KeyPressed
        if (textCardNumber1.getText().length() == 4) {
            textCardNumber2.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber1KeyPressed

    /**
     * Upon key press, if input string of CardNumber2 field is four, move focus
     * to next field.
     *
     * @param evt KeyEvent
     */
    private void textCardNumber2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber2KeyPressed
        if (textCardNumber2.getText().length() == 4) {
            textCardNumber3.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber2KeyPressed

    /**
     * Upon key press, if input string of CardNumber3 field is four, move focus
     * to next field.
     *
     * @param evt KeyEvent
     */
    private void textCardNumber3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber3KeyPressed
        if (textCardNumber3.getText().length() == 4) {
            textCardNumber4.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber3KeyPressed

    /**
     * Display help-image for CVV number.
     *
     * @param evt ActionEvent
     */
    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        icon = new ImageIcon(".\\CreditCardCVV.gif");
        JOptionPane.showMessageDialog(null, "", "CSC Help",
                JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * Change to account panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        resetFields();
        frame.changePanel("card2");
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel labAmount;
    private javax.swing.JLabel labCSC;
    private javax.swing.JLabel labCardNumber;
    private javax.swing.JLabel labError1;
    private javax.swing.JLabel labError2;
    private javax.swing.JLabel labInformation1;
    private javax.swing.JLabel labMonth;
    private javax.swing.JLabel labPayment;
    private javax.swing.JLabel labValue;
    private javax.swing.JLabel labYear;
    private javax.swing.JSpinner spinMonth;
    private javax.swing.JSpinner spinYear;
    private javax.swing.JTextField textAmount;
    private javax.swing.JTextField textCSC;
    private javax.swing.JTextField textCardNumber1;
    private javax.swing.JTextField textCardNumber2;
    private javax.swing.JTextField textCardNumber3;
    private javax.swing.JTextField textCardNumber4;
    // End of variables declaration//GEN-END:variables
}
