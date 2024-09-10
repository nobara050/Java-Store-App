package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.CTHoaDonDTO;
import java.sql.*;
import java.util.ArrayList;

public class CTHoaDonDAO {
    //Hàm lấy một tất cả CTHoaDon 
    public ArrayList<CTHoaDonDTO> getListCTHoaDon() {
        ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
        String sql = "SELECT * FROM cthoadon";
        
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                CTHoaDonDTO cthd = new CTHoaDonDTO();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                cthd.setThanhTien(rs.getInt(5));
                dscthd.add(cthd);
            }
            
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        
        return dscthd;
    }
    
    //Hàm lấy CTHoaDon theo MaHD
    public ArrayList<CTHoaDonDTO> getListCTHoaDonTheoMaHD(int maHD) {
        ArrayList<CTHoaDonDTO> dscthd = new ArrayList<>();
        String sql = "SELECT * FROM cthoadon WHERE MaHD = " + maHD;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                CTHoaDonDTO cthd = new CTHoaDonDTO();
                cthd.setMaHD(rs.getInt(1));
                cthd.setMaSP(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getInt(4));
                cthd.setThanhTien(rs.getInt(5));
                dscthd.add(cthd);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dscthd;
    }
    
    //Hàm thêm hóa đơn
    public boolean addCTHoaDon(CTHoaDonDTO cthd) {

//        boolean result;
//        try {
//            String sql = "INSERT INTO cthoadon VALUES(?,?,?,?,?)";
//            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
//            prep.setInt(1, cthd.getMaHD());
//            prep.setInt(2, cthd.getMaSP());
//            prep.setInt(3, cthd.getSoLuong());
//            prep.setInt(4, cthd.getDonGia());
//            prep.setInt(5, cthd.getThanhTien());
//            result = prep.executeUpdate() > 0;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return result;

        boolean result;
        CallableStatement callableStatement;
        String sql = "{call ThemCTHOADON(?, ?, ?)}";
        try {
            MyConnect.connectToDatabase();
            callableStatement = MyConnect.getConnection().prepareCall(sql);
            callableStatement.setInt(1, cthd.getMaHD());
            callableStatement.setInt(2, cthd.getMaSP());
            callableStatement.setInt(3, cthd.getSoLuong());
            result = callableStatement.executeUpdate() > 0;

        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm xóa hóa đơn
    public boolean deleteCTHoaDon(int maHD) {
        boolean result;
        String sql = "DELETE FROM cthoadon WHERE MaHD = " + maHD;
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
    

//    public boolean updateCTHoaDon(int maHD, int maSP, CTHoaDonDTO cthd) {
//        boolean result = false;
//        try {
//            String sql = "UPDATE cthoadon SET MaHD=?, MaSP=?, SoLuong=?, DonGia=? ThanhTien=? "
//                    + "WHERE MaHD=? AND MaSP=?";
//            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
//            prep.setInt(1, cthd.getMaHD());
//            prep.setInt(2, cthd.getMaSP());
//            prep.setInt(3, cthd.getSoLuong());
//            prep.setInt(4, cthd.getDonGia());
//            prep.setInt(5, cthd.getThanhTien());
//            prep.setInt(6, maHD);
//            prep.setInt(7, maSP);
//            result = prep.executeUpdate() > 0;
//        } catch(SQLException ex) {
//            return false;
//        }
//        return result;
//    }
    
    
     public boolean Xoa_HOADON_CTHOADON(int maHD) {
        boolean result;
        String sql = "{call Xoa_HOADON_CTHOADON(?)}";
        CallableStatement callableStatement;
        try {
            MyConnect.connectToDatabase();
            callableStatement = MyConnect.getConnection().prepareCall(sql);
            callableStatement.setInt(1, maHD);
            result = callableStatement.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
}
