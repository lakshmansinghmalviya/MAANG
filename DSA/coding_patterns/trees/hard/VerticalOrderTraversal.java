// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree

package coding_patterns.trees.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import coding_patterns.trees.basic.TreeNode;

class Tuple {
    int vertical;
    int level;
    TreeNode node;

    Tuple() {
    }

    Tuple(TreeNode n, int v, int l) {
        vertical = v;
        level = l;
        node = n;
    }
}

public class VerticalOrderTraversal {

    // we can use any traversal order just do the -1 if goes to left and +1 if right

    // we can use any traversal order just do the -1 if goes to left and +1 if right
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // vertical ind level ind
        // treemap need to maintain from left to right so most neg to pos
        // the inner treemap we need to maintain the top to bottom traversal for the
        // level one
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.vertical;
            int y = tuple.level;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
                // putifabsent we can use
            }

            if (!map.get(x).containsKey(y)) {
                // putifabsent we can use
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> lists = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> tMap : map.values()) {
            lists.add(new ArrayList<>());

            for (PriorityQueue<Integer> nodesPq : tMap.values()) {
                while (!nodesPq.isEmpty()) {
                    System.out.println(nodesPq.peek());
                    lists.get(lists.size() - 1).add(nodesPq.poll());
                }
            }
        }

        return lists;
    }

    // public List<List<Integer>> verticalTraversal(TreeNode root) {
    // // This solution will work when the order level doesn't matter top to bottom
    // must be in this prob
    // //vertical ind level ind
    // TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
    // Queue<Tuple> q = new LinkedList<>();
    // q.offer(new Tuple(root, 0, 0));

    // while (!q.isEmpty()) {
    // Tuple tuple = q.poll();
    // TreeNode node = tuple.node;
    // int x = tuple.vertical;
    // int y = tuple.level;

    // if (map.get(x) == null) {
    // // putifabsent we can use
    // map.put(x, new PriorityQueue<>());
    // }

    // map.get(x).offer(node.val);

    // if (node.left != null) {
    // q.offer(new Tuple(node.left, x - 1, y + 1));
    // }
    // if (node.right != null) {
    // q.offer(new Tuple(node.right, x + 1, y + 1));
    // }
    // }

    // List<List<Integer>> lists = new ArrayList<>();
    // System.out.println(map);
    // for (PriorityQueue<Integer> pq : map.values()) {
    // List<Integer> list = new ArrayList<>();
    // while (!pq.isEmpty()) {
    // System.out.println(pq.peek());
    // list.add(pq.poll());
    // }
    // lists.add(list);
    // }
    // return lists;
    // }

    public static void main(String[] args) {

    }
}