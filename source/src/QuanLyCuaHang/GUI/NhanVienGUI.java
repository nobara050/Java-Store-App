package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.BUS.NhanVienBUS;
import QuanLyCuaHang.DTO.NhanVienDTO;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class NhanVienGUI extends javax.swing.JInternalFrame {

    public static NhanVienBUS nhanvienBUS = new NhanVienBUS(); //Để thao tác với bảng dữ liệu 
    public static NhanVienDTO nhanvienDTO = new NhanVienDTO(); //Biến này đại diện cho khách hàng được chọn trong table
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    public NhanVienGUI() {
        initComponents();
        timkiemType = (String) jComboBox.getSelectedItem();
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        nhanvienBUS = new NhanVienBUS();
        nhanvienDTO = new NhanVienDTO();
        jTNhanVien.setRowHeight(30);
        upDTB();
    }
    //Load DTB lên Table
    public static void upDTB(){
        DefaultTableModel RecordTable = (DefaultTableModel)jTNhanVien.getModel();
        RecordTable.setRowCount(0);
        nhanvienBUS.getListNhanVien();
        
        for (NhanVienDTO nhanvientemp : nhanvienBUS.listNhanVien){
            RecordTable.addRow(new Object[]{nhanvientemp.MaNV,nhanvientemp.Ho,nhanvientemp.Ten,nhanvientemp.GioiTinh,nhanvientemp.ChucVu,nhanvientemp.NgayBD, nhanvientemp.NgaySinh});
        }
    }
    
    public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)jTNhanVien.getModel();
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
        jTNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        jTNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ", "Tên", "Giới tính", "Chức vụ", "Ngày vào làm", "Ngày sinh"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTNhanVienMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTNhanVien);

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Danh Sách Nhân Viên");

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/acc.png"))); // NOI18N
    jButton1.setText("Tài khoản");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Họ tên", "Giới tính" }));
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
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jBTimkiem)
                    .addGap(18, 18, 18)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(18, 18, 18)
                    .addComponent(jBThem)
                    .addGap(18, 18, 18)
                    .addComponent(jBSua)
                    .addGap(18, 18, 18)
                    .addComponent(jBXoa))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(69, Short.MAX_VALUE))
        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBXoa)
                .addComponent(jBSua)
                .addComponent(jBThem)
                .addComponent(jBTimkiem)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(84, 84, 84))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    
    
    private void jXemTaiKhoanActionPerformed(ActionEvent evt) {
    	if(nhanvienDTO.MaNV== 0) {
            new MyDialog("Vui lòng chọn nhân viên cần xem!", MyDialog.ERROR_DIALOG);
        }
        //Nếu đã chọn hóa đơn thì mở giao diện xem chi tiết hóa đơn
        else {
            //Lấy dòng được chọn trong bảng
            int selectedRow = jTNhanVien.getSelectedRow();
            //Lấy mã hóa đơn từ dòng được chọn
            if (selectedRow != -1) {
                int maNV = Integer.parseInt(jTNhanVien.getValueAt(selectedRow, 0).toString());
                //Mở giao diện xem chi tiết hóa đơn
                new accNhanVienGUI_fixpass().setVisible(true);
            }
        }
		
	}
    
    
    
    private void jBTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimkiemActionPerformed
        // TODO add your handling code here:
         if(txtTimkiem.getText().trim().equals("")){
            upDTB();
        } else{
           upDTB();
           nhanvienBUS.listNhanVien = nhanvienBUS.searchNhanVien(txtTimkiem.getText(),timkiemType);
           DefaultTableModel RecordTable = (DefaultTableModel)jTNhanVien.getModel();
           RecordTable.setRowCount(0);
           for (NhanVienDTO nvtemp : nhanvienBUS.listNhanVien){
           RecordTable.addRow(new Object[]{Integer.toString(nvtemp.MaNV),nvtemp.Ho,nvtemp.Ten,nvtemp.GioiTinh,nvtemp.ChucVu});
           }
        } 
    }//GEN-LAST:event_jBTimkiemActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jBThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemActionPerformed
        // TODO add your handling code here:
        addNhanVienGUI addFrame = new addNhanVienGUI();
        addFrame.setVisible(true);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jBThemActionPerformed

    private void jBSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSuaActionPerformed
        // TODO add your handling code here:
        if (nhanvienDTO.Ten.equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            updateNhanVienGUI updateFrame = new updateNhanVienGUI();
            updateFrame.setVisible(true);
            updateFrame.pack();
            updateFrame.setLocationRelativeTo(null);
            updateFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jBSuaActionPerformed

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        // TODO add your handling code here:
        if (nhanvienDTO.Ten.equals("")){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            nhanvienBUS.deleteNhanVien(String.valueOf(nhanvienDTO.MaNV));
            //Reset lại đối tượng chỏ trong bảng
            nhanvienDTO = new NhanVienDTO();
            //Xóa xong phải load lại DTB lên Table để thể hiện xóa
            upDTB();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jTNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNhanVienMouseClicked
        //Lấy thông tin object khi click chuột vào
        DefaultTableModel RecordTable = (DefaultTableModel) jTNhanVien.getModel();
        int SelectedRows = jTNhanVien.getSelectedRow();
        nhanvienDTO.MaNV = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        nhanvienDTO.Ho = (RecordTable.getValueAt(SelectedRows, 1).toString());
        nhanvienDTO.Ten = (RecordTable.getValueAt(SelectedRows, 2).toString());
        nhanvienDTO.GioiTinh = (RecordTable.getValueAt(SelectedRows, 3).toString());
        nhanvienDTO.ChucVu = (RecordTable.getValueAt(SelectedRows, 4).toString());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            nhanvienDTO.NgayBD = sdf.parse(RecordTable.getValueAt(SelectedRows, 5).toString());
        } catch (ParseException ex) {
            ex.printStackTrace(); 
        } 
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            nhanvienDTO.NgayBD = sdf.parse(RecordTable.getValueAt(SelectedRows, 5).toString());
        } catch (ParseException ex) {
            ex.printStackTrace(); 
        } 

    }//GEN-LAST:event_jTNhanVienMouseClicked

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        timkiemType = (String) jComboBox.getSelectedItem();
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (nhanvienDTO.MaNV == 0){
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        } else {
            accNhanVienGUI addFrame = new accNhanVienGUI();
            addFrame.setVisible(true);
            addFrame.pack();
            addFrame.setLocationRelativeTo(null);
            addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSua;
    private javax.swing.JButton jBThem;
    private javax.swing.JButton jBTimkiem;
    private javax.swing.JButton jBXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTable jTNhanVien;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
