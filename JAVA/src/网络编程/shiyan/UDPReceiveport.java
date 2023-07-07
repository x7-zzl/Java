package 网络编程.shiyan;

import java.io.IOException;
import java.net.DatagramSocket;

/*
2. 使用基于UDP的网络编程方法，完成多个客户端和服务器间的聊天功能。要求图形界面。
 */
public class UDPReceiveport {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(10010);
        System.out.println("服务器已开启");

        UDPSERVERThread t = new UDPSERVERThread(socket);
        t.start();
    }
}
