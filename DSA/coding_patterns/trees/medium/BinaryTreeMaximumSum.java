// https://leetcode.com/problems/binary-tree-maximum-path-sum/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class BinaryTreeMaximumSum {
    public int findHeight(TreeNode root, int arr[]) {
        if (root == null) {
            return 0;
        }

        int leftSum = findHeight(root.left, arr);
        int rightSum = findHeight(root.right, arr);
        arr[0] = Math.max(arr[0], root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        findHeight(root, arr);
        return arr[0];
    }

    public static void main(String[] args) {

    }
}
