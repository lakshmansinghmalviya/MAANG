// https://leetcode.com/problems/recover-binary-search-tree/description/

package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class RecoverBST {
    TreeNode firstNode = null, lastNode = null, prev;

    void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        // logic

        if (prev != null && prev.val > root.val) {
            if (firstNode == null)
                firstNode = prev;
            lastNode = root;
        }

        prev = root;
        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inOrder(root);
        if (firstNode != null && lastNode != null) {
            int temp = firstNode.val;
            firstNode.val = lastNode.val;
            lastNode.val = temp;
        }
    }
}
