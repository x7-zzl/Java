package 加减法口算习题.Version1;

import java.util.Random;

//产生并逐行输出50道100以内的加减法口算题
public class Main {
    public static void main(String[] args) {
        int m , n , flag ;
        char sign = '+';
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            flag = random.nextInt(2);
            m = random.nextInt(101);
            n = random.nextInt(101);
            if (flag == 1) {
                sign = '+';
            } else {
                sign = '-';
            }
            System.out.println(""+(i+1)+":\t"+m+sign+n+"=");
        }
    }
}
