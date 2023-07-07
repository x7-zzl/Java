package exerciseendless.Arrays_use;

import java.util.Arrays;
import java.util.stream.IntStream;


public class ArraysStreamSum {
    public static void main(String[] args) {
//        int[] a= {1,2,3,4};
        int[] a= {7,8,9,3,1,34,5};
        IntStream stream = Arrays.stream(a);
        stream.forEach(str -> System.out.print(str + " "));
        System.out.println();


        //计算int数组中所有元素的和
        System.out.println("计算数组中所有元素的和:"+Arrays.stream(a).sum());//10

        System.out.println(Math.max(1,2));
    }
}
