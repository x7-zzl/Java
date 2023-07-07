package 算法很美.P4二维数组和矩阵;

@SuppressWarnings("ALL")
public class 顺时针打印二维数组 {
    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 3, 4, 5, 9},
                {4, 8, 9, 1, 6, 7},
                {3, 5, 7, 1, 7, 6},
                {4, 8, 4, 2, 9, 3},
                {5, 6, 1, 8, 9, 4}};

        print(a);

    }

    private static void print(int[][] a) {
        int leftUpRow = 0, leftUpColumn = 0,
                rightDownRow = a.length - 1, rightDownColumn = a[0].length - 1;
        while (leftUpRow <= rightDownRow && leftUpColumn <= rightDownColumn) {
            int r = leftUpRow, c = leftUpColumn;
            //上面一条边
            while (c <= rightDownColumn) {
                System.out.print(a[r][c++] + " ");
            }
            //恢复
            c = rightDownColumn;
            r++;
            //右边的一条边
            while (r <= rightDownRow) {
                System.out.print(a[r++][c] + " ");
            }
            //恢复
            r = rightDownRow;
            c--;
            //下面一条边
            while (c >= leftUpRow) {
                System.out.print(a[r][c--] + " ");
            }
            //恢复
            c = leftUpColumn;
            r--;
            //左面一条边
            while (r > leftUpRow) {
                System.out.print(a[r--][c] + " ");
            }
            leftUpRow++;
            leftUpColumn++;
            rightDownRow--;
            rightDownColumn--;
        }
    }
}
