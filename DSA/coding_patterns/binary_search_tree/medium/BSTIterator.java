package coding_patterns.binary_search_tree.medium;

import java.util.Stack;

import coding_patterns.trees.basic.TreeNode;

public class BSTIterator { 

    //  we could solve this the approach of storing the inorder and then doing the same work 
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            pushAll(root);
        }
    }

    public int next() {
        if (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            pushAll(current.right);
            return current.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
