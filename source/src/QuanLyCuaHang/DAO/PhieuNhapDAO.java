package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.PhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;

public class PhieuNhapDAO {
    //Hàm lấy toàn bộ PhieuNhap
    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
        String sql = "SELECT * FROM phieunhap";
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PhieuNhapDTO pn = new PhieuNhapDTO();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(3));
                pn.setNgayLap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
                dspn.add(pn);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dspn;
    }
    
    //Hàm lấy PhieuNhap theo MaPN
    public PhieuNhapDTO getPhieuNhapTheoMaPN(int maPN) {
        PhieuNhapDTO pn = null;
        String sql = "SELECT * FROM phieunhap WHERE MaPN=" + maPN;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pn = new PhieuNhapDTO();
                pn.setMaPN(rs.getInt(1));
                pn.setMaNCC(rs.getInt(2));
                pn.setMaNV(rs.getInt(3));
                pn.setNgayLap(rs.getDate(4));
                pn.setTongTien(rs.getInt(5));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
       return pn;
    }
    
     //Hàm lấy mã phiếu nhập mới nhất
    public int getMaPNMoiNhat() {
        String sql = "SELECT MAX(maPN) FROM phieunhap";
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
    
    //Hàm thêm phiếu nhập
    public boolean addPhieuNhap(PhieuNhapDTO pn) {
        boolean result;
        String sql = "INSERT INTO phieunhap(MaPN, MaNCC, MaNV, NgayLap, TongTien) VALUES(?,?,?,?,?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, pn.getMaPN());
            prep.setInt(2, pn.getMaNCC());
            prep.setInt(3, pn.getMaNV());
            prep.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime())); //lấy thời gian hiện tại
            prep.setInt(5, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm xóa phiếu nhập
    public boolean deletePhieuNhap(int maPN) {
        boolean result;
        String sql = "DELETE FROM phieunhap WHERE MaPN=" + maPN;
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
    
    //Hàm sửa phiếu nhập
    public boolean updatePhieuNhap(int maPN, PhieuNhapDTO pn) {
        boolean result;
        String sql = "UPDATE phieunhap SET MaPN=?, MaNCC=?, MaNV=?, NgayLap=?, TongTien=? WHERE MaPN=" + maPN;
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, pn.getMaPN());
            prep.setInt(2, pn.getMaNCC());
            prep.setInt(3, pn.getMaNV());
            prep.setDate(4, new java.sql.Date(pn.getNgayLap().getTime()));
            prep.setInt(5, pn.getTongTien());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }

}
