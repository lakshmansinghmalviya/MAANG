// https://leetcode.com/problems/delete-node-in-a-bst/

package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class DeleteNodeInBST {

    TreeNode findLastLeftNodeOfRightSubtree(TreeNode root) {
        if (root != null && root.left == null)
            return root;
        return findLastLeftNodeOfRightSubtree(root.left);
    }

    TreeNode findNodeParentAndSubTree(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        TreeNode lastNodeOfRightSubTree = findLastLeftNodeOfRightSubtree(root.right);
        lastNodeOfRightSubTree.left = leftChild;
        return rightChild;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        TreeNode dummy = root;
        if (root.val == key)
            return findNodeParentAndSubTree(root);

        while (root != null) {
            if (root.left != null && root.left.val == key) {
                root.left = findNodeParentAndSubTree(root.left);
                return dummy;
            }
            if (root.right != null && root.right.val == key) {
                root.right = findNodeParentAndSubTree(root.right);
                return dummy;
            } else if (root.val > key) {
                root = root.left;
                continue;
            } else
                root = root.right;
        }
        return dummy;
    }

    public static void main(String[] args) {
        //
    }
}
