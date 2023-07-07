package 网络编程.社区党群服务中心管理系统;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        //增加界面的美观程度
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
        Thread t = new Thread(new ChatServerThread(ss));
        t.start();
    }
}

public class ChatServerThread extends JPanel implements Runnable {
    ServerSocket ss;
    JTextArea area=new JTextArea(20,20);
    @Override
    public void run() {
        try {
            while (true) {

                //在线聊天服务器，群聊
                Socket socket1 = ss.accept();
                BufferedReader br1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                String str = br1.readLine();

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
                bw.write(str);
                bw.newLine();
                bw.flush();

                area.append(str+"\n");

                br1.close();
                bw.close();
                socket1.close();

            }
        } catch (Exception ee) {
            System.out.println(ee);
            ee.printStackTrace();
        }
    }

    public ChatServerThread(ServerSocket ss) {
        this.ss = ss;
        JFrame frame=new JFrame("在线聊天信息框");
        JPanel panel=new JPanel();


        area.setForeground(Color.MAGENTA);
        area.setCaretColor(Color.MAGENTA);
        area.setSelectionColor(Color.MAGENTA);

        frame.add(panel);
        JScrollPane js=new JScrollPane(area);
        panel.add(js);
        frame.setVisible(true);
        frame.setSize(250,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
