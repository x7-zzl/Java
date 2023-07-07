package Java数据结构和算法.DataStructure.数组_字符串.数组.特殊矩阵压缩;

import java.util.Arrays;

public class DownMatrix {
    public static void main(String[] args) {
        int[][] downMatrix = {
                {1, 0, 0, 0, 0},
                {2, 3, 0, 0, 0},
                {3, 4, 5, 0, 0},
                {4, 0, 6, 3, 0},
                {5, 6, 7, 8, 7}};

        int length = downMatrix[0].length;
        int m = 0;
        //非0元素的个数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < downMatrix.length; j++) {
                if (i >= j) {
                    if (downMatrix[i][j] != 0) {
                        m++;
                    }
                }

            }
        }

        int[] storage = new int[m];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < downMatrix.length; j++) {
                if (i >= j) {
//                    System.out.println(upperMatrix[i][j]);
                    if (downMatrix[i][j] != 0) {
                        storage[count++] = downMatrix[i][j];
                    }
                }

            }
        }

        System.out.println("压缩后的数组" + Arrays.toString(storage));
    }

}
