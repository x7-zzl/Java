package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*给你一个长度固定的整数数组arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

        注意：请不要在超过该数组长度的位置写入元素。

        要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。

        示例 1：

        输入：[1,0,2,3,0,4,5,0]
        输出：null
        解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
        示例 2：

        输入：[1,2,3]
        输出：null
        解释：调用函数后，输入的数组将被修改为：[1,2,3]*/

public class t1089_复写0 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
    }

    public static void duplicateZeros(int[] arr) {
        //通过使用队列实现
        Queue<Integer> queue = new LinkedList<>();
        //遍历数组
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {//数组元素为0，就在队列尾加0
                queue.add(0);
            }
            queue.add(arr[j]);//将数组的元素放入队列
            arr[j] = queue.remove();//从队列头取出数据按序返回数组中
        }

        System.out.println(Arrays.toString(arr));
    }
}
