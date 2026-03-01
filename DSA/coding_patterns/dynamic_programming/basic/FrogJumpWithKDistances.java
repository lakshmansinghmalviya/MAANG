// https://takeuforward.org/plus/dsa/problems/frog-jump-with-k-distances?tab=description

package coding_patterns.dynamic_programming.basic;

import java.util.Arrays;

public class FrogJumpWithKDistances {

    public static int frogJumpWithKDistances(int arr[], int[] dp, int index, int k) {
        if (index >= arr.length - 1)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int minStep = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index + i < arr.length) {
                int currenMinSteps = frogJumpWithKDistances(arr, dp, index + i, k)
                        + Math.abs(arr[index] - arr[index + i]);
                minStep = Math.min(minStep, currenMinSteps);
            }
        }
        return dp[index] = minStep;
    }

    public static void main(String[] args) {
        // print n-1;
        int arr[] = { 10, 5, 20, 0, 15 };
        int k = 2;
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpWithKDistances(arr, dp, 0, k));// 15
    }
}