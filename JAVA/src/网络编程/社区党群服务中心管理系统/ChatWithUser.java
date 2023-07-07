package 网络编程.社区党群服务中心管理系统;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ChatWithUser extends JPanel {
    String name;
    JButton b1;
    JTextField t1;

    public ChatWithUser(String name) {
        this.name = name;
        JPanel panel, cover, panel1;
        panel = new JPanel();
        this.add(panel);
        this.setVisible(true);
        b1 = new JButton("发送");

        t1 = new JTextField(20);

        panel1 = new JPanel(new BorderLayout());
        cover = new JPanel();

        Box hbox = Box.createHorizontalBox();
        hbox.add(t1);
        hbox.add(b1);

        panel1.add(hbox, BorderLayout.SOUTH);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(cover, BorderLayout.CENTER);


        b1.addActionListener(e -> {
            try {
                DatagramSocket socket1 = new DatagramSocket();
                String str = t1.getText()  + ":"+ "系统管理员" + name;
                byte[] b1 = str.getBytes();
                //创建数据，并把数据打包
                DatagramPacket packet1 = new DatagramPacket(b1, b1.length, InetAddress.getByName("localhost"), 10010);
                socket1.send(packet1);
                //设置对话框将在1秒后自动关闭
                JOptionPane pane = new JOptionPane("发送成功", JOptionPane.INFORMATION_MESSAGE);
                int TIME_VISIBLE = 1000;//单位ms
                JDialog dialog = pane.createDialog(null, "该对话框将在1秒后自动关闭");
                dialog.setModal(false);
                dialog.setVisible(true);
                new Timer(TIME_VISIBLE, e1 -> dialog.setVisible(false)).start();
                t1.setText("");
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });


    }

    public ChatWithUser() {

    }
}
