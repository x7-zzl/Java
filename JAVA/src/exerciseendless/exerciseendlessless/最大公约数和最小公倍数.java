package exerciseendless.exerciseendlessless;

import java.util.Scanner;

//求两个数的最大公约数
public class 最大公约数和最小公倍数 {
    //方法一：0和任何非零的数的约数都是这个非零的数
    //耗时间
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int a = input.nextInt();
//        int b = input.nextInt();
//        int r = 1;
//        if(a == 0 || b == 0){
//            System.out.print(a == 0 ? b : a);//输入的数a,b其中有0的情况
//        }
//        else{
//            for ( int i = 2; i <= a && i <= b;i++){
//                if(a % i == 0 && b % i == 0){//遍历最后出现的是最大的
//                    r = i;
//                }
//            }
//            System.out.print(r);
//        }
//    }

    //方法二：辗转相除法
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c=a*b;

        System.out.println(a);

        System.out.println(gcd(a,b));
        System.out.println(c/gcd(a,b));
    }

    public static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
