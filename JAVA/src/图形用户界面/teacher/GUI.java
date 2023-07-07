package 图形用户界面.teacher;
import javax.swing.*;

public class GUI {
    private  JFrame registerJFrame;
    private  RegisterGui  registerJPanle;
    public GUI() {
        registerJFrame=new JFrame("管理系统");
        registerJPanle =new RegisterGui();
        registerJFrame.add(registerJPanle.getRegisterJPanle());
        registerJFrame.setSize(200,400);
        registerJFrame.setLocationRelativeTo(null);//屏幕中央
        registerJFrame.setVisible(true);
        // registerJFrame.setResizable(false);// 不最大化
        registerJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        new GUI();

    }
}


