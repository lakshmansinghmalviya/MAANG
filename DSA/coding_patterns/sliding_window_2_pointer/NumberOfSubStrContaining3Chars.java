// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
package coding_patterns.sliding_window_2_pointer;

import java.util.Arrays;

public class NumberOfSubStrContaining3Chars {

    public int numberOfSubstrings(String s) {
        int r = 0, cnt = 0;

        int arr[] = { -1, -1, -1 };

        while (r < s.length()) {

            arr[s.charAt(r) - 'a'] = r;

            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                int min = Arrays.stream(arr).min().getAsInt();
                cnt = cnt + (min + 1);
            }
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
    }
}