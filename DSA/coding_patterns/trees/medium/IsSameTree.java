// https://leetcode.com/problems/same-tree/

package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (q == null && p != null) || q.val != p.val)
            return false;

        if (isSameTree(p.left, q.left) == false || isSameTree(p.right, q.right) == false)
            return false;

        return true;
    }

    public static void main(String[] args) {

    }
}
