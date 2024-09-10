package QuanLyCuaHang.BUS;

import QuanLyCuaHang.DAO.PhieuNhapDAO;
import QuanLyCuaHang.DTO.PhieuNhapDTO;
import java.util.ArrayList;

public class PhieuNhapBUS {

    public PhieuNhapDAO phieunhapDAO = new PhieuNhapDAO(); //DAO để dùng hàm
    public ArrayList<PhieuNhapDTO> listPhieuNhap = new ArrayList<>();; //Danh sách phiếu nhập để quản lý
    
    //Hàm lấy toàn bộ phiếu nhập
    public ArrayList<PhieuNhapDTO> getListPhieuNhap() {
        this.listPhieuNhap = phieunhapDAO.getListPhieuNhap();
        return this.listPhieuNhap;
    }
    
    //Hàm lấy phiếu nhập theo mã phiếu nhập
    public PhieuNhapDTO getPhieuNhapTheoMaPN(String maPN) {
        int ma = Integer.parseInt(maPN);
        for (PhieuNhapDTO pn : listPhieuNhap) {
            if (pn.getMaPN() == ma) {
                return pn;
            }
        }
        return null;
    }
    
    //Hàm lấy mã phiếu nhập mới nhất
    public int getMaPNMoiNhat() {
        return phieunhapDAO.getMaPNMoiNhat();
    }
    
    //Hàm thêm phiếu nhập
    public boolean addPhieuNhap(int maPN, int nhaCungCap,int nhanVien, int tongTien) {
        PhieuNhapDTO pn = new PhieuNhapDTO();
        pn.setMaPN(maPN);
        pn.setMaNCC(nhaCungCap);
        pn.setMaNV(nhanVien);
        pn.setTongTien(tongTien);
        return phieunhapDAO.addPhieuNhap(pn);
    }

//    public ArrayList<PhieuNhapDTO> getListPhieuNhapTheoGia(String giaThap, String giaCao) {
//        try {
//            int min = Integer.parseInt(giaThap);
//            int max = Integer.parseInt(giaCao);
//            if (max < min) {
//                new MyDialog("Hãy nhập khoảng giá phù hợp!", MyDialog.ERROR_DIALOG);
//                return null;
//            }
//            ArrayList<PhieuNhapDTO> result = new ArrayList<>();
//            for (PhieuNhapDTO pn : listPhieuNhap) {
//                if (pn.getTongTien() <= max && pn.getTongTien() >= min) {
//                    result.add(pn);
//                }
//            }
//            return result;
//        } catch (Exception e) {
//            new MyDialog("Hãy nhập số nguyên cho khoảng giá!", MyDialog.ERROR_DIALOG);
//        }
//        return null;
//    }
//
//    public ArrayList<PhieuNhapDTO> getListPhieuNhapTheoNgay(String tuNgay, String denNgay) {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
//            
//            Date min = sdf.parse(tuNgay);
//            Date max = sdf.parse(denNgay);
//            if (max.before(min)) {
//                new MyDialog("Hãy nhập khoảng ngày phù hợp!", MyDialog.ERROR_DIALOG);
//                return null;
//            }
//            ArrayList<PhieuNhapDTO> result = new ArrayList<>();
//            for (PhieuNhapDTO pn : listPhieuNhap) {
//                if (pn.getNgayLap().after(min) && pn.getNgayLap().before(max)) {
//                    result.add(pn);
//                }
//            }
//            return result;
//        } catch (Exception e) {
//            new MyDialog("Hãy nhập ngày hợp lệ (dd/MM/yyy)!", MyDialog.ERROR_DIALOG);
//        }
//        return null;
//    }
    
    //Hàm tìm kiếm phiếu nhập
    public ArrayList<PhieuNhapDTO> searchPhieuNhap(String tuKhoa, String type) {
        tuKhoa = tuKhoa.trim().toLowerCase();
          ArrayList<PhieuNhapDTO> dspn = new ArrayList<>();
          switch (type) {
            case "Mã PN":
                for (PhieuNhapDTO pn : listPhieuNhap) {
                    String mapn = Integer.toString(pn.getMaPN()).trim();
                    if (mapn.contains(tuKhoa)){
                         dspn.add(pn);
                    }
                }
                break;
            case "Mã NCC":
                for (PhieuNhapDTO pn : listPhieuNhap) {
                    String mapn = String.valueOf(pn.getMaNCC()).trim().toLowerCase();
                    if(mapn.contains(tuKhoa)){
                         dspn.add(pn);
                    }
                }
                break;
            case "Mã NV":
                for (PhieuNhapDTO pn : listPhieuNhap) {
                    String manv = String.valueOf(pn.getMaNV()).trim().toLowerCase();
                     if (manv.contains(tuKhoa)){
                         dspn.add(pn);
                     }
                }
                break;
            }
        return dspn;
    }
}
