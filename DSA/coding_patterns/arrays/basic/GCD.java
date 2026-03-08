// https://leetcode.com/problems/find-greatest-common-divisor-of-array/

// revision with timer

package coding_patterns.arrays.basic;

import java.util.Arrays;

public class GCD {

    int findGCDBrute(int a, int b) {
        for (int i = (int) Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 0;
    }

    int findGCDEQlgo(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        if (a == 0)
            return b;
        return a;
    }

    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(min + " " + max);
        return findGCDEQlgo(min, max);
    }

    public static void main(String[] args) {

    }
}