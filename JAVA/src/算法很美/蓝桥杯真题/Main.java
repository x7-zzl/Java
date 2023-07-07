package 算法很美.蓝桥杯真题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);//输入的前提条件
        String st=in.nextLine();//输入字符串
        long[] a=new long [26];//对应26个字母
        for(int i=0;i<st.length();i++) {//暴力
            a[st.charAt(i)-'A']++;
        }
        long max=0;
        for(int i=0;i<26;i++) {//找出出现次数最大的数值
            max=Math.max(max, a[i]);
        }
        for(int i=0;i<26;i++) {//只要是次数最大的数值，就输出。可能有多个
            if(a[i]==max) {
                System.out.print( (char) ('A'+i));//用char来转换
            }
        }
    }

}
