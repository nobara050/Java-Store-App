package QuanLyCuaHang.GUI;

import QuanLyCuaHang.BUS.NhanVienBUS;
import java.util.Calendar;
import java.util.Date;


public class addNhanVienGUI extends javax.swing.JFrame {
    
    NhanVienBUS nhanvienBUS = new NhanVienBUS();
    public boolean flag = false;
    
    public addNhanVienGUI() {
        initComponents();
        nhanvienBUS.getListNhanVien();
        
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
        jLChucVu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTSDT = new javax.swing.JTextField();
        jTGioiTinh = new javax.swing.JComboBox<>();
        jcombobox = new javax.swing.JComboBox<>();
        jNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm Nhân Viên");

        jLHo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLHo.setText("Họ:");

        jLTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLTen.setText("Tên:");

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
        jLHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLHeader.setText("Thông Tin Nhân Viên");

        jLChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLChucVu.setText("Chức vụ:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("SĐT:");

        jTGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        jcombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Quan Ly", "Nhan Vien" }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ngày sinh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLHo)
                            .addGap(91, 91, 91))
                        .addComponent(jLTen))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLGioiTinh)
                            .addComponent(jLChucVu)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTTen)
                    .addComponent(jTHo)
                    .addComponent(jTSDT)
                    .addComponent(jTGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addComponent(jLHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jBLuu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLHeader)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHo)
                    .addComponent(jTHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLGioiTinh)
                    .addComponent(jTGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLChucVu)
                    .addComponent(jcombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBLuu)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLuuActionPerformed
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();        
        flag = nhanvienBUS.addNhanVien(jTSDT.getText(),
                                       jTHo.getText(),
                                       jTTen.getText(),
                                       (String) jTGioiTinh.getSelectedItem(),
                                       (String)jcombobox.getSelectedItem(),
                                       currentDate,
                                       jNgaySinh.getDate()
                                       );
        if (flag == true) {
                NhanVienGUI.AddRowToJTable(new Object[]{
                    jTSDT.getText(),
                    jTHo.getText(),
                    jTTen.getText(),
                    jTGioiTinh.getSelectedItem(),
                    jcombobox.getSelectedItem(),
                    currentDate,
                    jNgaySinh.getDate()
                });
            NhanVienGUI.upDTB();
            this.dispose();
        }
        else {
            System.out.println("here");
        }
    }//GEN-LAST:event_jBLuuActionPerformed
    
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
            java.util.logging.Logger.getLogger(addNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addNhanVienGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBLuu;
    private javax.swing.JLabel jLChucVu;
    private javax.swing.JLabel jLGioiTinh;
    private javax.swing.JLabel jLHeader;
    private javax.swing.JLabel jLHo;
    private javax.swing.JLabel jLTen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.toedter.calendar.JDateChooser jNgaySinh;
    private javax.swing.JComboBox<String> jTGioiTinh;
    private javax.swing.JTextField jTHo;
    private javax.swing.JTextField jTSDT;
    private javax.swing.JTextField jTTen;
    private javax.swing.JComboBox<String> jcombobox;
    // End of variables declaration//GEN-END:variables
}
