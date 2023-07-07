package 网络编程.mooctcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class TCPEG2 {

    public static void main(String[] args) throws IOException {

        //1.创建服务器套接字，并指定端口号

        ServerSocket listener=new ServerSocket(8888);

        System.out.println("服务端已启动...");

        //2 接受客户端连接，并返回客户端套接字

        //返回的是客户端套字

        Socket socket = listener.accept();

        //3. 获取输入输出流

        //4 处理

        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line=br.readLine();

        // 以，为分隔符分割字符串

        String[] input = line.split(",");

        int a1 = Integer.parseInt(input[0]);

        int d = Integer.parseInt(input[1]);

        int n = Integer.parseInt(input[2]);

        double result = n*a1+n*(n-1)/d;

//        System.out.println("首项为："+a1+"公差为："+d+"项数为："+n+"，的前n项和为：" +result);

        //服务端回复客户端

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter( socket.getOutputStream()));

        bw.write("首项为："+a1+",公差为："+d+",项数为："+n+",的前n项和为：" +result);

        bw.newLine();

        bw.flush();

        // 5 关闭

        bw.close();

        br.close();

        socket.close();

        listener.close();

    }

}
