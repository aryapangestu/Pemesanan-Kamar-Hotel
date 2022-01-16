/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import PopupMenu.PopupTambahEditKamar;
import Database.DriverDatabase;
import Kontrol.KamarKontrol;
import Kontrol.PemesananKontrol;
import Kontrol.TamuKontrol;
import PopupMenu.PopupTambahEditPemesanan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aryap
 */
public class KamarMenu extends javax.swing.JFrame {
    private DriverDatabase database;

    private KamarKontrol kamarKontrol;
    
    private DefaultTableModel model_Kamar;
    
    private void loadDatabase() throws IOException{
        database = new DriverDatabase();
        database.memuatDatabase();
        
        kamarKontrol = database.getKamarKontrol();
    }
    
    private void setTable(){
        try {
            loadDatabase();
        } catch (IOException ex) {
            Logger.getLogger(KamarMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Kamar
        model_Kamar = (DefaultTableModel) Table_Kamar.getModel();
        model_Kamar.setRowCount(0);
        for (int i = 0; i < kamarKontrol.sizeData(); i++) {
            model_Kamar.addRow(kamarKontrol.oneRow(i));
        }
    }
    /**
     * Creates new form KamarMenu
     */
    public KamarMenu() {
        initComponents();
        setTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Kamar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Button_TambahKamar = new javax.swing.JButton();
        Button_EditKamar = new javax.swing.JButton();
        Button_HapusKamar = new javax.swing.JButton();
        Button_Kembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Kamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. kamar", "Tipe kamar", "Status WI-FI", "Status kamar", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Kamar.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Table_Kamar);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Data Kamar");

        Button_TambahKamar.setText("Tambah");
        Button_TambahKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TambahKamarActionPerformed(evt);
            }
        });

        Button_EditKamar.setText("Edit");
        Button_EditKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EditKamarActionPerformed(evt);
            }
        });

        Button_HapusKamar.setText("Hapus");
        Button_HapusKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_HapusKamarActionPerformed(evt);
            }
        });

        Button_Kembali.setText("Kembali");
        Button_Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_KembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_TambahKamar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_EditKamar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_HapusKamar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Kembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(Button_Kembali)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_TambahKamar)
                    .addComponent(Button_EditKamar)
                    .addComponent(Button_HapusKamar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_TambahKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TambahKamarActionPerformed
        PopupTambahEditKamar tambah_Kamar = new PopupTambahEditKamar(null,true,-1);
        tambah_Kamar.setVisible(true);
        setTable();
    }//GEN-LAST:event_Button_TambahKamarActionPerformed

    private void Button_KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_KembaliActionPerformed
        new MainMenu().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Button_KembaliActionPerformed

    private void Button_EditKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_EditKamarActionPerformed
        if(Table_Kamar.getSelectedRow() != -1){
            PopupTambahEditKamar tambah_kamar = new PopupTambahEditKamar(null,true, Table_Kamar.getSelectedRow());
            tambah_kamar.setVisible(true);
            setTable();
        }
    }//GEN-LAST:event_Button_EditKamarActionPerformed

    private void Button_HapusKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_HapusKamarActionPerformed
        if(Table_Kamar.getSelectedRow() != -1){
            //Hapus kamar
            kamarKontrol.listKamar().remove(Table_Kamar.getSelectedRow());

            //Update database
            try {
                database.simpanDatabase();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(KamarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(KamarMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setTable();
    }//GEN-LAST:event_Button_HapusKamarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KamarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KamarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KamarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KamarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KamarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_EditKamar;
    private javax.swing.JButton Button_HapusKamar;
    private javax.swing.JButton Button_Kembali;
    private javax.swing.JButton Button_TambahKamar;
    private javax.swing.JTable Table_Kamar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
