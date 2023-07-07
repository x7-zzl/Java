package 算法很美.P1位运算;

import java.util.Scanner;

//将0-1之间的浮点数用二进制表示
public class 题0_1之间浮点数 {
    public static void main(String[] args) {
        System.out.println("请输入一个0-1之间的浮点数");
        double num = new Scanner(System.in).nextDouble();
        StringBuilder sb = new StringBuilder("0.");

        while (num > 0) {
            double r = num * 2;
            if (r >= 1) {
                sb.append("1");
                num = r - 1;
            } else {
                sb.append("0");
                num = r;
            }
            if(sb.length()>34){
                System.out.println("error");
                return;
            }
        }
        System.out.println(sb);
    }
}
