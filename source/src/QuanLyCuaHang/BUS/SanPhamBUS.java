package QuanLyCuaHang.BUS;

import Main.MyDialog;
import QuanLyCuaHang.DAO.SanPhamDAO;
import QuanLyCuaHang.DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {

    public ArrayList<SanPhamDTO> listSanPham = new ArrayList<>();;
    public SanPhamDAO spDAO = new SanPhamDAO();


    //Dùng để lấy sản phẩm trong DTB up lên Table trong GUI
    public ArrayList<SanPhamDTO> getListSanPham() {
        listSanPham = spDAO.getListSanPham();
        return listSanPham;
    }

//    //Lấy sản phẩm theo mã sản phẩm
//    public SanPhamDTO getSanPham(String ma) {
//        if (!ma.trim().equals("")) {
//            try {
//                int maSP = Integer.parseInt(ma);
//                for (SanPhamDTO sp : listSanPham) {
//                    if (sp.getMaSP() == maSP) {
//                        return sp;
//                    }
//                }
//            } catch (Exception e) {
//            }
//        }
//        return null;
//    }
//    
//    //Lấy các sản phẩm theo tên
//    public ArrayList<SanPhamDTO> getSanPhamTheoTen(String ten) {
//        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
//        for (SanPhamDTO sp : listSanPham) {
//            String tenSP = sp.getTenSP().toLowerCase();
//            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
//                dssp.add(sp);
//            }
//        }
//        return dssp;
//    }
//    
//    //Lấy các sản phẩm theo loại
//    public ArrayList<SanPhamDTO> getSanPhamTheoLoai(String ma) {
//        if (!ma.trim().equals("")) {
//            ArrayList<SanPhamDTO> dssp = new ArrayList<>();
//            try {
//                int maLoai = Integer.parseInt(ma);
//                for (SanPhamDTO sp : listSanPham) {
//                    if (sp.getMaLoai() == maLoai) {
//                        dssp.add(sp);
//                    }
//                }
//                return dssp;
//            } catch (Exception e) {
//            }
//        }
//        return null;
//    }
//    
//    //Lấy ra ảnh của sản phẩm theo mã, dùng để làm hình ảnh, chưa quan trọng sẽ bổ sung sau
//    public String getAnh(String ma) {
//        int maSP = Integer.parseInt(ma);
//        return spDAO.getAnh(maSP);
//    }
    
    
    public void incSoLuongSP(int ma, int soLuongMat) {
        spDAO.incSoLuongSP(ma, soLuongMat);
    }
    public void descSoLuongSP(int ma, int soLuongMat) {
        spDAO.descSoLuongSP(ma, soLuongMat);
    }
    
    //Tự động lấy mã sản phẩm là số lớn nhất trong kho cộng 1
    public int getMaSPMoiNhat(){
        return spDAO.getMaSPMoiNhat();
    }
    
    
    public boolean addSanPham(String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia) {
        
        
        if (ten.trim().equals("")) {
            new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
            return false;
        }

        if (donViTinh.trim().equals("")) {
            new MyDialog("Vui lòng điền Đơn vị tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        
        int result = spDAO.getMaSPMoiNhat();
        if (result == -1) {
            new MyDialog("Lấy mã thất bại!", MyDialog.ERROR_DIALOG);
            return false;
        }
        try {
            int soLuongSP = Integer.parseInt(soLuong);
            donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);
            if (loai.trim().equals("")) {
                new MyDialog("Vui lòng chọn Loại sản phẩm!", MyDialog.ERROR_DIALOG);
                return false;
            }
            SanPhamDTO sp = new SanPhamDTO(result+1,ten, loai, 0, donViTinh, "", donGiaSP);
            

            if (spDAO.addSanPham(sp)) {
                new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            new MyDialog("Nhập số hợp lệ cho Đơn giá hoặc Số lượng!", MyDialog.ERROR_DIALOG);
        }
        return false;
    }

//    public boolean nhapSanPhamTuExcel(String ten,
//            String loai,
//            String soLuong,
//            String donViTinh,
//            String anh,
//            String donGia) {
//
//        try {
//            String[] loaiTmp = loai.split(" - ");
//            int maLoai = Integer.parseInt(loaiTmp[0]);
//            int soLuongSP = Integer.parseInt(soLuong);
//            donGia = donGia.replace(",", "");
//            int donGiaSP = Integer.parseInt(donGia);
//
//            SanPhamDTO sp = new SanPhamDTO();
//            sp.setTenSP(ten);
//            sp.setMaLoai(maLoai);
//            sp.setSoLuong(soLuongSP);
//            sp.setDonViTinh(donViTinh);
//            sp.setHinhAnh(anh);
//            sp.setDonGia(donGiaSP);
//
//            spDAO.nhapSanPhamTuExcel(sp);
//        } catch (Exception e) {
//        }
//        return false;
//    }
    
    public boolean deleteSanPham(String ma) {
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if(dlg.getAction() != MyDialog.OK_OPTION) return false;
        
        int maSP = Integer.parseInt(ma);
        if (spDAO.deleteSanPham(maSP)) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
            return true;
        }
        new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
        return false;
    }

    public boolean updateSanPham(String ma,
            String ten,
            String loai,
            String soLuong,
            String donViTinh,
            String anh,
            String donGia) {

        try {
            if (ma.trim().equals("")) {
                new MyDialog("Chưa chọn sản phẩm để sửa!", MyDialog.ERROR_DIALOG);
                return false;
            }
            donGia = donGia.replace(",", "");
            int maSP = Integer.parseInt(ma);
            int soLuongSP = Integer.parseInt(soLuong);
            int donGiaSP = Integer.parseInt(donGia);

            if (ten.trim().equals("")) {
                new MyDialog("Tên SP không được để rỗng!", MyDialog.ERROR_DIALOG);
                return false;
            }

            SanPhamDTO sp = new SanPhamDTO();
            sp.setMaSP(maSP);
            sp.setTenSP(ten);
            sp.setLoai(loai);
            sp.setSoLuong(soLuongSP);
            sp.setDonViTinh(donViTinh);
            sp.setHinhAnh(anh);
            sp.setDonGia(donGiaSP);

            if (spDAO.updateSanPham(sp)) {
                new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
                return true;
            } else {
                new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
                return false;
            }
        } catch (Exception e) {
            new MyDialog("Nhập số hợp lệ cho Đơn giá và Số lượng!", MyDialog.ERROR_DIALOG);
        }
        return false;
    }
    
    
//    public String getTenSP(int maSP) {
//        for (SanPhamDTO sp : listSanPham) {
//            if (sp.getMaSP() == maSP) {
//                return sp.getTenSP();
//            }
//        }
//        return "";
//    }
      
    
    //Tìm kiếm các từ khóa khớp với từ cần tìm trong ô tìm kiếm sản phẩm
    public ArrayList<SanPhamDTO> searchSanPham(String tuKhoa, String type) {
        tuKhoa = tuKhoa.trim().toLowerCase();
        ArrayList<SanPhamDTO> dssp = new ArrayList<>();
            switch (type) {
                case "Mã SP" -> {
                    for (SanPhamDTO sp : listSanPham) {
                        String masp = Integer.toString(sp.getMaSP()).trim();
                        if (masp.contains(tuKhoa)){
                            dssp.add(sp);
                        }
                    }
                }
                case "Tên SP" -> {
                    for (SanPhamDTO sp : listSanPham) {
                        String tensp = sp.getTenSP().trim().toLowerCase();
                        if(tensp.contains(tuKhoa)){
                            dssp.add(sp);
                        }
                    }
                }
                case "Mã loại" -> {
                    for (SanPhamDTO sp : listSanPham) {
                        String loai = sp.getLoai().trim().toLowerCase();
                        if(loai.contains(tuKhoa)){
                            dssp.add(sp);
                        }
                    }
                }
            }
        return dssp;
    }
    
}
