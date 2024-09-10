package QuanLyCuaHang.DTO;

public class SanPhamDTO {
    public int MaSP;
    public String TenSP;
    public String Loai;
    public int SoLuong;
    public String DonViTinh;
    public String HinhAnh;
    public int DonGia;

    public SanPhamDTO() {
        MaSP = 0;
        TenSP = new String();
        Loai = new String();
        SoLuong = 0;
        DonViTinh = new String();
        HinhAnh = new String();
        DonGia = 0;
    }

    public SanPhamDTO(int maSP, String tenSP, String Loai, int soLuong, String donViTinh, String hinhAnh, int donGia) {
        this.MaSP = maSP;
        this.TenSP = tenSP;
        this.Loai = Loai;
        this.SoLuong = soLuong;
        this.DonViTinh = donViTinh;
        this.HinhAnh = hinhAnh;
        this.DonGia = donGia;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int maSP) {
        this.MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        this.TenSP = tenSP;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.DonViTinh = donViTinh;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.HinhAnh = hinhAnh;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        this.DonGia = donGia;
    }
}
