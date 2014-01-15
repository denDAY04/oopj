package GUI;

import java.awt.event.KeyEvent;

/**
 * Class for the Admin panel in GUI
 */
public class Admin extends javax.swing.JPanel {
    tvmGUI master;
    
    /**
     * Custom constructor
     * @param tvmGUI Reference to {@link tvmGUI}.
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
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InAdminSelection.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InAdminSelectionKeyPressed(evt);
            }
        });
        add(InAdminSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 314, 67, -1));

        LabAdminTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabAdminTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabAdminTitle.setText("Service");
        LabAdminTitle.setToolTipText("");
        add(LabAdminTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 780, -1));

        LabAdminInfo.setText(" ");
        add(LabAdminInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 354, -1));

        LabAdminTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabAdminTime.setText(" ");
        add(LabAdminTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 11, 321, -1));

        TextAdminMenu.setBackground(new java.awt.Color(240, 240, 240));
        TextAdminMenu.setColumns(20);
        TextAdminMenu.setRows(5);
        TextAdminMenu.setFocusable(false);
        jScrollPane3.setViewportView(TextAdminMenu);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 98, 359, 197));

        LabAdminSelection.setText("Valg :");
        add(LabAdminSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 317, -1, -1));

        TextAdminLog.setColumns(20);
        TextAdminLog.setRows(5);
        jScrollPane4.setViewportView(TextAdminLog);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 347, 589, 200));

        ButAdminOk.setText("Ok");
        ButAdminOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAdminOkActionPerformed(evt);
            }
        });
        add(ButAdminOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 313, -1, -1));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
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
    public javax.swing.JLabel BackgroundPIC;
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
