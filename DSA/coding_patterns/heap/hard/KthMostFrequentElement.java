// https://leetcode.com/problems/top-k-frequent-elements/

package coding_patterns.heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KthMostFrequentElement {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        List<Integer> list = new ArrayList<>();

        while (k-- > 0)
            list.add(pq.poll().getKey());

        // because it doent sort while inserting so the below line wont work in some
        // cases
        // return pq.stream().limit(k).mapToInt(entry->entry.getKey()).toArray();

        return list.stream().mapToInt(i -> i).toArray();
    }
}
