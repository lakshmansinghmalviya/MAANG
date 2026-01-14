// https://leetcode.com/problems/max-consecutive-ones-iii/

package coding_patterns.sliding_window_2_pointer;

public class MaxconsicutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int max = 0;
        int zero = 0;

        while (r < nums.length) {

            if (nums[r] == 0)
                zero++;
            // this can be removed think like if the zeros are > k dont update once left
            // make it k<= then we can updat max
            while (zero > k) {
                if (nums[l] == 0)
                    zero--;
                l++;
            }
            if (nums[l] == 0) {
                zero--;
            }

            if (zero <= k)
                max = Math.max(max, r - l + 1);

            r++;
        }
        return max;
    }

    // most opt
    public static int longestOnesOpt(int[] nums, int k) {
        int l = 0, r = 0;
        int max = 0;
        int zero = 0;

        while (r < nums.length) {

            if (nums[r] == 0)
                zero++;
            // this can be removed think like if the zeros are > k dont update once left
            // make it k<= then we can updat max

            if (zero > k) {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }

            if (zero <= k)
                max = Math.max(max, r - l + 1);

            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        // Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        // Output: 6
        // Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        // Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
    }
}