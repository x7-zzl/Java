package 网络编程.ChatDouble;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatManager extends JPanel {
    String name;
    JTextArea area;
    JTextField t1;
    JButton b1;
    BufferedWriter bw;
    BufferedReader br;

    public ChatManager(String name) {
        this.name = name;
        JPanel panel, cover, panel1;
        panel = new JPanel();
        this.add(panel);
        this.setVisible(true);

        b1 = new JButton("发送");
        area = new JTextArea(20, 10);
        area.setForeground(Color.MAGENTA);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);

        JScrollPane js = new JScrollPane(area);
        t1 = new JTextField(20);

        panel1 = new JPanel(new BorderLayout());
        cover = new JPanel();

        Box hbox = Box.createHorizontalBox();
        hbox.add(t1);
        hbox.add(b1);

        panel1.add(js, BorderLayout.NORTH);
        panel1.add(hbox, BorderLayout.SOUTH);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(cover, BorderLayout.CENTER);
        Socket socket1 = null;
        try {
            socket1 = new Socket("localhost", 8889);

            bw = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("发送")) {
                    try {


                        //向服务器端发送数据
                        String str = name + ":" + t1.getText();
                        area.append(str + "\n");

                        bw.write(str);
                        bw.newLine();
                        bw.flush();

                        //接收服务器的反馈
                        String str1 = br.readLine();
                        area.append(str1 + "\n");


                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

            }
        });
    }

}





