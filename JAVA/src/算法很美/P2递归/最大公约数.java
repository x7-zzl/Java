package 算法很美.P2递归;

import java.util.Scanner;

public class 最大公约数 {
    static int f(int a,int b){
        if(b==0)
            return a;
        return f(b,a%b);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int m=a*b;
        System.out.println(f(a,b));

        System.out.println("<-------------->");
//            辗转相除法
//            a对b取余，b赋值给a 余数赋值给b，，直到 b == 0
        int r = 1;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        System.out.println(a);
        System.out.println("最小公倍数；"+m/a);
        System.out.println("<-------------->");
        //0和任何非零的数的约数都是这个非零的数
        //耗时间
        if (a == 0 || b == 0) {
            System.out.print(a == 0 ? b : a);//输入的数a,b其中有0的情况
        } else {
            for (int i = 2; i <= a && i <= b; i++) {
                if (a % i == 0 && b % i == 0) {//遍历最后出现的是最大的
                    r = i;
                }
            }
            System.out.println(r);
        }
    }
}
