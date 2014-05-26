package GUI.Admin;

import GUI.System.GUIFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for displaying all terminals. This also allows for changing of a
 * terminal's data.
 */
public class TerminalListAdminPanel extends javax.swing.JPanel {

    private final DefaultTableModel tableModel;
    private GUIFrame frame;

    /**
     * Custom constructor which also sets the column names of the table.
     */
    public TerminalListAdminPanel() {
        initComponents();
        tableModel = (DefaultTableModel) tableTerminalList.getModel();
        tableTerminalList.getColumnModel().getColumn(0).setHeaderValue(
                "ID number");
        tableTerminalList.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(1).
                setHeaderValue("Address");
        tableTerminalList.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(2).setHeaderValue(
                "Zip code");
        tableTerminalList.getColumnModel().getColumn(2).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(3).setHeaderValue(
                "Charging status");
        tableTerminalList.getColumnModel().getColumn(3).setPreferredWidth(35);
        tableTerminalList.getColumnModel().getColumn(4).setHeaderValue(
                "Offline since");
        tableTerminalList.getColumnModel().getColumn(4).setPreferredWidth(30);
        tableTerminalList.getColumnModel().getColumn(5).setHeaderValue(
                "IP address");
        tableTerminalList.getColumnModel().getColumn(5).setPreferredWidth(20);
        tableTerminalList.getColumnModel().getColumn(6).setHeaderValue(
                "Install status");
        tableTerminalList.getColumnModel().getColumn(6).setPreferredWidth(30);
        tableTerminalList.getSelectionModel().addListSelectionListener(
                new CustomSelectionListener());
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
     * Load all terminals into the JTable.
     */
    public void loadPage() {
        clearTable();
        ArrayList<String[]> list = frame.tManager.getAllTerminals();
        for (String[] iter : list) {
            tableModel.addRow(iter);
        }
    }

    /**
     * Clear the JTable.
     */
    private void clearTable() {
        /* First clear the selection in order to ensure that no erros occour due
         to selection listener.
         */
        tableTerminalList.clearSelection();

        while (tableModel.getRowCount() != 0) {
            tableModel.removeRow(0);
        }
    }

    /**
     * Reset input fields.
     */
    private void resetPage() {
        textAddress.setText("");
        textZipCode.setText("");
        comboChargingStatus.setSelectedIndex(0);
        textOfflineSince.setText("");
        textIPAddress.setText("");
        comboInstallStatus.setSelectedIndex(0);
    }

    /**
     * Custom ListSelectionListener for the table. With this, whenever a
     * terminal is selected in the table, its data is written to the input
     * fields in which the administrator can then change them.
     */
    class CustomSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            int row = tableTerminalList.getSelectedRow();
            /* If no rows are selected, it is likely because they are being 
             removed, so it should not try and collect data.
             */
            if (row == -1) {
                return;
            }

            textAddress.setText((String) tableTerminalList.getValueAt(row, 1));
            textZipCode.setText((String) tableTerminalList.getValueAt(row, 2));
            String chargingStatus = (String) tableTerminalList.
                    getValueAt(row, 3);
            if (chargingStatus.equals("IDLE")) {
                comboChargingStatus.setSelectedIndex(0);
            } else {
                comboChargingStatus.setSelectedIndex(1);
            }
            textOfflineSince.setText((String) tableTerminalList.getValueAt(row,
                    4));
            textIPAddress.setText((String) tableTerminalList.getValueAt(row, 5));
            String installStatus = (String) tableTerminalList.getValueAt(row, 6);
            if (installStatus.equals("PENDEP")) {
                comboInstallStatus.setSelectedIndex(0);
            } else if (installStatus.equals("ENABLE")) {
                comboInstallStatus.setSelectedIndex(1);
            } else {
                comboInstallStatus.setSelectedIndex(2);
            }
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
        btnEditTerminal = new javax.swing.JButton();
        textAddress = new javax.swing.JTextField();
        labAddress = new javax.swing.JLabel();
        textZipCode = new javax.swing.JTextField();
        labZipCode = new javax.swing.JLabel();
        labChargingStatus = new javax.swing.JLabel();
        textOfflineSince = new javax.swing.JTextField();
        labOfflineSince = new javax.swing.JLabel();
        textIPAddress = new javax.swing.JTextField();
        labIPAddress = new javax.swing.JLabel();
        labInstallStatus = new javax.swing.JLabel();
        btnAddNewTerminal = new javax.swing.JButton();
        labNewTerminalInstructions = new javax.swing.JLabel();
        comboInstallStatus = new javax.swing.JComboBox();
        comboChargingStatus = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(402, 302));

        labChargingStationList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labChargingStationList.setText("List of Charging Stations");

        labInformation.setText("Below you will see a list of all the charging station in the country.");

