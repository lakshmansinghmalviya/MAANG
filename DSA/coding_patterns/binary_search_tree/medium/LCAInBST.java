package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class LCAInBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (!(root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val))
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {

    }
}