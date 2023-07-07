package 多线程.z2;
//生产者和消费者
//奶箱类
public class Box {
   private    int milk;
    boolean flag=false;
    //获取牛奶
    public synchronized void put(int milk)
    {//如果没有，等待
        if(flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.milk=milk;
        System.out.println("送奶工将第"+this.milk+"瓶牛奶放入奶箱");
        flag=true;
        notifyAll();
    }
    public synchronized  void get()
    {
        if (!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("消费者拿到第"+this.milk+"瓶奶");
        flag=false;
        notifyAll();
    }
}
