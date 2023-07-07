package leetcode;
/*给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。

        序号代表了一个元素有多大。序号编号的规则如下：

        序号从 1 开始编号。
        一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
        每个数字的序号都应该尽可能地小。
        示例 1：

        输入：arr = [40,10,20,30]
        输出：[4,1,2,3]
        解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
        示例 2：

        输入：arr = [100,100,100]
        输出：[1,1,1]
        解释：所有元素有相同的序号。
        示例 3：

        输入：arr = [37,12,28,9,100,56,80,5,12]
        输出：[5,3,4,2,8,6,7,1,3]*/

import java.util.*;

public class t1331_数组序号转换 {
    public static void main(String[] args) {
        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    public static int[] arrayRankTransform(int[] arr) {
       /* // 先复制一份数据到新的数组，排序新数组
        int[] a = arr.clone();
        Arrays.sort(a);

        // 利用HashMap去重，赋值该数组的所求序号
        int temp = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (!map.containsKey(a[i])) {
                temp++;
                map.put(a[i], temp);
            }
        }

        // 比对map中的元素实际位置，赋值
        for (int i = 0; i < arr.length; i++) {
            a[i] = map.get(arr[i]);
        }
        return a;*/

        Map<Integer, Integer> map = new HashMap<>();
        int[] b = new int[arr.length];
        System.arraycopy(arr, 0, b, 0, arr.length);
        Arrays.sort(b);
        int p = 0;
        for (int j : b) {
            if (!map.containsKey(j)) {
                p++;
                map.put(j, p);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> m : entries) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == m.getKey()) {
                    arr[i] = m.getValue();
                }
            }
        }
        return arr;

    }/*   for (int i = 0; i < arr.length; i++) {
            b[i] = map.get(arr[i]);
        }

        return b;*/
}
