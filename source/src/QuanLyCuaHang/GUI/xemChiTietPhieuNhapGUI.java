package QuanLyCuaHang.GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import QuanLyCuaHang.DAO.CTPhieuNhapDAO;
import QuanLyCuaHang.DTO.CTPhieuNhapDTO;

import java.awt.*;
import java.util.ArrayList;

public class xemChiTietPhieuNhapGUI extends JFrame {
    private JTable chiTietTable;
    private DefaultTableModel model;
    private CTPhieuNhapDAO ctPNDAO;

    public xemChiTietPhieuNhapGUI(int maPN) {
        setTitle("Chi Tiết Phiếu Nhập");
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
        model.addColumn("Mã phiếu nhập");
        model.addColumn("Mã sản phẩm");
        model.addColumn("Số lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành tiền");

        //Lấy danh sách chi tiết theo mã 
        ctPNDAO = new CTPhieuNhapDAO();
        ArrayList<CTPhieuNhapDTO> ctpnList = ctPNDAO.getListCTPhieuNhapTheoMaPN(maPN);
        if (ctpnList != null) {
            for (CTPhieuNhapDTO ctpn : ctpnList) {
                hienThiChiTietPhieuNhap(ctpn.getMaPN(), ctpn.getMaSP(), ctpn.getSoLuong(), ctpn.getDonGia(),
                        ctpn.getThanhTien());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy chi tiết phiếu nhập");
        }

        setVisible(true);
    }

    public void hienThiChiTietPhieuNhap(int maPN, int maSP, int soLuong, int donGia, int thanhTien) {
        //Thêm dòng vào table
        model.addRow(new Object[]{maPN, maSP, soLuong, donGia, thanhTien});
    }
}
