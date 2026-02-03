// https://takeuforward.org/plus/dsa/problems/pre,-post,-inorder-in-one-traversal

package coding_patterns.trees.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class PreInPostOrderTraversal {

    // T-O(3*N)
    // S-O(4N) // stack

    public List<Integer>[] postorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        if (root == null) {
            return new List[] {};
        }

        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair temp = stack.pop();
            if (temp.num == 1) {
                preOrder.add(temp.node.val);
                temp.num++;
                stack.push(temp);
                if (temp.node.left != null) {
                    stack.push(new Pair(temp.node.left, 1));
                }

            } else if (temp.num == 2) {
                inOrder.add(temp.node.val);
                temp.num++;
                stack.push(temp);
                if (temp.node.right != null) {
                    stack.push(new Pair(temp.node.right, 1));
                }
            } else {
                postOrder.add(temp.node.val);
            }
        }

        return new List[] { preOrder, inOrder, postOrder };
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode one = new TreeNode(1, null, null);
        one.left = two;
        one.right = three;
        List<Integer>[] arr = new PreInPostOrderTraversal().postorderTraversal(one);
        System.out.println(arr[0] + "   " + arr[1] + "   " + arr[2]);
    }
}
