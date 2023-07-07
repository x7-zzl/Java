package exerciseendless.exerciseendlessless;

import java.util.Scanner;

public class 选择排序 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min;
        int[] arr = new int[n];
        //输入n个数组元素
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            min = i;//每次讲min置成无序组起始位置元素下标
            for (int j = i; j < n; j++)//遍历无序组，找到最小元素。
            {
                if (arr[j] < arr[min])
                    min = j;
                int t = arr[j];
                arr[j]=arr[min];
                arr[min]=t;
            }
            for (int j : arr) {
                System.out.println(j);
            }
        }
    }
}