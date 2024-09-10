package QuanLyCuaHang.DTO;

public class PhanQuyenDTO {

    public String Quyen;
    public int NhapHang;
    public int qlSanPham;
    public int qlNhanVien;
    public int qlKhachHang;
    public int ThongKe;

    public PhanQuyenDTO() {
        Quyen = new String();
        NhapHang = 0;
        qlSanPham = 0;
        qlNhanVien = 0;
        qlKhachHang = 0;
        ThongKe = 0;
    }

    public PhanQuyenDTO(String quyen, int nhapHang, int qlSanPham, int qlNhanVien, int qlKhachHang, int thongKe) {
        this.Quyen = quyen;
        this.NhapHang = nhapHang;
        this.qlSanPham = qlSanPham;
        this.qlNhanVien = qlNhanVien;
        this.qlKhachHang = qlKhachHang;
        this.ThongKe = thongKe;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String quyen) {
        this.Quyen = quyen;
    }

    public int getNhapHang() {
        return NhapHang;
    }

    public void setNhapHang(int nhapHang) {
        this.NhapHang = nhapHang;
    }

    public int getQlSanPham() {
        return qlSanPham;
    }

    public void setQlSanPham(int qlSanPham) {
        this.qlSanPham = qlSanPham;
    }

    public int getQlNhanVien() {
        return qlNhanVien;
    }

    public void setQlNhanVien(int qlNhanVien) {
        this.qlNhanVien = qlNhanVien;
    }

    public int getQlKhachHang() {
        return qlKhachHang;
    }

    public void setQlKhachHang(int qlKhachHang) {
        this.qlKhachHang = qlKhachHang;
    }

    public int getThongKe() {
        return ThongKe;
    }

    public void setThongKe(int thongKe) {
        this.ThongKe = thongKe;
    }

}
