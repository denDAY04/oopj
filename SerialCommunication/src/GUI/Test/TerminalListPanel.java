/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Test;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author AndreasStensig
 */
public class TerminalListPanel extends javax.swing.JPanel {

    private final DefaultTableModel tableModel;
    private GUIFrame frame;
    
    /**
     * Creates new form ChargingStationListViewPanel
     */
    public TerminalListPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tableTerminalList.getModel();
        tableTerminalList.getColumnModel().getColumn(0).setHeaderValue("ID number");
        tableTerminalList.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableTerminalList.getColumnModel().getColumn(1).setHeaderValue("Address");
        tableTerminalList.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(2).setHeaderValue("Zip code");
        tableTerminalList.getColumnModel().getColumn(2).setPreferredWidth(12);
        tableTerminalList.getColumnModel().getColumn(3).setHeaderValue("Charging status");
        tableTerminalList.getColumnModel().getColumn(3).setPreferredWidth(30);
        tableTerminalList.getColumnModel().getColumn(4).setHeaderValue("Offline since");
        tableTerminalList.getColumnModel().getColumn(4).setPreferredWidth(30);
    }
    
    public void setFrame(GUI.Test.GUIFrame frame) {
        this.frame = frame;
    }
    
    public void loadTerminalDetails() {
        clearTable();
        ArrayList<String[]> list = frame.tManager.getAllTerminals();
        for (String[] iter : list) {
            String[] temp = {iter[0], iter[1], iter[2], iter[3], iter[4]};
            tableModel.addRow(temp);
        }
    }
    
    private void clearTable() {
        /* First clear the selection in order to ensure that no erros occour due
        to selection listener.
        */
        tableTerminalList.clearSelection();
        while(tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labChargingStationList = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        tableTerminalList = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(402, 302));

        labChargingStationList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labChargingStationList.setText("List of Charging Stations");

        labInformation.setText("Below you will see a list of all the charging station in the country.");

        tableTerminalList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        )
        //{public boolean isCellEditable(int row, int column){
            //    return false;
            //}
        //}
    );
    tableTerminalList.setFocusable(false);
    tableTerminalList.setRowSelectionAllowed(false);
    tableTerminalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tableScrollPane.setViewportView(tableTerminalList);

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
    });

    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labChargingStationList)
                .addComponent(labInformation)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnBack)
                    .addGap(18, 18, 18)
                    .addComponent(jButton1)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(layout.createSequentialGroup()
            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labChargingStationList)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labInformation)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnBack)
                .addComponent(jButton1))
            .addGap(20, 20, 20))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        clearTable();
        frame.changePanel("card2");
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tableTerminalList.getColumnModel().getColumn(0).setPreferredWidth(10);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labChargingStationList;
    private javax.swing.JLabel labInformation;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable tableTerminalList;
    // End of variables declaration//GEN-END:variables
}
