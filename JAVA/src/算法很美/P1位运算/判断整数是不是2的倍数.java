package 算法很美.P1位运算;

import java.util.Scanner;

public class 判断整数是不是2的倍数 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();
        if(((n-1)&n)==0){
            System.out.println(n+"是2的倍数");
        }
        else
            System.out.println(n+"不是2的倍数");
        System.out.println("----------------------");
        if(n%2==0||n==1){
            System.out.println(n+"是2的倍数");
        }
        else  System.out.println(n+"不是2的倍数");
    }
}
