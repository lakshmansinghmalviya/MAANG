// https://www.naukri.com/code360/problems/minimum-element-in-bst_8160462

package coding_patterns.binary_search_tree;

import coding_patterns.trees.basic.TreeNode;

public class FindMinMaxInBST {

    public TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root;
        return findMin(root.left);
    }

    public TreeNode findMax(TreeNode root) {
        if (root == null)
            return null;
        if (root.right == null)
            return root;
        return findMax(root.right);
    }

    public static void main(String[] args) {

    }
}
