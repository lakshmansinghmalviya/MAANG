// https://leetcode.com/problems/merge-k-sorted-lists/

package coding_patterns.heap.hard;

import java.util.PriorityQueue;

class ListNode {
    ListNode next;
    int val;

    ListNode(int v) {
        val = v;
    }
}

class Pair {
    int value;
    ListNode node;

    Pair(int v, ListNode node) {
        this.value = v;
        this.node = node;
    }

    public String toString() {
        return this.value + "";
    }
}

public class MergeKSortedList {
    // optimal approach to use min heap
    // Time: O(N log K)
    // Space: O(K)

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> (a.value - b.value));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(new Pair(lists[i].val, lists[i]));
            }
        }

        while (minHeap.size() > 0) {
            Pair min = minHeap.poll();
            temp.next = min.node;
            temp = temp.next;
            if (min.node.next != null) {
                minHeap.offer(new Pair(min.node.next.val, min.node.next));
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }

    // better approach

    // private ListNode merge(ListNode lHead, ListNode rHead) {
    // ListNode dHead = new ListNode(-1);
    // ListNode temp = dHead;

    // while (lHead != null && rHead != null) {
    // if (lHead.val < rHead.val) {
    // temp.next = lHead;
    // lHead = lHead.next;
    // temp = temp.next;
    // } else {
    // temp.next = rHead;
    // rHead = rHead.next;
    // temp = temp.next;
    // }
    // }
    // if (lHead != null) {
    // temp.next = lHead;
    // }
    // if (rHead != null) {
    // temp.next = rHead;
    // }
    // System.out.println("M-- ");
    // // print(dHead.next);
    // return dHead.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    // ListNode dummy = null;
    // for (int i = 0; i < lists.length; i++) {
    // dummy = merge(dummy, lists[i]);
    // }
    // return dummy;
    // }
}
