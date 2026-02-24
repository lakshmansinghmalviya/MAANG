package coding_patterns.binary_search_tree.medium;

import coding_patterns.trees.basic.TreeNode;

public class ConstructBSTUsingPreorder {

    public TreeNode insertNodeInBST(TreeNode root, int key) {
        if (root == null)
            return new TreeNode(key);
        if (root.val > key)
            root.left = insertNodeInBST(root.left, key);
        else
            root.right = insertNodeInBST(root.right, key);
        return root;
    }

    public TreeNode bstFromPreorder(int arr[], int upperBound, int index[]) {
        if (index[0] == arr.length || arr[index[0]] > upperBound)
            return null;
        TreeNode root = new TreeNode(arr[index[0]]);
        index[0]++;
        root.left = bstFromPreorder(arr, root.val, index);
        root.right = bstFromPreorder(arr, upperBound, index);
        return root;
    }

    // This is the brute force method works in O (N*N)
    public TreeNode bstFromPreorder(int[] preorder) {
        // TreeNode root = new TreeNode(preorder[0]);
        // for (int i = 1; i < preorder.length; i++)
        // root = insertNodeInBST(root, preorder[i]);
        // return root;

        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }
}
