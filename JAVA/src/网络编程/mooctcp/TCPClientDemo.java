package 网络编程.mooctcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
使用基于TCP的网络编程方法，完成远程计算等差数列的前n项和功能。
（1）客户端将一等差数列的首项a1，公差d和项数n发送给服务器；
（2）服务器端接收到数据后对接收到的数据进行解析，将前n项和的计算结果发送给客户端；
（3）客户端收到后输出到控制台。
 */
public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        Scanner in = new Scanner(System.in);
        //输入3个数
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //换行输入3个数
        bw.write(String.valueOf(a));
        bw.newLine();
        bw.write(String.valueOf(b));
        bw.newLine();
        bw.write(String.valueOf(c));
        bw.newLine();
        bw.flush();

        //接收服务器的反馈
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(Integer.parseInt(line));
        socket.close();

    }
}
