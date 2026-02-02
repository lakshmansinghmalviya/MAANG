// https://leetcode.com/problems/binary-tree-preorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalOrDFS {

    // we can solve it using stack also

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        // usual formula is root, left, right
        // in stack just replace , get the node and then put rigth, left
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right); // first put right and then left
            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }

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