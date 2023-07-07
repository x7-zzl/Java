package 多线程.z2;

public class Boxdemo {
    public static void main(String[] args) {
        Box b=new Box();

        Producer producer=new Producer(b);

        Consumer consumer=new Consumer(b);

        Thread t1=new Thread(producer);
        Thread t2=new Thread(consumer);

        t1.start();
        t2.start();
    }
}
