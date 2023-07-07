package 算法很美.P7dfs;

import java.util.Scanner;

@SuppressWarnings("all")
public class 素数环 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] r = new int[n];
        r[0] = 1;
        dfs(n, r, 1);
    }

    private static void dfs(int n, int[] r, int cur) {
        if (cur == n && isP(r[0] + r[n - 1])) {
            print(r);
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (check(r, i, cur)) {
                r[cur] = i;
                dfs(n, r, cur + 1);
                r[cur] = 0;
            }
        }
    }

    private static void print(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + (i == r.length - 1 ? " " : " "));
        }
        System.out.println();
    }

    private static boolean check(int[] r, int i, int cur) {
        for (int e : r) {
            if (e == i || !isP(r[cur - 1] + i)) return false;
        }
        return true;
    }

    private static boolean isP(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % 2 == 0) return false;
        }
        return true;
    }
}
