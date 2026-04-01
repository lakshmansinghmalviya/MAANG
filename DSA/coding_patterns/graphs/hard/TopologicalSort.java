package coding_patterns.graphs.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    void dfs(int node, boolean vis[], List<List<Integer>> adj, Stack<Integer> stack) {
        vis[node] = true;

        for (int n : adj.get(node)) {
            if (!vis[n])
                dfs(n, vis, adj, stack);
        }
        stack.push(node);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        // build the adj list

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int uu = edges[i][0];
            int vv = edges[i][1];
            adj.get(uu).add(vv);
        }

        for (int node = 0; node < V; node++) {
            if (!vis[node]) {
                dfs(node, vis, adj, stack);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.isEmpty())
            list.add(stack.pop());

        return list;
    }
}