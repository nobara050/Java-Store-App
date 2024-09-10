package QuanLyCuaHang.DTO;

public class CTHoaDonDTO {
    public int MaHD;
    public int MaSP;
    public int SoLuong;
    public int DonGia;
    public int ThanhTien;

    public CTHoaDonDTO() {
        MaHD = 0;
        MaSP = 0;
        SoLuong = 0;
        DonGia = 0;
        ThanhTien = 0;
    }

    public CTHoaDonDTO(int maHD, int maSP, int soLuong, int donGia, int thanhTien) {
        this.MaHD = maHD;
        this.MaSP = maSP;
        this.SoLuong = soLuong;
        this.DonGia = donGia;
        this.ThanhTien = thanhTien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int maHD) {
        this.MaHD = maHD;
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
