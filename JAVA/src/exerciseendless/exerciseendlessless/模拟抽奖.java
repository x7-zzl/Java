package exerciseendless.exerciseendlessless;
import java.util.Scanner;
import java.util.Random;
public class 模拟抽奖 {
    public static void main(String[] args){
        int x1,x2,x3,x4,x5;   //声明5个变量用来存放系统随机生成的1~16的整数
        int g1,g2,g3,g4,g5;   //声明5个变量用来存放用户输入的号码
        Random guess=new Random(); //实例化Random对象，用于产生随机数
        x1=1+ guess.nextInt(16);
        x2=1+ guess.nextInt(16);
        x3=1+ guess.nextInt(16);
        x4=1+ guess.nextInt(16);
        x5=1+ guess.nextInt(16);
        Scanner input=new Scanner(System.in);
        System.out.println("请您抽奖 ");
        System.out.println("请输入第1个号码<数字:1~16>");
        g1=input.nextInt();
        System.out.println("请输入第2个号码<数字:1~16>");
        g2=input.nextInt();
        System.out.println("请输入第3个号码<数字:1~16>");
        g3=input.nextInt();
        System.out.println("请输入第4个号码<数字:1~16>");
        g4=input.nextInt();
        System.out.println("请输入第5个号码<数字:1~16>");
        g5=input.nextInt();
        int count=0; //声明一个变量用来存放出现号码一致情况的次数
        if(g1==x1)
            count++;
        if(g2==x2)
            count++;
        if(g3==x3)
            count++;
        if(g4==x4)
            count++;
        if(g5==x5);
             count++;
             switch(count){
                 case 5:
                     System.out.println("恭喜您中了一等奖！");break;
                 case 4:
                     System.out.println("恭喜您中了二等奖！");break;
                 case 3:
                     System.out.println("恭喜您中了三等奖！");break;
                 default:
                     System.out.println("很遗憾，您未中奖！");
             }

    }

}
