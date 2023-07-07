package 网络编程.mooctcp;

import java.io.*;
import java.net.Socket;

//客户端
public class TCPEG1 {

    public static void main(String[] args) throws IOException {

        //1.创建客户端套接字,并指定服务器地址和端口号

        Socket socket=new Socket("127.0.0.1",8888);

        //2.获取输入或者输出流

        //客户端是向服务端发消息   输出

        //3.处理

        String str = "1,2,3";

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter( socket.getOutputStream()));

        bw.write(str);

        bw.newLine();

        bw.flush();

        System.out.println("输入内容："+str);

        //接收服务端回复

        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String s = br.readLine();

        System.out.println(s);

        //4.关闭



        br.close();

        bw.close();

        socket.close();

    }

}
