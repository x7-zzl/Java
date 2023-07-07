package 网络编程.社区党群服务中心管理系统;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servletSockettest {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("服务器启动！");
         Socket s = ss.accept();
        boolean b = true;
        InputStream is = s.getInputStream();
        //服务器把输入放入线程里面执行，不会影响主线程的接收信息功能
        Thread t = new Thread(){
            OutputStream os = s.getOutputStream();
            Scanner sc  = new Scanner(System.in);
            @Override
            public void run() {
                // TODO Auto-generated method stub
                boolean b = true;
                while(b){
                    try {
                        System.out.print("服务器输入：");
                        os.write(sc.next().getBytes());
                        os.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        while(b){
            byte[] bt = new byte[1024];
            int length = is.read(bt);
            String str = new String(bt,0,length);
            System.out.println("\t\t\t"+str+"：客户端");
        }


        is.close();
        s.shutdownInput();
        s.close();
        ss.close();

    }
}