package coding_patterns.dynamic_programming.basic;

import java.util.Arrays;

public class FabonacciSeries {

    public static int fab(int n) {
        if (n <= 1)
            return n;
        return fab(n - 1) + fab(n - 2);
    }

    // IF we are solving this prob using recursion then there will be overrlapping
    // subproblems to remove those repetitive
    // we use DP

    public static int fabDp(int n, int arr[]) {
        if (n <= 1)
            return n;

        if (arr[n] != -1)
            return arr[n];
        // or get here store then return if getting confusion
        return arr[n] = fabDp(n - 1, arr) + fabDp(n - 2, arr);
    }

    public static void main(String[] args) {
        int n = 40;
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);

        long start = System.nanoTime();
        System.out.println("Normal CALL");
        System.out.println(fab(n));
        long end = System.nanoTime();
        System.out.println("Normal Time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        System.out.println("DP CALL");
        System.out.println(fabDp(n, arr));
        end = System.nanoTime();
        System.out.println("DP Time: " + (end - start) / 1_000_000 + " ms");
    }
}