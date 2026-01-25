package medium;

import java.util.Arrays;

public class MinimumCoinsGreedy {

    public int findMinCoins(int arr[], int target) {
        Arrays.sort(arr);
        int cnt = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            while (target >= arr[i]) {
                target -= arr[i];
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 1, 4, 5, 3 };
        System.out.println(new MinimumCoinsGreedy().findMinCoins(arr, 15));
    }
}