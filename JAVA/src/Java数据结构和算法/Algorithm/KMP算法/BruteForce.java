package Java数据结构和算法.Algorithm.KMP算法;

import java.util.Scanner;

public class BruteForce {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        System.out.println(indexOf(s, p));
    }

    public static int indexOf(String s, String p) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < p.length()) {

            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == p.length())
            return i - j;
        else
            return -1;
    }
}
