package Java数据结构和算法.Algorithm.排序算法;
/*
插入排序:定义一个待插入的数，再定义一个待插入数的前一个数的下标，然后拿待插入数与前面的数组一一比较，最后交换。
第一趟a[0]不动，第二躺a[1]和a[0]比,大的话不动，小的2话把a[0]值赋给a[1]，跳出while，a[0]的值保存前的a[1]
第二趟,把a[2]和a[0]-a[1]进行比较，大的话不动，小的2话把被比较的a[1]忘后挪一位，
*/

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {

        int[] a = {1,8,9,4,8,6,5,3,2,9};
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {  //长度不减1，是因为要留多一个位置方便插入数
            //定义待插入的数
            int insertValue = a[i];
            //找到待插入数的前一个数的下标
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < a[insertIndex]) {
                //拿a[i]与a[i-1]的前面数组比较
                a[insertIndex + 1] = a[insertIndex];
                insertIndex--;
            }
            a[insertIndex + 1] = insertValue;
        }
        System.out.println(Arrays.toString(a));
    }
}
