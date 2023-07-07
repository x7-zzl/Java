package 多线程.z1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池实现多线程 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());
        service.shutdown();
    }
}

class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
