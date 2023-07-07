package 图形用户界面.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandingUse {
    public EventHandingUse()
    {
        JFrame app=new JFrame("事件处理");
        Container c=app.getContentPane();
        c.setLayout(new FlowLayout());
        JButton b=new JButton("单击");
        b.addActionListener(new B());
        c.add(b);
        app.setSize(200,100);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }



    class B implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("触发事件源");
        }
    }
        public static void main(String[] args) {
            new EventHandingUse();
        }



}
