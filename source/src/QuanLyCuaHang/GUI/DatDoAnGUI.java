package QuanLyCuaHang.GUI;

import Main.MyConnect;
import Main.MyDialog;
import Main.MyRole;
import QuanLyCuaHang.BUS.CTHoaDonBUS;
import QuanLyCuaHang.BUS.HoaDonBUS;
import QuanLyCuaHang.BUS.KhachHangBUS;
import QuanLyCuaHang.BUS.SanPhamBUS;
import QuanLyCuaHang.DTO.SanPhamDTO;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.sql.*;
import java.awt.Desktop;
import java.text.NumberFormat;
import java.util.Locale;


public class DatDoAnGUI extends javax.swing.JInternalFrame {
    //======================================================
    //========KHAI BÁO GIỎ HÀNG VÀ BẢNG SẢN PHẨM ===========
    //======================================================
    public static SanPhamBUS spBUS = new SanPhamBUS(); //Biến này dùng để thao tác bảng dữ liệu sản phẩm
    public static SanPhamDTO spClicked = new SanPhamDTO(); //Biến này đại diện cho sản phẩm được click vào trong table sản phẩm
    public ArrayList<SanPhamDTO> giohang = new ArrayList<>(); //Biến này đại diện cho cái giỏ hàng, là một mảng các sản phẩm 
    public SanPhamDTO giohangClicked = new SanPhamDTO(); //Biến này sẽ lưu thông tin sản phẩm được click vào trong giỏ hàng
    
    //======================================================
    //====KHAI BÁO BIẾN DÙNG THANH TẠO HÓA ĐƠN VÀ CTHD =====
    //======================================================
    public CTHoaDonBUS ctBUS = new CTHoaDonBUS(); //Biến này dùng trong jBTThanhToan. Dùng BUS tạo CTHoaDon mới khi thanh toán
    public HoaDonBUS hdBUS = new HoaDonBUS(); //Biến này dùng trong jBTThanhToan. Dùng BUS tạo HoaDon mới khi thanh toán
    public KhachHangBUS khBUS = new KhachHangBUS(); //Biến này dùng trong nút jBTThanhToan. Dùng để kiểm tra mã khách hàng mua hàng có tồn tại hay chưa
    int TongTien = 0; //Tổng thành tiền, dùng để thanh toán tạo hóa đơn
    public String timkiemType; //Biến dùng để lấy dữ liệu combobox
    public static int prehoadon = 0;
    
