package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class InsertInBST {
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root==null) return new TreeNode(val);f
    //     TreeNode head = root;
    //     while (root != null) {
    //         if (root.val > val) {
    //             if (root.left == null) {
    //                 root.left = new TreeNode(val);
    //                 return head;
    //             }
    //             root = root.left;
    //         } else {
    //             if (root.right == null) {
    //                 root.right = new TreeNode(val);
    //                 return head;
    //             }
    //             root = root.right;
    //         }
    //     }
    //     return head;
    // }
}