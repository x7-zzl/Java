package 网络编程.mooctcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPRECEIVE {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line1 = br.readLine();

        //服务器端将接收到的字符进行小写处理（即将所有字母转化为小写），并向客户端发出转换后的字符串作为响应。
        String line2=line1.toLowerCase();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write(line2);
        bw.newLine();
        bw.flush();

        //返回“处理成功”给服务器作为响应， 否则返回“处理错误”给服务器作为响应
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line3 = br1.readLine();
        System.out.println(line3);
        s.close();
    }
}
