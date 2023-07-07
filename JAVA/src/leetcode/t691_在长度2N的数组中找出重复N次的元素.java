package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*961. 在长度 2N 的数组中找出重复 N 次的元素
        给你一个整数数组 nums ，该数组具有以下属性：

        nums.length == 2 * n.
        nums 包含 n + 1 个 不同的 元素
        nums 中恰有一个元素重复 n 次
        找出并返回重复了 n 次的那个元素。

        示例 1：
        输入：nums = [1,2,3,3]
        输出：3
        示例 2：
        输入：nums = [2,1,2,5,3,2]
        输出：2
        示例 3：
        输入：nums = [5,1,5,2,5,3,5,4]
        输出：5*/
public class t691_在长度2N的数组中找出重复N次的元素 {
    public static void main(String[] args) {
        int []nums= {1,2,3,3};
        System.out.println(repeatedNTimes(nums));
    }

    public static int repeatedNTimes(int[] nums) {
        //方法1
//        Set<Integer> hashSet = new HashSet<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!hashSet.add(nums[i])){
//                return nums[i];
//            }
//        }
//        return -1;

        //方法2
//        int n=nums.length/2;
//        Arrays.sort(nums);
//        //包含 n + 1 个不同的元素，恰有一个元素重复 n 次，其他n个元素元素只能出现一次
//        //所以排序之后nums[n]即为要找的元素
//        return nums[n]==nums[n+1]?nums[n]:nums[n-1];

        //方法3
//        boolean[] flag=new boolean[10000];
//        int res=-1;
//        for (int num : nums) {
//            if (flag[num]) {
//                return num;
//            }
//            flag[num] = true;
//        }
//        return res;


        //方法4  暴力
        int mid=nums.length/2;
        int count[]=new int[10005];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            if(count[nums[i]]==mid){return nums[i];}
        }
        return -1;
    }
}
