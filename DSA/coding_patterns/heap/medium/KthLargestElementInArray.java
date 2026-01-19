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
    public static void main(String[] args) {
        // by default it works for the min heap
    }
}
