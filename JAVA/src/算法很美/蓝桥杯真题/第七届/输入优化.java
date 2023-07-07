package 算法很美.蓝桥杯真题.第七届;

import java.io.*;
import java.util.Scanner;

public class 输入优化 {
    public static void main(String[] args) throws IOException {
        long t1=System.currentTimeMillis();
//        StreamTokenizer scanner=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        scanner.nextToken();
//        int n= (int) scanner.nval;//3348

//        Scanner scanner = new Scanner(new BufferedInputStream(System.in));//2555
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));//3051
        Scanner scanner=new Scanner(System.in);//3459
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                       n++;
                    }
                }
            }
        }
        System.out.println(n);
        long t2=System.currentTimeMillis();
        System.out.println(t2-t1+"ms");
    }
}
