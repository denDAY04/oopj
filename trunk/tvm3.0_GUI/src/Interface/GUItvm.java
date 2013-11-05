package Interface;

import MachineLogic.CreatedTickets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mathias Rasmussen
 */
public class GUItvm extends javax.swing.JFrame {
    
    private UserInterface UI = new UserInterface();
    private CreatedTickets CT = new CreatedTickets();
    public GUItvm() {
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

        jPanel1 = new javax.swing.JPanel();
        hardwareID = new javax.swing.JTextField();
        enterID = new javax.swing.JLabel();
        opsætNext = new javax.swing.JButton();
        opsætAuto = new javax.swing.JLabel();
        startZon = new javax.swing.JLabel();
        startZonText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        opsætAuto1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        typeDaText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        typeEngText = new javax.swing.JTextField();
        saveAndQuit = new javax.swing.JToggleButton();
        addMore = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        zonePriceText = new javax.swing.JTextField();
        errorLabel1 = new javax.swing.JLabel();
        backBut1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        welcomLabel = new javax.swing.JLabel();
        selLangLabel = new javax.swing.JLabel();
        daBut = new javax.swing.JButton();
        engBut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(hardwareID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 184, -1));

        enterID.setText("Indtast maskinens unikke ID kode: ");
        jPanel1.add(enterID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        opsætNext.setText("Næste");
        opsætNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsætNextActionPerformed(evt);
            }
        });
        jPanel1.add(opsætNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, 30));

        opsætAuto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opsætAuto.setText("Opsætning af automat");
        jPanel1.add(opsætAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 281, -1));

        startZon.setText("Indtast start zone:");
        jPanel1.add(startZon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 230, -1));
        jPanel1.add(startZonText, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 180, -1));

        getContentPane().add(jPanel1, "card2");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opsætAuto1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        opsætAuto1.setText("Opsætning af automat");
        jPanel2.add(opsætAuto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 281, -1));

        jLabel1.setText("Indtast navnet på billettypen på dansk:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 240, -1));
        jPanel2.add(typeDaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 270, -1));

        jLabel2.setText("Indtast navnet på billettypen på engelsk:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 240, -1));
        jPanel2.add(typeEngText, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 270, -1));

        saveAndQuit.setText("Gem og afslut");
        saveAndQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndQuitActionPerformed(evt);
            }
        });
        jPanel2.add(saveAndQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        addMore.setText("Tilføj flere");
        addMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoreActionPerformed(evt);
            }
        });
        jPanel2.add(addMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 80, -1));

        jLabel3.setText("Indtast pris pr. zone:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 170, -1));
        jPanel2.add(zonePriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 270, -1));

        errorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(errorLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 310, -1));

        backBut1.setText("Tilbage");
        backBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBut1ActionPerformed(evt);
            }
        });
        jPanel2.add(backBut1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        getContentPane().add(jPanel2, "card3");

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcomLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        welcomLabel.setText("Welcome to BlueJ Trafikselskab/Velkommen til BlueJ Trafikselskab");
        jPanel3.add(welcomLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 460, -1));

        selLangLabel.setText("Select language / Vælg sprog");
        jPanel3.add(selLangLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 64, -1, -1));

        daBut.setText(" Danish / Dansk");
        daBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daButActionPerformed(evt);
            }
        });
        jPanel3.add(daBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 96, 140, -1));

        engBut.setText("English / Engelsk");
        engBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engButActionPerformed(evt);
            }
        });
        jPanel3.add(engBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 137, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("2.");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 20, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("1.");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 20, -1));

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Variables
    private int hardID;
    private int startZone;
    private void opsætNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsætNextActionPerformed
        hardID = (int) Integer.parseInt(hardwareID.getText());
        startZone = (int) Integer.parseInt(startZonText.getText());
        System.out.println(""+hardID);
        System.out.println(""+startZone);
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);       
    }//GEN-LAST:event_opsætNextActionPerformed

    private void addMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoreActionPerformed
        if ((int) Integer.parseInt(zonePriceText.getText()) <= 0 || typeDaText.getText().equals("") || typeEngText.getText().equals(""))
        {
            errorLabel1.setText("Error - Et eller flere felter er tomme.");
        }
        else
        {
            CT.addTicket((int) Integer.parseInt(zonePriceText.getText()), typeDaText.getText(), typeEngText.getText(), startZone);
            zonePriceText.setText(""); typeDaText.setText(""); typeEngText.setText("");
            errorLabel1.setText("");
        }

        addMore.setSelected(false);
    }//GEN-LAST:event_addMoreActionPerformed

    private void saveAndQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndQuitActionPerformed
        if ((int) Integer.parseInt(zonePriceText.getText()) == 0 || typeDaText.getText().equals("") || typeEngText.getText().equals("") || CT.getArray().isEmpty())
        {
            errorLabel1.setText("Error - Der er ikke oprettet nogle billeter.");
        }
        else 
        {
            CT.addTicket((int) Integer.parseInt(zonePriceText.getText()), typeDaText.getText(), typeEngText.getText(), startZone);
            jPanel2.setVisible(false);
            jPanel3.setVisible(true);
        }
        saveAndQuit.setSelected(false);
    }//GEN-LAST:event_saveAndQuitActionPerformed

    private void backBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBut1ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
    }//GEN-LAST:event_backBut1ActionPerformed

    private void daButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daButActionPerformed

    private void engButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engButActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_engButActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUItvm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUItvm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUItvm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUItvm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUItvm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addMore;
    private javax.swing.JButton backBut1;
    private javax.swing.JButton daBut;
    private javax.swing.JButton engBut;
    private javax.swing.JLabel enterID;
    private javax.swing.JLabel errorLabel1;
    private javax.swing.JTextField hardwareID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel opsætAuto;
    private javax.swing.JLabel opsætAuto1;
    private javax.swing.JButton opsætNext;
    private javax.swing.JToggleButton saveAndQuit;
    private javax.swing.JLabel selLangLabel;
    private javax.swing.JLabel startZon;
    private javax.swing.JTextField startZonText;
    private javax.swing.JTextField typeDaText;
    private javax.swing.JTextField typeEngText;
    private javax.swing.JLabel welcomLabel;
    private javax.swing.JTextField zonePriceText;
    // End of variables declaration//GEN-END:variables
}
