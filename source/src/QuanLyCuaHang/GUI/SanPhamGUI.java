package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.BUS.SanPhamBUS;
import QuanLyCuaHang.DTO.SanPhamDTO;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class SanPhamGUI extends javax.swing.JInternalFrame {
    public static SanPhamBUS spBUS = new SanPhamBUS(); //Để thao tác với bảng dữ liệu 
    public static SanPhamDTO spDTO = new SanPhamDTO(); //Biến này đại diện cho khách hàng được chọn trong table
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    public SanPhamGUI() {
        initComponents();
        timkiemType = (String) jComboBox.getSelectedItem();
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        spBUS = new SanPhamBUS();
        spDTO = new SanPhamDTO();
        jTSanPham.setRowHeight(30);
        upDTB();
    }
    
    //Load DTB lên Table
    public static void upDTB(){
        DefaultTableModel RecordTable = (DefaultTableModel)jTSanPham.getModel();
        RecordTable.setRowCount(0);
        spBUS.getListSanPham();
        
        for (SanPhamDTO sptemp : spBUS.listSanPham){
            RecordTable.addRow(new Object[]{sptemp.MaSP,sptemp.TenSP,sptemp.Loai,sptemp.SoLuong,sptemp.DonViTinh,sptemp.DonGia});
        }
    }

    //Thêm dòng khi add đối tượng ở Jframe khác
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTSanPham.getModel();
        model.addRow(dataRow);
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBTimkiem = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jBThem = new javax.swing.JButton();
        jBSua = new javax.swing.JButton();
        jBXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSanPham = new javax.swing.JTable();
        jComboBox = new javax.swing.JComboBox<>();

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

        jBThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addicon.png"))); // NOI18N
        jBThem.setText(" Thêm");
        jBThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBThemActionPerformed(evt);
            }
        });

        jBSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/fixicon.png"))); // NOI18N
        jBSua.setText(" Sửa");
        jBSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSuaActionPerformed(evt);
            }
        });

        jBXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delicon.png"))); // NOI18N
        jBXoa.setText(" Xóa");
        jBXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBXoaActionPerformed(evt);
            }
        });

        jTSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Loại", "Số lượng", "Đơn vị tính", "Đơn giá"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTSanPhamMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTSanPham);

    jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Tên SP", "Mã loại" }));
    jComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(53, 53, 53)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jBTimkiem)
                    .addGap(18, 18, 18)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBThem)
                    .addGap(18, 18, 18)
                    .addComponent(jBSua)
                    .addGap(18, 18, 18)
                    .addComponent(jBXoa)))
            .addContainerGap(67, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(167, 167, 167)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jBTimkiem)
                .addComponent(jBXoa)
                .addComponent(jBSua)
                .addComponent(jBThem)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(70, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimkiemActionPerformed
        if(txtTimkiem.getText().trim().equals("")){
            upDTB();
        } else{
           upDTB();
           spBUS.listSanPham = spBUS.searchSanPham(txtTimkiem.getText(),timkiemType);
           DefaultTableModel RecordTable = (DefaultTableModel)jTSanPham.getModel();
           RecordTable.setRowCount(0);
           for (SanPhamDTO sptemp : spBUS.listSanPham){
           RecordTable.addRow(new Object[]{Integer.toString(sptemp.MaSP),sptemp.TenSP,sptemp.Loai,sptemp.SoLuong,sptemp.DonViTinh,sptemp.DonGia});
           }
        }   
    }//GEN-LAST:event_jBTimkiemActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jBThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemActionPerformed

        addSanPhamGUI addFrame = new addSanPhamGUI();
        addFrame.setVisible(true);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jBThemActionPerformed

    private void jBSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSuaActionPerformed

        if (spDTO.TenSP.trim().equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            updateSanPhamGUI updateFrame = new updateSanPhamGUI();
            updateFrame.setVisible(true);
            updateFrame.pack();
            updateFrame.setLocationRelativeTo(null);
            updateFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jBSuaActionPerformed

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        // TODO add your handling code here:
        if (spDTO.TenSP.trim().equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            spBUS.deleteSanPham(String.valueOf(spDTO.MaSP));
            //Reset lại đối tượng chỏ trong bảng
            spDTO = new SanPhamDTO();
            //Xóa xong phải load lại DTB lên Table để thể hiện xóa
            upDTB();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSanPhamMouseClicked
        //Lấy thông tin object khi click chuột vào
        DefaultTableModel RecordTable = (DefaultTableModel) jTSanPham.getModel();
        int SelectedRows = jTSanPham.getSelectedRow();
        spDTO.MaSP = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        spDTO.TenSP = (RecordTable.getValueAt(SelectedRows, 1).toString());
        spDTO.Loai = (RecordTable.getValueAt(SelectedRows, 2).toString());
        spDTO.SoLuong = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 3).toString()));
        spDTO.DonViTinh = (RecordTable.getValueAt(SelectedRows, 4).toString());
        spDTO.DonGia = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 5).toString()));
    }//GEN-LAST:event_jTSanPhamMouseClicked

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        timkiemType = (String) jComboBox.getSelectedItem();
    }//GEN-LAST:event_jComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSua;
    private javax.swing.JButton jBThem;
    private javax.swing.JButton jBTimkiem;
    private javax.swing.JButton jBXoa;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTable jTSanPham;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
