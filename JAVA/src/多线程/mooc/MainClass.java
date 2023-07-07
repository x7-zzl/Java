package 多线程.mooc;

/*
‍利用Thread或Runnable实现一个多用户的银行取款程序。
为了保证多个用户在对同一账户取钱时数据的一致性，可通过定义静态变量和线程同步两种方式实现。要求：
‍（1）用户可选择使用的取款方式应包含柜台和ATM取款。
‍（2）采用将账号的钱数定义为静态变量的方式实现该程序，每次不同的用户取钱后打印账号余额。
‍（3）采用线程同步的方式实现该程序，每次不同的用户取钱后打印账号余额。
‍（4）分析以上两种多线程程序的区别，为什么要线程同步？。
// */
//
//public class BankDemo {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//        Bank bank=new Bank();
//        while (true){
//            Man man1=new Man(bank);
//            man1.start();
//            Man man2=new Man(bank);
//            man2.start();
//        }
//    }
//}
//
////线程类
//class Man extends Thread{
//    private Bank bank;
//
//    public Man(Bank bank){
//        this.bank=bank;
//    }
//
//    @Override
//    public void run() {
//        bank.getMoney(10);
//    }
//}
//
//
////银行类
//class Bank {
//    private int money=50000;
//    public synchronized boolean getMoney(int num){
//        if (num<0) {
//            //取钱的数目要大于0
//            System.out.println("输入错误！");
//            return false;
//        }else if (num>money||money<0) {
//            //判断余额是否足够
//            System.out.println("余额不足！");
//            return false;
//
//        }else {
//
//            System.out.println("取款："+num+"元,余额为"+(money-num));
//            money-=num;
//            return true;
//        }
//    }
//}
//
//
////public class Drawmoney {
////    Scanner in = new Scanner(System.in);
////    double balance = 10000000;
////
////    public synchronized void Guitai() {//柜台取款
////        System.out.println("你已使用柜台取款，请输入取款金额：");
////        double yue = in.nextDouble();
////        if (balance - yue > 0) {
////            balance = balance - yue;
////            System.out.println("你通过" + Thread.currentThread().getName() + "方式取出" + yue + "元,剩余余额" + balance + "元");//获取线程名称
////
////        } else System.out.println("您的余额不足");
////    }
////
////    public synchronized void ATM() {//ATM取款
////        System.out.println("你已使用ATM取款，请输入取款金额：");
////        double yue = in.nextDouble();
////        if (balance - yue > 0) {
////
////            balance = balance - yue;
////            System.out.println("你通过" + Thread.currentThread().getName() + "方式取出" + yue + "元,剩余余额" + balance + "元");//获取线程名称
////
////        } else System.out.println("您的余额不足");
////    }
////}
////
////class Myrunnable implements Runnable {
////    private Drawmoney drawmoney;
////
////    public Myrunnable(Drawmoney drawmoney) {
////        this.drawmoney = drawmoney;
////    }
////
////    @Override
////    public void run() {
////        while (true){
////            if (Thread.currentThread().getName().equals("Guitai"))//通过获取线程的名称来判断使用对应的方法
////            {
////                drawmoney.Guitai();
////            } else
////                drawmoney.ATM();
////        }
////
////    }
////
////    public static void main(String[] args) {
////        Drawmoney drawmoney = new Drawmoney();
////        Myrunnable t = new Myrunnable(drawmoney);
////        Scanner in = new Scanner(System.in);
////
////            Thread t1 = new Thread(t, "Guitai");
////            t1.start();
////            Thread t2 = new Thread(t, "ATM");
////            t2.start();
////    }
////}
////


class Bank {
    // 假设一个账户有1000块钱
    static int money = 1000;

    // 柜台取钱的方法
    public synchronized void getCounter(int money1) {
       money -= money1;// 取钱后总数减少
        System.out.println("A取走了" + money1 + "还剩下" + Bank.money);
    }

    // ATM取钱的方法
    public synchronized void getATM(int money2) {// 参数是每次取走的钱
       money -= money2;// 取钱后总数减少
        System.out.println("B取走了" + money2 + "还剩下" + Bank.money);
    }

}

class PersonA extends Thread {
    // 创建银行对象
    Bank bank;

    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonA(Bank bank) {
        this.bank = bank;
    }

    // 重写run方法，在里面使用柜台取钱

    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.getCounter(100);// 每次取走100块
            try {
                sleep(100);// 取完休息0.1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}


class PersonB extends Thread {
    // 创建银行对象
    Bank bank;

    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonB(Bank bank) {
        this.bank = bank;
    }

    // 重写run方法，在里面使用使用ATM取钱

    @Override
    public void run() {
        while (Bank.money >= 200) {
            bank.getATM(200);// 每次取钱200块
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

public class MainClass {
    public static void main(String[] args) {
        Bank bank = new Bank();
        PersonA pA = new PersonA(bank);
        PersonB pB = new PersonB(bank);
        // 两个人开始取钱
        pA.start();
        pB.start();
    }
}