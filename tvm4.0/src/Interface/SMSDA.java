/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;

/**
 *
 * @author Nordahl
 */
public class SMSDA extends javax.swing.JPanel {
    tvmGUI master;
    WelcomeDA WelcomeDAClass;
    CartDA CartDAClass;
    PayDA PayDAClass;
    /**
     * Creates new form SMSDA
     */
    public SMSDA(tvmGUI tvmGUI) {
        master = tvmGUI;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabSMSDAInfo = new javax.swing.JLabel();
        LabSMSDATime = new javax.swing.JLabel();
        LabSMSDATitle = new javax.swing.JLabel();
        LabSMSDAInstruct = new javax.swing.JLabel();
        LabSMSDATotal = new javax.swing.JLabel();
        ButSMSDAConfirm = new javax.swing.JButton();
        InSMSDAPhoneNMB = new javax.swing.JTextField();
        ButSMSDAHelp = new javax.swing.JButton();
        ButSMSDABack = new javax.swing.JButton();
        ButSMSDAClear = new javax.swing.JButton();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabSMSDAInfo.setText(" ");
        add(LabSMSDAInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 348, -1));

        LabSMSDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabSMSDATime.setText(" ");
        add(LabSMSDATime, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 11, 367, -1));

        LabSMSDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabSMSDATitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSMSDATitle.setText("Betaling med SMS");
        add(LabSMSDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 780, -1));

        LabSMSDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSMSDAInstruct.setText("Indtast telefonnummeret som regningen skal sendes til og tryk herefter på godkend. ");
        add(LabSMSDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 780, -1));

        LabSMSDATotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabSMSDATotal.setText("Total pris: ");
        add(LabSMSDATotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 214, 155, -1));

        ButSMSDAConfirm.setText("Godkend");
        ButSMSDAConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAConfirmActionPerformed(evt);
            }
        });
        add(ButSMSDAConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 246, 93, 38));

        InSMSDAPhoneNMB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(InSMSDAPhoneNMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 148, 155, 48));

        ButSMSDAHelp.setText("?");
        ButSMSDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAHelpActionPerformed(evt);
            }
        });
        add(ButSMSDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 49, 36));

        ButSMSDABack.setText("Tilbage");
        ButSMSDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDABackActionPerformed(evt);
            }
        });
        add(ButSMSDABack, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 553, 100, 36));

        ButSMSDAClear.setText("Afbryd");
        ButSMSDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAClearActionPerformed(evt);
            }
        });
        add(ButSMSDAClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 553, 100, 36));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    public void setReferences(WelcomeDA refWelcomeDA, CartDA refCartDA, PayDA refPayDA)
    {
        WelcomeDAClass = refWelcomeDA;
        CartDAClass = refCartDA;
        PayDAClass = refPayDA;
    }
    private void ButSMSDAConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAConfirmActionPerformed
        // Get String from text field
        String phoneNUM = InSMSDAPhoneNMB.getText();
        // Make payment
        if (master.SMS.MakePaymentBool(phoneNUM)) {
            // Show dialog refering to a fictional message
            JOptionPane.showMessageDialog(this,
                "\nVi har modtaget dit nummer."
                + "\nEn besked vil blive sendt til nummeret inden for ét minut."
                + "\nFølg venligst instruktionerne i beskeden."
                + "\nFortsat god dag."
                + "\n"
                + "\nBlueJ Trakfikselskab","Nummer modtaget",
                JOptionPane.INFORMATION_MESSAGE);
            master.printTickets(this);
        } else {
            // Show dialog with error
            JOptionPane.showMessageDialog(this,
                "\nDer skete en fejl."
                + "\nDet indtastede nummer kunne ikke findes."
                + "\nPrøv igen, gå tilbage og vælg anden betaling,"
                + "\neller afbryd."
                + "\n"
                + "\nBlueJ Trakfikselskab","Nummer ikke fundet",
                JOptionPane.ERROR_MESSAGE);
            return;         // To avoid resetting to welcomming screen
        }
        // Set SMS pointer to null
        master.SMS = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Clear phone number field
        InSMSDAPhoneNMB.setText("");
        // Reset total price label
        LabSMSDATotal.setText("Total pris: ");
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Go back to welcomeing screen
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButSMSDAConfirmActionPerformed

    private void ButSMSDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            "\nFor hjælp ring xx xx xx xx"
            + "\nFor teknisk assistance ring xx xx xx xx"
            + "\nHusk at oplyse maskinens ID, som kan findes i øvre venstre hjørne."
            + "\n"
            + "\nBlueJ Trakfikselskab","Hjælp og teknisk support",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButSMSDAHelpActionPerformed

    private void ButSMSDABackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDABackActionPerformed
        // Set SMS pointer to null
        master.SMS = null;
        // Go back to previous window
        master.ChangePanel(PayDAClass);
    }//GEN-LAST:event_ButSMSDABackActionPerformed

    private void ButSMSDAClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAClearActionPerformed
        // Set SMS pointer to null
        master.SMS = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Clear phone number field
        InSMSDAPhoneNMB.setText("");
        // Reset total price label
        LabSMSDATotal.setText("Total pris: ");
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Go back to welcomeing screen
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButSMSDAClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JButton ButSMSDABack;
    public javax.swing.JButton ButSMSDAClear;
    public javax.swing.JButton ButSMSDAConfirm;
    public javax.swing.JButton ButSMSDAHelp;
    public javax.swing.JTextField InSMSDAPhoneNMB;
    public javax.swing.JLabel LabSMSDAInfo;
    public javax.swing.JLabel LabSMSDAInstruct;
    public javax.swing.JLabel LabSMSDATime;
    public javax.swing.JLabel LabSMSDATitle;
    public javax.swing.JLabel LabSMSDATotal;
    // End of variables declaration//GEN-END:variables
}