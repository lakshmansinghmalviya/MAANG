// https://leetcode.com/problems/insert-interval/

package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    // brute force is to make new n+1 array and then sort it and do the merge
    // interval question

    // optimized one or optimal one
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        int min = newInterval[0];
        int max = newInterval[1];
        // we can remove these variable and use the newInterval itself

        while (i < n && max >= intervals[i][0]) {
            min = Math.min(intervals[i][0], min);
            max = Math.max(intervals[i][1], max);
            i++;
        }

        list.add(new int[] { min, max });

        while (i < n) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[][] {});
    }

    public static void main(String[] args) {

    }
}