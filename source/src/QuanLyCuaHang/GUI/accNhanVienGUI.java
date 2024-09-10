package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.DAO.TaiKhoanDAO;
import QuanLyCuaHang.DTO.NhanVienDTO;
import QuanLyCuaHang.DTO.TaiKhoanDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class accNhanVienGUI extends javax.swing.JFrame {
    
    public static TaiKhoanDAO taiKhoanDAO;
    public static NhanVienDTO cur = new NhanVienDTO();
    public accNhanVienGUI() {
        taiKhoanDAO = new TaiKhoanDAO();
        cur = NhanVienGUI.nhanvienDTO;
        initComponents();
        upDTB();
    }
    //Load DTB lên Table
    public static void upDTB(){
        ArrayList<TaiKhoanDTO> dsTaiKhoan = taiKhoanDAO.getListTaiKhoanTheoMaNV(cur.getMaNV());
        DefaultTableModel model = (DefaultTableModel) jTableNhanVien.getModel();
        model.setRowCount(0);
        if (dsTaiKhoan != null) {
        	for (TaiKhoanDTO tk : dsTaiKhoan) {
                    model.addRow(new Object[]{tk.getMaNhanVien(), tk.getTenDangNhap(), tk.getMatKhau(), tk.getQuyen()});
                }
        }
        else {
        	  new MyDialog("Không có tài khoản!", MyDialog.ERROR_DIALOG);
        }
    }
     public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTableNhanVien.getModel();
        model.addRow(dataRow);
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhanVien = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin tài khoản của nhân viên");

        jTableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Mật khẩu", "Quyền"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jScrollPane1.setViewportView(jTableNhanVien);

    jButton1.setText("Tạo mới");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton2.setText("Đổi mật khẩu");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jButton3.setText("Xóa");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton3)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(21, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3)
                .addComponent(jButton1)
                .addComponent(jButton2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        accNhanVienGUI_addTK addFrame = new accNhanVienGUI_addTK();
        addFrame.setVisible(true);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableNhanVien.getSelectedRow();
		if (selectedRow != -1) {
			int maNV = (int) jTableNhanVien.getValueAt(selectedRow, 0);
			if (taiKhoanDAO.deleteTaiKhoan(maNV)) {
				new MyDialog("Xóa thành công", MyDialog.SUCCESS_DIALOG);
                                upDTB();
			} else {
				new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
			}
		} else {
			new MyDialog("Chọn tài khoản cần xóa", MyDialog.INFO_DIALOG);
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableNhanVien.getSelectedRow();
		if (selectedRow != -1) {
                    accNhanVienGUI_fixpass addFrame = new accNhanVienGUI_fixpass();
                    addFrame.setVisible(true);
                    addFrame.pack();
                    addFrame.setLocationRelativeTo(null);
                    addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                } else {
			new MyDialog("Chọn tài khoản cần đổi mật khẩu", MyDialog.INFO_DIALOG);
		}
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(accNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accNhanVienGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accNhanVienGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableNhanVien;
    // End of variables declaration//GEN-END:variables
}
