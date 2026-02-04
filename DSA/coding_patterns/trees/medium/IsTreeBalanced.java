// https://leetcode.com/problems/balanced-binary-tree/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class IsTreeBalanced {

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }

    public static void main(String[] args) {
        // find that is the tree balaced or not
    }
}