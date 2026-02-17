
// https://www.naukri.com/code360/problems/floor-from-bst_920457/
package coding_patterns.binary_search_tree;

import coding_patterns.trees.basic.TreeNode;

public class FindFloorInBST {
    public int findFloor(TreeNode root, int val) {
        int floor = -1;
        while (root != null) {
            if (root.val == val)
                return root.val;

            if (root.val > val) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
