// https://leetcode.com/problems/rank-transform-of-an-array/

package coding_patterns.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : arr)
            pq.offer(n);

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;

        while (!pq.isEmpty()) {
            int element = pq.poll();
            if (!map.containsKey(element))
                map.put(element, index++);
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = map.get(arr[i]);

        return arr;
    }

    public static void main(String[] args) {
        // pass the array here
    }
}
