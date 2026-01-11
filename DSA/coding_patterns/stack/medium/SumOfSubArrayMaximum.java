package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMaximum {
    int[][] previousAndNextGreaterElement(int nums[]) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int arr[] = Arrays.copyOf(nums, nums.length); // to traverse on
        int arr2[] = Arrays.copyOf(nums, nums.length);
        int j = nums.length - 1;

        for (int i = 0; i < nums.length; i++, j--) {

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            arr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] <= nums[j]) {
                stack2.pop();
            }

            arr2[j] = stack2.isEmpty() ? nums.length : stack2.peek();

            stack2.push(j);

        }
        return new int[][] { arr, arr2 };
    }

    public int sumSubarrayMaximum(int[] arr) {
        long total = 0;
        int output[][] = previousAndNextGreaterElement(arr);
        int prev[] = output[0];
        int next[] = output[1];

        System.out.println("PREV  " + Arrays.toString(prev));
        System.out.println("NEXT  " + Arrays.toString(next));

        long MOD = 1000000007L;

        for (int i = 0; i < arr.length; i++) {
            int left = i - prev[i];
            int right = next[i] - i;

            total = (total + (left * right * 1L * arr[i]) % MOD) % MOD;
        }
        return (int) (total % MOD);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 1, 4, 2, 0, 1 };
        SumOfSubArrayMaximum subArrayMaximum = new SumOfSubArrayMaximum();
        System.out.println(subArrayMaximum.sumSubarrayMaximum(arr));
    }

    // think can we use largest traingle in a histogram optimized solutino here ?
}