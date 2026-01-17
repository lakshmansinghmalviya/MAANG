// https://leetcode.com/problems/binary-subarrays-with-sum/

package coding_patterns.sliding_window_2_pointer;

public class BinarySubArrayWithSumK {

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

    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 1, 1, 0 };
        System.out.println(new BinarySubArrayWithSumK().numSubarraysWithSum(arr, 2));
    }
}