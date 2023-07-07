package 图形用户界面.exercise;
/*框架和标签的使用（JFrame和·JLabel）*/

import javax.swing.*;
import java.awt.*;

public class JFrameLabel extends JFrame{
    public JFrameLabel()
    {
        super("框架和标签的使用");
        Container c=getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.LEFT));
        String[] s={"文本标签","文字在图形上方","文字在图形下方"};
        ImageIcon []ic={null,new ImageIcon(getClass().getResource("1.jpg")),
                new ImageIcon(getClass().getResource("9.jpg"))};
        int []ih={0,JLabel.LEFT,JLabel.CENTER};
        int []iv={0,JLabel.CENTER,JLabel.BOTTOM};
        for(int i=0;i<3;i++)
        {
            JLabel label=new JLabel(s[i],ic[i],JLabel.LEFT);
            if(i>0)
            {
                label.setHorizontalAlignment(ih[i]);
                label.setHorizontalAlignment(iv[i]);

            }
            label.setToolTipText("第"+(i+1)+"个标签");
            c.add(label);
        }
    }

    public static void main(String[] args) {
        JFrameLabel app=new JFrameLabel();
        app.setSize(600,300);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
