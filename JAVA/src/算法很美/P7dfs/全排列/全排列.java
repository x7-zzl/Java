package 算法很美.P7dfs.全排列;

import java.util.Arrays;
import java.util.TreeSet;


//解决数组或者整数的全排列问题
@SuppressWarnings("all")
public class 全排列 {

    static TreeSet<String> ts = new TreeSet<>();

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 5, 7, 4};

        perm(a, 0, a.length - 1);
        int count = 0;
        for (String s : ts) {
            System.out.println(s);
            count++;
        }
        System.out.println(count);
    }

    public static void perm(int[] array, int start, int end) {
        if (start == end) {
            ts.add(Arrays.toString(array));
        } else {
            for (int i = start; i <= end; i++) {
                //1，2，3的全排列这块相当于将其中一个提了出来，下次递归从start+1开始
                swapArrayIndex(array, start, i);
                perm(array, start + 1, end);
                //这块是复原数组，为了保证下次另外的同级递归使用数组不会出错
                //这块可以通过树来理解，每次回退一步操作，交换回去
                swapArrayIndex(array, start, i);

            }
        }
    }

    public static void swapArrayIndex(int[] a, int start, int end) {
        int t = a[start];
        a[start] = a[end];
        a[end] = t;
    }

}
