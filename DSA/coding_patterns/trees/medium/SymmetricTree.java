package coding_patterns.trees.medium;

import java.util.Stack;

import coding_patterns.trees.basic.TreeNode;

public class SymmetricTree {

    public boolean isSymetric(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null)
            return true;

        if ((lRoot != null && rRoot == null) || (lRoot == null && rRoot != null) || (lRoot.val != rRoot.val))
            return false;

        if (isSymetric(lRoot.left, rRoot.right) == false || isSymetric(lRoot.right, rRoot.left) == false)
            return false;

        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        // return isSymetric(root, root);
        return isSymetricUsingStack(root);
    }

        // stack can work here in or linkedlist
    public boolean isSymetricUsingStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null || n1.val != n2.val)
                return false;

            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true; 
    }

    public static void main(String[] args) {

    }
}