    public DatDoAnGUI() {
        initComponents(); //Chạy các thành phần trong design mode
        timkiemType = (String) jComboBox.getSelectedItem();
        //Bỏ cái khung kéo bo của internal panel
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        //Làm mới các biến static mỗi lần reset panel
        spBUS = new SanPhamBUS();
        spClicked = new SanPhamDTO();
        khBUS.getListKhachHang();
        spBUS.getListSanPham();
        giohang = new ArrayList<>();
        
        //Set chiều cao các dòng trong table
        jTSanPham.setRowHeight(30);
        jTGioHang.setRowHeight(25);
        TongTien = 0;
        
        //load dữ liệu từ database lên table
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
    
    public String DinhDangTienTe (int SoTien) {
        //tạo 1 NumberFormat để định dạng số theo tiêu chuẩn EN
        Locale localeEN = new Locale("en","En");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        //phần ngăn của số được phân cách bằng dấu phẩy
        String str = en.format(SoTien);
        return str;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBTimkiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTSanPham = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTSoLuongDat = new javax.swing.JTextField();
        jBThem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTGioHang = new javax.swing.JTable();
        jLGioHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLTongTien = new javax.swing.JLabel();
        jBXoa = new javax.swing.JButton();
        jBRefesh = new javax.swing.JButton();
        jBThanhToan = new javax.swing.JButton();
        jTMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        xuathoadon = new javax.swing.JButton();

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

    jTSoLuongDat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTSoLuongDatActionPerformed(evt);
        }
    });

    jBThem.setText(" Thêm");
    jBThem.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBThemActionPerformed(evt);
        }
    });

    jTGioHang.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Mã SP", "Tên SP", "Số lượng", "Giá"
        }
    )
    {public boolean isCellEditable(int row, int column){return false;}}

    );
    jTGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTGioHangMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTGioHang);

    jLGioHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLGioHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Cart.png"))); // NOI18N
    jLGioHang.setText("Giỏ Hàng");

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

    jBThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thanhtoan.png"))); // NOI18N
    jBThanhToan.setText("Thanh toán");
    jBThanhToan.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBThanhToanActionPerformed(evt);
        }
    });

    jTMaKH.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTMaKHActionPerformed(evt);
        }
    });

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    jLabel2.setText("Số điện thoại Khách");

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("(Nếu khách không có tài khoản thì sẽ lưu với makh là 0)");

    jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã SP", "Tên SP", "Mã loại" }));
    jComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBoxActionPerformed(evt);
        }
    });

    xuathoadon.setText("Xuất hóa đơn");
    xuathoadon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            xuathoadonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jBTimkiem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTMaKH)
                                        .addComponent(jTSoLuongDat, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jBThem)))))
                    .addGap(142, 142, 142))
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1)
                    .addGap(18, 18, 18)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)
                    .addComponent(jLTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jBXoa)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jBRefesh)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jBThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addComponent(jLGioHang, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
            .addGap(0, 37, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(xuathoadon)
            .addGap(127, 127, 127))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBTimkiem)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLGioHang)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTSoLuongDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBThem))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLTongTien)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBXoa)
                    .addComponent(jBThanhToan)
                    .addComponent(jBRefesh)
                    .addComponent(jTMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)))
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(xuathoadon)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTimkiemActionPerformed
        if(txtTimkiem.getText().trim().equals("")){
            //Load lại table dựa vào DTB nếu không có gì trong ô txtTimkiem
            upDTB();
        } 
        
        else{
            //Load lại table dựa vào DTB
            //Điều này để phòng trường hợp tìm kiếm rồi, muốn tìm lần nữa thì lúc này table đã bị thay đổi
            //Nên trước khi tìm tiếp sẽ load lại lần nữa
            upDTB();

            //Gọi hàm tìm kiếm trong BUS và lưu vào biến spBUS.listSanPham
            spBUS.listSanPham = spBUS.searchSanPham(txtTimkiem.getText(),timkiemType);
            //Set cột lại cho table, và thêm vào với từng đối tượng trong spBUS
            DefaultTableModel RecordTable = (DefaultTableModel)jTSanPham.getModel();
            RecordTable.setRowCount(0);
            for (SanPhamDTO sptemp : spBUS.listSanPham){
                RecordTable.addRow(new Object[]{Integer.toString(sptemp.MaSP),sptemp.TenSP,sptemp.Loai,sptemp.SoLuong,sptemp.DonViTinh,sptemp.DonGia});
            }
        }   
    }//GEN-LAST:event_jBTimkiemActionPerformed

    private void jTSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSanPhamMouseClicked
        //Lấy thông tin object khi click chuột vào
        spClicked = new SanPhamDTO();
        DefaultTableModel RecordTable = (DefaultTableModel) jTSanPham.getModel();
        int SelectedRows = jTSanPham.getSelectedRow();
        
        //Lưu thông tin này vào spClicked
        spClicked.MaSP = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        spClicked.TenSP = (RecordTable.getValueAt(SelectedRows, 1).toString());
        spClicked.Loai = (RecordTable.getValueAt(SelectedRows, 2).toString());
        spClicked.SoLuong = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 3).toString()));
        spClicked.DonViTinh = (RecordTable.getValueAt(SelectedRows, 4).toString());
        spClicked.DonGia = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 5).toString()));
    }//GEN-LAST:event_jTSanPhamMouseClicked

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jTSoLuongDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSoLuongDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSoLuongDatActionPerformed

    private void jBThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThemActionPerformed
        //Ý tưởng là tạo một mảng giohang, nếu sản phẩm đã tồn tại thì update lại số lượng, nếu chưa thì thêm một đối tượng mới vào mảng giohang
        //spClicked là sản phẩm được bấm vào trong bảng jTSanPham
        //Tạo một spClickedtemp là bản sao chép của spClicked để có thay đổi gì thì spClicked không bị đổi
        SanPhamDTO spClickedtemp = new SanPhamDTO(spClicked.MaSP, spClicked.TenSP, spClicked.Loai, spClicked.SoLuong, spClicked.DonViTinh, spClicked.HinhAnh, spClicked.DonGia);

        int sld = 0, slkho = spClicked.getSoLuong();
        //sld là số trong txtField, khai báo bằng 0 ở đây và lát mới gán giá trị của txtField nhằm catch lỗi
        //slkho là số lượng sản phẩm kho còn

        boolean flagC = false; //Biến này là biến xét coi có thêm thành công vào giỏ hay không
        //Nếu thêm thất bại thì flagC trả false
        //Nếu thành công thì load lại jTable dựa vào mảng giỏ hàng

        //Kiểm tra chọn đối tượng chưa
        if (spClickedtemp.TenSP.equals("")) {
            new MyDialog("Chưa chọn đối tượng!", MyDialog.ERROR_DIALOG);
        }
        //Kiểm tra nhập số lượng chưa
        else if (jTSoLuongDat.getText().trim().isEmpty()) {
            new MyDialog("Nhập số lượng!", MyDialog.ERROR_DIALOG);
        } else {

            // Kiểm tra đã nhập số lượng hợp lệ chưa
            try {
                sld = Integer.parseInt(jTSoLuongDat.getText().trim()); //Số lượng nhập ở cái khung txt
                //Khai báo sld ở đây do khai báo ở trên không catch lỗi "nhập số lượng không hợp lệ" được
                if (sld <= 0) {
                    throw new NumberFormatException("Số lượng phải lớn hơn 0");
                } else flagC = true;
                //Đánh dấu đã nhập đúng số lượng, các bước thêm vào đã đầy đủ
            } catch (NumberFormatException e) {
                new MyDialog("Số lượng nhập vào không hợp lệ!", MyDialog.ERROR_DIALOG);
            }
        }
        //flagC tới đây true tức là chưa làm sai cú pháp thêm sản phẩm

        //Xử lý việc thêm vào khi flagC ở trên thành công
        if (giohang.isEmpty() == false && flagC) { //Đây là xử lý thêm lần thứ 2 trở đi
            boolean found = false; //Biến kiểm tra sản phẩm thêm vào có trùng không
            for (SanPhamDTO giohangtemp : giohang) {
                //Xử lý có sản phẩm có mã sản phẩm trong giỏ hàng rồi tức là đã được thêm vào trước đó
                //Thực hiện cộng dồn thay vì add đối tượng mới vào mảng giohang
                if (giohangtemp.MaSP == spClickedtemp.MaSP) {
                    int sldNew = giohangtemp.SoLuong + sld;
                    if (sldNew > slkho) { //Check xem sau khi cộng dồn có nhiều hơn kho hay không
                        new MyDialog("Số lượng hàng trong kho không đủ!", MyDialog.ERROR_DIALOG);
                        flagC = false;
                        break;
                    }
                    giohangtemp.setSoLuong(sldNew);
                    found = true; //Trả true, cộng dồn số lượng thành công, không tạo đối tượng mới add vào mảng
                    break;
                }
            }
            //Xử lý sản phẩm chưa được thêm vào
            if (flagC && !found) {
                if (sld > slkho) {
                    new MyDialog("Số lượng hàng trong kho không đủ!", MyDialog.ERROR_DIALOG);
                    flagC = false;
                } else {
                    //Tạo đối tượng mới rồi add vào là được
                    spClickedtemp.SoLuong = sld;
                    giohang.add(spClickedtemp);
                }
            }
        }

        //Đây là xử lý thêm vào lần đầu
        else if (flagC) {
            if (sld > slkho) {
                new MyDialog("Số lượng hàng trong kho không đủ!", MyDialog.ERROR_DIALOG);
            } else {
                spClickedtemp.SoLuong = sld; //spClickedtemp sẽ lưu dữ liệu soLuong định bán, vì vậy ban đầu mới phải clone ra từ thằng spClicked
                giohang.add(spClickedtemp);
            }
        }

        //Tới đây mà flagC true thì là đã thêm thành công
        //Còn false tức là nó báo dialog lỗi rồi nên không làm gì hết
        TongTien = 0;
        if (flagC) {
            DefaultTableModel RecordTable = (DefaultTableModel) jTGioHang.getModel();
            RecordTable.setRowCount(0);
            for (SanPhamDTO giohangtemp : giohang) {
                RecordTable.addRow(new Object[]{
                    giohangtemp.MaSP,
                    giohangtemp.TenSP,
                    giohangtemp.SoLuong,
                    giohangtemp.DonGia * giohangtemp.SoLuong
                });
                TongTien = TongTien + giohangtemp.DonGia*giohangtemp.SoLuong;
            }
            jTSoLuongDat.setText(""); //Reset lại txt nhập số lượng sau khi thêm thành công
            jLTongTien.setText(Integer.toString(TongTien));
        }
    }//GEN-LAST:event_jBThemActionPerformed

    private void jTGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTGioHangMouseClicked
        DefaultTableModel RecordTable = (DefaultTableModel) jTGioHang.getModel();
        int SelectedRows = jTGioHang.getSelectedRow();
        giohangClicked.MaSP = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString()));
        giohangClicked.TenSP = (RecordTable.getValueAt(SelectedRows, 1).toString());
        giohangClicked.SoLuong = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 2).toString()));
        giohangClicked.DonGia = (Integer.parseInt(RecordTable.getValueAt(SelectedRows, 3).toString()));
    }//GEN-LAST:event_jTGioHangMouseClicked

    private void jBXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBXoaActionPerformed

        if (giohang.isEmpty()){
            new MyDialog("Chưa có sản phẩm trong giỏ hàng!", MyDialog.ERROR_DIALOG);
        }
        else if (giohangClicked.MaSP == 0) {
            new MyDialog("Chọn sản phẩm cần xóa khỏi giỏ hàng!", MyDialog.ERROR_DIALOG);
        }
        else{
            for (int i=0; i<giohang.size(); i++) {
                if (giohang.get(i).MaSP == giohangClicked.MaSP){
                    giohang.remove(i);
                }
            }
            TongTien = 0;
            DefaultTableModel RecordTable = (DefaultTableModel) jTGioHang.getModel();
            RecordTable.setRowCount(0);
            for (SanPhamDTO giohangtemp : giohang) {
                RecordTable.addRow(new Object[]{
                    giohangtemp.MaSP,
                    giohangtemp.TenSP,
                    giohangtemp.SoLuong,
                    giohangtemp.DonGia * giohangtemp.SoLuong
                });
                TongTien = TongTien + giohangtemp.DonGia*giohangtemp.SoLuong;
            }
            jLTongTien.setText(Integer.toString(TongTien));
            giohangClicked = new SanPhamDTO();
        }
    }//GEN-LAST:event_jBXoaActionPerformed

    private void jBRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefeshActionPerformed
        DefaultTableModel RecordTable = (DefaultTableModel)jTGioHang.getModel();
        RecordTable.setRowCount(0);
        TongTien = 0;
        giohang = new ArrayList<>();
        jLTongTien.setText("0");
    }//GEN-LAST:event_jBRefeshActionPerformed

    private void jBThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBThanhToanActionPerformed
        
        //Hộp thoại xác nhận thanh toán
        MyDialog dlg = new MyDialog("Xác nhận thanh toán", MyDialog.WARNING_DIALOG);
        boolean HDflag; //Biến này để check coi thanh toán có thành công không, nếu có thì sẽ dùng để tạo hóa đơn và chi tiết hóa đơn ở dưới nữa
        int hoadondangxuly = hdBUS.getMaHoaDonMoiNhat()+1;
        
        //(If lớn nhất) nếu chọn No thì jBThanhToan kết thúc tại đây
        //Chọn Yes sẽ tiếp tục 
        if(dlg.getAction() == MyDialog.OK_OPTION) {
            
            //1. Kiểm tra giỏ hàng có sản phẩm chưa, nếu chưa in dòng thông báo và kết thúc jBThanhToan 
            if(giohang.isEmpty() == true){
                new MyDialog("Chưa có sản phẩm nào trong giỏ hàng!", MyDialog.ERROR_DIALOG);
            } 
            
            //2. Trường hợp giỏ hàng có đồ, sẽ tiếp tục thanh toán
            else {
                
                //2.1 Khách hàng không đăng ký tài khoản và thanh toán diện không đăng ký tài khoản, cho họ makh là 0 và thanh toán
                if(jTMaKH.getText().trim().equals("")) {
                    hdBUS.addHoaDon(hoadondangxuly, 0, MyRole.manv, 0, "Dang xu ly"); //Tạo hóa đơn
                    //Để tổng tiền là 0 vì trong hệ quản trị ta đã cài trigger tự động tính tổng tiền hoadon, phieunhap, tongchitieu
                    
                    //Cờ này báo hiệu việc hóa đơn tạo thành công và sẽ tạo cthoadon
                    HDflag = true;
                } 
                
                //2.2 Khách hàng có đọc cho nhập makh nhưng không có trong csdl, họ đọc sai hoặc chưa tạo tài khoản, báo lỗi và kết thúc jBThanhToan
                else if(khBUS.getKhachHangTheoMaKH(jTMaKH.getText().trim()) == null){
                    new MyDialog("Mã khách hàng chưa tồn tại \ntạo khách hàng mới hoặc lưu thông tin khách mà không cần nhập mã.", MyDialog.ERROR_DIALOG);
                    HDflag = false;
                }
                
                //2.3 Khách đã đăng ký trước đó và đọc đúng makh (hay số điện thoại) thì sẽ thanh toán với makh đó 
                else{
                    // Cố gắng thêm hóa đơn vào cơ sở dữ liệu với mã khách hàng từ jTMaKH
                    //Chỗ này để tổng tiền hóa đơn là 0 do áp dụng trigger trong hệ quản trị
                    //Đoạn này trigger tính tổng tiền hóa đơn sẽ kích hoạt khi thêm hay xóa một chi tiết hóa đơn, nó sẽ tính tổng tiền của chi tiết hóa đơn xong update lại chỗ hóa dơn
                    hdBUS.addHoaDon(hoadondangxuly,Integer.parseInt(jTMaKH.getText()), MyRole.manv, 0, "Dang xu ly");
                    HDflag = true;    
                }
                
                //3. Sau khi tạo hóa đơn thành công sẽ thêm chi tiết hóa đơn với từng món ăn được thêm vào giỏ 
                if(HDflag){
                    boolean checkhere;
                    //Tạo chi tiết hóa đơn mới cho mỗi mục sản phẩm ta mua trong giỏ hàng
                    for (SanPhamDTO temp : giohang){
                        checkhere = ctBUS.addCTHoaDon(  hoadondangxuly,
                                    temp.MaSP,
                                    temp.SoLuong);
                        if(!checkhere){
                            new MyDialog("Đã xảy ra lỗi do số lượng chưa đc cập nhật lại! Vui lòng thử lại.", MyDialog.ERROR_DIALOG);
                            hdBUS.Xoa_HOADON_CTHOADON(hoadondangxuly);
                            HDflag = false;
                            
                            //Set lại giỏ hàng thành rỗng
                            DefaultTableModel RecordTable = (DefaultTableModel)jTGioHang.getModel();
                            RecordTable.setRowCount(0);
                            giohang = new ArrayList<>();

                            //Sản phẩm trong giỏ hàng khi click vào cũng đc làm mới
                            giohangClicked = new SanPhamDTO();

                            //Reset tổng tiền
                            TongTien = 0;
                            jLTongTien.setText("0");
                            upDTB();
                        }
                                
                    }
                    
                    
                    if(HDflag){
                        new MyDialog("Thanh toán thành công. \nHóa đơn vừa tạo có MaHD là: " + hoadondangxuly, MyDialog.SUCCESS_DIALOG);
                    
                        //Set lại giỏ hàng thành rỗng
                        DefaultTableModel RecordTable = (DefaultTableModel)jTGioHang.getModel();
                        RecordTable.setRowCount(0);
                        giohang = new ArrayList<>();

                        //Sản phẩm trong giỏ hàng khi click vào cũng đc làm mới
                        giohangClicked = new SanPhamDTO();

                        //Reset tổng tiền
                        TongTien = 0;
                        jLTongTien.setText("0");
                        
                        prehoadon = hoadondangxuly;
                        //Load lại table
                        upDTB();
                    }
                }
                
            }
        }
        
    }//GEN-LAST:event_jBThanhToanActionPerformed

    private void jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxActionPerformed
        // TODO add your handling code here:
        timkiemType = (String) jComboBox.getSelectedItem();
    }//GEN-LAST:event_jComboBoxActionPerformed

    private void jTMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMaKHActionPerformed

    private void xuathoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuathoadonActionPerformed
        if (prehoadon == 0){
            new MyDialog("Chưa tạo hóa đơn nào để in hóa đơn.", MyDialog.ERROR_DIALOG);
        } else {
            Document document = new Document(PageSize.A4);
            String filename = "HD" + prehoadon;
            try{
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("reports/" + filename + ".pdf"));
                document.open();
                //Ghi file pdf
                
                //===========================================
                //= ĐỊNH DẠNG CÁC THUỘC TÍNH KHÔNG BẮT BUỘC =
                //===========================================
                
                document.addAuthor(String.valueOf(MyRole.manv));
                document.addCreationDate();
//                document.addCreator();
                document.addTitle("Hóa đơn mua hàng");
                document.addSubject("Hóa đơn khám bệnh");
                
                //===========================================
                //====== ĐỊNH DẠNG FONT CHỮ TRONG PDF =======
                //===========================================
                
                //Định dạng font tiếng việt, các font tiêu đề
                File filefontTieuDe = new File("fonts/vuArialBold.ttf");
                BaseFont bfTieuDe = 
                BaseFont.createFont(filefontTieuDe.getAbsolutePath(),
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                
                //font tiêu đề 1 in đậm size 16, màu blue
                Font fontTieuDe1 = new Font(bfTieuDe,16);
                fontTieuDe1.setColor(BaseColor.BLUE);
                
                //font tiêu đề 2 in đậm size 13, màu blue
                Font fontTieuDe2 = new Font(bfTieuDe,13);
                fontTieuDe2.setColor(BaseColor.BLUE);
                
                //font tiêu đề 3 in đậm size 13, màu đen
                Font fontTieuDe3 = new Font(bfTieuDe,13);
                
                //font tiêu đề 4 in đậm size 12, màu đen
                Font fontTieuDe4 = new Font(bfTieuDe,12);
                
                //Định dạng font unicode Tiếng Viết, các font nội dung
                File filefontNoiDung = new File("fonts/vuArial.ttf");
                BaseFont bfNoiDung = 
                BaseFont.createFont(filefontNoiDung.getAbsolutePath(),
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                
                //font nội dung 1 in thường, size 13, màu đen
                Font fontNoiDung1 = new Font(bfNoiDung,13);
                
                //font nội dung 2 in thường, size 13, màu đen
                Font fontNoiDung2 = new Font(bfNoiDung,12);
                
                //font nội dung 3 in thường, size 11, màu đen
                Font fontNoiDung3 = new Font(bfNoiDung,11);
                
                //===========================================
                //===== CHÈN ẢNH LOGO VÀ INFO CỬA HÀNG ======
                //===========================================
                Image logo = Image.getInstance("images/logoMenu.jpg"); 
                //Set vị trí từ góc dưới cùng bên trái 
                logo.setAbsolutePosition(80, 750);

                //Set kích thước height và width của ảnh 
                logo.scaleAbsolute(50, 50); 
                document.add(logo);
                Paragraph prgTenCH = new Paragraph("CỬA HÀNG ĐỒ ĂN NHANH 5 NGÔI SAO", fontTieuDe2);
                prgTenCH.setIndentationLeft(100); // set khoảng cách từ biên trái
                document.add(prgTenCH);
                
                // Chènn địa chỉ cửa hàng
                Paragraph prgDiaChiCH = new Paragraph("Địa chỉ: Thủ Đức, Việt Nam", fontNoiDung2); 
                prgDiaChiCH.setIndentationLeft(100); 
                document.add(prgDiaChiCH); 
                
                //Chèn số điện thoại 
                Paragraph prgSoDTCH = new Paragraph("Số Điện thoại: 0123456789", fontNoiDung2); 
                prgSoDTCH.setIndentationLeft(100); 
                document.add(prgSoDTCH);
                
                // Chèn Tiêu đề pdf 
                Paragraph prgTieuDe = new Paragraph("HÓA ĐƠN MUA HÀNG", fontTieuDe1); 
                prgTieuDe.setAlignment(Element.ALIGN_CENTER); // Canh giữa 
                prgTieuDe.setSpacingBefore(10); // Set khoảng cách phía trên 
                prgTieuDe.setSpacingAfter(10); // Set khoảng cách phía dưới 
                document.add(prgTieuDe);

//                String TenKhachHang = "";
//                String TenNhanVien = "";
                
                try {
                    MyConnect.connectToDatabase();
                    String strSQL = "Select * from HOADON, NHANVIEN, KHACHHANG WHERE HOADON.MANV = NHANVIEN.MANV AND HOADON.MAKH = KHACHHANG.MAKH AND MaHD = ?";
                    PreparedStatement pres = MyConnect.getConnection().prepareStatement(strSQL,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                    
                    pres.setInt(1, prehoadon);
                    ResultSet rs = pres.executeQuery();
                    if (rs.first()) {
                        // Chèn thông tin Khách hàng đang unordered List
                        List listTTKH = new List(List.UNORDERED);

                        // Họ tên BN
                        listTTKH.add(new ListItem("Họ tên khách hàng: "+ rs.getString(15).toUpperCase() + " " +
                        rs.getString(16).toUpperCase(), fontNoiDung1));

                        // Ma BN
                        listTTKH.add(new ListItem("Mã khách hàng: " +
                        rs.getInt(2), fontNoiDung1));
                        document.add(listTTKH);
                    }
                } catch (SQLException e){
                    System.out.println(e);
                    System.out.println("Error");
                } finally{
                    MyConnect.closeConnection();
                }
                
                //===========================================
                //=========== THÔNG TIN TIỀN TỆ =============
                //===========================================
                Paragraph prgCTHoaDon = new Paragraph ("Các sản phẩm đã mua", fontTieuDe3);
                prgCTHoaDon.setSpacingBefore(10);
                prgCTHoaDon.setSpacingBefore(10);
                document.add(prgCTHoaDon);
                
                //Định nghĩa số cột, chiều rộng bảng
                PdfPTable tableCTHoaDon = new PdfPTable(6); //6 cột
                tableCTHoaDon.setWidthPercentage(80);
                tableCTHoaDon.setSpacingBefore(10);
                tableCTHoaDon.setSpacingAfter(10);
                
                //Set Column widths
                float[] tableCTHoaDon_columnWidths = {50,120,150,100,80,100};
                tableCTHoaDon.setWidths(tableCTHoaDon_columnWidths);
                
                //Chèn tiêu đề 6 cột
                PdfPCell cellTDTT = new PdfPCell(new Paragraph("STT", fontTieuDe4));
                cellTDTT.setBorderColor(BaseColor.BLACK);
                cellTDTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDTT);
                
                PdfPCell cellTDMaSP = new PdfPCell(new Paragraph("Mã SP", fontTieuDe4));
                cellTDMaSP.setBorderColor(BaseColor.BLACK);
                cellTDMaSP.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDMaSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDMaSP);
                
                PdfPCell cellTDTenSP = new PdfPCell(new Paragraph("Tên SP", fontTieuDe4));
                cellTDTenSP.setBorderColor(BaseColor.BLACK);
                cellTDTenSP.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDTenSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDTenSP);
                
                PdfPCell cellTDSoLuong = new PdfPCell(new Paragraph("Số Lượng", fontTieuDe4));
                cellTDSoLuong.setBorderColor(BaseColor.BLACK);
                cellTDSoLuong.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDSoLuong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDSoLuong);
                
                PdfPCell cellTDDonGia = new PdfPCell(new Paragraph("Đơn Giá", fontTieuDe4));
                cellTDDonGia.setBorderColor(BaseColor.BLACK);
                cellTDDonGia.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDDonGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDDonGia);
                
                PdfPCell cellTDThanhTien = new PdfPCell(new Paragraph("Thành Tiền", fontTieuDe4));
                cellTDThanhTien.setBorderColor(BaseColor.BLACK);
                cellTDThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                cellTDThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                tableCTHoaDon.addCell(cellTDThanhTien);
                
                try {
                    MyConnect.connectToDatabase();
                    String strSQL = "Select * from CTHOADON, SANPHAM WHERE CTHOADON.MaSP = SANPHAM.MaSP and MaHD = ?";
                    PreparedStatement pres = MyConnect.getConnection().prepareStatement(strSQL);
                    pres.setString(1, String.valueOf(prehoadon));
                    ResultSet rs = pres.executeQuery();
                    int TongTienHoaDon  = 0;
                    int TT =1;
                    
                    while(rs.next()){
                        PdfPCell cellTT = new PdfPCell(new Paragraph(String.valueOf(TT), fontNoiDung3));
                        cellTT.setMinimumHeight(20);
                        cellTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellTT);


                        PdfPCell cellMaSP = new PdfPCell(new Paragraph(String.valueOf(rs.getInt(2)), fontNoiDung3));
                        cellMaSP.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellMaSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellMaSP);
                        
                        PdfPCell cellTenSP = new PdfPCell(new Paragraph(rs.getString(7), fontNoiDung3));
                        cellTenSP.setPaddingLeft(10);
                        cellTenSP.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        cellTenSP.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellTenSP);
                        
                        PdfPCell cellSL = new PdfPCell(new Paragraph(String.valueOf(rs.getInt(3)), fontNoiDung3));
                        cellSL.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellSL.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellSL);
                        
                        int DonGia = rs.getInt(4)
