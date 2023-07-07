package 网络编程.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=br.read();
//        Scanner scan = new Scanner(System.in);
//        int n=scan.nextInt();
        int score;
        int s1=0,s2=0;
        int p1=0,p2=0;
        for(int i=0;i<n;i++){
            score=br.read();
//            score=scan.nextInt();
            if(score>=60){
                s1++;
            }
            if(score>=85){
                s2++;
            }
        }

        p1=(int) ((s1*1.0/n+0.005)*100);
        p2=(int) ((s2*1.0/n+0.005)*100);
        System.out.println(p1+"%");
        System.out.println(p2+"%");
//        br.close();
    }
}