package 多线程.shiyan;

public class Bread {
    int count = 20;//面包数量

    public synchronized void make() {//制作面包
        try {
            Thread.sleep(100);//线程睡眠1秒，便于观察程序的运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;//制作一块面包，面包数量加1
        System.out.println(Thread.currentThread().getName() + "加工出一块面包，现有面包有" + count + "块");//获取线程名称
    }

    public synchronized void sell() {//售卖面包
        if (count > 0) {

            try {
                Thread.sleep(100);//线程睡眠1秒，便于观察程序的运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            count--;//卖出一块面包，面包数量减1
            System.out.println(Thread.currentThread().getName() + "卖出一块面包，现有面包" + count + "块");//获取线程名称

        }


    }
}

class Test implements Runnable {
    private Bread bread;

    public Test(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {//实现方法
        while (true)//死循环，使程序一直运行
        {
            if (Thread.currentThread().getName().equals("面包师"))//通过获取线程的名称来判断使用对应的方法
            {
                bread.make();
            } else
                bread.sell();
        }


    }
}

class BreadDemo {//测试类

    public static void main(String[] args) {
        Bread bread = new Bread();
        Test t = new Test(bread);

        Thread t1 = new Thread(t, "面包师");//线程名称
        Thread t2 = new Thread(t, "窗口1的店员");
        Thread t3 = new Thread(t, "窗口2的店员");

        t1.start();
        t2.start();
        t3.start();//启动线程
    }
}