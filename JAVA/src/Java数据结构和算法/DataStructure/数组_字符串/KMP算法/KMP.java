package Java数据结构和算法.DataStructure.数组_字符串.KMP算法;

import java.util.Scanner;

//kmp算法
//输入两个字符串，返回模式串第一次出现在主串的位置
public class KMP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        System.out.println(indexOf(s, p));
    }

    public static int indexOf(String s, String p) {
        int i = 0;
        int j = 0;

        int[] next = new int[p.length()];
        getNext(p, next);

        while (i < s.length() && j < p.length()) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == p.length())
            return i - j;
        else
            return -1;
    }

    private static void getNext(String p, int[] next) {
        int j = 0, k = -1;
        next[0] = -1;
        while (j < p.length() - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else k = next[k];
        }

    }


}
