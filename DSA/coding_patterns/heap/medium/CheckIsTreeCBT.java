// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

package coding_patterns.heap.medium;

class TreeNode {
    TreeNode left;
    TreeNode right;
}

public class CheckIsTreeCBT {
    int totalNode(TreeNode root) {
        if (root == null)
            return 0;
        int left = totalNode(root.left);
        int right = totalNode(root.right);
        return 1 + left + right;
    }

    public boolean isCompleteTree(TreeNode root, int n, int i) {
        if (root == null)
            return true;
        if (i > n)
            return false;
        boolean left = isCompleteTree(root.left, n, i * 2);
        boolean right = isCompleteTree(root.right, n, i * 2 + 1);
        return left & right;
    }

    public boolean isCompleteTree(TreeNode root) {
        int n = totalNode(root);
        int i = 1;
        return isCompleteTree(root, n, 1);
    }

    public static void main(String[] args) {

    }
    // Another problem can be solved using this that is is binary tree Heap 
    //  check  if CBT && maxOrderHeap (node's child value should have lesser)
}