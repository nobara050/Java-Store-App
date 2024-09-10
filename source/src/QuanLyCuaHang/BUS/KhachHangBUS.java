package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.KhachHangDAO;
import QuanLyCuaHang.DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class KhachHangBUS {

    public ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();
    public KhachHangDAO khachhangDAO = new KhachHangDAO();
    
    public ArrayList<KhachHangDTO> getListKhachHang() {
        this.listKhachHang = khachhangDAO.getListKhachHang();
        return listKhachHang;
    }
    
    public KhachHangDTO getKhachHangTheoMaKH(String maKH) {
        int ma = Integer.parseInt(maKH);
        for (KhachHangDTO kh : listKhachHang) {
            if (kh.getMaKH() == ma)
                return kh;
        }
        return null;
    }
    
    public ArrayList<KhachHangDTO> searchKhachHang(String tuKhoa, String type) {
        tuKhoa = tuKhoa.trim().toLowerCase();
          ArrayList<KhachHangDTO> dskh = new ArrayList<>();
          switch (type) {
            case "Mã KH" -> {
                for (KhachHangDTO kh : listKhachHang) {
                    String makh =  Integer.toString(kh.getMaKH()).trim();
                    if (makh.contains(tuKhoa)){
                        dskh.add(kh);
                    }
                }
            }
            case "Họ tên" -> {
                for (KhachHangDTO kh : listKhachHang) {
                    String tenkh = kh.getHo().trim().toLowerCase() + " " + kh.getTen().trim().toLowerCase();
                    if(tenkh.contains(tuKhoa)){
                        dskh.add(kh);
                    }
                }
            }
            case "Giới tính" -> {
                for (KhachHangDTO kh : listKhachHang) {
                    String gioitinh = String.valueOf(kh.getGioiTinh()).trim().toLowerCase();
                    if (gioitinh.contains(tuKhoa)){
                        dskh.add(kh);
                    }
                }
            }
            }
        return dskh;
    }
    
    
    
    public boolean addKhachHang(String maKH, String ho, String ten, String gioitinh) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        if (!pattern.matcher(maKH).matches()) {
            new MyDialog("Hãy nhập số điện thoại hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        //Kiểm tra đã nhập tên chưa
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        //Tạo biến khách hàng để thêm
        KhachHangDTO kh = new KhachHangDTO(Integer.parseInt(maKH), ho, ten, gioitinh, 0);
        
        //Thêm và tạo cờ kiểm tra đã thêm thành công hay chưa
        boolean flag = khachhangDAO.addKhachHang(kh);
        
        //Kiểm tra cờ để xuất thông báo phù hợp
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    
    public boolean updateKhachHang(String makh, String ho, String ten, String gioiTinh) {   
        //Kiểm tra đã nhập tên chưa
        if (ten.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        //Tạo biến để lưu thông tin sửa
        KhachHangDTO kh = new KhachHangDTO();
        kh.setHo(ho);
        kh.setTen(ten);
        kh.setGioiTinh(gioiTinh);
        
        //Sửa khách hàng có mã khách hàng được nhập thành thông tin khách hàng lưu trong biến
        boolean flag = khachhangDAO.updateKhachHang(Integer.parseInt(makh), kh);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    
    public boolean deleteKhachHang(int maKH) {
        boolean flag;
        //Xóa khách hàng lưu trong cơ sở dữ liệu
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if(dlg.getAction() != MyDialog.OK_OPTION) return false;
        flag = khachhangDAO.deleteKhachHang(maKH);
        //Kiểm tra cờ để xuất thông báo thích hợp
        if (flag) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    
}
