// https://leetcode.com/problems/climbing-stairs/

import java.util.Arrays;

public class ClimbStairs {
    public int climb(int n, int s, int[] dp) {
        if (s == n)
            return 1;
        if (s > n)
            return 0;
        if (dp[s] != -1)
            return dp[s];
        int one = climb(n, s + 1, dp);
        int two = climb(n, s + 2, dp);
        dp[s] = one + two;
        return one + two;
    }

    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n, 0, dp);
    }

    public static void main(String[] args) {

    }
}
