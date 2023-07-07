package exerciseendless.exerciseendlessless;

import java.util.Arrays;
import java.util.Scanner;
//-------冒泡排序法
//对n个数进行排序
public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr =new int[n];
        //输入n个数组元素
        for(int i=0;i<n;i++) {
            arr[i]=scan.nextInt();
        }
        System.out.println(Arrays.binarySearch(arr,7));
        //外层循环,它决定一共走几趟
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环,开始逐个比较
            //如果我们发现前一个数比后一个数大,则交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //换位
                    int temp  = arr[j];//中间值
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        //输出结果
        for (int j : arr) {
            System.out.print(j+" ");
        }
    }
}
