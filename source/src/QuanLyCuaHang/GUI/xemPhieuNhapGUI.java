package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.BUS.CTPhieuNhapBUS;
import QuanLyCuaHang.BUS.PhieuNhapBUS;
import QuanLyCuaHang.DTO.PhieuNhapDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class xemPhieuNhapGUI extends javax.swing.JFrame {
    public static PhieuNhapBUS phieunhapBUS = new PhieuNhapBUS(); //Để thao tác với bảng dữ liệu hóa đơn
    public static CTPhieuNhapBUS ctphieunhapBUS = new CTPhieuNhapBUS();
    public static PhieuNhapDTO phieunhapDTO = new PhieuNhapDTO(); //Biến này đại diện cho phiếu nhập được chọn trong table
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    public xemPhieuNhapGUI() {
        initComponents();
        timkiemType = (String) jComboBox.getSelectedItem();
        phieunhapBUS = new PhieuNhapBUS();
        phieunhapDTO = new PhieuNhapDTO();
        jTPhieuNhap.setRowHeight(30);
        upDTB();
    }
    //Load DTB lên Table
    public static void upDTB(){
        DefaultTableModel RecordTable = (DefaultTableModel)jTPhieuNhap.getModel();
        RecordTable.setRowCount(0);
        phieunhapBUS.getListPhieuNhap();
        
        for (PhieuNhapDTO pntemp : phieunhapBUS.listPhieuNhap){
            RecordTable.addRow(new Object[]{Integer.toString(pntemp.MaPN),Integer.toString(pntemp.MaNCC),pntemp.MaNV,pntemp.NgayLap,pntemp.TongTien});
        }
    }
    
    //Thêm dòng khi add đối tượng ở Jframe khác
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTPhieuNhap.getModel();
        model.addRow(dataRow);
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPhieuNhap = new javax.swing.JTable();
        jComboBox = new javax.swing.JComboBox<>();
        txtTimkiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách phiếu nhập");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/view.png"))); // NOI18N
        jButton1.setText("Xem chi tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày lập ", "Tổng tiền"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTPhieuNhapMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTPhieuNhap);

    jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã PN", "Mã NCC", "Mã NV" }));
    jComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxActionPerformed(evt);
        }
    });

    jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/searchicon.png"))); // NOI18N
    jButton2.setText("Tìm");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jComboBox)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        timkiemType = (String) jComboBox.getSelectedItem();
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(txtTimkiem.getText().trim().equals("")){
            upDTB();
        } else{
           upDTB();
           phieunhapBUS.listPhieuNhap = phieunhapBUS.searchPhieuNhap(txtTimkiem.getText(),timkiemType);
           DefaultTableModel RecordTable = (DefaultTableModel)jTPhieuNhap.getModel();
           RecordTable.setRowCount(0);
           for (PhieuNhapDTO sptemp : phieunhapBUS.listPhieuNhap){
           RecordTable.addRow(new Object[]{Integer.toString(sptemp.MaPN),sptemp.MaNCC,sptemp.MaNV,sptemp.NgayLap,sptemp.TongTien});
           }
        }   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPhieuNhapMouseClicked
        // TODO add your handling code here:
         //Lấy thông tin object khi click chuột vào
        DefaultTableModel RecordTable = (DefaultTableModel) jTPhieuNhap.getModel();
        int SelectedRows = jTPhieuNhap.getSelectedRow();
        phieunhapDTO.MaPN = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        phieunhapDTO.MaNCC = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 1).toString()));
        phieunhapDTO.MaNV = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 2).toString()));
        //Xử lí ngayLap
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            phieunhapDTO.NgayLap = sdf.parse(RecordTable.getValueAt(SelectedRows, 3).toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
            // Xử lý lỗi ở đây
        }        
        phieunhapDTO.TongTien = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 4).toString()));
    }//GEN-LAST:event_jTPhieuNhapMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Nếu chưa chọn hóa đơn nào thì thông báo lỗi
        if(phieunhapDTO.MaPN==0) {
            new MyDialog("Vui lòng chọn phiếu nhập cần xem chi tiết", MyDialog.ERROR_DIALOG);
        }
        //Nếu đã chọn hóa đơn thì mở giao diện xem chi tiết hóa đơn
        else {
            //Lấy dòng được chọn trong bảng
            int selectedRow = jTPhieuNhap.getSelectedRow();
            //Lấy mã hóa đơn từ dòng được chọn
            if (selectedRow != -1) {
                int maPN = Integer.parseInt(jTPhieuNhap.getValueAt(selectedRow, 0).toString());
                //Mở giao diện xem chi tiết hóa đơn
                new xemChiTietPhieuNhapGUI(maPN).setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(xemPhieuNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(xemPhieuNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(xemPhieuNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(xemPhieuNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new xemPhieuNhapGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTPhieuNhap;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
