// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingCharString {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "sdfsfds";
        System.out.println(lengthOfLongestSubstring(s));
    }
}