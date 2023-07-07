package leetcode;

public class t2432_处理用时最长的那个任务的员工 {
    public static void main(String[] args) {
        int n = 10;
        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        int i = hardestWorker(n, logs);
        System.out.println(i);
    }

    public static int hardestWorker(int n, int[][] logs) {
        //res返回结果
        int res = logs[0][0], max = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            //储存差值
            int ct = logs[i][1] - logs[i - 1][1];

            //相同时返回序号更加小的
            if (ct > max || (ct == max && logs[i][0] < res)) {
                res = logs[i][0];
                max = ct;
            }
        }
        return res;
    }
}
