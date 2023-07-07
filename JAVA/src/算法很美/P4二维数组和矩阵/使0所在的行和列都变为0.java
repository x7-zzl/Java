package 算法很美.P4二维数组和矩阵;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class 使0所在的行和列都变为0 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 0, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}};

        changeZero(matrix);

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void changeZero(int[][] a) {
        int m = a.length, n = a[0].length;
        int[] recordRow = new int[m];
        int[] recordColumn = new int[n];

        //记录出现0的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    recordRow[i] = 1;
                    recordColumn[j] = 1;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (recordRow[i] == 1 || recordColumn[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }

    }
}
