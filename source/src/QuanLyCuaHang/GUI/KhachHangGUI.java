package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.BUS.KhachHangBUS;
import QuanLyCuaHang.DTO.KhachHangDTO;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class KhachHangGUI extends javax.swing.JInternalFrame {
    public static KhachHangBUS khBUS = new KhachHangBUS(); //Để thao tác với bảng dữ liệu khách hàng
    public static KhachHangDTO khDTO = new KhachHangDTO(); //Biến này đại diện cho khách hàng được chọn trong table
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    public KhachHangGUI() {
        initComponents();
        timkiemType = (String) jComboBox.getSelectedItem();
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        khBUS = new KhachHangBUS();
        khDTO = new KhachHangDTO();
        jTKhachHang.setRowHeight(30);
        upDTB();
    }
    //Load DTB lên Table
    public static void upDTB(){
        DefaultTableModel RecordTable = (DefaultTableModel)jTKhachHang.getModel();
        RecordTable.setRowCount(0);
        khBUS.getListKhachHang();
            for (KhachHangDTO khtemp : khBUS.listKhachHang){
                    RecordTable.addRow(new Object[]{khtemp.MaKH,khtemp.Ho,khtemp.Ten,khtemp.GioiTinh,khtemp.TongChiTieu});
            }
    }
    
    //Thêm dòng khi add đối tượng ở Jframe khác
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTKhachHang.getModel();
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
        jTKhachHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
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

        jTKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ", "Tên", "Giới tính", "Chi tiêu"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTKhachHangMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTKhachHang);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Danh Sách Khách Hàng");

    jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã KH", "Họ tên", "Giới tính" }));
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
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jBTimkiem)
                    .addGap(18, 18, 18)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBThem)
                    .addGap(18, 18, 18)
                    .addComponent(jBSua)
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
                .addComponent(jBThem)
                .addComponent(jBSua)
                .addComponent(jBXoa)
                .addComponent(jBTimkiem)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(75, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimkiemActionPerformed
        String tukhoa = txtTimkiem.getText().toLowerCase();
        if(tukhoa.equals("")){
            upDTB();
        } else {
            upDTB();
            khBUS.listKhachHang = khBUS.searchKhachHang(txtTimkiem.getText(), timkiemType);
            if (khBUS.listKhachHang != null) {
                DefaultTableModel RecordTable = (DefaultTableModel) jTKhachHang.getModel();
                RecordTable.setRowCount(0);
                for (KhachHangDTO khtemp : khBUS.listKhachHang) {
                    if (khtemp != null) {
                        RecordTable.addRow(new Object[]{khtemp.MaKH, khtemp.Ho, khtemp.Ten, khtemp.GioiTinh, khtemp.TongChiTieu});
                    }
                }
            }
        }
    }//GEN-LAST:event_jBTimkiemActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jBThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemActionPerformed
        // TODO add your handling code here:
        addKhachHangGUI addFrame = new addKhachHangGUI();
        addFrame.setVisible(true);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jBThemActionPerformed

    private void jBSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSuaActionPerformed
        // TODO add your handling code here:
        if (khDTO.Ten.trim().equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            updateKhachHangGUI updateFrame = new updateKhachHangGUI();
            updateFrame.setVisible(true);
            updateFrame.pack();
            updateFrame.setLocationRelativeTo(null);
            updateFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jBSuaActionPerformed

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        // TODO add your handling code here:
        if (khDTO.Ten.trim().equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            khBUS.deleteKhachHang(khDTO.MaKH);
            //Reset lại đối tượng chỏ trong bảng
            khDTO = new KhachHangDTO();
            //Xóa xong phải load lại DTB lên Table để thể hiện xóa
            upDTB();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jTKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTKhachHangMouseClicked
        //Lấy thông tin object khi click chuột vào
        DefaultTableModel RecordTable = (DefaultTableModel) jTKhachHang.getModel();
        int SelectedRows = jTKhachHang.getSelectedRow();
        khDTO.MaKH = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        khDTO.Ho = (RecordTable.getValueAt(SelectedRows, 1).toString());
        khDTO.Ten = (RecordTable.getValueAt(SelectedRows, 2).toString());
        khDTO.GioiTinh = (RecordTable.getValueAt(SelectedRows, 3).toString());
        khDTO.TongChiTieu = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 4).toString()));

    }//GEN-LAST:event_jTKhachHangMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTable jTKhachHang;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
