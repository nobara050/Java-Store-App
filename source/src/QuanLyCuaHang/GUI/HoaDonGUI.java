package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.BUS.CTHoaDonBUS;
import QuanLyCuaHang.BUS.HoaDonBUS;
import QuanLyCuaHang.DTO.HoaDonDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends javax.swing.JInternalFrame {
    public static int TrangThaiJButtonXuLy = 0;
    public static HoaDonBUS hoadonBUS = new HoaDonBUS(); //Để thao tác với bảng dữ liệu hóa đơn
    public static CTHoaDonBUS cthoadonBUS = new CTHoaDonBUS();
    public static HoaDonDTO hoadonDTO = new HoaDonDTO(); //Biến này đại diện cho hóa đơn được chọn trong table
     public String timkiemType; //Dùng để lấy dữ liệu combo box
    public HoaDonGUI() {
        initComponents();
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        timkiemType = (String) jComboBoxHĐ.getSelectedItem();
        hoadonBUS = new HoaDonBUS();
        hoadonDTO = new HoaDonDTO();
        jTHoaDon.setRowHeight(30);
        upDTB();
    }
     
    //Load DTB lên Table
    public static void upDTB(){
//        DefaultTableModel RecordTable = (DefaultTableModel)jTHoaDon.getModel();
//        RecordTable.setRowCount(0);
//        hoadonBUS.getListHoaDon();//MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu
//            for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
//                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien, hdtemp.GhiChu});
//            }
        DefaultTableModel RecordTable = (DefaultTableModel)jTHoaDon.getModel();
        hoadonBUS.getListHoaDon();
        switch (TrangThaiJButtonXuLy){
            case 0 -> {
                jButtonXuLy.setText("Tất cả");
                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("", "Ghi chú");
                RecordTable.setRowCount(0);
                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
                }
            }
            case 1 -> {
                jButtonXuLy.setText("Đang xử lý");
                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("Dang xu ly", "Ghi chú");
                RecordTable.setRowCount(0);
                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
                }
            }
            case 2 -> {
                jButtonXuLy.setText("Hoàn tất");
                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("Hoan tat", "Ghi chú");
                RecordTable.setRowCount(0);
                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
                }
            }
        }
    }
    
    //Thêm dòng khi add đối tượng ở Jframe khác
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTHoaDon.getModel();
        model.addRow(dataRow);
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBTimkiem = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jXemChiTietHoaDon = new javax.swing.JButton();
        jBXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxHĐ = new javax.swing.JComboBox<>();
        jButtonXuLy = new javax.swing.JButton();
        jButtonCheck = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        jBTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/searchicon.png"))); // NOI18N
        jBTimkiem.setText("Tìm kiếm");
        jBTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTimkiemActionPerformed(evt);
            }
        });

        txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        jXemChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/view.png"))); // NOI18N
        jXemChiTietHoaDon.setText("Xem chi tiết");
        jXemChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXemChiTietHoaDonActionPerformed(evt);
            }
        });

        jBXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delicon.png"))); // NOI18N
        jBXoa.setText(" Xóa");
        jBXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBXoaActionPerformed(evt);
            }
        });

        jTHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "MaKH", "MaNV", "Ngày lập", "Tổng tiền", "Ghi chú"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTHoaDonMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTHoaDon);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Danh Sách Hóa Đơn");

    jComboBoxHĐ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã HĐ", "Mã KH", "Mã NV" }));
    jComboBoxHĐ.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxHĐActionPerformed(evt);
        }
    });

    jButtonXuLy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/process.png"))); // NOI18N
    jButtonXuLy.setText("Tất cả");
    jButtonXuLy.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonXuLyActionPerformed(evt);
        }
    });

    jButtonCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/check.png"))); // NOI18N
    jButtonCheck.setText("Đã xong");
    jButtonCheck.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButtonCheckActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jBTimkiem)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jComboBoxHĐ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCheck)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButtonXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jXemChiTietHoaDon)
                    .addGap(18, 18, 18)
                    .addComponent(jBXoa)))
            .addContainerGap(69, Short.MAX_VALUE))
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(jLabel1)
            .addGap(39, 39, 39)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jXemChiTietHoaDon)
                .addComponent(jBXoa)
                .addComponent(jBTimkiem)
                .addComponent(jComboBoxHĐ, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButtonXuLy)
                .addComponent(jButtonCheck))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(75, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimkiemActionPerformed
        String tuKhoa = txtTimkiem.getText().toLowerCase();
    	if(tuKhoa.equals("")){
            upDTB();
        } else{
           upDTB();
           hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon(txtTimkiem.getText(),timkiemType);
           DefaultTableModel RecordTable = (DefaultTableModel)jTHoaDon.getModel();
           RecordTable.setRowCount(0);
           for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
            RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
           }
        }   
    }//GEN-LAST:event_jBTimkiemActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jXemChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXemChiTietHoaDonActionPerformed
        //Nếu chưa chọn hóa đơn nào thì thông báo lỗi
        if(hoadonDTO.MaHD==0) {
            new MyDialog("Vui lòng chọn hóa đơn cần xem chi tiết", MyDialog.ERROR_DIALOG);
        }
        //Nếu đã chọn hóa đơn thì mở giao diện xem chi tiết hóa đơn
        else {
            //Lấy dòng được chọn trong bảng
            int selectedRow = jTHoaDon.getSelectedRow();
            //Lấy mã hóa đơn từ dòng được chọn
            if (selectedRow != -1) {
                int maHD = Integer.parseInt(jTHoaDon.getValueAt(selectedRow, 0).toString());
                //Mở giao diện xem chi tiết hóa đơn
                new xemChiTietHoaDonGUI(maHD).setVisible(true);
            }
        }

    }//GEN-LAST:event_jXemChiTietHoaDonActionPerformed

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        if (hoadonDTO.MaHD == 0){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            cthoadonBUS.deleteCTHoaDon(hoadonDTO.MaHD);
            hoadonBUS.deleteHoaDon(hoadonDTO.MaHD);
            
            //Reset lại đối tượng chỏ trong bảng
            hoadonDTO = new HoaDonDTO();
            //Xóa xong phải load lại DTB lên Table để thể hiện xóa
            upDTB();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jTHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTHoaDonMouseClicked
    hoadonDTO = new HoaDonDTO();
    DefaultTableModel RecordTable = (DefaultTableModel) jTHoaDon.getModel();
    int SelectedRows = jTHoaDon.getSelectedRow();
    hoadonDTO.MaHD = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
    hoadonDTO.MaKH= (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 1).toString()));
    hoadonDTO.MaNV = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 2).toString()));
    //Xử lí ngayLap
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        hoadonDTO.NgayLap = sdf.parse(RecordTable.getValueAt(SelectedRows, 3).toString());
    } catch (ParseException ex) {
        ex.printStackTrace();
        // Xử lý lỗi ở đây
    }        
    hoadonDTO.GhiChu = (RecordTable.getValueAt(SelectedRows, 5).toString());

    }//GEN-LAST:event_jTHoaDonMouseClicked

    private void jComboBoxHĐActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHĐActionPerformed
        // Gán dữ liệu/giá trị hiện tại được chọn của combo box vào lại timkiemType:
        timkiemType = (String) jComboBoxHĐ.getSelectedItem();
        
               
            
    }//GEN-LAST:event_jComboBoxHĐActionPerformed

    private void jButtonXuLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuLyActionPerformed
        // TODO add your handling code here:
        TrangThaiJButtonXuLy++;
        if (TrangThaiJButtonXuLy >= 3) TrangThaiJButtonXuLy = 0;
        DefaultTableModel RecordTable = (DefaultTableModel)jTHoaDon.getModel();
        upDTB();
