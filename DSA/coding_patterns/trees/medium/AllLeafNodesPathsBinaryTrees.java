// https://leetcode.com/problems/binary-tree-paths/

package coding_patterns.trees.medium;

import java.util.ArrayList;
import java.util.List;

import coding_patterns.trees.basic.TreeNode;

public class AllLeafNodesPathsBinaryTrees {
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, String str) {
        if (root == null)
            return;

        str = str + root.val + "->";
        if (isLeaf(root)) {
            list.add(str.substring(0, str.length() - 2));
            // we remove this o(n) to retrieve the string put a condition above like below
            // commented code
            return;
        }

        if (root.left != null) {
            binaryTreePaths(root.left, list, str);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, list, str);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        binaryTreePaths(root, list, "");
        return list;
    }

    public static void main(String[] args) {
        // Another question we can solve that is find the path till a give node/val so
        // go left left... and then right once met put in the if condition so store once
        // true and return from there only
    }

}

// str = str + root.val;
// if (!isLeaf(root))
// str = str + "->";

// if (isLeaf(root)) {
// list.add(str);
// return;
// }