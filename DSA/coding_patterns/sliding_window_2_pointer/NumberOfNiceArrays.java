// https://leetcode.com/problems/count-number-of-nice-subarrays/

package coding_patterns.sliding_window_2_pointer;

public class NumberOfNiceArrays {

    int findBinarySubArrayWithSumKOrLesser(int arr[], int goal) {
        int cnt = 0;
        int l = 0, r = 0;
        int sum = 0;

        while (r < arr.length) {
            sum += arr[r];
            // System.out.println(sum + " " + goal);
            while (sum > goal || goal < 0) {
                if (goal < 0)
                    break;
                sum = sum - arr[l];
                l++;
            }

            if (sum <= goal) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return findBinarySubArrayWithSumKOrLesser(nums, goal) - findBinarySubArrayWithSumKOrLesser(nums, goal - 1);
    }

    public int numberOfSubarrays(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }
        // or while running in the loop while counting you can do the modulo

        return numSubarraysWithSum(nums, k);
    }

    public static void main(String[] args) {
        // /Hint from the binary subarray sum with k

        // Input: nums = [1,1,2,1,1], k = 3
        // Output: 2
        // Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and
        // [1,2,1,1].
    }
}
