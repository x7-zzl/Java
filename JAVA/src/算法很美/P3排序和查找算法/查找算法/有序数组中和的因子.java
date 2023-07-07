package 算法很美.P3排序和查找算法.查找算法;
/*给定一个有序数组，输入k。从数组中找到两个数，使它们的和为k
输出这两个数的数组元素下标
如[1,2,3,4,5,6,7,8,9,10]
k=15
[4,9],[5,8],[6,7]
 */

//bug:没有找到所有的可能组合并输出    待优化

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class 有序数组中和的因子 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};

        Arrays.sort(a);
//        Util.Tools.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        Scanner in = new Scanner(System.in);
        System.out.print("输入要找的数之和:");
        int k = in.nextInt();
        int[] result = sortArraySumYinZi(a, k);
        System.out.println(Arrays.toString(result));
    }

    //Time:O(n),Space:O(1)
    private static int[] sortArraySumYinZi(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] > target) --j;
            else if (a[i] + a[j] < target) ++i;
            else return new int[]{i, j};
        }
        //没有找到
        return new int[]{};
    }

}
