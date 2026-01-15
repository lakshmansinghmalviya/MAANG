// https://leetcode.com/problems/fruit-into-baskets/

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FruitsBasket {

    public int totalFruitMostOptimal(int[] arr) {

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int l = 0, r = 0, max = 0;

        while (r < arr.length) {

            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            if (map.size() > 2) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.getOrDefault(arr[l], 0) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            if (map.size() <= 2) {
                max = Math.max(max, r - l + 1);
            }
            r++;
        }

        return max;
    }

    public static void main(String[] args) {
        // Input: fruits = [1,2,1]
        // Output: 3
        // Explanation: We can pick from all 3 trees.
    }

    public int totalFruit(int[] arr) {

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int l = 0, r = 0, max = 0;

        while (r < arr.length) {

            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if (map.getOrDefault(arr[l], 0) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}