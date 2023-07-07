package 多线程.shiyan;
import java.util.Scanner;

public class Bank {
    int yue = 2000000;
    public synchronized void make() {//制作面包
        System.out.println("存钱");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        yue = yue + a;
        System.out.println(Thread.currentThread().getName() + "余额" + yue + "块");//获取线程名称
    }
    public synchronized void sell() {//售卖面包
        if (yue > 0) {
            if (Thread.currentThread().getName().equals("ATM")) {
                System.out.println("ATM取款");
            } else {
                System.out.println("Counter取款");
            }
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            yue = yue - a;
            System.out.println(Thread.currentThread().getName() + "余额" + yue + "块");//获取线程名称
        } else {
            System.out.println("没钱");
            System.exit(0);
        }
    }
}

class Test1 implements Runnable {
    private Bank bank;

    public Test1(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {//实现方法
        while (true)//死循环，使程序一直运行
        {
            if (Thread.currentThread().getName().equals("存钱"))//通过获取线程的名称来判断使用对应的方法
            {
                bank.make();
                break;
            } else
            { bank.sell();
            break;}
        }

    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Test1 t = new Test1(bank);

        Thread t1 = new Thread(t, "存钱");//线程名称
        Thread t2 = new Thread(t, "ATM");
        Thread t3 = new Thread(t, "Counter");

        t1.start();
        t2.start();
        t3.start();//启动线程
    }
}
