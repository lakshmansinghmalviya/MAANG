package coding_patterns.sliding_window_2_pointer;

public class MinimumWindowSubSequence {

    String minimumWindowSubSequence(String s, String t) {

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            // first char matched
            if (s.charAt(i) == t.charAt(0)) {
                int p1 = i;
                int p2 = 0;

                // check all the chars matched or not in the t
                while (p1 < s.length() && p2 < t.length()) {
                    if (s.charAt(p1) == t.charAt(p2))
                        p2++;
                    p1++;
                }

                // if alll chars matched
                if (p2 == t.length()) {
                    int end = p1 - 1;
                    p2 = p2 - 1;
                    while (end >= i) {
                        if (s.charAt(end) == t.charAt(p2))
                            p2--;
                            if (p2<0)break;
                        end--;
                    }

                    int start = end;
                    int len = p1 - start;
                    if (minLen > len) {
                        minLen = len;
                        ans = s.substring(start, start + len);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       String s = "abcdebde";
       String t = "bde";
       System.out.println(new MinimumWindowSubSequence().minimumWindowSubSequence(s, t));
    }
}