// https://leetcode.com/problems/non-overlapping-intervals/description/

package medium;

import java.util.Arrays;

public class NonOverlapingIntevals {

    // N max meetings in one room we did solve and then we can reduce this number
    // with total we will get the ans

    public int eraseOverlapIntervals(int[][] arr) {

        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int previousLastMeeting = arr[0][1];
        int cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= previousLastMeeting) {
                previousLastMeeting = arr[i][1];
                cnt++;
            }
        }
        return arr.length - cnt;
    }

    public static void main(String[] args) {

    }
}
