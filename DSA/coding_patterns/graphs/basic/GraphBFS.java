// https://www.naukri.com/code360/problems/bfs-in-graph_973002

package coding_patterns.graphs.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean vis[] = new boolean[n];
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> list = adj.get(node);
            res.add(node);

            for (int element : list) {
                if (!vis[element]) {
                    // if dont do then other list may have its upper saying my neoughbour and same
                    // upper is saying
                    vis[element] = true;
                    queue.offer(element);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}