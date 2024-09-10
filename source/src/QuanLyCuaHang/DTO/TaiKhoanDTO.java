package QuanLyCuaHang.DTO;

public class TaiKhoanDTO {

    public int MaNhanVien;
    public String TenDangNhap;
    public String MatKhau;
    public String Quyen;

    public TaiKhoanDTO() {
        MaNhanVien = 0;
        TenDangNhap = new String();
        MatKhau = new String();
        Quyen = new String();
    }

    public TaiKhoanDTO(int maNhanVien, String tenDangNhap, String matKhau, String quyen) {
        this.MaNhanVien = maNhanVien;
        this.TenDangNhap = tenDangNhap;
        this.MatKhau = matKhau;
        this.Quyen = quyen;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.MaNhanVien = maNhanVien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.TenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        this.MatKhau = matKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String quyen) {
        this.Quyen = quyen;
    }
}
