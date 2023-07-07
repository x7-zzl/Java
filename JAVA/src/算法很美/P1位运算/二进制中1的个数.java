package 算法很美.P1位运算;
//题3:求某个数二进制中”1“的个数

import java.util.Scanner;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
//        使用Integer.parseInt()实现二进制转换为十进制
        //Integer.toString实现十进制转换为二进制
        System.out.println("二进制为:" + Integer.toString(n, 2));

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == (1 << i)) {
                count++;
            }
            System.out.println(count);
        }
        System.out.println(count);


        System.out.println("=========================");
        count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1) {
                count++;
            }

        }
        System.out.println(count);
        System.out.println("=========================");
        count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        System.out.println(count);

    }
}
