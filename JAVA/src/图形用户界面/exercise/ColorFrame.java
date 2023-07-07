package 图形用户界面.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame {
    private JPanel panel1, panel2;
    public ColorFrame() {
        setLayout(new GridLayout(-1, 1));
        panel1 = new JPanel();
        panel2 = new JPanel();
        getContentPane().add(panel1);
        getContentPane().add(panel2);
        panel1.setBackground(Color.red);
        JButton btn1 = new JButton("White");
        JButton btn2 = new JButton("Black");
        panel1.add(btn1);
        panel1.add(btn2);
        new ToogleGroup(panel1, btn1, Color.white, btn2, Color.black);
        JButton btn3 = new JButton("Red");
        JButton btn4 = new JButton("Green");
        panel2.add(btn3);
        panel2.add(btn4);
        new ToogleGroup(panel2, btn3, Color.red, btn4, Color.green);
    }
    private static class ToogleGroup implements ActionListener {
        private JButton btn1;
        private JButton btn2;
        private Color color1;
        private Color color2;
        private Component target;
        public ToogleGroup(Component target, JButton btn1, Color color1,
                           JButton btn2, Color color2) {
            this.btn1 = btn1;
            this.btn2 = btn2;
            btn1.addActionListener(this);
            btn2.addActionListener(this);
            this.target = target;
            this.color1 = color1;
            this.color2 = color2;
            toggleButton(btn1);
        }
        private void toggleButton(Object src){
            if (src == btn1) {
                btn1.setVisible(false);
                btn2.setVisible(true);
                target.setBackground(color1);
            } else {
                btn1.setVisible(true);
                btn2.setVisible(false);
                target.setBackground(color2);
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            toggleButton(src);
        }
    }
    public static void main(String[] args) {
        ColorFrame colorFrame = new ColorFrame();
        colorFrame.setSize(300, 300);
        colorFrame.setLocationRelativeTo(null);
        colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorFrame.setVisible(true);
    }

}
