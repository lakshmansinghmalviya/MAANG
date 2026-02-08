package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class SymmetricTree {

    public boolean isSymetric(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null)
            return true;
        if ((lRoot != null && rRoot == null) || (lRoot == null && rRoot != null) || (lRoot.val != rRoot.val))
            return false;

        if (isSymetric(lRoot.left, rRoot.right) == false || isSymetric(lRoot.right, rRoot.left) == false)
            return false;

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymetric(root, root);
    }

    public static void main(String[] args) {

    }
}
