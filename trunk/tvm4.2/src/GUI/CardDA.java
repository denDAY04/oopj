/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author Nordahl
 */
public class CardDA extends javax.swing.JPanel {
    tvmGUI master;
    WelcomeDA WelcomeDAClass;
    CartDA CartDAClass;
    PayDA PayDAClass;
    /**
     * Creates new form CardDA
     */
    public CardDA(tvmGUI tvmGUI) {
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

        LabCardDAInfo = new javax.swing.JLabel();
        LabCardDATime = new javax.swing.JLabel();
        LabCardDATitle = new javax.swing.JLabel();
        LabCardDAInstruct = new javax.swing.JLabel();
        PwdCardDACode = new javax.swing.JPasswordField();
        LabCardDATotal = new javax.swing.JLabel();
        ButCardDAConfirm = new javax.swing.JButton();
        ButCardDAHelp = new javax.swing.JButton();
        ButCardDAClear = new javax.swing.JButton();
        ButCardDABack = new javax.swing.JButton();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabCardDAInfo.setText(" ");
        add(LabCardDAInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 316, -1));

        LabCardDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabCardDATime.setText("  ");
        add(LabCardDATime, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 11, 350, -1));

        LabCardDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabCardDATitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Interface/Bundle"); // NOI18N
        LabCardDATitle.setText(bundle.getString("BETALING MED BETALINGSKORT")); // NOI18N
        add(LabCardDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 780, -1));

        LabCardDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCardDAInstruct.setText(bundle.getString("INDSÆT BETALINGSKORT OG INDTAST DIN PIN-KODE I FELTET NEDENUNDER. TRYK HEREFTER PÅ GODKEND.")); // NOI18N
        add(LabCardDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 780, -1));

        PwdCardDACode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(PwdCardDACode, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 148, 136, 48));

        LabCardDATotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabCardDATotal.setText(bundle.getString("TOTAL PRIS: ")); // NOI18N
        add(LabCardDATotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 214, 155, -1));

        ButCardDAConfirm.setText(bundle.getString("GODKEND")); // NOI18N
        ButCardDAConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCardDAConfirmActionPerformed(evt);
            }
        });
        add(ButCardDAConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 246, 93, 38));

        ButCardDAHelp.setText(bundle.getString("?")); // NOI18N
        ButCardDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCardDAHelpActionPerformed(evt);
            }
        });
        add(ButCardDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 50, 36));

        ButCardDAClear.setText(bundle.getString("AFBRYD")); // NOI18N
        ButCardDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCardDAClearActionPerformed(evt);
            }
        });
        add(ButCardDAClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 553, 100, 36));

        ButCardDABack.setText(bundle.getString("TILBAGE")); // NOI18N
        ButCardDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCardDABackActionPerformed(evt);
            }
        });
        add(ButCardDABack, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 553, 100, 36));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    
    public void setReferences(WelcomeDA refWelcomeDA, CartDA refCartDA, PayDA refPayDA)
    {
        WelcomeDAClass = refWelcomeDA;
        CartDAClass = refCartDA;
        PayDAClass = refPayDA;
    }
    
    private void ButCardDAConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCardDAConfirmActionPerformed
        // Get text from password field
        String pinString = PwdCardDACode.getText();
        // Make payment
        if (master.CC.MakePaymentBool(pinString) == false) {   // If simulation failed.
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle.getString("FEJL.")
                + WelcomeDA.languageBundle.getString("DU HAR INDTASTET EN UGYLDIG PIN.")
                + WelcomeDA.languageBundle.getString("PRØV IGEN, ELLER AFBRYD.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("FORKERT PIN"),
                JOptionPane.ERROR_MESSAGE);
        } else {
            // Print ticket
            master.printTickets(this);
            // Show dialog confirming transaction
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT.")
                + WelcomeDA.languageBundle.getString("SE SLISKEN NEDEN FOR FOR DIN BILLET OG HUSK DIT KORT.")
                + WelcomeDA.languageBundle.getString("FORTSAT GOD DAG.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT"),
                JOptionPane.INFORMATION_MESSAGE);

            //If not out of order
            if (!master.outOfOrder) {
                // Set Credit Card pointer to null
                master.CC = null;
                // Clear content of cart-array, list-array, and list
                CartDAClass.ListCartDATicketList.removeAll();
                master.CartContent.clear();
                master.SB.clearCart();
                // Clear pin field
                PwdCardDACode.setText("");
                // Reset inserted money label
                LabCardDATotal.setText(WelcomeDA.languageBundle.getString("TOTAL PRIS: "));
                // Reset selectionscreen's inputs
                master.resetSelectionScreen();
                // Go back to welcomeing screen
                master.ChangePanel(WelcomeDAClass);
            }
        }
    }//GEN-LAST:event_ButCardDAConfirmActionPerformed

    private void ButCardDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCardDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("FOR HJÆLP RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("FOR TEKNISK ASSISTANCE RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("HUSK AT OPLYSE MASKINENS ID, SOM KAN FINDES I ØVRE VENSTRE HJØRNE.")
            + "\n"
            + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("HJÆLP OG TEKNISK SUPPORT"),
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButCardDAHelpActionPerformed

    private void ButCardDAClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCardDAClearActionPerformed
        // Set Credit Card pointer to null
        master.CC = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Clear pin field
        PwdCardDACode.setText("");
        // Reset total price label
        LabCardDATotal.setText(WelcomeDA.languageBundle.getString("TOTAL PRIS: "));
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Go back to welcomeing screen
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButCardDAClearActionPerformed

    private void ButCardDABackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCardDABackActionPerformed
        // Set credit card pointer to null
        master.CC = null;
        // Go back to previous window
        master.ChangePanel(PayDAClass);
    }//GEN-LAST:event_ButCardDABackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JButton ButCardDABack;
    public javax.swing.JButton ButCardDAClear;
    public javax.swing.JButton ButCardDAConfirm;
    public javax.swing.JButton ButCardDAHelp;
    public javax.swing.JLabel LabCardDAInfo;
    public javax.swing.JLabel LabCardDAInstruct;
    public javax.swing.JLabel LabCardDATime;
    public javax.swing.JLabel LabCardDATitle;
    public javax.swing.JLabel LabCardDATotal;
    public javax.swing.JPasswordField PwdCardDACode;
    // End of variables declaration//GEN-END:variables
}
