/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Nordahl
 */
public class OutOfOrder extends javax.swing.JPanel {
    tvmGUI master;
    /**
     * Creates new form OutOfOrder
     */
    public OutOfOrder(tvmGUI tvmGUI) {
        master = tvmGUI;
        initComponents();
    }
    
    public void setReferences()
    {
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabOutOfOrderTitle = new javax.swing.JLabel();
        LabOutOfOrderInfo = new javax.swing.JLabel();
        LabOutOfOrderTime = new javax.swing.JLabel();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabOutOfOrderTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabOutOfOrderTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabOutOfOrderTitle.setText("Ude af drift / Out of order");
        add(LabOutOfOrderTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 256, 780, -1));

        LabOutOfOrderInfo.setText(" ");
        add(LabOutOfOrderInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 361, -1));

        LabOutOfOrderTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabOutOfOrderTime.setText("  ");
        add(LabOutOfOrderTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 11, 339, -1));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JLabel LabOutOfOrderInfo;
    public javax.swing.JLabel LabOutOfOrderTime;
    public javax.swing.JLabel LabOutOfOrderTitle;
    // End of variables declaration//GEN-END:variables
}