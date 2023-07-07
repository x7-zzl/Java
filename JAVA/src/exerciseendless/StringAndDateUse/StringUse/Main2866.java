package exerciseendless.StringAndDateUse.StringUse;
/**
 * 2866: kksk
 * 题目描述
 这道题目很简单，就是看看谁快，请你输出N次kksk
 输入
 多实例。
 第一行一个整数T（表示样例数量，1<=T<=20)
 之后T行，每行一个整数N，（1<=N<=10）
 输出
 每个样例包含N行，每行都是“kksk”（不含引号）

 */
import java.util.Scanner;

public class Main2866 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        StringBuilder sb=new StringBuilder();
        String a="kksk";
        for(int i=0;i<n;i++) {
            sb.append(a);
        }

        int k=in.nextInt();
        for(int i=0;i<k;i++) {
            System.out.println(sb.toString());
        }


    }

}