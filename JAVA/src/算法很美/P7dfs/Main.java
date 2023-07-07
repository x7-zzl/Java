package 算法很美.P7dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    // bool数组用来判断搜索的下一个位置是否可行
    // col列，dg对角线，udg反对角线
    // g[N][N]用来存路径
    public static int N = 20;
    public static char[][] g = new char[N][N];
    public static boolean[] col = new boolean[N], dg = new boolean[N], udg = new boolean[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                g[i][j] = '.';
            }
        }

        dfs(0);
        bufferedReader.close();
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i ++) {
                for (int j = 0; j < n; j ++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i ++) {
            // 剪枝(对于不满足要求的点，不再继续往下搜索)
            // udg[n - u + i]，+n是为了保证下标非负
            if (!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1);
                // 恢复现场
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '.';
            }
        }
    }
}

