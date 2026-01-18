// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
package medium;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        if (head.next == null)
            return null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (prev != null) {
            prev.next = prev.next.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}