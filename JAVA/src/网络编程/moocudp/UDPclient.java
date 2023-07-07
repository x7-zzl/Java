package 网络编程.moocudp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
//使用基于TCP的网络编程方法，完成远程计算等差数列的前n项和功能。
//（1）客户端将一等差数列的首项a1，公差d和项数n发送给服务器；
//（2）服务器端接收到数据后对接收到的数据进行解析，将前n项和的计算结果发送给客户端；
//（3）客户端收到后输出到控制台。
 */
public class UDPclient {
    //构造一个含有三个参数的方法，存放三个整数，将一等差数列的首项a1，公差d和项数n封装
    public static byte[] convert(int a, int b, int c) throws IOException {
        byte[] data = null;

        //写入数据
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //使用DataOutputStream流输入整数
        DataOutputStream dos = new DataOutputStream(bos);
        //首项a1
        dos.writeInt(a);
        //公差d
        dos.writeInt(b);
        //项数n
        dos.writeInt(c);
        dos.flush();

        //获取数据
        data = bos.toByteArray();
        //关闭
        dos.close();
        //返回数据
        return data;
    }


    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner in = new Scanner(System.in);
        //输入3个整数，等差数列的首项a1，公差d和项数n
        System.out.println("请输入等差数列的首项a1，公差d和项数n：");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        //调用convert()方法传递参数
        byte[] b1 = convert(a, b, c);
        DatagramPacket packet = new DatagramPacket(b1, b1.length, InetAddress.getByName("localhost"), 9999);
        datagramSocket.send(packet);
        datagramSocket.close();

        //接收服务器的反馈
        byte[] b2=new byte[1024];
        DatagramSocket datagramSocket1 = new DatagramSocket(12345);
        DatagramPacket packet1=new DatagramPacket(b2,b2.length);

        //调用DatagramPacket的对象接受数据
        datagramSocket1.receive(packet1);
        System.out.println("接收到的数据是"+new String(packet1.getData(),0,packet1.getLength()));

        datagramSocket1.close();

    }


}
