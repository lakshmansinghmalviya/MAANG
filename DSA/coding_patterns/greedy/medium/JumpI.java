// https://leetcode.com/problems/jump-game/description/

package medium;

public class JumpI {

    // Notes to give interviewer
    // if we have 0 nowhere we will be able to reach at the end

    public boolean canJump(int[] nums) {

        // int i = 0;

        // while (i != nums.length - 1 && i < nums.length) {
        // i = i + nums[i];
        // if (i < nums.length && nums[i] == 0 && i != nums.length - 1)
        // return false;
        // }

        // return i >= nums.length - 1;

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex)
                return false;
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
