// https://leetcode.com/problems/binary-tree-postorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
       void postOrderList(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        postOrderList(list, root.left);
        postOrderList(list, root.right);
        list.add(root.val);
    }

 
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderList(list, root);
        return list;
    }
}
