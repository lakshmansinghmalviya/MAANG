// https://takeuforward.org/plus/dsa/problems/frog-jump

package coding_patterns.dynamic_programming.basic;

import java.util.Arrays;

public class FrogJump {

    public int minimumFrogJump(int arr[], int index) {
        if (index >= arr.length)
            return 0;

        int left = minimumFrogJump(arr, index + 1) + Math.abs(arr[index] - arr[index + 1]);
        int right = 0;
        if (index > 1)
            right = minimumFrogJump(arr, index + 2) + Math.abs(arr[index] - arr[index + 2]);

        return Math.min(left, right);
    }

    public static int minimumFrogJump(int arr[], int index, int dp[]) {
        if (index >= arr.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int left = 0, right = 0;
        if (index < arr.length - 1)
            left = minimumFrogJump(arr, index + 1, dp) + Math.abs(arr[index] - arr[index + 1]);
        if (index < arr.length - 2)
            right = minimumFrogJump(arr, index + 2, dp) + Math.abs(arr[index] - arr[index + 2]);
            
        dp[index] = Math.min(left, right);

        // return Math.min(left, right);
        return dp[index];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 5, 4 };
        int n = arr.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(minimumFrogJump(arr, 0, dp));
    }
}