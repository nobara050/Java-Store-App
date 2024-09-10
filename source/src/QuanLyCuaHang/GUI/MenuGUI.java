package QuanLyCuaHang.GUI;

import Main.MyDialog;
import QuanLyCuaHang.DTO.PhanQuyenDTO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
public class MenuGUI extends javax.swing.JFrame {
    public static PhanQuyenDTO privileges;
    Color DefaultColor, ClickedColor;
    public MenuGUI(PhanQuyenDTO privileges) {
        MenuGUI.privileges = privileges;
        initComponents();
        
        URL url_icon_plus = MenuGUI.class.getResource("/Image/logoMenu.jpg");
          Image img = Toolkit.getDefaultToolkit().createImage(url_icon_plus);
          this.setIconImage(img);
        
        DefaultColor = new Color(153,0,0);
        ClickedColor = new Color(0,102,0); //Màu khi click chuột vào menu
        
        //Set màu mặc định khi chưa click chuột vào menu
        jPanelDatMon.setBackground(ClickedColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        //Đặt jFrame vào giữa màn hình
        this.setLocationRelativeTo(null);
        
        
        DatDoAnGUI dmGUI = new DatDoAnGUI();
        jPanelBody.removeAll();
        jPanelBody.add(dmGUI).setVisible(true);
        applyPrivileges(this.privileges);
    }
    
    private void applyPrivileges(PhanQuyenDTO privileges) {
        jLabelNhapHang.setVisible(privileges.getNhapHang() == 1);
        jLabelNhaCungCap.setVisible(privileges.getNhapHang() == 1);
        jLabelKhachHang.setVisible(privileges.getQlKhachHang() == 1);
        jLabelNhanVien.setVisible(privileges.getQlNhanVien() == 1);
        jLabelSanPham.setVisible(privileges.getQlSanPham() == 1);
        jLabelThongKe.setVisible(privileges.getThongKe() == 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jPanelDatMon = new javax.swing.JPanel();
        jLabelDatMon = new javax.swing.JLabel();
        jPanelHoaDon = new javax.swing.JPanel();
        jLabelHoaDon = new javax.swing.JLabel();
        jPanelKhachHang = new javax.swing.JPanel();
        jLabelKhachHang = new javax.swing.JLabel();
        jPanelNhanVien = new javax.swing.JPanel();
        jLabelNhanVien = new javax.swing.JLabel();
        jPanelSanPham = new javax.swing.JPanel();
        jLabelSanPham = new javax.swing.JLabel();
        jPanelNhapHang = new javax.swing.JPanel();
        jLabelNhapHang = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jPanelNhaCungCap = new javax.swing.JPanel();
        jLabelNhaCungCap = new javax.swing.JLabel();
        jPanelThongKe = new javax.swing.JPanel();
        jLabelThongKe = new javax.swing.JLabel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelHeaderName = new javax.swing.JLabel();
        jPanelDangXuat = new javax.swing.JPanel();
        jLabelDangXuat = new javax.swing.JLabel();
        jPanelBody = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cửa hàng 5 Ngôi Sao");
        setBackground(new java.awt.Color(51, 51, 51));

        jPanelMenu.setBackground(new java.awt.Color(204, 0, 0));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanelDatMon.setBackground(new java.awt.Color(153, 0, 0));
        jPanelDatMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDatMonMouseClicked(evt);
            }
        });

