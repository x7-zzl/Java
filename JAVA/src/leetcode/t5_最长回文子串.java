package leetcode;

import java.util.Arrays;

/*给你一个字符串 s，找到 s 中最长的回文子串。

        示例 1：

        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：

        输入：s = "cbbd"
        输出："bb"


        提示：

        1 <= s.length <= 1000
        s 仅由数字和英文字母组成*/
public class t5_最长回文子串 {
    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String[] split = s.split("");
        System.out.println(Arrays.toString(split));

        return s;
    }
}
