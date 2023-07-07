package 网络编程.tcpexercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//服务器端：接收数据，给出反馈
public class tcp2 {
    public static void main(String[] args) throws IOException {
        //ServerSocket(int port),创建绑定到指定端口的服务器套接字
        ServerSocket ss=new ServerSocket(12345);
        //Socket accept(),侦听要连接到此套接字并接受它。
        Socket s=ss.accept();
        //通过使用Socket来使用InputStream,ServerSocket对象中没有getInputStream()方法
        InputStream in=s.getInputStream();
        byte[] b=new byte[1024];
        int length=in.read(b);
        String data=new String(b,0,length);
        System.out.println("服务器："+data);
        //给出反馈
        OutputStream os=s.getOutputStream();
        os.write("数据已经收到".getBytes(StandardCharsets.UTF_8));
//        s.close();
        ss.close();
    }
}