        tableTerminalList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        )
        {public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tableTerminalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tableScrollPane.setViewportView(tableTerminalList);

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
    });

    btnEditTerminal.setText("Edit selection");
    btnEditTerminal.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnEditTerminalActionPerformed(evt);
        }
    });

    labAddress.setText("Address");

    labZipCode.setText("Zip code");

    labChargingStatus.setText("Charging status");

    labOfflineSince.setText("Offline since");

    labIPAddress.setText("IP address");

    labInstallStatus.setText("Install status");

    btnAddNewTerminal.setText("Add new terminal");
    btnAddNewTerminal.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddNewTerminalActionPerformed(evt);
        }
    });

    labNewTerminalInstructions.setText("If you wish to add a new terminal to the list fill in the fields 'Address', 'Zip Code', and 'IP address'. Leave the others blank.");

    comboInstallStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDEP", "ENABLE", "DISABL" }));

    comboChargingStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IDLE", "CHAR" }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labChargingStationList)
                .addComponent(labInformation)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(123, 123, 123)
                            .addComponent(btnAddNewTerminal))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labAddress))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textZipCode))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labChargingStatus)
                                .addComponent(comboChargingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labOfflineSince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textOfflineSince))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labIPAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textIPAddress))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labInstallStatus)
                                .addComponent(comboInstallStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnEditTerminal)))
                .addComponent(labNewTerminalInstructions))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labNewTerminalInstructions)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(labAddress)
                .addComponent(labZipCode)
                .addComponent(labChargingStatus)
                .addComponent(labOfflineSince)
                .addComponent(labIPAddress)
                .addComponent(labInstallStatus))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textOfflineSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(textIPAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboInstallStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(comboChargingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnBack)
                .addComponent(btnEditTerminal)
                .addComponent(btnAddNewTerminal))
            .addGap(20, 20, 20))
    );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change to administrator's control panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        resetPage();
        clearTable();
        frame.changePanel("card11");
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Collect data from the input fields and use them to change the terminal in
     * the database.
     *
     * @param evt ActionEvent
     */
    private void btnEditTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTerminalActionPerformed
        if (tableTerminalList.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this,
                    "No terminal was selected for editing. ");
            return;
        }
        int terminalID = Integer.parseInt((String) tableModel.getValueAt(
                tableTerminalList.getSelectedRow(), 0));
        System.err.println("" + terminalID);
        String address = textAddress.getText();
        String zipCode = textZipCode.getText();
        String chargingStatus;
        int chargingSelect = comboInstallStatus.getSelectedIndex();
        if (chargingSelect == 0) {
            chargingStatus = "IDLE";
        } else {
            chargingStatus = "CHAR";
        }
        String offlineSince = textOfflineSince.getText().toUpperCase();
        String ipAddress = textIPAddress.getText();
        String installStatus;
        int installSelect = comboInstallStatus.getSelectedIndex();
        if (installSelect == 0) {
            installStatus = "PENDEP";
        } else if (installSelect == 1) {
            installStatus = "ENABLE";
        } else {
            installStatus = "DISABL";
        }
        String[] arr = {address, zipCode, chargingStatus, offlineSince, ipAddress, installStatus};
        for (String element : arr) {
            if (element.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "One or more fields are empty. Could not edit data.");
                return;
            }
        }
        frame.tManager.editFullTerminal(arr, terminalID);
        loadPage();
    }//GEN-LAST:event_btnEditTerminalActionPerformed

    /**
     * Collect some of the data from the input fields required to create a new
     * terminal im the database.
     *
     * @param evt ActionEvent
     */
    private void btnAddNewTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewTerminalActionPerformed
        String address = textAddress.getText();
        String zipCode = textZipCode.getText();
        String ipAddress = textIPAddress.getText();
        if (address.isEmpty() || zipCode.isEmpty() || ipAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "One or more of the required fiels are empty.\n Could not create ne terminal.");
            return;
        }
        frame.tManager.addTerminal(address, zipCode, ipAddress);
        loadPage();
    }//GEN-LAST:event_btnAddNewTerminalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewTerminal;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditTerminal;
    private javax.swing.JComboBox comboChargingStatus;
    private javax.swing.JComboBox comboInstallStatus;
    private javax.swing.JLabel labAddress;
    private javax.swing.JLabel labChargingStationList;
    private javax.swing.JLabel labChargingStatus;
    private javax.swing.JLabel labIPAddress;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labInstallStatus;
    private javax.swing.JLabel labNewTerminalInstructions;
    private javax.swing.JLabel labOfflineSince;
    private javax.swing.JLabel labZipCode;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable tableTerminalList;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textIPAddress;
    private javax.swing.JTextField textOfflineSince;
    private javax.swing.JTextField textZipCode;
    // End of variables declaration//GEN-END:variables
}