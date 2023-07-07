package 算法很美.P9动态规划;


/*小偷背包容量为8，有4件物品如下：id     1  2  3  4
                      weight   2  3  4  5
                      value    3  4  5  6
f(k,w)表示背包容量为w，有k件物品可偷，求最大价值的偷法f(k,w)*/
//状态转移方程如下：f(k,w)=f(k-1,w),wk>w,放不下
//                    f(k-1,w)  /      f(k-1,w-wk)+vk;
public class 背包问题01 {
    public static void main(String[] args) {
        int f[][]=new int[5][9];
        int w[]= {0,2,3,4,5};
        int v[]= {0,3,4,5,8};

        for(int i=1;i<5;i++) {
            for (int j = 1; j < 9; j++) {
                if(w[i]>j) {//放不下
                    f[i][j]=f[i-1][j];
                }else {
                    f[i][j]=Math.max(f[i-1][j], f[i-1][j-w[i]]+v[i]);
                }
            }
        }


        for(int i=0;i<5;i++) {
            for(int j=0;j<9;j++) {
                System.out.printf("f[%d][%d]=%d  ",i,j,f[i][j]);
            }
            System.out.println();
        }
    }
}
