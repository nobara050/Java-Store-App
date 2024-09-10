package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.HoaDonDTO;
import java.sql.*;
import java.util.ArrayList;

public class HoaDonDAO {
    //Hàm lấy một tất cả HoaDon
    public ArrayList<HoaDonDTO> getListHoaDon() {
        ArrayList<HoaDonDTO> dshd = new ArrayList<>();
        String sql = "SELECT * FROM hoadon";
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getInt(1));
                hd.setMaKH(rs.getInt(2));
                hd.setMaNV(rs.getInt(3));
                hd.setNgayLap(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setGhiChu(rs.getString(6));
                dshd.add(hd);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return dshd;
    }
    
    //Hàm lấy mã hóa đơn mới nhất, trả về -1 nếu không thành công
    public int getMaHoaDonMoiNhat() {
        String sql = "SELECT MAX(maHD) FROM hoadon";
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next())
                return rs.getInt(1);
        } catch(SQLException ex) {
            ex.printStackTrace();
            return -1;
        } finally{
            MyConnect.closeConnection();
        }
        return -1;
    }
    
    //Hàm thêm hóa đơn, khi thêm sẽ đồng thời cập nhật lại tổng tiền của khách hàng
    public boolean addHoaDon(HoaDonDTO hd) {
        boolean result;
        String sql = "INSERT INTO hoadon(MaHD, MaKH, MaNV, NgayLap, TongTien, GhiChu) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, hd.getMaHD());
            prep.setInt(2, hd.getMaKH());
            prep.setInt(3, hd.getMaNV());
            prep.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
            prep.setInt(5, hd.getTongTien());
            prep.setString(6, hd.getGhiChu());
            result = prep.executeUpdate() > 0;

        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm xóa một hóa đơn
    public boolean deleteHoaDon(int maHD) {
        boolean result;
        String sql = "Delete from HOADON WHERE maHD=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, maHD);
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    

//    //Hàm lấy danh sách HoaDon theo ngày
//    public ArrayList<HoaDonDTO> getListHoaDon(Date dateMin, Date dateMax) {
//        String sql = "SELECT * FROM hoadon WHERE NgayLap BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";
//        try {
//            MyConnect.connectToDatabase();
//            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
//            pre.setDate(1, dateMin);
//            pre.setDate(2, dateMax);
//            ResultSet rs = pre.executeQuery();
//
//            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
//
//            while (rs.next()) {
//                HoaDonDTO hd = new HoaDonDTO();
//                hd.setMaHD(rs.getInt(1));
//                hd.setMaKH(rs.getInt(2));
//                hd.setMaNV(rs.getInt(3));
//                hd.setNgayLap(rs.getDate(4));
//                hd.setTongTien(rs.getInt(5));
//                hd.setGhiChu(rs.getString(6));
//                dshd.add(hd);
//            }
//            return dshd;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return null;
//    }
    
    public boolean updateHoaDonGhiChu(int mahd, String ghichu) {
        boolean result;
        String sql = "UPDATE hoadon SET GhiChu = ? WHERE MaHD=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, ghichu);
            pre.setInt(2, mahd);
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
