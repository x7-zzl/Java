package 算法很美.P3排序和查找算法.查找算法;

import java.util.Arrays;

@SuppressWarnings("all")
public class 顺序查找和二分查找的时间效率 {
    static int SequenceSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        //如果找不到该元素，返回
        return 123456789;
    }

    public static void main(String[] args) {
        int[] arr=new int[1000000000];
        //赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }

        long t1=System.currentTimeMillis();
        SequenceSearch(arr,arr.length-1);
        long t2=System.currentTimeMillis();
        Arrays.binarySearch(arr,arr.length-1);
        long t3=System.currentTimeMillis();
        System.out.println("顺序查找:"+(t2-t1)+"ms");
        System.out.println("二分查找:"+(t3-t2)+"ms");
    }
}
