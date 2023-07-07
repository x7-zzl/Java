package 算法很美.P9动态规划;

import java.util.Scanner;

public class 斐波那契数列 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int n = new Scanner(System.in).nextInt();

        System.out.println(f(n));

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1 + "ms");
    }

    //使用动态规划解决
    private static int f(int n) {
        return f1(n, new int[n + 1]);
    }

    private static int f1(int n, int[] m) {
        if (n == 0 || n == 1) return n;
        if (m[n] == 0) {
            m[n] = f1(n - 1, m) + f1(n - 2, m);
        }

        return m[n];
    }

}
