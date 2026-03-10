// https://leetcode.com/problems/rotting-oranges/

package coding_patterns.graphs.medium;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i, j, val, increment;

    Pair(int i, int j, int val, int increment) {
        this.i = i;
        this.j = j;
        this.val = val;
        this.increment = increment;
    }
}

public class RottenOranges {
    
    int fillMatrics(int row, int col, int val, int increment, Queue<Pair> q, int grid[][]) {
        q.offer(new Pair(row, col, val, increment));
        grid[row][col] = val;
        return increment;
    }

    int[] fillInQueue(Pair p, Queue<Pair> q, int m, int n, int[][] grid, boolean vis[][], int cntFresh) {

        int i = p.i, j = p.j, val = p.val, increment = p.increment;
        int max = increment;
        // int prevCol = j - 1, nextCol = j + 1, topRow = i - 1, bottomRow = i + 1;
        vis[i][j] = true;

        // we can reduce this by running a loop and keeping these values in the the
        // array and check similarly for col & row
        int[][] indexes = new int[][] { { i, j - 1 }, { i, j + 1 }, { i - 1, j }, { i + 1, j } };

        for (int ind = 0; ind < indexes.length; ind++) {
            int row = indexes[ind][0];
            int col = indexes[ind][1];
            
            if (col >= 0 && col <= n - 1 && row >= 0 && row <= m - 1 && !vis[row][col] && grid[row][col] == 1) {
                int curIncrement = fillMatrics(row, col, val, increment + 1, q, grid);
                max = Math.max(max, curIncrement);
                cntFresh = cntFresh - 1;
            }
        }
        // // check left
        // if (prevCol >= 0 && !vis[i][prevCol] && grid[i][prevCol] == 1) {
        // int curIncrement = fillMatrics(i, prevCol, val, increment + 1, q, grid);
        // max = Math.max(max, curIncrement);
        // cntFresh = cntFresh - 1;
        // }
        // // check right
        // if (nextCol <= n - 1 && !vis[i][nextCol] && grid[i][nextCol] == 1) {
        // int curIncrement = fillMatrics(i, nextCol, val, increment + 1, q, grid);
        // max = Math.max(max, curIncrement);
        // cntFresh = cntFresh - 1;
        // }
        // //check top
        // if (topRow >= 0 && !vis[topRow][j] && grid[topRow][j] == 1) {
        // int curIncrement = fillMatrics(topRow, j, val, increment + 1, q, grid);
        // max = Math.max(max, curIncrement);
        // cntFresh = cntFresh - 1;
        // }
        // //check bottom
        // if (bottomRow <= m - 1 && !vis[bottomRow][j] && grid[bottomRow][j] == 1) {
        // int curIncrement = fillMatrics(bottomRow, j, val, increment + 1, q, grid);
        // max = Math.max(max, curIncrement);
        // cntFresh = cntFresh - 1;
        // }
        return new int[] { max, cntFresh };
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length, max = 0, cntFresh = 0;
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // dont even require to put the val but its fine
                if (grid[i][j] == 2)
                    q.offer(new Pair(i, j, grid[i][j], 0));
                if (grid[i][j] == 1)
                    cntFresh++;
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int arr[] = fillInQueue(p, q, m, n, grid, vis, cntFresh);
            cntFresh = arr[1];
            max = Math.max(max, arr[0]);
        }

        // we can count it while adding how many fresh are there and then while
        // making them rotten we can decrement then we can remove this loop

        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (grid[i][j] == 1)
        // return -1;
        // }
        // }

        if (cntFresh != 0)
            return -1;

        return max;
    }
}