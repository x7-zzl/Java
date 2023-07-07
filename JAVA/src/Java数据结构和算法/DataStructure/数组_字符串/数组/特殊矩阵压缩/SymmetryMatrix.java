package Java数据结构和算法.DataStructure.数组_字符串.数组.特殊矩阵压缩;

import java.util.Arrays;

public class SymmetryMatrix {
    public static void main(String[] args) {
        int[][] symmetryMatrix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}
        };

        int length = symmetryMatrix[0].length;
        int m = 0;
        //元素的个数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < symmetryMatrix.length; j++) {
                if (i <= j) {
                    m++;
                }

            }
        }

        int[] storage = new int[m];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < symmetryMatrix.length; j++) {
                if (i <= j) {
                    storage[count++] = symmetryMatrix[i][j];

                }

            }
        }
        System.out.println("压缩后的数组" + Arrays.toString(storage));

    }
}
