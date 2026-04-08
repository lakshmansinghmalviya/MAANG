// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

package coding_patterns.binary_search_tree.medium;

import java.util.List;
import java.util.Stack;

import coding_patterns.trees.basic.TreeNode;

class BSTIterator {
    Stack<TreeNode> stack;
    boolean isForNext = false;

    BSTIterator(TreeNode root, boolean isForNext) {
        stack = new Stack<>();
        this.isForNext = isForNext;
        pushAll(root);
    }

    public void pushAll(TreeNode temp) {
        TreeNode root = temp;
        while (root != null) {
            stack.push(root);
            if (isForNext == false) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public TreeNode next() {
        if (stack.isEmpty())
            return null;

        TreeNode next = stack.pop();
        if (isForNext == false) {
            pushAll(next.right);
        } else
            pushAll(next.left);

        return next;
    }
}

public class TwoSumBST {
    void inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // do it using the the BST iterator so we will have O(H) space complexity now we
    // have O(N)

    // public boolean findTarget(TreeNode root, int k) {
    // List<Integer> list = new ArrayList<>();
    // inOrder(root, list);
    // int j = list.size() - 1;
    // int i = 0;

    // while (i < j) {
    // int sum = list.get(i) + list.get(j);
    // if (sum == k)
    // return true;
    // if (sum < k)
    // i++;
    // else
    // j--;
    // }
    // return false;
    // }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator nextElements = new BSTIterator(root, false);
        BSTIterator beforeElements = new BSTIterator(root, true);
        TreeNode i = nextElements.next(), j = beforeElements.next();

        // if both reach at the same point it means not possible
        while (i != null && j != null && i.val < j.val) {
            int sum = i.val + j.val;
            if (sum == k)
                return true;
            if (sum < k)
                i = nextElements.next();
            else
                j = beforeElements.next();
        }
        return false;
    }
}