//                                *130/100
                                ;
                        PdfPCell cellDonGia = new PdfPCell(new Paragraph(DinhDangTienTe(DonGia), fontNoiDung3));
                        cellTenSP.setPaddingLeft(10);
                        cellDonGia.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellDonGia.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellDonGia);
                        
                        PdfPCell cellThanhTien = new PdfPCell(new Paragraph(DinhDangTienTe(rs.getInt((5))), fontNoiDung3));
                        cellThanhTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellThanhTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableCTHoaDon.addCell(cellThanhTien);
                        TongTienHoaDon = TongTienHoaDon + rs.getInt(5);
                        TT = TT+1;
                    }
                    
                    PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG: ", fontTieuDe4));
                    cellTongCong.setMinimumHeight(20);
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setColspan(5);
                    tableCTHoaDon.addCell(cellTongCong);

                    PdfPCell cellTongTien = new PdfPCell(new Paragraph(DinhDangTienTe(TongTienHoaDon), fontTieuDe4));
                    cellTongTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cellTongTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableCTHoaDon.addCell(cellTongTien);


                }
                catch (SQLException e){
                    System.out.println(e);
                    System.out.println("Error");
                } finally{
                    MyConnect.closeConnection();
                }
                document.add(tableCTHoaDon);
                document.close();
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            
            try{
                File file = new File("reports/" + filename + ".pdf");
                if(!Desktop.isDesktopSupported()) {
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if(file.exists()) desktop.open(file);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_xuathoadonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRefesh;
    private javax.swing.JButton jBThanhToan;
    private javax.swing.JButton jBThem;
    private javax.swing.JButton jBTimkiem;
    private javax.swing.JButton jBXoa;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLGioHang;
    private javax.swing.JLabel jLTongTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTGioHang;
    private javax.swing.JTextField jTMaKH;
    static javax.swing.JTable jTSanPham;
    private javax.swing.JTextField jTSoLuongDat;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JButton xuathoadon;
    // End of variables declaration//GEN-END:variables
}
