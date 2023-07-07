package 多线程.z2;

public class Consumer implements Runnable{
    private Box b;
    public Consumer(Box b) {
        this.b=b;
    }

    @Override
    public void run() {
        while (true){
            b.get();
        }
    }
}
