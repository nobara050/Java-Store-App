package QuanLyCuaHang.DTO;

public class CTPhieuNhapDTO {
    public int MaPN;
    public int MaSP;
    public int SoLuong;
    public int DonGia;
    public int ThanhTien;

    public CTPhieuNhapDTO() {
        MaPN = 0;
        MaSP = 0;
        SoLuong = 0;
        DonGia = 0;
        ThanhTien = 0;
    }

    public CTPhieuNhapDTO(int maPN, int maSP, int soLuong, int donGia, int thanhTien) {
        this.MaPN = maPN;
        this.MaSP = maSP;
        this.SoLuong = soLuong;
        this.DonGia = donGia;
        this.ThanhTien = thanhTien;
    }

    public int getMaPN() {
        return MaPN;
    }

    public void setMaPN(int maPN) {
        this.MaPN = maPN;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        this.MaSP = maSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        this.DonGia = donGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.ThanhTien = thanhTien;
    }
}
