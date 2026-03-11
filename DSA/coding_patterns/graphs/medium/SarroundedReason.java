// https://leetcode.com/problems/surrounded-regions/description/

package coding_patterns.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

public class SarroundedReason {

    void fillRowInQueue(char[][] board, int row, int n, boolean vis[][], Queue<Pair> q) {
        for (int i = 0; i < n; i++) {
            if (!vis[row][i] && board[row][i] == 'O') {
                vis[row][i] = true;
                q.offer(new Pair(row, i));
            }
        }
    }

    void fillColInQueue(char[][] board, int col, int n, boolean vis[][], Queue<Pair> q) {
        for (int i = 0; i < n; i++) {
            if (!vis[i][col] && board[i][col] == 'O') {
                vis[i][col] = true;
                q.offer(new Pair(i, col));
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        fillRowInQueue(board, 0, n, vis, q);
        fillRowInQueue(board, m - 1, n, vis, q);
        fillColInQueue(board, 0, m, vis, q);
        fillColInQueue(board, n - 1, m, vis, q);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.row;
            int j = p.col;
            int indexes[][] = new int[][] { { i + 1, j }, { i - 1, j }, { i, j - 1 }, { i, j + 1 } };

            for (int ind = 0; ind < indexes.length; ind++) {
                int row = indexes[ind][0];
                int col = indexes[ind][1];

                if (row >= 0 && row <= m - 1 && col >= 0 && col <= n - 1 && !vis[row][col] && board[row][col] == 'O') {
                    q.offer(new Pair(row, col));
                    vis[row][col] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}