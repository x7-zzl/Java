package 网络编程.mooctcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
使用基于TCP的网络编程方法，完成远程小写转换和校验功能：
（1）客户端键盘录入几个字符，发送到服务器端。
（2）服务器端将接收到的字符进行小写处理（即将所有字母转化为小写），并向客户端发出转换后的字符串作为响应。
（3）客户端对收到的字符串进行处理校验。如果校验成功，返回“处理成功”给服务器作为响应，
并将其保存到character.txt文件中；否则返回“处理错误”给服务器作为响应。
 */
public class TCPSEND {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        //客户端键盘录入几个字符，发送到服务器端。
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(String.valueOf(a));
        bw.newLine();
        bw.flush();

        //客户端对收到的字符串进行处理校验。
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        //如果校验成功，返回“处理成功”给服务器作为响应， 否则返回“处理错误”给服务器作为响应。
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isLowerCase(c)) {
                bw2.write("处理成功");
                bw2.newLine();
            } else bw2.write("处理错误");
            bw2.newLine();

        } bw2.flush();

        //并将其保存到character.txt文件中；
        File file = new File("D:\\umr\\character.txt");
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(file));
        bw1.write(line);
        bw1.newLine();
        bw1.flush();

        socket.close();
    }
}