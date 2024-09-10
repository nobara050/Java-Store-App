package QuanLyCuaHang.GUI;

import Main.MyDialog;
import Main.MyRole;
import QuanLyCuaHang.BUS.CTPhieuNhapBUS;
import QuanLyCuaHang.BUS.NhaCungCapBUS;
import QuanLyCuaHang.BUS.PhieuNhapBUS;
import QuanLyCuaHang.BUS.SanPhamBUS;
import QuanLyCuaHang.DTO.NhaCungCapDTO;
import QuanLyCuaHang.DTO.SanPhamDTO;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class NhapHangGUI extends javax.swing.JInternalFrame {
    //Mấy biến để static để đưa dữ liệu cho jframe khác 
    public static SanPhamBUS spBUS = new SanPhamBUS(); //Để thao tác với bảng dữ liệu 
    public static SanPhamDTO spDTO = new SanPhamDTO(); //Biến này đại diện cho sản phẩm được chọn trong table
    public ArrayList<SanPhamDTO> phieunhap = new ArrayList<>(); //Biến này đại diện cho danh sách sản phẩm trong phiếu nhập
    public SanPhamDTO clickphieunhap = new SanPhamDTO(); //Biến này là sản phẩm trong phiếu nhập được click vào
    public PhieuNhapBUS pnBUS = new PhieuNhapBUS(); //Biến này dùng để tạo phiếu nhập mới lúc nhập thành công
    public CTPhieuNhapBUS ctpnBUS = new CTPhieuNhapBUS(); //Biến này dùng để tạo chi tiết phiếu nhập mới tương ứng với mỗi sản phẩm trong phiếu nhập
    public NhaCungCapBUS nccBUS = new NhaCungCapBUS(); //Biến này dùng để chọn nhà cung cấp 
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    
    int TongTien = 0;
    public NhapHangGUI() {
        initComponents();
        timkiemType = (String) jComboBox.getSelectedItem();
        nccBUS.getListNhaCungCap(); //Lấy danh sách nhà cung cấp
        Fillcombo(); //Combobox chọn nhà cung cấp
        
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        spBUS = new SanPhamBUS();
        spDTO = new SanPhamDTO();
        phieunhap = new ArrayList<>();
        jTSanPham.setRowHeight(30);
        jTPhieuNhap.setRowHeight(25);
        TongTien = 0;
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
    
    //Combobox nhà cung cấp
    public void Fillcombo(){
        for (NhaCungCapDTO temp: nccBUS.listNhaCungCap){
            jComboBoxNCC.addItem(temp.TenNCC);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSanPham = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTSoLuongNhap = new javax.swing.JTextField();
        jBThem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTPhieuNhap = new javax.swing.JTable();
        jLGioHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLTongTien = new javax.swing.JLabel();
        jBXoa = new javax.swing.JButton();
        jBRefesh = new javax.swing.JButton();
        jBNhap = new javax.swing.JButton();
        jComboBoxNCC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
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

    txtTimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtTimkiemActionPerformed(evt);
        }
    });

    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel1.setText("Số Lượng:");

    jTSoLuongNhap.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTSoLuongNhapActionPerformed(evt);
        }
    });

    jBThem.setText(" Thêm");
    jBThem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBThemActionPerformed(evt);
        }
    });

    jTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Mã SP", "Tên SP", "Số lượng", "Giá"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTPhieuNhapMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTPhieuNhap);

    jLGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhaphang.png"))); // NOI18N
    jLGioHang.setText("Phiếu Nhập");

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("Tổng tiền:");

    jLTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLTongTien.setText("0");
    jLTongTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jBXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delicon.png"))); // NOI18N
    jBXoa.setText(" Xóa");
    jBXoa.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBXoaActionPerformed(evt);
        }
    });

    jBRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reset.png"))); // NOI18N
    jBRefesh.setText("Refresh");
    jBRefesh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBRefeshActionPerformed(evt);
        }
    });

    jBNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon.png"))); // NOI18N
    jBNhap.setText("Nhập Hàng");
    jBNhap.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBNhapActionPerformed(evt);
        }
    });

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel2.setText("Nhà cung cấp");

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/view.png"))); // NOI18N
    jButton1.setText("Xem phiếu nhập");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton1MouseClicked(evt);
        }
    });

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
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGap(33, 33, 33)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBThem))
                        .addComponent(jComboBoxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(142, 142, 142)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addComponent(jLTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 80, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jBTimkiem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1)))
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jBXoa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBRefesh)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addComponent(jLGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGap(50, 50, 50))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBTimkiem)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLGioHang)
                        .addComponent(jButton1)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBThem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLTongTien)))
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBNhap))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(74, Short.MAX_VALUE))
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

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jTSoLuongNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSoLuongNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSoLuongNhapActionPerformed

    private void jBThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemActionPerformed
        //Ý tưởng của phiếu nhập tương tự giỏ hàng
        SanPhamDTO spDTOtemp = new SanPhamDTO(spDTO.MaSP, spDTO.TenSP, spDTO.Loai, spDTO.SoLuong, spDTO.DonViTinh, spDTO.HinhAnh, spDTO.DonGia);
        int sld = 0, slkho = spDTO.getSoLuong();
        boolean flagC = false; 

        //Kiểm tra chọn đối tượng chưa
        if (spDTOtemp.TenSP.equals("")) {
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        }
        //Kiểm tra nhập số lượng chưa
        else if (jTSoLuongNhap.getText().trim().isEmpty()) {
            new MyDialog("Nhập số lượng!", MyDialog.ERROR_DIALOG);
        } else {

            // Kiểm tra đã nhập số lượng hợp lệ chưa
            try {
                sld = Integer.parseInt(jTSoLuongNhap.getText().trim()); 
                if (sld <= 0) {
                    throw new NumberFormatException("Số lượng phải lớn hơn 0");
                } else flagC = true;
                //Đánh dấu đã nhập đúng số lượng, các bước thêm vào đã đầy đủ
            } catch (NumberFormatException e) {
                new MyDialog("Số lượng nhập vào không hợp lệ!", MyDialog.ERROR_DIALOG);
            }
        }
        //flagC tới đây true tức là chưa làm sai cú pháp đưa sản phẩm vào phiếu nhập

        //Xử lý việc thêm vào khi flagC ở trên thành công
        if (phieunhap.isEmpty() == false && flagC) { //Đây là xử lý thêm lần thứ 2 trở đi
            boolean found = false; //Biến kiểm tra sản phẩm thêm vào có trùng không
            for (SanPhamDTO phieunhaptemp : phieunhap) {
                //Xử lý có sản phẩm có mã sản phẩm trong giỏ hàng rồi tức là đã được thêm vào trước đó
                //Thực hiện cộng dồn thay vì add đối tượng mới vào mảng phieunhap
                if (phieunhaptemp.MaSP == spDTOtemp.MaSP) {
                    int sldNew = phieunhaptemp.SoLuong + sld;
                    phieunhaptemp.setSoLuong(sldNew);
                    found = true; //Trả true, cộng dồn số lượng thành công, không tạo đối tượng mới add vào mảng
                    break;
                }
            }
            //Xử lý sản phẩm chưa được thêm vào
            if (flagC && !found) {
                //Tạo đối tượng mới rồi add vào là được
                spDTOtemp.SoLuong = sld;
                phieunhap.add(spDTOtemp);
            }
        }

        //Đây là xử lý thêm vào lần đầu
        else if (flagC) {
            spDTOtemp.SoLuong = sld;
            phieunhap.add(spDTOtemp);
        }

        //Tới đây mà flagC true thì là đã thêm thành công
        //Còn false tức là nó báo dialog lỗi rồi nên không làm gì hết
        if (flagC) {
            TongTien = 0;
            DefaultTableModel RecordTable = (DefaultTableModel) jTPhieuNhap.getModel();
            RecordTable.setRowCount(0);
            for (SanPhamDTO phieunhaptemp : phieunhap) {
                RecordTable.addRow(new Object[]{
                    phieunhaptemp.MaSP,
                    phieunhaptemp.TenSP,
                    phieunhaptemp.SoLuong,
                    phieunhaptemp.DonGia * phieunhaptemp.SoLuong
                });
                TongTien = TongTien + phieunhaptemp.DonGia*phieunhaptemp.SoLuong;
            }
            jTSoLuongNhap.setText(""); //Reset lại txt nhập số lượng sau khi thêm thành công
            jLTongTien.setText(Integer.toString(TongTien));
        }
    }//GEN-LAST:event_jBThemActionPerformed

    private void jTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPhieuNhapMouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTPhieuNhap.getModel();
        int SelectedRows = jTPhieuNhap.getSelectedRow();
        clickphieunhap.MaSP = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        clickphieunhap.TenSP = (RecordTable.getValueAt(SelectedRows, 1).toString());
        clickphieunhap.SoLuong = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 2).toString()));
        clickphieunhap.DonGia = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 3).toString()));
    }//GEN-LAST:event_jTPhieuNhapMouseClicked

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed
        // TODO add your handling code here:
        if (phieunhap.isEmpty()){
            new MyDialog("Chưa có sản phẩm trong phiếu nhập!", MyDialog.ERROR_DIALOG);
        }
        else if (clickphieunhap.MaSP == 0) {
            new MyDialog("Chọn sản phẩm cần xóa khỏi phiếu nhập!", MyDialog.ERROR_DIALOG);
        }
        else{
            for (int i=0; i<phieunhap.size(); i++) {
                if (phieunhap.get(i).MaSP == clickphieunhap.MaSP){
                    phieunhap.remove(i);
                }
            }
            TongTien = 0;
            DefaultTableModel RecordTable = (DefaultTableModel) jTPhieuNhap.getModel();
            RecordTable.setRowCount(0);
            for (SanPhamDTO phieunhaptemp : phieunhap) {
                RecordTable.addRow(new Object[]{
                    phieunhaptemp.MaSP,
                    phieunhaptemp.TenSP,
                    phieunhaptemp.SoLuong,
                    phieunhaptemp.DonGia * phieunhaptemp.SoLuong
                });
                TongTien = TongTien + phieunhaptemp.DonGia*phieunhaptemp.SoLuong;
            }
            jLTongTien.setText(Integer.toString(TongTien));
            clickphieunhap = new SanPhamDTO();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jBRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefeshActionPerformed
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel)jTPhieuNhap.getModel();
        RecordTable.setRowCount(0);
        TongTien = 0;
        phieunhap = new ArrayList<>();
        jLTongTien.setText("0");
    }//GEN-LAST:event_jBRefeshActionPerformed

    private void jBNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNhapActionPerformed
        MyDialog dlg = new MyDialog("Xác nhận nhập hàng", MyDialog.WARNING_DIALOG);
        boolean flag = true;
        
        int curPhieuNhap = pnBUS.getMaPNMoiNhat()+1;
        
        if(dlg.getAction() == MyDialog.OK_OPTION) {
            if(phieunhap.isEmpty() == true){
                new MyDialog("Chưa có sản phẩm nào trong phiếu nhập!", MyDialog.ERROR_DIALOG);
            }else {
                String selectedNCC = jComboBoxNCC.getSelectedItem().toString();
                int nccInfo = nccBUS.getNCCTheoTen(selectedNCC).MaNCC;
                int curmanv = MyRole.manv;
                //Đoạn này sẽ dùng trigger trong môn hệ quản trị để tính tổng tiền của phiếu nhập
                //2 trigger được kích hoạt là trigger kiểm tra phiếu nhập mới tạo có tổng tiền bằng 0 hay chưa
                //trigger còn lại là trigger tính tổng tiền của các chi tiết phiếu nhập đó và update vào phiếu nhập 
                flag = pnBUS.addPhieuNhap(curPhieuNhap,nccInfo,curmanv, 0);//có cài trigger tính giùm tổng tiền rồi

                if(flag == false){
                    new MyDialog("Lỗi xảy ra. Nhập hàng thất bại", MyDialog.ERROR_DIALOG);
                }

                else {
                        for (SanPhamDTO temp : phieunhap){
                            //Chỗ này update lại số lượng trong DAO luôn rồi nên khỏi phải dùng hàm update, mốt làm v cho gọn
                            ctpnBUS.addCTPhieuNhap(curPhieuNhap,temp.MaSP,temp.SoLuong); 
                        }

                        new MyDialog("Nhập thành công. \nBạn vừa thêm phiếu nhập số: " + curPhieuNhap, MyDialog.SUCCESS_DIALOG);
                        DefaultTableModel RecordTable = (DefaultTableModel)jTPhieuNhap.getModel();
                        RecordTable.setRowCount(0);
                        phieunhap = new ArrayList<>();
                        clickphieunhap = new SanPhamDTO();
                        TongTien = 0;
                        jLTongTien.setText("0");
                        upDTB();
                    }
            }
        }

    }//GEN-LAST:event_jBNhapActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        xemPhieuNhapGUI addFrame = new xemPhieuNhapGUI();
        addFrame.setVisible(true);
        addFrame.pack();
        addFrame.setLocationRelativeTo(null);
        addFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        timkiemType = (String) jComboBox.getSelectedItem();
    }//GEN-LAST:event_jComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBNhap;
    private javax.swing.JButton jBRefesh;
    private javax.swing.JButton jBThem;
    private javax.swing.JButton jBTimkiem;
    private javax.swing.JButton jBXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JComboBox<String> jComboBoxNCC;
    private javax.swing.JLabel jLGioHang;
    private javax.swing.JLabel jLTongTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTPhieuNhap;
    static javax.swing.JTable jTSanPham;
    private javax.swing.JTextField jTSoLuongNhap;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
