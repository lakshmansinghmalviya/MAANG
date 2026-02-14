package coding_patterns.trees.hard;

import java.util.LinkedList;
import java.util.Queue;

import coding_patterns.trees.basic.TreeNode;

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode n, int i) {
        node = n;
        index = i;
    }
}

public class MaxWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int max = 0;
        while (!q.isEmpty()) {
            Pair pair = q.peek();
            int size = q.size();
            int startIndex = pair.index;

            for (int i = 0; i < size; i++) {
                pair = q.poll();
                TreeNode node = pair.node;
                int currentIndex = pair.index;
                max = Math.max(max, currentIndex - startIndex + 1);

                if (node.left != null)
                    q.offer(new Pair(node.left, 2 * currentIndex + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, 2 * currentIndex + 2));
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
