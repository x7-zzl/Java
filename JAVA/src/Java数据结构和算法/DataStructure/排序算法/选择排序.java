package Java数据结构和算法.DataStructure.排序算法;
/*先假设a[i]（即a[0]）是最小的数，然后把后面都是元素和它比较，找到最小的数，与开始的a[i]交换，
这样，第一趟循环后，最小的数就放在a[0]，就这样一直比较下去，每一趟循环都找到最小的数放在前面。*/

import java.util.Arrays;

//选择排序:先定义一个记录最小元素的下标，然后循环一次后面的，找到最小的元素，最后将他放到前面排序好的序列。
public class 选择排序 {
    public static void main(String[] args) {
        int[] a = {46,74,53,14,26,38,86,65,27,34};

        for (int i = 0; i < a.length - 1; i++) {
            int index = i;//标记第一个为待比较的数
            for (int j = i + 1; j < a.length; j++) { //然后从后面遍历与第一个数比较
                if (a[j] < a[index]) {  //如果小,就交换最小值
                    index = j;//保存最小元素的下标
                }
            }
            //找到最小值后，将最小的值放到第一的位置，进行下一遍循环
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }
}

