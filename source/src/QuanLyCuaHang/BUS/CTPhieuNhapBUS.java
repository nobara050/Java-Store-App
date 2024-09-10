package QuanLyCuaHang.BUS;

import QuanLyCuaHang.DAO.CTPhieuNhapDAO;
import QuanLyCuaHang.DTO.CTPhieuNhapDTO;
import java.util.ArrayList;

public class CTPhieuNhapBUS {

    private ArrayList<CTPhieuNhapDTO> listPhieuNhap = new ArrayList<>();;
    private CTPhieuNhapDAO ctpnDAO = new CTPhieuNhapDAO();

    
    public ArrayList<CTPhieuNhapDTO> getListPhieuNhap() {
        this.listPhieuNhap = ctpnDAO.getListCTPhieuNhap();
        return listPhieuNhap;
    }
    
    public ArrayList<CTPhieuNhapDTO> getListPhieuNhap(String maPN) {
        ArrayList<CTPhieuNhapDTO> dsct = new ArrayList<>();
        int ma = Integer.parseInt(maPN);
        for(CTPhieuNhapDTO ct: listPhieuNhap) {
            if(ct.getMaPN() == ma) {
                dsct.add(ct);
            }
        }
        return dsct;
    }
    
     public void addCTPhieuNhap(int maPN, int maSP, int soLuong) {
        CTPhieuNhapDTO cthd = new CTPhieuNhapDTO();
        cthd.setMaPN(maPN);
        cthd.setMaSP(maSP);
        cthd.setSoLuong(soLuong);
        ctpnDAO.addCTPhieuNhap(cthd);
    }

    public boolean addCTPhieuNhap(CTPhieuNhapDTO ctpn) {
        return ctpnDAO.addCTPhieuNhap(ctpn);
    }
}
