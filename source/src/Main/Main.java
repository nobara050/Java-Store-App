package Main;
import QuanLyCuaHang.GUI.LoginFormGUI;

public class Main {
    public static void main(String[] args) {
        MyConnect myConnect = new MyConnect();
        new LoginFormGUI().setVisible(true);
    }
}