package 网络编程.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建发送端的Socket对象
        DatagramSocket socket=new DatagramSocket();
        //从键盘中录入数据
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=bf.readLine())!=null)
        {
/*            if (line.contains("888"))
            {
                int m=line.indexOf("888");
                line=line.substring(0,m);
                break;
            }*/
            if(line.equals("888")){//如果输入数据888跳出循环
                break;
            }
            //创建数据，并把数据打包
            byte[] b=line.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet=new DatagramPacket(b,b.length, InetAddress.getByName("localhost"),10);
            socket.send(packet);
        }
        socket.close();
    }
}
