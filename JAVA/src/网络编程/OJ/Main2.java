package 网络编程.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i=1;i<=T;i++)
        {
            int n = Integer.parseInt(br.readLine());
            for (int j=1;j<=n;j++)
            {
                sum+=j;
            }
            System.out.println(sum);
            sum=0;
        }
    }
}

