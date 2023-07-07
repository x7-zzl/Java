package leetcode;
/*给定正整数 k，你需要找出可以被 k整除的、仅包含数字 1 的最 小 正整数 n的长度。
        返回 n的长度。如果不存在这样的 n，就返回-1。
        注意： n不符合 64 位带符号整数。*/

public class t_1015可被K整除的最小整数 {
    public static void main(String[] args) {

    }

    public static int smallestRepunitDivByK(int k) {
        int i=1;

        while (i<=1000000) {
            if (onlyContains(i)&&i%k==0) {
                return i;
            }
            i=i*10+1;
        }

        return -1;
    }


    public static boolean onlyContains(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '1') {
                return false;
            }
        }
        return true;
    }

}
