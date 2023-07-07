package exerciseendless.exerciseendlessless;
import java.util.Scanner;
public class 任意数之和 {
    public static void main(String[] args) {
        double x=0,sum=0;
        int i=0;
        Scanner input =new Scanner(System.in);
        System.out.println("请输入多个数，每输入一个数后enter或tab或空格确认");
        System.out.println("输入一个非数字符号结束输入操作");
        while(input.hasNextDouble()) {//hasNextDouble()方法用来判断是否为double型
            x=input.nextDouble();//获取数据
            sum+=x;
            i++;
        }
        System.out.println("共输入"+i+"个数，其和为:"+sum);
    }
}