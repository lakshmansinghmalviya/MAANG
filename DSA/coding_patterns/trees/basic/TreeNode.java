package coding_patterns.trees.basic;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val, TreeNode l, TreeNode r) {
        this.val = val;
        left = l;
        right = r;
    }
}
