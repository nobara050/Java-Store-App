package QuanLyCuaHang.DAO;

import Main.MyConnect;
import QuanLyCuaHang.DTO.NhaCungCapDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhaCungCapDAO {
    //Hàm lấy một tất cả NhaCungCap
    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {
        ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
        String sql = "SELECT * FROM nhacungcap";
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setDienThoai(rs.getString(4));
                dsncc.add(ncc);
            }
            return dsncc;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            MyConnect.closeConnection();
        }
        return null;
    }
    
    //Hàm lấy NhaCungCap theo MaNCC
    public NhaCungCapDTO getNhaCungCapTheoMaNCC(int maNCC) {
        NhaCungCapDTO ncc = null;
        String sql = "SELECT * FROM nhacungcap WHERE MaNCC=" + maNCC;
        try {
            MyConnect.connectToDatabase();
            Statement stmt = MyConnect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getInt(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setDienThoai(rs.getString(4));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally{
            MyConnect.closeConnection();
        }
        return ncc;
    }
    
    //Hàm thêm nhà cung cấp
    public boolean addNhaCungCap(NhaCungCapDTO ncc) {
        boolean result;
        String sql = "INSERT INTO nhacungcap VALUES(?,?,?,?)";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setInt(1, ncc.getMaNCC());
            prep.setString(2, ncc.getTenNCC());
            prep.setString(3, ncc.getDiaChi());
            prep.setString(4, ncc.getDienThoai());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm sửa nhà cung cấp
    public boolean updateNhaCungCap(NhaCungCapDTO ncc) {
        boolean result;
        String sql = "UPDATE nhacungcap SET TenNCC=?, DiaChi=?, DienThoai=? WHERE MaNCC=?";
        try {
            MyConnect.connectToDatabase();
            PreparedStatement prep = MyConnect.getConnection().prepareStatement(sql);
            prep.setString(1, ncc.getTenNCC());
            prep.setString(2, ncc.getDiaChi());
            prep.setString(3, ncc.getDienThoai());
            prep.setInt(4, ncc.getMaNCC());
            result = prep.executeUpdate() > 0;
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally{
            MyConnect.closeConnection();
        }
        return result;
    }
    
    //Hàm xóa nhà cung cấp
    public boolean deleteNhaCungCap(int maNCC) {
        boolean result;
        String sql = "DELETE FROM nhacungcap WHERE MaNCC=" + maNCC;
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
