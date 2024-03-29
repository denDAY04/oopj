package GUI;

import javax.swing.JOptionPane;

/**
 * Class for the CartDA panel in GUI
 */
public class CartDA extends javax.swing.JPanel {
    tvmGUI master;
    WelcomeDA WelcomeDAClass;
    PayDA PayDAClass;
    
    /**
     * Custom constructor
     * @param tvmGUI Reference to {@link tvmGUI}.
     */
    public CartDA(tvmGUI tvmGUI) {
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

        LabCartDAInfo = new javax.swing.JLabel();
        LabCartDATime = new javax.swing.JLabel();
        LabCartDATitle = new javax.swing.JLabel();
        LabCartDAInstruct = new javax.swing.JLabel();
        LabCartDATotal = new javax.swing.JLabel();
        ButCartDAHelp = new javax.swing.JButton();
        ButCartDAClear = new javax.swing.JButton();
        ButCartDARemove = new javax.swing.JButton();
        ButCartDAAddM = new javax.swing.JButton();
        ButCartDAPay = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListCartDATicketList = new javax.swing.JList<String>();
        LabCartDASTK = new javax.swing.JLabel();
        LabCartDKType = new javax.swing.JLabel();
        LabCartDKAmountZones = new javax.swing.JLabel();
        LabCartDKPricePerTicket = new javax.swing.JLabel();
        LabCartDKSubTotal = new javax.swing.JLabel();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabCartDAInfo.setText(" ");
        add(LabCartDAInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 288, -1));

        LabCartDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabCartDATime.setText(" ");
        add(LabCartDATime, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 11, 309, -1));

        LabCartDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Interface/Bundle"); // NOI18N
        LabCartDATitle.setText(bundle.getString("INDKØBSKURV")); // NOI18N
        add(LabCartDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 69, 356, -1));

        LabCartDAInstruct.setText(bundle.getString("HERUNDER KAN DU SE DINE VALGTE BILLETTER. DU KAN VÆLGE AT SLETTE BILLETTER, TILFØJE FLERE, RYDDE ALT, ELLER GÅ TIL BETALING. ")); // NOI18N
        add(LabCartDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 116, 642, -1));

        LabCartDATotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabCartDATotal.setText(bundle.getString("TOTAL PRIS: ")); // NOI18N
        add(LabCartDATotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 496, 130, -1));

        ButCartDAHelp.setText(bundle.getString("?")); // NOI18N
        ButCartDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCartDAHelpActionPerformed(evt);
            }
        });
        add(ButCartDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 548, -1, 32));

        ButCartDAClear.setText(bundle.getString("RYD ALT")); // NOI18N
        ButCartDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCartDAClearActionPerformed(evt);
            }
        });
        add(ButCartDAClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 548, 82, 32));

        ButCartDARemove.setText(bundle.getString("FJERN")); // NOI18N
        ButCartDARemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCartDARemoveActionPerformed(evt);
            }
        });
        add(ButCartDARemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 548, 81, 32));

        ButCartDAAddM.setText(bundle.getString("TILFØJ FLERE")); // NOI18N
        ButCartDAAddM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCartDAAddMActionPerformed(evt);
            }
        });
        add(ButCartDAAddM, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 548, 84, 32));

        ButCartDAPay.setText(bundle.getString("GÅ TIL BETALING")); // NOI18N
        ButCartDAPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCartDAPayActionPerformed(evt);
            }
        });
        add(ButCartDAPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 548, 130, 32));

        ListCartDATicketList.setFont(new java.awt.Font("Consolas", 0, 15)); // NOI18N
        jScrollPane2.setViewportView(ListCartDATicketList);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 187, 571, 291));

        LabCartDASTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCartDASTK.setText(bundle.getString("STK.")); // NOI18N
        add(LabCartDASTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 167, 85, -1));

        LabCartDKType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCartDKType.setText(bundle.getString("BILLET TYPE")); // NOI18N
        add(LabCartDKType, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 167, 86, -1));

        LabCartDKAmountZones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCartDKAmountZones.setText(bundle.getString("ANTAL ZONER")); // NOI18N
        add(LabCartDKAmountZones, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 167, 85, -1));

        LabCartDKPricePerTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCartDKPricePerTicket.setText(bundle.getString("PRIS PR. STK")); // NOI18N
        add(LabCartDKPricePerTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 167, 86, -1));

        LabCartDKSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCartDKSubTotal.setText(bundle.getString("SUB-TOTAL")); // NOI18N
        add(LabCartDKSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 167, 85, -1));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sets references to other panels.
     * @param refWelcomeDA Reference to WelcomeDA panel.
     * @param refPayDA Reference to PayDA.
     */
    public void setReferences(WelcomeDA refWelcomeDA, PayDA refPayDA) {
        WelcomeDAClass = refWelcomeDA;
        PayDAClass = refPayDA;
    }
    
    private void ButCartDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCartDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("FOR HJÆLP RING XX XX XX XX")
            + WelcomeDA.languageBundle
                    .getString("FOR TEKNISK ASSISTANCE RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("HUSK AT OPLYSE MASKINENS ID, SOM KAN FINDES I ØVRE VENSTRE HJØRNE.")
            + "\n"
            + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB")
                , WelcomeDA.languageBundle.getString("HJÆLP OG TEKNISK SUPPORT")
            , JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButCartDAHelpActionPerformed

    private void ButCartDAClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCartDAClearActionPerformed
        // Clear content of cart-array, list-array, and list
        ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Show welcome screen
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButCartDAClearActionPerformed

    @SuppressWarnings("unchecked")
    private void ButCartDARemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCartDARemoveActionPerformed
        int TickToDelete = ListCartDATicketList.getSelectedIndex();
        // If no item is selected, escape method call.
        if (TickToDelete == -1) {return;} 
        // Delete string from list-array and Ticket from shopping-array
        master.CartContent.remove(TickToDelete);
        master.SB.removeTicket(TickToDelete);
        // Remake list after deletion
        ListCartDATicketList.setListData((String[]) master.CartContent
                .toArray(new String[0]));
        // Recalculate total price
        LabCartDATotal.setText(WelcomeDA.languageBundle
                .getString("TOTAL PRIS: ")+master.SB.getTotalPrice()
                +WelcomeDA.languageBundle.getString(" DKK"));
    }//GEN-LAST:event_ButCartDARemoveActionPerformed

    private void ButCartDAAddMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCartDAAddMActionPerformed
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Switch to selection window
        master.ChangePanel(WelcomeDAClass);
    }//GEN-LAST:event_ButCartDAAddMActionPerformed

    private void ButCartDAPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCartDAPayActionPerformed
        // If no items in list, abort method call
        if (master.CartContent.isEmpty()) {return;}
        // Text for machine info label
        PayDAClass.LabPayDAInfo.setText(WelcomeDA.languageBundle
                .getString("MASKIN ID: ")+master.hardID+WelcomeDA.languageBundle
                        .getString("ZONE: ")+master.startZone);
        // Move to next window
        master.ChangePanel(PayDAClass);
    }//GEN-LAST:event_ButCartDAPayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JButton ButCartDAAddM;
    public javax.swing.JButton ButCartDAClear;
    public javax.swing.JButton ButCartDAHelp;
    public javax.swing.JButton ButCartDAPay;
    public javax.swing.JButton ButCartDARemove;
    public javax.swing.JLabel LabCartDAInfo;
    public javax.swing.JLabel LabCartDAInstruct;
    public javax.swing.JLabel LabCartDASTK;
    public javax.swing.JLabel LabCartDATime;
    public javax.swing.JLabel LabCartDATitle;
    public javax.swing.JLabel LabCartDATotal;
    public javax.swing.JLabel LabCartDKAmountZones;
    public javax.swing.JLabel LabCartDKPricePerTicket;
    public javax.swing.JLabel LabCartDKSubTotal;
    public javax.swing.JLabel LabCartDKType;
    public javax.swing.JList<String> ListCartDATicketList;
    public javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
