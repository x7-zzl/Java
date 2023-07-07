package Java数据结构和算法.Algorithm.查找算法;

public class 顺序查找 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8, 9, 10, 22, 33, 44, 66, 77};
        System.out.println(sequenceSearch(a, 77));
    }

    static int sequenceSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        //如果找不到该元素，返回
        return 123456789;
    }
}