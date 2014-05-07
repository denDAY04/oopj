/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Test;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AndreasStensig
 */
public class AddFundsPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private String wrongCardNBR = "9999999999999999";
    private ImageIcon icon;
    private boolean inputError;
    /**
     * Creates new form AddFundsViewPanel
     */
    public AddFundsPanel() {
        initComponents();
        textCardNumber1.setDocument(new JTextFieldLimit(4));
        textCardNumber2.setDocument(new JTextFieldLimit(4));
        textCardNumber3.setDocument(new JTextFieldLimit(4));
        textCardNumber4.setDocument(new JTextFieldLimit(4));
        textCSC.setDocument(new JTextFieldLimit(3));
        textAmount.setDocument(new JTextFieldLimit(4));
    }

    public void setFrame(GUI.Test.GUIFrame frame) {
        this.frame = frame;
    }
    
    private void registerDeposit() {
        int customerID = Integer.parseInt(frame.cManager.getLoggedInUser().getCustomerNumb());
        int oldBalance  = frame.cManager.getLoggedInUser().getBalance();
        int depositAmount = Integer.parseInt(textAmount.getText())*100;
        int newBalance = oldBalance + depositAmount;
        int lastFourDigits = Integer.parseInt(textCardNumber4.getText());
        
        /* External reference number is for simulation purposes only. 
        Originally this numbers would be supplied by the 3rd-party banking 
        instituts. 
        */
        long randomNum = System.currentTimeMillis() * 13 * 29;
        String randomNumString = ("" + randomNum).substring(0, 6);
        int externalRefNumb = Integer.parseInt(randomNumString);
        
        /* Log deposit on database (also changes customer's balance) */
        Object[] depositData = {customerID, depositAmount, newBalance, externalRefNumb, lastFourDigits};
        frame.cManager.registerDeposit(depositData);
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
        labProcessing = new javax.swing.JLabel();
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

        setPreferredSize(new java.awt.Dimension(402, 302));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labPayment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labPayment.setText("Add funds");
        add(labPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 90, 32));

        labCardNumber.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labCardNumber.setText("Card number");
        add(labCardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, -1, -1));

        labMonth.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labMonth.setText("Month");
        add(labMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 143, -1, -1));

        spinMonth.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        add(spinMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 49, -1));

        labYear.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labYear.setText("Year");
        add(labYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 143, -1, -1));

        spinYear.setModel(new javax.swing.SpinnerNumberModel(14, 14, 30, 1));
        add(spinYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 169, 57, -1));

        labCSC.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labCSC.setText("CSC");
        add(labCSC, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 143, -1, -1));

        textCSC.setText(" ");
        add(textCSC, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 169, 47, -1));

        labProcessing.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labProcessing.setText("Processing...");
        labProcessing.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(labProcessing, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 373, -1));

        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        textAmount.setText(" ");
        add(textAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 90, -1));

        labAmount.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        labAmount.setText("Amount (DKK)");
        add(labAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        btnAccept.setText("Accept/OK");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 268, -1, -1));

        labInformation1.setText("Enter your billing information to add funds to your account.");
        add(labInformation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 360, -1));

        textCardNumber1.setText(" ");
        textCardNumber1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber1KeyPressed(evt);
            }
        });
        add(textCardNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, -1));

        textCardNumber2.setText(" ");
        textCardNumber2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber2KeyPressed(evt);
            }
        });
        add(textCardNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 50, -1));

        textCardNumber3.setText(" ");
        textCardNumber3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textCardNumber3KeyPressed(evt);
            }
        });
        add(textCardNumber3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 50, -1));

        textCardNumber4.setText(" ");
        add(textCardNumber4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 50, -1));

        labError1.setForeground(new java.awt.Color(255, 0, 51));
        labError1.setText("The informations given does not match that of a valid credit card.");
        add(labError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 360, -1));
        labError1.setVisible(false);

        labError2.setForeground(new java.awt.Color(255, 0, 51));
        labError2.setText("Please try again.");
        add(labError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 310, -1));
        labError2.setVisible(false);

        labValue.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labValue.setText("Enter value between 100-2000");
        add(labValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 170, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        inputCheck();
        if (inputError == false){
            registerDeposit();
            JOptionPane.showMessageDialog(this, "The following amount has been added to your account balance.\n"+textAmount.getText()+" DKK");
            frame.changePanel("card5");
            resetFields();
            labError1.setVisible(inputError);
            labError2.setVisible(inputError);
        } else{
            //labError1.setVisible(inputError);
            //labError2.setVisible(inputError);
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void textCardNumber1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber1KeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            return;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE){
            return;
        }
        
        if(textCardNumber1.getText().length() == 4){
           textCardNumber2.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber1KeyPressed

    private void textCardNumber2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            return;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE){
            return;
        }
        if(textCardNumber2.getText().length() == 4){
           textCardNumber3.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber2KeyPressed

    private void textCardNumber3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCardNumber3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            return;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_DELETE){
            return;
        }
        if(textCardNumber3.getText().length() == 4){
           textCardNumber4.requestFocusInWindow();
        }
    }//GEN-LAST:event_textCardNumber3KeyPressed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        //Absolute path
        //icon = new ImageIcon("C:\\Users\\Mathias Rasmussen\\Desktop\\Project\\SerialCommunication\\CreditCardCVV.gif");
        //Relative path
        icon = new ImageIcon(".\\CreditCardCVV.gif");
        JOptionPane.showMessageDialog(null, "", "CSC Help", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_btnHelpActionPerformed
    
    private void inputCheck(){
       
        String cardNumber = textCardNumber1.getText()+textCardNumber2.getText()+
                            textCardNumber3.getText()+textCardNumber4.getText();
        if (cardNumber.equals(wrongCardNBR)){
            labError1.setVisible(true);
            labError2.setVisible(true);
            inputError = true;
            return;
        } else{
            labError1.setVisible(false);
            labError2.setVisible(false);
            inputError = false;
        }
            
        if (!cardNumber.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")){
            labError1.setVisible(true);
            labError2.setVisible(true);
            inputError = true;
            return;
        } else{
            labError1.setVisible(false);
            labError2.setVisible(false);
            inputError = false;
      
        }
        
        if (!textCSC.getText().matches("\\d\\d\\d")){
            labError1.setVisible(true);
            labError2.setVisible(true);
            inputError = true;
            return;
        } else{
            labError1.setVisible(false);
            labError2.setVisible(false);
            inputError = false;
        }
        
        //                                 Regex: 100-999 or 1000-1999 or 2000
        if (!textAmount.getText().matches("[1-9][0-9][0-9]|[1][0-9][0-9][0-9]|[2][0][0][0]")){
            labValue.setForeground(Color.RED);
            inputError = true;
            return;
        } else{
            labValue.setForeground(Color.BLACK);
            inputError = false;
        }        
    }
    
    private void resetFields(){
        textCardNumber1.setText("");
        textCardNumber2.setText("");
        textCardNumber3.setText("");
        textCardNumber4.setText("");
        textAmount.setText("");
        textCSC.setText("");
        spinMonth.setValue(3);
        spinYear.setValue(15);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnHelp;
    private javax.swing.JLabel labAmount;
    private javax.swing.JLabel labCSC;
    private javax.swing.JLabel labCardNumber;
    private javax.swing.JLabel labError1;
    private javax.swing.JLabel labError2;
    private javax.swing.JLabel labInformation1;
    private javax.swing.JLabel labMonth;
    private javax.swing.JLabel labPayment;
    private javax.swing.JLabel labProcessing;
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
