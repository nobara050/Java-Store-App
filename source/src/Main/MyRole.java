package Main;

import QuanLyCuaHang.DTO.PhanQuyenDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRole {
    public String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    public String uname = "QLCH";
    public String upass = "QLCH";
    public static int manv;
    public PhanQuyenDTO loginrole(String role) {
        Connection conn2;
        PreparedStatement stmt;
        ResultSet rs;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn2 = DriverManager.getConnection(url, uname, upass);
            String sql = "SELECT * FROM PHANQUYEN WHERE QUYEN = ?";
            stmt = conn2.prepareStatement(sql);
            stmt.setString(1, role);
            rs = stmt.executeQuery();
            if (rs.next()) {
                PhanQuyenDTO phanQuyen = new PhanQuyenDTO();
                phanQuyen.setQuyen(rs.getString("QUYEN"));
                phanQuyen.setNhapHang(rs.getInt("NHAPHANG"));
                phanQuyen.setQlSanPham(rs.getInt("QLSANPHAM"));
                phanQuyen.setQlNhanVien(rs.getInt("QLNHANVIEN"));
                phanQuyen.setQlKhachHang(rs.getInt("QLKHACHHANG"));
                phanQuyen.setThongKe(rs.getInt("THONGKE"));
                return phanQuyen;
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // Close resources...
        }
    }


    public String login(String TenDangNhap, String MatKhau) {
        Connection conn3;
        PreparedStatement stmt;
        ResultSet rs;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn3 = DriverManager.getConnection(url, uname, upass);
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap = ? and MatKhau = ?";
            stmt = conn3.prepareStatement(sql);
            stmt.setString(1, TenDangNhap);
            stmt.setString(2, MatKhau);
            rs = stmt.executeQuery();
            if (rs.next()) {
                manv = rs.getInt("MaNV");
                return rs.getString("Quyen");
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
        }
    }
}