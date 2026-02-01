// https://leetcode.com/problems/binary-tree-preorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversalOrDFS {
        void preOrderList(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        preOrderList(list, root.left);
        preOrderList(list, root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderList(list, root);
        return list;
    }
}
