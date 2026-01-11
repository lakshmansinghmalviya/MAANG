// https://leetcode.com/problems/maximal-rectangle/

package coding_patterns.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class MaximumReactangle {

    int largetReactangleInhistogram(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i] && arr[stack.peek()] != arr[i]) {
                int right = i;
                int elementIndex = stack.pop();
                int element = arr[elementIndex];
                int left = stack.isEmpty() ? -1 : stack.peek();
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

    public int maximalRectangle(char[][] arr) {

        int m = arr.length;
        int n = arr[0].length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int currentElement = arr[i][j] - '0';

                if (i <= 0) {
                    matrix[i][j] = currentElement;
                } else if (currentElement != 0)
                    matrix[i][j] = 1 + matrix[i - 1][j];
                else
                    matrix[i][j] = 0;
            }
        }

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
            max = Math.max(max, largetReactangleInhistogram(matrix[i]));
        }

        return max;
    }

    public static void main(String[] args) {

    }
}