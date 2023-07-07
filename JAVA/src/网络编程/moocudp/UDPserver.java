package 网络编程.moocudp;
/*
//使用基于TCP的网络编程方法，完成远程计算等差数列的前n项和功能。
//（1）客户端将一等差数列的首项a1，公差d和项数n发送给服务器；
//（2）服务器端接收到数据后对接收到的数据进行解析，将前n项和的计算结果发送给客户端；
//（3）客户端收到后输出到控制台。
 */

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPserver {
    //构造一个含有三个参数的方法，存放三个整数，将一等差数列的首项a1，公差d和项数n封装
    public static int convert(byte[] data) throws IOException {
        //使用DataOutputStream流输传入三个整数
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        int a = dis.readInt();
        int b = dis.readInt();
        int c = dis.readInt();
        //根据数学知识sum也一定为整数
        int sum = c * a + c * (c - 1) * b / 2;
        dis.close();
        //返回前n项和
        return sum;
    }

    public static void main(String[] args) throws IOException {
        //1.接收端端口
        DatagramSocket socket = new DatagramSocket(9999);
        //2.准备接受容器
        byte[] datastring = new byte[1024];
        //3.封装成包   DatagramPacket(byte buf[], int length)
        DatagramPacket packet = new DatagramPacket(datastring, datastring.length);
        //4.接受数据   （阻塞式接受）
        socket.receive(packet);
        //5.分析数据
        int data = convert(packet.getData());
        System.out.println("已接收到数据，前n项和为"+data);
        socket.close();
        //将结果发送给客户端
        DatagramSocket socket1= new DatagramSocket();
        String line= String.valueOf(data);
        byte[] b=line.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet1=new DatagramPacket(b,b.length,InetAddress.getByName("localhost"),12345);
        socket1.send(packet1);
        //6.释放资源
        socket1.close();
    }
}
