package 图形用户界面.progress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JProgressTest {

    JFrame frame = new JFrame("测试进度条");

    JCheckBox indeterminate = new JCheckBox("不确定进度");
    JCheckBox noBorder = new JCheckBox("不绘制边框");

    //创建进度条
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);


    public void init(){
        //组装视图

        //处理复选框的点击行为
        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取一下indeterminate复选框有没有选中？
                boolean selected = indeterminate.isSelected();

                //设置当前进度条不确定进度
                bar.setIndeterminate(selected);

                bar.setStringPainted(!selected);

            }
        });

        noBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取一下noBorder复选框有没有选中？
                boolean selected = noBorder.isSelected();

                bar.setBorderPainted(!selected);
            }
        });

        Box vBox = Box.createVerticalBox();
        vBox.add(indeterminate);
        vBox.add(noBorder);


        //设置进度条的属性
        bar.setStringPainted(true);
        bar.setBorderPainted(true);

        //把当前窗口的布局方式修改为FlowLayout
        frame.setLayout(new FlowLayout());
        frame.add(vBox);
        frame.add(bar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //通过循环模拟修改进度条的进度
        for (int i = 0; i <= 100; i++) {
            //修改已经完成的工作量，也就是百分比
            bar.setValue(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        new JProgressTest().init();
    }
}
