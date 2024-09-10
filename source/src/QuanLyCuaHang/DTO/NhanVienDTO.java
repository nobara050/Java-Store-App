package QuanLyCuaHang.DTO;

import java.util.Date;

public class NhanVienDTO {

    public int MaNV;
    public String Ho;
    public String Ten;
    public String GioiTinh;
    public String ChucVu;
    public Date NgayBD;
    public Date NgaySinh;

    public NhanVienDTO() {
        MaNV = 0;
        Ho = new String();
        Ten = new String();
        GioiTinh = new String();
        ChucVu = new String();
        NgayBD = new Date();
        NgaySinh = new Date();
    }

    public NhanVienDTO(int maNV, String ho, String ten, String gioiTinh, String chucVu, Date NgayBD, Date NgaySinh) {
        this.MaNV = maNV;
        this.Ho = ho;
        this.Ten = ten;
        this.GioiTinh = gioiTinh;
        this.ChucVu = chucVu;
        this.NgayBD = NgayBD;
        this.NgaySinh = NgaySinh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        this.MaNV = maNV;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        this.Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        this.ChucVu = chucVu;
    }
    
    public Date getNgayBD() {
        return NgayBD;
    }
    
    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }
    
    public Date getNgaySinh() {
        return NgaySinh;
    }
    
    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

}
