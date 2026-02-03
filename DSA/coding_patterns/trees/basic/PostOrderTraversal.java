// https://leetcode.com/problems/binary-tree-postorder-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> postorderTraversalUsingTwoStack(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root == null)
            return list;

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            TreeNode taken = stack2.peek();
            list.addFirst(taken.val);
            if (taken.left != null) {
                stack1.push(taken.left);
            }
            if (taken.right != null) {
                stack1.push(taken.right);
            }
        }
        return list;
    }
}