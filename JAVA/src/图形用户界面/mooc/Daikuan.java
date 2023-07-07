package 图形用户界面.mooc;
/*( 50分 )
用图形用户界面完成第4单元作业题2：贷款计算
为了认清校园贷的本质，请根据下面的描述，计算校园贷的实际花费。 用户借贷为等额本息贷款，贷款月利率为0.9%，每月还款金额计算如下式所示，
假设李雷贷款n元，分m月还清，贷款平台需要扣除本金的20%作为保证金，利率按足额贷款进行计算。
要求：设计图形界面，程序运行后，用户在图形界面中输入贷款金额和还款月数，计算李雷实际贷到的金额以及加上本金共需还款金额（结果四舍五入）并输出。 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Daikuan {
    private JLabel label1, label2, label3, label4;
    JTextField textField1, textField2, textField3, textField4;

    public Daikuan() {
        JFrame frame = new JFrame("贷款计算");
        JPanel panel = new JPanel();
        label1 = new JLabel("贷款金额");
        label2 = new JLabel("贷款月数");
        label3 = new JLabel("实际贷到的金额");
        label4 = new JLabel("共需还款金额");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        textField4 = new JTextField(10);
        JButton button = new JButton("计算共需还款金额");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("计算共需还款金额")) {
                    int n = Integer.parseInt(textField1.getText());
                    int m = Integer.parseInt(textField2.getText());
                    float w = Float.valueOf(String.valueOf(textField1));
                    float k = (float) Math.pow(1.009, m);
                    int x = (int) Math.round(n * 0.8);
                    int y = (int) Math.round(n + m * n * 0.009 * k / (k - 1));
                    textField3.setText(String.valueOf(x));
                    textField4.setText(String.valueOf(y));
                }
            }
        });


        frame.add(panel);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(button);

        panel.setBackground(Color.cyan);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(225, 225);

    }

    public static void main(String[] args) {
        new Daikuan();
    }

}
