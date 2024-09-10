package QuanLyCuaHang.DTO;

import java.util.Date;

public class PhieuNhapDTO {

    public int MaPN;
    public int MaNCC;
    public int MaNV;
    public Date NgayLap;
    public int TongTien;

    public PhieuNhapDTO() {
        MaPN = 0;
        MaNCC = 0;
        MaNV = 0;
        NgayLap = new Date();
        TongTien = 0;
    }

    public PhieuNhapDTO(int maPN, int maNCC, int maNV, Date ngayLap, int tongTien) {
        this.MaPN = maPN;
        this.MaNCC = maNCC;
        this.MaNV = maNV;
        this.NgayLap = ngayLap;
        this.TongTien = tongTien;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int maPN) {
        this.MaPN = maPN;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int maNCC) {
        this.MaNCC = maNCC;
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

}
