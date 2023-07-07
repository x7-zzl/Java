package 多线程.z1;

//三个窗口买票
public class Selltickets {
    public static void main(String[] args) {
        Tickets tickets=new Tickets();
        Thread t1=new Thread(tickets,"窗口1");
        Thread t2=new Thread(tickets,"窗口2");
        Thread t3=new Thread(tickets,"窗口3");


        t1.start();
        t2.start();
        t3.start();
    }
}

class Tickets implements Runnable{
    int count=10000;
    Object object=new Object();
//    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true)
        {
            synchronized (object){
                //lock.lock();
                if (count>0)
                {

//                    try {
//                        Thread.sleep(1);//睡眠1毫秒
//                    }catch (InterruptedException e)
//                    {
//                        e.getStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName()+"正在出售第"+count+"张票");
                    count--;
                }
               // lock.unlock();//lock锁，不常用
            }

        }
    }
}