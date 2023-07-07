package 图形用户界面.Christmas;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Test extends JFrame {
    public static void main(String[] args) {
        Test TuPian = new Test();
        TuPian.launch();
    }

    @Override
    public void paint(Graphics g) {
    
        g.setColor(Color.green);
        g.setFont(new Font("黑体",Font.BOLD,10));
//        g.drawString("圣",295,100);
//        g.drawString("圣诞快",285,115);

        String[] s = {"圣","诞","快","乐","！","圣","诞","快","乐","！","圣","诞","快","乐","！"
                ,"圣","诞","快","乐","！","圣","诞","快","乐","！","圣","诞","快","乐","！"
                ,"圣","诞","快","乐","！","圣","诞","快","乐","！","圣","诞","快","乐","！"
                ,"圣","诞","快","乐","！","圣","诞","快","乐","！","圣","诞","快","乐","！"};
        //第一块
        for (int i =110;i < 230;i += 15){
            for(int j = 0;j < (i-110)*2/15+1;j ++){
                g.drawString(s[j],295-(i-110)/3*2+10*j,i);
            }
        }
        //第二块
        for (int i =230;i<355;i+=15){
            for (int j = 0;j < (i-215)*2/15+3;j ++)
                g.drawString(s[j],275-(i-230)/3*2+10*j,i);
        }
        //第三块
        for (int i =365;i<560;i+=15){
            for (int j = 0;j < (i-365)*2/15+9;j ++)
                g.drawString(s[j],255-(i-365)/3*2+10*j,i);
        }
        g.setColor(new Color(230,120,0));
        for (int i =560;i<630;i+=15){
            g.drawString("圣诞快乐！",275,i);
        }
    }

    public void launch() {
        //改变框架图标
        try {
            this.setIconImage(ImageIO.read(new File("D:\\IntelliJ IDEA 2021.1.2\\代码\\untitled\\src\\图形用户界面\\Christmas\\圣诞树背景图.png")));
        }catch (IOException exception){
            exception.getStackTrace();
        }
//       设置窗口是否可见
        this.setVisible(true);
//        设置窗口大小
        this.setSize(600,700);
//        设置窗口位置
        this.setLocationRelativeTo(null);
//        设置窗口标题
        this.setTitle("圣诞树");
    }
}