package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.CTHoaDonDAO;
import QuanLyCuaHang.DAO.HoaDonDAO;
import QuanLyCuaHang.DTO.HoaDonDTO;
import java.util.ArrayList;

public class HoaDonBUS {
    CTHoaDonDAO cthdDAO = new CTHoaDonDAO();
    public ArrayList <HoaDonDTO>  listHoaDon = new ArrayList<>(); //Danh sách hóa đơn
    public HoaDonDAO hoadonDAO = new HoaDonDAO(); //DAO để dùng hàm
    
    //Hàm lấy danh sách hóa đơn
    public ArrayList<HoaDonDTO> getListHoaDon() {
        listHoaDon = hoadonDAO.getListHoaDon();
        return listHoaDon;
    }
    public boolean Xoa_HOADON_CTHOADON(int maHD) {
        return cthdDAO.Xoa_HOADON_CTHOADON(maHD);
    }
    //Hàm lấy mã hóa đơn mới nhất
    public int getMaHoaDonMoiNhat() {
        return hoadonDAO.getMaHoaDonMoiNhat();
    }
    
    //Hàm thêm hóa đơn
    public void addHoaDon(int maHD, int maKH, int maNV, int tongTien, String ghiChu) {
        HoaDonDTO hd = new HoaDonDTO();
        hd.setMaHD(maHD);
        hd.setMaNV(maNV);
        hd.setMaKH(maKH);
        hd.setGhiChu(ghiChu);
        hd.setTongTien(tongTien);
        hoadonDAO.addHoaDon(hd);
    }

//    public HoaDonDTO getHoaDon(String maHD) {
//        int ma = Integer.parseInt(maHD);
//        for (HoaDonDTO hd : listHoaDon) {
//            if (hd.getMaHD() == ma)
//                return hd;
//        }
//        return null;
//    }
    
    //Hàm xóa hóa đơn
    public boolean deleteHoaDon(int maHD) {
        boolean flag;
        
        //Xóa khách hàng lưu trong cơ sở dữ liệu
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if(dlg.getAction() != MyDialog.OK_OPTION) return false;
        flag = hoadonDAO.deleteHoaDon(maHD);
        //Kiểm tra cờ để xuất thông báo thích hợp
        if (flag) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    //Hàm tiềm kiếm hóa đơn
    public ArrayList<HoaDonDTO> searchHoaDon(String tuKhoa, String type) {
        tuKhoa = tuKhoa.trim().toLowerCase();
          ArrayList<HoaDonDTO> dshd = new ArrayList<>();
          switch (type) {
            case "Mã HĐ" -> {
                for (HoaDonDTO hd : listHoaDon) {
                    String mahd = Integer.toString(hd.getMaHD()).trim();
                    if (mahd.contains(tuKhoa)){
                        dshd.add(hd);
                    }
                }
            }
            case "Mã NV" -> {
                for (HoaDonDTO hd : listHoaDon) {
                    String manv = Integer.toString(hd.getMaNV());
                    if(manv.contains(tuKhoa)){
                        dshd.add(hd);
                    }
                }
            }
            case "Mã KH" -> {
                for (HoaDonDTO hd : listHoaDon) {
                    String makh = Integer.toString(hd.getMaKH());
                    if (makh.contains(tuKhoa)){
                        dshd.add(hd);
                    }
                }
            }
            case "Ghi chú" -> {
                for (HoaDonDTO hd : listHoaDon) {
                    String ghichu = hd.getGhiChu().trim().toLowerCase();
                    if (ghichu.contains(tuKhoa)){
                        dshd.add(hd);
                    }
                }
            }
           }
        return dshd;
    }
    
    
//    public ArrayList<HoaDonDTO> getListHoaDonTheoGia(String min, String max) {
//        try {
//            int minPrice = Integer.parseInt(min);
//            int maxPrice = Integer.parseInt(max);
//            ArrayList<HoaDonDTO> dshd = new ArrayList<>();
//            for (HoaDonDTO hd : listHoaDon) {
//                if (hd.getTongTien() > minPrice && hd.getTongTien() < maxPrice)
//                    dshd.add(hd);
//            }
//            return dshd;
//        } catch (Exception e) {
//            new MyDialog("Hãy nhập khoảng giá hợp lệ", MyDialog.ERROR_DIALOG);
//        }
//        return null;
//    }
//
//    
//    public ArrayList<HoaDonDTO> getListHoaDonTheoNgay(String min, String max) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date minDate = sdf.parse(min);
//            Date maxDate = sdf.parse(max);
//
//            java.sql.Date dateMin = new java.sql.Date(minDate.getTime());
//            java.sql.Date dateMax = new java.sql.Date(maxDate.getTime());
//
//            ArrayList<HoaDonDTO> dshd = hoaDonDAO.getListHoaDon(dateMin, dateMax);
//            return dshd;
//        } catch (Exception e) {
//            new MyDialog("Hãy nhập khoảng ngày hợp lệ!", MyDialog.ERROR_DIALOG);
//        }
//        return null;
//    }
    
    public boolean updateHoaDonGhiChu(int mahd, String ghichu) {
        boolean flag = hoadonDAO.updateHoaDonGhiChu(mahd, ghichu);
        if (!flag) {
            new MyDialog("Cập nhập thất bại!", MyDialog.ERROR_DIALOG);
        } else {
            new MyDialog("Cập nhập thành công!", MyDialog.SUCCESS_DIALOG);
        }
        return flag;
    }
    
    
    public boolean deleteHoaDonNOSIGNAL(int maHD) {
        boolean flag;
        flag = hoadonDAO.deleteHoaDon(maHD);
        //Kiểm tra cờ để xuất thông báo thích hợp
        return flag;
    }
}
