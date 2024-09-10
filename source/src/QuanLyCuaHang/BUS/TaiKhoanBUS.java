package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.TaiKhoanDAO;
import QuanLyCuaHang.DTO.CTHoaDonDTO;
import java.util.ArrayList;

public class TaiKhoanBUS {
    public ArrayList<CTHoaDonDTO> listTaiKhoan = new ArrayList<>();
    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    
    public boolean updateMatKhau(String ma, String matKhauMoi) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.updateMatKhau(maNV, matKhauMoi);
        if (flag) {
            new MyDialog("Cập nhật tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Cập nhật tài khoản thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

//
//    public void datLaiQuyen(String ma, String quyen) {
//        try {
//            int maNV = Integer.parseInt(ma);
//            boolean flag = taiKhoanDAO.datLaiQuyen(maNV, quyen);
//            if (flag) {
//                new MyDialog("Đặt lại thành công!", MyDialog.SUCCESS_DIALOG);
//            } else {
//                new MyDialog("Đặt lại thất bại!", MyDialog.ERROR_DIALOG);
//            }
//        } catch (NumberFormatException e) {
//            new MyDialog("Mã nhân viên không hợp lệ!", MyDialog.ERROR_DIALOG);
//        }
//    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public boolean addTaiKhoan(String ma, String tenDangNhap,String matKhau, String quyen) {
        try {
            int maNV = Integer.parseInt(ma);
            if (tenDangNhap.trim().isEmpty()) {
                new MyDialog("Không được để trống Tên đăng nhập!", MyDialog.ERROR_DIALOG);
                return false;
            }
            if (kiemTraTrungTenDangNhap(tenDangNhap)) {
                MyDialog dlg = new MyDialog("Tên đăng nhập bị trùng!", MyDialog.ERROR_DIALOG);
                return false;
            }
            boolean flag = taiKhoanDAO.addTaiKhoan(maNV, tenDangNhap,matKhau, quyen);
            if (flag) {
                new MyDialog("Cấp tài khoản thành công! Mật khẩu là " + matKhau, MyDialog.SUCCESS_DIALOG);
            } else {
                new MyDialog("Cấp tài khoản thất bại!", MyDialog.ERROR_DIALOG);
            }
            return flag;
        } catch (NumberFormatException e) {
            new MyDialog("Mã nhân viên không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
    }

    public void deleteTaiKhoan(String ma) {
        try {
            int maNV = Integer.parseInt(ma);
            boolean flag = taiKhoanDAO.deleteTaiKhoan(maNV);
            if (flag) {
                new MyDialog("Xoá tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
            } else {
                new MyDialog("Xoá tài khoản thất bại!", MyDialog.ERROR_DIALOG);
            }
        } catch (NumberFormatException e) {
            new MyDialog("Mã nhân viên không hợp lệ!", MyDialog.ERROR_DIALOG);
        }
    }

}
