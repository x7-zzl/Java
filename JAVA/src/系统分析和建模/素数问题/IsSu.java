package 系统分析和建模.素数问题;
/*
素数问题
输出1-50之间的素数
        素数的定义:除了1与本身之外，不能被其他正整数整除的数,叫作素数,也叫质数
        按照习惯规定，1不算素数,最小的素数是2,其余的是3、5、7、11、13、17、19...等等由定义判断素数

        对于数n,从i=2,3,4,5...到 n-1判断n能否被i整除,如果全部不能整除,则n是素数,
        只要有一个能除尽,则n不是素数,为了压缩循环次数，可将判断范围从2 ~ n-1改为2 ~ sqrt(n)


*/

public class IsSu {
    public static void main(String[] args) {
        int n=50;
        int[] a=new int[n];
        for (int i = 0; i < n-1; i++) {//赋值
            a[i]=i+2;
        }

        int max= (int) Math.sqrt(n);
        int count=2;
        //从2开始，看能否被整除，可以的话基本上素数，并且把2的倍数去掉
        //然后一直倒7执行操作
        while (count<max){
            for (int i = count*2-2; i <50 ; i+=count) {
                a[i]=0;
            }
            count++;
        }

        for (int i = 0; i < n-1; i++) {
            if(a[i]!=0){
                System.out.println(a[i]);
            }
        }

    }


}
