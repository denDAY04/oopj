package GUI;

import java.util.Locale;
import javax.swing.JOptionPane;
import java.util.ResourceBundle;

/**
 * Class for the WelcomeDA panel in GUI
 */
public class WelcomeDA extends javax.swing.JPanel {
    tvmGUI master;
    CartDA CartDAClass;
    private String toListType;
    
    /**
     * Custom constructor.
     * @param tvmGUI Reference to {@link tvmGUI}.
     */
    public WelcomeDA(tvmGUI tvmGUI) {
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

        LabWelcomeDATitle = new javax.swing.JLabel();
        LabWelcomeDAInstruct = new javax.swing.JLabel();
        LabWelcomeDAInfo = new javax.swing.JLabel();
        LabWelcomeDATime = new javax.swing.JLabel();
        CBWelcomeDAType = new javax.swing.JComboBox<String>();
        LabWelcomeDAPricePZ = new javax.swing.JLabel();
        CBWelcomeDAZone = new javax.swing.JComboBox<String>();
        LabWelcomeDATypeError = new javax.swing.JLabel();
        LabWelcomeDAZonesError = new javax.swing.JLabel();
        LabWelcomeDAError = new javax.swing.JLabel();
        CBWelcomeDAAmount = new javax.swing.JComboBox<String>();
        LabWelcomeDATempPrice = new javax.swing.JLabel();
        LabWelcomeDATotalPrice = new javax.swing.JLabel();
        LabWelcomeDAAmountError = new javax.swing.JLabel();
        ButWelcomeDANext = new javax.swing.JButton();
        ButWelcomeDAHelp = new javax.swing.JButton();
        ButWelcomeDALang = new javax.swing.JButton();
        BackgroundPIC = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabWelcomeDATitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Interface/Bundle"); // NOI18N
        LabWelcomeDATitle.setText(bundle.getString("VELKOMMEN TIL BLUEJ TRAFIKSELSKAB")); // NOI18N
        add(LabWelcomeDATitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 69, -1, -1));

