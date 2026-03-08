// https://leetcode.com/problems/flood-fill/description/

package coding_patterns.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;
    int val; // optional to understand better

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        int start = image[sr][sc], m = image.length, n = image[0].length;
        boolean vis[][] = new boolean[m][n];

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row, j = p.col;
            int indexes[][] = new int[][] { { i, j - 1 }, { i, j + 1 }, { i - 1, j }, { i + 1, j } };
            vis[i][j] = true;
            image[i][j] = color;

            for (int ind = 0; ind < indexes.length; ind++) {
                int row = indexes[ind][0], col = indexes[ind][1];

                if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1 && !vis[row][col]
                        && image[row][col] == start) {
                    // image[row][col]=color;
                    q.offer(new Pair(row, col));
                }
            }
        }

        return image;
    }
}