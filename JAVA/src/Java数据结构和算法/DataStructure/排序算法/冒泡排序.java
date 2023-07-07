package Java数据结构和算法.DataStructure.排序算法;
/*第一趟，相邻的两个数组元素进行比较，把大的元素挪到后面，在与下一个元素比较，大的元素往右挪，
第一趟结束后最大的元素在最右边；最后一个元素第二趟不用比较，接着每一趟之后大的元素元素都放在后面的位置*/

import java.util.Arrays;

@SuppressWarnings("all")
//public class 冒泡排序 {
//    public static void main(String[] args) {
//        int[] a = new int[10];
//        //给元素赋值
//        Util.Tools.createRandomArray(a,100);
//        System.out.println("原来的数组:" + Arrays.toString(a));
//
//        //冒泡排序
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a.length - 1 - i; j++) {
//                if (a[j] > a[j + 1]) {
//                    int t = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = t;
//                }
//            }
//        }
//
//
//        System.out.println("排序后的数组:" + Arrays.toString(a));
//    }
//}
//冒泡排序
public class 冒泡排序 {
    public static void main(String[] args) {
//        int a[] = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 50,4, 19,48};
        int a[]={46,74,53,14,26,38,86,65,27,34};
        //记录比较次数
        int count = 0;
        //i=0,第一轮比较
        for (int i = 0; i < a.length-1; i++) {
            //第一轮，两两比较
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
                count++;
            }
            System.out.println(Arrays.toString(a));

        }

        System.out.println("一共比较了：" + count + "次");//一共比较了：105次
        System.out.println(Arrays.toString(a));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
    }
}
