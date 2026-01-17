// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

package coding_patterns.sliding_window_2_pointer;

public class MaximumPointObtainFromCard {
    public int maxScore(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int sum2 = 0;

        while (l < k) {
            sum += arr[l];
            max = Math.max(max, sum);
            l++;
        }
        l--;

        while (r >= arr.length - k) {
            sum -= arr[l--];
            // max = Math.max(max, sum);
            sum2 += arr[r--];
            // max = Math.max(max, sum2);
            max = Math.max(max, sum + sum2);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}