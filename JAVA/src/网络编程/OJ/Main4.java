package 网络编程.OJ;

import java.io.IOException;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) throws IOException {
        long sum=0;
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        for(int i =1; i<=n; i++){
            if(i%3==0||i%5==0||i%7==0){
                sum=sum+i;
            }
        }
        System.out.println(sum%998244353);
    }

}
