package GUI.Admin;

import GUI.System.GUIFrame;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Panel for an administrator to log in as a customer.
 */
public class LoginAsPanel extends javax.swing.JPanel {

    private GUIFrame frame;
    private int errors;
    private DefaultListModel listModel;

    /**
     * Custom constructor.
     */
    public LoginAsPanel() {
        initComponents();
        errors = 1;
        listModel = new DefaultListModel();
        listCustomers.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    //Check for null to avoid nullpointerexception when clearing list
                    if (listCustomers.getSelectedValue() == null) {
                        return;
                    } else {
                        String item = (listCustomers.getSelectedValue().
                                toString());
                        //Make array of substrings by splitting on whitespace
                        String substrings[] = item.split("\\s+");
                        textEmail.setText(substrings[substrings.length - 1]);
                    }
                }
            }
        });
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
     * Load all customers into JList.
     */
    public void loadPage() {
        ArrayList<String> arr = frame.cManager.getCustomersByFirstName(
                "%" + textSearch.getText() + "%");
        listModel.clear();
        if (arr.isEmpty() == false) {
            for (String customer : arr) {
                listModel.addElement(customer);
            }
            listCustomers.setModel(listModel);
        }
    }

    /**
     * Check input fields for errors.
     */
    private void inputCheck() {
        if (isValidEmailAddress(textEmail.getText()) == true) {
            labEmail.setForeground(Color.BLACK);
            labErrorEmail.setVisible(false);
            errors--;
        } else {
            labEmail.setForeground(Color.RED);
            labErrorEmail.setVisible(true);
        }
    }

    /**
     * Method found at StackOverflow.com, which validates the syntax of an email
     * address.
     * http://stackoverflow.com/questions/624581/what-is-the-best-java-email
     * -address-validation-method
     *
     * @param email
     *
     * @return true if the string matches the structure of a valid email
     *         address; false oStherwise.
     */
    private boolean isValidEmailAddress(String email) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(
                ".+@.+\\.[a-z]+");
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * Reset fields.
     */
    public void resetPage() {
        textEmail.setText("");
        textSearch.setText("");
        listCustomers.clearSelection();
        listModel.clear();
        labErrorEmail.setVisible(false);
        labEmail.setForeground(Color.BLACK);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitle = new javax.swing.JLabel();
        labEmail = new javax.swing.JLabel();
        labInformation1 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        labErrorEmail = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCustomers = new javax.swing.JList();
        textSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        labTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labTitle.setText("Edit Customer Account");

        labEmail.setText("Email");

        labInformation1.setText("Enter the customers email to get access to their account. ");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        labErrorEmail.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        labErrorEmail.setForeground(new java.awt.Color(255, 0, 0));
        labErrorEmail.setText("- No customer with this email found");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listCustomers);

        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search (First name)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labInformation1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(26, 26, 26)
                        .addComponent(btnNext))
                    .addComponent(labTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labEmail)
                                .addGap(18, 18, 18)
                                .addComponent(labErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(textSearch)))
                    .addComponent(jScrollPane1))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labInformation1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labEmail)
                    .addComponent(labErrorEmail)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addContainerGap())
        );

        labErrorEmail.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change to administrator's control panel.
     *
     * @param evt ActionEvent
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        frame.changePanel("card11");
        resetPage();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Change to administrator's customer-account panel.
     *
     * @param evt ActionEvent
     */
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        inputCheck();
        if (errors == 0 && frame.cManager.admLoggedInAs(textEmail.getText().
                toLowerCase()) == true) {
            frame.changePanel("card13");
            resetPage();
        }
        errors = 1;
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * On every key release, search for a customer in the database with a first
     * name containing such character sequence as are in the input field.
     *
     * @param evt KeyEvent
     */
    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        ArrayList<String> arr = frame.cManager.getCustomersByFirstName(
                "%" + textSearch.getText() + "%");
        System.err.println(textSearch.getText());
        listModel.clear();
        if (arr.isEmpty() == false) {
            for (String customer : arr) {
                listModel.addElement(customer);
            }
            listCustomers.setModel(listModel);
        } else {
            listModel.add(0, "No customer found - Try again");
            listCustomers.setModel(listModel);
        }
        System.err.println(textSearch.getText());
    }//GEN-LAST:event_textSearchKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labEmail;
    private javax.swing.JLabel labErrorEmail;
    private javax.swing.JLabel labInformation1;
    private javax.swing.JLabel labTitle;
    private javax.swing.JList listCustomers;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables
}