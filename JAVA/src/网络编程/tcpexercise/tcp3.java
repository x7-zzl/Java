package 网络编程.tcpexercise;

import java.io.*;
import java.net.Socket;

public class tcp3 {
    public static void main(String[] args) throws IOException {

        Socket socket= new Socket("10.62.48.48",12345);
        //从键盘中录入数据
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
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
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        socket.close();
    }
}
