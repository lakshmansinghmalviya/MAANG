// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
package coding_patterns.trees.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import coding_patterns.trees.basic.TreeNode;

class Pair {
    TreeNode node;
    int fireNumber;

    Pair(TreeNode n, int f) {
        node = n;
        fireNumber = f;
    }
}

public class AmountToDestroyBinaryTree {
    
    TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parentMapping, int start) {
        parentMapping.put(root, null); // according to the contraints else put negative value
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = null;
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == start) {
                temp = node;
            }

            if (node.left != null) {
                q.offer(node.left);
                parentMapping.put(node.left, node);
            }

            if (node.right != null) {
                q.offer(node.right);
                parentMapping.put(node.right, node);
            }
        }
        return temp;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Map<TreeNode, TreeNode> parentMapping = new HashMap<>();
        TreeNode startNode = markParent(root, parentMapping, start);
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startNode, 0));
        visited.put(startNode, true);
        int maxTime = 0;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            maxTime = Math.max(maxTime, pair.fireNumber);

            if (node.left != null && !visited.containsKey(node.left)) {
                q.offer(new Pair(node.left, pair.fireNumber + 1));
                visited.put(node.left, true);
            }
            if (node.right != null && !visited.containsKey(node.right)) {
                q.offer(new Pair(node.right, pair.fireNumber + 1));
                visited.put(node.right, true);
            }

            if (parentMapping.get(node) != null && !visited.containsKey(parentMapping.get(node))) {
                q.offer(new Pair(parentMapping.get(node), pair.fireNumber + 1));
                visited.put(parentMapping.get(node), true);
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {

    }
}