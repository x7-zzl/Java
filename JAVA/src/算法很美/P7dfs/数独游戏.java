package 算法很美.P7dfs;

import java.util.Scanner;
//数独游戏，输入九行数据，1-9，0表示空

/*"
018074000        918374625
600002041        673582941
040010370        245916378
307800000        367825194
000160507        824169537
500040062        591743862
750000400        752691483
000258000        439258716
006000209        186437259
*/
@SuppressWarnings("all")
public class 数独游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = scanner.nextLine().toCharArray();
        }
        dfs(table, 0, 0);
    }

    private static void dfs(char[][] table, int x, int y) {
        if (x == 9) {
            print(table);
            System.exit(0);
        }
        if (table[x][y] == '0') {
            for (int k = 0; k < 10; k++) {
                if (check(table, x, y, k)) {
                    table[x][y] = (char) ('0' + k);
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            table[x][y] = '0';//回溯
        } else {
            dfs(table, x + (y + 1) / 9, (y + 1) % 9);
        }
    }

    private static boolean check(char[][] table, int i, int j, int k) {
        for (int l = 0; l < 9; l++) {
            if (table[i][l] == (char) ('0' + k)) return false;
            if (table[l][j] == (char) ('0' + k)) return false;
        }
        //检查小九宫格
        for (int l = (i / 3) * 3; l < (i / 3 + 1) * 3; l++) {
            for (int m = (j / 3) * 3; m < (j / 3 + 1) * 3; m++) {
                if (table[l][m] == (char) ('0' + k)) return false;
            }
        }
        return true;
    }

    private static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }
}
