/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.KeyEvent;

/**
 *
 * @author Nordahl
 */
public class Admin extends javax.swing.JPanel {
    tvmGUI master;
    /**
     * Creates new form Admin
     */
    public Admin(tvmGUI tvmGUI) {
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

        InAdminSelection = new javax.swing.JTextField();
        LabAdminTitle = new javax.swing.JLabel();
        LabAdminInfo = new javax.swing.JLabel();
        LabAdminTime = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextAdminMenu = new javax.swing.JTextArea();
        LabAdminSelection = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TextAdminLog = new javax.swing.JTextArea();
        ButAdminOk = new javax.swing.JButton();

        InAdminSelection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InAdminSelectionKeyPressed(evt);
            }
        });

        LabAdminTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabAdminTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabAdminTitle.setText("Service");
        LabAdminTitle.setToolTipText("");

        LabAdminInfo.setText(" ");

        LabAdminTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabAdminTime.setText(" ");

        TextAdminMenu.setBackground(new java.awt.Color(240, 240, 240));
        TextAdminMenu.setColumns(20);
        TextAdminMenu.setRows(5);
        TextAdminMenu.setFocusable(false);
        jScrollPane3.setViewportView(TextAdminMenu);

        LabAdminSelection.setText("Valg :");

        TextAdminLog.setColumns(20);
        TextAdminLog.setRows(5);
        jScrollPane4.setViewportView(TextAdminLog);

        ButAdminOk.setText("Ok");
        ButAdminOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAdminOkActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabAdminTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabAdminInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(LabAdminTime, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabAdminSelection)
                                .addGap(18, 18, 18)
                                .addComponent(InAdminSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(ButAdminOk)
                                .addGap(293, 293, 293))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabAdminInfo)
                    .addComponent(LabAdminTime))
                .addGap(26, 26, 26)
                .addComponent(LabAdminTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InAdminSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabAdminSelection)
                    .addComponent(ButAdminOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InAdminSelectionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InAdminSelectionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {  // Check if key pressed
            master.adminWriteData();                         // is ENTER
        }
    }//GEN-LAST:event_InAdminSelectionKeyPressed

    private void ButAdminOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAdminOkActionPerformed
        master.adminWriteData();
    }//GEN-LAST:event_ButAdminOkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButAdminOk;
    public javax.swing.JTextField InAdminSelection;
    public javax.swing.JLabel LabAdminInfo;
    public javax.swing.JLabel LabAdminSelection;
    public javax.swing.JLabel LabAdminTime;
    public javax.swing.JLabel LabAdminTitle;
    public javax.swing.JTextArea TextAdminLog;
    public javax.swing.JTextArea TextAdminMenu;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}