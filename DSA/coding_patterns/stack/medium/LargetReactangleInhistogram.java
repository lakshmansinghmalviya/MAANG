// https://leetcode.com/problems/largest-rectangle-in-histogram/

package coding_patterns.stack.medium;

import java.util.Stack;
import java.util.Arrays;

public class LargetReactangleInhistogram {

    // optimal approach we can do calculation while removing or coming back

    int largetReactangleInhistogram(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i] && arr[stack.peek()] != arr[i]) {
                int right = i;
                int elementIndex = stack.pop();
                int element = arr[elementIndex];
                int left = stack.isEmpty()?-1:stack.peek();
                int mulWith = right - left - 1;
                max = Math.max(max, mulWith * element);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int right = arr.length;
            int elementIndex = stack.pop();
            int element = arr[elementIndex];
            int left = stack.isEmpty() ? -1 : stack.peek();
            int mulWith = right - left - 1;
            max = Math.max(max, mulWith * element);
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 1, 2 };
        LargetReactangleInhistogram largetReactangleInhistogram = new LargetReactangleInhistogram();
        // int output[][] =
        // largetReactangleInhistogram.previousSmallerAndNextSmallerElement(arr);
        // System.out.println(Arrays.toString(output[0]));
        // System.out.println(Arrays.toString(output[1]));
        System.out.println(largetReactangleInhistogram.largetReactangleInhistogram(arr));
    }

    int[][] previousSmallerAndNextSmallerElement(int arr[]) {

        Stack<Integer> stackNext = new Stack<>();
        Stack<Integer> stackPrev = new Stack<>();
        int arrNext[] = new int[arr.length];
        int arrPrev[] = new int[arr.length];
        int j = 0;

        for (int i = arr.length - 1; i >= 0; i--, j++) {

            while (!stackNext.isEmpty() && arr[stackNext.peek()] >= arr[i]) {
                stackNext.pop();
            }

            arrNext[i] = stackNext.isEmpty() ? arr.length : stackNext.peek();

            stackNext.push(i);

            while (!stackPrev.isEmpty() && arr[stackPrev.peek()] >= arr[j]) {
                stackPrev.pop();
            }

            arrPrev[j] = stackPrev.isEmpty() ? -1 : stackPrev.peek();

            stackPrev.push(j);
        }
        return new int[][] { arrPrev, arrNext };
    }

    // better approach brutefoce will to run the loops manuanlly from the standed
    // point to left and right find
    // int largetReactangleInhistogram(int arr[]) {
    // int output[][] = previousSmallerAndNextSmallerElement(arr);
    // int arrPrev[] = output[0];
    // int arrNext[] = output[1];
    // int max = 0;

    // for (int i = 0; i < arr.length; i++) {
    // int leftMin = arrPrev[i];
    // int rightMin = arrNext[i];
    // int mulWith = rightMin - leftMin - 1;
    // max = Math.max(max, mulWith * arr[i]);
    // }
    // return max;
    // }

}