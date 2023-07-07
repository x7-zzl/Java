package 多线程.shiyan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int  n=input.nextInt();
        int max=0;
        String b=Integer.toString(n,2);//进制转换
        System.out.println(b);
        for (int i=0;i<=n;i++)
        {
            if(max<i)
            {
                max=i;
            }
        }
        System.out.println("最大值为"+max);
    }
}
