package Java数据结构和算法.DataStructure.排序算法;


import java.util.Arrays;

//希尔排序，缩小增量排序
//希尔排序：插入排序的升级
@SuppressWarnings("all")
public class 希尔排序 {
    public static void main(String[] args) {
//        int[] a = {22, 3, 5, 1, 23, 6, 70, 34, 23, 4, 95, 78, 34, 65, 38, 65, 76, 32, 76, 108, 9};
//
//        int n = a.length;
//        int gap = n / 2;
//        while (gap > 0) {
//            for (int j = gap; j < n; j++) {
//                int i = j;
//                while (i >= gap && a[i - gap] > a[i]) {
//                    int temp = a[i - gap] + a[i];
//                    a[i - gap] = temp - a[i - gap];
//                    a[i] = temp - a[i - gap];
//                    i -= gap;
//                }
//            }
//            gap = gap / 2;
//        }
//
//        System.out.println(Arrays.toString(a));
//
        int[] a = {1,8,9,4,8,6,5,3,2,9};
        System.out.println(Arrays.toString(a));
        //增量从a.length/2开始，一直减小到1
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            //将整个数组分为若干个子数组

            //交换法
            for (int i = gap; i < a.length; i++) {
                //遍历各组的元素
                for (int j = i - gap; j >= 0; j = j - gap) {
                    //交换元素
                    if (a[j] > a[j + gap]) {
                        int temp = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
