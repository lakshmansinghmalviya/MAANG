// https://leetcode.com/problems/binary-tree-level-order-traversal/

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalOrBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists ;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
