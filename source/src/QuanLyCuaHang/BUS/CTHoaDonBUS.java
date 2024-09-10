package QuanLyCuaHang.BUS;

import QuanLyCuaHang.DAO.CTHoaDonDAO;
import QuanLyCuaHang.DTO.CTHoaDonDTO;
import java.util.ArrayList;

public class CTHoaDonBUS {
    
    public ArrayList<CTHoaDonDTO> listCTHoaDon = new ArrayList<>();; //Danh sách CTHoaDon
    public CTHoaDonDAO cthdDAO = new CTHoaDonDAO(); //DAO để dùng hàm 
    public HoaDonBUS hdBUS = new HoaDonBUS(); 
    
    //Hàm lấy danh sách chi tiết hóa đơn
    public ArrayList<CTHoaDonDTO> getListCTHoaDon() {
        this.listCTHoaDon = cthdDAO.getListCTHoaDon();
        return listCTHoaDon;
    }
    
    //Hàm thêm chi tiết hóa đơn
    public boolean addCTHoaDon(int maHD, int maSP, int soLuong) {
        CTHoaDonDTO cthd = new CTHoaDonDTO();
        cthd.setMaHD(maHD);
        cthd.setMaSP(maSP);
        cthd.setSoLuong(soLuong);
        return cthdDAO.addCTHoaDon(cthd);
    }
    
    //Hàm xóa chi tiết hóa đơn
    public boolean deleteCTHoaDon(int maHD) {
        boolean flag;
        //Xóa khách hàng lưu trong cơ sở dữ liệu
        flag = cthdDAO.deleteCTHoaDon(maHD);
        //Kiểm tra cờ để xuất thông báo thích hợp
        return flag;
    }
    
//    public CTHoaDonDTO getCTHoaDonTheoMaHD(int maHD) {
//    	return ctHDDAO.getCTHoaDonTheoMaHD(maHD);
//    }
//    
//    public ArrayList<CTHoaDonDTO> getListCTHoaDonTheoMaHD(String maHD) {
//       int ma = Integer.parseInt(maHD);
//        ArrayList<CTHoaDonDTO> dsct = new ArrayList<>();
//
//       for (CTHoaDonDTO cthd : listCTHoaDon) {
//          if (cthd.getMaHD() == ma)
//               dsct.add(cthd);
//        }
//        return dsct;
//    }
    
}

