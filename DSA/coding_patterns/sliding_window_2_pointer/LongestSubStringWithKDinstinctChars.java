// https://takeuforward.org/plus/dsa/problems/longest-substring-with-at-most-k-distinct-characters

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDinstinctChars {

    int longestSubStringWithKDinstinctChars(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int max = 0;

        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                if (map.getOrDefault(s.charAt(l), 0) <= 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
