package zzlown;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Acg {

    public Acg() {
        //改变框架图标
        JFrame frame = new JFrame("Fate");
        JPanel panel = new JPanel(new GridLayout(1, 1));
        @SuppressWarnings("all")
        String pathName = "D:\\IntelliJ IDEA 2021.1.2\\代码\\JAVA\\src\\zzlown\\命运转盘.png";
        try {
            frame.setIconImage(ImageIO.read(new File(pathName)));
        } catch (IOException exception) {
            exception.getStackTrace();
        }

        JPanel cover = new JPanel();
        @SuppressWarnings("all")
        //添加背景图片
        ImageIcon bg = new ImageIcon("D:\\IntelliJ IDEA 2021.1.2\\代码\\JAVA\\src\\zzlown\\nightmare_order.jpg");
        JLabel label = new JLabel(bg);
        label.setBounds(0, 0, bg.getIconWidth(), bg.getIconHeight());
        frame.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
        JPanel jp = (JPanel) frame.getContentPane();
        jp.setOpaque(false);
        panel.setOpaque(false);
        cover.setOpaque(false);

        JButton b1 = new JButton("Fate Order");

        JButton b2 = new JButton("侍寝名单");

        b1.addActionListener(e -> {
            if (e.getActionCommand().equals("Fate Order")) {
                cover.setVisible(false);
                cover.removeAll();
                cover.add(new Fate());
                cover.setVisible(true);
            }
        });


        b2.addActionListener(e -> {
            if (e.getActionCommand().equals("侍寝名单")) {
                cover.setVisible(false);
                cover.removeAll();
                cover.add(new Information());
                cover.setVisible(true);
            }
        });

        frame.setSize(1000, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        panel.setBackground(new java.awt.Color(122, 255, 193));


        panel.add(b1);
        panel.add(b2);
        frame.add(panel, "North");
        frame.add(cover, "Center");
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new Acg();
    }

}

class Information extends JPanel {
    public Information() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);


        JTextArea area = new JTextArea(45, 40);
        area.setForeground(Color.green);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);
        this.add(panel);
        this.setVisible(true);

        panel.add(new JScrollPane(area));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            @SuppressWarnings("all")
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/umr", "root", "yswysyydxj");
            @SuppressWarnings("all")
            String sql = "select * from acg ";
            Statement ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery(sql);

            int i = 0;
            while (rs.next()) {
                i++;
                area.append("<----------------->" + i + "<----------------->");
                area.append("\n");
                area.append(rs.getString(1));
                area.append(":");
                area.append(rs.getString(2));
                area.append("\n");
            }
            area.append("共计有" + i + "条数据");
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}


class Fate extends JPanel {

    public Fate() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JTextField t1 = new JTextField(10);
        JTextArea area = new JTextArea(45, 40);
        JButton button = new JButton("Select");
        JLabel label = new JLabel("姓名");

        area.setForeground(Color.green);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);
        panel.setBackground(Color.pink);

        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.add(label);
        panel.add(t1);
        panel.add(button);

        panel.add(new JScrollPane(area));

        this.add(panel);
        this.setVisible(true);
        button.addActionListener(e -> {
            if (e.getActionCommand().equals("Select")) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    @SuppressWarnings("all")
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/umr", "root", "yswysyydxj");
                    @SuppressWarnings("all")
                    String sql = "select * from acg where xm='" + t1.getText() + "'";

                    Statement ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet rs = ps.executeQuery(sql);


                    while (rs.next()) {
                        area.append(rs.getString(1));
                        area.append(":");
                        area.append(rs.getString(2));
                        area.append("\n");
                    }

                    ps.close();
                    conn.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

        });

    }

}