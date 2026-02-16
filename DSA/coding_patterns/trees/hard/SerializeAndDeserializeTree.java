package coding_patterns.trees.hard;

import java.util.LinkedList;
import java.util.Queue;

import coding_patterns.trees.basic.TreeNode;

public class SerializeAndDeserializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String values[] = data.split("\\s+");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // dry run remaining
    }
}
