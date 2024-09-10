package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.SanPhamDTO;
import java.sql.*;
import java.util.ArrayList;

public class SanPhamDAO {
    //Hàm lấy toàn bộ SanPham
    public ArrayList<SanPhamDTO> getListSanPham() {
        String sql = "SELECT * FROM SanPham";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            while (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setLoai(rs.getString(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));
                dssp.add(sp);
            }
            return dssp;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return null;
    }
    
    //Hàm lấy SanPham theo MaSP
    public SanPhamDTO getSanPhamTheoMaSP(int ma) {
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, ma);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                SanPhamDTO sp = new SanPhamDTO();

                sp.setMaSP(rs.getInt(1));
                sp.setTenSP(rs.getString(2));
                sp.setLoai(rs.getString(3));
                sp.setSoLuong(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setHinhAnh(rs.getString(6));
                sp.setDonGia(rs.getInt(7));

                return sp;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return null;
    }
    
    //Hàm lấy mã sản phẩm mới nhất
    public int getMaSPMoiNhat() {
        String sql = "SELECT MAX(MaSP) FROM sanpham";
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

//    public ArrayList<SanPhamDTO> getSanPhamTheoLoai(int Loai) {
//        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
//        String sql = "SELECT * FROM SanPham WHERE Loai=?";
//        try {
//            MyConnect.connectToDatabase();
//            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
//            pre.setInt(1, Loai);
//            ResultSet rs = pre.executeQuery();
//            
//            while (rs.next()) {
//                SanPhamDTO sp = new SanPhamDTO();
//                sp.setMaSP(rs.getInt(1));
//                sp.setTenSP(rs.getString(2));
//                sp.setLoai(rs.getString(3));
//                sp.setSoLuong(rs.getInt(4));
//                sp.setDonViTinh(rs.getString(5));
//                sp.setHinhAnh(rs.getString(6));
//                sp.setDonGia(rs.getInt(7));
//                dssp.add(sp);
//            }
//            return dssp;
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return null;
//    }

//    public String getAnh(int ma) {
//        String sql = "SELECT HinhAnh FROM SanPham WHERE MaSP=?";
//        try {
//            MyConnect.connectToDatabase();
//            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
//            pre.setInt(1, ma);
//            ResultSet rs = pre.executeQuery();
//            if (rs.next()) {
//                return rs.getString("HinhAnh");
//            }
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        } finally{
//            MyConnect.closeConnection();
//        }
//        return "";
//    }
    
    //Hàm tăng số lượng sản phẩm, dùng cho tiện hơn update toàn bộ thông tin
    public void incSoLuongSP(int ma, int soLuongTang) {
        SanPhamDTO sp = getSanPhamTheoMaSP(ma);
        int soLuong = sp.getSoLuong();
        sp.setSoLuong(soLuong + soLuongTang);
        String sql = "UPDATE SanPham SET SoLuong = ? WHERE MaSP = " + ma;
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, sp.getSoLuong());
            pre.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
    }
    
    //Hàm giảm số lượng sản phẩm, dùng cho tiện hơn update toàn bộ thông tin
    public void descSoLuongSP(int ma, int soLuongMat) {
        SanPhamDTO sp = getSanPhamTheoMaSP(ma);
        int soLuong = sp.getSoLuong();
        sp.setSoLuong(soLuong - soLuongMat);
        String sql = "UPDATE SanPham SET SoLuong = ? WHERE MaSP = " + ma;
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, sp.getSoLuong());
            pre.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
    }
    
    //Hàm thêm sản phẩm
    public boolean addSanPham(SanPhamDTO sp) {
        String sql = "INSERT INTO SanPham(MaSP, TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setInt(1, sp.getMaSP());
            pre.setString(2, sp.getTenSP());
            pre.setString(3, sp.getLoai());
            pre.setInt(4, 0);
            pre.setString(5, sp.getDonViTinh());
            pre.setString(6, "");
            pre.setInt(7, sp.getDonGia());
            pre.execute();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }

//    public boolean nhapSanPhamTuExcel(SanPhamDTO sp) {
//        try {
//            String sql = "DELETE * FROM SanPham; " +
//                    "INSERT INTO SanPham(TenSP, Loai, SoLuong, DonViTinh, HinhAnh, DonGia) "
//                    + "VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
//            pre.setString(1, sp.getTenSP());
//            pre.setInt(2, sp.getMaLoai());
//            pre.setInt(3, sp.getSoLuong());
//            pre.setString(4, sp.getDonViTinh());
//            pre.setString(5, sp.getHinhAnh());
//            pre.setInt(6, sp.getDonGia());
//
//            pre.execute();
//            return true;
//        } catch (SQLException e) {
//        }
//        return false;
//    }
    
    //Hàm xóa sản phẩm
    public boolean deleteSanPham(int maSP) {
        String sql = "DELETE FROM SanPham WHERE MaSP = " + maSP;
        try {
            MyConnect.connectToDatabase();
            Statement st = MyConnect.getConnection().createStatement();
            st.execute(sql);
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
    //Hàm sửa thông tin sản phẩm
    public boolean updateSanPham(SanPhamDTO sp) {
        String sql = "UPDATE SanPham SET "
                    + "TenSP=?, "
                    + "Loai=?, SoLuong=?, DonViTinh=?, HinhAnh=?, DonGia=? "
                    + "WHERE MaSP=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement pre = MyConnect.getConnection().prepareStatement(sql);
            pre.setString(1, sp.getTenSP());
            pre.setString(2, sp.getLoai());
            pre.setInt(3, sp.getSoLuong());
            pre.setString(4, sp.getDonViTinh());
            pre.setString(5, sp.getHinhAnh());
            pre.setInt(6, sp.getDonGia());
            pre.setInt(7, sp.getMaSP());

            pre.execute();
            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return false;
    }
    
}
