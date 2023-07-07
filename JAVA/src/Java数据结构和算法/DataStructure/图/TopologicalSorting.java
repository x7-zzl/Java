package Java数据结构和算法.DataStructure.图;

import java.util.Stack;
//拓朴排序
public class TopologicalSorting {

    //方法2：基于深度优先查找发（DFS）获取拓扑排序
    public Stack<Character> result1;
    /*
     * adjMatrix是待遍历图的邻接矩阵
     * value是待遍历图顶点用于是否被遍历的判断依据，0代表未遍历，非0代表已被遍历
     */
    public void dfs(int[][] adjMatrix, boolean[] isVisited) {
        result1 = new Stack<Character>();
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i])
                dfsVisit(adjMatrix, isVisited, i);
        }
    }

    /*
     * adjMatrix是待遍历图的邻接矩阵
     * value是待遍历图顶点用于是否被遍历的判断依据，0代表未遍历，非0代表已被遍历
     * number是当前正在遍历的顶点在邻接矩阵中的数组下标编号
     */
    public void dfsVisit(int[][] adjMatrix, boolean[] isVisited, int number) {
        isVisited[number] = true;               //把++count1赋值给当前正在遍历顶点判断值数组元素，变为非0，代表已被遍历
        for (int i = 0; i < isVisited.length; i++) {
            if (adjMatrix[number][i] == 1 && !isVisited[i])         //当，当前顶点的相邻有相邻顶点可行走且其为被遍历
                dfsVisit(adjMatrix, isVisited, i);   //执行递归，行走第i个顶点
        }
        char temp = (char) ('a' + number);
        result1.push(temp);
    }

    public static void main(String[] args) {
        TopologicalSorting test = new TopologicalSorting();
        int[][] adjMatrix = {{0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};

        boolean[] isVisited = new boolean[5];
        test.dfs(adjMatrix, isVisited);
        System.out.println("使用ＤＦＳ方法得到拓扑排序序列的逆序：");
        System.out.println(test.result1);
        System.out.println("使用ＤＦＳ方法得到拓扑排序序列：");
        while (!test.result1.empty())
            System.out.print(test.result1.pop() + "\t");


    }
}
