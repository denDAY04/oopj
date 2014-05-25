package GUI.User;

import GUI.System.GUIFrame;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Panel with a list of all terminals, for a customer's view.
 */
public class TerminalListPanel extends javax.swing.JPanel {

    private final DefaultTableModel tableModel;
    private GUIFrame frame;

    /**
     * Custom constructor.
     */
    public TerminalListPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tableTerminalList.getModel();
        tableTerminalList.getColumnModel().getColumn(0).setHeaderValue(
                "ID number");
        tableTerminalList.getColumnModel().getColumn(0).setPreferredWidth(10);
        tableTerminalList.getColumnModel().getColumn(1).
                setHeaderValue("Address");
        tableTerminalList.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(2).setHeaderValue(
                "Zip code");
        tableTerminalList.getColumnModel().getColumn(2).setPreferredWidth(12);
        tableTerminalList.getColumnModel().getColumn(3).setHeaderValue(
                "Charging status");
        tableTerminalList.getColumnModel().getColumn(3).setPreferredWidth(30);
        tableTerminalList.getColumnModel().getColumn(4).setHeaderValue(
                "Offline since");
        tableTerminalList.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    /**
     * Setter for GUIFrame reference.
     *
     * @param frame GUIFrame object.
     */
    public void setFrame(GUI.System.GUIFrame frame) {
        this.frame = frame;
    }

    /**
     * Load fields.
     */
    public void loadPage() {
        resetPage();
        ArrayList<String[]> list = frame.tManager.getAllTerminals();
        for (String[] iter : list) {
            String[] temp = {iter[0], iter[1], iter[2], iter[3], iter[4]};
            tableModel.addRow(temp);
        }
    }

    /**
     * Reset fields.
     */
    private void resetPage() {
        /* First clear the selection in order to ensure that no erros occour due
         to selection listener.
         */
        tableTerminalList.clearSelection();

        while (tableModel.getRowCount() != 0) {
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
        {public boolean isCellEditable(int row, int column){
            return false;
        }
    }
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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labChargingStationList)
                .addComponent(labInformation)
                .addComponent(btnBack)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(labChargingStationList)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(labInformation)
            .addGap(13, 13, 13)
            .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnBack)
            .addGap(20, 20, 20))
    );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change to account panel.
     *
     * @param evt
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        resetPage();
        frame.changePanel("card2");
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel labChargingStationList;
    private javax.swing.JLabel labInformation;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable tableTerminalList;
    // End of variables declaration//GEN-END:variables
}
