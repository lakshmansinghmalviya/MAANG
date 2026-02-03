// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class HeightOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {

    }

}
