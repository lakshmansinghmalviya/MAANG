package coding_patterns.trees.medium;

import coding_patterns.trees.basic.TreeNode;

public class LCAOfTwoNodeInBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;

        // if the other guy is null then return the other one may be val or null if both
        // are not null we got our matched val/node keep forwarding that until the
        // function ends
    }

    public static void main(String[] args) {

    }

    // brute force (submission is fine)
    // boolean findPathToNode(TreeNode root, TreeNode val, List<TreeNode> list) {
    // if (root == null)
    // return false;

    // list.add(root);

    // if (root == val) {
    // return true;
    // }
    // if (findPathToNode(root.left, val, list) || findPathToNode(root.right, val,
    // list))
    // return true;
    // list.removeLast();
    // return false;
    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // List<TreeNode> list1 = new ArrayList<>();
    // List<TreeNode> list2 = new ArrayList<>();
    // findPathToNode(root, p, list1);
    // findPathToNode(root, q, list2);
    // TreeNode node = null;

    // for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
    // if (list1.get(i) == list2.get(i))
    // node = list1.get(i);
    // else
    // break;
    // }
    // // System.out.println(list1 + " " + list2);

    // return node;
    // }
}
