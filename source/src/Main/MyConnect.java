package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
    private static Connection conn = null;
    public static final String MyURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String UrName = "QLCH";
    public static final String UrPass = "QLCH";
    
    public static void connectToDatabase() throws SQLException{
	if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(MyURL, UrName, UrPass);
        }
    }
    
    public static  Connection getConnection() {
        return conn;
    }
    
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MyConnect(){
        try {
            //Đăng ký Driver cho project
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");
            
            //Tạo thông số kết nối
            conn = DriverManager.getConnection(MyURL, UrName, UrPass);          
            
            //Kiểm tra kết nối thành công hay không
            if (conn != null) { 
                System.out.println("Connected to the database"); 
                System.out.println("Application is running..."); 
            } 
            else { 
                System.out.println("Failed to make connection!"); 
            }
        //Kiểm tra có thư viện JDBC chưa
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }
}
