package exerciseendless.StringAndDateUse.StringUse;
/*
题目描述
《让子弹飞》里，张麻子拿着枪，对着一众跪下的百姓说，我来鹅城，只办三件事，那就是：
公平！
公平！
还是**的公平！
这一题希望你可以从一堆“justice”（不含引号）找到“yuanwang”（不含引号），并且输出它的位置，如果没有“yuanwang”（不含引号），请输出”None“（不含引号）。
输入
一个整数N（1<=N<=100），代表样例数量
接下来是N行，每行包含一个样例，样例包含“justice”，“yuanwang”，以及空格。每个样例保证'yuanwang'出现的次数小于等于1，并且样例长度小于1000
输出
一个整数（代表‘yuanwang’首字符的位置）或者‘None’（不含引号）
 */
import java.util.Scanner;
public class CountStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str= new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.nextLine();
        }

        for (int i = 0; i < n; i++) {
            int count=0;
            int m = str[i].indexOf("yuanwang");
            String a = "yuanwang";
           if(str[i].contains(a)){
                //获取索引位置，加上寻找的字符长度 ，substring(i)方法截取从此后的所有字符
//                str[i] = str[i].substring(str[i].indexOf(a) + a.length());
                count++;
            }
             if (count == 0)
                System.out.println("None");
             else System.out.println(m);
        }
    }
}

