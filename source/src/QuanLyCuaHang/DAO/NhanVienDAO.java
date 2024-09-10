package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.NhanVienDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhanVienDAO {
    //Hàm lấy một tất cả NhanVien
    public ArrayList<NhanVienDTO> getListNhanVien() {
        String sql = "SELECT * FROM NhanVien";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVienDTO> dssv = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setChucVu(rs.getString(5));
                nv.setNgayBD(rs.getDate(6));
                nv.setNgaySinh(rs.getDate(7));
                dssv.add(nv);
            }
            return dssv;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return null;
    }
    
    //Hàm lấy NhanVien theo MaNV
    public NhanVienDTO getNhanVienTheoMaNV(int maNV) {
        NhanVienDTO nv = null;
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(0, maNV);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nv = new NhanVienDTO();
                nv.setMaNV(rs.getInt(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setChucVu(rs.getString(5));
                nv.setNgayBD(rs.getDate(6));
                nv.setNgaySinh(rs.getDate(7));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return nv;
    }
    
    //Hàm lấy mã nhân viên mới nhất, trả về 1 nếu thất bại
    public int getMaNVMoiNhat() {
        String sql = "SELECT MAX(MaNV) FROM nhanvien";
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return -1;
    }
    
    //Hàm thêm một nhân viên
    public boolean addNhanVien(NhanVienDTO nv) {
        boolean result;
        java.sql.Date sqlNgayBD = new java.sql.Date(nv.getNgayBD().getTime());
        java.sql.Date sqlNgaySinh = new java.sql.Date(nv.getNgaySinh().getTime());
        String sql = "INSERT INTO nhanvien(MaNV ,Ho, Ten, GioiTinh, ChucVu, NgayBD, NgaySinh) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHo());
            pre.setString(3, nv.getTen());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getChucVu());
            pre.setDate(6, sqlNgayBD);
            pre.setDate(7, sqlNgaySinh);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm sửa một nhân viên
    public boolean updateNhanVien(NhanVienDTO nv) {
        boolean result;
        String sql = "UPDATE nhanvien SET Ho=?, Ten=?, GioiTinh=?, ChucVu=? WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, nv.getHo());
            pre.setString(2, nv.getTen());
            pre.setString(3, nv.getGioiTinh());
            pre.setString(4, nv.getChucVu());
            pre.setInt(5, nv.getMaNV());
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

    //Hàm xóa một nhân viên
    public boolean deleteNhanVien(int maNV) {
        boolean result;
        String sql = "DELETE FROM nhanvien WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, maNV);
            result = pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

}