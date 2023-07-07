package 多线程.z1;
//奇数偶数线程,通过构造方法实现
public class ThreadTest4 extends Thread{
    private String name;//线程名称
    private int a;//输出序列的初始值
    public ThreadTest4(String name,int a)
    {
        super(name);
        this.a=a;
    }


    @Override
    public void run() {
        int i=a;
        System.out.println("\n"+this.getName()+":");
        while (i<200)
        {
            System.out.print(i+"  ");
            i+=2;//自增2
        }
        System.out.println("\n"+this.getName()+"结束");

    }

    public static void main(String[] args) {
        ThreadTest4 t1=new ThreadTest4("奇数线程",1);
        ThreadTest4 t2=new ThreadTest4("偶数线程",2);
        t1.start();
        t2.start();
        t1.setPriority(10);

    }
}
