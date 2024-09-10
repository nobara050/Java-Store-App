package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.NhanVienDAO;
import QuanLyCuaHang.DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class NhanVienBUS {
    public NhanVienDAO nhanvienDAO = new NhanVienDAO();
    public ArrayList<NhanVienDTO> listNhanVien = new ArrayList<>();

    public ArrayList<NhanVienDTO> getListNhanVien() {
        this.listNhanVien = nhanvienDAO.getListNhanVien();
        return this.listNhanVien;
    }
    

    public boolean addNhanVien(String maNV, String ho, String ten, String gioiTinh, String chucVu, Date NgayBD, Date NgaySinh) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        if (!pattern.matcher(maNV).matches()) {
            new MyDialog("Hãy nhập số điện thoại hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        int maNVint = Integer.parseInt(maNV);
        ho = ho.trim();
        ten = ten.trim();
        chucVu = chucVu.trim();
        if (ten.equals("")) {
            new MyDialog("Tên không được để trống!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (chucVu.equals("")) {
            new MyDialog("Chức vụ không được để trống!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        NhanVienDTO nv = new NhanVienDTO(maNVint,ho,ten,gioiTinh,chucVu,(Date) NgayBD, (Date)NgaySinh);
       
        boolean flag = nhanvienDAO.addNhanVien(nv);
        if (!flag) {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        } else {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        }
        return flag;
    }

    public boolean updateNhanVien(String ma, String ho, String ten, String gioiTinh, String chucVu) {
        int maNV = Integer.parseInt(ma);
        ho = ho.trim();
        ten = ten.trim();
        chucVu = chucVu.trim();
        if (ten.equals("")) {
            new MyDialog("Tên không được để trống!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (chucVu.equals("")) {
            new MyDialog("Chức vụ không được để trống!", MyDialog.ERROR_DIALOG);
            return false;
        }
        NhanVienDTO nv = new NhanVienDTO();
        nv.setMaNV(maNV);
        nv.setHo(ho);
        nv.setTen(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setChucVu(chucVu);
        boolean flag = nhanvienDAO.updateNhanVien(nv);
        if (!flag) {
            new MyDialog("Cập nhập thất bại!", MyDialog.ERROR_DIALOG);
        } else {
            new MyDialog("Cập nhập thành công!", MyDialog.SUCCESS_DIALOG);
        }
        return flag;
    }

    public ArrayList<NhanVienDTO> searchNhanVien(String tuKhoa, String type) {
        tuKhoa = tuKhoa.trim().toLowerCase();
          ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
          switch (type) {
            case "Mã NV" -> {
                for (NhanVienDTO nv : listNhanVien) {
                    String manv = Integer.toString(nv.getMaNV()).trim();
                    if (manv.contains(tuKhoa)){
                        dsnv.add(nv);
                    }
                }
             }
            case "Họ tên" -> {
                for (NhanVienDTO nv : listNhanVien) {
                    String tennv = nv.getHo().trim().toLowerCase() + " " + nv.getTen().trim().toLowerCase();
                    if(tennv.contains(tuKhoa)){
                        dsnv.add(nv);
                    }
                }
             }
            case "Giới tính" -> {
                for (NhanVienDTO nv : listNhanVien) {
                    String gioitinh = String.valueOf(nv.getGioiTinh()).trim().toLowerCase();
                    if (gioitinh.contains(tuKhoa)){
                        dsnv.add(nv);
                    }
                }
             }
            }
        return dsnv;
    }
    public boolean deleteNhanVien(String ma) {
        try {
            int maNV = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Toàn bộ thông tin nhân viên và dữ liệu liên quan sẽ bị xóa. Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            boolean flag = false;
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                flag = nhanvienDAO.deleteNhanVien(maNV);
                if (flag) {
                    new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
                } else {
                    new MyDialog("Xoá thất bại, thông tin nhân viên này đang được lưu để hỗ trợ các mục khác !", MyDialog.ERROR_DIALOG);
                }
            }
            return flag;
        } catch (Exception e) {
            new MyDialog("Chưa chọn nhân viên!", MyDialog.ERROR_DIALOG);
        }
        return false;
    }
    
}
