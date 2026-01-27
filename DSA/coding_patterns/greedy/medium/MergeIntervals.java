// https://leetcode.com/problems/merge-intervals/

package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] arr) {

        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int min = arr[0][0];
        int max = arr[0][1];

        for (int i = 1; i < arr.length; i++) {
            int curMin = arr[i][0];
            int curMax = arr[i][1];
            if (max >= curMin) {
                if (max < curMax)
                    max = curMax;
            } else {
                list.add(new int[] { min, max });
                min = curMin;
                max = curMax;
            }
        }
        list.add(new int[] { min, max });

        return list.toArray(new int[][] {});
    }

    public static void main(String[] args) {
    }
}
