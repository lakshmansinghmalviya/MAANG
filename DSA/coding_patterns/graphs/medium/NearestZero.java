package coding_patterns.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col, increment;

    Pair(int r, int c, int inc) {
        row = r;
        col = c;
        increment = inc;
    }
}

public class NearestZero {

    public int[][] updateMatrix(int[][] mat) {

        Queue<Pair> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row,j = p.col,increment = p.increment;
            int indexes[][] = new int[][] { { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 } };

            for (int ind = 0; ind < indexes.length; ind++) {
                int row = indexes[ind][0];
                int col = indexes[ind][1];

                if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1 && !vis[row][col] && mat[row][col] == 1) {
                    q.offer(new Pair(row, col, increment + 1));
                    vis[row][col] = true;
                    // dont modify the existing array instead creat new
                    mat[row][col] = increment + 1;
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        //
    }
}