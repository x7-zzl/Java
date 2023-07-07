package 多线程.z1;

//多线程实现的第二种方式，实现Runnable接口
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread t=new Thread(new Runnable() {//匿名类
            @Override
            public void run() {
                for (int  i=0;i<100;i++)
                {
                    System.out.println("分支线程——->"+i);
                }
            }
        });
        t.start();

        for (int  i=0;i<100;i++)
        {
            System.out.println("主线程——->"+i);
        }
        }
}
