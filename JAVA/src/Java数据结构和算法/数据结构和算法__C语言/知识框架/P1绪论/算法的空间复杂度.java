package Java数据结构和算法.数据结构和算法__C语言.知识框架.P1绪论;
//例1.11:数组逆序，将一维数组a的n个数逆序存放到原数组中

public class 算法的空间复杂度 {
    public static void main(String[] args) {
        int n=100;
        int[] a=new int[n];

        //空间复杂度为O(1)
        for (int i=0;i<n/2;i++){
            int t=a[i];
            a[i]=a[n-1-i];
            a[n-1-i]=t;
        }

        int[] b=new int[n];

        //空间复杂度为O(n)
        for (int i=0;i<n;i++)
            b[i]=a[n-1-i];
        for (int i=0;i<n;i++)
           a[i]=b[i];


        for (int i=0;i<n;i++){
            System.out.print(a[i]);
        }
    }
}