//        switch (TrangThaiJButtonXuLy){
//            case 0 -> {
//                jButtonXuLy.setText("Tất cả");
//                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("", "Ghi chú");
//                RecordTable.setRowCount(0);
//                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
//                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
//                }
//            }
//            case 1 -> {
//                jButtonXuLy.setText("Đang xử lý");
//                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("Dang xu ly", "Ghi chú");
//                RecordTable.setRowCount(0);
//                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
//                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
//                }
//            }
//            case 2 -> {
//                jButtonXuLy.setText("Hoàn tất");
//                hoadonBUS.listHoaDon = hoadonBUS.searchHoaDon("Hoan tat", "Ghi chú");
//                RecordTable.setRowCount(0);
//                for (HoaDonDTO hdtemp : hoadonBUS.listHoaDon){
//                    RecordTable.addRow(new Object[]{hdtemp.MaHD,hdtemp.MaKH,hdtemp.MaNV,hdtemp.NgayLap,hdtemp.TongTien,hdtemp.GhiChu});
//                }
//            }
//        }
        
    }//GEN-LAST:event_jButtonXuLyActionPerformed

    private void jButtonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckActionPerformed
        // TODO add your handling code here:
        MyDialog dlg = new MyDialog("Hóa đơn sẽ chuyển trạng thái sang hoàn tất?", MyDialog.WARNING_DIALOG);
        if(dlg.getAction() == MyDialog.OK_OPTION){
            hoadonBUS.updateHoaDonGhiChu(hoadonDTO.MaHD, "Hoan tat");
            upDTB();
        }
    }//GEN-LAST:event_jButtonCheckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTimkiem;
    private javax.swing.JButton jBXoa;
    private javax.swing.JButton jButtonCheck;
    private static javax.swing.JButton jButtonXuLy;
    private javax.swing.JComboBox<String> jComboBoxHĐ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTable jTHoaDon;
    private javax.swing.JButton jXemChiTietHoaDon;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
