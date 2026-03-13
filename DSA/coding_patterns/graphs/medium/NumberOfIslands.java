// https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class NumberOfIslands {

    void bfs(Queue<Pair> q, boolean[][] vis, int iInd, int jInd, int m, int n, char[][] grid) {

        q.offer(new Pair(iInd, jInd));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            vis[i][j] = true;

            int[][] indexes = new int[][] { { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 } };

            for (int ind = 0; ind < indexes.length; ind++) {
                int row = indexes[ind][0];
                int col = indexes[ind][1];

                if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1 && !vis[row][col]
                        && grid[row][col] == '1') {
                    vis[row][col] = true;
                    q.offer(new Pair(row, col));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int cnt = 0;

        for (int iInd = 0; iInd < m; iInd++) {
            for (int jInd = 0; jInd < n; jInd++) {
                if (grid[iInd][jInd] == '1' && !vis[iInd][jInd]) {
                    cnt++;
                    bfs(q, vis, iInd, jInd, m, n, grid);
                }
            }
        }
        return cnt;
    }
}
