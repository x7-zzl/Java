package 多线程.shiyan;
/*
 我们使用的计算机系统就是一个多线程程序，我们在编辑文档时，可以同时听音乐、看视频，桌面右下角的时钟会不断更新最新时间，这些都是多线程给我们带来的好处。
 请实现一个多线程程序，分别使用Thread类和Runnable接口求一个整数序列中的最大者，其中，一个线程用来求前n个数的最大者，另一个线程用于更新界面把当前求的最大者显示出来。
 要求：每隔5秒求一次前n个数的最大者，然后再隔5秒求前n+1个数的最大者，依次类推，并以图形化形式实时显示运行结果。
 */

import javax.swing.*;
import java.util.Random;


class MyThread1 extends Thread {
    public static int max;//生成0~999的随机数;
    int a[]=new int[100];


    public synchronized void run() {//用来求前n个数的最大者

        for ( int i = 0; i <100; i++) {
            max=new Random().nextInt(100);
            a[i]=max;
        }
        for (int i=0;i<100;i++)
        {
            try {
            Thread.sleep(1000 * 5);//线程休息5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            if(max < a[i]){
                max = a[i];
            }
            System.out.println("已生成了"+(+i+1)+"个数组元素，其中的最大值为" +max);
        }
        }
    }


class MyRunnable extends JPanel implements Runnable {//用于更新界面把当前求的最大者显示出来
    public static JTextField textField;

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        JFrame frame = new JFrame("最大值显示界面");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("最大的数是:");
        textField = new JTextField(10);


        frame.add(panel);
        panel.add(label);
        panel.add(textField);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);

    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(1000 * 5);//线程休息5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textField.setText("");//清空文本域
            textField.setText(String.valueOf(MyThread1.max));//显示最大值

        }

    }

}


