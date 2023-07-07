package Java数据结构和算法.DataStructure.数组_字符串.数组.稀疏数组;

import java.io.*;

//3.1.4课后练习
// 要求:
//1)在前面的基础上，将稀疏数组保存到磁盘上，比如map.data
// 2)恢复原来的数组时，读取 map.data进行恢复
public class 将稀疏数组保存到磁盘 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\umr\\tamako\\map.txt"));

        StringBuilder sb = new StringBuilder("原数组为:\n");

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
                sb.append(data + "\t");
            }
            System.out.println();
            sb.append("\n");
        }

//        bw.write(String.valueOf(sb));
//        bw.flush();
//        bw.newLine();

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
//        for (int i = 0; i < sparseArray.length; i++) {
//            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
//            System.out.println();
//        }
//        System.out.println("<------------------>");

        sb.append("稀疏数组为:\n");
        for (int i = 0; i < count + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
                sb.append(sparseArray[i][j]+"\t");
            }
            System.out.println();
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

        System.out.println("从文件中读取的数据为:");
        BufferedReader br=new BufferedReader(new FileReader("D:\\umr\\tamako\\map.txt"));
        String data=br.readLine();
        while ((data=br.readLine())!=null){
            System.out.println(data);
        }

    }
}
