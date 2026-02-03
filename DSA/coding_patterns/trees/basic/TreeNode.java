package coding_patterns.trees.basic;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode l, TreeNode r) {
        this.val = val;
        left = l;
        right = r;
    }
}
