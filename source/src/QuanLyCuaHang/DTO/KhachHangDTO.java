package QuanLyCuaHang.DTO;

public class KhachHangDTO {
    public int MaKH;
    public String Ho;
    public String Ten;
    public String GioiTinh;
    public int TongChiTieu;

    public KhachHangDTO() {
        MaKH = 0;
        Ho = new String();
        Ten = new String();
        GioiTinh = new String();
        TongChiTieu = 0;
    }

    public KhachHangDTO(int maKH, String ho, String ten, String gioiTinh, int tongChiTieu) {
        this.MaKH = maKH;
        this.Ho = ho;
        this.Ten = ten;
        this.GioiTinh = gioiTinh;
        this.TongChiTieu = tongChiTieu;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        this.MaKH = maKH;
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

    public int getTongChiTieu() {
        return TongChiTieu;
    }

    public void setTongChiTieu(int tongChiTieu) {
        this.TongChiTieu = tongChiTieu;
    }


}
