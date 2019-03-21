/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.vnen;

import controllers.Tree;
import db.VnEnDictionary;
import dictionary.Dictionary;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import views.HomeFrame;

/**
 *
 * @author Thien Phuc
 */
public class VNENHomeFrame extends javax.swing.JFrame {
    private Dictionary dictionary;
    /**
     * Creates new form VNENHomeFrame
     */
    public VNENHomeFrame() {
        initComponents();
        this.setSize(500, 500);
        this.dictionary = VnEnDictionary.dictionary;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnTran = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMean = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(null);

        btnHome.setText("Trang chủ");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome);
        btnHome.setBounds(0, 0, 90, 25);
        getContentPane().add(txtSearch);
        txtSearch.setBounds(40, 102, 300, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Vietnamese-English");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 220, 40);

        btnTran.setText("Dịch");
        btnTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranActionPerformed(evt);
            }
        });
        getContentPane().add(btnTran);
        btnTran.setBounds(360, 105, 100, 30);

        jLabel3.setText("Author: Tran Thien Phuc - SE130139");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 430, 267, 16);

        btnAdd.setText("Thêm vào từ điển");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(50, 360, 390, 25);

        jScrollPane1.setViewportView(txtMean);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 160, 420, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        HomeFrame frame = new HomeFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddNewFrame frame = new AddNewFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranActionPerformed
        txtMean.setText("");
        String word = txtSearch.getText().trim().toLowerCase();
        String regex = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n"
                + "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n"
                + "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$";
        if (!word.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Chữ không hợp lệ");
            return;
        }
        LinkedList<String> result = dictionary.translate(word);
        if (!result.isEmpty()) {
            String mean = "";
            for (String string : result) {
                mean += string + "\n";
            }
            txtMean.setText(mean);
        } else {
            JOptionPane.showMessageDialog(this, "Not found this word in our dictionary");
        }
    }//GEN-LAST:event_btnTranActionPerformed

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
            java.util.logging.Logger.getLogger(VNENHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VNENHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VNENHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VNENHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VNENHomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnTran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtMean;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
