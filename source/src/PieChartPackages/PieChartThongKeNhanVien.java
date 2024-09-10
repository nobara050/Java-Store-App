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

public class PieChartThongKeNhanVien extends javax.swing.JFrame {

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
    
    public PieChartThongKeNhanVien() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 934, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 250));
        panel.setBounds(10, 10, 900, 463);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Biểu Đồ");
        lblNewLabel.setBounds(406, 10, 96, 32);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNewLabel.setForeground(new Color(25, 25, 112));
        panel.add(lblNewLabel);

        pieChartPanel = new JPanel();
        pieChartPanel.setBackground(new Color(255, 255, 255));
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
        lblNewLabel_1.setForeground(new Color(25, 25, 112));
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Month");
        lblNewLabel_2.setBounds(757, 23, 53, 13);
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel_2.setForeground(new Color(25, 25, 112));
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
                        comboBoxMonth.removeAllItems();
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
            comboBoxYear.addItem("");
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

    private void updatePieChart(int year, int month) throws SQLException {
        pieDataset.clear();
        PreparedStatement p = MyConnect.getConnection().prepareStatement(
                "SELECT * FROM ( " +
                "  SELECT nv.Ten, COUNT(hd.MaHD) AS totalInvoices " +
                "  FROM hoadon hd " +
                "  JOIN nhanvien nv ON hd.MaNV = nv.MaNV " +
                "  WHERE EXTRACT(YEAR FROM hd.NgayLap) = ? " +
                "  AND EXTRACT(MONTH FROM hd.NgayLap) = ? " +
                "  GROUP BY nv.Ten " +
                "  ORDER BY totalInvoices DESC " +
                ") WHERE ROWNUM <= 10");
        p.setInt(1, year);
        p.setInt(2, month);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            String employeeName = r.getString("Ten");
            double totalInvoices = r.getDouble("totalInvoices");
            pieDataset.setValue(employeeName, totalInvoices);
        }
        r.close();
        p.close();

        pieChartPanel.repaint();
    }

    private void showPieChart() {
        pieDataset = new DefaultPieDataset();
        pieDataset.setValue("No Data", 100);

        pieChart = ChartFactory.createPieChart3D("Thống kê 10 nhân viên có nhiều hóa đơn nhất trong tháng", pieDataset, true, true, false);
        pieChart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 20));
        PiePlot piePlot = (PiePlot) pieChart.getPlot();
        chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(new Color(255, 255, 255));
        chartPanel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        piePlot.setBackgroundPaint(new Color(240, 248, 255));

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
                PieChartThongKeNhanVien frame = new PieChartThongKeNhanVien();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
