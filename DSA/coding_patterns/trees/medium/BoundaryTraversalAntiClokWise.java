// https://takeuforward.org/plus/dsa/problems/boundary-traversal

package coding_patterns.trees.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coding_patterns.trees.basic.TreeNode;

public class BoundaryTraversalAntiClokWise {

    public boolean isLeafNode(TreeNode rNode) {
        return (rNode.left == null && rNode.right == null);
    }

    void findLeftTree(TreeNode root, List<Integer> list) {
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeafNode(cur)) {
                list.add(cur.data);
            }
            if (cur.left != null) {
                cur = cur.left;
            } else
                cur = cur.right;
        }
    }

    void findRightTree(TreeNode root, List<Integer> list) {

        TreeNode cur = root.right;
        List<Integer> temp = new ArrayList<>();

        while (cur != null) {
            if (!isLeafNode(cur)) {
                temp.add(cur.data);
            }
            if (cur.right != null) {
                cur = cur.right;
            } else
                cur = cur.left;
        }
        Collections.reverse(temp);
        list.addAll(temp);
    }

    void findLeafNodetTree(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        if (isLeafNode(root)) {
            list.add(root.data);
            return;
        }

        findLeafNodetTree(root.left, list);
        findLeafNodetTree(root.right, list);
    }

    public List<Integer> boundary(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null)
            list.add(root.data);

        findLeftTree(root, list);
        findLeafNodetTree(root, list);
        findRightTree(root, list);
        return list;
    }

    public static void main(String[] args) {

        TreeNode two = new TreeNode(2, null, null);
        TreeNode thTreeNode = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, null, null);
        one.left = two;
        one.right = thTreeNode;

        BoundaryTraversalAntiClokWise bWise = new BoundaryTraversalAntiClokWise();
        System.out.println(bWise.boundary(one)); // .data need to replace with the .val else check on the given link
                                                 // above paste there and test working fine
    }
}