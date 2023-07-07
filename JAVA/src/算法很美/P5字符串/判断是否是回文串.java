package 算法很美.P5字符串;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class 判断是否是回文串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一段字符串:");
        String str = in.nextLine();
        System.out.println(isPalindromeString(str));
    }

    public static boolean isPalindromeString(String str) {
        if (str.equals("")) {
            return true;
        }
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
