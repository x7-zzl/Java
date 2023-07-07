package 网络编程.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPReceive {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket=new DatagramSocket(5000);  //接收端端口
        //死循环实现持续接受数据
        while (true){
            //字节长度为1024
            byte b[]=new byte[1024];
            //创建数据，并把数据打包
            DatagramPacket packet=new DatagramPacket(b,b.length);

            //调用DatagramPacket的对象接受数据
            socket.receive(packet);
            System.out.println("接收到的数据是"+new String(packet.getData(),0,packet.getLength()));
//          socket.close();
        }




    }
}
