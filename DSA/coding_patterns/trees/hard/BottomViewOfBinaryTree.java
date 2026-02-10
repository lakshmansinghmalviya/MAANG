// https://www.naukri.com/code360/problems/bottom-view-of-binary-tree_893110

package coding_patterns.trees.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import coding_patterns.trees.basic.TreeNode;

public class BottomViewOfBinaryTree {
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
           
            // the bigger level comes later as we are doing level order so that will replace the previous one ,
            //  then we will have the last level nodes

            // if (!map.containsKey(x)) {
                map.put(x, node.val);
            // }

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

    }
}
