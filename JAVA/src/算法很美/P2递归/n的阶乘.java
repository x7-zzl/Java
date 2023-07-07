package 算法很美.P2递归;

import java.util.Scanner;

public class n的阶乘 {
    public static void main(String[] args) {
        int n=new Scanner(System.in).nextInt();

        System.out.println(f(n));
    }
    static int f(int n){
        if(n==1){
           return 1;
        }
        return n*f(n-1);
    }
}
