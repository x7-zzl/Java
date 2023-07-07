package 算法很美.P2递归;
//汉诺塔游戏
/*初始时，圆盘都在A上，将A上的所有圆盘都移动到C盘上，B盘为辅助盘
移动过程中保持盘号小的在盘号大的上面*/

import java.util.Scanner;

public class 递归实现汉诺塔 {
    public static void main(String[] args) {
        System.out.println("输入A台上圆盘的个数:");
        int n = new Scanner(System.in).nextInt();
        printHanoiTower(n, "Parent", "C", "B");
    }

    static void printHanoiTower(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("把 " + n + " 号圆盘从 " + from + " 台移动到 " + to);
        } else {
            printHanoiTower(n - 1, from, help, to);
            System.out.println("把 " + n + " 号圆盘从 " + from + " 台移动到 " + to);
            printHanoiTower(n - 1, help, to, from);

        }
    }
}