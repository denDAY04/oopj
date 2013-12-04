package Interface;

import java.awt.Color;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nordahl
 */
public class Setup1 extends javax.swing.JPanel {
    tvmGUI master;
    Setup2 Setup2Class;
    /**
     * Creates new form Setup1
     */
    public Setup1(tvmGUI tvmGUI) {
        master = tvmGUI;
        initComponents(); 
    }
    
    public void setReferences(Setup2 refSetup2)
    {
        Setup2Class = refSetup2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabSetup1Title = new javax.swing.JLabel();
        LabSetup1HardwareID = new javax.swing.JLabel();
        InSetup1HardwareID = new javax.swing.JTextField();
        LabSetup1StartZone = new javax.swing.JLabel();
        InSetup1StartZone = new javax.swing.JTextField();
        ButSetup1Next = new javax.swing.JButton();
        LabSetup1Error = new javax.swing.JLabel();

        LabSetup1Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabSetup1Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSetup1Title.setText("Opsæt automat");
        LabSetup1Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LabSetup1HardwareID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSetup1HardwareID.setText("Indtast maskinens unikke ID kode");

        LabSetup1StartZone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSetup1StartZone.setText("Indtast start zone.");

        ButSetup1Next.setText("Næste");
        ButSetup1Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButSetup1NextActionPerformed(evt);
            }
        });

        LabSetup1Error.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabSetup1Error.setForeground(new java.awt.Color(255, 0, 0));
        LabSetup1Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabSetup1Error.setText("Fejl - Ugyldig indtastning");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(LabSetup1Title, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(InSetup1HardwareID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(LabSetup1StartZone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(InSetup1StartZone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(LabSetup1Error, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(289, 289, 289))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(LabSetup1HardwareID, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(255, 255, 255))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ButSetup1Next, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LabSetup1Title)
                .addGap(50, 50, 50)
                .addComponent(LabSetup1HardwareID)
                .addGap(6, 6, 6)
                .addComponent(InSetup1HardwareID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(LabSetup1StartZone)
                .addGap(3, 3, 3)
                .addComponent(InSetup1StartZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(LabSetup1Error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(ButSetup1Next, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButSetup1NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButSetup1NextActionPerformed

        master.hardID = master.isInteger(InSetup1HardwareID.getText());
        master.startZone = master.isInteger(InSetup1StartZone.getText());
        if(master.hardID == -1)
        {
            LabSetup1Error.setVisible(true);
            LabSetup1HardwareID.setForeground(Color.red);
        }
        else
        {
            LabSetup1HardwareID.setForeground(Color.black);
        }
        if(master.startZone == -1)
        {
            LabSetup1Error.setVisible(true);
            LabSetup1StartZone.setForeground(Color.red);
        }
        else
        {
            LabSetup1StartZone.setForeground(Color.black);
        }
        if (master.hardID !=-1 && master.startZone !=-1)
        {
            LabSetup1Error.setVisible(false);
            Setup2Class.LabSetup2Info.setText("Maskin ID: "+master.hardID+"  Zone: "+master.startZone);
            //switchWindow(Setup1, Setup2Class);
            master.ChangePanel(Setup2Class);
        }
    }//GEN-LAST:event_ButSetup1NextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButSetup1Next;
    public javax.swing.JTextField InSetup1HardwareID;
    public javax.swing.JTextField InSetup1StartZone;
    public javax.swing.JLabel LabSetup1Error;
    public javax.swing.JLabel LabSetup1HardwareID;
    public javax.swing.JLabel LabSetup1StartZone;
    public javax.swing.JLabel LabSetup1Title;
    // End of variables declaration//GEN-END:variables
}
