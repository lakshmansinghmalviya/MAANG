// https://takeuforward.org/plus/dsa/problems/kth-largest-element-in-a-stream-of-running-integers?tab=editorial

package coding_patterns.heap.hard;

import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int kth, int[] nums) {
        int k = kth;
        for (int i = 0; i < k; i++)
            minHeap.offer(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

public class KthLargestInARunningStream {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 3;
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(6));
    }
}
