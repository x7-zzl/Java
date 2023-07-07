package 算法很美.P9动态规划;


import java.util.Arrays;

/*给定数组arr，返回arr的最长递增子序列长度。比如arr=[2,1,5,3,6,4,8,9,7]最长递增子序列为，
        [1,3,4,8,9] ,所以返回这个子序列的长度为5，给定数组arr，
        返回arr的最长所以返回这个子序列的长度。比如arr=[2,1,5,3,6,4,8,9,7]
        最长递增子序列[1,3,4,8,9],所以返回这个子序列的长度为5
        arr=[2,1,5,3,6,4,8,9,7]
        [1,3,4,8,9]
        dp[1,1,2,2,3,3,4,5,4]

        思路：把问题化简为子问题，求整个整个数组的最长子序列，我可以先求前面少一个数的递增子序列，
        不断递减累加，反过来想就是动态规划，先从arr最左边开始也就是从arr[0]开始当计算arr[1]时只需找到
        它前面比他小的递增子序列最大的那一个就可以了，这就是关系状态方程：dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
        dp[i]表示在必须以arr[i]这个数结尾的情况下，arr[0....i]中最大递增子序列长度*/
public class 最长递增子序列 {
    public static int dp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        //循环求dp中剩余的值
        for (int i = 1; i < arr.length; i++) {
            //计算在arr[i]之前的所有比arr[i]小的数且子序列值最大的也就是
            // 关系状态方程：dp[i]=max{dp[j]+1(0<=j<i,arr[j]<arr[i])}
            int max = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        Arrays.sort(dp);
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,8,9,4,8,6,5,3,2,9};
        System.out.println(Arrays.toString(arr));
        System.out.println(dp(arr));
    }
}
