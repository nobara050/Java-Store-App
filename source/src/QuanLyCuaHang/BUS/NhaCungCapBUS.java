package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.NhaCungCapDAO;
import QuanLyCuaHang.DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class NhaCungCapBUS {
    public NhaCungCapDAO nhacungcapDAO = new NhaCungCapDAO();
    public ArrayList<NhaCungCapDTO> listNhaCungCap = new ArrayList<>();;


    public ArrayList<NhaCungCapDTO> getListNhaCungCap() {
        this.listNhaCungCap = nhacungcapDAO.getListNhaCungCap();
        return this.listNhaCungCap;
    }

    public boolean addNhaCungCap(String tenNCC, String diaChi, String dienThoai) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        if (!pattern.matcher(dienThoai).matches()) {
            new MyDialog("Hãy nhập số điện thoại hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        if (tenNCC.trim().equals("")) {
            new MyDialog("Hãy nhập tên Nhà cung cấp này!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (diaChi.trim().equals("")) {
            new MyDialog("Hãy nhập địa chỉ!", MyDialog.ERROR_DIALOG);
            return false;
        }

        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setMaNCC(Integer.parseInt(dienThoai));
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setDienThoai(dienThoai);
        boolean flag = nhacungcapDAO.addNhaCungCap(ncc);
        if (flag) {
            new MyDialog("Thêm mới thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm mới thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean updateNhaCungCap(String maNCC, String tenNCC, String diaChi, String dienThoai) {
        //Kiểm tra đã nhập tên chưa
        if (dienThoai.trim().equals("")) {
            new MyDialog("Không được để trống số điện thoại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        //Kiểm tra đã nhập tên chưa
        if (tenNCC.trim().equals("")) {
            new MyDialog("Hãy nhập tên Nhà cung cấp này!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (diaChi.trim().equals("")) {
            new MyDialog("Hãy nhập địa chỉ!", MyDialog.ERROR_DIALOG);
            return false;
        }

        NhaCungCapDTO ncc = new NhaCungCapDTO();
        ncc.setMaNCC(Integer.parseInt(maNCC));
        ncc.setTenNCC(tenNCC);
        ncc.setDiaChi(diaChi);
        ncc.setDienThoai(dienThoai);
        
        boolean flag = nhacungcapDAO.updateNhaCungCap(ncc);

        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
    public ArrayList<NhaCungCapDTO> searchNhaCungCap(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<NhaCungCapDTO> dskh = new ArrayList<>();
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String mancc = Integer.toString(ncc.getMaNCC());
            String ten = ncc.getTenNCC().toLowerCase();
            String diachi = ncc.getDiaChi().toLowerCase();
            String dienthoai = ncc.getDienThoai().toLowerCase();
            if (mancc.contains(tuKhoa) || ten.contains(tuKhoa) || diachi.contains(tuKhoa) || dienthoai.contains(tuKhoa)) {
                dskh.add(ncc);
            }
        }
        return dskh;
    }
    
    public NhaCungCapDTO getNCCTheoTen(String ten) {
        for (NhaCungCapDTO ncc : listNhaCungCap) {
            String tenNCC = ncc.getTenNCC().toLowerCase();
            if (tenNCC.toLowerCase().contains(ten.toLowerCase())) {
                return ncc;
            }
        }
        return null;
    }
}
