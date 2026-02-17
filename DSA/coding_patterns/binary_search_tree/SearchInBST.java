// https://leetcode.com/problems/search-in-a-binary-search-tree/
package coding_patterns.binary_search_tree;

import coding_patterns.trees.basic.TreeNode;

public class SearchInBST {

    TreeNode searchInBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (root.val > val)
            return searchInBST(root.left, val);

        return searchInBST(root.right, val);
    }
}
