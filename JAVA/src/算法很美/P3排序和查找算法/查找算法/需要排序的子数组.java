package 算法很美.P3排序和查找算法.查找算法;

import java.util.Arrays;

//给定一个无序数组，找到需要排序的最短子数组的长度,返回数组下标
// {2,3,7,5,4,6}  4
@SuppressWarnings("ALL")
public class 需要排序的子数组 {
    public static void main(String[] args) {
        int[] a=new int[]{2,3,7,4,5,6};
//        int[] a = new int[10];
//        Util.Tools.createRandomArray(a, 10);
        System.out.println("原数组:" + Arrays.toString(a));
        int[] result = findZiArray(a, a.length);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findZiArray(int[] a, int n) {
        int p1 = 0, p2 = 0;
        int max = a[0];
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && a[i] > a[i + 1] && p1 == 0) {//出现第一次拐点
                p1 = i;
                if (a[i] > max) {
                    max = a[i];
                }
            }
            if (a[i] < max) {
                p2 = i;
            }
        }
        if (p1 == 0) {
            return new int[]{0, 0};
        }
        return new int[]{p1, p2};
    }
}
