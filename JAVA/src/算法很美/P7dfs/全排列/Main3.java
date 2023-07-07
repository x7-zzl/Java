package 算法很美.P7dfs.全排列;

/*3、凑算式
        题目：

        这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

        比如：

        6+8/3+952/714 就是一种解法，

        5+3/1+972/486 是另一种解法。

        这个算式一共有多少种解法？*/
public class Main3 {
    static int ans;
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    static boolean check() {
        int x = a[3] * 100 + a[4] * 10 + a[5];
        int y = a[6] * 100 + a[7] * 10 + a[8];
        if ((a[1] * y + a[2] * x) % (y * a[2]) == 0 && a[0] + (a[1] * y + a[2] * x) / (y * a[2]) == 10) return true;
        return false;
    }

    /*递归回溯生成全排列，适用于无重复元素的情况
     * 考虑第k位，前面已经排定*/
    static void f(int k) {
        if (k == 9) {//一种排列已经产生（出口）
            if (check())//根据题目要求进行检查，如果boolean型的check（）为true就++
                ans++;
        }
        //从k往后的每个数字都可以放在k位
        for (int i = k; i < 9; i++) {
            //尝试将位置i与位置k进行交换，以此确定k位的值
            {
                int t = a[i];
                a[i] = a[k];
                a[k] = t;
            }
            f(k + 1);
            {         //回溯
                int t = a[i];
                a[i] = a[k];
                a[k] = t;
            }
        }
    }

    public static void main(String[] args) {
        f(0);//从第0个开始
        System.out.println(ans);
    }

}
