package 算法很美.P4二维数组和矩阵;

@SuppressWarnings("ALL")
public class 逆时针打印二维数组 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12}};

        print(matrix);

    }

    private static void print(int[][] a) {
        int leftUpRow = 0, leftUpColumn = 0,
                rightDownRow = a.length - 1, rightDownColumn = a[0].length - 1;
        while (leftUpRow <= rightDownRow && leftUpColumn <= rightDownColumn) {
            int r = leftUpRow, c = leftUpColumn;
            //左边一条边
            while (r <= rightDownRow) {
                System.out.print(a[r++][c] + " ");
            }
            //恢复
            r = rightDownRow;
            c++;
            //下面一条边
            while (c <= rightDownColumn) {
                System.out.print(a[r][c++] + " ");
            }
            //恢复
            r--;
            c = rightDownColumn;
            //右边一条边
            while (r >= leftUpRow) {
                System.out.print(a[r--][c] + " ");
            }
            //恢复
            r = leftUpRow;
            c--;
            //上面一条边
            while (c > leftUpColumn) {
                System.out.print(a[r][c--] + " ");
            }

            leftUpRow++;
            leftUpColumn++;
            rightDownRow--;
            rightDownColumn--;

        }
    }
}

