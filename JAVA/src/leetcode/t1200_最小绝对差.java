package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1200. 最小绝对差
        给你个整数数组 arr，其中每个元素都 不相同。

        请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

        示例 1：

        输入：arr = [4,2,1,3]
        输出：[[1,2],[2,3],[3,4]]
        示例 2：

        输入：arr = [1,3,6,10,15]
        输出：[[1,3]]
        示例 3：

        输入：arr = [3,8,-10,23,19,-4,-14,27]
        输出：[[-14,-10],[19,23],[23,27]]*/
public class t1200_最小绝对差 {
    public static void main(String[] args) {
        int[] a = {3, 8, -10, 23, 19, -4, -14, 27};
        System.out.println(minimumAbsDifference(a));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
                list.clear();
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[i + 1]);
                list.add(res);
            } else if (arr[i + 1] - arr[i] == min) {
                List<Integer> res = new ArrayList<>();
                res.add(arr[i]);
                res.add(arr[i + 1]);
                list.add(res);
            }
        }
        return list;
    }

}

