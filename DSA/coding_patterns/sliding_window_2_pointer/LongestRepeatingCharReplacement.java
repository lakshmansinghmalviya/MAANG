// https://leetcode.com/problems/longest-repeating-character-replacement/

package coding_patterns.sliding_window_2_pointer;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    // better solution
    public int characterReplacementBetter(String s, int k) {
        int maxLen = 0, l = 0, r = 0, maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char ch[] = s.toCharArray();

        while (r < ch.length) {
            map.put(ch[r], map.getOrDefault(ch[r], 0) + 1);
            maxF = Math.max(maxF, map.get(ch[r]));
            int changesRequired = (r - l + 1) - maxF;

            while (changesRequired > k) {
                maxF = 0;
                map.put(ch[l], map.getOrDefault(ch[l], 0) - 1);
                // we can remove the re scanning for the max because if my prev maxF was 3  and i will get lesser then it wont make my sol len bigger 
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    maxF = Math.max(maxF, entry.getValue());
                }
                l++;
                changesRequired = (r - l + 1) - maxF;
            }

            if (changesRequired <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    // optimal solution

    public int characterReplacementOtpimal(String s, int k) {
        int maxLen = 0, l = 0, r = 0, maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char ch[] = s.toCharArray();

        while (r < ch.length) {
            map.put(ch[r], map.getOrDefault(ch[r], 0) + 1);
            maxF = Math.max(maxF, map.get(ch[r]));
            int changesRequired = (r - l + 1) - maxF;

            if(changesRequired > k) {
                maxF = 0;
                map.put(ch[l], map.getOrDefault(ch[l], 0) - 1);
                // we can remove the re scanning for the max because if my prev maxF was 3  and i will get lesser then it wont make my sol len bigger 
                l++;
                changesRequired = (r - l + 1) - maxF;
            }

            if (changesRequired <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // First Dry run for the len(j-i+1)-maxFrequency changes need to be made

    }

    // brute force
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int maxF = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxF = Math.max(maxF, map.get(c));
                int changesRequired = (j - i + 1) - maxF;
                if (changesRequired <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }
}
