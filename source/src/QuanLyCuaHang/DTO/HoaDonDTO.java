package QuanLyCuaHang.DTO;

import java.util.Date;

public class HoaDonDTO {
    public int MaHD;
    public int MaKH;
    public int MaNV;
    public Date NgayLap;
    public int TongTien;
    public String GhiChu;

    public HoaDonDTO() {
        MaHD = 0;
        MaKH = 0;
        MaNV = 0;
        NgayLap = new Date();
        TongTien = 0;
        GhiChu = new String();
    }

    public HoaDonDTO(int maHD, int maKH, int maNV, Date ngayLap, int tongTien, String ghiChu) {
        this.MaHD = maHD;
        this.MaKH = maKH;
        this.MaNV = maNV;
        this.NgayLap = ngayLap;
        this.TongTien = tongTien;
        this.GhiChu = ghiChu;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        this.MaHD = maHD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        this.MaKH = maKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        this.MaNV = maNV;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.NgayLap = ngayLap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        this.TongTien = tongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }
}
