package 算法很美.P2递归;

import java.util.Scanner;

public class 斐波那契 {
    public static void main(String[] args) {
        System.out.println("输入斐波那契数列的项数:");
        int n=new Scanner(System.in).nextInt();
        System.out.println(f(n));

        System.out.println("<------------------->");
        int f1=1,f2=1;
        int f3=0;
        if(n==1||n==2){
            f3=1;
        }else {
            for (int i = 0; i < n-2; i++) {
                f3=f1+f2;
                f1=f2;
                f2=f3;
            }
        }

        System.out.println(f3);
    }
    static int f(int n){
        if(n==1||n==2){
            return 1;
        }
        return f(n-1)+f(n-2);
    }
}
