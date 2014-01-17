package GUI;

import javax.swing.JOptionPane;

/**
 * Class for the SMSDA panel in GUI
 */
public class SMSDA extends javax.swing.JPanel {
    tvmGUI master;
    WelcomeDA WelcomeDAClass;
    CartDA CartDAClass;
    PayDA PayDAClass;
    
    /**
     * Custom constructor
     * @param tvmGUI Reference to {@link tvmGUI}.
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
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Interface/Bundle"); // NOI18N
        LabSMSDATitle.setText(bundle.getString("BETALING MED SMS")); // NOI18N
        add(LabSMSDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 780, -1));

        LabSMSDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSMSDAInstruct.setText(bundle.getString("INDTAST TELEFONNUMMERET SOM REGNINGEN SKAL SENDES TIL OG TRYK HEREFTER PÅ GODKEND. ")); // NOI18N
        add(LabSMSDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 780, -1));

        LabSMSDATotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabSMSDATotal.setText(bundle.getString("TOTAL PRIS: ")); // NOI18N
        add(LabSMSDATotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 214, 155, -1));

        ButSMSDAConfirm.setText(bundle.getString("GODKEND")); // NOI18N
        ButSMSDAConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAConfirmActionPerformed(evt);
            }
        });
        add(ButSMSDAConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 246, 93, 38));

        InSMSDAPhoneNMB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(InSMSDAPhoneNMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 148, 155, 48));

        ButSMSDAHelp.setText(bundle.getString("?")); // NOI18N
        ButSMSDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAHelpActionPerformed(evt);
            }
        });
        add(ButSMSDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 553, 49, 36));

        ButSMSDABack.setText(bundle.getString("TILBAGE")); // NOI18N
        ButSMSDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDABackActionPerformed(evt);
            }
        });
        add(ButSMSDABack, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 553, 100, 36));

        ButSMSDAClear.setText(bundle.getString("AFBRYD")); // NOI18N
        ButSMSDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAClearActionPerformed(evt);
            }
        });
        add(ButSMSDAClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 553, 100, 36));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Sets references to other panels.
     * @param refWelcomeDA Reference to WelcomeDA panel.
     * @param refCartDA Reference to CartDA panel.
     * @param refPayDA Referece to PayDA.
     */
    public void setReferences(WelcomeDA refWelcomeDA, CartDA refCartDA
            , PayDA refPayDA) {
        WelcomeDAClass = refWelcomeDA;
        CartDAClass = refCartDA;
        PayDAClass = refPayDA;
    }
    
    private void ButSMSDAConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAConfirmActionPerformed
        // Get String from text field
        String phoneNUM = InSMSDAPhoneNMB.getText();
        // Make payment
        if (master.PY.makePaymentBool(phoneNUM)) {
            // Show dialog refering to a fictional message
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle
                        .getString("VI HAR MODTAGET DIT NUMMER.")
                + WelcomeDA.languageBundle.getString("EN BESKED VIL BLIVE SENDT TIL NUMMERET INDEN FOR ÉT MINUT.")
                + WelcomeDA.languageBundle
                        .getString("FØLG VENLIGST INSTRUKTIONERNE I BESKEDEN.")
                + WelcomeDA.languageBundle.getString("FORTSAT GOD DAG.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB")
                    ,WelcomeDA.languageBundle.getString("NUMMER MODTAGET"),
                JOptionPane.INFORMATION_MESSAGE);
            master.printTickets();
        } else {
            // Show dialog with error
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle.getString("DER SKETE EN FEJL.")
                + WelcomeDA.languageBundle
                        .getString("DET INDTASTEDE NUMMER KUNNE IKKE FINDES.")
                + WelcomeDA.languageBundle.getString("PRØV IGEN, GÅ TILBAGE OG VÆLG ANDEN BETALING,")
                + WelcomeDA.languageBundle.getString("ELLER AFBRYD.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB")
                    , WelcomeDA.languageBundle.getString("NUMMER IKKE FUNDET"),
                JOptionPane.ERROR_MESSAGE);
            return;         // To avoid resetting to welcomming screen
        }
        // Set PY pointer to null
        master.PY = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Clear phone number field
        InSMSDAPhoneNMB.setText("");
        // Reset total price label
        LabSMSDATotal.setText(WelcomeDA.languageBundle
                .getString("TOTAL PRIS: "));
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Go back to welcomeing screen
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButSMSDAConfirmActionPerformed

    private void ButSMSDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("FOR HJÆLP RING XX XX XX XX")
            + WelcomeDA.languageBundle
                    .getString("FOR TEKNISK ASSISTANCE RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("HUSK AT OPLYSE MASKINENS ID, SOM KAN FINDES I ØVRE VENSTRE HJØRNE.")
            + "\n"
            + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB")
                , WelcomeDA.languageBundle.getString("HJÆLP OG TEKNISK SUPPORT")
            , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButSMSDAHelpActionPerformed

    private void ButSMSDABackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDABackActionPerformed
        // Set PY pointer to null
        master.PY = null;
        // Go back to previous window
        master.ChangePanel(PayDAClass);
    }//GEN-LAST:event_ButSMSDABackActionPerformed

    private void ButSMSDAClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSMSDAClearActionPerformed
        // Set PY pointer to null
        master.PY = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Clear phone number field
        InSMSDAPhoneNMB.setText("");
        // Reset total price label
        LabSMSDATotal.setText(WelcomeDA.languageBundle
                .getString("TOTAL PRIS: "));
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
