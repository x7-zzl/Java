package 多线程.shiyan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class PaintovalPane extends JPanel implements Runnable{
    int x;
    int y;
    int r;
    public PaintovalPane(int x,int y,int r ){
        this.x = x ;
        this.y = y ;
        this.r = r ;
    }
    public void paintComponent(Graphics g) {
        Random rd = new Random(System.currentTimeMillis());
        super.paintComponent(g);
        g.setColor(Color.getHSBColor(rd.nextInt(255),
                rd.nextInt(255), rd.nextInt(255)));
        g.fillOval(x, y, r, r);
    }
    @Override
    public void run() {
// TODO Auto-generated method stub
        while(true)
        {
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class InputPane extends JPanel{

    JTextField jtf1 = new JTextField("",5);
    JTextField jtf2 = new JTextField("",5);

    JLabel jl1 = new JLabel("行数");
    JLabel jl2 = new JLabel("列数");

    public InputPane(){

        jl1.setBounds(0, 0, 50, 20);
        jl2.setBounds(0, 25, 50, 20);

        jtf1.addActionListener(new My_ActionListener1());
        jtf2.addActionListener(new My_ActionListener1());

        jtf1.setBounds(50, 0, 50, 20);
        jtf2.setBounds(50, 25, 50, 20);

        setLayout(null);

        add(jl1);
        add(jl2);
        add(jtf1);
        add(jtf2);

    }

}

class My_ActionListener1 implements ActionListener{
    String info;
    @Override
    public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
        info = (String)e.getActionCommand();
        System.out.println(info);
    }

}

class PaintovalFrame extends JFrame{
    public PaintovalFrame() {
        setTitle("lamp");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        InputPane ip = new InputPane();
        ip.setBounds(250, 300, 200, 100);

        contentPane.add(ip);

        for(int i=0;i<5;i++){

            for(int j=0;j<5;j++){

                PaintovalPane jp = new PaintovalPane(0,0,50);

                jp.setBounds(50*i, 50*j, 50, 50);

                contentPane.add(jp);

                new Thread(jp).start();

            }

        }

    }
}

public class Paintoval {
    public static void main(String[] args)
    {
        JFrame f = new PaintovalFrame();
        f.show();
    }
}