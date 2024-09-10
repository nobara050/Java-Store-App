package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.TaiKhoanDTO;
import java.sql.*;
import java.util.ArrayList;

public class TaiKhoanDAO {
    //Hàm lấy danh sách tài khoản theo mã nhân viên, do một người có thể có nhiều account
    public ArrayList<TaiKhoanDTO> getListTaiKhoanTheoMaNV(int MaNV) {
        ArrayList<TaiKhoanDTO> dsTaiKhoan = new ArrayList<>();
        String sql = "SELECT * FROM TaiKhoan WHERE MaNV=" + MaNV;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                taiKhoan.setMaNhanVien(rs.getInt("MaNV"));;
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setQuyen(rs.getString("Quyen"));
                dsTaiKhoan.add(taiKhoan);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dsTaiKhoan;
    }
    
    //Hàm lấy tên đăng nhập theo mã nhân viên
    public String getTenDangNhapTheoMaNV(int maNV) {
        String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE MaNV=" + maNV;
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return "";
    }
    
    //Hàm lấy quyền theo mã nhân viên
    public String getQuyenTheoMaNV(int maNV) {
        String sql = "SELECT Quyen FROM TaiKhoan WHERE MaNV=" + maNV;
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return "";
    }
    
    //Hàm kiểm tra tên đăng nhập có tồn tại chưa
    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = '" + tenDangNhap + "'";
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }

    //Hàm thêm tài khoản 
    public boolean addTaiKhoan(int maNV, String tenDangNhap, String matKhau,String quyen) {
        String sql = "INSERT INTO taikhoan(MaNV, TenDangNhap, MatKhau, Quyen) "
                    + "VALUES (?, ?, ?, ?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, maNV);
            pre.setString(2, tenDangNhap);
            pre.setString(3, matKhau);
            pre.setString(4, quyen);
            return pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
    //Hàm sửa mật khẩu
    public boolean updateMatKhau(int maNV, String matKhauMoi) {
        String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, matKhauMoi);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
    //Hàm sửa tên đăng nhập
    public boolean updateTenDangNhap(int maNV, String tenDangNhapMoi) {
        // Check if the new username already exists
        if (kiemTraTrungTenDangNhap(tenDangNhapMoi)) {
            return false;
        }
        String sql = "UPDATE TaiKhoan SET TenDangNhap=? WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, tenDangNhapMoi);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
    //Hàm sửa quyền
    public boolean updateQuyen(int maNV, String quyen) {
        String sql = "UPDATE TaiKhoan SET Quyen=? WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, quyen);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
    //Hàm xóa tài khoản
    public boolean deleteTaiKhoan(int maNV) {
        String sql = "DELETE FROM TaiKhoan WHERE MaNV=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, maNV);
            return pre.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
}
