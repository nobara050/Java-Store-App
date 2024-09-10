package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.CTPhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;

public class CTPhieuNhapDAO {
    //Hàm lấy một tất cả CTPhieuNhap
    public ArrayList<CTPhieuNhapDTO> getListCTPhieuNhap() {
        ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
        String sql = "SELECT * FROM ctphieunhap";
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO();
                ctpn.setMaPN(rs.getInt(1));
                ctpn.setMaSP(rs.getInt(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setDonGia(rs.getInt(4));
                ctpn.setThanhTien(rs.getInt(5));
                dsctpn.add(ctpn);
            }
            
         } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dsctpn;
    }
    
    //Hàm lấy CTPhieuNhap theo MaPN
    public ArrayList<CTPhieuNhapDTO> getListCTPhieuNhapTheoMaPN(int maPN) {
        ArrayList<CTPhieuNhapDTO> dsctpn = new ArrayList<>();
        String sql = "SELECT * FROM ctphieunhap WHERE MaPN = " + maPN;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                CTPhieuNhapDTO ctpn = new CTPhieuNhapDTO();
                ctpn.setMaPN(rs.getInt(1));
                ctpn.setMaSP(rs.getInt(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setDonGia(rs.getInt(4));
                ctpn.setThanhTien(rs.getInt(5));
                dsctpn.add(ctpn);
            }
            
         } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dsctpn;
    }
    
    //Hàm thêm chi tiết phiếu nhập
    public boolean addCTPhieuNhap(CTPhieuNhapDTO ctpn) {
        boolean result;
        String sql = "{call ThemCTPN(?, ?, ?)}";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, ctpn.getMaPN());
            prep.setInt(2, ctpn.getMaSP());
            prep.setInt(3, ctpn.getSoLuong());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
        
//        boolean result;
//        String sql = "INSERT INTO ctphieunhap VALUES(?,?,?,?,?)";
//        try {
//            MyConnect.connectToDatabase();
//            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
//            prep.setInt(1, ctpn.getMaPN());
//            prep.setInt(2, ctpn.getMaSP());
//            prep.setInt(3, ctpn.getSoLuong());
//            prep.setInt(4, ctpn.getDonGia());
//            prep.setInt(5, ctpn.getThanhTien());
//            result = prep.executeUpdate() > 0;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return result;
    }
    
    //Hàm xóa chi tiết phiếu nhập
    public boolean deleteCTPhieuNhap(int maPN) {
        boolean result;
        String sql = "DELETE FROM ctphieunhap WHERE MaPN=" + maPN;
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


//    public boolean updateCTPhieuNhap(int maPN, CTPhieuNhapDTO ctpn) {
//        boolean result;
//        String sql = "UPDATE ctphieunhap SET MaPN = ?, MaSP = ?, SoLuong = ?, DonGia = ?, ThanhTien = ? WHERE MaPN = ?";
//        try {
//            MyConnect.connectToDatabase();
//            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
//            prep.setInt(1, ctpn.getMaPN());
//            prep.setInt(2, ctpn.getMaSP());
//            prep.setInt(3, ctpn.getSoLuong());
//            prep.setInt(4, ctpn.getDonGia());
//            prep.setInt(5, ctpn.getThanhTien());
//            prep.setInt(6, maPN);
//            result = prep.executeUpdate() > 0;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return result;
//    }
}
