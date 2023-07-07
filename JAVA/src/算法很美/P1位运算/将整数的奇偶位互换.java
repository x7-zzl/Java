package 算法很美.P1位运算;

import java.util.Scanner;

public class 将整数的奇偶位互换 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

//        int ou = n & 0xaaaaaaaa;  //和1010 1010 1010....(32位)作与运算,取得偶数位，其余为0
//        int ji = n & 0x55555555;  //和0101 0101 0101....(32位)作与运算，取得奇数位，其余为0
//        int result = (ou >> 1) ^ (ji << 1);  //偶数位向左移一位，奇数位向右移一位 ，再作异或运算
//        //输出
//        System.out.println("交换前：" + Integer.toString(n, 2));
//        System.out.println("交换后：" + Integer.toString(result, 2));
//        System.out.println(result);

        System.out.println("---------------------------------");
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1; i+=2) {
//            char x = str.charAt(i);
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

    }

}
