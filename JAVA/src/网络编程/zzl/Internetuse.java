package 网络编程.zzl;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Internetuse {
    public static void main(String[] args) throws UnknownHostException {
        //确定主机名称的IP地址，主机名称可以是机器名称，也可以是IP地址
        InetAddress address=InetAddress.getByName("10.62.48.162");
        //获取此IP地址的主机名
        String name=address.getHostName();
        //返回IP地址的字符串
        String ip=address.getHostAddress();
        System.out.println("主机名称"+name);
        System.out.println("IP地址"+ip);
    }
}
