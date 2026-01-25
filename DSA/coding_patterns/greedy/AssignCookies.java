// https://leetcode.com/problems/assign-cookies/description/

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int cnt = 0;

        for (int i = 0; i < g.length; i++) {

            for (int k = j; k < s.length; k++) {
                if (s[k] >= g[i]) {
                    j = k + 1;
                    cnt++;
                    break;
                }
            }
        }

        // Arrays may not be sorted so this wont work
        // for (int i = g.length-1; i >=0; i--) {
        // for (int k = j; k >=0; k--) {
        // if (s[k] >= g[i]) {
        // j = k-1;
        // cnt++;
        // break;
        // }
        // }
        // }

        return cnt;
    }

    public static void main(String[] args) {
        int g[] = { 1, 2, 3, 4 };
        int s[] = { 1, 2, 3 };
        System.out.println(findContentChildren(g, s));
    }
}