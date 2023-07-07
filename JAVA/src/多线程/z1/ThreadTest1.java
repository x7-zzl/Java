package 多线程.z1;

//多线程实现的第一种方式，通过继承Thread类实现
public class ThreadTest1 {
    public static void main(String[] args) {
        T t = new T();
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程——->" + i);
        }
    }
}


class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("分支线程--->" + i);
        }
    }
}