// https://takeuforward.org/plus/dsa/problems/top-view-of-bt

package coding_patterns.trees.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import coding_patterns.trees.basic.TreeNode;

public class TopViewOfBinaryTree {

    public List<Integer> retrieveTopViewOfBinaryTree(TreeNode root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            int x = tuple.vertical;
            int y = tuple.level;
            TreeNode node = tuple.node;

            if (!map.containsKey(x)) {
                map.put(x, node.val);
            }

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        list.addAll(map.values());

        System.out.println(map);

        return list;
    }

    public static void main(String[] args) {
        // Input : root = [1, 2, 3, 4, 5, 6, 7]
        // Output : [4, 2, 1, 3, 7]
    }
}