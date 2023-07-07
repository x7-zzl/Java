package 网络编程.tcpexercise;
//客户端：数据来自文本文件，接收服务器发反馈

import java.io.*;
import java.net.Socket;

public class tcp5 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        //封装文本文件的数据
        BufferedReader br = new BufferedReader(new FileReader("D:\\IntelliJ IDEA 2021.1.2\\网络编程\\src\\OJ\\Main3.java"));
        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //结束标记
        socket.shutdownOutput();
        //接收反馈
        BufferedReader brkehu = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String data = brkehu.readLine();//等待读取数据
        System.out.println("服务器的反馈：" + data);
        br.close();
        bw.close();
        socket.close();
    }
}

