package coding_patterns.graphs.hard;
import java.util.Arrays;

public class IsGraphBipertite {

    boolean dfs(int col, int[][] graph, int colors[], int node) {
        colors[node] = col;

        for (int num : graph[node]) {
            if (colors[num] == -1) {
                if (dfs((col == 1 ? 2 : 1), graph, colors, num) == false)
                    return false;
            } else if (colors[num] == col)
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int colors[] = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (dfs(1, graph, colors, i) == false)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
      
    }
}