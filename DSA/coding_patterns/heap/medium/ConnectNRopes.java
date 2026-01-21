// https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

package coding_patterns.heap.medium;

import java.util.PriorityQueue;

public class ConnectNRopes {

    // S-o(n)
    //T- n log n
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : arr)
            pq.offer(n);
        int sum = 0;

        if (pq.size() == 1)
            return 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            sum = sum + first + second;
            // System.out.print(sum+" ");
            // System.out.print(sum+" ");
            pq.offer(first + second);
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
