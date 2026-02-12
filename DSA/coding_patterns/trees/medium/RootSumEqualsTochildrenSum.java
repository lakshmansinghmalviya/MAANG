// https://leetcode.com/problems/root-equals-sum-of-children/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class RootSumEqualsTochildrenSum {
    // public boolean checkTree(TreeNode root) {
    // if (root == null)
    // return true;

    // if (root.left != null && root.right != null && root.val == (root.left.val +
    // root.right.val))
    // return true;

    // return false;
    // }

    // If asked that the root/parent should have its left tree sum + right tree sum
    // equivalent then ?
    public boolean checkTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;
        if (root.val != sum)
            return false;
        // if all the left + right subtree sum==parent/root then replace the root val
        // with the sum of left + right subtree
        // like root.val= left.val+right.val; to go up with the sum

        if (checkTree(root.left) == false || checkTree(root.right) == false) {
            return false;
        }
        return true;
    }
}
