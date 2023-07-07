package leetcode;

import java.util.Arrays;

public class t2441_与对应负数同时存在的最大正整数 {
    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        int maxK = findMaxK(nums);
        System.out.println(maxK);
    }

    public static int findMaxK(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int t = nums[i] - (nums[i] * 2);

            int res = Arrays.binarySearch(nums, t);
            if(res>=0){
                return nums[i];
            }
        }
        return -1;
    }

//    private static int MyBinarySearch(int[] nums, int key) {
//        int left = 0, right = nums.length - 1;
//
//        int mid = (left + right) / 2;
//
//        while (left < right) {
//            if (key < nums[mid]) {
//                right = mid;
//            } else if (key > nums[mid]) {
//                left = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//
//
//        return -1;
//
//    }


}
