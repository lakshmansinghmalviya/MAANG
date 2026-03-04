// https://www.naukri.com/code360/problems/dfs-traversal_630462

package coding_patterns.graphs.basic;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {

    public static void dfs(List<List<Integer>> adj, List<Integer> components, int node, boolean[] vis) {
        vis[node] = true;
        components.add(node);
        for (int n : adj.get(node)) {
            if (!vis[n])
                dfs(adj, components, n, vis);
        }
    }

    public static List<List<Integer>> depthFirstSearch(int vetex, int e, List<List<Integer>> edges) {
        if (edges == null)
            return new ArrayList<>();
        boolean vis[] = new boolean[vetex];
        List<List<Integer>> res = new ArrayList<>();


                // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <vetex; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);  // because undirected
        }


        for (int i = 0; i < vetex; i++) {
            if (!vis[i]) {
                List<Integer> list = new ArrayList<>();
                dfs(adj, list, i, vis);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}