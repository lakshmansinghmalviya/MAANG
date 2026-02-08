// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

package coding_patterns.trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import coding_patterns.trees.basic.TreeNode;

public class ZigZagInorderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                // all is inorder except this and flag
                if (flag == 0)
                    list.add(temp.val);
                else
                    list.addFirst(temp.val);

                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            }
            lists.add(list);

            if (flag == 0)
                flag = 1;
            else
                flag = 0;
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}