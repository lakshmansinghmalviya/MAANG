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

    public static void main(String[] args) {

    }
}
