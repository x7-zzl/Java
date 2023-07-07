package 算法很美.P9动态规划;

import java.util.Arrays;
import java.util.Random;

public class DP {

    public static void main(String[] args) {

        long t1=System.currentTimeMillis();
        System.out.println("Generating a random array...");
        DP DP = new DP();
        int[] a = DP.randomArray();
        System.out.println(Arrays.toString(a)); //输出生成的随机数组
        System.out.println("each DP array:"); //输出每次计算时arrayOut数组的内容，便于观察
        System.out.println("DP length  is:" + DP.getLength(a)); //输出最长递增子序列的长度
        long t2=System.currentTimeMillis();
        System.out.println((t2-t1)+"ms");
    }

    //生成一个10以内的数组，长度为10
    public int[] randomArray() {
        Random random = new Random();
        int[] randomArray = new int[10];
        for (int i = 0; i < 10; i++) {
            randomArray[i] = random.nextInt(10);
        }

        return randomArray;
    }
    //二分查找要替换的位置
    public int BinarySearchPosition(int []a, int left, int right, int key) {

        int mid;
        if (a[right] < key) {
            return right + 1;
        } else {
            while (left < right) {
                mid = (left + right) / 2;
                if (a[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

    }

    //获取最长递增子序列的长度
    public int getLength(int[] b) {

        int len = 1;

        int[] a = new int[b.length + 1];//a[0]没有存放数据
        a[1] = b[0];
        for (int i = 1; i < b.length; i++) {
            int  position = BinarySearchPosition(a, 1, len, b[i]);
            a[position] = b[i];
            System.out.println(Arrays.toString(a));
            if (len < position) {
                len = position;
            }
        }

        return len;
    }

}