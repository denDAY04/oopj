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

        LabSMSDAInfo.setText(" ");

        LabSMSDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabSMSDATime.setText(" ");

        LabSMSDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabSMSDATitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSMSDATitle.setText("Betaling med SMS");

        LabSMSDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSMSDAInstruct.setText("Indtast telefonnummeret som regningen skal sendes til og tryk herefter på godkend. ");

        LabSMSDATotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabSMSDATotal.setText("Total pris: ");

        ButSMSDAConfirm.setText("Godkend");
        ButSMSDAConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAConfirmActionPerformed(evt);
            }
        });

        InSMSDAPhoneNMB.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ButSMSDAHelp.setText("?");
        ButSMSDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAHelpActionPerformed(evt);
            }
        });

        ButSMSDABack.setText("Tilbage");
        ButSMSDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDABackActionPerformed(evt);
            }
        });

        ButSMSDAClear.setText("Afbryd");
        ButSMSDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSMSDAClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabSMSDAInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(LabSMSDATime, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LabSMSDATitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabSMSDAInstruct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(342, 342, 342)
                                .addComponent(ButSMSDAConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabSMSDATotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(InSMSDAPhoneNMB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButSMSDAHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButSMSDABack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(ButSMSDAClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabSMSDAInfo)
                    .addComponent(LabSMSDATime))
                .addGap(44, 44, 44)
                .addComponent(LabSMSDATitle)
                .addGap(18, 18, 18)
                .addComponent(LabSMSDAInstruct)
                .addGap(18, 18, 18)
                .addComponent(InSMSDAPhoneNMB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LabSMSDATotal)
                .addGap(18, 18, 18)
                .addComponent(ButSMSDAConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButSMSDAHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButSMSDAClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButSMSDABack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
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
            // For each ticket
            for (int index=0;index<(master.SB.getCart().size());index++) {
                // Send the ticket to the statistics module
                master.ST.LogSale(master.SB.getCart().get(index));
            }
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
