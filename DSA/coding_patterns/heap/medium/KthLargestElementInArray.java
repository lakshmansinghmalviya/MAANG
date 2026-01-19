// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

package coding_patterns.heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        // using sorting it will take o(n log n) -T
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(Arrays.stream(nums).boxed().toList());

        while (k-- > 1)
            pq.poll();

        return pq.peek();
    }

    public int findKthLargestOptimized(int[] nums, int k) {
        // using sorting it will take o(n log n) -T
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public int findKthSmallestOptimized(int[] nums, int k) {
        // using sorting it will take o(n log n) -T
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        // by default it works for the min heap

        int arr[] = { 1, 2, 4, 55, 4, 3 };
        int k = 6;
        System.out.println(new KthLargestElementInArray().findKthSmallestOptimized(arr, k)); // max heap
        System.out.println(new KthLargestElementInArray().findKthLargestOptimized(arr, k)); // min heap default impl of
                                                                                            // the PQ
    }
}