        LabWelcomeDAInstruct.setText(bundle.getString("VÆLG BILLETTYPE, ANTAL ZONER OG ANTAL BILLETTER FRA DROPDOWN MENUERNE HERUNDER OG TRYK NÆSTE.")); // NOI18N
        add(LabWelcomeDAInstruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 116, -1, -1));

        LabWelcomeDAInfo.setText(" ");
        add(LabWelcomeDAInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 193, -1));

        LabWelcomeDATime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabWelcomeDATime.setText(" ");
        add(LabWelcomeDATime, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 11, 225, -1));

        CBWelcomeDAType.setMaximumRowCount(10);
        CBWelcomeDAType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vælg billettype..." }));
        CBWelcomeDAType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBWelcomeDATypeActionPerformed(evt);
            }
        });
        add(CBWelcomeDAType, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 171, 126, -1));

        LabWelcomeDAPricePZ.setText(" ");
        add(LabWelcomeDAPricePZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 174, 135, -1));

        CBWelcomeDAZone.setMaximumRowCount(10);
        CBWelcomeDAZone.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vælg antal zoner...", "2-zoner", "3-zoner", "4-zoner", "5-zoner", "6-zoner", "7-zoner", "Alle-zoner" }));
        CBWelcomeDAZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBWelcomeDAZoneActionPerformed(evt);
            }
        });
        add(CBWelcomeDAZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 171, -1, -1));

        LabWelcomeDATypeError.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabWelcomeDATypeError.setForeground(new java.awt.Color(255, 0, 0));
        LabWelcomeDATypeError.setText(" ");
        add(LabWelcomeDATypeError, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 151, 96, -1));

        LabWelcomeDAZonesError.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabWelcomeDAZonesError.setForeground(new java.awt.Color(255, 0, 0));
        LabWelcomeDAZonesError.setText(" ");
        add(LabWelcomeDAZonesError, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 151, 110, -1));

        LabWelcomeDAError.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabWelcomeDAError.setForeground(new java.awt.Color(255, 0, 0));
        LabWelcomeDAError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabWelcomeDAError.setText(" ");
        add(LabWelcomeDAError, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 341, 242, -1));

        CBWelcomeDAAmount.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vælg antal billetter...", "1 stk", "2 stk", "3 stk", "4 stk", "5 stk" }));
        CBWelcomeDAAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBWelcomeDAAmountActionPerformed(evt);
            }
        });
        add(CBWelcomeDAAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 171, -1, -1));

        LabWelcomeDATempPrice.setText(bundle.getString("PRIS PR. BILLET: ")); // NOI18N
        add(LabWelcomeDATempPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 408, 200, -1));

        LabWelcomeDATotalPrice.setText(bundle.getString("TOTAL PRIS:")); // NOI18N
        add(LabWelcomeDATotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 433, 200, -1));

        LabWelcomeDAAmountError.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        LabWelcomeDAAmountError.setForeground(new java.awt.Color(255, 0, 0));
        LabWelcomeDAAmountError.setText(" ");
        add(LabWelcomeDAAmountError, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 151, 127, -1));

        ButWelcomeDANext.setText(bundle.getString("NÆSTE")); // NOI18N
        ButWelcomeDANext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButWelcomeDANextActionPerformed(evt);
            }
        });
        add(ButWelcomeDANext, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 550, 86, 32));

        ButWelcomeDAHelp.setText(bundle.getString("?")); // NOI18N
        ButWelcomeDAHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButWelcomeDAHelpActionPerformed(evt);
            }
        });
        add(ButWelcomeDAHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 551, -1, 31));

        ButWelcomeDALang.setText(bundle.getString("[LANGUAGE]")); // NOI18N
        ButWelcomeDALang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButWelcomeDALangActionPerformed(evt);
            }
        });
        add(ButWelcomeDALang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, 32));

        BackgroundPIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/BackgroundGUI.png"))); // NOI18N
        add(BackgroundPIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 600));
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Sets references to other panels
     * @param refCartDA Reference to CartDA panel.
     */
    public void setReferences(CartDA refCartDA) {CartDAClass = refCartDA;}
    
    private void CBWelcomeDATypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBWelcomeDATypeActionPerformed
        //Checking which item is selected and setting price accordingly
        int n = CBWelcomeDAType.getItemCount()-1;   //Begin from index 0
        for (int m = 0; m<n; m++)
        {
            if (master.language == 1) { // Danish
                String type = master.CT.getTicket(m).getTypeDA();
                if (type.equals(CBWelcomeDAType.getSelectedItem().toString()))
                {
                    master.typePricePZ = master.CT.getTicket(m)
                            .getPricePerZone();
                    LabWelcomeDAPricePZ.setText(languageBundle
                            .getString("PRIS PR. ZONE: ")+master.typePricePZ
                            +languageBundle.getString("DKK"));
                }
            } else {
                String type = master.CT.getTicket(m).getTypeENG();
                if (type.equals(CBWelcomeDAType.getSelectedItem().toString()))
                {
                    master.typePricePZ = master.CT.getTicket(m)
                            .getPricePerZone();
                    LabWelcomeDAPricePZ.setText(languageBundle
                            .getString("PRIS PR. ZONE: ")+master.typePricePZ
                            +languageBundle.getString("DKK"));
                }
            }
        }
        if (CBWelcomeDAType.getSelectedItem().toString().equals(languageBundle
                .getString("VÆLG BILLETTYPE...")))
        {
            LabWelcomeDAError.setText(languageBundle
                    .getString("FEJL - ET ELLER FLERE VALG ER UGYLDIGE"));
            LabWelcomeDATypeError.setText(languageBundle
                    .getString("UGYLDIGT VALG"));
            LabWelcomeDAPricePZ.setText(" ");
            LabWelcomeDATempPrice.setText(languageBundle
                    .getString("PRIS PR. BILLET: "));
            LabWelcomeDATotalPrice.setText(languageBundle
                    .getString("TOTAL PRIS: "));
        }
        else
        {
            LabWelcomeDAError.setText(" ");
            LabWelcomeDATypeError.setText(" ");
            LabWelcomeDAPricePZ.setVisible(true);
            if (!CBWelcomeDAType.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG BILLETTYPE...")) &&
                !CBWelcomeDAZone.getSelectedItem().toString().equals
                    (languageBundle.getString("VÆLG ANTAL ZONER...")) &&
                !CBWelcomeDAAmount.getSelectedItem().toString().equals
                    (languageBundle.getString("VÆLG ANTAL BILLETTER..."))
            ) {
                LabWelcomeDATotalPrice.setText(languageBundle.
                        getString("TOTAL PRIS: ")+(master.typePricePZ*master
                        .amountZones*master.amountTickets)+languageBundle
                                .getString("DKK"));
            }
            if (!CBWelcomeDAType.getSelectedItem().toString().equals
                        (languageBundle.getString("VÆLG BILLETTYPE...")) &&
                !CBWelcomeDAZone.getSelectedItem().toString().equals
                        (languageBundle.getString("VÆLG ANTAL ZONER..."))
            ) {
                LabWelcomeDATempPrice.setText(languageBundle
                        .getString("PRIS PR. BILLET: ")+(master.typePricePZ
                        *master.amountZones)+languageBundle.getString("DKK"));
            }
        }
    }//GEN-LAST:event_CBWelcomeDATypeActionPerformed

    private void CBWelcomeDAZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBWelcomeDAZoneActionPerformed
        if (CBWelcomeDAZone.getSelectedItem().toString().equals(languageBundle
                .getString("VÆLG ANTAL ZONER..."))) {
            LabWelcomeDAError.setText(languageBundle
                    .getString("FEJL - ET ELLER FLERE VALG ER UGYLDIGE"));
            LabWelcomeDAZonesError.setText(languageBundle
                    .getString("UGYLDIGT VALG"));
            LabWelcomeDATempPrice.setText(languageBundle
                    .getString("PRIS PR. BILLET: "));
            LabWelcomeDATotalPrice.setText(languageBundle
                    .getString("TOTAL PRIS: "));
        } else {
            try {
                master.amountZones =  Integer.parseInt(CBWelcomeDAZone
                        .getSelectedItem().toString().substring(0, 1));
            } catch (NumberFormatException e) {
                master.amountZones = 8;
            }
            LabWelcomeDAError.setText(" ");
            LabWelcomeDAZonesError.setText(" ");
            if (!CBWelcomeDAType.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG BILLETTYPE...")) &&
                !CBWelcomeDAZone.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL ZONER...")) &&
                !CBWelcomeDAAmount.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL BILLETTER..."))
            ) {
                LabWelcomeDATotalPrice.setText(languageBundle
                        .getString("TOTAL PRIS: ")+(master.typePricePZ
                        *master.amountZones*master.amountTickets)+languageBundle
                        .getString("DKK"));
            }
            if (!CBWelcomeDAType.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG BILLETTYPE...")) &&
                !CBWelcomeDAZone.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL ZONER..."))
            ) {
                LabWelcomeDATempPrice.setText(languageBundle
                        .getString("PRIS PR. BILLET: ")+(master.typePricePZ
                        *master.amountZones)+languageBundle.getString("DKK"));
            }
        }
        if (!CBWelcomeDAType.getSelectedItem().toString()
                .equals(languageBundle.getString("VÆLG BILLETTYPE...")) && 
                !CBWelcomeDAZone.getSelectedItem().toString()
                .equals(languageBundle.getString("VÆLG ANTAL ZONER..."))) {
            LabWelcomeDATempPrice.setText(languageBundle
                    .getString("PRIS PR. BILLET: ")+(master.typePricePZ
                    *master.amountZones)+languageBundle.getString("DKK"));
        }
    }//GEN-LAST:event_CBWelcomeDAZoneActionPerformed

    private void CBWelcomeDAAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBWelcomeDAAmountActionPerformed
        if (CBWelcomeDAAmount.getSelectedItem().toString()
            .equals(languageBundle.getString("VÆLG ANTAL BILLETTER..."))) {
            LabWelcomeDAError.setText(languageBundle
                    .getString("FEJL - ET ELLER FLERE VALG ER UGYLDIGE"));
            LabWelcomeDAAmountError.setText(languageBundle
                    .getString("UGYLDIGT VALG"));
            LabWelcomeDATotalPrice.setText(languageBundle
                    .getString("TOTAL PRIS: "));
        } else {
            master.amountTickets = Integer.parseInt(CBWelcomeDAAmount
                    .getSelectedItem().toString().substring(0, 1));
            LabWelcomeDAError.setText(" ");
            LabWelcomeDAAmountError.setText(" ");
        }
        if (!CBWelcomeDAType.getSelectedItem().toString()
                .equals(languageBundle.getString("VÆLG BILLETTYPE...")) &&
            !CBWelcomeDAZone.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL ZONER...")) &&
            !CBWelcomeDAAmount.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL BILLETTER..."))
        ) {
            LabWelcomeDATotalPrice.setText(languageBundle
                    .getString("TOTAL PRIS: ")+(master.typePricePZ
                    *master.amountZones*master.amountTickets)+languageBundle
                    .getString("DKK"));
        }
    }//GEN-LAST:event_CBWelcomeDAAmountActionPerformed

    @SuppressWarnings("unchecked")
    private void ButWelcomeDANextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButWelcomeDANextActionPerformed
        int ticketIndex = 0;
        /*Array begins from 0; ComboWindow begins from 1 with first being 
        unusable.*/
        int n = master.CT.getArray().size()+2;   

        if (CBWelcomeDAType.getSelectedItem().toString().equals(languageBundle
                .getString("VÆLG BILLETTYPE...")) ||
            CBWelcomeDAZone.getSelectedItem().toString().equals(languageBundle
                    .getString("VÆLG ANTAL ZONER...")) ||
            CBWelcomeDAAmount.getSelectedItem().toString()
                    .equals(languageBundle.getString("VÆLG ANTAL BILLETTER..."))
        ) {
            return;
        }

        for (int m = 0; m<n; m++) 
        {
            String type;
            if (master.language==1){ // Danish
                type = master.CT.getTicket(m).getTypeDA();}  
            else {  // English
                type = master.CT.getTicket(m).getTypeENG();    }
            if (type.equals(CBWelcomeDAType.getSelectedItem().toString())) {
                ticketIndex = m;
                break;
            }
        }
        master.SB.addToCart(ticketIndex, master.amountZones, CBWelcomeDAAmount
                .getSelectedIndex());
        // add selected ticket to soppingcart
        String toListAmount = master.amountTickets+languageBundle
                .getString("STK");
        if (master.language==1){
            toListType = master.CT.getTicket(ticketIndex).getTypeDA();}
        else {
            toListType = master.CT.getTicket(ticketIndex).getTypeENG();
        }

        String toListZones = master.amountZones+languageBundle
                .getString("-ZONER");
        // Check if last option is selected
        String temp_s = ""+CBWelcomeDAZone.getSelectedItem();
        int selectedAmountZones = 0;
        if (temp_s.equals(languageBundle.getString("ALLE-ZONER"))) {
            selectedAmountZones = 8;       // All zoner
        } else {    // If not, substring to first char to ignore " stk"
            selectedAmountZones = Integer.parseInt(temp_s.substring(0,1));
        }
        String toListSinglePrice = (master.CT.getTicket(ticketIndex)
                .getPricePerZone()*selectedAmountZones)+languageBundle
                        .getString("DKK");

        // Separate variable to calculate total price
        int subTotalCalc = master.typePricePZ*master.amountZones*master
                .amountTickets;
        String toListsubTotal = subTotalCalc+languageBundle.getString("DKK");

        //Convert type length to maximum 8 characters
        if(toListType.length() > 9) {
            toListType = toListType.substring(0, 8);
        }
        //Fit to list design with 20 characters in total
        toListAmount = master.fitToListCart(toListAmount);
        toListType = master.fitToListCart(toListType);
        toListZones = master.fitToListCart(toListZones);
        toListSinglePrice = master.fitToListCart(toListSinglePrice);

        /* Add selected ticket to an array and display the array on a list 
        on next window.*/
        master.CartContent.add(toListAmount+toListType+toListZones
                +toListSinglePrice+toListsubTotal);
        CartDAClass.ListCartDATicketList.setListData((String[]) master
                .CartContent.toArray(new String[0]));

        // Show next window
        master.ChangePanel(CartDAClass);
        CartDAClass.LabCartDAInfo.setText(languageBundle
                .getString("MASKIN ID: ")+master.hardID+languageBundle
                .getString("ZONE: ")+master.startZone);
        CartDAClass.LabCartDATotal.setText(languageBundle
                .getString("TOTAL PRIS: ")+master.SB.getTotalPrice()
                +languageBundle.getString("DKK"));
    }//GEN-LAST:event_ButWelcomeDANextActionPerformed

    private void ButWelcomeDAHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButWelcomeDAHelpActionPerformed
        JOptionPane.showMessageDialog(this,
            languageBundle.getString("FOR HJÆLP RING XX XX XX XX")
            + languageBundle
                    .getString("FOR TEKNISK ASSISTANCE RING XX XX XX XX")
            + languageBundle.getString("HUSK AT OPLYSE MASKINENS ID, SOM KAN FINDES I ØVRE VENSTRE HJØRNE.")
            + "\n"
            + languageBundle.getString("BLUEJ TRAKFIKSELSKAB"),languageBundle
                    .getString("HJÆLP OG TEKNISK SUPPORT"),
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ButWelcomeDAHelpActionPerformed

    private void ButWelcomeDALangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButWelcomeDALangActionPerformed
        if (master.language==1) {
            languageBundle = ResourceBundle.getBundle("Interface.Bundle"
                , new Locale("en", "IE","EURO"));  // set language to English
            master.language =2;
            int numberOfItems = CBWelcomeDAType.getItemCount();
            CBWelcomeDAType.removeItemAt(0);
            CBWelcomeDAType.addItem(languageBundle
                    .getString("VÆLG BILLETTYPE..."));
            for (int n=1; (numberOfItems > n);n++){
                CBWelcomeDAType.removeItemAt(0);
                CBWelcomeDAType.addItem(master.CT.getTicket(n-1).getTypeENG());  
            }
        } else {   
            languageBundle = ResourceBundle.getBundle("Interface.Bundle"
                    , new Locale("", "",""));         
            master.language =1;
            int numberOfItems = CBWelcomeDAType.getItemCount();
            CBWelcomeDAType.removeItemAt(0);
            CBWelcomeDAType.addItem(languageBundle
                    .getString("VÆLG BILLETTYPE..."));
            for (int n=1; (numberOfItems > n);n++){
                CBWelcomeDAType.removeItemAt(0);
                CBWelcomeDAType.addItem(master.CT.getTicket(n-1).getTypeDA());
            }
                        
        }
         // re-write the content of all text in GUI objects
        LabWelcomeDATitle.setText(languageBundle
                .getString("VELKOMMEN TIL BLUEJ TRAFIKSELSKAB"));
        LabWelcomeDAInstruct.setText(languageBundle.getString("VÆLG BILLETTYPE, ANTAL ZONER OG ANTAL BILLETTER FRA DROPDOWN MENUERNE HERUNDER OG TRYK NÆSTE."));

        CBWelcomeDAZone.removeItemAt(0);
        CBWelcomeDAZone.addItem(languageBundle
                .getString("VÆLG ANTAL ZONER..."));
        CBWelcomeDAZone.removeItemAt(0);
        CBWelcomeDAZone.addItem(languageBundle.getString("2-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);        
        CBWelcomeDAZone.addItem(languageBundle.getString("3-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);        
        CBWelcomeDAZone.addItem(languageBundle.getString("4-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);        
        CBWelcomeDAZone.addItem(languageBundle.getString("5-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);        
        CBWelcomeDAZone.addItem(languageBundle.getString("6-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);
        CBWelcomeDAZone.addItem(languageBundle.getString("7-ZONER"));
        CBWelcomeDAZone.removeItemAt(0);
        CBWelcomeDAZone.addItem(languageBundle.getString("ALLE-ZONER"));


        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle
                .getString("VÆLG ANTAL BILLETTER..."));
        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle.getString("1-STK"));
        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle.getString("2-STK"));
        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle.getString("3-STK"));
        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle.getString("4-STK"));
        CBWelcomeDAAmount.removeItemAt(0);
        CBWelcomeDAAmount.addItem(languageBundle.getString("5-STK")); 
        LabWelcomeDAError.setText(" ");
        LabWelcomeDATypeError.setText(" ");
        LabWelcomeDAZonesError.setText(" ");
        LabWelcomeDAAmountError.setText(" ");
        
        LabWelcomeDATempPrice.setText(languageBundle
                .getString("PRIS PR. BILLET: "));
        LabWelcomeDATotalPrice.setText(languageBundle.getString("TOTAL PRIS:"));
        ButWelcomeDANext.setText(languageBundle.getString("NÆSTE"));
        ButWelcomeDALang.setText(languageBundle.getString("[LANGUAGE]"));
        CartDAClass.LabCartDATitle.setText(languageBundle
                .getString("INDKØBSKURV"));
        CartDAClass.LabCartDAInstruct.setText(languageBundle.getString("HERUNDER KAN DU SE DINE VALGTE BILLETTER. DU KAN VÆLGE AT SLETTE BILLETTER, TILFØJE FLERE, RYDDE ALT, ELLER GÅ TIL BETALING. "));
        CartDAClass.LabCartDATotal.setText(languageBundle
                .getString("TOTAL PRIS: "));
        CartDAClass.ButCartDAClear.setText(languageBundle.getString("RYD ALT"));
        CartDAClass.ButCartDARemove.setText(languageBundle.getString("FJERN"));
        CartDAClass.ButCartDAAddM.setText(languageBundle
                .getString("TILFØJ FLERE"));
        CartDAClass.ButCartDAPay.setText(languageBundle
                .getString("GÅ TIL BETALING"));
        CartDAClass.LabCartDASTK.setText(languageBundle.getString("STK."));
        CartDAClass.LabCartDKType.setText(languageBundle
                .getString("BILLET TYPE"));
        CartDAClass.LabCartDKAmountZones.setText(languageBundle
                .getString("ANTAL ZONER"));
        CartDAClass.LabCartDKPricePerTicket.setText(languageBundle
                .getString("PRIS PR. STK"));
        master.CartDAClass.LabCartDKSubTotal.setText(languageBundle
                .getString("SUB-TOTAL"));
        master.PayDAClass.LabPayDATitle.setText(languageBundle
                .getString("BETALING"));
        master.PayDAClass.LabPayDAInstruct.setText(languageBundle
                .getString("VÆLG ØNSKET BETALINGSFORM."));
        master.PayDAClass.ButPayDACash.setText(languageBundle
                .getString("KONTANT"));
        master.PayDAClass.ButPayDACard.setText(languageBundle
                .getString("BETALINGSKORT"));
        master.PayDAClass.ButPayDASMS.setText(languageBundle.getString("SMS"));
        master.PayDAClass.ButPayDAClear.setText(languageBundle
                .getString("AFBRYD"));
        master.PayDAClass.ButPayDABack.setText(languageBundle
                .getString("TILBAGE"));
        master.CashDAClass.LabCashDATitle.setText(languageBundle
                .getString("KONTANT BETALING"));
        master.CashDAClass.LabCashDAInstruct.setText(languageBundle.getString("INDSÆT BELØBET TIL BETALING I FELTET OG TRYK INDSÆT PENGE. FOR PENGE TILBAGE, TRYK AFBRYD."));
        master.CashDAClass.LabCashDAInserted.setText(languageBundle
                .getString("PENGE INDSAT: "));
        master.CashDAClass.LabCashDAMissing.setText(languageBundle
                .getString("MANGLER: "));
        master.CashDAClass.ButCashDAPay.setText(languageBundle
                .getString("INDSÆT PENGE"));
        master.CashDAClass.ButCashDAClear.setText(languageBundle
                .getString("AFBRYD"));
        master.CashDAClass.ButCashDABack.setText(languageBundle
                .getString("TILBAGE"));
        master.CardDAClass.LabCardDATitle.setText(languageBundle
                .getString("BETALING MED BETALINGSKORT"));
        master.CardDAClass.LabCardDAInstruct.setText(languageBundle.getString("INDSÆT BETALINGSKORT OG INDTAST DIN PIN-KODE I FELTET NEDENUNDER. TRYK HEREFTER PÅ GODKEND."));
        master.CardDAClass.LabCardDATotal.setText(languageBundle
                .getString("TOTAL PRIS: "));
        master.CardDAClass.ButCardDAConfirm.setText(languageBundle
                .getString("GODKEND"));
        master.CardDAClass.ButCardDAClear.setText(languageBundle
                .getString("AFBRYD"));
        master.CardDAClass.ButCardDABack.setText(languageBundle
                .getString("TILBAGE"));
        master.SMSDAClass.LabSMSDATitle.setText(languageBundle
                .getString("BETALING MED SMS"));
        master.SMSDAClass.LabSMSDAInstruct.setText(languageBundle.getString("INDTAST TELEFONNUMMERET SOM REGNINGEN SKAL SENDES TIL OG TRYK HEREFTER PÅ GODKEND. "));
        master.SMSDAClass.LabSMSDATotal.setText(languageBundle
                .getString("TOTAL PRIS: "));
        master.SMSDAClass.ButSMSDAConfirm.setText(languageBundle
                .getString("GODKEND"));
        master.SMSDAClass.ButSMSDABack.setText(languageBundle
                .getString("TILBAGE"));
        master.SMSDAClass.ButSMSDAClear.setText(languageBundle
                .getString("AFBRYD"));
        LabWelcomeDAInfo.setText(languageBundle.getString("MASKIN ID: ")
                +master.hardID+languageBundle.getString("ZONE: ")
                +master.startZone);
        
        CartDAClass.ListCartDATicketList.removeAll();
        master.CartContent.clear();
        master.SB.clearCart();
        master.resetSelectionScreen();
        

    }//GEN-LAST:event_ButWelcomeDALangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel BackgroundPIC;
    public javax.swing.JButton ButWelcomeDAHelp;
    public javax.swing.JButton ButWelcomeDALang;
    public javax.swing.JButton ButWelcomeDANext;
    public javax.swing.JComboBox<String> CBWelcomeDAAmount;
    public javax.swing.JComboBox<String> CBWelcomeDAType;
    public javax.swing.JComboBox<String> CBWelcomeDAZone;
    public javax.swing.JLabel LabWelcomeDAAmountError;
    public javax.swing.JLabel LabWelcomeDAError;
    public javax.swing.JLabel LabWelcomeDAInfo;
    public javax.swing.JLabel LabWelcomeDAInstruct;
    public javax.swing.JLabel LabWelcomeDAPricePZ;
    public javax.swing.JLabel LabWelcomeDATempPrice;
    public javax.swing.JLabel LabWelcomeDATime;
    public javax.swing.JLabel LabWelcomeDATitle;
    public javax.swing.JLabel LabWelcomeDATotalPrice;
    public javax.swing.JLabel LabWelcomeDATypeError;
    public javax.swing.JLabel LabWelcomeDAZonesError;
    // End of variables declaration//GEN-END:variables
    public static ResourceBundle languageBundle = ResourceBundle
            .getBundle("Interface.Bundle");    //bundle variable
}
