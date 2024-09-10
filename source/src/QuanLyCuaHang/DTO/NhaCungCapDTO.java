package QuanLyCuaHang.DTO;

public class NhaCungCapDTO {
    public int MaNCC;
    public String TenNCC;
    public String DiaChi;
    public String DienThoai;

    public NhaCungCapDTO() {
        MaNCC = 0;
        TenNCC = new String();
        DiaChi = new String();
        DienThoai = new String();
    }

    public NhaCungCapDTO(int maNCC, String tenNCC, String diaChi, String dienThoai) {
        this.MaNCC = maNCC;
        this.TenNCC = tenNCC;
        this.DiaChi = diaChi;
        this.DienThoai = dienThoai;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int maNCC) {
        this.MaNCC = maNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.TenNCC = tenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        this.DiaChi = diaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.DienThoai = dienThoai;
    }
}
