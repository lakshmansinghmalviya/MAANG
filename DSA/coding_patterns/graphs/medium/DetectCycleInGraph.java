// https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-an-undirected-graph?source=strivers-a2z-dsa-track

package coding_patterns.graphs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int val, cameFrom;

    Pair(int v, int c) {
        val = v;
        cameFrom = c;
    }
}

public class DetectCycleInGraph {

    boolean checkForCycle(int n, List<Integer>[] adj, boolean vis[]) {
        vis[n] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(n, -1));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int current = p.val;
            int parent = p.cameFrom;

            // explore all neighbours of the current dont write ad[n]
            for (int ajdNode : adj[current]) {
                if (!vis[ajdNode]) {
                    vis[ajdNode] = true;
                    q.offer(new Pair(ajdNode, current));
                } else if (parent != ajdNode)
                    return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                // if any connected compo gives then it has a cylce
                if (checkForCycle(i, adj, vis))
                    return true;
            }
        }
        return false;
    }
}
