// https://leetcode.com/problems/binary-tree-inorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    void inOrderList(List<Integer> list, TreeNode root) {
        if (root == null)
            return;
        inOrderList(list, root.left);
        list.add(root.val);
        inOrderList(list, root.right);
    }

    // Using recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    break;
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderList(list, root);
        return list;
    }
}
