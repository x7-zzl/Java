package 网络编程.shiyan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/*1. 使用基于TCP的网络编程方法，完成远程注册与登录模块，即客户端发送相关请求，服务器端接收请求处理并返回响应消息。
要求图形界面，数据库保存注册信息。
 */
public class TCPclientdemo {
    public TCPclientdemo() {
        JFrame frame = new JFrame("客户端");
        JPanel panel = new JPanel();
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        JButton button1 = new JButton("登录");
        JButton button2 = new JButton("注册");

        frame.add(panel);
        panel.setBackground(new java.awt.Color(173, 255, 122));
        panel.add(new JLabel("用户名"));
        panel.add(textField1);
        panel.add(new JLabel("密码"));
        panel.add(new JLabel("  "));
        panel.add(textField2);
        panel.add(button1);
        panel.add(button2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 350);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("登录")) {

                    try {
                        Socket socket1  = new Socket("localhost", 12345);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                        bw.write(textField1.getText());
                        bw.newLine();
                        bw.write(textField2.getText());
                        bw.newLine();
                        bw.write("登录");
                        bw.newLine();
                        bw.flush();

                        //接收服务器的反馈
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                        String line = br.readLine();
                        JOptionPane.showMessageDialog(null, line);

                        socket1.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("注册")) {
                    if (e.getActionCommand().equals("注册")) {
                        Socket socket2 = null;
                        try {
                            socket2 = new Socket("localhost", 12345);
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
                            bw.write(textField1.getText());
                            bw.newLine();
                            bw.write(textField2.getText());
                            bw.newLine();
                            bw.write("注册");
                            bw.newLine();
                            bw.flush();

                            //接收服务器的反馈
                            BufferedReader br = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                            String line = br.readLine();
                            JOptionPane.showMessageDialog(null, line);

                            socket2.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }

                }
            }
        });
    }

    public static void main(String[] args) {
        new TCPclientdemo();
    }
}
