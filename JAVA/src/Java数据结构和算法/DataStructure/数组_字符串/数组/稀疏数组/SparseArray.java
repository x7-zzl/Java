package Java数据结构和算法.DataStructure.数组_字符串.数组.稀疏数组;

public class SparseArray {
    public static void main(String[] args) {
        //创建一个11*11的棋盘数组
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        //输出原始的二维数组
        //增强for循环输出二维数组数据
        System.out.println("原始的二维数组:");

        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%2d\t", data);
            }
            System.out.println();
        }

        //稀疏数组
        // 输出数组中非零元素的个数
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                }

            }
        }
        System.out.println("非零元素个数为:" + count);


        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;

        count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];

                }
            }
        }

        System.out.println("得到的稀疏数组是:");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
            System.out.println();
        }
        System.out.println("<------------------>");
        for (int i = 0; i < count + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }

        int[][] chessArray1=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <count+1; i++) {
                chessArray1[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        System.out.println("再将稀疏数组转为原始的二维数组:");
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%2d\t", data);
            }
            System.out.println();
        }
    }

}
