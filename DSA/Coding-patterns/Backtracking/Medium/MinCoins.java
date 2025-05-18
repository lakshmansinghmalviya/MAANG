package Medium;

import java.util.*;

public class MinCoins {
    // this is the technique to print the any one solution so return the true when
    // condition satirfyied and return false when cndn not satisfied
    public static boolean findMinCoins(int arr[], int index, int n, int target, int sum, int cnt) {
        if (index >= arr.length) {
            return false;
        }
        if (target == sum) {
            System.out.println("Counts are  : " + cnt);
            return true;
        }
        if (sum > target) {
            return false;
        }
        sum += arr[index];
        cnt++;
        if (findMinCoins(arr, index, n, target, sum, cnt) == true)
            return true;
        sum -= arr[index];
        cnt--;
        if (findMinCoins(arr, index + 1, n, target, sum, cnt) == true)
            return true;

        return false;
    }
//  count total no of the subsequences return 1 when condition satisfied and return 0 when condition not satisfied
    public static int findMinCoinsCount(int arr[], int index, int n, int target, int sum, int cnt) {
        if (index >= arr.length) {
            return 0;
        }
        if (target == sum) {
            System.out.println("Counts are  : " + cnt);
            return 1;
        }
        if (sum > target) {
            return 0;
        }
        sum += arr[index];
        cnt++;
        int leftCnt = findMinCoinsCount(arr, index, n, target, sum, cnt);
        sum -= arr[index];
        cnt--;
        int rightCnt = findMinCoinsCount(arr, index + 1, n, target, sum, cnt);
        return Math.min(leftCnt ,rightCnt);
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 4, 3, 2, 1 };
        // first sort the array in any order for now i will be sorting in DESC order
        // Arrays.sort(arr,(a,b)->b[0]-a[0]);
        System.out.println(findMinCoins(arr, 0, arr.length, 7, 0, 0));
        // System.out.println(findMinCoinsCount(arr, 0, arr.length, 7, 0, 0)); //wrong ans
    }
}