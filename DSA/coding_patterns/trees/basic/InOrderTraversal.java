// https://leetcode.com/problems/binary-tree-inorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
        void inOrderList(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inOrderList(list, root.left);
        list.add(root.val);
        inOrderList(list, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderList(list, root);
        return list;
    }
}
