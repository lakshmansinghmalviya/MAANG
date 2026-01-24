// https://leetcode.com/problems/task-scheduler/description/.

package coding_patterns.heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());
        int size = 0;

        // ["A","C","A","B","D","B"] n=1
        // A-2
        // b-2
        // c-1
        // d-1

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cnt = 0;
            for (int i = 1; i <= n + 1; i++) {
                if (!pq.isEmpty()) {
                    cnt++;
                    int freq = pq.poll();
                    freq--;
                    if (freq > 0)
                        list.add(freq);
                }
            }

            if (list.size() == 0) {
                size += cnt;
            } else {
                size += (n + 1);
            }

            for (int i = 0; i < list.size(); i++) {
                pq.offer(list.get(i));
            }
        }
        return size;
    }

    public static void main(String[] args) {
        //
    }
}
