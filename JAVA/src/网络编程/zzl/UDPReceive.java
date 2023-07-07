package 网络编程.zzl;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {
    public static void main(String[] args) throws IOException {

        DatagramSocket s=new DatagramSocket(10010);  //接收端端口
        //字节长度为1024
        byte[ ]b=new byte[1024];
        //创建数据，并把数据打包
        DatagramPacket p=new DatagramPacket(b,b.length);

        //调用DatagramPacket的对象接受数据
        s.receive(p);
        //byte[].getData()返回数据缓冲区
        byte[] data=p.getData();
        //获取字节长度
        //节省空间，从0到数组字节长度，避免浪费空间
        String string=new String(data,0,p.getLength());
//        String string=new String(data);
        System.out.println("数据是"+string);
        //关闭
        s.close();
    }
}
