// https://leetcode.com/problems/hand-of-straights/description/

package coding_patterns.heap.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < hand.length; i++)
            pq.offer(hand[i]);

        // 1,2,3
        // n = 1

        while (!pq.isEmpty()) {
            List<Integer> equals = new ArrayList<>();
            int prevElement = pq.poll();

            List<Integer> collect = new ArrayList<>();
            collect.add(prevElement);

            while (!pq.isEmpty() && collect.size() < groupSize) {

                int element = pq.poll();
                if (element - prevElement == 1) {
                    prevElement = element;
                    collect.add(element);
                } else if (element == prevElement)
                    equals.add(element);
                if (collect.size() >= groupSize)
                    break;
            }

            for (int i = 0; i < equals.size(); i++)
                pq.add(equals.get(i));

            if (collect.size() != groupSize) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //
    }
}
