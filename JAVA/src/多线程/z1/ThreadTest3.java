package 多线程.z1;
//线程的睡眠和打断睡眠
//线程的优先级和线程名称，获取线程当前的名称
public class ThreadTest3 {
    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable(),"线程1:");
        Thread t2=new Thread(new MyRunnable(),"线程2:");
        //t1.setName("线程1:");
        t1.setPriority(10);
        t2.setPriority(10);//设置最高优先级
        t1.start();
        t2.start();
        for (int i=0;i<100;i++)//main线程
        {
            System.out.println(Thread.currentThread().getName()+"--->");
        }


        try {
            Thread.sleep(1000*5);//线程睡眠，单位毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();//中断睡眠，依靠异常处理程序


    }

}

class MyRunnable implements Runnable{   //实现Runnable接口的抽象方法run()

    @Override
    public void run() {
        for (int i=0;i<100;i++)
        {
            try {
                Thread.sleep(1000*60*60);//线程睡眠，单位毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->");
        }
    }
}