package Java数据结构和算法.DataStructure.图.Djikstra算法;


public class DijkstraDemo {
    public static int[] dijkstra(int[][] a, int startVertex) {
        //初始化 以求出最短路径的点 result[]
        int length = a.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = -1;
        }
        result[startVertex] = 0;
        // 初始化 未求出最短路径的点 notFound[]
        int[] notFound = new int[length];
        for (int i = 0; i < length; i++) {
            notFound[i] = a[startVertex][i];
        }
        notFound[startVertex] = -1;
        // 开始 Dijkstra 算法
        for (int i = 1; i < length; i++) {
            //1. 从「未求出最短路径的点」notFound 中取出 最短路径的点
            //1.1 找到最短距离的点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (notFound[j] > 0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }
            //1.2 将最短距离的点 取出 放入结果中
            result[minIndex] = min;
            notFound[minIndex] = -1;
            //2. 刷新 「未求出最短距离的点」 notFound[] 中的距离
            //2.1 遍历刚刚找到最短距离的点 (B) 的出度 (BA、BB、BC、BD)
            for (int j = 0; j < length; j++) {
                // 出度可通行(例如 BD:graph[1][3]  > 0)
                // 出度点不能已经在结果集 result中(例如 D: result[3] == -1)
                if (a[minIndex][j] > 0  && result[j] == -1) {
                    int newDistance = result[minIndex] + a[minIndex][j];
                    //通过 B 为桥梁，刷新距离
                    //（比如`AD = 6 < AB + BD = 4` 就刷新距离）（ -1 代表无限大）
                    if (newDistance < notFound[j] || notFound[j] == -1) {
                        notFound[j] = newDistance;
                    }
                }
            }

        }
        return result;
    }

    /**
     * 测试案例
     */
    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
//        int[][] graph = new int[][]{
//                {0, 2, -1, 6}
//                , {2, 0, 3, 2}
//                , {-1, 3, 0, 2}
//                , {6, 2, 2, 0}};

        int n = -1;//表示不可连接
        int[][] graph = new int[][]{
                {0, 3, 8, n, n, n, 7, n},
                {3, 0, n, n, 7, n, 5, n},
                {8, n, 0, n, n, 10, 9, n},
                {n, n, n, 0, 11, n, n, 14},
                {n, 7, n, 11, 0, n, n, 27},
                {n, n, 10, n, n, 0, 6, 13},
                {7, 5, 9, n, n, 6, 0, n},
                {n, n, n, 14, 27, 13, n, 0}
        };
        int[] dijkstra = dijkstra(graph, 6);
        for (int i : dijkstra) {
            System.out.print(i+" ");
        }
    }
}
