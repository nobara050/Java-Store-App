package PieChartPackages;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;

import Main.MyConnect;

import java.awt.Color;
import java.text.NumberFormat;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.sql.*;

public class PieChartThongKeTopSanPham extends javax.swing.JFrame {

   
    public DefaultPieDataset pieDataset;
    public JFreeChart pieChart;
    public ChartPanel chartPanel;
    
    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JPanel pieChartPanel;
    public JLabel lblNewLabel_1;
    public JLabel lblNewLabel_2;
    public JComboBox<Object> comboBoxMonth;
    public JComboBox<String> comboBoxYear; 
    
    public PieChartThongKeTopSanPham() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 934, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250)); // Light blue background
        panel.setBounds(10, 10, 900, 463);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Biểu Đồ");
        lblNewLabel.setBounds(406, 10, 96, 32);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNewLabel.setForeground(new Color(25, 25, 112)); // Navy color for text
        panel.add(lblNewLabel);

        pieChartPanel = new JPanel();
        pieChartPanel.setBackground(new Color(255, 255, 255)); // White background for chart panel
        pieChartPanel.setBounds(10, 52, 880, 401);
        panel.add(pieChartPanel);
        pieChartPanel.setLayout(new BorderLayout(0, 0));

        comboBoxYear = new JComboBox<>();
        comboBoxYear.setBounds(662, 19, 76, 21);
        comboBoxYear.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(comboBoxYear);

        lblNewLabel_1 = new JLabel("Year");
        lblNewLabel_1.setBounds(615, 23, 37, 13);
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(25, 25, 112)); // Navy color for text
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Month");
        lblNewLabel_2.setBounds(757, 23, 53, 13);
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel_2.setForeground(new Color(25, 25, 112)); // Navy color for text
        panel.add(lblNewLabel_2);

        comboBoxMonth = new JComboBox<>();
        comboBoxMonth.setBounds(814, 19, 76, 21);
        comboBoxMonth.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(comboBoxMonth);
        
        // Initialize and display the pie chart
        showPieChart();
        
        // Load comboBox data
        loadComboBoxData();

        // Add action listeners
        comboBoxYear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBoxYear.getSelectedIndex() > 0) {
                    int selectedYear = Integer.valueOf(comboBoxYear.getSelectedItem().toString());
                    try {
                        comboBoxMonth.removeAllItems(); //Xóa item cũ trong comboBoxMonth	
                        showMonth(selectedYear);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        comboBoxMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBoxMonth.getSelectedIndex() > 0) {
                    int selectedYear = Integer.valueOf(comboBoxYear.getSelectedItem().toString());
                    int selectedMonth = comboBoxMonth.getSelectedIndex() + 1;
                    try {
                        updatePieChart(selectedYear, selectedMonth);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
    
    private void loadComboBoxData() {
        try {
            MyConnect.connectToDatabase();
            comboBoxYear.addItem(""); //Thêm item rỗng vào comboBoxYear
            showYear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void showYear() throws SQLException {
        PreparedStatement p = MyConnect.getConnection().prepareStatement(
                "SELECT DISTINCT EXTRACT(YEAR FROM NgayLap) AS Year FROM HOADON ORDER BY Year");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String year = r.getString("Year");
            comboBoxYear.addItem(year);
        }
        r.close();
        p.close();
    }
    
    private void showMonth(int year) throws SQLException {
        PreparedStatement p = MyConnect.getConnection().prepareStatement(
                "SELECT DISTINCT EXTRACT(MONTH FROM NgayLap) AS Month FROM HOADON WHERE EXTRACT(YEAR FROM NgayLap) = ? ORDER BY Month");
        p.setInt(1, year);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int month = r.getInt("Month");
            comboBoxMonth.addItem(String.valueOf(month));
        }
        r.close();
        p.close();
    }
    //Câu lệnh để lấy giá trị bên trong các bảng (sanpham,cthd,hoadon) được kết nhau
    private void updatePieChart(int year, int month) throws SQLException {
        pieDataset.clear();
        PreparedStatement p = MyConnect.getConnection().prepareStatement(
                "SELECT * FROM ( " +
            "  SELECT sp.tensp, SUM(cthd.SoLuong) AS totalSold " +
            "  FROM cthoadon cthd " +
            "  JOIN sanpham sp ON cthd.MaSP = sp.MaSP " +
            "  JOIN hoadon hd ON hd.MaHD = cthd.MaHD " +
            "  WHERE EXTRACT(YEAR FROM hd.NgayLap) = ? " +
            "  AND EXTRACT(MONTH FROM hd.NgayLap) = ? " +
            "  GROUP BY sp.tensp " +
            "  ORDER BY totalSold DESC " +
            ") WHERE ROWNUM <= 10");
        p.setInt(1, year);
        p.setInt(2, month);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String productName = r.getString("tensp");
            double totalAmount = r.getDouble("totalSold");
            pieDataset.setValue(productName, totalAmount);
        }
        r.close();
        p.close();

        pieChartPanel.repaint();
    }

    private void showPieChart() {
        pieDataset = new DefaultPieDataset();
        pieDataset.setValue("No Data", 100); // giá trị mặc định khi chưa có dữ liệu

        pieChart = ChartFactory.createPieChart3D("Thống kê 10 sản phẩm bán chạy nhất của từng tháng theo năm", pieDataset, true, true, false);
        pieChart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 20));
        PiePlot piePlot = (PiePlot) pieChart.getPlot();
        chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(new Color(255, 255, 255));
        chartPanel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // Change PieChart background
        piePlot.setBackgroundPaint(new Color(240, 248, 255)); // AliceBlue background

        // Set label generator to show percentage
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})", 
        					NumberFormat.getInstance(), 
                            NumberFormat.getPercentInstance()));

        pieChartPanel.removeAll();
        pieChartPanel.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setLayout(null);
        pieChartPanel.validate();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PieChartThongKeTopSanPham frame = new PieChartThongKeTopSanPham();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  

    // Variables declaration - do not modify                     
    // End of variables declaration                   


    /**
     * Creates new form PieChartThongKeTopSanPham
     */
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}