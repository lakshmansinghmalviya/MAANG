
// https://leetcode.com/problems/number-of-enclaves/https://leetcode.com/problems/number-of-enclaves/

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class NumberOfEnclave {
    void fillOneRowOrColInQ(int rowOrCol, int n, boolean[][] vis, Queue<Pair> q, int[][] grid, boolean isRow) {
        for (int i = 0; i < n; i++) {
            if (isRow) {
                if (!vis[rowOrCol][i] && grid[rowOrCol][i] == 1) {
                    vis[rowOrCol][i] = true;
                    q.offer(new Pair(rowOrCol, i));
                }
            } else {
                if (!vis[i][rowOrCol] && grid[i][rowOrCol] == 1) {
                    vis[i][rowOrCol] = true;
                    q.offer(new Pair(i, rowOrCol));
                }
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        fillOneRowOrColInQ(0, n, vis, q, grid, true);
        fillOneRowOrColInQ(m - 1, n, vis, q, grid, true);
        fillOneRowOrColInQ(0, m, vis, q, grid, false);
        fillOneRowOrColInQ(n - 1, m, vis, q, grid, false);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;

            int[][] indexes = new int[][] { { i - 1, j }, { i + 1, j }, { i, j - 1 }, { i, j + 1 } };

            for (int ind = 0; ind < indexes.length; ind++) {
                int row = indexes[ind][0];
                int col = indexes[ind][1];
                if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1 && !vis[row][col] && grid[row][col] == 1) {
                    vis[row][col] = true;
                    q.offer(new Pair(row, col));
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1)
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
