package exerciseendless.exerciseendlessless;

//输入月份的数字,显示相应的季节
import java.util.Scanner;
public class Seasontest {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String season;
        int month;
        Scanner input=new Scanner(System.in);
        System.out.println("请输入月份的数字:");
        month = input.nextInt();
        if(month==3||month==4||month==5)
            season="春季";
        else if(month==6||month==7||month==8)
            season="夏季";
        else if(month==9||month==10||month==11)
            season="秋季";
        else if(month==12||month==1||month==2)
            season="冬季";
        else
            season="不在一年四季之中";
        System.out.println(season);
    }

}
