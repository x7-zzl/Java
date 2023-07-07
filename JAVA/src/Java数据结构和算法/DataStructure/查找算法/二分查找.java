package Java数据结构和算法.DataStructure.查找算法;

public class 二分查找 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8, 9, 10, 22, 33, 44, 66, 77};
        //查找的数组有序是使用二分法的前提
//        Arrays.binarySearch(a, 1);
        //输出数组下标
        System.out.println(binarySearch(a, 5));
    }

    private static int binarySearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;

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