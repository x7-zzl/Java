package 算法很美.P5字符串.kmp算法;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class 暴力匹配 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("原串:");
        String s = scan.nextLine();
        System.out.println("匹配串:");
        String p = scan.nextLine();
        System.out.println(indexOf(s, p));
        System.out.println(s.indexOf(p));
    }

    //暴力解法
    //s是原串，p是匹配模式
    //返回p字符串在s字符串中第一次出现的位置下标
    private static int indexOf(String s, String p) {
        int i = 0;
        int temp = i;
        int j = 0;


        while (temp < s.length()) {
            if (s.charAt(temp) == p.charAt(j)) {
                temp++;
                j++;
                if (j == p.length()) {
                    return i;
                }
            } else {
                i++;
                temp = i;
                j = 0;
            }
        }

        return -1;
    }
}
