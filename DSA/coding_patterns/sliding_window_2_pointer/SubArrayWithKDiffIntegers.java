// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;

public class SubArrayWithKDiffIntegers {
        int findBinarySubArrayWithSumKOrLesser(int arr[], int k) {
        int cnt = 0;
        int l = 0, r = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            // System.out.println(sum + " " + goal);
            while (map.size() > k) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.getOrDefault(arr[l], 0) <= 0)
                    map.remove(arr[l]);
                l++;
            }
            if (map.size() <= k) {
                cnt += (r - l + 1);
            }
            r++;
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return findBinarySubArrayWithSumKOrLesser(nums, k) - findBinarySubArrayWithSumKOrLesser(nums, k - 1);
    }

    public static void main(String[] args) {
        // exactly same as NumberOfNiceArrays.java
    }
}
