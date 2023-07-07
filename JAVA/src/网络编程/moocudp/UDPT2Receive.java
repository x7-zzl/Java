package 网络编程.moocudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/*
使用基于UDP的网络编程方法，完成远程小写转换和校验功能：
（1）客户端键盘录入几个字符，发送到服务器端。
（2）服务器端将接收到的字符进行小写处理（即将所有字母转化为小写），并向客户端发出转换后的字符串作为响应。
（3）客户端对收到的字符串进行处理校验。如果校验成功，返回“处理成功”给服务器作为响应，
并将其保存到character.txt文件中；否则返回“处理错误”给服务器作为响应。
 */
public class UDPT2Receive {
    public static void main(String[] args) throws IOException {
        //服务器端将接收到的字符进行小写处理（即将所有字母转化为小写），并向客户端发出转换后的字符串作为响应。
        DatagramSocket socket1 = new DatagramSocket(9999);
        byte[] data1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data1, data1.length);
        socket1.receive(packet1);

        String m= new String(packet1.getData(),0,packet1.getLength());
        String n=m.toLowerCase();
        System.out.println("服务器已接收到数据并进行了小写处理:"+n);
        socket1.close();

        //向客户端发出转换后的字符串作为响应
        DatagramSocket socket2=new DatagramSocket();
        byte[] data2=n.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, InetAddress.getByName("localhost"), 12345);
        socket2.send(packet2);
        socket2.close();

        //如果校验成功，服务器接收“处理成功”作为响应，
        //否则，服务器接收“处理错误”作为响应。
        DatagramSocket socket3 = new DatagramSocket(8888);
        byte[] data3 = new byte[1024];
        DatagramPacket packet3 = new DatagramPacket(data3, data3.length);
        socket3.receive(packet3);
        System.out.println(new String(packet3.getData(),0,packet3.getLength()));
        socket3.close();

    }
}
