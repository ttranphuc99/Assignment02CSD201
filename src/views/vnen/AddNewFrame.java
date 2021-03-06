/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.vnen;

import controllers.Tree;
import db.EnVnDictionary;
import db.VnEnDictionary;
import dictionary.Dictionary;
import javax.swing.JOptionPane;

/**
 *
 * @author Thien Phuc
 */
public class AddNewFrame extends javax.swing.JFrame {

    private Dictionary dictionary;

    /**
     * Creates new form AddNewFrame
     */
    public AddNewFrame() {
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

        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtWord = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMeaning = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(90, 330, 130, 25);

        btnBack.setText("Trở về");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(280, 330, 110, 25);

        jLabel3.setText("Author: Tran Thien Phuc - SE130139");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 430, 267, 16);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Vietnamese-English");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 30, 240, 29);

        jLabel2.setText("Từ:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 90, 21, 16);
        getContentPane().add(txtWord);
        txtWord.setBounds(80, 120, 330, 40);

        jLabel4.setText("Nghĩa (ngăn cách bởi dấu ','):");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 200, 180, 16);
        getContentPane().add(txtMeaning);
        txtMeaning.setBounds(80, 240, 330, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtWord.getText().trim().isEmpty() || txtMeaning.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống!");
        } else {
            String word = txtWord.getText().trim().toLowerCase();
            String regex = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\n"
                    + "            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\n"
                    + "            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]+$";
            if (!word.matches(regex)) {
                JOptionPane.showMessageDialog(this, "Chữ không hợp lệ");
                return;
            }
            String mean = txtMeaning.getText().trim().toLowerCase();
            regex = "^[a-z ]+[,a-z ]+$";
            if (!mean.matches(regex)) {
                JOptionPane.showMessageDialog(this, "Ngữ nghĩa không hợp lệ");
                return;
            }

            dictionary.addWords(word, mean);

            Dictionary otherDic = EnVnDictionary.dictionary;
            String[] meanList = mean.split(",");
            for (String string : meanList) {
                otherDic.addWords(string.trim(), word);
            }
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        VNENHomeFrame frame = new VNENHomeFrame();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMeaning;
    private javax.swing.JTextField txtWord;
    // End of variables declaration//GEN-END:variables
}
