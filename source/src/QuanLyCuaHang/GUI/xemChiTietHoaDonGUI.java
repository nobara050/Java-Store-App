package QuanLyCuaHang.GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import QuanLyCuaHang.DAO.CTHoaDonDAO;
import QuanLyCuaHang.DTO.CTHoaDonDTO;

import java.awt.*;
import java.util.ArrayList;

public class xemChiTietHoaDonGUI extends JFrame {
    private JTable chiTietTable;
    private DefaultTableModel model;
    private CTHoaDonDAO ctHDDAO;

    public xemChiTietHoaDonGUI(int maHD) {
        setTitle("Chi Tiết Hóa Đơn");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //Tạo bảng để hiển thị chi tiết hóa đơn
        model = new DefaultTableModel();
        chiTietTable = new JTable(model);
        chiTietTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(chiTietTable);
        add(scrollPane, BorderLayout.CENTER);
        //Tạo tiêu đề cho các cột
        model.addColumn("Mã hóa đơn");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành tiền");
        
        //Lấy danh sách chi tiết hóa đơn theo mã hóa đơn
        ctHDDAO = new CTHoaDonDAO();
        ArrayList<CTHoaDonDTO> cthdList = ctHDDAO.getListCTHoaDonTheoMaHD(maHD);
        if (cthdList != null) {
            for (CTHoaDonDTO cthd : cthdList) {
                hienThiChiTietHoaDon(cthd.getMaHD(), cthd.getMaSP(), cthd.getSoLuong(), cthd.getDonGia(),
                        cthd.getThanhTien());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết hóa đơn");
        }

        setVisible(true);
    }

    public void hienThiChiTietHoaDon(int maHD, int maSP, int soLuong, int donGia, int thanhTien) {
        //Thêm dòng vào table
        model.addRow(new Object[]{maHD, maSP, soLuong, donGia, thanhTien});
    }
}
