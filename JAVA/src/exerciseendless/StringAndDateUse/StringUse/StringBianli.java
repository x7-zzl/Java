package exerciseendless.StringAndDateUse.StringUse;
//字符串遍历,统计各种字符出现的次数

import java.util.Scanner;


public class StringBianli {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int small = 0, big = 0, num = 0;
        for (int i = 0; i < a.length(); i++) {

            System.out.print(a.charAt(i) + " ");
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                small++;
            } else if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                big++;
            } else if (a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                num++;
            }
        }
        System.out.println(small);
        System.out.println(big);
        System.out.println(num);
    }
}
