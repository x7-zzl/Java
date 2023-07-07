package 网络编程.tcpexercise;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//客户端：发送数据，接收服务器反馈
public class tcp1 {
    public static void main(String[] args) throws IOException {
        //Socket(String host, int port),创建流套接字并将其连接到指定主机上的指定端口号。
        //创建Socket对象
        Socket socket=new Socket(InetAddress.getLocalHost(),12345);
        //OutputStream getOutputStream()返回此套接字的输出流。
        OutputStream os=socket.getOutputStream();
        os.write("hello,tcp,i will carry you".getBytes(StandardCharsets.UTF_8));

        //接收服务器反馈
        InputStream in=socket.getInputStream();
        byte[] b=new byte[1024];
        int length=in.read(b);
        String data=new String(b,0,length);
        System.out.println("客户端："+data);

        //void close()关闭此套接字。
        socket.close();
    }
}
