package 算法很美.P4二维数组和矩阵;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class 顺时针打印二维数组_集合 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 5, 8, 9, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9}};

        System.out.print(printMatrix(arr));
    }

    private static ArrayList<Integer> printMatrix(int[][] a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int rows = a.length;
        int cols = a[0].length;
        while (rows > 0 && cols > 0) {
            print(list, a, rows, cols, start);
            start++;
            rows = a.length - start * 2;
            cols = a[0].length - start * 2;
        }
        return list;
    }

    private static ArrayList<Integer> print(ArrayList<Integer> list, int[][] a, int rows, int cols, int start) {
        for (int i = start; i < cols + start; i++) {
            list.add(a[start][i]);
        }
        if (rows - 1 > 0) {
            for (int i = start + 1; i < rows + start; i++) {
                list.add(a[i][cols - 1 + start]);
            }
        }
        if (rows - 1 > 0 && cols - 1 > 0) {
            for (int i = cols - 2 + start; i >= start; i--) {
                list.add(a[rows - 1 + start][i]);
            }
        }
        if (rows > 2 && cols > 2) {
            for (int i = rows - 2 + start; i > start; i--) {
                list.add(a[i][start]);
            }
        }
        return list;
    }

}
