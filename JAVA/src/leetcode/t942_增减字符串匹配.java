package leetcode;

import java.util.Arrays;

/*由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:

        如果perm[i] < perm[i + 1]，那么s[i] == 'I'
        如果perm[i] > perm[i + 1]，那么 s[i] == 'D'
        给定一个字符串 s ，重构排列perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
        示例 1：

        输入：s = "IDID"
        输出：[0,4,1,3,2]
        示例 2：

        输入：s = "III"
        输出：[0,1,2,3]
        示例 3：

        输入：s = "DDI"
        输出：[3,2,0,1]*/
public class t942_增减字符串匹配 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));

    }

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] a = new int[n + 1];
        //I++,D--
        int start = 0, end = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                a[i] = start++;
            } else if(s.charAt(i)=='D'){
                a[i] = end--;
            }
        }
        a[n] = start;
        return a;
    }
}