        jLabelDatMon.setBackground(new java.awt.Color(153, 0, 0));
        jLabelDatMon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDatMon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDatMon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDatMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/datmon.png"))); // NOI18N
        jLabelDatMon.setText("Đặt món");
        jLabelDatMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDatMonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelDatMonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatMonLayout = new javax.swing.GroupLayout(jPanelDatMon);
        jPanelDatMon.setLayout(jPanelDatMonLayout);
        jPanelDatMonLayout.setHorizontalGroup(
            jPanelDatMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDatMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelDatMonLayout.setVerticalGroup(
            jPanelDatMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelHoaDon.setBackground(new java.awt.Color(153, 0, 0));

        jLabelHoaDon.setBackground(new java.awt.Color(153, 0, 0));
        jLabelHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon.png"))); // NOI18N
        jLabelHoaDon.setText("Hóa đơn");
        jLabelHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelHoaDonMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelKhachHang.setBackground(new java.awt.Color(153, 0, 0));
        jPanelKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelKhachHangMouseClicked(evt);
            }
        });

        jLabelKhachHang.setBackground(new java.awt.Color(153, 0, 0));
        jLabelKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/khachhang.png"))); // NOI18N
        jLabelKhachHang.setText("Khách hàng");
        jLabelKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelKhachHangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKhachHangLayout = new javax.swing.GroupLayout(jPanelKhachHang);
        jPanelKhachHang.setLayout(jPanelKhachHangLayout);
        jPanelKhachHangLayout.setHorizontalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelKhachHangLayout.setVerticalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelNhanVien.setBackground(new java.awt.Color(153, 0, 0));
        jPanelNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelNhanVienMouseClicked(evt);
            }
        });

        jLabelNhanVien.setBackground(new java.awt.Color(153, 0, 0));
        jLabelNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhanvien.png"))); // NOI18N
        jLabelNhanVien.setText("Nhân viên");
        jLabelNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelNhanVienMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNhanVienLayout = new javax.swing.GroupLayout(jPanelNhanVien);
        jPanelNhanVien.setLayout(jPanelNhanVienLayout);
        jPanelNhanVienLayout.setHorizontalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNhanVienLayout.setVerticalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelSanPham.setBackground(new java.awt.Color(153, 0, 0));

        jLabelSanPham.setBackground(new java.awt.Color(153, 0, 0));
        jLabelSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sanpham.png"))); // NOI18N
        jLabelSanPham.setText("Sản phẩm");
        jLabelSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSanPhamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelSanPhamMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelNhapHang.setBackground(new java.awt.Color(153, 0, 0));

        jLabelNhapHang.setBackground(new java.awt.Color(153, 0, 0));
        jLabelNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNhapHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhaphang.png"))); // NOI18N
        jLabelNhapHang.setText("Nhập hàng");
        jLabelNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNhapHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelNhapHangMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNhapHangLayout = new javax.swing.GroupLayout(jPanelNhapHang);
        jPanelNhapHang.setLayout(jPanelNhapHangLayout);
        jPanelNhapHangLayout.setHorizontalGroup(
            jPanelNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelNhapHangLayout.setVerticalGroup(
            jPanelNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N

        jPanelNhaCungCap.setBackground(new java.awt.Color(153, 0, 0));

        jLabelNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cungcap.png"))); // NOI18N
        jLabelNhaCungCap.setText("Nhà cung cấp");
        jLabelNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNhaCungCapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNhaCungCapLayout = new javax.swing.GroupLayout(jPanelNhaCungCap);
        jPanelNhaCungCap.setLayout(jPanelNhaCungCapLayout);
        jPanelNhaCungCapLayout.setHorizontalGroup(
            jPanelNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        jPanelNhaCungCapLayout.setVerticalGroup(
            jPanelNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanelThongKe.setBackground(new java.awt.Color(153, 0, 0));

        jLabelThongKe.setBackground(new java.awt.Color(153, 0, 0));
        jLabelThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jLabelThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thongke.png"))); // NOI18N
        jLabelThongKe.setText("Thống kê");
        jLabelThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThongKeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelThongKeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelThongKeLayout = new javax.swing.GroupLayout(jPanelThongKe);
        jPanelThongKe.setLayout(jPanelThongKeLayout);
        jPanelThongKeLayout.setHorizontalGroup(
            jPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelThongKeLayout.setVerticalGroup(
            jPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanelDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelHeader.setBackground(new java.awt.Color(51, 51, 51));
        jPanelHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabelHeaderName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelHeaderName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeaderName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeaderName.setText("             Chương Trình Quản Lý Cửa Hàng Thức Ăn Nhanh");

        jPanelDangXuat.setBackground(new java.awt.Color(0, 204, 0));
        jPanelDangXuat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelDangXuat.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDangXuat.setText("Đăng xuất");
        jLabelDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDangXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelDangXuatLayout = new javax.swing.GroupLayout(jPanelDangXuat);
        jPanelDangXuat.setLayout(jPanelDangXuatLayout);
        jPanelDangXuatLayout.setHorizontalGroup(
            jPanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );
        jPanelDangXuatLayout.setVerticalGroup(
            jPanelDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabelHeaderName, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHeaderName, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanelDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBody.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelBodyLayout = new javax.swing.GroupLayout(jPanelBody);
        jPanelBody.setLayout(jPanelBodyLayout);
        jPanelBodyLayout.setHorizontalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jPanelBodyLayout.setVerticalGroup(
            jPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDatMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDatMonMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(ClickedColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        DatDoAnGUI dmGUI = new DatDoAnGUI();
        jPanelBody.removeAll();
        jPanelBody.add(dmGUI).setVisible(true);
    }//GEN-LAST:event_jLabelDatMonMouseClicked

    private void jLabelHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHoaDonMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(ClickedColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        HoaDonGUI hdGUI = new HoaDonGUI();
        jPanelBody.removeAll();
        jPanelBody.add(hdGUI).setVisible(true);
    }//GEN-LAST:event_jLabelHoaDonMouseClicked

    private void jLabelKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhachHangMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(ClickedColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        KhachHangGUI khGUI = new KhachHangGUI();
        jPanelBody.removeAll();
        jPanelBody.add(khGUI).setVisible(true);
    }//GEN-LAST:event_jLabelKhachHangMouseClicked

    private void jLabelNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNhanVienMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(ClickedColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        NhanVienGUI nvGUI = new NhanVienGUI();
        jPanelBody.removeAll();
        jPanelBody.add(nvGUI).setVisible(true);
    }//GEN-LAST:event_jLabelNhanVienMouseClicked

    private void jLabelSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSanPhamMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(ClickedColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        SanPhamGUI spGUI = new SanPhamGUI();
        jPanelBody.removeAll();
        jPanelBody.add(spGUI).setVisible(true);
    }//GEN-LAST:event_jLabelSanPhamMouseClicked

    private void jLabelNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNhapHangMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(ClickedColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(DefaultColor);
        
        NhapHangGUI nhGUI = new NhapHangGUI();
        jPanelBody.removeAll();
        jPanelBody.add(nhGUI).setVisible(true);
    }//GEN-LAST:event_jLabelNhapHangMouseClicked

    private void jLabelDatMonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDatMonMousePressed
        
    }//GEN-LAST:event_jLabelDatMonMousePressed

    private void jLabelHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHoaDonMousePressed
        
    }//GEN-LAST:event_jLabelHoaDonMousePressed

    private void jLabelKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelKhachHangMousePressed
        
    }//GEN-LAST:event_jLabelKhachHangMousePressed

    private void jLabelNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNhanVienMousePressed
        
    }//GEN-LAST:event_jLabelNhanVienMousePressed

    private void jLabelSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSanPhamMousePressed
        
    }//GEN-LAST:event_jLabelSanPhamMousePressed

    private void jLabelNhapHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNhapHangMousePressed
        
    }//GEN-LAST:event_jLabelNhapHangMousePressed

    private void jLabelThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThongKeMousePressed
        
    }//GEN-LAST:event_jLabelThongKeMousePressed

    private void jPanelDatMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDatMonMouseClicked
       
    }//GEN-LAST:event_jPanelDatMonMouseClicked

    private void jPanelNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelNhanVienMouseClicked
        
    }//GEN-LAST:event_jPanelNhanVienMouseClicked

    private void jPanelKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelKhachHangMouseClicked
        
    }//GEN-LAST:event_jPanelKhachHangMouseClicked

    private void jLabelThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThongKeMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(DefaultColor);
        jPanelThongKe.setBackground(ClickedColor);
        
        ThongKeGUI tkGUI = new ThongKeGUI();
        jPanelBody.removeAll();
        jPanelBody.add(tkGUI).setVisible(true);
    }//GEN-LAST:event_jLabelThongKeMouseClicked

    private void jLabelDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDangXuatMouseClicked
        MyDialog dlg = new MyDialog("Bạn có muốn đăng xuất tài khoản?", MyDialog.WARNING_DIALOG);
        if(dlg.getAction() == MyDialog.OK_OPTION){
            this.dispose();
            new LoginFormGUI().setVisible(true);
        }
    }//GEN-LAST:event_jLabelDangXuatMouseClicked

    private void jLabelNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNhaCungCapMouseClicked
        //Đổi màu khi click chuột
        jPanelDatMon.setBackground(DefaultColor);
        jPanelHoaDon.setBackground(DefaultColor);
        jPanelKhachHang.setBackground(DefaultColor);
        jPanelNhanVien.setBackground(DefaultColor);
        jPanelSanPham.setBackground(DefaultColor);
        jPanelNhapHang.setBackground(DefaultColor);
        jPanelNhaCungCap.setBackground(ClickedColor);
        jPanelThongKe.setBackground(DefaultColor);
        NhaCungCapGUI nccGUI = new NhaCungCapGUI();
        jPanelBody.removeAll();
        jPanelBody.add(nccGUI).setVisible(true);
    }//GEN-LAST:event_jLabelNhaCungCapMouseClicked

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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI(privileges).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDangXuat;
    private javax.swing.JLabel jLabelDatMon;
    private javax.swing.JLabel jLabelHeaderName;
    private javax.swing.JLabel jLabelHoaDon;
    private javax.swing.JLabel jLabelKhachHang;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNhaCungCap;
    private javax.swing.JLabel jLabelNhanVien;
    private javax.swing.JLabel jLabelNhapHang;
    private javax.swing.JLabel jLabelSanPham;
    private javax.swing.JLabel jLabelThongKe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBody;
    private javax.swing.JPanel jPanelDangXuat;
    private javax.swing.JPanel jPanelDatMon;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelHoaDon;
    private javax.swing.JPanel jPanelKhachHang;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelNhaCungCap;
    private javax.swing.JPanel jPanelNhanVien;
    private javax.swing.JPanel jPanelNhapHang;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JPanel jPanelThongKe;
    // End of variables declaration//GEN-END:variables
}
