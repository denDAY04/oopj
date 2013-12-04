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

        LabCashDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabCashDATime.setText(" ");

        LabCashDAInfo.setText(" ");

        LabCashDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabCashDATitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCashDATitle.setText("Kontant betaling");

        LabCashDAInstruct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabCashDAInstruct.setText("Indsæt beløbet til betaling i feltet og tryk “Indsæt penge”. For penge tilbage, tryk \"Afbryd\".");

        LabCashDAInserted.setText("Penge indsat: ");

        LabCashDAMissing.setText("Mangler: ");

        ButCashDAPay.setText("Indsæt penge");
        ButCashDAPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAPayActionPerformed(evt);
            }
        });

        ButCashDAHelp.setText("?");
        ButCashDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAHelpActionPerformed(evt);
            }
        });

        ButCashDAClear.setText("Afbryd");
        ButCashDAClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDAClearActionPerformed(evt);
            }
        });

        ButCashDABack.setText("Tilbage");
        ButCashDABack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButCashDABackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabCashDAInserted, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LabCashDAMissing, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabCashDATitle, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(294, 294, 294))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(InCashDAInserted, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ButCashDAPay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(344, 344, 344))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButCashDAHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButCashDABack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(ButCashDAClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabCashDAInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                .addComponent(LabCashDATime, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabCashDAInstruct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabCashDATime)
                    .addComponent(LabCashDAInfo))
                .addGap(44, 44, 44)
                .addComponent(LabCashDATitle)
                .addGap(18, 18, 18)
                .addComponent(LabCashDAInstruct)
                .addGap(18, 18, 18)
                .addComponent(InCashDAInserted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabCashDAMissing)
                    .addComponent(LabCashDAInserted))
                .addGap(49, 49, 49)
                .addComponent(ButCashDAPay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButCashDAClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButCashDAHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButCashDABack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
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
                "\nBetaling gennemført."
                + "\nHusk din billet og byttepenge."
                + "\nFortsat god dag."
                + "\n"
                + "\nBlueJ Trakfikselskab","Betaling gennemført",
                JOptionPane.INFORMATION_MESSAGE);
            // Print tickets
            master.printTickets(this);
        } else if (missingMoney == 0) {
            // Print tickets
            master.printTickets(this);
            // Show dialog box about ticket printing
            JOptionPane.showMessageDialog(this,
                "\nBetaling gennemført."
                + "\nHusk din billet."
                + "\nFortsat god dag."
                + "\n"
                + "\nBlueJ Trakfikselskab","Betaling gennemført",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Update labes
            LabCashDAInserted.setText("Penge indsat: "+master.CH.getInsertedMoney()+" DKK");
            LabCashDAMissing.setText("Mangler: "+missingMoney+" DKK");
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
            LabCashDAInserted.setText("Penge indsat: ");
            // Reset selectionscreen's inputs
            master.resetSelectionScreen();
            // Go back to welcomeing screen
            master.ChangePanel(WelcomeDAClass);
        }
    }//GEN-LAST:event_ButCashDAPayActionPerformed

    private void ButCashDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            "\nFor hjælp ring xx xx xx xx"
            + "\nFor teknisk assistance ring xx xx xx xx"
            + "\nHusk at oplyse maskinens ID, som kan findes i øvre venstre hjørne."
            + "\n"
            + "\nBlueJ Trakfikselskab","Hjælp og teknisk support",
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
        master.ChangePanel(WelcomeDAClass);
        //Show dialog box about money returned
        JOptionPane.showMessageDialog(this,
            "\nDu har valgt at afbryde købet."
            + "\nSe slisken neden under betalingsmodulet"
            + "\nfor at modtage dine indsatte penge."
            + "\nFortsat god dag."
            + "\n"
            + "\nBlueJ Trakfikselskab","Afbryd af køb",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButCashDAClearActionPerformed

    private void ButCashDABackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButCashDABackActionPerformed
        // Set Cash pointer to null
        master.CH = null;
        // Go back to previous window
        master.ChangePanel(PayDAClass);
    }//GEN-LAST:event_ButCashDABackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
