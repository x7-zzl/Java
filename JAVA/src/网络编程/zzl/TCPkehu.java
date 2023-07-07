package 网络编程.zzl;
//客户端：发送数据，接收服务器反馈
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPkehu {
    public static void main(String[] args) throws IOException {
        //Socket(String host, int port),创建流套接字并将其连接到指定主机上的指定端口号。
        //创建Socket对象
        Socket socket=new Socket("10.62.48.48",12345);
        //OutputStream getOutputStream()返回此套接字的输出流。
        OutputStream os=socket.getOutputStream();
        os.write("hello,tcp,i will carry you".getBytes(StandardCharsets.UTF_8));


        //void close()关闭此套接字。
        socket.close();
    }
}
