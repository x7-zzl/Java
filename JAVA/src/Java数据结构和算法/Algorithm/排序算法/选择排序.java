package Java数据结构和算法.Algorithm.排序算法;
/*先假设a[i]（即a[0]）是最小的数，然后把后面都是元素和它比较，找到最小的数，与开始的a[i]交换，
这样，第一趟循环后，最小的数就放在a[0]，就这样一直比较下去，每一趟循环都找到最小的数放在前面。*/

import java.util.Arrays;

@SuppressWarnings("all")
public class 选择排序 {
    public static void main(String[] args) {

        int[] arr = {43, 21, 69, 23, 65, 33, 81, 12, 43, 54};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
