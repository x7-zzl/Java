package 网络编程.shiyan;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPSERVERThread extends Thread {
    private DatagramSocket socket;
    private JTextArea area;

    public UDPSERVERThread(DatagramSocket socket) {
        this.socket = socket;

        JFrame frame = new JFrame("服务器端");
        JPanel panel = new JPanel();
        area = new JTextArea(20, 30);

        frame.add(panel);
        panel.add(area);
        area.setForeground(Color.MAGENTA);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);

        panel.setBackground(new Color(122, 255, 124, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(325, 470);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void run() {
        while (true) {
            try {
                byte[] b1 = new byte[1024];
                //创建数据，并把数据打包
                DatagramPacket packet1 = new DatagramPacket(b1, b1.length);
                socket.receive(packet1);
//              System.out.println(new String(packet1.getData(), 0, packet1.getLength()));
                String line1 = new String(packet1.getData());
                area.append(line1);
                area.append("\n");
                System.out.println(line1);
                //不能关闭socket
                // socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
