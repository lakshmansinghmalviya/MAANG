// https://leetcode.com/problems/sliding-window-maximum/description/

package coding_patterns.stack.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {

        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // if window is going outside
            if (!stack.isEmpty() && stack.getFirst() <= i - k) {
                stack.removeFirst();
            }

            // remove if we get the smaller smaller element before and we are in window
            // already
            while (!stack.isEmpty() && arr[stack.getLast()] <= arr[i]) {
                stack.removeLast();
            }

            stack.addLast(i);
            if (i >= k - 1)
                list.add(arr[stack.getFirst()]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] minlidingWindow(int[] arr, int k) {

        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // if window is going outside
            if (!stack.isEmpty() && stack.getFirst() <= i - k) {
                stack.removeFirst();
            }

            // remove if we get the smaller smaller element before and we are in window
            // already
            while (!stack.isEmpty() && arr[stack.getLast()] >= arr[i]) {
                stack.removeLast();
            }

            stack.addLast(i);
            if (i >= k - 1)
                list.add(arr[stack.getFirst()]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // LinkedList<Integer> queue = new LinkedList<>();
        // queue.addLast(1);
        // queue.addLast(2);
        // queue.addLast(3);
        // queue.addLast(1);
        // System.out.println(queue);
        // queue.removeFirst();
        // System.out.println(queue);
        // queue.removeLast();
        // queue.getFirst();
        // queue.getLast();
        // System.out.println(queue);

        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(arr, k)));
        System.out.println(Arrays.toString(slidingWindowMaximum.minlidingWindow(arr, k)));
    }
}