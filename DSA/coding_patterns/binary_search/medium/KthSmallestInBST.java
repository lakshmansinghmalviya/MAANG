package coding_patterns.binary_search.medium;

import coding_patterns.trees.basic.TreeNode;

public class KthSmallestInBST {
    int min = -1;
    int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 10; // return anything doesn't matter as we are not calculating by this
        kthSmallest(root.left, k);
        cnt++;
        if (cnt == k) {
            min = root.val;
        }
        kthSmallest(root.right, k);
        return min;
    }

    public static void main(String[] args) {
        // 
    }
}
