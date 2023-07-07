package 图形用户界面.五子棋.draw;

//import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleDraw {

    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";

    private JFrame frame = new JFrame("这里测试绘图");

    JButton btnRect = new JButton("绘制矩形");
    JButton btnOval = new JButton("绘制椭圆");

    //定义一个变量，记录当前要绘制椭圆还是矩形
    private String shape = "";

    //自定义类，继承Canvas类，重写paint(Graphics g)方法完成画图；
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //绘制不同的图形

            if (shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.MAGENTA);//设置当前画笔的颜色为黑色
                g.drawRect(100,100,150,100);

            }else if(shape.equals(OVAL_SHAPE)){
                //绘制椭圆
                g.setColor(Color.RED);
                g.drawOval(100,100,150,100);
            }

        }
    }

    //创建自定义的画布对象
    MyCanvas drawArea = new MyCanvas();


    public void init(){
        //组装视图
        btnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改标记的值为rect
                shape = RECT_SHAPE;
                drawArea.repaint();
            }
        });

        btnOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改标记的值为oval
                shape = OVAL_SHAPE;
                drawArea.repaint();
            }
        });

        //创建Panel，承载按钮
        Panel p = new Panel();
        p.add(btnRect);
        p.add(btnOval);

        frame.add(p,BorderLayout.SOUTH);

        //drawArea的大小需要设置
        drawArea.setPreferredSize(new Dimension(300,300));
        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }



}

