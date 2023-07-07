package 算法很美.P2递归;

import java.util.Scanner;

//小白正在上楼梯，楼梯有n阶台阶，小白一次可以上1，2，3阶
//实现一个方法,计算小白有多少种走完楼梯的方式
public class 小白上楼梯 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("一共有多少个台阶:");
            int n = scanner.nextInt();
            System.out.println(f(n));
        }

    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }
        return f(n - 1) + f(n - 2) + f(n - 3);
    }
}
