// https://leetcode.com/problems/count-complete-tree-nodes/

package coding_patterns.trees.basic;

public class CountNumberOfNodesInBinaryTree {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    int left = countNodes(root.left);
    int right = countNodes(root.right);
    return 1 + left + right;
  }
}