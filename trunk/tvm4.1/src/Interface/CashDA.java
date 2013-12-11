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
public class CashDA extends javax.swing.JPanel {
    tvmGUI master;
    WelcomeDA WelcomeDAClass;
    CartDA CartDAClass;
    PayDA PayDAClass;
    /**
     * Creates new form CashDA
     */
    public CashDA(tvmGUI tvmGUI) {
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

        LabCashDATime = new javax.swing.JLabel();
        LabCashDAInfo = new javax.swing.JLabel();
        LabCashDATitle = new javax.swing.JLabel();
        LabCashDAInstruct = new javax.swing.JLabel();
        InCashDAInserted = new javax.swing.JTextField();
        LabCashDAInserted = new javax.swing.JLabel();
        LabCashDAMissing = new javax.swing.JLabel();
        ButCashDAPay = new javax.swing.JButton();
        ButCashDAHelp = new javax.swing.JButton();
        ButCashDAClear = new javax.swing.JButton();
        ButCashDABack = new javax.swing.JButton();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabCashDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabCashDATime.setText(" ");
        add(LabCashDATime, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 11, 268, -1));

        LabCashDAInfo.setText(" ");
        add(LabCashDAInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 300, -1));

        LabCashDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabCashDATitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Interface/Bundle"); // NOI18N
        LabCashDATitle.setText(bundle.getString("KONTANT BETALING")); // NOI18N
        add(LabCashDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 69, 209, -1));

        LabCashDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCashDAInstruct.setText("Indsæt beløbet til betaling i feltet og tryk “Indsæt penge”. For penge tilbage, tryk \"Afbryd\".");
        add(LabCashDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 116, 780, -1));
        add(InCashDAInserted, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 148, 102, -1));

        LabCashDAInserted.setText(bundle.getString("PENGE INDSAT: ")); // NOI18N
        add(LabCashDAInserted, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 186, 142, -1));

        LabCashDAMissing.setText(bundle.getString("MANGLER: ")); // NOI18N
        add(LabCashDAMissing, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 186, 121, -1));

        ButCashDAPay.setText(bundle.getString("INDSÆT PENGE")); // NOI18N
        ButCashDAPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAPayActionPerformed(evt);
            }
        });
        add(ButCashDAPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 249, 110, 56));

        ButCashDAHelp.setText(bundle.getString("?")); // NOI18N
        ButCashDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAHelpActionPerformed(evt);
            }
        });
        add(ButCashDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 552, 49, 37));

        ButCashDAClear.setText(bundle.getString("AFBRYD")); // NOI18N
        ButCashDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAClearActionPerformed(evt);
            }
        });
        add(ButCashDAClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 552, 100, 37));

        ButCashDABack.setText(bundle.getString("TILBAGE")); // NOI18N
        ButCashDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDABackActionPerformed(evt);
            }
        });
        add(ButCashDABack, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 552, 100, 37));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    
    public void setReferences(WelcomeDA refWelcomeDA, CartDA refCartDA, PayDA refPayDA)
    {
        WelcomeDAClass = refWelcomeDA;
        CartDAClass = refCartDA;
        PayDAClass = refPayDA;
    }
    
    private void ButCashDAPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDAPayActionPerformed
        int insertedMoney = Integer.parseInt(InCashDAInserted.getText());
        int missingMoney = master.CH.MakePaymentInt(insertedMoney);

        if (missingMoney < 0) {
            // Show dialog box about ticket printing and money-change
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT.")
                + WelcomeDA.languageBundle.getString("HUSK DIN BILLET OG BYTTEPENGE.")
                + WelcomeDA.languageBundle.getString("FORTSAT GOD DAG.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT"),
                JOptionPane.INFORMATION_MESSAGE);
            // Print tickets
            master.printTickets(this);
            
            LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: "));
            InCashDAInserted.setText(null);
        
        } else if (missingMoney == 0) {
            // Print tickets
            master.printTickets(this);
            
            LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: "));
            InCashDAInserted.setText(null);
            
            
            // Show dialog box about ticket printing
            JOptionPane.showMessageDialog(this,
                WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT.")
                + WelcomeDA.languageBundle.getString("HUSK DIN BILLET.")
                + WelcomeDA.languageBundle.getString("FORTSAT GOD DAG.")
                + "\n"
                + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("BETALING GENNEMFØRT"),
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Update labes
            LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: ")+master.CH.getInsertedMoney()+WelcomeDA.languageBundle.getString("DKK"));
            LabCashDAMissing.setText(WelcomeDA.languageBundle.getString("MANGLER: ")+missingMoney+WelcomeDA.languageBundle.getString("DKK"));
            // Return to avoid resetting to welcomming screen
            return;
        }
        //If not out of order
        if (!master.outOfOrder) {
            // Set Cash pointer to null
            master.CH = null;
            // Clear content of cart-array, list-array, and list
            CartDAClass.ListCartDATicketList.removeAll();
            master.CartContent.clear();
            master.SB.clearCart();
            // Reset inserted money label
            LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: "));
            // Reset selectionscreen's inputs
            master.resetSelectionScreen();
            // Go back to welcomeing screen
            master.ChangePanel(WelcomeDAClass);
        }
    }//GEN-LAST:event_ButCashDAPayActionPerformed

    private void ButCashDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("FOR HJÆLP RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("FOR TEKNISK ASSISTANCE RING XX XX XX XX")
            + WelcomeDA.languageBundle.getString("HUSK AT OPLYSE MASKINENS ID, SOM KAN FINDES I ØVRE VENSTRE HJØRNE.")
            + "\n"
            + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("HJÆLP OG TEKNISK SUPPORT"),
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButCashDAHelpActionPerformed

    private void ButCashDAClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDAClearActionPerformed
        // Set Cash pointer to null
        master.CH = null;
        // Clear content of cart-array, list-array, and list
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        // Reset selectionscreen's inputs
        master.resetSelectionScreen();
        // Go back to welcomming screen
        
        
        LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: "));
        InCashDAInserted.setText(null);
        
        master.ChangePanel(WelcomeDAClass);
        //Show dialog box about money returned
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("DU HAR VALGT AT AFBRYDE KØBET.")
            + WelcomeDA.languageBundle.getString("SE SLISKEN NEDEN UNDER BETALINGSMODULET")
            + WelcomeDA.languageBundle.getString("FOR AT MODTAGE DINE INDSATTE PENGE.")
            + WelcomeDA.languageBundle.getString("FORTSAT GOD DAG.")
            + "\n"
            + WelcomeDA.languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),WelcomeDA.languageBundle.getString("AFBRYD AF KØB"),
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButCashDAClearActionPerformed

    private void ButCashDABackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDABackActionPerformed
        // Set Cash pointer to null
        master.CH = null;
        
        LabCashDAInserted.setText(WelcomeDA.languageBundle.getString("PENGE INDSAT: "));
        InCashDAInserted.setText(null);
        
        // Go back to previous window
        master.ChangePanel(PayDAClass);
        //Show dialog box about money returned
        JOptionPane.showMessageDialog(this,
            WelcomeDA.languageBundle.getString("RETURNERER INDKASTED PENGE")
            + WelcomeDA.languageBundle.getString("SE SLISKEN NEDEN UNDER BETALINGSMODULET")
            + WelcomeDA.languageBundle.getString("FOR AT MODTAGE DINE INDSATTE PENGE."));
    }//GEN-LAST:event_ButCashDABackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JButton ButCashDABack;
    public javax.swing.JButton ButCashDAClear;
    public javax.swing.JButton ButCashDAHelp;
    public javax.swing.JButton ButCashDAPay;
    public javax.swing.JTextField InCashDAInserted;
    public javax.swing.JLabel LabCashDAInfo;
    public javax.swing.JLabel LabCashDAInserted;
    public javax.swing.JLabel LabCashDAInstruct;
    public javax.swing.JLabel LabCashDAMissing;
    public javax.swing.JLabel LabCashDATime;
    public javax.swing.JLabel LabCashDATitle;
    // End of variables declaration//GEN-END:variables
}
