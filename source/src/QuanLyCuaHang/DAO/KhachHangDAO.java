package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.KhachHangDTO;
import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO {
    //Hàm lấy một tất cả KhachHang
    public ArrayList<KhachHangDTO> getListKhachHang() {
        String sql = "SELECT * FROM khachhang";
        try {
            MyConnect.connectToDatabase();
            Statement stat = MyConnect.getConnection().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<KhachHangDTO> dskh = new ArrayList<>();
            while (rs.next()) {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getInt(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setGioiTinh(rs.getString(4));
                kh.setTongChiTieu(rs.getInt(5));
                dskh.add(kh);
            }
            return dskh;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return null;
    }
    
    //Hàm thêm KhachHang
    public boolean addKhachHang(KhachHangDTO kh) {
        boolean result;
        String sql = "INSERT INTO khachhang VALUES(?,?,?,?,?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, kh.getMaKH());
            prep.setString(2, kh.getHo());
            prep.setString(3, kh.getTen());
            prep.setString(4, kh.getGioiTinh());
            prep.setInt(5, kh.getTongChiTieu());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

    public boolean deleteKhachHang(int maKH) {
        boolean result;
        String sql = "Delete from khachhang WHERE MaKH=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, maKH);
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

    public boolean updateKhachHang(int maKH, KhachHangDTO kh) {
        boolean result;
        String sql = "UPDATE khachhang SET Ho=?, Ten=?, GioiTinh=? WHERE MaKH=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setString(1, kh.getHo());
            prep.setString(2, kh.getTen());
            prep.setString(3, kh.getGioiTinh());
            prep.setInt(4, maKH);
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

    public boolean updateTongChiTieu(int maKH, int tongChiTieu) {
        boolean result;
        String sql = "UPDATE khachhang SET TongChiTieu=" + tongChiTieu + " WHERE MaKH=" + maKH;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            result = stmt.executeUpdate(sql) > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
}
