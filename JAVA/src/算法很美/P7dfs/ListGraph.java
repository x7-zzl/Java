package 算法很美.P7dfs;

import java.util.ArrayList;
//有向图的遍历
public class ListGraph {
    ArrayList<ArrayList<Integer>> graphs;

    public ListGraph(int v) {
        graphs = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge(int start, int end) {
        graphs.get(start).remove((Integer) end);
    }


}

