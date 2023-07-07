package 网络编程.shiyan;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


/*1. 使用基于TCP的网络编程方法，完成远程注册与登录模块，即客户端发送相关请求，服务器端接收请求处理并返回响应消息。
要求图形界面，数据库保存注册信息。
 */
public class TCPserverdemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        ServerSocket ss = new ServerSocket(12345);
        while (true) {
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line1 = br.readLine();
            String line2 = br.readLine();
            String line3 = br.readLine();
            System.out.println("用户名：" + line1);
            System.out.println("密码：" + line2);


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1", "root", "yswysyydxj");

            if (line3.equals("登录")) {
                String sql = "select * from users where name=? and mima=?";
                PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ps.setString(1, line1);
                ps.setString(2, line2);

                ResultSet rs = ps.executeQuery();
                //发送给客户端
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String s1 = "登录成功";
                String s2 = "登录失败(请检查您输入的信息是否正确)";
                if (rs.next() && line2.equals(rs.getString(2))) {
                    bw.write(s1);
                    bw.newLine();
                } else bw.write(s2);
                bw.newLine();
                bw.flush();

                rs.close();
                ps.close();
                conn.close();

            }
            //注册
            if (line3.equals("注册")) {
                String s1 = "注册成功";
                String s2 = "注册失败(用户名已存在)";
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                try {
                    String sql = "insert into users values (?,?)";
                    PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ps.setString(1, line1);
                    ps.setString(2, line2);
                    ps.executeUpdate();
                    //发送给客户端

                    bw.write(s1);
                    bw.newLine();
                    bw.flush();
                    ps.close();
                    conn.close();

                } catch (Exception exception) {
                    System.out.println(exception);
                    bw.write(s2);
                    bw.newLine();
                    bw.flush();
                }

            }

            socket.close();
        }

    }
}
