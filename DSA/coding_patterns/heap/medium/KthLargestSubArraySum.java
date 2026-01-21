// https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1

package coding_patterns.heap.medium;

import java.util.PriorityQueue;

public class KthLargestSubArraySum {

    // brute for is to find all the sub array sums
    // then store and sort then and get n-k

    // optimal is to use the min heap for the max ones
    public int findKthLargestSubarraySum(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (minHeap.size() >= k) {
                    if (minHeap.peek() < sum) {
                        minHeap.poll();
                        minHeap.offer(sum);
                    }
                } else
                    minHeap.offer(sum);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5 };
        System.out.println(new KthLargestSubArraySum().findKthLargestSubarraySum(arr, 2));
    }
}