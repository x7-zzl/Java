package exerciseendless.StringAndDateUse.StringUse;

import java.util.Scanner;

//节省空间，提升效率
//利用StringBuilder进行字符串翻转
public class StringBuilderreverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要翻转的字符串内容：");
        String s = scan.nextLine();
        System.out.println(MyReverse(s));

    }

    public static String MyReverse(String s) {
        //把string s 转换为StringBuilder类型
        StringBuilder sb = new StringBuilder(s);
        //翻转方法
        sb.reverse();
        //字符串拼接
        //StringBuilder转为String
        String ss = sb.toString();
        return ss;
        //匿名内部类实现
        //  return new StringBuilder(s).reverse().toString();
    }
}
