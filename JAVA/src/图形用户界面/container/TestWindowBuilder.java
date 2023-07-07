package 图形用户界面.container;

import javax.swing.*;
import java.awt.*;

public class TestWindowBuilder extends JFrame {

    public TestWindowBuilder(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,300);
        getContentPane().setLayout(new BorderLayout(0,0));
        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar,BorderLayout.NORTH);
        JButton button = new JButton("打开");
        toolBar.add(button);
        JButton button1 = new JButton("保存");
        toolBar.add(button1);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu1 = new JMenu("文件");
        menuBar.add(menu1);

        JMenuItem menuItem1 = new JMenuItem("打开");
        menu1.add(menuItem1);
        JMenuItem menuItem2 = new JMenuItem("保存");
        menu1.add(menuItem2);
        JMenu menu = new JMenu("编辑");
        menuBar.add(menu);
        JMenuItem menuItem3 = new JMenuItem("复制");
        menu.add(menuItem3);
        JMenuItem menuItem4 = new JMenuItem("粘贴");
        menu.add(menuItem4);
    }
    public static void main(String[] args) {
        TestWindowBuilder testWindowBuilder = new TestWindowBuilder();
        testWindowBuilder.setVisible(true);

    }
}
