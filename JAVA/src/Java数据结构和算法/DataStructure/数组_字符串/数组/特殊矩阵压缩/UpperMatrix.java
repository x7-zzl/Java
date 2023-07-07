package Java数据结构和算法.DataStructure.数组_字符串.数组.特殊矩阵压缩;

import java.util.Arrays;

//上三角矩阵
public class UpperMatrix {
    public static void main(String[] args) {
        int[][] upperMatrix = {
                {1, 2, 0, 4},
                {0, 3, 0, 2},
                {0, 0, 5, 1},
                {0, 0, 0, 6},
        };

        int length = upperMatrix[0].length;
        int m = 0;
        //非0元素的个数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < upperMatrix.length; j++) {
                if (i <= j) {
                    if (upperMatrix[i][j] != 0) {
                        m++;
                    }
                }

            }
        }

        int[] storage = new int[m];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < upperMatrix.length; j++) {
                if (i <= j) {
//                    System.out.println(upperMatrix[i][j]);
                    if (upperMatrix[i][j] != 0) {
                        storage[count++] = upperMatrix[i][j];
                    }
                }

            }
        }

        System.out.println("压缩后的数组" + Arrays.toString(storage));

    }


}
