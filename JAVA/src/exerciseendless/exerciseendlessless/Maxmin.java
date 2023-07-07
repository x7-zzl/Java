package exerciseendless.exerciseendlessless;
//求三个数之间的最大值和最小值
import java.util.Scanner;

public class Maxmin {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int max,min;
        int x,y,z;
        Scanner input=new Scanner(System.in);
        System.out.println("请分别输入x,y,z的值:");
        x=input.nextInt();
        y=input.nextInt();
        z=input.nextInt();
        if(x>y)
            max=x;
        else
            max=y;
        if(z>max)
            max=z;
        System.out.println("最大值是:"+max);
        min=x<y?x:y;
        min=z<min?z:min;
        System.out.println("最小值是；"+min);


    }

}
