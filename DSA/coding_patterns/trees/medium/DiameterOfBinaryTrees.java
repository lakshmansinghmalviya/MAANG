// https://leetcode.com/problems/diameter-of-binary-tree/
package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class DiameterOfBinaryTrees {

    int max = 0;

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = findHeight(root.left);
        int leftR = findHeight(root.right);
        return 1 + Math.max(leftH, leftR);
    }

    public int diameterOfBinaryTreeFind(TreeNode root) {
        if (root == null)
            return 0;
        int l = findHeight(root.left);
        int r = findHeight(root.right);
        max = Math.max(max, l + r);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // avoid global then use this this and store at index 0
        // int arr[] = new int[1]; // to store the max
        return diameterOfBinaryTreeFind(root);
    }

    public int diameterOfBinaryTreeOptimal(TreeNode root) {
        // avoid global then use this this and store at index 0
        // int arr[] = new int[1]; // to store the max
        return diameterOfBinaryTreeFind(root);
    }
    

    // Optimal from N^2 to N

    public int findHeight(TreeNode root, int[] arr) {
        if (root == null)
            return 0;
        int leftH = findHeight(root.left, arr);
        int rightH = findHeight(root.right, arr);
        arr[0] = Math.max(arr[0], leftH + rightH);
        System.out.println("Max " + arr[0] + "  lef rig " + leftH + " " + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
