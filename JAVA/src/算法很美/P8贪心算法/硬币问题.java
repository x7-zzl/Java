package 算法很美.P8贪心算法;
/*
     贪心算法:
     只顾眼前，找到并使用当前的最优解，不去考虑其他可能出现的最优解
     当前最优解不一定是全局最优解
 */

import java.util.Scanner;
/*硬币问题:有1，5，10，50，100，500元各个面额的硬币若干个，
需要支付cost元，最少用几个硬币?

实例:
输入：3 2 1 3 0 2
     620
输出:6
 */
public class 硬币问题 {

    //硬币的面额
    static int[] coins={1,5,10,50,100,500};

    static int[] currentCoin =new int[coins.length];
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("输入每个面额的硬币个数:");
        for (int i = 0; i < currentCoin.length; i++) {
            currentCoin[i]= scan.nextInt();
        }
        System.out.println("输入总金额数:");
        int cost= scan.nextInt();
        int result=f(cost,coins.length-1);

        System.out.println("最少需要"+result+"枚硬币");
    }
    //先用大面值的硬币
    // 因为如果不用大面值的硬币的话，就会所有多个小面额的硬币
    static int f(int cost,int coinsIndex){
        if(cost<=0) return 0;
        if(coinsIndex==0) return cost;

        int coinValue=coins[coinsIndex];
        //总金额有多少个当前面额的硬币
        int x=cost/coinValue;
        //有多少个当前面额的硬币
        int t=Math.min(x,currentCoin[coinsIndex]);
        return t+f(cost-t*coinValue,coinsIndex-1);
    }
}
