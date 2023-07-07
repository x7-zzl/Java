package 图形用户界面.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZhuceGUI {

    public static void main(String[] args) {
         JFrame frame;//框架
        JPanel panel;//面板
         JLabel namelabel = new JLabel("姓名");//姓名标签
         TextField textField = new TextField(10);//文本长度10
        JLabel passwordlabel = new JLabel("密码");
       JPasswordField passwordField = new JPasswordField(10);//密码专用 *
        JButton button1 = new JButton("提交");//按钮
       JButton button2;

       JRadioButton sexJRadioButton[] = new JRadioButton[2];//性别选择字符数组，长度为2
         JLabel sexJLabel = new JLabel("性别");
        JLabel hpbby = new JLabel("爱好");
        JCheckBox jCheckBoxes[] = new JCheckBox[6];//多选字符串数组
       JComboBox province;//组合文本框，下拉列表框
       JLabel sheng = new JLabel("省份");

      JLabel comment = new JLabel("评论");
        TextArea commentarea = new TextArea(4, 8);//文本区域面积

        frame = new JFrame("注册界面");
        frame.getContentPane().setBackground(Color.red);//框架设置颜色的方法，被面板覆盖
        panel = new JPanel();

        frame.add(panel);
        panel.setBackground(Color.green);//面板设置颜色
        // panel.setPreferredSize(new Dimension(1000,1000));//设置面板大小

        panel.add(namelabel);//添加各种组件到panel上
        panel.add(textField);
        panel.add(passwordlabel);
        panel.add(passwordField);


        panel.add(sexJLabel);
        String sex[] = {"男", "女"};//字符数组
        ButtonGroup sexGroup = new ButtonGroup();//创建按钮组，把按钮加到同一个组中
        for (int i = 0; i < 2; i++) {
            sexJRadioButton[i] = new JRadioButton(sex[i]);//男,女放入性别选择按钮
            sexGroup.add(sexJRadioButton[i]);//两个性别放在一组里
            panel.add(sexJRadioButton[i]);
            if (i != sexJRadioButton.length - 1)//如果不在数组长度范围内
                panel.add(new JLabel("             "));
        }

        panel.add(hpbby);
        String s[] = {"nanan", "睡觉", "吃饭", "yang", "yuhan", "音乐"};
        for (int i = 0; i < jCheckBoxes.length; i++) {
            jCheckBoxes[i] = new JCheckBox(s[i]);
            panel.add(jCheckBoxes[i]);
            if (i != jCheckBoxes.length - 1)
                panel.add(new JLabel("                       "));
        }


        panel.add(comment);
        commentarea.setSize(20, 10);

        panel.add(commentarea);
        panel.add(new JLabel("                                                           "));
        String p[] = {"河南省", "北京市", "上海市", "重庆市", "天津市"};
        panel.add(sheng);
        province = new JComboBox(p);
        panel.add(province);

    /*    class Jianting implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
               // JButton x=(JButton) e.getSource();
                if(e.getActionCommand().equals("重设")) {
                    JOptionPane.showMessageDialog(null,"重设成功");
                }
            }//

        }
       button2= new JButton("重设");//事件源
        button2.addActionListener(new Jianting());*/

        button2 = new JButton("重设");//事件源
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("重设")) {
                    JOptionPane.showMessageDialog(null, "重设成功");
                }
            }
        });


        frame.setSize(450, 660);
        frame.setResizable(true);//可最大化
        frame.setLocationRelativeTo(null);//屏幕中间
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.add(new JLabel("                           "));
        panel.add(button1);
        panel.add(new JLabel("           "));
        panel.add(button2);
    }
}


