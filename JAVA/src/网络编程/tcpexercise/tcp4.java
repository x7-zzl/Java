package 网络编程.tcpexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp4 {
    public static void main(String[] args) throws IOException {
        //ServerSocket(int port),创建绑定到指定端口的服务器套接字
        ServerSocket ss=new ServerSocket(12345);

        //Socket accept(),侦听要连接到此套接字并接受它。
        Socket s=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while((line=br.readLine())!=null)
        {
            System.out.println(line);
        }
        ss.close();
    }
}
