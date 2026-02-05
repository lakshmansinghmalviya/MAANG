// https://leetcode.com/problems/diameter-of-binary-tree/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class DiameterOfBinaryTrees {
    
    int max = 0;

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = findHeight(root.left);
        int leftR = findHeight(root.right);
        return 1 + Math.max(leftH, leftR);
    }

    public int diameterOfBinaryTreeFind(TreeNode root) {
        if (root == null)
            return 0;
        int l = findHeight(root.left);
        int r = findHeight(root.right);
        max = Math.max(max, l + r);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeFind(root);
    }
}
