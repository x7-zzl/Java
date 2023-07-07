package 网络编程.tcpexercise;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;

    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //解决名称冲突问题
            int count = 0;
            File file = new File("D:\\IntelliJ IDEA 2021.1.2\\网络编程\\src\\OJ\\t868_二进制间距[" + count + "].txt");
            while (file.exists()) {
                count++;
                file = new File("D:\\IntelliJ IDEA 2021.1.2\\网络编程\\src\\OJ\\t868_二进制间距[" + count + "].txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));


            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();

                //给出反馈
                BufferedWriter bwserver = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                bwserver.write("文件上传成功");
                bwserver.newLine();
                bwserver.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
