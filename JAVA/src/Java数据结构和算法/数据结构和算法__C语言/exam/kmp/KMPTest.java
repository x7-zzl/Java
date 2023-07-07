package Java数据结构和算法.数据结构和算法__C语言.exam.kmp;

import java.util.Arrays;

public class KMPTest {
    public static void main(String[] args) {
        String s1 = "nametamakonajisanightmareyuhankoutoumi";
        String s2 = "najisa";

        System.out.println(index(s1, s2));
    }

    public static int index(String s1, String s2) {
        int[] next = new int[s2.length()];
        getNext(next,s2);
        System.out.println(Arrays.toString(next));

        int i = 0,j=0;
        while (i<s1.length()&&j<s2.length()){
            if(j==-1||s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==s2.length()){
            return i-j+1;
        }else {
            return -1;
        }

    }

    public static void getNext(int[] next, String s2) {
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < s2.length() - 1) {
            if (j == -1 || s2.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }


    }
}
