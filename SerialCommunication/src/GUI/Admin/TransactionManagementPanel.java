package GUI.Admin;

import GUI.System.GUIFrame;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * * Panel with two JTables for deposits and billings, separately. This is
 * viewed by the administrator without posing as a customer.
 */
public class TransactionManagementPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private GUIFrame frame;
    private ArrayList<String[]> billingList;
    private ArrayList<String[]> depositList;

    /**
     * Custom constructor that also sets the column labels of the JTables.
     */
    public TransactionManagementPanel() {
        initComponents();
        tableDepositHistory.getColumnModel().getColumn(0).setHeaderValue(
                "Number");
        tableDepositHistory.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableDepositHistory.getColumnModel().getColumn(1).setHeaderValue(
                "Customer");
        tableDepositHistory.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableDepositHistory.getColumnModel().getColumn(2).setHeaderValue(
                "Deposit Date");
        tableDepositHistory.getColumnModel().getColumn(2).setPreferredWidth(15);
        tableDepositHistory.getColumnModel().getColumn(3).setHeaderValue(
                "Amount(DKK)");
        tableDepositHistory.getColumnModel().getColumn(3).setPreferredWidth(15);
        tableDepositHistory.getColumnModel().getColumn(4).setHeaderValue(
                "Balance(DKK)");
        tableDepositHistory.getColumnModel().getColumn(4).setPreferredWidth(20);
        tableDepositHistory.getColumnModel().getColumn(5).setHeaderValue(
                "Ref. number");
        tableDepositHistory.getColumnModel().getColumn(5).setPreferredWidth(15);
        tableDepositHistory.getColumnModel().getColumn(6).setHeaderValue(
                "Card number");

        tableBillingHistory.getColumnModel().getColumn(0).setHeaderValue(
                "Number");
        tableBillingHistory.getColumnModel().getColumn(0).setPreferredWidth(15);
        tableBillingHistory.getColumnModel().getColumn(1).setHeaderValue(
                "Customer");
        tableBillingHistory.getColumnModel().getColumn(1).setPreferredWidth(35);
        tableBillingHistory.getColumnModel().getColumn(2).setHeaderValue(
                "Hw number");
        tableBillingHistory.getColumnModel().getColumn(2).setPreferredWidth(35);
        tableBillingHistory.getColumnModel().getColumn(3).setHeaderValue(
                "Start charge");
        tableBillingHistory.getColumnModel().getColumn(3).setPreferredWidth(90);
        tableBillingHistory.getColumnModel().getColumn(4).setHeaderValue(
                "Amount(DKK)");
        tableBillingHistory.getColumnModel().getColumn(4).setPreferredWidth(60);
        tableBillingHistory.getColumnModel().getColumn(5).setHeaderValue("Rate");
        tableBillingHistory.getColumnModel().getColumn(5).setPreferredWidth(10);
        tableBillingHistory.getColumnModel().getColumn(6).setHeaderValue("Wh");
        tableBillingHistory.getColumnModel().getColumn(6).setPreferredWidth(10);
        tableBillingHistory.getColumnModel().getColumn(7).setHeaderValue(
                "Balance(DKK)");
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
     * Load all billings and deposits into the two tables, with simple details.
     */
    public void loadPage() {
        tableModel = (DefaultTableModel) tableBillingHistory.getModel();
        clearTable(tableModel);
        billingList = frame.bManager.getAllBillings();
        for (String[] iter : billingList) {
            tableModel.addRow(iter);
        }

        tableModel = (DefaultTableModel) tableDepositHistory.getModel();
        clearTable(tableModel);
        depositList = frame.depManager.getAllDeposits();
        for (String[] iter : depositList) {
            tableModel.addRow(iter);
        }
    }

    /**
     * Clear the content of the table to which the parameterized TableModel
     * belongs.
     *
     * @param tableModle TableModel object of the JTable to clear of data.
     */
    private void clearTable(DefaultTableModel tableModle) {
        if (tableModle != null) {
            while (tableModle.getRowCount() != 0) {
                tableModle.removeRow(0);
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

        labTransactionHistory = new javax.swing.JLabel();
        labInformation = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        tableBillingHistory = new javax.swing.JTable();
        labInformation2 = new javax.swing.JLabel();
        tableScrollPane1 = new javax.swing.JScrollPane();
        tableDepositHistory = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        textSearchDep = new javax.swing.JTextField();
        labSearchDep = new javax.swing.JLabel();
        textSearchBil = new javax.swing.JTextField();
        labSearchBil = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(402, 302));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTransactionHistory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTransactionHistory.setText("Transaction History");
        add(labTransactionHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        labInformation.setText("Below you will see a history of all billings and deposits currently in the system.");
        add(labInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 430, 23));

        tableBillingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        )
        {public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tableScrollPane.setViewportView(tableBillingHistory);

    add(tableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 312, 679, 161));

    labInformation2.setText("You can search for deposits by Ref. number, or search billings by transaction number.");
    add(labInformation2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, 460, -1));

    tableDepositHistory.setModel(new javax.swing.table.DefaultTableModel(
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
    tableScrollPane1.setViewportView(tableDepositHistory);

    add(tableScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 114, 679, 161));

    jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
    jLabel1.setText("Deposits");
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 70, -1));

    jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
    jLabel2.setText("Billings");
    add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 286, 54, -1));

    btnBack.setText("Back");
    btnBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
    });
    add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 484, 69, -1));

    textSearchDep.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            textSearchDepKeyReleased(evt);
        }
    });
    add(textSearchDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 90, -1));

    labSearchDep.setText("Search deposits");
    add(labSearchDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

    textSearchBil.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            textSearchBilKeyReleased(evt);
        }
    });
    add(textSearchBil, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 90, -1));

    labSearchBil.setText("Search billings");
    add(labSearchBil, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
/**
     * Clear tables and change to administrator's customer-account panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        clearTable((DefaultTableModel) tableBillingHistory.getModel());
        clearTable((DefaultTableModel) tableDepositHistory.getModel());
        frame.changePanel("card11");
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * When a key is released in the deposit search field, search for a deposit
     * with the matching deposit number, if input text is at least 5 characters.
     *
     * @param evt KeyEvent
     */
    private void textSearchDepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchDepKeyReleased

        if (textSearchDep.getText().length() == 5) {
            try {
                int ExternalReferenceNumb = Integer.parseInt(textSearchDep.
                        getText());
                if (ExternalReferenceNumb <= 0) {
                    return;
                }
            } catch (NumberFormatException e) {
                System.err.println("Catch");
                return;
            }

            tableModel = (DefaultTableModel) tableDepositHistory.getModel();
            clearTable(tableModel);
            depositList = frame.depManager.getDepositsByRefNumber(textSearchDep.
                    getText());
            for (String[] iter : depositList) {
                tableModel.addRow(iter);
            }
        } else if (textSearchDep.getText().length() == 0) {
            tableModel = (DefaultTableModel) tableDepositHistory.getModel();
            clearTable(tableModel);
            depositList = frame.depManager.getAllDeposits();
            for (String[] iter : depositList) {
                tableModel.addRow(iter);
            }
        }
    }//GEN-LAST:event_textSearchDepKeyReleased

    /**
     * When a key is released in the billing search field, search for a billing
     * with the matching billing number.
     *
     * @param evt
     */
    private void textSearchBilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchBilKeyReleased
        if (textSearchBil.getText().length() != 0) {
            try {
                int transactionNumb = Integer.parseInt(textSearchBil.getText());
                if (transactionNumb <= 0) {
                    return;
                }
            } catch (NumberFormatException e) {
                return;
            }
            tableModel = (DefaultTableModel) tableBillingHistory.getModel();
            /* Clear table and insert values */
            clearTable(tableModel);
            billingList = frame.bManager.getBillingsByTransactionNumb(
                    textSearchBil.getText());
            for (String[] iter : billingList) {
                tableModel.addRow(iter);
            }
        } else if (textSearchBil.getText().length() == 0) {
            tableModel = (DefaultTableModel) tableBillingHistory.getModel();
            /* Clear table and insert values */
            clearTable(tableModel);
            billingList = frame.bManager.getAllBillings();
            for (String[] iter : billingList) {
                tableModel.addRow(iter);
            }
        }
    }//GEN-LAST:event_textSearchBilKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labInformation;
    private javax.swing.JLabel labInformation2;
    private javax.swing.JLabel labSearchBil;
    private javax.swing.JLabel labSearchDep;
    private javax.swing.JLabel labTransactionHistory;
    private javax.swing.JTable tableBillingHistory;
    private javax.swing.JTable tableDepositHistory;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JScrollPane tableScrollPane1;
    private javax.swing.JTextField textSearchBil;
    private javax.swing.JTextField textSearchDep;
    // End of variables declaration//GEN-END:variables
}