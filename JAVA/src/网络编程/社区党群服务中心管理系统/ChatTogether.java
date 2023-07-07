package 网络编程.社区党群服务中心管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ChatTogether extends JPanel {
    String name;
    public ChatTogether(String name) {
        this.name = name;
        JPanel panel, cover, panel1;
        panel = new JPanel();
        this.add(panel);
        this.setVisible(true);

        JButton b1 = new JButton("发送");
        JTextField t1 = new JTextField(20);
        panel1 = new JPanel(new BorderLayout());
        cover = new JPanel();

        Box hbox = Box.createHorizontalBox();
        hbox.add(t1);
        hbox.add(b1);

        panel1.add(hbox, BorderLayout.CENTER);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(cover, BorderLayout.CENTER);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("发送")) {
                    //向服务器端发送数据
                    try {
                        Socket socket1 = new Socket("localhost", 7777);
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                        String str = name + ":" + t1.getText();
                        bw.write(str);
                        bw.newLine();
                        bw.flush();


                        //接收服务器的反馈
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                        String str1 = br.readLine();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }

            }
        });


    }


}
