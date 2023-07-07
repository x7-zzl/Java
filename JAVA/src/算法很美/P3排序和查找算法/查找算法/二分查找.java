package 算法很美.P3排序和查找算法.查找算法;
//使用前提:数组已经有序
/*优点是比较次数少，查找速度快，平均性能好；
  其缺点是要求待查表为有序表，且插入删除困难。
  因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
    使用条件：查找序列是顺序结构，有序。
*/


import java.util.Arrays;

@SuppressWarnings("ALL")
public class 二分查找 {
    private static int count=1;

    public static void main(String[] args) {
        int a[] = {1,3,5,6,8,9,10,22,33,44,66,77};
        //查找的数组有序是使用二分法的前提
//        Arrays.binarySearch(a,1);
        //输出数组下标
        System.out.println(binarySearch(a, 66));
    }

    private static int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            System.out.println("第"+(count++)+"次查找的中间值是："+a[mid]);
            if (a[mid] < key)
                left = mid + 1;
            else if (a[mid] > key)
                right = mid - 1;
            else
                return mid; // key found
        }
        return -(left + 1);  // key not found.
    }
}
