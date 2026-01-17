// https://leetcode.com/problems/minimum-window-substring/.

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;

public class MinimumWindowString {

    // Do pen & paper for most clearity as my register is fulled hahaha

    public String minWindow(String s, String t) {
        int sIndex = -1, l = 0, r = 0, cnt = 0, minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        while (r < s.length()) {

            if (map.getOrDefault(s.charAt(r), 0) >= 1) {
                cnt++;
            }

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);

            while (cnt == t.length()) {

                if (minLen > (r - l + 1)) {
                    sIndex = l;
                    minLen = r - l + 1;
                }

                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) + 1);
                if (map.getOrDefault(s.charAt(l), 0) >= 1)
                    cnt--;

                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {

    }

    // public String minWindow(String s, String t) {
    // int sIndex = -1;
    // int minLen = Integer.MAX_VALUE;

    // for (int i = 0; i < s.length(); i++) {
    // HashMap<Character, Integer> map = new HashMap<>();
    // for (int r = 0; r < t.length(); r++)
    // map.put(t.charAt(r), map.getOrDefault(t.charAt(r), 0) + 1);
    // int cnt = 0;
    // for (int j = i; j < s.length(); j++) {
    // if (map.getOrDefault(s.charAt(j), 0) >= 1) {
    // map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1);
    // cnt++;
    // }
    // if (cnt == t.length()) {
    // System.out.println(sIndex + " " + minLen);
    // if (minLen > (j - i + 1)) {
    // sIndex = i;
    // minLen = j - i + 1;
    // }
    // break;
    // }
    // }
    // }
    // return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    // }
}
