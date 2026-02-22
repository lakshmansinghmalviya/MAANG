package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class ValidateBST {

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (!(root.val > min && root.val < max))
            return false;
        boolean leftEverFalse = isValidBST(root.left, min, root.val);
        boolean rightEverFalse = isValidBST(root.right, root.val, max);

        return leftEverFalse && rightEverFalse;
    }

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
    }

}
