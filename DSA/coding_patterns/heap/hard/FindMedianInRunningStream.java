// https://leetcode.com/problems/find-median-from-data-stream

package coding_patterns.heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> maxHeap; // left bucket
    PriorityQueue<Integer> minHeap; // right bucket

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (maxHeap.size() == 0)
            maxHeap.offer(num);
        else if (maxHeap.size() <= minHeap.size()) {
            if (maxHeap.peek() < num && minHeap.peek() < num) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else
                maxHeap.offer(num);
        } else if (maxHeap.size() > minHeap.size()) {
            if (maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else
                minHeap.offer(num);
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek() * 1.0) / 2;
        return maxHeap.peek();
    }
}

public class FindMedianInRunningStream {

    // use min and max heap logic here

    public static void main(String[] args) {
        // pass array here
    }
}