package 算法很美.P3排序和查找算法;

import java.util.Arrays;

/*System.arraycopy和java.util.Arrays.copyof区别：
       Arrays.copyOf( )不只是拷贝原数组元素，也在内部创建了一个长度为newlenth的新数组，返回新数组。
       而System.arraycopy需要目标数组，将原数组拷贝到你自定义的数组里，
       而且可以选择拷贝的起点和长度以及放入新数组中的位置。
       其实在底层里Arrays.copyOf( )调用了System.arraycopy( )将原数组内容复制到新数组中。*/
public class ArrayMethodTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{11, 22, 33, 44, 55, 66, 77, 88, 99};
        //将数组b的元素从指针为srcPos的位置开始复制到数组a中，
        //数组a从下标为destPos的位置元素  开始替换为数组b的从srcPos的位置开始，长度为length
        System.arraycopy(b, 0, a, 1, 7);
        printArray(a);
    }

    public static void printArray(int[] temp) {
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp[i]);
//        }
//        System.out.println();
        System.out.println(Arrays.toString(temp));
    }
}
