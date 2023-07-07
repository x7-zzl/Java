package 算法很美.P7dfs;
//dfs遍历

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class GraphTraversal {
    ListGraph graph;
    boolean[] visited;

    public GraphTraversal(ListGraph listGraph) {
        this.graph = listGraph;
        visited = new boolean[listGraph.graphs.size()];
    }


    public void DFSTraversal(int v) {
        if (visited[v]) return;
        visited[v] = true;
        System.out.print(v + "-> ");
        Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
        while (neighbors.hasNext()) {
            int nextNode = neighbors.next();
            if (!visited[nextNode]) {
                DFSTraversal(nextNode);
            }
        }
    }

    public void DFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                DFSTraversal(i);
            }
        }
    }


    //BFS图遍历
    public void BFSTraversal(int v) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerFirst(v);
        while (queue.size() != 0) {
            Integer cur = queue.pollFirst();
            System.out.print(cur + " -> ");
            Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();
            while (neighbors.hasNext()) {
                int nextNode = neighbors.next();
                if (!visited[nextNode]) {
                    queue.offerLast(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public void BFS() {
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                BFSTraversal(i);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
