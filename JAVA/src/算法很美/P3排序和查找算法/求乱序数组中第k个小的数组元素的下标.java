package 算法很美.P3排序和查找算法;

import java.util.Arrays;
import java.util.Scanner;

//求乱序数组中第k个小的数组元素下标并输出
@SuppressWarnings("ALL")
public class 求乱序数组中第k个小的数组元素的下标 {
    public static void main(String[] args) {
        int[] a = {1, 8, 9, 4, 8, 6, 5, 3, 2, 9};
        //输出数组元素，以il.Tools.createRandomArray(a, 100);便查看
        System.out.println("数组元素是:" + Arrays.toString(a));

        //输入查询的数
        //k>0
        System.out.print("输入第k个小的数组元素(k>0):");
        int k = new Scanner(System.in).nextInt();

//        //开辟临时数组
//        int[] b = new int[a.length];
        //复制数组b
//        for (int i = 0; i < a.length; i++) {
//            b[i] = a[i];
//        }

        /*System.arraycopy和java.util.Arrays.copyof区别：
        Arrays.copyOf( )不只是拷贝原数组元素，也在内部创建了一个长度为newlenth的新数组，返回新数组。
        而System.arraycopy需要目标数组，将原数组拷贝到你自定义的数组里，而且可以选择拷贝的起点和长度以及放入新数组中的位置。
        其实在底层里Arrays.copyOf( )调用了System.arraycopy( )将原数组内容复制到新数组中。*/


        //复制数组b
        int[] b = Arrays.copyOf(a, a.length);


        Arrays.sort(b);
        System.out.println("需要找的数组元素是:" + b[k - 1]);


        //暴力查找
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[k - 1]) {
                System.out.println("需要找的数组下标是:" + i);

            }
        }


    }

}
