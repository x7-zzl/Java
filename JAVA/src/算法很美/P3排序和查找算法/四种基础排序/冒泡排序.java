package 算法很美.P3排序和查找算法.四种基础排序;
/*第一趟，相邻的两个数组元素进行比较，把大的元素挪到后面，在与下一个元素比较，大的元素往右挪，
第一趟结束后最大的元素在最右边；最后一个元素第二趟不用比较，接着每一趟之后大的元素元素都放在后面的位置*/

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("all")
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = {1,8,9,4,8,6,5,3,2,9};
        //给元素赋值

        System.out.println("原来的数组:" + Arrays.toString(a));

        //冒泡排序
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        System.out.println("排序后的数组:" + Arrays.toString(a));
    }
}
