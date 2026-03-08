// https://leetcode.com/problems/number-of-provinces/

package coding_patterns.graphs.basic;

import java.util.ArrayList;
import java.util.List;

public class ProvincesInGraph {

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

        for (int i = 0; i < vetex; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u); // because undirected
        }

        for (int i = 0; i < vetex; i++) {
            if (!vis[i]) {
                List<Integer> list = new ArrayList<>();
                dfs(adj, list, i, vis);
                res.add(list);
            }
        }
        System.out.println("The dfs size is " + res.size());
        return res;
    }

    public int findCircleNum(int[][] connects) {
        int n = connects.length;

        List<List<Integer>> edges = new ArrayList<>();
        // convert matrix to edges in list format
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && connects[i][j] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    edges.add(temp);
                }
            }
        }

        int cnt = depthFirstSearch(n, 0, edges).size();
        return cnt;
    }

    public static void main(String[] args) {
        // num of provinces
        // its just to solve the unconnect components problems
        // means to print all the components which are linked to each other in one and
        // others in the newer list
        // no need to store in the list but its fine
    }
}