// https://leetcode.com/problems/binary-tree-right-side-view/

package coding_patterns.trees.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import coding_patterns.trees.basic.TreeNode;

public class RightSideViewOfTheBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return list;
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            int x = tuple.vertical;
            int y = tuple.level;
            TreeNode node = tuple.node;

            if (!map.containsKey(y)) {
                map.put(y, node.val);
            }

            // make the right on top as we are looking from the right so first take the
            // right node val
            if (node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));

            // for the left side view of the binary tree , insert the left first then right
            // that's it
            if (node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));
        }
        list.addAll(map.values());
        return list;
    }

    public static void main(String[] args) {
        // To skip/remove the q size we can travers recursively in order/post order
    }
}