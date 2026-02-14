// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

package coding_patterns.trees.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import coding_patterns.trees.basic.TreeNode;

class Pair {
    TreeNode node;
    int distance;

    Pair(TreeNode n, int d) {
        node = n;
        distance = d;
    }
}

public class FindNodeAtDistanceK {
    void markParent(TreeNode root, Map<TreeNode, TreeNode> parentMapping) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        parentMapping.put(root, null);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
                parentMapping.put(node.left, node);
            }
            if (node.right != null) {
                q.offer(node.right);
                parentMapping.put(node.right, node);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMapping = new HashMap<>();
        markParent(root, parentMapping);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        q.offer(new Pair(target, 0));
        visited.put(target, true);

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.distance == k)
                list.add(pair.node.val);

            if (pair.distance > k)
                continue;

            if (pair.node.left != null && !visited.containsKey(pair.node.left)) {
                q.offer(new Pair(pair.node.left, pair.distance + 1));
                visited.put(pair.node.left, true);
            }
            if (pair.node.right != null && !visited.containsKey(pair.node.right)) {
                q.offer(new Pair(pair.node.right, pair.distance + 1));
                visited.put(pair.node.right, true);
            }
            if (parentMapping.get(pair.node) != null && !visited.containsKey(parentMapping.get(pair.node))) {
                q.offer(new Pair(parentMapping.get(pair.node), pair.distance + 1));
                visited.put(parentMapping.get(pair.node), true);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
