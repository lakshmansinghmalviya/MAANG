// https://leetcode.com/problems/jump-game-ii/description/

package medium;

public class JumpII {

    public int jump(int[] nums) {
        return jumpHelper(nums, 0, 0);
    }

    // dry run bro and time limit exceeded
    public int jumpHelper(int arr[], int index, int jump) {

        if (index >= arr.length - 1)
            return jump;

        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            mini = Math.min(mini, jumpHelper(arr, index + i, jump + 1));
        }
        return mini;
    }
}
