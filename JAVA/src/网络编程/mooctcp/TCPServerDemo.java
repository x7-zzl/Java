package 网络编程.mooctcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line1 = br.readLine();
        String line2 = br.readLine();
        String line3 = br.readLine();

        int a = Integer.parseInt(line1);
        int b = Integer.parseInt(line2);
        int c = Integer.parseInt(line3);
        //计算出结果
        int d = c * a + c * (c - 1) * b / 2;

        //发送给客户端
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write(String.valueOf(d));
        bw.newLine();
        bw.flush();

        s.close();
    }
}
