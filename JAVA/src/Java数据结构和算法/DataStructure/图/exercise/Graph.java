package Java数据结构和算法.DataStructure.图.exercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private final ArrayList<String> vertexList = new ArrayList<>();//存储顶点集合
    private final int[][] adjacencyMatrix; //存储图对应的邻结矩阵
    private int sides = 0;//表示边的数目
    private boolean[] isVisited;

    //构造器
    public Graph(int n) {
        adjacencyMatrix = new int[n][n];
        isVisited = new boolean[n];
    }

    public static void main(String[] args) {
        //测试一把图是否创建ok
        int n = 8;  //结点的个数
        //String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E
//		graph.insertEdge(0, 1, 1); // A-B
//		graph.insertEdge(0, 2, 1); //
//		graph.insertEdge(1, 2, 1); //
//		graph.insertEdge(1, 3, 1); //
//		graph.insertEdge(1, 4, 1); //

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();


        /*     深度优先遍历算法步骤
        1) 访问初始结点 v，并标记结点 v 为已访问。
        2) 查找结点 v 的第一个邻接结点 w。
        3) 若 w 存在，则继续执行 4，如果 w 不存在，则回到第 1 步，将从 v 的下一个结点继续。
        4) 若 w 未被访问，对 w 进行深度优先遍历递归（即把 w 当做另一个 v，然后进行步骤 123）。
        5) 查找结点 v 的 w 邻接结点的下一个邻接结点，转到步骤 3*/

        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
        System.out.println();

       /* 广度优先遍历算法步骤
        1) 访问初始结点 v 并标记结点 v 为已访问。
        2) 结点 v 入队列
        3) 当队列非空时，继续执行，否则算法结束。
        4) 出队列，取得队头结点 u。
        5) 查找结点 u 的第一个邻接结点 w。
        6) 若结点 u 的邻接结点 w 不存在，则转到步骤 3；否则循环执行以下三个步骤：
        6.1 若结点 w 尚未被访问，则访问结点 w 并标记为已访问。
        6.2 结点 w 入队列
        6.3 查找结点 u 的继 w 邻接结点后的下一个邻接结点 w，转到步骤 6*/
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]

    }

    //图中常用的方法
//    //返回结点的个数
//    public int getNumOfVertex() {
//        return vertexList.size();
//    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : adjacencyMatrix) {
            System.err.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getSides() {
        return sides;
    }

//    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
//    public String getValueByIndex(int i) {
//        return vertexList.get(i);
//    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return adjacencyMatrix[v1][v2];
    }


    //得到第一个邻接结点的下标 w
    public int getFirstNeighbor(int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (adjacencyMatrix[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (adjacencyMatrix[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    public void dfs(boolean[] isVisited, int i) {
        System.out.println(vertexList.get(i));

        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, i);
            }
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    public void bfs(boolean isVisited[],int i){
        System.out.println(vertexList.get(i));
        int u; // 表示队列的头结点对应下标
        int w; // 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList<Integer> queue = new LinkedList<Integer>();
        isVisited[i]=true;
        queue.addLast(i);

        while (!queue.isEmpty()){
            u=queue.removeFirst();
            w=getFirstNeighbor(u);
            while (w!=-1){
                if(isVisited[i]){
                    System.out.println(vertexList.get(i));
                    isVisited[i]=true;
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs(){
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }
    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边

    /**
     * @param v1     表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2     第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        adjacencyMatrix[v1][v2] = weight;
        adjacencyMatrix[v2][v1] = weight;
        sides++;
    }
}
