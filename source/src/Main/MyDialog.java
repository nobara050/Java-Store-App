package Main;

import javax.swing.*;

public class MyDialog extends JDialog {

    public String content;
    public int type;
    public final static int ERROR_DIALOG = 1;
    public final static int SUCCESS_DIALOG = 2;
    public final static int INFO_DIALOG = 3;
    public final static int WARNING_DIALOG = 4;
    
    private int action;
    public final static int OK_OPTION = 0;
    public final static int NO_OPTION = 1;
    
    public int getAction() {
        return action;
    }

    public MyDialog(String content, int type) {
        this.content = content;
        this.type = type;
        action();
    }
    public void action(){
        switch (this.type) {
            case 1 ->                 {
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame,content,"Error",JOptionPane.ERROR_MESSAGE);
                }
            case 2 ->                 {
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame,content,"Success",JOptionPane.INFORMATION_MESSAGE);
                }
            case 3 ->                 {
                    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
                    JOptionPane.showMessageDialog(frame,content,"Info",JOptionPane.INFORMATION_MESSAGE);
                }
            case 4 -> action = JOptionPane.showConfirmDialog(null, content, "Confirm" , JOptionPane.YES_NO_OPTION);
            default -> {
            }
        }
    }
    
    
}


