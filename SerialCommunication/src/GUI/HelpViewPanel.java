/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author Jonas
 */
public class HelpViewPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignupCongratulationsPanel
     */
    public HelpViewPanel() {
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

        jDialog1 = new javax.swing.JDialog();
        labCongratulations = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labWelcomeText = new javax.swing.JTextPane();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labCongratulations.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labCongratulations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCongratulations.setText("Help");
        labCongratulations.setToolTipText("");
        add(labCongratulations, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, 100, 677, 29));

        labWelcomeText.setText("Insert text here....");
        labWelcomeText.setAutoscrolls(false);
        labWelcomeText.setFocusable(false);
        jScrollPane1.setViewportView(labWelcomeText);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 530, 200));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labCongratulations;
    private javax.swing.JTextPane labWelcomeText;
    // End of variables declaration//GEN-END:variables
}
