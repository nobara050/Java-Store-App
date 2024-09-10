package QuanLyCuaHang.GUI;

import QuanLyCuaHang.BUS.NhaCungCapBUS;
import QuanLyCuaHang.DTO.NhaCungCapDTO;

public class updateNhaCungCapGUI extends javax.swing.JFrame {

    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public boolean flag = false;
    
    public updateNhaCungCapGUI() {
        initComponents();
        jTMaNCC.setText(String.valueOf(NhaCungCapGUI.nccDTO.MaNCC));
        jTTenNCC.setText(NhaCungCapGUI.nccDTO.TenNCC);
        jTDiaChi.setText(NhaCungCapGUI.nccDTO.DiaChi);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTenNCC = new javax.swing.JLabel();
        jLDiaChi = new javax.swing.JLabel();
        jTTenNCC = new javax.swing.JTextField();
        jTDiaChi = new javax.swing.JTextField();
        jBLuu = new javax.swing.JButton();
        jLHeader = new javax.swing.JLabel();
        jLNCC = new javax.swing.JLabel();
        jTMaNCC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm nhà cung cấp");

        jLTenNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLTenNCC.setText("Tên NCC");

        jLDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLDiaChi.setText("Địa chỉ");

        jTTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTenNCCActionPerformed(evt);
            }
        });

        jBLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBLuu.setText("Lưu");
        jBLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLuuActionPerformed(evt);
            }
        });

        jLHeader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLHeader.setText("Thông tin nhà cung cấp");

        jLNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLNCC.setText("SĐT-Mã NCC:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLHeader)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTDiaChi)
                            .addComponent(jTTenNCC)
                            .addComponent(jTMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBLuu)
                        .addGap(133, 133, 133))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNCC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTenNCC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDiaChi))
                .addGap(18, 18, 18)
                .addComponent(jBLuu)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLuuActionPerformed
        // TODO add your handling code here:
        flag = nccBUS.updateNhaCungCap(String.valueOf(NhaCungCapGUI.nccDTO.MaNCC),jTTenNCC.getText(),jTDiaChi.getText(),jTMaNCC.getText());
         if (flag){
            NhaCungCapGUI.upDTB();
            NhaCungCapGUI.nccDTO = new NhaCungCapDTO();
            this.dispose();   
        }
    }//GEN-LAST:event_jBLuuActionPerformed

    private void jTTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTenNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTenNCCActionPerformed

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
            java.util.logging.Logger.getLogger(updateNhaCungCapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateNhaCungCapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateNhaCungCapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateNhaCungCapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateNhaCungCapGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLuu;
    private javax.swing.JLabel jLDiaChi;
    private javax.swing.JLabel jLHeader;
    private javax.swing.JLabel jLNCC;
    private javax.swing.JLabel jLTenNCC;
    private javax.swing.JTextField jTDiaChi;
    private javax.swing.JTextField jTMaNCC;
    private javax.swing.JTextField jTTenNCC;
    // End of variables declaration//GEN-END:variables
}
