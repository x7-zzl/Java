package 网络编程.tcpexercise;
//接收到的数据写入文本文件，给出反馈，代码用线程封装，为每一个客户端开启一个线程

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp6 {
    public static void main(String[] args) throws IOException {
        //ServerSocket(int port),创建绑定到指定端口的服务器套接字
        ServerSocket ss = new ServerSocket(12345);
        while (true){
            //Socket accept(),侦听要连接到此套接字并接受它。
            Socket s = ss.accept();
            //为每一个客户端开启一个线程
            new Thread(new ServerThread(s)).start();
        }
    }
}
