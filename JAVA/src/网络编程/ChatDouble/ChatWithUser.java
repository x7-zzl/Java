package 网络编程.ChatDouble;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatWithUser extends JPanel {
    String name;
    JTextArea area;
    JButton b1;
    JTextField t1;
    BufferedWriter bw;
    BufferedReader br1;

    public ChatWithUser(String name) {
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

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(8889);
            Socket socket = ss.accept();
            br1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getActionCommand().equals("发送")) {
                    try {

                        String str = br1.readLine();
                        area.append(str + "\n");
                        String str1 = "系统管理员" + name + ":" + t1.getText();
                        area.append(str1 + "\n");
                        bw.write(str1);
                        bw.newLine();
                        bw.flush();

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });


    }

}


