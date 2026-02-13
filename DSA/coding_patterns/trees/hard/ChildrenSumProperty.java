// https://takeuforward.org/plus/dsa/problems/children-sum-property-in-binary-tree

package coding_patterns.trees.hard;

import coding_patterns.trees.basic.TreeNode;

public class ChildrenSumProperty {

    void changeTree(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            root.left.val = root.val;
        if (root.right != null)
            root.right.val = root.val;

        changeTree(root.left);
        changeTree(root.right);
        int sum = 0;
        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;
        root.val = sum;
    }

    public static void main(String[] args) {

    }
}