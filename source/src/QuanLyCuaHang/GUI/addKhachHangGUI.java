package QuanLyCuaHang.GUI;

import QuanLyCuaHang.BUS.KhachHangBUS;

public class addKhachHangGUI extends javax.swing.JFrame {

    KhachHangBUS khBUS = new KhachHangBUS();
    public boolean flag = false;
    
    public addKhachHangGUI() {
        initComponents();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLHo = new javax.swing.JLabel();
        jLTen = new javax.swing.JLabel();
        jTHo = new javax.swing.JTextField();
        jTTen = new javax.swing.JTextField();
        jBLuu = new javax.swing.JButton();
        jLGioiTinh = new javax.swing.JLabel();
        jLHeader = new javax.swing.JLabel();
        jLSDT = new javax.swing.JLabel();
        jTSDT = new javax.swing.JTextField();
        jComboBoxGioiTinh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm Khách Hàng");

        jLHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLHo.setText("Họ:");

        jLTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLTen.setText("Tên:");

        jTHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTHoActionPerformed(evt);
            }
        });

        jBLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBLuu.setText("Lưu");
        jBLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLuuActionPerformed(evt);
            }
        });

        jLGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLGioiTinh.setText("Giới tính:");

        jLHeader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLHeader.setText("Thông Tin Khách hàng");

        jLSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLSDT.setText("SĐT-Mã KH:");

        jComboBoxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nu", "Khac" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLHeader)
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLHo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLGioiTinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTTen)
                            .addComponent(jTHo)
                            .addComponent(jTSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jComboBoxGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBLuu)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSDT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLTen))
                    .addComponent(jTTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGioiTinh)
                    .addComponent(jComboBoxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jBLuu)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLuuActionPerformed
        // TODO add your handling code here:
        flag = khBUS.addKhachHang(jTSDT.getText(),jTHo.getText(),jTTen.getText(), jComboBoxGioiTinh.getSelectedItem().toString());
        if (flag == true) {
                KhachHangGUI.AddRowToJTable(new Object[]{
                    jTSDT.getText(),
                    jTHo.getText(),
                    jTTen.getText(),
                    jComboBoxGioiTinh.getSelectedItem().toString(),
                    '0'
                });
            this.dispose();
        }
    }//GEN-LAST:event_jBLuuActionPerformed

    private void jTHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTHoActionPerformed

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
            java.util.logging.Logger.getLogger(addKhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addKhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addKhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addKhachHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addKhachHangGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLuu;
    private javax.swing.JComboBox<String> jComboBoxGioiTinh;
    private javax.swing.JLabel jLGioiTinh;
    private javax.swing.JLabel jLHeader;
    private javax.swing.JLabel jLHo;
    private javax.swing.JLabel jLSDT;
    private javax.swing.JLabel jLTen;
    private javax.swing.JTextField jTHo;
    private javax.swing.JTextField jTSDT;
    private javax.swing.JTextField jTTen;
    // End of variables declaration//GEN-END:variables
}
