package 图形用户界面.弹球小游戏;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class PinBall {
    //创建窗口对象

    JFrame frame = new JFrame("弹球小游戏");

    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;


    //球拍的高度和宽度60
    private final int RACKET_WIDTH = 600;
    private final int RACKET_HEIGHT = 20;

    //小球的大小
    private final int BALL_SIZE = 16;

    //定义变量，记录小球的坐标
    private int ballX = 120;
    private int ballY = 20;

    //定义变量，记录小球在x和y方向上分别移动的速度
    private int speedY = 10;
    private int speedX = 5;

    //定义变量，记录球拍的坐标
    private int racketX = 120;
    private final int racketY = 340;

    //定义变量，标识当前游戏是否已结束
    private boolean isOver = false;

    //声明一个定时器
    private Timer timer;

    //自定义一个类，继承canvas，充当画布
    class MyCanvas extends Canvas {

        @Override
        public void paint(Graphics g) {
            //TODO 在这里绘制内容

            if (isOver) {
                //游戏结束
                g.setColor(Color.RED);

                g.setFont(new Font("Times", Font.BOLD, 25));

                g.drawString("游戏结束！", 50, 200);
            } else {
                //游戏中

                //绘制小球
                g.setColor(Color.BLUE);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

                //绘制球拍
                g.setColor(Color.MAGENTA);
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);
            }

        }
    }

    //创建绘画区域
    MyCanvas drawArea = new MyCanvas();

    public void init() {
        //组装视图，游戏逻辑的控制

        //完成球拍坐标的变化
        KeyListener listener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取当前按下的键
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
                    //<-  应该向左移动
                    if (racketX > 0) {
                        racketX -= 10;
                    }
                }

                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
                    //->  应该向右移动
                    if (racketX < (TABLE_WIDTH - RACKET_WIDTH)) {
                        racketX += 10;
                    }
                }
            }
        };


        // JFrame和drawArea注册监听器
        frame.addKeyListener(listener);
        drawArea.addKeyListener(listener);

        //小球坐标的控制
        ActionListener task = e -> {


            //根据边界范围，修正速度
            if (ballX <= 0 || ballX >= (TABLE_WIDTH - BALL_SIZE)) {
                speedX = -speedX;
            }

            if (ballY <= 0 || (ballY > racketY - BALL_SIZE && ballX > racketX && ballX < racketX + RACKET_WIDTH)) {
                speedY = -speedY;
            }

            if (ballY > racketY - BALL_SIZE && (ballX < racketX || ballX > racketX + RACKET_WIDTH)) {
                //当前小球超出了球拍的范围，游戏结束

                //停止定时器
                timer.stop();
                //修改游戏是否结束的标记
                isOver = true;
                //重绘界面
                drawArea.repaint();
            }

            //更新小球的坐标，重绘界面
            ballX += speedX;
            ballY += speedY;
            //重绘界面
            drawArea.repaint();
        };
        //小球移动速度
        timer = new Timer(88, task);
        timer.start();


        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(drawArea);

        //改变框架图标
        try {
            frame.setIconImage(ImageIO.read(new File("src/图形用户界面/弹球小游戏/弹球.png")));
        }catch (IOException exception){
            exception.getStackTrace();
        }

        //设置frame最佳大小，并可视
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    /*    增加界面的美观程度
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }*/
        new PinBall().init();
    }


}