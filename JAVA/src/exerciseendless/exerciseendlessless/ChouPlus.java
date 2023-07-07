package exerciseendless.exerciseendlessless;
//抽奖
import java.util.Random;
import java.util.Scanner;

public class ChouPlus {
    public static void main(String[] args) {
        int i=1;   //声明变量用来统计循环次数
        int flag=0;//中奖后用来输出语句"你中奖了！"
        here:do {        //若用户中奖，则跳出此循环
            int x1, x2, x3, x4, x5;   //声明5个变量用来存放系统随机生成的1~16的整数
            int g1, g2, g3, g4, g5;   //声明5个变量用来存放用户输入的号码
            Random guess = new Random(); //实例化Random对象，用于产生随机数
            x1 = 1 + guess.nextInt(16);
            x2 = 1 + guess.nextInt(16);
            x3 = 1 + guess.nextInt(16);
            x4 = 1 + guess.nextInt(16);
            x5 = 1 + guess.nextInt(16);
            Scanner input = new Scanner(System.in);
            System.out.println("这是您第"+i+"次抽奖！");
            System.out.println("请您抽奖 ");
            System.out.println("请输入第1个号码<数字:1~16>");
            g1 = input.nextInt();
            System.out.println("请输入第2个号码<数字:1~16>");
            g2 = input.nextInt();
            System.out.println("请输入第3个号码<数字:1~16>");
            g3 = input.nextInt();
            System.out.println("请输入第4个号码<数字:1~16>");
            g4 = input.nextInt();
            System.out.println("请输入第5个号码<数字:1~16>");
            g5 = input.nextInt();
            int count = 0; //声明一个变量用来存放出现号码一致情况的次数
            if (g1 == x1)
                count++;
            if (g2 == x2)
                count++;
            if (g3 == x3)
                count++;
            if (g4 == x4)
                count++;
            if (g5 == x5) ;
            count++;
            if(count==3||count==4||count==5){
                flag=1; //用来统计用户是否中奖
               break here; //跳出本程序中的do while循环
            }
            if(count==2||count==1||count==0){
                System.out.println("你此次未中奖，不要灰心！");
                i++;//循环次数加1
            }
        } while (i <= 5);
        if(flag==1)
            System.out.println("你中奖了！");
        else
            System.out.println("今天你未中奖，请下次再来！");
    }
        }



