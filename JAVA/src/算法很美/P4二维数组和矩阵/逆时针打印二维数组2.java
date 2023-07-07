package 算法很美.P4二维数组和矩阵;

@SuppressWarnings("all")
public class 逆时针打印二维数组2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 8},
                {16, 17, 18, 19, 6, 8},
                {15, 24, 25, 20, 7, 8},
                {14, 23, 22, 21, 8, 8},
                {13, 12, 11, 10, 9, 8}};

        int leftUpRow = 0;
        int leftUpColumn = 0;
        int rightDownRow = matrix.length - 1;
        int rightDownColumn = matrix[0].length - 1;

        // 打印行right
        while (leftUpRow <= rightDownRow && leftUpColumn <= rightDownColumn) {

            for (int j = leftUpColumn; j < rightDownColumn; j++) {
                System.out.print(matrix[leftUpRow][j] + " ");
            }

            for (int i = leftUpRow; i < rightDownRow; i++) {
                System.out.print(matrix[i][rightDownColumn] + " ");
            }

            //往回退的时候需要加个处理，就是防止重复打印
            for (int j = rightDownColumn; j > leftUpColumn; j--) {

                System.out.print(matrix[rightDownRow][j] + " ");
                if (leftUpRow == rightDownRow) {
                    break;
                }
            }

            for (int i = rightDownRow; i > leftUpRow; i--) {
                System.out.print(matrix[i][leftUpColumn] + " ");
                if (leftUpColumn == rightDownColumn) {
                    break;
                }
            }
            leftUpRow++;
            leftUpColumn++;
            rightDownRow--;
            rightDownColumn--;
        }

    }

}