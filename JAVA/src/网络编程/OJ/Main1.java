package 网络编程.OJ;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int sum = 0;
        int T=in.nextInt();
        for (int i=1;i<=T;i++)
        {

            int n =in.nextInt();
            for (int j=1;j<=n;j++)
            {
                sum+=j;
            }
            System.out.println(sum);
            sum=0;
        }
    }
}
