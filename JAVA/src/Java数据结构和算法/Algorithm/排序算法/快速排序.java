package Java数据结构和算法.Algorithm.排序算法;
/*
快速排序算法
        -1、分解:数组A[p..r]被划分为两个子数组A[p..q-1]和A [ q+1,r]，
        使得A[q]为大小展中的数，左侧A[p..q-1]中的每个元素都小于等于它，
        而右侧A [ q+1,r]中的每个元素都大于等于它。其中计算下标q也是划分过程的一部分。
        -2、解决:通过递归调用快速排序，对子数组A
        [p..q-1]和A [ q+l,r]进
        行排序
        -3、合并:因为子数组都是原址排序的，所以不需要合并，数组A[p..r]已经有序
        >那么，划分就是问题的关键
*/
/*
以数组中的第一个数作为基准数，然后从数组两边开始检索，
从数组右边开始检索比基准数小的数（大的数跳过）j，找到后停下，从左边找比基准数大的数（小数跳过）i、
知道后将i,j交换位置，一直这样排到i=j时跳出，然后把基准数与这个数交换位置。
这样现在所处位置的基准数左边都比它下，右边都比它大。
 */

import java.util.Arrays;

@SuppressWarnings("all")
public class 快速排序 {
    public static void main(String[] args) {
        //生成数组元素
        int[] arr = new int[10];
        int[] a = {1,8,9,4,8,6,5,3,2,9};

        System.out.println("原数组:" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);

        System.out.println("快排后的数组:" + Arrays.toString(arr));

    }


    private static void quickSort(int[] arr, int left, int right) {
        //如果left<=right不成立，退出
        if (left > right) {
            return;
        }
        //定义基准数，为数组的第一个元素，left为0
        int base = arr[left];
        //定义i和j，分别在最左边和最右边的指针

        int i = left, j = right;

        while (i != j) {
            //从右边开始检索，如果>=base,j往左边挪动
            //找到比base小的数时停下
            while (arr[j] >= base && i < j) {
                j--;
            }

            //从左边开始检索，如果<=base,i往右边挪动
            //找到比base大的数时停下
            while (arr[i] <= base && i < j) {
                i++;
            }

            //到这说明两边都停下了，交换i,j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //到这说明i==j,把arr[i](arr[j])和base交换
        //因为base=arr[left],arr[left]的值已经存在base里面了，就不用再找中间数
        arr[left] = arr[i];
        arr[i] = base;


        //现在左边的数都比基准数小，右边都比它大
        //对左边进行排序
        quickSort(arr, left, i - 1);

        //对右边进行排序
        quickSort(arr, i + 1, arr.length - 1);
    }
}
