package 网络编程.社区党群服务中心管理系统;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerReceiveChat {
    public static void main(String[] args) throws IOException {
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
        DatagramSocket socket=new DatagramSocket(10010);
        ServerPortThread t=new ServerPortThread(socket);
        t.start();
    }

}

class ServerPortThread extends Thread{
    DatagramSocket socket;
    JTextArea area;

    public ServerPortThread(DatagramSocket socket) {
        this.socket = socket;
        JFrame frame = new JFrame("聊天信息框");
        JPanel panel = new JPanel();
        area = new JTextArea(20, 25);


        frame.add(panel);
        JScrollPane js=new JScrollPane(area);
        panel.add(js);
        area.setForeground(Color.MAGENTA);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);

        panel.setBackground(new Color(122, 255, 124, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(325, 470);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] b1 = new byte[1024];
                //创建数据，并把数据打包
                DatagramPacket packet1 = new DatagramPacket(b1, b1.length);
                socket.receive(packet1);
                String line1 = new String(packet1.getData());

                if(line1.contains("用户")){
                    area.append(line1+"\n");
                }else if(line1.contains("系统管理员")){
                    area.append("\t"+line1+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}