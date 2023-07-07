package 网络编程.OJ;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main4G {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###.##");
        double a = scan.nextDouble();
        BigDecimal t = BigDecimal.valueOf(a);
        int n = scan.nextInt();
        BigDecimal k = new BigDecimal("1");
        BigDecimal bi1 = new BigDecimal("10");

        for (int i = 1; i <= n; i++) {
            k = k.multiply(bi1);
        }

        System.out.println(df.format(k.multiply(t)));
    }

}