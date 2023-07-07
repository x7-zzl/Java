package 网络编程.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 登录界面
 * 这里就不设密码了。
 */
public class ClientLogin extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel jp1,jp2,jp3,jp4;
    private JLabel jl_userName,jl_ip,jl_port;
    private JTextField jtf_userName,jtf_ip,jtf_port;
    private JButton btn_login;
    public static String name = null;
    public static String ip = null;
    public static int port = 0;

    public ClientLogin() throws UnknownHostException
    {
        this.setLayout(new GridLayout(4,1));

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jl_userName = new JLabel("用户名:");
        jl_userName.setForeground(Color.white);
        jl_userName.setFont(new Font("宋体", Font.BOLD, 22));
        jl_ip = new JLabel("IP地址:");
        jl_ip.setForeground(Color.white);
        jl_ip.setFont(new Font("宋体", Font.BOLD, 22));
        jtf_userName = new JTextField(12);
        jtf_userName.setText("杨正");	//默认使用姓名杨正
        jtf_ip = new JTextField(12);
        jtf_ip.setText(InetAddress.getLocalHost().getHostAddress());	//默认IP地址
        jl_port = new JLabel("端口号:");
        jl_port.setForeground(Color.white);
        jl_port.setFont(new Font("宋体", Font.BOLD, 22));
        jtf_port = new JTextField(12);
        jtf_port.setText(Integer.toString(9999));
        btn_login = new JButton("登录");

        this.setTitle("QQ登录界面");
        this.setBounds(750, 400, 400, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp1.add(jl_userName);
        jp1.add(jtf_userName);
        jp2.add(jl_ip);
        jp2.add(jtf_ip);
        jp3.add(jl_port);
        jp3.add(jtf_port);
        jp4.add(btn_login);

        //添加背景图片
        ImageIcon icon=new ImageIcon("login.jpg");
        //Image im=new Image(icon);
        //将图片放入label中
        JLabel label=new JLabel(icon);
        //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        //必须设置为透明的。否则看不到图片
        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);

        //获取窗口的第二层，将label放入
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        //给登录按钮添加监听事件
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = jtf_userName.getText().toString();
                ip = jtf_ip.getText().trim();
                port = Integer.parseInt(jtf_port.getText().toString());

                //点击登录后，客户端连接服务器
                try {
                    Client.connectServer();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //隐藏当前窗口
                //setVisible(false);// 本窗口隐藏
                dispose();	//关闭
                //打开客户端
                new ClientFrame();
            }
        });
    }
}

