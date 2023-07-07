package 网络编程.moocudp;
/*
使用基于UDP的网络编程方法，完成远程小写转换和校验功能：
（1）客户端键盘录入几个字符，发送到服务器端。
（2）服务器端将接收到的字符进行小写处理（即将所有字母转化为小写），并向客户端发出转换后的字符串作为响应。
（3）客户端对收到的字符串进行处理校验。如果校验成功，返回“处理成功”给服务器作为响应，
并将其保存到character.txt文件中；否则返回“处理错误”给服务器作为响应。
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPT2Send {
    public static void main(String[] args) throws IOException {
        //客户端键盘录入几个字符，发送到服务器端。
        DatagramSocket socket1 = new DatagramSocket();
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        byte[] b1 = a.getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet1 = new DatagramPacket(b1, b1.length, InetAddress.getByName("localhost"), 9999);
        socket1.send(packet1);
        socket1.close();

        //客户端对收到的字符串进行处理校验
        DatagramSocket socket2 = new DatagramSocket(12345);
        byte[] b2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(b2, b2.length);
        socket2.receive(packet2);
        String line = new String(packet2.getData(), 0, packet2.getLength());
        System.out.println("客户端已接收数据"+line);
        socket2.close();
        //如果校验成功，返回“处理成功”给服务器作为响应，
        //并将其保存到character.txt文件中；否则返回“处理错误”给服务器作为响应。
        boolean flag = true;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isLowerCase(c)) {
            } else
            flag = false;
            break;
        }

        DatagramSocket socket3 = new DatagramSocket();
        byte[] b3 = "处理成功".getBytes();
        byte[] b4 = "处理错误".getBytes();
        DatagramPacket packet3 = null;
        if (flag) {
            packet3 = new DatagramPacket(b3, b3.length, InetAddress.getByName("localhost"), 8888);
            //并将其保存到character.txt文件中；
            File file = new File("D:\\umr\\character.txt");
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(file));
            bw1.write(line);
            bw1.newLine();
            bw1.flush();
            System.out.println("已保存到character.txt文件中");
        } else packet3 = new DatagramPacket(b4, b4.length, InetAddress.getByName("localhost"), 8888);
        socket3.send(packet3);
        socket3.close();
    }
}
