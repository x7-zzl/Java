package 图形用户界面.mooc;
/*
用图形用户界面完成第4单元作业题1：趣味数学题

马克思手稿中有这样一道趣味数学题：男人、女人和小孩总计n个人，在一家饭店里吃饭，共花了cost先令，每个男人各花3先令，每个女人各花2先令，每个小孩各花1先令，
请用穷举法编程计算男人、女人和小孩各有几个。
要求：设计图形界面，程序运行后，用户在图形界面中输入人数和总花费。若问题有解，计算男人、女人和小孩的数量并输出；若问题无解，则输出“No answer"。
注意：所有最终结果信息不要输出在控制台。
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eula {
    int man,woman,kid;
    int flag=0;
    private JLabel label1,label2;
    private JTextField textField1,textField2;
    public Eula()
    {
        JFrame frame=new JFrame("趣味数学题");
        JPanel panel=new JPanel();
        label1=new JLabel("总人数");
        label2=new JLabel("总花费");

        textField1= new JTextField(10);
        textField2= new JTextField(10);
        JTextArea area=new JTextArea(6,15);
        JScrollPane jScrollPane=new JScrollPane(area);

        JButton button=new JButton("计算");

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("计算"))
                {
                    area.setText("  ");
                    int n= Integer.parseInt(textField1.getText());
                    int cost=Integer.parseInt(textField2.getText());
                    int s=1;
                    for(man=0;man<=cost/3;man++)
                    {
                        for(woman=0;woman<=cost/2;woman++) {
                            kid = n - man - woman;
                            if (kid >=0) {//确保小孩的人数大于0计算
                                if (cost == 3 * man + 2 * woman + kid) {
                                    area.append("\n第"+s+++"种方法"+"\n男生人数:"+man+"\n女生人数"+woman+"\n小孩人数"+kid);
                                    flag = 1;
                                }
                            }
                        }
                    }
                    if(flag==0)
                        JOptionPane.showMessageDialog(null,"No answer!");
                }
            }
        });
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(panel);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(jScrollPane);
        panel.add(button);



        frame.setVisible(true);
        frame.setSize(180,300);
        frame.setLocationRelativeTo(null);
        panel.setBackground(Color.cyan);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

        public static void main(String[] args) {
            new Eula();
        }

}
