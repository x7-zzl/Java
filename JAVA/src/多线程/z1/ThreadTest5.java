package 多线程.z1;
//合理的终止线程，可以更好的保存数据
public class ThreadTest5 {
    public static void main(String[] args) throws InterruptedException {
        AAA a=new AAA();//实例化一个对象
        Thread t=new Thread(a);
        t.setName("线程");
        t.start();

        Thread.sleep(1000*5);//主线程睡眠5秒后修改flag
        a.flag=false;//想什么时候结束线程，就把flag改为false
    }
}

class AAA implements Runnable{
boolean flag=true;//通过此修改线程
    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            if(flag)//死循环
            {
                System.out.println(Thread.currentThread().getName()+"--->"+i);
                try {
                    Thread.sleep(1000);//线程睡眠1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}