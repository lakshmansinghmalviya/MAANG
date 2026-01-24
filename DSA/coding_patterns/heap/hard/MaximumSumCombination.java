// https://takeuforward.org/plus/dsa/problems/maximum-sum-combination

package coding_patterns.heap.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximumSumCombination {

    // Better approach to solve this problem but not optimal
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];

                if (pq.size() < k) {
                    pq.offer(sum);
                }

                else if (pq.peek() < sum) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (k-- > 0) {
            list.add(pq.poll());
        }

        Collections.reverse(list);

        return list;
    }

    // sort array using merge sort() in desceding order if primitive array
    void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // optimal approach
    public ArrayList<Integer> topKSumPairsOptimal(int[] a, int[] b, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashSet<String> vis = new HashSet<>();
        sort(a);
        sort(b);

        pq.add(new int[] { a[0] + b[0], 0, 0 });
        vis.add("0#0");

        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < k && !pq.isEmpty()) {

            int[] arr = pq.poll();
            int sum = arr[0], i = arr[1], j = arr[2];

            list.add(sum);

            // check i+1 with the j and i+1 should not go out
            if (i + 1 < a.length && !vis.contains(i + 1 + "#" + j)) {
                pq.offer(new int[] { a[i + 1] + b[j], i + 1, j });
                vis.add(i + 1 + "#" + j);
            }

            // check with j+1 same can have with j right

            if (j + 1 < a.length && !vis.contains(i + "#" + (j + 1))) {
                pq.offer(new int[] { a[i] + b[j + 1], i, j + 1 });
                vis.add(i + "#" + (j + 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 3, 4 };
        int arr2[] = { 4, 2, 3, 4 };

        System.out.println(new MaximumSumCombination().topKSumPairsOptimal(arr, arr2, 4));
    }
}