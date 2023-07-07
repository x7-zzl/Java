package 网络编程.zzl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSend {
    public static void main(String[] args) throws IOException {
       //创建发送端的Socket对象
        //此类表示用于发送和接收数据报数据包的套接字。
        DatagramSocket  datagramSocket=new DatagramSocket();

        //该类表示数据报包。
        //数据报包用于实现无连接分组传送服务。 仅基于该数据包中包含的信息，每个消息从一台机器路由到另一台机器。
        // 从一台机器发送到另一台机器的多个分组可能会有不同的路由，并且可能以任何顺序到达。 包传送不能保证。
        byte b[]="hello,udp，连接成功".getBytes(StandardCharsets.UTF_8);
//        int length=b.length;
//        InetAddress address=InetAddress.getByName("10.62.48.48");
//        int port=10086;
//        DatagramPacket datagramPacket=new DatagramPacket(b,length,address,port);
        //创建数据，并把数据打包
        DatagramPacket datagramPacket=new DatagramPacket(b,b.length,InetAddress.getByName("localhost"),8888);

        datagramSocket.send(datagramPacket);

        //关闭发送端
        datagramSocket.close();
    }
}
