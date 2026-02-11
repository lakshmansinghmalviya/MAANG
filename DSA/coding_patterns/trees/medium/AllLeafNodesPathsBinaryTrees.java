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

    }
}
