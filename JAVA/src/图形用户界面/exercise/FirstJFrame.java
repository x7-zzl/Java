package 图形用户界面.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstJFrame {
        public static void main(String[] args) {
            JFrame a=new JFrame("第一个界面");//框架名称
            JLabel label1=new JLabel("name");//实例化一个标签"name"
            JLabel label2=new JLabel("password");

            JPanel panel1=new JPanel();//实例化面板对象panel1

            JTextField txt=new JTextField(20);//输入文本信息,长度为20
            JPasswordField p1=new JPasswordField(20);
            JButton login=new JButton("登录");//登录按钮
            JButton exit=new JButton("退出");
            a.add(panel1);//面板加到框架



            panel1.setBackground(Color.cyan);//面板设置颜色
            panel1.add(label1);//标签加到面板上
            panel1.add(new JLabel("      "));//通过此方法可以给标签后增加空白字符，以便于窗口的美观
            panel1.add(txt);//输入文本框加到面板上
            panel1.add(label2);
            panel1.add(p1);//输入文本框加到面板上

            panel1.add(login);//登录按钮加到面板上
            panel1.add(exit);


            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("登录成功");
                }
            });

            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            a.setSize(300,280);//设置大小
            a.setLocationRelativeTo(null);//相对位置null，即为居中
            a.setVisible(true);//可视
            a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点x关闭窗口
            a.setResizable(false);//不改变大小



        }

}
