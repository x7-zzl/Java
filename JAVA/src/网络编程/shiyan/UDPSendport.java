package 网络编程.shiyan;
/*
2. 使用基于UDP的网络编程方法，完成多个客户端和服务器间的聊天功能。要求图形界面。
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSendport {
    public static void main(String[] args) throws IOException{

        //以开启三个客户端为例
        int i;
        for ( i=3;i>0;i--){
            JFrame frame = new JFrame("客户端"+i);
            JPanel panel = new JPanel();
            JLabel label = new JLabel("客户端"+i+":");
            JTextField textField1 = new JTextField(20);
            JButton button = new JButton("发送");

            frame.add(panel);
            panel.add(label);
            panel.add(textField1);
            panel.add(button);

//            switch (i){
//                case 1: panel.setBackground(new java.awt.Color(122, 217, 255));break;
//                case 2: panel.setBackground(new java.awt.Color(255, 122, 122, 111));break;
//                case 3:  panel.setBackground(new java.awt.Color(122, 255, 193));break;
//            }
            if(i == 1){
                panel.setBackground(new java.awt.Color(122, 217, 255));
            }
            if(i==2){
                panel.setBackground(new java.awt.Color(255, 122, 122, 111));
            }
            if(i==3){
                panel.setBackground(new java.awt.Color(122, 255, 193));
            }
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            //客户端发送数据
            DatagramSocket socket1 = new DatagramSocket();
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((e.getActionCommand().equals("发送"))){

                        String line1="客户端"+finalI+":"+textField1.getText();
                        byte[] b1 =line1.getBytes(StandardCharsets.UTF_8) ;

                        //创建数据，并把数据打包
                        DatagramPacket packet1 = null;
                        try {
                            packet1 = new DatagramPacket(b1, b1.length, InetAddress.getByName("localhost"),10010);
                            //发送数据
                            socket1.send(packet1);
//                            JOptionPane.showMessageDialog(null,"发送成功");
                        }  catch (IOException ioException) {
                            System.out.println(ioException);
                        }

                    }
                }
            });


        }


    }
}
