package Java数据结构和算法.DataStructure.排序;

public class BinaryInsertSortTest {
    public static int count = 0;

    public static void main(String[] args) {

        int[] a = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
//        print(a);
        binaryInsertSort(a);
//        print(a);

    }

    public static void binaryInsertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                // 缓存i处的元素值
                int tmp = a[i];
                // 记录搜索范围的左边界
                int low = 0;
                // 记录搜索范围的右边界
                int high = i - 1;
                while (low <= high) {
                    // 记录中间位置
                    int mid = (low + high) / 2;
                    // 比较中间位置数据和i处数据大小，以缩小搜索范围
                    if (a[mid] < tmp) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                //将low~i处数据整体向后移动1位
                if (i - low >= 0) System.arraycopy(a, low, a, low + 1, i - low);
                a[low] = tmp;
                print(a);
            }
        }
    }

    public static void print(int[] data) {
        for (int datum : data) {
            System.out.print(datum + "\t");
        }
        System.out.println();
    }

}