package 网络编程.社区党群服务中心管理系统;

import javax.swing.*;
import java.awt.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatManager extends JPanel {
    String name;
    JButton b1;

    public ChatManager(String name) {
        this.name = name;
        JPanel panel, cover, panel1;
        panel = new JPanel();
        this.add(panel);
        this.setVisible(true);

        b1 = new JButton("发送");

        JTextField t1 = new JTextField(20);

        panel1 = new JPanel(new BorderLayout());
        cover = new JPanel();
        Box hbox = Box.createHorizontalBox();
        hbox.add(t1);
        hbox.add(b1);

        panel1.add(hbox, BorderLayout.SOUTH);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(cover, BorderLayout.CENTER);

        b1.addActionListener(e -> {
            if (e.getActionCommand().equals("发送")) {
                try {
                    try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        }
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }
                    DatagramSocket socket1 = new DatagramSocket();
                    String str = "用户"+name + ":" + t1.getText();
                    byte[] bytes =str.getBytes() ;
                    //创建数据，并把数据打包
                    DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"),10010);
                    socket1.send(packet1);

                    //设置对话框将在1秒后自动关闭
                    JOptionPane pane = new JOptionPane("发送成功", JOptionPane.INFORMATION_MESSAGE);
                    int TIME_VISIBLE = 1000;//单位ms
                    JDialog dialog = pane.createDialog(null, "该对话框将在1秒后自动关闭");
                    dialog.setModal(false);
                    dialog.setVisible(true);
                    new Timer(TIME_VISIBLE, e12 -> dialog.setVisible(false)).start();
                    t1.setText("");
                } catch (Exception socketException) {
                    socketException.printStackTrace();
                }

            }
        });
    }



}



